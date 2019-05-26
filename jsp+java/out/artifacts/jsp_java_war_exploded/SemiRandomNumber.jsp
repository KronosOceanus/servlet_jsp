<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/20
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Semi-Random Number</title>
</head>
<body>
<%!
    private int randomNum = jsp_java.RanUtils.randomInt(10);
%>
<h1>Semi-Random Number: <br />
    <%= randomNum %> </h1>
</body>
</html>
