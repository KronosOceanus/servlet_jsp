<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/20
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Random Numbers</title>
</head>
<body>
<%-- 使用工具类生成五个随机数 --%>
<h1>Random Numbers</h1>
<ul>
    <li><%= jsp_java.RanUtils.randomInt(10)%></li>
    <li><%= jsp_java.RanUtils.randomInt(10)%></li>
    <li><%= jsp_java.RanUtils.randomInt(10)%></li>
    <li><%= jsp_java.RanUtils.randomInt(10)%></li>
    <li><%= jsp_java.RanUtils.randomInt(10)%></li>
</ul>
</body>
</html>
