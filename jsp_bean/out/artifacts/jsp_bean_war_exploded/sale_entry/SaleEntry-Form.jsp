<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/22
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invocking SaleEntry.jsp</title>
</head>
<body>
<center>
    <table border="5"><tr><td class="title">Invocking SaleEntry.jsp</td></tr></table>
    <%-- 修改action提交到不同的表单 --%>
    <form action="SaleEntry3.jsp">
        Item ID: <input type="text" name="itemID" /><br />
        Number of Items: <input type="text" name="numItems" /><br />
        Discount Code: <input type="text" name="discountCode" /><br />
        <input type="submit" value="Show Price" />
    </form>
</center>
</body>
</html>
