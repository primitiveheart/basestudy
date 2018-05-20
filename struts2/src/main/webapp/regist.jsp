<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/19
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>注册</title>
    <s:head/>
</head>
<body>
    <s:form action="regist">
        <s:textfield label="用户名" name="username" required="true"></s:textfield>
        <s:textfield label="年龄" name="age" required="true"></s:textfield>
        <s:submit value="保存"/>
    </s:form>
</body>
</html>
