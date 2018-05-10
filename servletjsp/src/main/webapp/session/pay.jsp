<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/10
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结算页面</title>
</head>
<body>
    <%
        HttpSession s = request.getSession();
        Map<String, Integer> cart = (Map<String, Integer>)s.getAttribute("cart");
        if(cart != null){
            for(Map.Entry<String, Integer> entry : cart.entrySet()){
    %>
            <h2>商品名称:<%=entry.getKey()%> </h2> <h3>数量:<%=entry.getValue()%></h3>
    <%
            }
        }else{
    %>
        <h2>亲，您还没有购物，请您去<a href="/session/CartList.jsp">购物</a></h2>
    <%
            }
    %>
</body>
</html>
