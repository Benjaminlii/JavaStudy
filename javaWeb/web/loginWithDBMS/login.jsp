<%--
  Created by IntelliJ IDEA.
  User: Benjamin
  Date: 2019/5/7
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="/javaWeb/Login" method="post">
    用户名：<label>
    <input type="text" name="uname"><br>
</label>
    密码：<label>
    <input type="password" name="upwd"><br>
</label>
    <input type="submit" value="登陆">
</form>
</body>
</html>
