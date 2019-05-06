<%--
  Created by IntelliJ IDEA.
  User: Benjamin
  Date: 2019/5/4
  Time: 19:28
  To change this template use File | Settings | File Templates.

  练习Cookie的使用
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookie</title>
</head>
<body>
    <%
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("userName");
        String pwd = request.getParameter("passWord");

        //将数据缓存金Cookie
        Cookie cookieName = new Cookie("userName", name);
        Cookie cookiePwd = new Cookie("passWord", pwd);

        //添加Cookie
        response.addCookie(cookieName);
        response.addCookie(cookiePwd);

        //重定向回客户端
        response.sendRedirect("/javaWeb/demoCookie/show.jsp");
    %>
</body>
</html>
