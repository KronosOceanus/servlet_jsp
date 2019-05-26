<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/20
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>The import Attribute</title>
</head>
<body>
<h1>The import Attribute</h1>
<%-- 导入包 --%>
<%@ page import="page.*" %>
<%@ page import="java.util.Date" %>
<%-- 声明 --%>
<%!
    private String randomID(){
        int num = (int)(Math.random() * 10000000.0);
        return "id" + num;
    }
    private final String NO_VALUE = "<I>No Value</I>";
%>
<%-- 预定义对象 --%>
<%
    String oldID = CookieUtils.getCookieValue(request,"userID",NO_VALUE);
    if (oldID.equals(NO_VALUE)){
        String newID = randomID();
        Cookie cookie = new Cookie("userID",newID);
        cookie.setMaxAge(60 * 60 * 24 * 365);
        response.addCookie(cookie);
    }
%>
This page was accessed on <%= new Date()%> with a userID
cookie of <%= oldID %>
</body>
</html>
