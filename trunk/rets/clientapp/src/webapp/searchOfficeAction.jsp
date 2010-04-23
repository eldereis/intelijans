<%--
$Header: /usr/local/cvsroot/rets/clientapp/src/webapp/searchOfficeAction.jsp,v 1.4 2005/04/26 18:37:13 ekovach Exp $
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
<jsp:useBean id="trans" class="org.realtor.rets.retsapi.RETSSearchOfficeTransaction" />
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
<title>RETS searchOffice Response</title>
</head>
<body>
<blockquote>
    <br>
    <img src="images/office.gif">
</blockquote>
<table width="800" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="57" height="691"></td>
    <td width="743" valign="top"> <br>
      <img src="images/officesearchresponcecopy.gif"> <br>
      <br>

            <h2>
<%

String status = trans.getResponseStatus();

if ( "0".equals(status))
{
    out.println("searchOffice Successful");

}
else
{
    out.println("searchOffice Error: " + status);
}
%>
      </h2>
<%
long transTime = conn.getLastTransactionTime();
double sec = (double) transTime/1000.0;
out.print("Transaction time "+sec+"  Seconds");
%><br/>
<br><font size="3"><b>
Response:</b></font><br>
<hr>
<%
 Map m = trans.getResponseMap();
 String bodyStr = (String) m.get("body");
 String searchClass = trans.getSearchClass();
 String fmt = trans.getSearchFormat();

 if ("STANDARD-XML".equalsIgnoreCase(fmt))
 {
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
//       System.out.println("Parser class is : "+p.getClass().getName());

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
      <textarea rows="25" cols="68"  name="textarea" style="background-color: #E2E2C5;">
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
