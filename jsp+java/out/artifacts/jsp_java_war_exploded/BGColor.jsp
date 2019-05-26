<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/19
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Color Testing</title>
    <%-- 如果提交bgColor参数，则显示该背景色，否则白色 --%>
    <%
        String bgColor = request.getParameter("bgColor");
        if (bgColor == null || bgColor.trim().equals("")){
            bgColor = "WHITE";
        }
    %>
</head>
<body bgcolor="<%= bgColor %>">
<h2 align="center">Testing a Background of "<%= bgColor %>"</h2>
</body>
</html>
