<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 20.05.2022
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="post" action="RegistrationServlet">
    Email:<input type="text" name="email" /><br/>
    Password:<input type="text" name="pass" /><br/>
    <input type="submit" value="Register" />
</form>
<br />
<form method="post" action="login.jsp">
    <input type="submit" value="To Login" />
</form>
<h4 style="color: red">${rmessage}</h4>
</body>
</html>
