<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/19
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wish for the Day</title>
</head>
<body>
<% if (Math.random() < 0.5){ %>
<h1>Have a <i>nice</i> day!</h1>
<% } else{ %>
<h1>Have a <i>lousy</i> day!</h1>
<% } %>
</body>
</html>
