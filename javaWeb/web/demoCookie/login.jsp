<%--
  Created by IntelliJ IDEA.
  User: Benjamin
  Date: 2019/5/4
  Time: 19:47
  To ChangeOff this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <%!
        String username = "";
    %>
    <%
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("userName")){
                username = cookie.getValue();
            }
        }
    %>
    <%-- 这里真的把我搞难受了，web不是我自己创建的文件夹，而是该应用默认的页面文件的地址，只需要加后面的路径就ok了 --%>
    <form action="/javaWeb/demoCookie/cookie.jsp" method="post">
        userName<input type="text" name="userName" value="<%=username%>">
        passWord<input type="password" name="passWord"/>
        <input type="submit" value="submit"/>
    </form>
</body>
</html>
