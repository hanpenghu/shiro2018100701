<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-07-17
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>登录成功页面</title>
</head>
<body>
登录成功 ! <shiro:principal property="username"/>
<hr/>
<shiro:hasPermission name="add">拥有add权限</shiro:hasPermission>
<hr/>
<shiro:hasPermission name="query">拥有query权限</shiro:hasPermission>
<hr/>
<shiro:hasPermission name="delete">拥有delete权限</shiro:hasPermission>
<hr/>
<shiro:hasPermission name="update">拥有update权限</shiro:hasPermission>
</body>
</html>
