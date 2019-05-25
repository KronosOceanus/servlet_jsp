<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/22
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bake Bean Values: page-based Sharing</title>
</head>
<body>
<center>
    <h1>Baked Bean Value: page-based Sharing</h1>
    <jsp:useBean id="pageBean" class="share.BakedBean" />
    <jsp:setProperty name="pageBean" property="*" />
    <h2>Bean level: </h2>
    <jsp:getProperty name="pageBean" property="level" />
    <h2>Dish bean goes with:</h2>
    <jsp:getProperty name="pageBean" property="goesWith" />
</center>
</body>
</html>
