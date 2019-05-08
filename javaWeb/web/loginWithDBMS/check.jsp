<%@ page import="loginWithDBMS.Acc" %>
<%@ page import="loginWithDBMS.LoginDao" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Benjamin
  Date: 2019/5/7
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>check</title>
</head>
<body>
    <%
        int rtn = 0;
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        Acc acc = new Acc(uname,upwd);
        try {
            LoginDao login = new LoginDao("root", "litao.", "web");
            rtn = login.login(acc);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        if(rtn <= 0){
            out.print("error");
        }else{
            out.print("get it");
        }
    %>
</body>
</html>
