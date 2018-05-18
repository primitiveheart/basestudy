<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/18
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>在线的人数</title>
</head>
<body>
    <c:if test="${empty map}">
        没有登陆者
    </c:if>
    <c:if test="${!empty map}">
        <c:forEach items="${map}" var="m">
            ${m.key}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/kickServlet?username=${m.key}">踢人</a>
        </c:forEach>
    </c:if>
</body>
</html>
