<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Table</title>
</head>
<body>

<h2>Users List</h2>
<table cellpadding="5" border="1">
    <tr>
        <th>Account No </th>
        <th>Name</th>
        <th>Balance</th>
        <th>Email</th>
        <th>Address</th>
        <th>Delete</th>
        <th>Update</th>
        <th>Send</th>
        <th>Transaction History </th>
    </tr>

    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.accountNo}</td>
            <td>${user.name}</td>
            <td>${user.balance}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>

            <td><a href="${pageContext.request.contextPath}/delete/${user.accountNo}">Delete</a></td>
            <td><a href="${pageContext.request.contextPath}/update/${user.accountNo}">Update</a></td>
            <td><a href="${pageContext.request.contextPath}/send/${user.accountNo}">Send</a></td>
            <td><a href="${pageContext.request.contextPath}/viewHistory/${user.accountNo}">View History</a></td>

        </tr>
    </c:forEach>
</table> <br>
<a href="home"> <input type="submit" value="Add User"> </a>
<a href="history"> <input type="submit" value="All Transaction History"> </a>
</body>
</html>
