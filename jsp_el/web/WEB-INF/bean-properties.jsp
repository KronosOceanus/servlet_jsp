<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/25
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accessig Bean Properties</title>
</head>
<%-- 访问bean属性 --%>
<body>
<h1>Accessig Bean Properties</h1>
<p>
    <ul>
    <li><b>First Name: </b>${employee.name.firstName}</li>
    <li><b>Last Name: </b>${employee.name.lastName}</li>
    <li><b>Company Name: </b>${employee.company.companyName}</li>
    <li><b>Company Business: </b>${employee.company.business}</li>
</ul>
</p>
</body>
</html>
