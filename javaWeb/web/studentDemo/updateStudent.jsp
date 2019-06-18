<%@ page import="studentDemo.entity.Student" %>
<%@ page import="studentDemo.dao.StudentDao" %><%--
  Created by IntelliJ IDEA.
  User: Benjamin
  Date: 2019/5/11
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update studentCustom</title>
</head>
<body>
<%Student stu = StudentDao.findStudentBySno(Integer.valueOf(request.getParameter("sno")));%>
<form action="/javaWeb/updateStudentServlet" method="post">
    学号：<label>
    <input type="text" name="sno" value="<%=stu.getSno()%>" readonly="readonly">
</label><br>
    姓名：<label>
    <input type="text" name="sname" value="<%=stu.getSname()%>">
</label><br>
    年龄：<label>
    <input type="text" name="sage" value="<%=stu.getSage()%>">
</label><br>
    地址：<label>
    <input type="text" name="saddress" value="<%=stu.getSaddress()%>">
</label><br>
    <input type="submit">
</form>
</body>
</html>
