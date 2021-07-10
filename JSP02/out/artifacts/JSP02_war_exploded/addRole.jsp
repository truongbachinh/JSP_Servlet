<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/6/2021
  Time: 3:32 PM
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

<h1>Download registration</h1>

<p>To register for our downloads, enter your name and email
    address below. Then, click on the Submit button.</p>
<p>${message}</p>
<form action="admin" method="post">
    <input type="hidden" name="action" value="addRole">
    <label class="pad_top">Role Name:</label>
    <input type="text" name="roleName" value="${role.roleName}"><br>
    <label class="pad_top">Role Description:</label>
    <input type="text" name="roleDes" value="${role.roleDes}"><br>
    <label>&nbsp;</label>
    <input type="submit" value="addNewRole" class="margin_left">
</form>

</body>

</html>

