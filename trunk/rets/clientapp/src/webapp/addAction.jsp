<%-- $Header: /usr/local/cvsroot/rets/clientapp/src/webapp/addAction.jsp,v 1.2 2005/03/31 21:30:17 ekovach Exp $ --%>
<%@ page language='java' contentType='text/html' %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="org.realtor.rets.client.update.*" %>
<%@ page import="org.realtor.rets.retsapi.*" %>
<%@ page import ="org.realtor.rets.util.*" %>
<%@ page import = "org.realtor.rets.validation.*" %>
<%@ page import="org.w3c.dom.*" %>

<jsp:useBean id="conn" scope="session" class="org.realtor.rets.retsapi.RETSConnection" />
<jsp:useBean id="trans" class="org.realtor.rets.retsapi.RETSUpdateTransaction" />

<%

RETSGetMetadataTransaction metaData = new RETSGetMetadataTransaction();

metaData.setType("METADATA-SYSTEM");
metaData.setId("*");
metaData.setFormat("STANDARD-XML");
metaData.setVersion(request.getParameter("version"));
conn.execute(metaData);

// we must copy out the request map since it's unmodifiable.
HashMap newTable = new HashMap();
newTable.putAll(request.getParameterMap());
// now remove hidden fields, which aren't names
newTable.remove("id");
newTable.remove("version");
newTable.remove("resource");
newTable.remove("ClassName");

RETSUpdateValidator validator = new RETSUpdateValidator(request.getParameter("resource"), "ResidentialProperty", "Add");
//System.out.println("XXXXXXXXXXXXXXXXXXXX "+metaData.getResponse());
validator.setMetaData(metaData.getResponse());
validator.setUserInfo((String) session.getAttribute("user-info"));
validator.setSymbolTable(newTable);
validator.validate();

if ( validator.hasErrors() ) {
	List errors = validator.getErrors();
	for (int i=0; i<errors.size(); i++) {
		System.out.println(errors.get(i));
	}
	session.setAttribute("errors",errors);
	response.sendRedirect(request.getHeader("referer"));
}


trans.setNewValues(request.getParameterMap());
trans.setResource(request.getParameter("resource"));
trans.setClassName("ResidentialProperty");
conn.execute(trans);

%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="main.css" />
<title>RETS searchProperty Response</title>
</head>
<body>
<blockquote>
	<br>
	<img src="images/property.gif">
</blockquote>
<table width="868" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="68" height="758"></td>
    <td width="800" valign="top"><br>

      <img src="images/searchpropertyresponcecopy.gif">
      <br>
      <br>
			<a href="technicalcomments.htm#SearchPropertySuccessful"><img src="images/techcomments.gif" width="218" height="50" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="businesscomments.htm#SearchPropertySuccessful"><img src="images/busicomment.gif" width="218" height="47" border="0"></a> 
      <br>
			<br>
			<br>
			<br>
			<h2>
<%
 
String status = trans.getResponseStatus();
 
 if ( "0".equals(status))
 {
     out.println("Update Successful");
     
 }
 else
 {
     out.println("Update Error: " + status);
 }
 %>
 </h2>
 <%
long transTime = conn.getLastTransactionTime();
double sec = (double) transTime/1000.0;
out.print("Transaction time "+sec+"  Seconds");
%>
 <br><br>     <font size="3"><b>Response:</b></font><br>
    
			
<% 
 Map m = trans.getResponseMap();
 String bodyStr = (String) m.get("body");
 String fmt ="COMPACT";
 

 
  %>
<br><br>
      <textarea rows="25" cols="80" name="textarea" style="background-color: #E2E2C5;">
<%
Iterator it = m.keySet().iterator();

while (it.hasNext()) {
	String key=(String)it.next();
	out.println( key+"=["+m.get(key)+"]");
}
%>
</textarea>
    </td>
  </tr>
</table>
</body>
</html>