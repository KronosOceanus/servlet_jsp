<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/21
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add jsp_param to included jsp</title>
</head>
<body>
<%-- ……………… --%>
<h1 align="center">add jsp_param to included html</h1>
<jsp:include page="/jsp_param/JspParamBGColor.jsp">
    <%-- 增加/改变请求参数 --%>
    <jsp:param name="bgColor" value="yellow" />
</jsp:include>
</body>
</html>
