<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/20
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Random List (Version 2)</title>
</head>
<body>
<h1>Random List (Version 2)</h1>
<ul>
    <%
        int numEntries = jsp_java.RanUtils.randomInt(10);
        for (int i=0;i<numEntries;i++){
    %>
    <li><%= jsp_java.RanUtils.randomInt(10)%></li>
    <% } %>
</ul>
</body>
</html>
