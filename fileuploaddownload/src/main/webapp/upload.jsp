<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/18
  Time: 7:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/demo2" method="post" enctype="multipart/form-data">
        名字:<input type="text" name="name">
        文件一:<input type="file" name="f1">
        文件二:<input type="file" name="f2">
        <input type="submit" value="上传">
    </form>
</body>
</html>
