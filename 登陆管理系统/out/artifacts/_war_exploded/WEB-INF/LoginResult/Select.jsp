<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/6/20
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select</title>
    <link rel="stylesheet" href="../../css/Sheet.css" type="text/css" />
</head>
<body>
<center>
    <h1><b>Select Result</b></h1>
    <table border="1 px solid balck" cellspacing="0">
        <tr>
            <th><b>ID</b></th>
            <th><b>Account</b></th>
            <th><b>Username</b></th>
            <th><b>Email</b></th>
            <th><b>Phone</b></th>
            <th><b>IDFK</b></th>
            <th><b>IDCardNumber</b></th>
            <th><b>Name</b></th>
            <th><b>Birthday</b></th>
            <th><b>Address</b></th>
        </tr>
        <%
            User user = (User)session.getAttribute("user");
            out.println("<tr><td>" + user.getId() +"</td>" + "<td>" + user.getAccount() +"</td>" +
                    "<td>" + user.getUsername() +"</td>" + "<td>" + user.getEmail() +"</td>" +
                    "<td>" + user.getPhone() +"</td>" + "<td>" + user.getId_card_fk() +"</td>" +
                    "<td>" + user.getIdCard().getId_card_number() +"</td>" +
                    "<td>" + user.getIdCard().getName() +"</td>" +
                    "<td>" + user.getIdCard().getBirthday() +"</td>" +
                    "<td>" + user.getIdCard().getAddress() +"</td></td>");
        %>
    </table><br />
    <form action="/Main.jsp">
        <input type="submit" value="Return to main" />
    </form>
</center>
</body>
</html>
