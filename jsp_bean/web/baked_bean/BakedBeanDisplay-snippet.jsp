<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/22
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Repeated Baked Bean Values: request-based Sharing</title>
</head>
<body>
<center>
    <h1>Repeated Baked Bean Values: request-based Sharing</h1>
    <%-- 设置次页面共享 --%>
    <jsp:useBean id="requestBean" class="share.BakedBean"
             scope="request"/>
    <h2>Bean level: </h2>
    <jsp:getProperty name="requestBean" property="level" />
    <h2>Dish bean goes with: </h2>
    <jsp:getProperty name="requestBean" property="goesWith" />
</center>
</body>
</html>
