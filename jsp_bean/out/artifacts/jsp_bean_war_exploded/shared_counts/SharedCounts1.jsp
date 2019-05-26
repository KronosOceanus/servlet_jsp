<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/22
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shared Access Counts: Page 1</title>
</head>
<body>
<center>
    <table border="5">
        <th><tr class="title">Shared Access Counts: Page 1</tr></th>
    </table><p></p>

    <%-- bean的id相同，共享 --%>
    <jsp:useBean id="counter" class="share.AccessCountBean"
            scope="application" >
        <%-- 在页面被首次访问时执行 --%>
        <jsp:setProperty name="counter" property="firstPage"
                         value="SharedCounts1.jsp" />
    </jsp:useBean>

    of SharedCounts1.jsp (this page),
    <a href="SharedCounts2.jsp">SharedCounts2.jsp</a>
    <jsp:getProperty name="counter" property="firstPage" />
    was the first page accessed;
    <p>
        Collectively, the two pages have been accessed
        <%-- 针对所有的请求都要执行 --%>
        <jsp:getProperty name="counter" property="accessCount" />
        times;
    </p>
    <%-- 也可以调用方法 --%>
    <jsp:setProperty name="counter" property="accessCountIncrement"
                     value="1" />
</center>
</body>
</html>
