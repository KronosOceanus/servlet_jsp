<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/7/2
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Main</title>
</head>
<body>
<center>
    <h1>Login</h1><br />
    <form>
        Account：<input type="text" name="account"
                       minlength="6" maxlength="9" required="required"/><br />
        Password：<input type="password" name="password"
                        minlength="6" maxlength="18" required="required"/><br />
        <input type="submit" value="Log in" />
    </form>
    <form>
        <input type="submit" value="Sign up" />
    </form>
</center>
</body>
</html>
