<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/7/2021
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>KITS</title>
    <link rel="stylesheet" href="./style/main.css" type="text/css"/>
</head>
<body>
<h1>Update User</h1>
<p>NOTE: You can't update the email address.</p>
<form action="userAdmin" method="post">
    <input type="hidden" name="action" value="update_user">
    <label class="pad_top">Email:</label>
    <input type="email" name="email" value="${user.email}"
           disabled><br>
    <label class="pad_top">First Name:</label>
    <input type="text" name="firstName" value="${user.firstName}"
           required><br>
    <label class="pad_top">Last Name:</label>
    <input type="text" name="lastName" value="${user.lastName}"
           required><br>
    <label>&nbsp;</label>
    <input type="submit" value="Update" class="margin_left">
</form>
</body>
</html>