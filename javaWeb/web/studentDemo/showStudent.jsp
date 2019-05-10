<%@ page import="java.util.List" %>
<%@ page import="studentDemo.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Benjamin
  Date: 2019/5/10
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>show student</title>
</head>
<body>
<table border="1px" style="padding: 1px;margin: 0">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>地址</th>
    </tr>
    <%
        List<Student> stus = (List<Student>) request.getAttribute("students");
        for (Student stu : stus) {%>
    <tr>
        <td><a href="/javaWeb/studentDemo/updateStudent.jsp?sno=<%=stu.getSno()%>">
            <%=stu.getSno()%>
        </a>
        </td>
        <td><%=stu.getSname()%>
        </td>
        <td><%=stu.getSage()%>
        </td>
        <td><%=stu.getSaddress()%>
        </td>
        <td><a href="/javaWeb/deleteStudentServlet?sno=<%=stu.getSno()%>">删除</a></td>
    </tr>
    <%
        }%>
</table>
<a href="/javaWeb/studentDemo/addStudent.html">添加学生信息</a>
<%
    //判断是否经历过删除、添加或更新
    Object error = request.getAttribute("delete");
    if (error != null) {
        String s = (String) error;
        if (s.equals("1")) {
            out.print("删除成功！");
        } else {
            out.print("删除失败！");
        }
    }
    error = request.getAttribute("add");
    if (error != null) {
        String s = (String) error;
        if (s.equals("1")) {
            out.print("增加成功！");
        } else {
            out.print("增加失败！");
        }
    }

    error = request.getAttribute("update");
    if (error != null) {
        String s = (String) error;
        if (s.equals("1")) {
            out.print("更新成功！");
        } else {
            out.print("更新失败！");
        }
    }
%>
</body>
</html>
