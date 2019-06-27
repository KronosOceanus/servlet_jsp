<%@ page import="entity.User" %>
<%@ page import="service.UserServiceImpl" %>
<%@ page import="dao.UserDaoImpl" %>
<%@ page import="dao.IDCardDaoImpl" %>
<%@ page import="service.UserService" %><%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/6/20
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="Error.jsp" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="css/Sheet.css" type="text/css" />
</head>
<body>
<center>
    <h1><b>Update</b></h1>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        UserService uS = new UserServiceImpl(new UserDaoImpl(), new IDCardDaoImpl());
        User user = uS.findById(id);
    %>
    <form action="/controller.UpdateServlet">
        <h2><b>User Information</b></h2>
        Account：<%= user.getAccount() %>><br />
        <input type="text" name="account" hidden="hidden"
               value="<%= user.getAccount() %>" />
        <input type="password" name="password" hidden="hidden"
               value="<%= user.getPassword() %>"/>
        Username：<input type="text" name="username"
                        minlength="1" maxlength="20" value="<%= user.getUsername() %>"/><br />
        Email：<input type="email" name="email"
                     maxlength="25" value="<%= user.getEmail() %>"/><br />
        Phone：<input type="tel" name="phone"
                     maxlength="11" value="<%= user.getPhone()%>"/><br />
        <p>
        <h2><b>ID Card Information</b></h2>
        ID_Card_Number：<%= user.getIdCard().getId_card_number() %><br />
        Name：<%= user.getIdCard().getName() %><br />
        Birthday：<%= user.getIdCard().getBirthday() %><br />
        Address：<%= user.getIdCard().getAddress() %><br />
        </p>
        <input type="submit" value="Submit update" />
    </form>
</center>
</body>
</html>
