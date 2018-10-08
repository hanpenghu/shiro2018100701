<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-07-17
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>user login</h1>
<form action="/test2/login" method="post">
    username:<input type="text" name="username">
    <p>
        password:<input type="password" name="password">
    <p>
        ${msg }
        <input type="submit" value="submit">
</form>
</body>
</html>
