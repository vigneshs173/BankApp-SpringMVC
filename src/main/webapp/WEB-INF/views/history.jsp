<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Table</title>
</head>
<body>

<h2>Transaction History</h2>

<table cellpadding="5" border="1">
    <tr>
        <th>Transaction No</th>
        <th>Sender No</th>
        <th>Receiver No</th>
        <th>Transactional Amount</th>
        <th>Transaction Date and Time</th>
    </tr>

    <c:forEach var="history" items="${transactionHistory}">
        <tr>
            <td>${history.transactionNo}</td>
            <td>${history.senderNo}</td>
            <td>${history.receiverNo}</td>
            <td>${history.transactionalAmount}</td>
            <td>${history.dateTime}</td>
        </tr>
    </c:forEach>
</table> <br>


<a href="list"> <input type="submit" value="Back to List"> </a>
</body>
</html>
