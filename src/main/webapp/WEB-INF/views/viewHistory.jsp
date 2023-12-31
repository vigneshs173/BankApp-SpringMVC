<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Table</title>
</head>
<body>

<h2>Account No is : ${accountNo}</h2>
<hr>
<h2>Debited Transactions</h2>
<table cellpadding="5" border="1">
    <tr>
        <th>Transaction No</th>
        <th>Receiver No</th>
        <th>Transactional Amount</th>
        <th>Transaction Date and Time</th>
    </tr>

    <c:forEach var="debit" items="${debit}">
        <tr>
            <td>${debit.transactionNo}</td>
            <td>${debit.receiverNo}</td>
            <td>${debit.transactionalAmount}</td>
            <td>${debit.dateTime}</td>
        </tr>
        <c:set var="totalDebit" value="${totalDebit + debit.transactionalAmount}" />
    </c:forEach>
</table>
<h2>Total Debited Amount : ${totalDebit}</h2>
<hr>
<h2>Credited Transactions</h2>
<table cellpadding="5" border="1">
    <tr>
        <th>Transaction No</th>
        <th>Sender No</th>
        <th>Transactional Amount</th>
        <th>Transaction Date and Time</th>
    </tr>

    <c:forEach var="credit" items="${credit}">
        <tr>
            <td>${credit.transactionNo}</td>
            <td>${credit.senderNo}</td>
            <td>${credit.transactionalAmount}</td>
            <td>${credit.dateTime}</td>
        </tr>
        <c:set var="totalCredit" value="${totalCredit + credit.transactionalAmount}" />
    </c:forEach>
</table>
<h2>Total Credited Amount : ${totalCredit}</h2>

<a href="../list"> <input type="submit" value="Back to List"> </a>
<hr>
</body>
</html>
