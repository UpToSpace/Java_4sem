<%@ page import="com.example.laba9.classes.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="customtags" prefix="mytable"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<c:import url="header.jsp" />

<h2>${fn:toUpperCase("home page")} </h2>

<c:set var="userLogin" value="${user.getLogin()}" scope="page" />
<c:choose>
    <c:when test="${not empty userLogin and userLogin eq 'user'}">
        <h2>I know you're THE user</h2>
    </c:when>
    <c:when test="${not empty userLogin and userLogin != 'user'}">
        <h2>Oh you're not the user...</h2>
    </c:when>
</c:choose>

<c:out value="hello ${user.getLogin()}, your role is ${user.getRole()}" />
<br />

<mytable:mytable tableName="Command table" />

<br/>

<form action="add.jsp" method="post">
    <mytable:mybutton btnName="add" />
</form>
<form action="delete.jsp" method="post">
    <mytable:mybutton btnName="delete" />
</form>
<form action="update.jsp" method="post">
    <mytable:mybutton btnName="update"/>
</form>

<c:import url="footer.jsp" />
</body>
</html>
