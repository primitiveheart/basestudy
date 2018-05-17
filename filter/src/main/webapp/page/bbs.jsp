<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/17
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>帖子</title>
</head>
<body>
    <c:if test="${sessionScope.user == null}">
        你是谁
    </c:if>
    <c:if test="${sessionScope.user != null}">
        您是:${sessionScope.user.username}
    </c:if>
    <hr>
    您的帖子
</body>
</html>
