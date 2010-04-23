<%@ page language='java' %><%
%><%@ page import="java.io.*,
                 java.util.Collection,
                 java.util.Iterator,
                 javax.mail.internet.MimeBodyPart" %><%
%><%@ page import="java.util.List"%><%
%><%@ page import="org.realtor.rets.retsapi.*" %><%
%><jsp:useBean id="conn" scope="session" class="org.realtor.rets.retsapi.RETSConnection" /><%
%><jsp:useBean id="tx" scope="session" class="org.realtor.rets.retsapi.RETSGetObjectTransaction" /><%
%><jsp:setProperty name="tx" property="*" /><%
    String id = request.getParameter("ID");
    if ( true ) {
//    if ( id != null && id.indexOf(":*") > -1 ) {
%>
<html>
<head>
    <title>RETS Listing Images</title>
    <link rel="stylesheet" type="text/css" href="main.css" />
</head>
<body>
<%
    conn.execute(tx);

    MimeBodyPart part = null;
    Iterator iterator = tx.allReturnedObjects().iterator();

    int i = 0;
    while ( iterator.hasNext() ) {
        part = (MimeBodyPart) iterator.next();
        if (part.getContentType().startsWith("image/")) {
	        out.println("<img src=\"getObjectPartAction.jsp?index=" + (i++) + "\" />" );
	        out.println("<br>");
	        out.println(part.getContentID());
	        out.println("<br>");
	        out.println("<br>");
        }
        else {
        	out.println("<br><b>Error:</b>");
        	out.println("<br>");
        	out.println("<code>");
        	InputStream is = tx.getPartAsStream(i++);
        	StringBuffer sb = new StringBuffer();
        	while (true) {
        		int value = is.read();
        		if (value < 0) {
        			break;
        		}
        		sb.append((char) value);
        	}
        	out.println(sb.toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;"));
        	out.println("</code>");
	    }
    }
%>
</body>
</html>
<% } else {
        out.println("blahlbahblah");
//        InputStream inputStream = tx.
//
//        int count;
//        byte b[] = new byte[8192];
//
//        while ((count = inputStream.read(b)) != -1) {
//            outputStream.write(b, 0, count);
//        }
//        out.flush();
//        out.close();
//
    }
%>