<html>
<body>
<h2>Insert User Info</h2>


<form action="add" method="post">

    <h3 style="color: red">${isAllEmpty}</h3>

    <label> Accound Number : </label>
    <input type="number" name="accountNo" >
    <h3 style="color: red">${accountNo}</h3>

    <label> Name : </label>
    <input type="text" name="name" >
    <h3 style="color: red">${name}</h3>

    <label> Balance : </label>
    <input type="number" name="balance" >
    <h3 style="color: red">${balance}</h3>

    <label> Email ID : </label>
    <input type="text" name="email" >
    <h3 style="color: red">${invalidEmail}</h3>

    <label> Address : </label>
    <input type="text" name="address" >
    <h3 style="color: red">${address}</h3>

    <input type="submit" value="Submit">

</form>

<a href="list"> <input type="submit" value="Back to List"> </a>


</body>
</html>
