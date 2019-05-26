<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/22
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Using jsp:setProperty 3</title>
</head>
<body>
<%-- 表单bean --%>
<center>
    <table border="5"><th><tr class="title">Using jsp；setProperty 3</tr></th></table>
    <jsp:useBean id="entry" class="higher.SaleEntry" />

    <%-- 直接关联所有参数 --%>
    <jsp:setProperty name="entry" property="*" />
    <%-- 缺点是不会自动返回null，也没有异常处理 --%>

    <br />
    <table border="1">
        <tr class="colored"><th>Item ID</th><th>Unit Price</th>
            <th>Number Ordered</th><th>Total Price</th></tr>
        <tr align="right">
            <td><jsp:getProperty name="entry" property="itemID" /></td>
            <td><jsp:getProperty name="entry" property="itemCost" /></td>
            <td><jsp:getProperty name="entry" property="numItems" /></td>
            <td><jsp:getProperty name="entry" property="totalCost" /></td>
        </tr>
    </table>
</center>
</body>
</html>