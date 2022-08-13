<%--
  Created by IntelliJ IDEA.
  User: 王斐
  Date: 2022/8/5
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="application/javascript" src="static/js/jquery.js"></script>
  <script>
        function getStr() {
            $.ajax({
                url:"/getS",
                success:function (d) {
                    console.log(d);
                }

            });
         };


        function getJson() {
            $.ajax({
                url:"/getJ",
                dataType:"json",
                success:function (d) {
                    console.log(d.id+"---"+d.name);
                }

            });
        };
        function listJson() {
            $.ajax({
                url:"/getL",
                dataType:"json",
                success:function (d) {
                    console.log(d);
                }

            });
        };

        function MapJson() {
            $.ajax({
                url:"/getMap",
                dataType:"json",
                success:function (d) {
                    console.log(d);
                }

            });
        };

        function MapJson() {
            $.ajax({
                url:"/getMaps",
                dataType:"json",
                success:function (d) {
                    console.log(d);
                }

            });
        };
  </script>
</head>
<body>
<h1>hello</h1>
<button onclick="getStr()">获取ajax</button>
<button onclick="getJson()">获取json对象</button>
<button onclick="listJson()">获取list</button>
<button onclick="MapJson()">获取map</button>
<button onclick="MapJson()">获取maps</button>

</body>
</html>

