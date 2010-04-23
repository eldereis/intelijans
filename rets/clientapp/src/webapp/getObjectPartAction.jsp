<%--
$Header: /usr/local/cvsroot/rets/clientapp/src/webapp/getObjectPartAction.jsp,v 1.3 2005/02/18 16:19:51 trawson Exp $
--%><%--
newlines must be surrounded so they are not written to the browser!
No trailing newline at the end of the file either!
Otherwise you get the following exception:
"org.apache.jasper.JasperException: getOutputStream() has already been called for this response"
--%><%@ page language='java' %><%
%><%@ page import="java.io.*,
                   javax.mail.internet.MimeBodyPart,
                   java.util.Collection" %><%
%><%@ page import="java.util.List"%><%
%><%@ page import="org.realtor.rets.retsapi.*" %><%
%><jsp:useBean id="tx" scope="session" class="org.realtor.rets.retsapi.RETSGetObjectTransaction" /><%
%><%

    InputStream inputStream = null;
    OutputStream outputStream = null;
    String index = request.getParameter("index");
    if ( index != null ) {
        int x = Integer.parseInt(index);

        MimeBodyPart part = tx.partAtIndex(x);

        inputStream = tx.getPartAsStream(x);
        outputStream = response.getOutputStream();
//        Object contentType =  tx.getResponseHeaderMap().get("Content-Type");

        response.setContentType(part.getContentType());

        int count;
        byte b[] = new byte[8192];

        while ((count = inputStream.read(b)) != -1) {
            outputStream.write(b, 0, count);
        }
        out.flush();
        out.close();
    } else {
        response.setContentType("text/html");
    }
%>