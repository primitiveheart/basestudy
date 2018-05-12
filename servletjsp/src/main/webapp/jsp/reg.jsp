<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/10
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
    <title>注册页面</title>
    <script language="javascript">
        function run(){
            var name = document.form1.username.value;
            if(name == "" || name.length == 0){
                alert("用户名不能为空");
                return false;
            }
            var password = document.form1.password.value;
            if(password == "" || password.length < 6){
                alert("密码至少为6位");
                return false;
            }
            var repassword =document.form1.repassword.value;
            if(repassword == "" || repassword != password){
                alert("两次密码不一致");
                return false;
            }

            var nickname = document.form1.nickname.value;
            if(nickname == "" || nickname.length == 0){
                alert("昵称不能为空");
                return false;
            }
//            var email = document.form1.email.value;
//            if(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(email)){
//                alert("邮箱格式正确");
//                return false;
//            }
        }


        function refreshCode(){
            var imageId = document.getElementById("imgId");
            imageId.src = "/code?"+new Date().getTime();

        }
    </script>
</head>
<body>
    <font color="red">${requestScope.msg}</font>
    <form name="form1" action="${pageContext.request.contextPath}/reg" method="post" onsubmit="return run()">
        <table border="1" width="70%">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" name="repassword"></td>
            </tr>
            <tr>
                <td>昵称</td>
                <td><input type="" name="nickname"></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td>
                    <input type="text" name="code">
                    <a href="#" onclick="refreshCode();return false"><img src="/code" id="imgId"></a>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="注册"></td>
            </tr>
        </table>
    </form>
</body>
</html>
