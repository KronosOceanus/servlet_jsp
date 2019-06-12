<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/22
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bake Bean Values: request-based Sharing</title>
</head>
<body>
<center>
    <h1>Baked Bean Value: request-based Sharing</h1>
    <%-- 设置同请求共享 --%>
    <jsp:useBean id="requestBean" class="share.BakedBean"
            scope="request"/>
    <%-- 关联所有参数 --%>
    <jsp:setProperty name="requestBean" property="*" />
    <h2>Bean level: </h2>
    <jsp:getProperty name="requestBean" property="level" />
    <h2>Dish bean goes with:</h2>
    <jsp:getProperty name="requestBean" property="goesWith" />

    <%-- 引入jsp，第二个页面共享第一个页面的request对象 --%>
    <jsp:include page="BakedBeanDisplay-snippet.jsp" />
</center>
</body>
</html>
