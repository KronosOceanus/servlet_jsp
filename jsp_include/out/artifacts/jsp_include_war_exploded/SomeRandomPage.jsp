<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/21
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Some Random Page</title>
</head>
<body>
<table border="5" align="center">
    <tr><th class="title">Some Random Page</th></tr>
</table>
<p>Information about our products and services.</p>
<p>Yada,Yada,Yada</p>
<p>Yada,Yada,Yada</p>
<%-- 代码重用而不是页面重用，使用include，每个页面的脚注都不同--%>
<%@ include file="/WEB-INF/ContactSection.jsp"%>
</body>
</html>
