<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/22
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shared Access Counts: Page 2</title>
</head>
<body>
<center>
    <table border="5">
        <th><tr class="title">Shared Access Counts: Page 2</tr></th>
    </table><p></p>

    <jsp:useBean id="counter" class="share.AccessCountBean"
                 scope="application" >
        <jsp:setProperty name="counter" property="firstPage"
                         value="SharedCounts2.jsp" />
    </jsp:useBean>

    of SharedCounts2.jsp (this page),
    <a href="SharedCounts1.jsp">SharedCounts1.jsp</a>
    <jsp:getProperty name="counter" property="firstPage" />
    was the first page accessed;
    <p>
        Collectively, the two pages have been accessed
        <jsp:getProperty name="counter" property="accessCount" />
        times;
    </p>
    <jsp:setProperty name="counter" property="accessCountIncrement"
                     value="1" />
</center>
</body>
</html>
