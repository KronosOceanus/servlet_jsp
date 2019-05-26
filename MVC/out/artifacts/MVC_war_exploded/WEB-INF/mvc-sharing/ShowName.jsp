<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/24
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thanks for Registering</title>
</head>
<%-- 显示姓名的页面 --%>
<body>
<h1>Thanks for Registering</h1>
<jsp:useBean id="nameBean" type="compare.NameBean"
    scope="session" />
<h2>First Name:
    <jsp:getProperty name="nameBean" property="firstName" /></h2>
<h2>Last Name:
    <jsp:getProperty name="nameBean" property="lastName" /></h2>
</body>
</html>
