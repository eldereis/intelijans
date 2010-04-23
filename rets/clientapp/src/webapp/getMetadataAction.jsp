<%--
$Header: /usr/local/cvsroot/rets/clientapp/src/webapp/getMetadataAction.jsp,v 1.2 2005/03/25 14:55:38 ekovach Exp $
--%>
<%@ page language='java' contentType='text/html' %>
<%@ page import="java.util.*" %>
<%@ page import="org.realtor.rets.retsapi.*" %>

<jsp:useBean id="conn" scope="session" class="org.realtor.rets.retsapi.RETSConnection" />
<jsp:useBean id="trans" class="org.realtor.rets.retsapi.RETSGetMetadataTransaction" />
<jsp:setProperty name="trans" property="*" />
<%
conn.execute(trans);
%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="main.css" />
<title>RETS GetMetadata Response</title>
</head>
<body>
<blockquote>
	<br>
	<img src="images/viewmdata.gif">
</blockquote>
<table width="746" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="3" height="682"></td>
    <td width="743" valign="top"> 
      <blockquote> 
        <p><b><font color="#003300" size="2"><br>
          <img src="images/getmetaaction.gif"></font> 
          </b></p>
        
<h2><%

String status = trans.getResponseStatus();

if ( "0".equals(status))
{
    out.println("GetMetadata Successful");
    
}
else
{
    out.println("GetMetadata Error: " + status);
}


%></h2>
<%
long transTime = conn.getLastTransactionTime();
double sec = (double) transTime/1000.0;
out.print("Transaction time "+sec+"  Seconds");
%>
        <p><font size="3">
         <br/>
         <b>Response:</b></font>
        <hr>
          <textarea rows="25" cols="68" name="textarea" style="background-color: #E2E2C5;">
<%
Map m = trans.getResponseMap();
Iterator it = m.keySet().iterator();

while (it.hasNext()) {
	String key=(String)it.next();
	out.println( key+"=["+m.get(key)+"]");
}
%>
</textarea>
          <br>
        </p>
      </blockquote>
    </td>
  </tr>
</table>
</body>
</html>
