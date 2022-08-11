<%--
  Created by IntelliJ IDEA.
  User: 王斐
  Date: 2022/8/4
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("sname","张飞");
    request.getRequestDispatcher("/req").forward(request,response);
%>
</body>
</html>
