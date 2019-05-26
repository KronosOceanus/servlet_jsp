<%--
  Created by IntelliJ IDEA.
  User: h'p
  Date: 2019/5/20
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>

<%-- 发送Excel表格 --%>
表格内容
<%@ page contentType="application/vnd.ms-excel"%>

<%-- 会话针对用户 --%>
<%@ page session="true" %> <%-- 存在已有会话则session绑定到该会话（默认） --%>
<%-- false组织jsp页面为那些不拥有会话的用户创建新的会话，可以节省大量服务器内存 --%>

<%-- 是否忽略EL表达式 --%>
<%@ page isELIgnored="true" %>

<%-- 指定out使用的缓冲区的大小 --%>
<%@ page buffer="32kb" %>
<%@ page buffer="none" %>

<%--控制当缓冲区充满之后是清空还是抛出异常 --%>
<%@ page autoFlush="true" %><%-- 清空（默认） --%>

<%-- 定义一个可以再Servlet中通过getServletInfo方法获取的字符串 --%>
<%@ page info="Some Message" %>

<%-- 指定该页面出错后的错误页面（跳转）--%>
<%@ page errorPage="index.jsp" %>
<%-- 然后再index.jsp中加入如下属性 --%>
<%@ page isErrorPage="true" %>

<%-- 指定jsp页面生成的Servlet的父类（例） --%>
<%@ page extends="page.CookieUtils" %>

<%-- 指定页面所使用的脚本语言 --%>
<%@ page language="java" %>

