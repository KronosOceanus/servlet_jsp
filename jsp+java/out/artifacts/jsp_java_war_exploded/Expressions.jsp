<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/19
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Expressions</title>
    <meta name="keywords" content="JSP,expressions,JavaServer Pages,servlets" />
    <meta name="description" content="A quick example of JSP expression" />
</head>
<body>
<h2>JSP Expressions</h2>
<ul>
    <%-- scriptlet代码直接插入到_jspService方法中 --%>
    <%-- jsp表达式（与Servlet是对应的）     预定义变量 --%>
    <li>Current time: <%= new java.util.Date() %></li>
    <li>Server: <%= application.getServerInfo() %></li>
    <li>Session ID: <%= session.getId() %></li>
    <li>The <code>testParam</code> form parameter:
        <%= request.getParameter("textParam") %></li>
    <%-- 相当于全局变量 --%>
    <li>Out: <% String s = "jsp";
                out.println("Attached GET data: " + s);%></li>
    <%-- 还可以用XML书写 --%>
</ul>
</body>
</html>
