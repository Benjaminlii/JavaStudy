<%--
  Created by IntelliJ IDEA.
  User: Benjamin
  Date: 2019/5/12
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upAndDown</title>
</head>
<body>
<form action="/javaWeb/upServlet" method="post" enctype="multipart/form-data">
    学号：<input type="text" name="sno"><br>
    姓名：<input type="text" name="sname"><br>
    上传照片：<input type="file" name="spacture"><br>
    <input type="submit" value="提交"><br>
    <a href="/javaWeb/downServlet?filename=picture.jpg">pacture</a>

</form>
</body>
</html>
