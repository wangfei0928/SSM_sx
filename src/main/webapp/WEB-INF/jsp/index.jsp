<%--
  Created by IntelliJ IDEA.
  User: 王斐
  Date: 2022/8/9
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hello index<br>
${session}
<br>
<shiro:hasAnyRoles name="putong,niubi">
    用户<shiro:principal/>拥有普通 牛逼角色
</shiro:hasAnyRoles>
<shiro:hasRole name="niubi">
    你是牛逼角色
</shiro:hasRole>
<shiro:hasRole name="putong">
    你是普通角色
</shiro:hasRole>
</body>
</html>
