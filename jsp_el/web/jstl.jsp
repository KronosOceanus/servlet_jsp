<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/8/13
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--                  导入标签库                   标签库前缀 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
    <%-- 跟 MyBatis 动态 SQL 相似 --%>
    <%-- test 表示条件（返回 boolean ）--%>
    <c:if test="${1==1}">
        xxxx
    </c:if>
    <c:if test="${1!=1}">
        yyyy
    </c:if>
</body>
</html>
