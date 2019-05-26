<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/21
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact Section</title>
</head>
<%-- 浏览器页面的脚注（每个页面包含的脚注都不同） --%>
<body>
<%!
    private int accessCount = 0;
    private Date accessDate = new Date();
    private String accessHost = "<I>No previous access</I>";
%>
<p></p>
<hr>This page &copy; 2003
<a href="https://translate.google.cn/">Google</a>
This page has been accessed <%= accessCount %>
times since server reboot. It was most recently accessed from
<%= accessHost %> at <%= accessDate %>
<% accessHost = request.getRemoteHost(); %>
<% accessDate = new Date(); %>
</body>
</html>
