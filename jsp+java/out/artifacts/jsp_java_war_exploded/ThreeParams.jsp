<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/19
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reading Three Request Parameters</title>
</head>
<body>
<h1>Reading Three Request Parameters</h1>
<ul>
    <li><b>param1</b>: <%= request.getParameter("param1") %></li>
    <li><b>param2</b>: <%= request.getParameter("param2") %></li>
    <li><b>param3</b>: <%= request.getParameter("param3") %></li>
</ul>
</body>
</html>
