<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/25
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accessing Collections</title>
</head>
<%-- 访问集合 --%>
<body>
<h1>Accessing Collections</h1>
<p>
    <ul>
    <li>${first[0]} ${last[0]} (${company["Ellison"]})</li>
    <li>${first[1]} ${last[1]} (${company["Gates"]})</li>
    <li>${first[2]} ${last[2]} (${company["McNealy"]})</li>
</ul>
</p>
</body>
</html>
