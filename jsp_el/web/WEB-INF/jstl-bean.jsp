<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/8/13
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL-Bean</title>
</head>
<body>
<center>
    <%-- 判断对象是否为 null --%>
    test：
    <c:if test="${empty obj}">
        jstlBean is null！<br />
    </c:if>
    <br />

    for：<br />
    <c:forEach begin="0" end="5" var="i">
        ${i} <br />
    </c:forEach>
    <br />

    <%-- 模拟 foreach --%>
    foreach：<br />
    <c:forEach items="${list}" var="li">
        ${li} <br/>
    </c:forEach>
    <br />

    <%-- 遍历 Map --%>
    遍历 Map：<br />
    <c:forEach items="${map}" var="entry">
        ${entry.key} === ${entry.value} <br />
    </c:forEach>
    <br />

</center>
</body>
</html>
