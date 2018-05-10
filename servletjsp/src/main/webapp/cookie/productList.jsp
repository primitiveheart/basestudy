<%@ page import="com.zgb.utils.CookieUtil" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/9
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品浏览记录</title>
</head>
<body>
    <img src="/img/11.png"><a href="/product?id=11">查看</a>
    <img src="/img/22.png"><a href="/product?id=22">查看</a>
    <img src="/img/33.png"><a href="/product?id=33">查看</a>
    <img src="/img/44.png"><a href="/product?id=44">查看</a>
    <img src="/img/55.png"><a href="/product?id=55">查看</a>

    <h2>浏览记录</h2><a href="/remove">清除记录</a>
    <%
        Cookie[] cookies = request.getCookies();
        Cookie cookie = CookieUtil.getCookieByName(cookies, "product");
        if(cookie != null){
            String p = cookie.getValue();
            String[] ps = p.split(",");
            for(String s: ps){
    %>
        <img src="/img/<%=s%>.png">
    <%
            }
        }
    %>
</body>
</html>
