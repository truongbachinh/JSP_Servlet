
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/25/2021
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Java-web course</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<style>
  /* The styles for the elements */
  body {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 85%;
    margin-left: 2em;
    margin-right: 2em;
    width: 400px;
  }
  h1 {
    font-size: 140%;
    color: teal;
    margin-bottom: .5em;
  }
  h2 {
    font-size: 120%;
    color: teal;
    margin-bottom: .5em;
  }
  label {
    float: left;
    width: 7em;
    margin-bottom: 0.5em;
    font-weight: bold;
  }
  input[type="text"], input[type="email"] {  /* An attribute selector */
    width: 15em;
    margin-left: 0.5em;
    margin-bottom: 0.5em;
  }
  span {
    margin-left: 0.5em;
    margin-bottom: 0.5em;
  }
  br {
    clear: both;
  }

  /* The styles for the classes */
  .pad_top {
    padding-top: 0.25em;
  }
  .margin_left {
    margin-left: 0.5em;
  }
</style>
<body>
<h1>Join our email list</h1>
<p>Nhập thông tin đầy đủ vào form</p>
<p><i>${message}</i></p>
<form action="emailList" method="post" enctype="multipart/fomr-data">
  <input type="hidden" name="action" value="add">
  <label for="email" class="pad_top">Email</label>
  <input type="email" id="email" name="ipEmail" value="${user.email}" >
  <br/>
  <label for="firstname" class="pad_top">First name</label>
  <input type="text" id="firstName" name="ipFirstName" value="${user.firstName}" >
  <br/>
  <label for="lastName" class="pad_top">Last name</label>
  <input type="text" id="lastName" name="ipLastName" value="${user.lastName}" >
  <br/>
  <input type="submit" value="Join now" class="margin_left">
</form>
</body>
</html>
