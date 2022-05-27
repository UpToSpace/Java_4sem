<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 26.05.2022
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>New</h3>
<form action="AddServlet" method="post">
  <label>Number</label>
  <br>
  <input type="text" name="number">
  <br>
  <label>Name</label>
  <br>
  <input type="text" name="name">
  <br>
  <input type="submit" value="add">
</form>
</body>
</html>
