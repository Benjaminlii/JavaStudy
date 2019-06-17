<%@ page import="po.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Benjamin
  Date: 2019/6/17
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FindStudent</title>
</head>
<body>

<table border="1px" style="padding: 1px;margin: 0">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
    <%
        List<Student> stus = (List<Student>) request.getAttribute("students");
        for (Student stu : stus) {%>
    <tr>
        <td><%=stu.getSno()%>
        </td>
        <td><%=stu.getSname()%>
        </td>
        <td><%=stu.getSage()%>
        </td>
    </tr>
    <%
        }%>
</table>

</body>
</html>
