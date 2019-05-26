<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/19
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Some Heading</title>
</head>
<body>
<%-- 方法声明 --%>
<%-- 等价代码在对应的Servlet中 --%>
<h1>Some Heading</h1>
<%-- 也可以使用XML声明--%>
<%!
    private String randomHeading(){
        return "<h2>" + Math.random() + "</h2>";
    }
%>
</body>
<%= randomHeading() %>
</html>
