<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/7/2021
  Time: 6:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Java-Web - KITS</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<h1>Update role</h1>

<p>To update role, click on the Submit button.</p>
<p>${message}</p>
<form action="download" method="post">
    <input type="hidden" name="action" value="submitRole">
    <label class="pad_top">Role Name:</label>
    <input type="hidden" name="roleId" value="${role.roleId}"><br>
    <input type="text" name="roleName" value="${role.roleName}"><br>
    <label class="pad_top">Role Description:</label>
    <input type="text" name="roleDes" value="${role.roleDes}"><br>
    <label>&nbsp;</label>
    <input type="submit" value="updateRole" class="margin_left">
</form>

</body>

</html>


