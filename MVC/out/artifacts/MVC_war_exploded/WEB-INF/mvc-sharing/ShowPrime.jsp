<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/24
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>A Prime Number</title>
</head>
<body>
<h1>A Prime Number</h1>
<jsp:useBean id="primeBean" type="compare.PrimeBean"
    scope="application" />
<jsp:getProperty name="primeBean" property="prime" />
</body>
</html>
