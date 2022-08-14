<%--
  Created by IntelliJ IDEA.
  User: 王斐
  Date: 2022/8/5
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>展示界面</title>
    <script type="application/javascript" src="/static/js/jquery.js"></script>
    <script>

        var pageNo = 1;
        var pageSize = 5;
        var totalPage;//总页数
        function edit(id) {
            location.href="/product/toEdit?id="+id;
        }
        function del(id){
            location.href="/product/toDel?id="+id;
        }

        function lastPage(pageSize) {
            pageSize = $('#myDlist option:selected').val();
            pageNo = pageNo - 1;
            if (pageNo <= 1){
                pageNo = 1;
            }
            location.href="/product/toList?pageSize="+pageSize+"&pageNo="+pageNo;

        }
        function nextPage() {

            pageSize = $('#myDlist option:selected').val();
            var totalSize = document.getElementById("totalSize").value;//总数量
            totalPage = Math.ceil((totalSize/pageSize));
            if (pageNo != totalPage){
                pageNo+=1;
            }
            location.href="/product/toList?pageSize="+pageSize+"&pageNo="+pageNo;
        }

        function jumpPage() {
            var totalSize = document.getElementById("totalSize").value;//总数量
            pageSize = $('#myDlist option:selected').val();
            pageNo = document.getElementById("jump").value;
            totalPage = Math.ceil((totalSize/pageSize));
            if (pageNo < 1||pageNo>totalPage){
                alert("请输入1到"+totalPage+"的数字！");
            }else {
                location.href="/product/toList?pageSize="+pageSize+"&pageNo="+pageNo;
            }
        }

        function change(o) {
            var pageSize = o.value;
            pageNo = 1;
            location.href="/product/toList?pageSize="+pageSize+"&pageNo="+pageNo;
        }
    </script>
</head>
<body>
<h1>登陆成功,欢迎${isLogin}</h1>
<p align="center"><a href="/product/toAdd">添加商品</a></p>
<table border="1" align="center">
    <input type="hidden" id="totalSize" value="${totalSize}">
    <tr>
        <td>产品ID</td>
        <td>产品名称</td>
        <td>价格</td>
        <td>图片</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${plist}" var="pro">
        <tr>
            <td>${pro.id}</td>
            <td>${pro.name}</td>
            <td>${pro.price}</td>
            <td><img src="/static/img/${pro.img}" width="100px" height="50px"></td>
            <td><button onclick="edit(${pro.id})">修改</button><button onclick="del(${pro.id})">删除</button></td>
        </tr>
    </c:forEach>
</table>
<p align="center">
    <button onclick="lastPage($('#myDlist option:selected').val())">上一页</button>
    <button onclick="nextPage()">下一页</button>
</p>
<p align="center">跳转到第<input type="text" id="jump" style="width: 20px">页<button onclick="jumpPage()">点击跳转</button></p>
<p align="center">每页显示
    <select onchange="change(this)" id="myDlist">
        <option value="5"  ${pageSize==5?'selected':''}>5</option>
        <option value="10" ${pageSize==10?'selected':''}>10</option>
        <option value="15" ${pageSize==15?'selected':''}>15</option>
        <option value="20" ${pageSize==20?'selected':''}>20</option>
    </select>条数据
</p>
</body>
</html>
