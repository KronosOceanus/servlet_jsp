<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/19
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Declarations</title>
</head>
<body>
<%-- 打印自服务器启动以来当前页数被请求的次数 --%>
<%-- 线程不安全 --%>
<h1>JSP Declarations</h1>
<%! private int accessCount = 0; %>
<h2>
    Accesses to page since server reboot:
    <%= ++accessCount %>
</h2>
</body>
</html>
