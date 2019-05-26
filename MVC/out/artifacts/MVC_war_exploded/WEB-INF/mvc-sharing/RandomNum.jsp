<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/24
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RandomNum</title>
</head>
<body>
<jsp:useBean id="randomNum" type="compare.NumberBean"
    scope="request" />
<h2>RandomNum: <jsp:getProperty name="randomNum" property="num" /></h2>
</body>
</html>
