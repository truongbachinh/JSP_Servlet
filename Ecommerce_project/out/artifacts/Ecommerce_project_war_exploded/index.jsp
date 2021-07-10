<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/7/2021
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>CiLi Ecommerce</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container-fluid">
        <div>
            <h3 class="text-center">Login to Cili Ecommerce website.</h3>
        </div>
        <hr>
        <form action="login">
            <div class="form-group">
                <label for="userName">Username: </label>
                <input type="text" name="ipUserName" id="userName" value="${userName}">
            </div>
            <div class="form-group">
                <label for="password">Password: </label>
                <input type="password" name="ipPassWord" id="password" value="${password}">
            </div>
        </form>
    </div>
</body>
</html>
