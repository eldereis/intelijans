<%--
$Header: /usr/local/cvsroot/rets/clientapp/src/webapp/logoutAction.jsp,v 1.1.1.1 2003/11/21 16:19:37 rsegelman Exp $
--%>
<%@ page language='java' contentType='text/html' %>
<%@ page import="java.util.*" %>
<%@ page import="org.realtor.rets.retsapi.*" %>

<jsp:useBean id="conn" scope="session" class="org.realtor.rets.retsapi.RETSConnection" />
<jsp:useBean id="trans" class="org.realtor.rets.retsapi.RETSLogoutTransaction" />
<jsp:setProperty name="trans" property="*" />

<%
conn.execute(trans);
%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="main.css" />
<title>RETS Logout Response</title>
</head>
<body>
<blockquote>
<br>
<img src="images/logout.gif">
</blockquote>
<table border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="110"></td>
    <td valign="top" align="left">
<b>
<%

String status = trans.getResponseStatus();

if ( "0".equals(status))
{
    out.println("Logout Successful");
    
}
else
{
    out.println("Logout Error: " + status);
}
%>
</b>
<br>
<%
long transTime = conn.getLastTransactionTime();
double sec = (double) transTime/1000.0;
out.print("Transaction time "+sec+"  Seconds");
%>
<br>
<br>
<b>Response:</b>
<br>
<hr>

<textarea rows="25" cols="80" style="background-color: #E2E2C5;">

<%
Map m = trans.getResponseMap();
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
<%
session.invalidate();
%>
