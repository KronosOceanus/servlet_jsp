<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/20
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Random List (Version 1)</title>
</head>
<body>
<%-- 生成长度改变的随机数列表 --%>
<h1>Random List (Version 1)</h1>
<ul>
    <%
        int numEntries = jsp_java.RanUtils.randomInt(10);
        for (int i=0;i<numEntries;i++){
            out.println("<LI>" + jsp_java.RanUtils.randomInt(10));
        }
    %>
</ul>
</body>
</html>
