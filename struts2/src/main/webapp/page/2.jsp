<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/19
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>动作类充当数据模型</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/demo2.action" method="post">
        用户名:<input type="text" name="name"><br/>
        年龄:<input type="text" name="age"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
