<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/21
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Using JavaBeans with JSP</title>
</head>
<body>
<table border="5" align="center">
    <tr><th class="title">Using JavaBeans with JSP</th></tr>
</table>
<%-- 创建bean --%>
<jsp:useBean id="stringBean" class="jsp_bean.StringBean" />
<ol>
    <%-- 两种方法显示属性 --%>
    <li>Initial value (from jsp:getProperty):
        <i><jsp:getProperty name="stringBean" property="message" /></i></li>
    <li>Initial value (from JSP expression):
        <i><%= stringBean.getMessage() %></i></li>

    <%-- 两种方法设置属性 --%>
    <li><jsp:setProperty name="stringBean" property="message"
             value="Best string bean: Fortex"/>
        Value after setting property with jsp:setProperty:
        <i><jsp:getProperty name="stringBean" property="message" /></i></li>
    <li><% stringBean.setMessage("My favroite: Kentucky Wonder"); %>
        Value after setting property with scriptlet:
        <i><%= stringBean.getMessage() %></i></li>

</ol>
</body>
</html>
