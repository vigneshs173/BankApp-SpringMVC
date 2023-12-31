<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update</title>
</head>
<body>

    <h2>Update user records</h2>

    <form action="updateUser" method="post">


        <label>Account No :</label> <br>
        <input type="text" name="accountNo" value="${user.accountNo}" readonly> <br> <br>

        <label>Name : </label> <br>
        <input type="text" name="name" value="${user.name}">
        <h3 style="color: red">${name}</h3>

        <label>Balance : </label> <br>
        <input type="number" name="balance" value="${user.balance}">
        <h3 style="color: red">${balance}</h3>

        <label>Mail ID : </label> <br>
        <input type="text" name="email" value="${user.email}">
        <h3 style="color: red">${invalidEmail}</h3>

        <label>Address : </label> <br>
        <input type="text" name="address" value="${user.address}"> <br>
        <h3 style="color: red">${address}</h3>


        <input type="submit" value="UPDATE"/>

    </form>

</body>
</html>
