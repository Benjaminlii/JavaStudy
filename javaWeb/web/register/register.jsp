<%--
  Created by IntelliJ IDEA.
  User: Benjamin
  Date: 2019/4/28
  Time: 22:12
  To ChangeOff this template use File | Settings | File Templates.
--%>
<%--
  使用一个注册并展示信息的demo练习Servlet和JSP的知识点
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>loginWithDBMS</title>
</head>
<body>
<form action="show" method="post">
    用户名：<label>
    <input type="text" name="username">
</label><br/>
    密码：<label>
    <input type="password" name="password">
</label><br/>
    Emil：<label>
    <input type="text" name="emil">
</label><br/>
    身份证号码：<label>
    <input type="text" name="idNum">
</label><br/>
    爱好：<br/>
    <!-- 多选框需要设置每一个选项的value -->
    <label>
        <input type="checkbox" name="hobby" value="电影">
    </label>电影
    <label>
        <input type="checkbox" name="hobby" value="音乐">
    </label>音乐
    <label>
        <input type="checkbox" name="hobby" value="跑步">
    </label>跑步
    <label>
        <input type="checkbox" name="hobby" value="游戏">
    </label>游戏
    <input type="submit" value="注册">
</form>
</body>
</html>
