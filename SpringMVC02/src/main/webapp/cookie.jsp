<%--
  Created by IntelliJ IDEA.
  User: 王斐
  Date: 2022/8/4
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie cookie = new Cookie("hobby","football");
    response.addCookie(cookie);
    request.getRequestDispatcher("/cookie").forward(request,response);
%>
</body>
</html>
