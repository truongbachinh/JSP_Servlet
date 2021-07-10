<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/7/2021
  Time: 2:41 PM
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

<h1>Login registration</h1>

<p>To register for our downloads, enter your name and email
    address below. Then, click on the Submit button.</p>
<p>${message}</p>
<form action="download" method="post">
    <input type="hidden" name="action" value="login">
    <label class="pad_top">Email:</label>
    <input type="email" name="email" value="${user.email}"><br>
    <input type="submit" value="Login" class="margin_left">
</form>

</body>

</html>

