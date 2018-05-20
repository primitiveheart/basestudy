<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/19
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="">
        用户名:<input/><br/>
        密码:<input/><br/>
        验证码:<input><img src="${pageContext.request.contextPath}/captcha.action"><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
