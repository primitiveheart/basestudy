<%@ page import="com.vo.User" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/17
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <c:if test="${sessionScope.user == null}">
        <a href="${pageContext.request.contextPath}/page/login.jsp">登录</a>
    </c:if>
    <c:if test="${sessionScope.user != null}">
        欢迎您:${sessionScope.user.nickname}
        <a href="${pageContext.request.contextPath}/">退出</a>
    </c:if>
    <hr>
    <a href="${pageContext.request.contextPath}/page/bbs.jsp">我的帖子</a>
</body>
</html>
