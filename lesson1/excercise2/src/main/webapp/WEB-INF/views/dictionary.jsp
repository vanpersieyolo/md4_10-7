<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2020
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>tìm từ</h1>
<form action="/dic" method="post">
    <p>nhập vào 1 từ</p>
    <input type="text" name="inputword">
    <input type="submit" value="chuyển đổi">
</form>
<input type="text" value="${word}">
</body>
</html>
