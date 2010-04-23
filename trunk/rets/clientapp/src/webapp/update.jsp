<%-- $Header: /usr/local/cvsroot/rets/clientapp/src/webapp/update.jsp,v 1.3 2005/04/08 13:35:47 ekovach Exp $ 
--%>
<%@ page language='java' contentType='text/html' %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="org.realtor.rets.client.update.*" %>
<%@ page import="org.realtor.rets.retsapi.*" %>
<%@ page import="org.realtor.rets.util.*" %>
<%@ page import="org.realtor.rets.util.RETSCompactHandler" %>
<%@ page import="org.realtor.rets.client.update.MetadataFieldList" %>
<%@ page import="javax.xml.parsers.*" %>
<%@ page import="org.xml.sax.InputSource" %>

<jsp:useBean id="parser" scope="page" class="org.realtor.rets.util.CompactParser" />
<jsp:useBean id="conn" scope="session" class="org.realtor.rets.retsapi.RETSConnection" />
<jsp:useBean id="trans" class="org.realtor.rets.retsapi.RETSSearchTransaction" />
<jsp:useBean id="metaTrans" scope="page" class="org.realtor.rets.retsapi.RETSGetMetadataTransaction"/>

<%
String id = request.getParameter("id");
String searchClass = request.getParameter("searchClass");

RETSGetMetadataTransaction metaData = new RETSGetMetadataTransaction();
metaData.setType("METADATA-RESOURCE");
metaData.setId("*");
metaData.setFormat("STANDARD-XML");
conn.execute(metaData);
//String status = metaData.getResponseStatus();

MetadataFieldList mdl = new MetadataFieldList(metaData.getResponse(), "Property", searchClass);
String systemName = mdl.getSystemName("ListingID");

Vector changeFields = mdl.getChangeFields();
RETSSearchPropertyTransaction rspt = new RETSSearchPropertyTransaction();
rspt.setSearchClass(searchClass);
rspt.setResource("Property");
rspt.setSearchStandardNames("0");
rspt.setSearchFormat("COMPACT");
rspt.setSearchQueryType("DMQL2");
String query = "(" + systemName + "=" + id + ")";
rspt.setSearchQuery(query);
StringBuffer sb = new StringBuffer();
Iterator iterator = changeFields.iterator();
boolean isFirst = true;
while (iterator.hasNext()) {
	if (!isFirst) {
		sb.append(",");
	}
	sb.append(iterator.next());
	isFirst = false;
}
rspt.setSearchSelect(sb.toString());
conn.execute(rspt);
parser = new CompactParser(rspt.getResponse());
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="main.css" />
</head>
<body>
<h1>Updating <%=request.getParameter("searchClass")%></h1>
<%
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
<form action="updateAction.jsp" method="POST">
<table border="0" cellpadding="3">
<tr>
<td colspan="2" align="right">
  <input type="submit" value="Update">
  <input type="reset">
 </td>
 </tr>
<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
<input type="hidden" name="resource" value="Property">
<%
while (parser.hasMoreColumns()) {
   String colName = parser.nextColumn();
   String colValue = parser.getData(colName);
%>
  <tr>
    <th align="right">
      <%= colName %>
     </th>
     <td>
       <input type="text" size="25" name="<%=colName%>" value="<%= colValue %>">
     </td>
   </tr>
<%
} // end while
%>
<tr>
<td colspan="2" align="right">
  <input type="submit" value="Update">
  <input type="reset">
 </td>
 </tr>
</table>

</form>
</body>
</html>