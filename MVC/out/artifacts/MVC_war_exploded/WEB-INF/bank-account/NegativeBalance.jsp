<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/24
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%-- 余额不足页面 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You Owe Us.Money!</title>
</head>
<body>
<table border="5" align="center">
    <tr><td class="title">We Know Where You Live!</td></tr>
</table>
<p>
    <jsp:useBean id="badCustomer" type="bank.BankCustomer"
        scope="request" />
    Watch out,
    <jsp:getProperty name="badCustomer" property="firstName" />
    we know where you live.
</p>
<p>
    Pay us the
    $<jsp:getProperty name="badCustomer" property="balanceNoSign" />
    you owe us before it is too late!
</p>
</body>
</html>
