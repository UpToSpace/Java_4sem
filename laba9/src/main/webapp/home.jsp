<%@ page import="com.example.laba9.classes.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.laba9.classes.Gamers" %>
<%@ page import="com.example.laba9.classes.Database" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 20.05.2022
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<%@include file="header.jsp"%>

<h1>Home page</h1>
<h4>hello ${user.getLogin()}, your role is ${user.getRole()}, today is <%= (new java.util.Date().getDate())%>.<%= (new java.util.Date().getMonth() + 1)%></h4>
<br />
<h3>Command table</h3>
<table style="{border-collapse: collapse; border: black;}">
    <tr>
        <td>Number</td>
        <td>Name</td>
    </tr>
    <%
        Database database = new Database();
        ArrayList<Gamers> gamers = database.GetGamers();
        for (Gamers gamer: gamers) {
    %>

    <tr>
        <td><%= gamer.getNumber() %></td>
        <td><%= gamer.getName() %></td>
    </tr>
    <%
        }
    %>
</table>
<br/>

<form action="add.jsp" method="post">
    <input type="submit" value="add">
</form>
<form action="delete.jsp" method="post">
    <input type="submit" value="delete">
</form>
<form action="update.jsp" method="post">
    <input type="submit" value="update">
</form>

<%@include file="footer.jsp"%>
</body>
</html>
