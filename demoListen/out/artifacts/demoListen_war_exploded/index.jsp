<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/5/2021
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>JAVA WEB - KITS</title>
  <link rel="stylesheet" href="./style/main.css" type="text/css"/>
</head>
<body>
<h1>Welcome to ${username}</h1>
<h1>CD list</h1>
<table>
  <tr>
    <th>Description</th>
    <th class="right">Price</th>
    <th>&nbsp;</th>
  </tr>
  <c:forEach var="product" items="${products}">
    <tr>
      <td><c:out value='${product.description}' /></td>
      <td class="right">${product.priceCurrencyFormat}</td>
      <td><form action="cart" method="post">
        <input type="hidden" name="productCode"
               value="${product.code}">
        <input type="submit"
               value="Add To Cart">
      </form></td>
    </tr>
  </c:forEach>
</table>

<p>For customer service, please send an email to ${custServEmail}.</p>

<p>&copy; Copyright ${currentYear} Mike Murach &amp; Associates, Inc.
  All rights reserved.</p>
</body>
</html>
