<%--
  Created by IntelliJ IDEA.
  User: 王斐
  Date: 2022/8/6
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品界面</title>
</head>
<body>
<form action="/product/edit" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td><input type="hidden" name="id" value="${pro.id}"></td>
        </tr>
        <tr>
            <td>产品名称</td>
            <td><input type="text" name="name" value="${pro.name}"></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="price" value="${pro.price}"></td>
        </tr>
        <tr>
            <td>图片:<img src="/static/img/${pro.img}" width="100px" height="50px"></td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
