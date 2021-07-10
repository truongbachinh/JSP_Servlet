<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/7/2021
  Time: 7:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/6/2021
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Java-Web - KITS</title>
    <link rel="stylesheet" href="./styles/main.css" type="text/css"/>
</head>
<body>

<h1>User Role registration</h1>

<p>To register. Click on the Submit button.</p>
<p>${message}</p>
<form action="admin" method="post">
    <input type="hidden" name="action" value="addUserRole">
    <label class="pad_top" for="userName">User Name:</label>

    <select name="userName" id="userName">
        <c:forEach var="u" items="${users}">
            <option value="${u.userId}">${u.firstName}&nbsp;${u.lastName}</option>
        </c:forEach>
    </select>
    </br>
    <label class="pad_top" for="roleName">Role Name:</label>
    <select name="roleName" id="roleName">
        <c:forEach var="r" items="${roles}">
            <option value="${r.roleId}">${r.roleName}</option>
        </c:forEach>
    </select>

    <label>&nbsp;</label>
    </br>
    <input type="submit" value="Add new User-Role" class="margin_left">
</form>

</body>

</html>

