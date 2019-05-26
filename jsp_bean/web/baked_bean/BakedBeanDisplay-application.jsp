<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/22
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Baked Bean Values: application-based Sharing</title>
</head>
<body>
<center>
    <h1>Baked Bean Value: application-based Sharing</h1>
    <%-- 设置全局共享 --%>
    <jsp:useBean id="applicationBean" class="share.BakedBean"
            scope="application"/>
    <jsp:setProperty name="applicationBean" property="*" />
    <h2>Bean level: </h2>
    <jsp:getProperty name="applicationBean" property="level" />
    <h2>Dish bean goes with:</h2>
    <jsp:getProperty name="applicationBean" property="goesWith" />
</center>
</body>
</html>
