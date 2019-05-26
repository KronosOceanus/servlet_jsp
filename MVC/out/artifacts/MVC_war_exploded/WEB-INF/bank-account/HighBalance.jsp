<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/24
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%-- 精英余额页面 --%>
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
    <br clear="all" />
    <jsp:useBean id="eliteCustomer" type="bank.BankCustomer"
        scope="request" />
    It is an honor to serve you,
    <jsp:getProperty name="eliteCustomer" property="firstName" />
    <jsp:getProperty name="eliteCustomer" property="lastName" />
</p>
$<jsp:getProperty name="eliteCustomer" property="balance" />
</body>
</html>
