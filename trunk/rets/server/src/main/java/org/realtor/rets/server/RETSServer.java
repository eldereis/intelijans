// $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/RETSServer.java,v 1.39 2005/04/10 19:20:37 ekovach Exp $
package org.realtor.rets.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Category;
import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.dataobjects.Agent;
import org.realtor.rets.server.v10.RETSGetObjectResponse;
import org.realtor.rets.server.v10.RETSLoginResponse;
import org.realtor.rets.server.v17.RETSChangePasswordResponse;
import org.realtor.rets.server.v17.RETSLogoutResponse;
import org.realtor.rets.util.DigestUtil;
import org.realtor.rets.util.RETSConfigurator;
import org.realtor.rets.util.RETSReplyCodes;

//import sun.misc.BASE64Decoder;
import org.apache.commons.codec.binary.Base64;

/**
 * RETSServer.java
 *
 * The RETSServer is implemented as a java servlet.  RETS Transaction receives
 * RETS transaction requests, parsses header information and the transaction is passed through
 * to the RETSResponse object that corresponds to the requested transaction.
 * Created on November 16, 2001, 8:32 AM
 *
 * @author  $Author: ekovach $
 * @version $Revision: 1.39 $
 */
public class RETSServer extends HttpServlet {

//    private static String retsVersion = "";
    private static final String[] requiredClientHeaderFields = {
        "Accept", "User-Agent"
    };
    private static final String[] optionalClientHeaderFields = {
        "Authorization", "Cookie", "RETS-Request-ID"
    };

    /** boundry string for multi-part MIME type*/
    private static final String BOUNDARYSTRING = "AVANTIA-XYZZY";

    /** log4j Category object */
    static Category cat = Category.getInstance(RETSServer.class);

    /** Initializes the servlet.
     *  @param config
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // initialize log4j
        RETSConfigurator.configure();
    }

    /** Destroys the servlet.     */
    public void destroy() {
        //do nothing
    }

    /** Adds required Response Header Fields
     *  @param  request         servlet request
     *  @param  response        servlet response
     *  @param  responseType    String containing Content-Type
     */
    private void addRequiredResponseHeaderFields(HttpServletRequest request,
        HttpServletResponse response, String responseType) {

    	String retsVersion = (String)request.getSession().getAttribute("RetsVersion");

        // Most of these fields are constants
        response.setHeader("Cache-Control", "private");
        response.setHeader("Content-Type", responseType);
        response.setHeader("RETS-Version",  retsVersion);
        response.setHeader("Server", "RETS-REFERENCE-IMPLEMENTATION/1.7");

        // add RETS-Server header if numeric version is >= 1.7
        if (retsVersion != null) {
	        int slashIndex = retsVersion.indexOf('/');
	        if (slashIndex > 0) {
	        	try {
	        		double retsNumericVersion = Double.parseDouble(retsVersion.substring(slashIndex + 1));
	        		if (retsNumericVersion >= 1.7) {
	        			response.setHeader("RETS-Server", "AvantiaReferenceImpl/1.2");
	        		}
	        	}
	        	catch (NumberFormatException e) {
	        		cat.error("Unable to read numeric RETS version from [" + retsVersion + "]");
	        	}
	        }
        }
    }

