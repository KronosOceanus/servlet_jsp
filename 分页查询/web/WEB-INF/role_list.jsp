<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/10/10
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Role List</title>
</head>
<body>
<center>
    总记录数：${pageBean.totalRecord} <br/>
    当前页数：${pageBean.pageNumber} <br/>

    <%-- 展示 --%>
    <c:forEach items="${pageBean.data}" var="role">
        ${role} <br/>
    </c:forEach>

    <%-- 翻页功能 --%>
    <c:if test="${pageBean.pageNumber gt 1}">
        <a href="${pageContext.request.contextPath}/controller.PageSelectServlet?pageNumber=${pageBean.pageNumber-1}">
            上一页
        </a>
    </c:if>
</center>
</body>
</html>
