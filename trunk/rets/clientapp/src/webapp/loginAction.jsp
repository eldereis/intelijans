
<%--
$Header: /usr/local/cvsroot/rets/clientapp/src/webapp/loginAction.jsp,v 1.3 2005/02/18 16:19:51 trawson Exp $
 --%>

<%@ page language='java' contentType='text/html' %>
<%@ page import="java.util.*" %>
<%@ page import="org.realtor.rets.retsapi.*" %>

<%
    // if this is not the first login; remove the old RETSConnection object
    if ( !session.isNew()) {
        session.removeAttribute("conn");
    }
%>

<jsp:useBean id="conn" scope="session" class="org.realtor.rets.retsapi.RETSConnection" />
<jsp:useBean id="trans" class="org.realtor.rets.retsapi.RETSLoginTransaction" />
<jsp:setProperty name="trans" property="*" />

<%
conn.setRequestHeaderField("RETS-Version",trans.getVersion());
conn.execute(trans);
//conn.setImageAccept(request.getParameter("imageAcceptValue"));

%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="main.css" />
<title>RETS Login Response</title>
</head>
<body>
      <blockquote>
        <br>
        <img src="images/login.gif">
        <br>
        <img src="images/loginactioncopy.gif">
      </blockquote>

<table width="813" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="813" valign="top">
       <blockquote>
        <p>
          <br>
          <br>
          <a href="technicalcomments.htm#LoginSuccessful"><img src="images/techcomments.gif" width="256" height="57" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="businesscomments.htm#loginSuccessful"><img src="images/busicomment.gif" width="256" height="57" border="0"></a>
          <br>
          <br>
          <br>
          <br>
        </p>

    <h2>
<%

String status = trans.getResponseStatus();

if ( "0".equals(status))
{
    out.println("Login Successful");
}
else
{
    out.println("Login Error: " + status);
}
%></h2>

<%
long transTime = conn.getLastTransactionTime();
double sec = (double) transTime/1000.0;
out.print("Transaction time "+sec+"  Seconds");
%>
         <br/>
        <p><font size="3">
        <b>Login Response:</b></font>
        <hr>
          <textarea rows="10" cols="69"  name="textarea" style="background-color: #E2E2C5;">
<%
Map m = trans.getResponseMap();
Iterator it = m.keySet().iterator();
// set user info to session
session.setAttribute("user-info",m.get("User"));

while (it.hasNext()) {
Object next = it.next();
    String key=(String)next;
    if ( !key.equals("body"))
    {
        out.println( key+"=["+m.get(key)+"]\n");
    }
}
//////////////////////////////////////////////////////////////////////////
%>

</textarea>
        </p>
<%
transTime = conn.getLastTransactionTime();
sec = (double) transTime/1000.0;
out.print("Action Transaction time "+sec+"  Seconds");
%>
        <br/><p><b><font size="3">
        Action Response:</font></b>
    <hr>
          <textarea rows="10" cols="69" name="textarea2" style="background-color: #E2E2C5;">

<%
RETSActionTransaction trans2 = new RETSActionTransaction();
conn.execute(trans2);

status = trans2.getResponseStatus();

if ( "0".equals(status))
{
    out.println("Action Successful");
}
else
{
    out.println("Action Error: " + status);
}
%>
<%
m = trans2.getResponseMap();

it = m.keySet().iterator();

while (it.hasNext()) {
    String key=(String)it.next();
//  if ( !key.equals("body"))
//  {
        out.println( key+"=["+m.get(key)+"]\n");
//  }
}

%>

</textarea>
        </p>
      </blockquote>
      <p><b>

        </b></p>
    </td>
  </tr>
</table>
</body>
</html>
