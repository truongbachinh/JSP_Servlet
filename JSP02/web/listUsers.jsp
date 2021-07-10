<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/5/2021
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Java web KITS</title>
    <link rel="stylesheet" href="./styles/main.css" type="text/css"/>
</head>
<body>

<h1>Users</h1>

<p>Here's a table with all of the cookies that this
    browser is sending to the current server.</p>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>${message}</p>
<table>
    <tr>
        <th>Id</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Email</th>
        <th>Detail</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="c" items="${users}">
        <tr>
            <td>${c.userId}</td>
            <td>${c.firstName}</td>
            <td>${c.lastName}</td>
            <td>${c.email}</td>
            <td><a href="admin?action=viewDetail&id=${c.userId}">Click</a></td>
            <td><a href="admin?action=update&id=${c.userId}">Click</a></td>
            <td><a href="admin?action=delete&id=${c.userId}">Click</a></td>
        </tr>
    </c:forEach>
</table>


<p><a href="admin?action=addRole">Add New Role</a></p>

<p><a href="admin?action=deleteCookies">Delete all persistent cookies</a></p>

</body>
</html>
