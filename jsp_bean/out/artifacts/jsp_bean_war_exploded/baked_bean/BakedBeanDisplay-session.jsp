<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/22
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Baked Bean Values: session-based Sharing</title>
</head>
<body>
<center>
    <h1>Baked Bean Value: session-based Sharing</h1>
    <jsp:useBean id="sessionBean" class="share.BakedBean" />
    <jsp:setProperty name="sessionBean" property="*" />
    <h2>Bean level: </h2>
    <jsp:getProperty name="sessionBean" property="level" />
    <h2>Dish bean goes with:</h2>
    <jsp:getProperty name="sessionBean" property="goesWith" />
</center>
</body>
</html>
