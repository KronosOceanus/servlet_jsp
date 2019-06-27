<%@ page import="entity.User" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/6/20
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="Error.jsp" %>
<html>
<head>
    <title>Login Successful</title>
    <link rel="stylesheet" href="css/Sheet.css" type="text/css" />
</head>
<body>
<center>
    <h1><b>All Users Information</b></h1>
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
            Collection<User> users = (Collection<User>) session.getAttribute("users");
            for (User user : users) {
                out.println("<tr><td>" + user.getId() + "</td>" + "<td>" + user.getAccount() + "</td>" +
                        "<td>" + user.getUsername() + "</td>" + "<td>" + user.getEmail() + "</td>" +
                        "<td>" + user.getPhone() + "</td>" + "<td>" + user.getId_card_fk() + "</td>" +
                        "<td>" + user.getIdCard().getId_card_number() + "</td>" +
                        "<td>" + user.getIdCard().getName() + "</td>" +
                        "<td>" + user.getIdCard().getBirthday() + "</td>" +
                        "<td>" + user.getIdCard().getAddress() + "</td></td>");
            }
        %>
    </table><br />
    <form action="/controller.SelectServlet">
        <input type="submit" value="findById" /><input type="text" name="id" />
        <input hidden="hidden" name="method" value="id" />
    </form><br />
    <form action="/controller.SelectServlet">
        <input type="submit" value="findByAccount" /><input type="text" name="account" />
        <input hidden="hidden" name="method" value="account" />
    </form><br />
    <form action="/controller.SelectServlet">
        <input type="submit" value="findByUsername" /><input type="text" name="username" />
        <input hidden="hidden" name="method" value="username" />
    </form><br />
    <form action="/controller.DeleteServlet">
        <input type="submit" value="DeleteById" /><input type="text" name="id" />
    </form><br />
    <form action="Update.jsp">
        <input type="submit" value="UpdateById" /><input type="text" name="id" />
    </form><br />
</center>
</body>
</html>
