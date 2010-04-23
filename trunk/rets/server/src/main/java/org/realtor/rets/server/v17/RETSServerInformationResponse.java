//$Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v17/RETSServerInformationResponse.java,v 1.6 2005/04/01 22:31:17 ekovach Exp $
package org.realtor.rets.server.v17;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.realtor.rets.server.RETSResponse;

/**
 *        Generate the Server Information response;
 *
 *        @author        ekovach
 *        @version 1.0
 */
public class RETSServerInformationResponse extends RETSResponse {

    /**
        A HashMap of resources to a String array of classes.
     */
    private static HashMap resourceClassMap = new HashMap();

    static {
        resourceClassMap.put("Property", new String [] {"ResidentialProperty", "RentalHomes", "LotsAndLand"});
        resourceClassMap.put("Agent", new String [] {"Agent"});
        resourceClassMap.put("Office", new String [] {"Office"});
    }

	/**
	 	The ISO 8601 DateFormat used to return dates.
    */
	private static final DateFormat DATEFORMAT_ISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss z");

	private String resource;

	private String [] classList;

	private boolean useSystemNames;

	public RETSServerInformationResponse(Map m) {
		super(m);
	}

	/**
	    Build the Server Information response.
	 */
	protected void buildResponse() {
        String [] resourceList = (String[]) requestMap.get("Resource");
        resource = null;
        if ((resourceList != null) && (resourceList.length > 0)) {
        	resource = resourceList[0];
        }
        classList = (String[]) requestMap.get("Class");
        if ((classList == null) || (classList.length < 1)) {
            if (resource == null || (resource.length() == 0)) {
                classList = new String [] {null};
            }
            else {
                classList = (String []) resourceClassMap.get(resource);
            }
        }
//        else if (resource != null) {
//            // verify that the specified class is available for the resource
//            String clazz = classList[0];
//            String [] classes = resourceClassMap(resource);
//        }


        // determine if we're using standard or system names
        useSystemNames = false;
        String [] standardNames = (String[]) requestMap.get("StandardNames");
        if ((standardNames != null) && (standardNames.length > 0)) {
        	useSystemNames = standardNames[0].equals("0");
        }

        String serverInformationXml = getServerInformationXml();
       	appendResponse("<RETS ReplyCode=\"" + getReplyCode() + "\" ReplyText=\"" + getReplyText() + "\">\n");
       	if (getReplyCode() == REPLY_CODE_SUCCESS) {
       			appendResponse("<ServerInformation>\n");
       			appendResponse(serverInformationXml);
       			appendResponse("</ServerInformation>");
       	}
        appendResponse("\n</RETS>");
        System.err.println(response);
	}

	/**
	    Get the ServerInformationParameter XML.  Also sets the internal reply code
	    if there's an error.
	 */
	private String getServerInformationXml() {
	    if (resource == null) {
	        setReplyCode(REPLY_CODE_SERVERINFORESPONSE_NOT_SUPPORTED);
	        return "";
	    }
	    else {
		    StringBuffer sb = new StringBuffer();

		    for (int i = 0; i < classList.length; i++) {
		        String clazz = classList[i];
		        cat.debug("Getting server information for resource [" + resource + "] class [" + clazz + "]");
		        if ((resource == null) && (clazz == null)) {
					sb.append(getParameterString("CurrentTimeStamp", clazz));
		        }
		        else {
		            // get the values for the resource/class pair
		            sb.append(getParameterString("MinimumLimit", clazz));
		            sb.append(getParameterString("ReplicationSupport", clazz));
		        }
		    }
			return sb.toString();
	    }
	}

	/**
	    Get the <Parameter> String for the named item.
	    @param name
	    @return The <Parameter> String for the named item.
	 */
	private String getParameterString(String parameterName, String clazz) {
		StringBuffer sb = new StringBuffer();
		try {
			// invoke the get<name> method and get the return value
			Method m = RETSServerInformationResponse.class.getMethod("get" + parameterName, new Class[] {String.class, String.class});
			Object value = (String) m.invoke(this, new Object [] {resource, clazz});

			sb.append("<Parameter name=\"");
			sb.append(parameterName);
			sb.append("\"");
			if (this.resource != null) {
				sb.append(" resource=\"");
				sb.append(this.resource);
				sb.append("\"");
			}
			if (clazz != null) {
				sb.append(" class=\"");
				sb.append(clazz);
				sb.append("\"");
			}
			sb.append(">");
			sb.append(value);
			sb.append("</Parameter>\n");
		}
		catch (InvocationTargetException e) {
			setReplyCode(REPLY_CODE_SERVERINFORESPONSE_NOT_SUPPORTED);
			setReplyText(getReplyText() + " (" + e.getCause().getMessage() + ")");
		}
		catch (Exception e) {
			setReplyCode(REPLY_CODE_SERVERINFORESPONSE_MISC_ERROR);
			cat.error(e);
		}
		return sb.toString();
	}

	/**
	 	Get the current time stamp for the resource and class.
	 	@return The current time stamp for the resource and class.
    */
	public String getCurrentTimeStamp(String resource, String clazz) {
		return DATEFORMAT_ISO8601.format(new Date());
	}

	/**
	 	Get the minumum limit for the resource and class.
	 	@return The minumum limit for the resource and class.
	 	@exception Exception Thrown if the minimum limit cannot be determined.
	 */
	public String getMinimumLimit(String resource, String clazz) throws Exception {
		return "NONE";
	}

	/**
	 	Get the replication support for the resource and class.
	 	@return The replication support for the resource and class.
	 	@exception Exception Thrown if the replication support information cannot be determined.
	 */
	public String getReplicationSupport(String resource, String clazz) throws Exception {
		return "N";
	}
}
