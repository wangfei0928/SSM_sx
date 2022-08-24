<%--
  Created by IntelliJ IDEA.
  User: 王斐
  Date: 2022/8/5
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="uname"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="checkbox" value="1" name="remember">记住我</td>
            <td><input type="submit" value="登录"></td>
        </tr>

    </table>
</form>
<shiro:guest> 欢迎游客访问，<a href="login.jsp">登录</a> </shiro:guest>
<shiro:user> 欢迎[<shiro:principal />]登录，<a href="logout">退出</a> </shiro:user>
<shiro:authenticated> 用户<shiro:principal />已通过身份验证 </shiro:authenticated>
</body>
</html>
