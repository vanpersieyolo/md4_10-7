<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/7/2020
  Time: 8:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    lettuce<input type="checkbox" name="condiment" value="lettuce">
    tomato<input type="checkbox" name="condiment" value="tomato">
    mustard<input type="checkbox" name="condiment" value="mustard">
    sprouts<input type="checkbox" name="condiment" value="sprouts">
    <input type="submit">
</form>
gia vị đã chọn là: <c:forEach var="condiment" items="${condiment}">
    <c:out value="${condiment}"></c:out>
</c:forEach>
</body>
</html>
