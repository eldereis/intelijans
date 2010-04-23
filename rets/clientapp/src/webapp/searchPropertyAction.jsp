<%--
$Header: /usr/local/cvsroot/rets/clientapp/src/webapp/searchPropertyAction.jsp,v 1.7 2005/04/26 18:37:13 ekovach Exp $
--%>
<%@ page language='java' contentType='text/html' %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="org.realtor.rets.retsapi.*" %>
<%@ page import="org.realtor.rets.util.XMLUtils" %>
<%@ page import="org.realtor.rets.util.RETSCompactHandler" %>
<%@ page import="org.realtor.rets.util.ResourceLocator" %>
<%@ page import="javax.xml.parsers.*" %>
<%@ page import="org.xml.sax.InputSource" %>

<jsp:useBean id="conn" scope="session" class="org.realtor.rets.retsapi.RETSConnection" />
<jsp:useBean id="trans" class="org.realtor.rets.retsapi.RETSSearchPropertyTransaction" />

<jsp:setProperty name="trans" property="*" />

<%
//if (trans.getVersion()!=null){
//conn.setRequestHeaderField("RETS-Version",trans.getVersion());
//}
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
            <h2><%

String status = trans.getResponseStatus();

 if ( "0".equals(status))
 {
     out.println("searchProperty Successful");

 }
 else
 {
     out.println("searchProperty Error: " + status);
 }
 %></h2>
 <%
long transTime = conn.getLastTransactionTime();
double sec = (double) transTime/1000.0;
out.print("Transaction time "+sec+"  Seconds");
%>
 <br><br>     <font size="3"><b>Response:</b></font><br>


<table border="1">
<%
 Map m = trans.getResponseMap();
 String bodyStr = (String) m.get("body");
 String fmt = trans.getSearchFormat();
 String searchClass = trans.getSearchClass();

 if ("STANDARD-XML".equalsIgnoreCase(fmt)) {
    String resourceLocator = ResourceLocator.locate(searchClass + ".xsl");
    out.print(XMLUtils.transformXmlToString(bodyStr,resourceLocator,null));
 }
 else {
    RETSCompactHandler h = new RETSCompactHandler();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    h.setOutputStream(baos);
    try {
       SAXParserFactory spf = SAXParserFactory.newInstance();
       SAXParser p = spf.newSAXParser();

       ByteArrayInputStream bais = new ByteArrayInputStream(bodyStr.getBytes());
       InputSource is = new InputSource(bais);
       p.parse(is,h);
       baos.flush();
       bais.close();
    }
    catch (Exception e){
      e.printStackTrace();
    }
 }
  %>
</table>
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
