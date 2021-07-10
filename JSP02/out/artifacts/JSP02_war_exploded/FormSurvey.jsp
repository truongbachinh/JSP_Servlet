<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/2/2021
  Time: 8:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Java-web course</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<h1>Survey</h1>
<p>If you have a moment, we'd appreciate it if you would fill out this survey</p>

<h3>Your information:</h3>
<p><i>${message}</i></p>
<form action="surveyList" method="post" enctype="multipart/fomr-data">
    <input type="hidden" name="action" value="add">
    <label for="firstname" class="pad_top">First name</label>
    <input type="text" id="firstName" name="ipFirstName" value="${user.firstName}" required>
    <br/>
    <label for="lastName" class="pad_top">Last name</label>
    <input type="text" id="lastName" name="ipLastName" value="${user.lastName}" required>
    <br/>
    <label for="email" class="pad_top">Email</label>
    <input type="email" id="email" name="ipEmail" value="${user.email}" required>
    <br/>
    <strong>How did you head about it ?</strong><br>
    <input type="radio" id="search" name="rdCheck" value="search" required>
    <label for="search">Search engine</label>&nbsp
    <input type="radio" id="word" name="rdCheck" value="word">
    <label for="word">Word of mouth</label><br>
    <input type="radio" id="other" name="rdCheck" value="other">
    <label for="other">Other</label><br>
    <strong>Would you like to receive announcements about new CDs and special offers?</strong>
    <br>
    <input type="checkbox" id="check" name="cbReceive" value="check" required>
    <label for="check">YES,I'd like that</label>
    <br>
    <label for="typeEmail">Country</label>
    <select id="typeEmail" name="selectEmail" required>
        <option value="" default>Email or postal email</option>
        <option value="email">Email</option>
        <option value="postal_email">Postal Email</option>
    </select>
    <br>

    <input type="submit" value="Submit" class="margin_left">
</form>
</body>
</html>
