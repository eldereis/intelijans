<%--
$Header: /usr/local/cvsroot/rets/clientapp/src/webapp/searchAgentAction.jsp,v 1.5 2005/04/26 18:37:13 ekovach Exp $
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
<jsp:useBean id="trans" class="org.realtor.rets.retsapi.RETSSearchAgentTransaction" />
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
<title>RETS searchAgent Response</title>
</head>
<body>
<blockquote>
    <br>
    <img src="images/agent.gif">
</blockquote>
<table width="853" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="55" height="640"></td>
    <td width="798" valign="top"><b>

</b>

      </b>&nbsp;<img src="images/searchchangentresponcopy.gif"><br>
<br>
<h2>
<%

String status = trans.getResponseStatus();

if ( "0".equals(status))
{
    out.println("searchAgent Successful");

}
else
{
    out.println("searchAgent Error: " + status);
}
%>
</h2>
<br/>
<%
long transTime = conn.getLastTransactionTime();
double sec = (double) transTime/1000.0;
out.print("Transaction time "+sec+"  Seconds");
%>
<br/>
 <br><font size="3"><b>Response:</b></font><br>
 <hr>
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

      <br>
      <br>
      <br>
      <textarea rows="25" cols="67"  name="textarea" style="background-color: #E2E2C5;">
<%

Iterator it = m.keySet().iterator();

while (it.hasNext()) {
    String key=(String)it.next();
    out.println( key+"=["+m.get(key)+"]");
}
%>
</textarea>
      <br>
    </td>
  </tr>
</table>
</body>
</html>
