<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 20.05.2022
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="LoginServlet">
    Email:<input type="text" name="email" /><br/>
    Password:<input type="text" name="pass" /><br/>
    <input type="submit" value="Log in" />
</form>
<br />
<form method="post" action="registration.jsp">
    <input type="submit" value="To Registration" />
</form>
<h4 style="color: red">${message}</h4>
</body>
</html>