    /**
     *  If a transaction is requested and the user is not logged in, send
     *  request for login is called.
     *  @param  request servlet request
     *  @param  response servlet response
     */
    protected void sendRequestForLogin(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, java.io.IOException {
        String nonce = DigestUtil.Digest(System.currentTimeMillis() + ":" +
                request.getServerName() + ":avantia");
        String qop = "auth";
        // qop = null;  // null disables 'qop'

        String opaque = "5ccdef346870ab04ddfe0412367fccba";
        response.setStatus(401);
        addRequiredResponseHeaderFields(request, response,
            "text/xml; charset=utf-8");

        //digest challenge for current and 1.5 RFC
        if (qop == null) {
            response.setHeader("WWW-Authenticate",
                "Digest realm=\"" + request.getServerName() + "\",nonce=\"" +
                nonce + "\",opaque=\"" + opaque + "\"");
        } else {
            response.setHeader("WWW-Authenticate",
                "Digest realm=\"" + request.getServerName() + "\",nonce=\"" +
                nonce + "\",opaque=\"" + opaque + "\",qop=\"" + qop + "\"");
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     * @throws PersistenceException
     */
    protected void processRequest(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        Enumeration hNames = request.getHeaderNames();

        // get users session
        HttpSession session = request.getSession();

        /*
        // get servlet context
        ServletContext context = getServletConfig().getServletContext();

        // setup the real path for future use. This is where we get our properties files
        // JETTY
        //String propertiesPath = context.getRealPath("/rets/");
        // non JETTY
        String propertiesPath = context.getRealPath("/");
        cat.debug("PropertiesPath: " + propertiesPath);
        System.setProperty("RETS_PROPERTIES_DIRECTORY", propertiesPath + "/");
        */

        Boolean loggedIn = (Boolean) session.getAttribute("LoggedIn");

        String uri = request.getRequestURI();

        String retsVersion = request.getHeader("RETS-Version");

        if (retsVersion != null) {
            cat.debug("client RETS version is " + retsVersion);
//        } else {
//            retsVersion = "RETS/1.0";
        }

        if (!validRETSVersion(retsVersion)) {
            //send back an error
            cat.error("rets version error");
            response.setStatus(200);
            response.setContentType("text/plain");

            RETSServerResponse resp = new RETSServerResponse();
            resp.setReplyCode(RETSResponse.REPLY_CODE_MISCELLANEOUS_LOGIN_ERROR);
            resp.setReplyText("Missing or Invalid RETS Version");

            java.io.PrintWriter out = response.getWriter();
            out.print(resp.getResponse());
            out.flush();
            out.close();
        } else {
            session.setAttribute("RetsVersion", retsVersion);
        }

        String action = uri.substring(uri.lastIndexOf('/') + 1);
        cat.info("Action :" + action);

        response.setStatus(200);
        response.setContentType("text/xml; charset=utf-8");

        while (hNames.hasMoreElements()) {
            String name = (String) hNames.nextElement();
            cat.info("Header: " + name + ": " + request.getHeader(name));

            //System.out.println("\tHeader: "+name+": "+request.getHeader(name));
        }

        Enumeration paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {
            String name = (String) paramNames.nextElement();
            cat.info("Param: " + name + ": " + request.getParameter(name));
            System.out.println("\tParam : " + name + ": " +
                request.getParameter(name));
        }

        if (action.equalsIgnoreCase("login")) {
            cat.debug("Attempting to login");
			RETSServerResponse resp = new RETSServerResponse();
            try {
                session.setAttribute("LoggedIn",
                    new Boolean(sendRETSLoginResponse(request, response)));


            } catch (ServletException e) {

                resp.setReplyCode(20036);
				resp.setReplyText("The server is temporarily disabled, you cannot login now.");
				cat.error(e);

            } catch (IOException e) {
                resp.setReplyCode(20036);
				resp.setReplyText("The server is temporarily disabled, you cannot login now");
				cat.error(e);

            } catch (PersistenceException e) {
                resp.setReplyCode(20036);
				resp.setReplyText("There was a problem with the database.  Please contact administrator.");
				cat.error(e);
            }
            	java.io.PrintWriter out = response.getWriter();
			    out.print(resp.getResponse());
			    out.flush();
                out.close();

        } else if (loggedIn.booleanValue()) {
            System.out.println("starting process rets request");
            RETSServerResponse resp = new RETSServerResponse();
            try {
            	processRETSRequest(action, request, response);
            } catch (PersistenceException e) {

                resp.setReplyCode(20036);
				resp.setReplyText("There was a problem retrieving your user data.");
				cat.error(e);
            }
            java.io.PrintWriter out = response.getWriter();
			out.print(resp.getResponse());
			out.flush();
            out.close();
        } else {
            sendRequestForLogin(request, response);
        }
    }

    /**
     *  Gets the loginResponse and sends it thru the response object
     *  @param request servlet request
     *  @param response servlet response
     *  @return true on success
     * @throws PersistenceException
     */
    protected boolean sendRETSLoginResponse(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, java.io.IOException, PersistenceException {
        // This needs to change to the authorzation header decode
        String auth = request.getHeader("Authorization");
        String method = request.getMethod();

        String username = null;
        Agent user = null;

        boolean isValid = false;

        response.addCookie(new Cookie("RETS-Session-ID", "0"));

        if (auth == null) {
            //send auth challenge
            cat.debug("sending request for login response");
            sendRequestForLogin(request, response);
        } else {
            String type = auth.substring(0, auth.indexOf(' '));
            cat.debug("Type is {" + type + "}");

            if ("Basic".equalsIgnoreCase(type)) {
                cat.debug("in basic auth");
                String code = auth.substring(auth.lastIndexOf(' ') + 1);
                //BASE64Decoder b64 = new BASE64Decoder();
                //Base64 b64 = new Base64();
		String decode = new String(Base64.decodeBase64(code.getBytes()));
                //String decode = new String(b64.decodeBuffer(code));

                //String decode = new String(Base64.decode(code.getBytes()));
                cat.debug("Basic Authentication code is {" + code +
                    "}  decode is {" + decode + "}");

                //username is everything before the ':'
                username = decode.substring(0, decode.indexOf(':'));
                user = RETSServerApp.getAgentsDAO().findByUsername(username);
                //RetsAgentDAO user2 = new RetsAgentDAO(username);

                if (user != null) {
                    String serverPassword = user.getPassword();

                    String clientPassword = decode.substring(decode.indexOf(':')+1);

                    isValid = (clientPassword.equals(serverPassword));
                }

            } else if ("Digest".equalsIgnoreCase(type)) {
                cat.debug("in digest auth");
                Map m = DigestUtil.parseAuthenticate(auth.substring(6));
                username = (String) m.get("username");

                String realm = (String) m.get("realm");
                String nonce = (String) m.get("nonce");
                String uri = (String) m.get("uri");
                String opaque = (String) m.get("opaque");
                String nc = (String) m.get("nc");
                String cnonce = (String) m.get("cnonce");
                String qop = (String) m.get("qop");
                String clientResponse = (String) m.get("response");

               	user = RETSServerApp.getAgentsDAO().findByUsername(username);

                //RetsAgentDAO user2 = new RetsAgentDAO(username);

                if(user == null) {
                    sendRequestForLogin(request, response);
                }else{

                    String password = user.getPassword();

                    if (cat.isDebugEnabled()) {
                        cat.debug("password:"+password);
                    }

                    //client response
                    String digestResponse = DigestUtil.Digest(username, realm,
                            password, method, uri, nonce, nc, cnonce, qop);

//                  cat.debug("server digest param:  username="+username+", realm="+realm+
//                  ", password="+password+", method="+method+
//                  ", uri="+uri+", nonce="+nonce+", nc="+nc+", cnonce="+cnonce+", qop="+qop+";");

                    cat.debug("digestResponse is " +
                            digestResponse + " clientResponse is " +
                            clientResponse);

                    // validate response
                    if ((digestResponse == null) ||
                            (!digestResponse.equals(clientResponse))) {
                        cat.debug("returning false, digestResponse is " +
                                digestResponse + " clientResponse is " +
                                clientResponse);
                        sendRequestForLogin(request, response);
                    } else {
                        isValid = true;
                    }
                }
            } else {
                cat.error("unknown auth");
            }

            if(isValid) {

                cat.debug("user.getID()="+user.getID());

                if (user.getID() != null) {
                    HttpSession session = request.getSession();
                    int timeout = session.getMaxInactiveInterval();

                    RETSLoginResponse loginResponse = (RETSLoginResponse)RETSResponseFactory.getResponse("LOGIN",
                            (String)session.getAttribute("RetsVersion"),
                            request.getParameterMap()); //new RETSLoginResponse(user, timeout);
                    loginResponse.setAgent(user);
                    loginResponse.setTimeout(timeout);

                    cat.debug("User Name :" + user.getMemberName());
                    addRequiredResponseHeaderFields(request, response,
                    "text/xml; charset=utf-8");

                    java.io.PrintWriter out = response.getWriter();
                    out.print(loginResponse.getResponse());
                    out.close();

                    if (loginResponse.getStatus().equalsIgnoreCase("success")) {
                        session.setAttribute("RETSUser", user);

                        isValid = true;
                    }
                    else {
                        cat.debug("login response status:"+loginResponse.getStatus());
                    }
                } else {
                    cat.error("User id is null!");
                    sendRequestForLogin(request, response);
                }
            }
        }

        cat.error("Leaving SendRetsLoginResponse");
        return isValid;
    }

    /** Process RETS Transaction Requests (other than login).
     *
     * @param action  transaction type (getobject, search, getMetadata, etc)
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRETSRequest(String action,
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, java.io.IOException, PersistenceException {
        RETSResponse resp = null;
        Map requestMap = request.getParameterMap();
        Iterator it = requestMap.keySet().iterator();
        cat.debug("Server Request Parameter Size:" + requestMap.size());

        // dump requestMap
        if (cat.isDebugEnabled()) {
            while (it.hasNext()) {
                String key = (String) it.next();
                String[] value = (String[]) requestMap.get(key);
                cat.debug("Server Request Parameter:" + key + "=[" + value[0] + "]");
            }
        }

        if (action.equalsIgnoreCase("getObject")) {
            ServletContext context = this.getServletConfig().getServletContext();
            ServletOutputStream os = response.getOutputStream();

            String resource = ((String[])requestMap.get("Resource"))[0];
            String type = ((String[])requestMap.get("Type"))[0];

            resp = RETSGetObjectResponseFactory.getInstance(
                    request.getParameterMap(),
                    (String)request.getSession().getAttribute("RetsVersion"),
                    request.getHeader("Accept")
            );

            ((RETSGetObjectResponse) resp).setContext(context);
            resp.buildResponse();

            RETSGetObjectResponse.RETSObjectResponseDescriptor [] rord =
                (RETSGetObjectResponse.RETSObjectResponseDescriptor [])
                resp.responseMap.get("responseDescriptorList");

            boolean isMultipart = ((RETSGetObjectResponse) resp).isMultipartResponse();
            cat.debug("isMultipart: "+ isMultipart);

            // build http
            if (isMultipart) {
                addRequiredResponseHeaderFields(request, response,
                        "multipart/parallel; boundary=" + BOUNDARYSTRING);
            } else {
                addRequiredResponseHeaderFields(request, response,
                        context.getMimeType(rord[0].getFilename()));
            }

            response.addHeader("MIME-Version", "1.0");

            try {
                cat.debug("Server ResponseMap Size:" + resp.responseMap.size());

                for (int i = 0; i < rord.length; i++) {
                	if (isMultipart) {
                        os.println("\n--" + BOUNDARYSTRING);
                	}

                    if (rord[i].isSuccessful()) {
                        cat.debug("Reading data from file " + rord[i].getFilename());
                        if (isMultipart) {
                            os.println("Content-ID: " + rord[i].getContentId());
                            os.println("Content-Type: " + context.getMimeType(rord[i].getFilename()));
                            os.println("Description: " + rord[i].getDescription());
                            os.println("Object-ID: " + i);
                            os.println();
                        }
                        else {
                            response.setHeader("Content-ID", rord[i].getContentId());
                            response.setHeader("Content-Type", context.getMimeType(rord[i].getFilename()));
                            response.setHeader("Description", rord[i].getDescription());
                        }

                        InputStream is = new FileInputStream(rord[i].getFilename());
                        cat.debug("getObject open successful");
                        // Stream file back to client
                        byte[] buffer = new byte[8192];
                        int size;
                        while ((size = is.read(buffer)) != -1) {
                            os.write(buffer, 0, size);
                        }
                        is.close();
                        cat.debug("getObject data file read successful");
                    } else if (isMultipart) {
                    	cat.debug("Writing multipart error");
                        os.println("Content-ID: " + rord[i].getContentId());
                        os.println("Content-Type: text/xml");
                        os.println("Description: " + rord[i].getDescription());
                        os.println("Object-ID: " + i);
                        os.println();
                        printRetsReplyCode(os, rord[i].getErrorCode(), rord[i].getDescription());
                    } else {
                    	cat.debug("Writing error response");
                    	response.addHeader("Content-Type", "text/xml");
                        response.addHeader("Content-ID", rord[i].getContentId());
                        response.addHeader("Object-ID", "0");
                        response.addHeader("Description: ", rord[i].getDescription());
                    	printRetsReplyCode(os, rord[i].getErrorCode(), rord[i].getDescription());
                    }

                } // end for

                if (isMultipart) {
                    os.println("--" + BOUNDARYSTRING + "--");
                }

            } catch (Exception e) {
                printRetsReplyCode(os, 20413);
                cat.error("exception during Getobject", e);
            }
            os.flush();
        } else if (action.equalsIgnoreCase("changePassword")) {
        	Agent user = (Agent) request.getSession().getAttribute("RETSUser");
            resp = new RETSChangePasswordResponse(requestMap, user);
            resp.buildResponse();

        	ServletOutputStream os = response.getOutputStream();
            printRetsReplyCode(os, resp.getReplyCode(), resp.getReplyText());
        } else if (action.equalsIgnoreCase("logout")) {
        	boolean isLoggedIn = ((Boolean) request.getSession().getAttribute("LoggedIn")).booleanValue();
            resp = new RETSLogoutResponse(request.getParameterMap(), isLoggedIn);
            java.io.PrintWriter out = response.getWriter();
            out.print(resp.getResponse());
            out.flush();
            out.close();
        } else {
            String[] formatList = (String[]) requestMap.get("Format");
            String format = null;

            if (formatList != null) {
                format = formatList[0];
            }

            if ((format != null) && format.startsWith("COMPACT")) {
                addRequiredResponseHeaderFields(request, response,
                    "text/xml; charset=utf-8");
            } else {
                addRequiredResponseHeaderFields(request, response,
                    "text/xml; charset=utf-8");
            }

            if (action != null) {
                resp = RETSResponseFactory.getResponse(action,
                        (String)request.getSession().getAttribute("RetsVersion"),
                        request.getParameterMap());
            }

            if (action.equalsIgnoreCase("getMetadata")) {
                String[] metadataComponentList = (String[]) resp.responseMap.get(
                        "metadataComponent");

                if (metadataComponentList != null) {
                    response.addHeader("Content-ID", metadataComponentList[0]);
                }

                response.addHeader("MIME-Version", "1.0");
            }

            java.io.PrintWriter out = response.getWriter();
            out.print(resp.getResponse());
            out.flush();
            out.close();
        }
    }

    /**
        Print the RETS reply header to the specified ServletOutputStream.
        @param os
     */
    private void printRetsReplyHeader(ServletOutputStream os) throws IOException {
    	os.println("<?xml version=\"1.0\" standalone=\"no\"?>");
    	// TODO: specify the correct DTD for the RETS version
    	os.println("<!DOCTYPE RETS SYSTEM \"RETS-20021015.dtd\">");
    }

    /**
        Print the standard RETS reply code
        @param os
        @param code
     */
    private void printRetsReplyCode(ServletOutputStream os, int code) throws IOException {
    	printRetsReplyCode(os, code, RETSReplyCodes.get(code));
    }

   /**
	    Print the standard RETS reply code
	    @param os
	    @param code
	    @param description
	 */
	private void printRetsReplyCode(ServletOutputStream os, int code, String description) throws IOException {
		printRetsReplyHeader(os);
		os.print("<RETS ReplyCode=\"");
		os.print(code);
		os.print("\" ReplyText=\"");
		os.print(description);
		os.println("\"/>");
	}

    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, java.io.IOException {
        processRequest(request, response);
    }

    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, java.io.IOException {
        processRequest(request, response);
    }

    /** Returns a short description of the servlet.     */
    public String getServletInfo() {
        return "National Association of Realtors - RETS 1.0 Reference Implementation";
    }

    /** Validates RETS Version String.     */
    protected boolean validRETSVersion(String theRetsVersion) {
        return ((theRetsVersion != null) &&
        (theRetsVersion.equalsIgnoreCase("RETS/1.0") ||
         theRetsVersion.equalsIgnoreCase("RETS/1.5") ||
         theRetsVersion.equalsIgnoreCase("RETS/1.7")
		));
    }
}
