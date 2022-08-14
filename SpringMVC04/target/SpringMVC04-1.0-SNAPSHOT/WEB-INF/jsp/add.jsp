<%--
  Created by IntelliJ IDEA.
  User: 王斐
  Date: 2022/8/6
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品界面</title>
</head>
<body>
<form action="/product/add" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>产品名称</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>图片</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
