<%--
  Created by IntelliJ IDEA.
  User: Benjamin
  Date: 2019/4/28
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%--
  使用一个注册并展示信息的demo练习Servlet和JSP的知识点
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <form action="show" method="post">
        用户名：<input type="text" name="username"><br/>
        密码：<input type="password" name="password"><br/>
        Emil：<input type="text" name="emil"><br/>
        身份证号码：<input type="text" name="idNum"><br/>
        爱好：<br/>
        <!-- 多选框需要设置每一个选项的value -->
        <input type="checkbox" name="hobby" value="电影">电影
        <input type="checkbox" name="hobby" value="音乐">音乐
        <input type="checkbox" name="hobby" value="跑步">跑步
        <input type="checkbox" name="hobby" value="游戏">游戏
        <input type="submit" value="注册">
    </form>
</body>
</html>
