<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: Benjamin
  Date: 2019/4/28
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show</title>
</head>
<body>
    <%
        //编码
        request.setCharacterEncoding("utf-8");
        out.print("用户名：" + request.getParameter("username") + "<br/>");
        out.print("密码：" + request.getParameter("password") + "<br/>");
        out.print("Emil：" + request.getParameter("emil") + "<br/>");
        out.print("身份证号码：" + request.getParameter("idNum") + "<br/>");
        out.print("爱好：" + Arrays.toString(request.getParameterValues("hobby")) + "<br/>");
    %>
</body>
</html>
