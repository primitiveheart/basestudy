<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/20
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>单文件上传</title>
    <s:head/>
</head>
<body>
    <s:actionerror/>
    <s:form action="upload1" enctype="multipart/form-data">
        <s:textfield name="name" label="名称"></s:textfield>
        <s:file name="photo" label="图片"></s:file>
        <s:submit value="上传"></s:submit>
    </s:form>
</body>
</html>
