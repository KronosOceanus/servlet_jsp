<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/22
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Using jsp:setProperty 1</title>
</head>
<body>
<%-- 类型强转 --%>
<center>
    <table border="5"><th><tr class="title">Using jsp；setProperty 1</tr></th></table>
    <jsp:useBean id="entry" class="higher.SaleEntry" />
    <jsp:setProperty name="entry" property="itemID"
            value='<%= request.getParameter("itemID") %>' />
    <%-- 设置int类型属性 --%>
    <%
        int numItemsOrdered = 1;
        try {
            numItemsOrdered = Integer.parseInt(request.getParameter("numItems"));
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    %>
    <jsp:setProperty name="entry" property="numItems"
            value="<%= numItemsOrdered %>" />

    <%
        double discountCode = 1.0;
        try {
            String discountString = request.getParameter("discountCode");
            discountCode = Double.parseDouble(discountString);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    %>
    <jsp:setProperty name="entry" property="discountCode"
            value="<%= discountCode %>" />
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
