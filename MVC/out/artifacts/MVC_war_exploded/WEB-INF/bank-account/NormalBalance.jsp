<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/24
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%-- 普通用户页面 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Balance</title>
</head>
<body>
<table border="5" align="center">
    <tr><td class="title">Your Balance</td></tr>
</table>
<p>
    <jsp:useBean id="regularCustomer" type="bank.BankCustomer"
        scope="request" />
    <ul>
    <li>First name: <jsp:getProperty name="regularCustomer" property="firstName" /></li>
    <li>Last name: <jsp:getProperty name="regularCustomer" property="lastName" /></li>
    <li>ID: <jsp:getProperty name="regularCustomer" property="id" /></li>
    <li>Balance: $<jsp:getProperty name="regularCustomer" property="balance" /></li>
</ul>
</p>
</body>
</html>
