<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/21
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>What's New at JspNews.com</title>
</head>
<body>
<table broder="5" align="center">
    <tr>
        <th class="title">
            What's New at JspNews.com
        </th>
    </tr>
</table>
<center>
    <p>
        Here is summary of out three most recent news stories:
    </p>
    <ol>
        <%-- 放在WEB-INF目录下 防止客户意外访问 --%>
        <li><jsp:include page="/WEB-INF/newsi_tem/Item1.html"></jsp:include></li>
        <li><jsp:include page="/WEB-INF/newsi_tem/Item2.html"></jsp:include></li>
        <li><jsp:include page="/WEB-INF/newsi_tem/Item3.html"></jsp:include></li>
    </ol>
</center>
</body>
</html>
