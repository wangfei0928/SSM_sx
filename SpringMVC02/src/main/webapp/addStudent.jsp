<%--
  Created by IntelliJ IDEA.
  User: 王斐
  Date: 2022/8/4
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/addStudent" method="post">
    <table>
        <tr>
            <td>学生姓名</td>
            <td><input type="text" name="sname"></td>
        </tr>
        <tr>
            <td>分数</td>
            <td><input type="text" name="score"></td>
        </tr>
        <tr>
            <td><input type="submit" value="添加"></td>
        </tr>
    </table>
</form>
</body>
</html>
