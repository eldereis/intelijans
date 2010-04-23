<%-- $Header: /usr/local/cvsroot/rets/clientapp/src/webapp/add.jsp,v 1.5 2005/03/31 21:30:17 ekovach Exp $ 
--%>
<%@ page language='java' contentType='text/html' %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="org.realtor.rets.client.update.*" %>
<%@ page import="org.realtor.rets.retsapi.*" %>
<%@ page import="org.realtor.rets.util.XMLUtils" %>
<%@ page import="org.realtor.rets.util.RETSCompactHandler" %>
<%@ page import="javax.xml.parsers.*" %>
<%@ page import="org.xml.sax.InputSource" %>

<jsp:useBean id="conn" scope="session" class="org.realtor.rets.retsapi.RETSConnection" />

<%
RETSGetMetadataTransaction metaData = new RETSGetMetadataTransaction();

metaData.setType("METADATA-SYSTEM");
metaData.setId("*");
metaData.setFormat("STANDARD-XML");
conn.execute(metaData);
String status = metaData.getResponseStatus();
 
%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="main.css" />
</head>
<body>
<blockquote>
	<img src="images/add_property.gif">
	<br>
<%
if ( !"0".equals(status))
 {
 	out.println("<h2>Add Failed</h2>");
 	 Map m  = metaData.getResponseMap();
     long transTime = conn.getLastTransactionTime();
	 double sec = (double) transTime/1000.0;
	 out.print("Transaction time "+sec+"  Seconds");
 %>
 	<br>
 	  <textarea rows="25" cols="80" name="textarea" style="background-color: #E2E2C5;">
<%
Iterator it = m.keySet().iterator();

while (it.hasNext()) {
	String key=(String)it.next();
	out.println( key+"=["+m.get(key)+"]");
}
%>
</textarea>
 <%
 }
 else
 {
    
 
MetadataFieldList fieldList = new MetadataFieldList(metaData.getResponse(),"Property","ResidentialProperty");
Vector fields = fieldList.getAddFields();

	if ( session.getAttribute("errors") != null ) {
		out.println("The data submitted failed validation for the following reasons<br>");
		out.println("<ol>");
		List errors = (List) session.getAttribute("errors");
		for ( int i=0; i < errors.size(); i++ ) {
			out.print("<li>");
			out.print(errors.get(i));
			out.println("</li>");
		}
		out.println("</ol>");
		session.removeAttribute("errors");
	}
%>
<h1>Add a <%=request.getParameter("resource")%></h1>
<table>
<form action="addAction.jsp" method="POST">
<input type="hidden" name="resource" value="<%=request.getParameter("resource")%>">
<tr>
  <td align="right" colspan="2">
	<input type="submit" value="Add">
  	 <input type="reset" value="Reset">
  </td>
 </tr>
<%
	for ( int i=0; i < fields.size(); i++) {
		String fieldName = (String) fields.get(i);
%>
		<tr>
			<th align="right"><%=fieldName%> </th>
			<td><input type=text name="<%=fieldName%>" size="25"></td>
		</tr>
<%
	} // end for 
%>
<tr>
  <td align="right" colspan="2">
	<input type="submit" value="Add">
  	 <input type="reset" value="Reset">
  </td>
 </tr>
 </form>
 </table>
<%
 } // end else !"0".equals(status))
 %>
 </blockquote>
</body>
</html>