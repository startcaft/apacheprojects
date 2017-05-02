<%--
  Created by IntelliJ IDEA.
  User: startcaft
  Date: 2017/4/27
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>list</title>
</head>
<body>

    <h4>List Page</h4>
    <a href="logout">Logout</a>
    <hr/>

    Welcome:<shiro:principal></shiro:principal>

    <shiro:hasRole name="admin">
        <br>
        <a href="admin">Admin</a>
    </shiro:hasRole>

    <shiro:hasRole name="user">
        <br>
        <a href="user">User</a>
    </shiro:hasRole>

</body>
</html>
