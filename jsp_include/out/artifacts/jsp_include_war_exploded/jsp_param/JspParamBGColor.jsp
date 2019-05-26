<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/21
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>included jsp</title>
</head>
<%-- 请求参数默认和主页面一样，但修改之后不同 --%>
<body bgcolor="<%= request.getParameter("bgColor") %>">
<h1 align="center">included jsp</h1>
</body>
</html>
