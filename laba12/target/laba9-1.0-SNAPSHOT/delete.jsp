<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 26.05.2022
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Delete</h3>
<form action="DeleteServlet" method="post">
  <label>Number</label>
  <br>
  <input type="text" name="number">
  <br>
  <input type="submit" value="delete">
</form>
</body>
</html>
