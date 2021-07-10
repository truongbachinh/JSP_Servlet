<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<h1>Checkout isn't finished yet</h1>
<p>Click on the browser's Back button to continue.</p>

<table>
    <tr>
        <th>Quantity</th>
        <th>Description</th>
        <th>Price</th>
        <th>Amount</th>
        <th></th>
    </tr>
    <c:forEach var="item" items="${cart.items}">
        <tr>
            <td>${item.quantity }</td>
            <td>${item.product.description }</td>
            <td>${item.product.priceCurrencyFormat }</td>
            <td>${item.totalCurrencyFormat}</td>
        </tr>
    </c:forEach>
    <tr>
        <td> Sum ${cart.totalPriceCurrencyFormat }</td>
    </tr>
</table>
<p>&copy; Copyright ${currentYear} Mike Murach &amp; Associates, Inc.
    All rights reserved.</p>
</body>
</html>
