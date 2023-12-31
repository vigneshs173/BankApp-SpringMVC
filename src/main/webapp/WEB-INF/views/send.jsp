<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Debit</title>
</head>

<body>
<h2>Your Account Number is : ${sender.accountNo}</h2>
<h2>Your Account Balance is : ${sender.balance}</h2> <br>

    <form action="debitAmount" method="post">

        <input type="number" name="senderNo" value="${sender.accountNo}" hidden> <br> <br>

        <label>Account No</label>
        <input type="number" name="receiverNo"> <br>
        <h3 style="color: red">${receiver}</h3>


        <label>Amount</label>
        <input type="number" name="transactionalAmount"> <br> <br>
        <h3 style="color: red">${balance}</h3>

        <input type="submit" value="SEND"> <br> <br>
    </form>

</body>
</html>
