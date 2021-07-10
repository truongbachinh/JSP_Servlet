<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/7/2021
  Time: 6:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/5/2021
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Java web KITS</title>
    <link rel="stylesheet" href="./style/main.css" type="text/css"/>
</head>
<body>

<h1>Role</h1>

<p>Here's a table with all role.</p>

<p>${message}</p>
<table>
    <tr>
        <th>Id</th>
        <th>Role name</th>
        <th>Role Description</th>
        <th colspan="3">Action</th>
    </tr>
    <c:forEach var="r" items="${roles}">
        <tr>
            <td>${r.roleId}</td>
            <td>${r.roleName}</td>
            <td>${r.roleDes}</td>
            <td><a href="admin?action=viewDetailRole&id=${r.roleId}">Click</a></td>
            <td><a href="admin?action=updateRole&id=${r.roleId}">Click</a></td>
            <td><a href="admin?action=deleteRole&id=${r.roleId}">Click</a></td>
        </tr>
    </c:forEach>
</table>


<p><a href="admin?action=addRole">Add New Role</a></p>
<p>
    <a href="admin?action=setUserRole">
        Set User Role
    </a>
</p>
<p><a href="admin?action=deleteCookies">Delete all persistent cookies</a></p>

</body>
</html>

