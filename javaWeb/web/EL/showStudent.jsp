<%@ page import="studentDemo.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Benjamin
  Date: 2019/5/13
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>show</title>
</head>
<body>
----------------Java代码--------------------<br>
id = <%=((Student)request.getAttribute("stu")).getSno()%><br>
name = <%=((Student)request.getAttribute("stu")).getSname()%><br>
age = <%=((Student)request.getAttribute("stu")).getSage()%><br>
address = <%=((Student)request.getAttribute("stu")).getSaddress()%><br>

-------------------EL----------------------<br>
id = ${requestScope.stu["sno"]}<br>
name = ${requestScope.stu.sname}<br>
age = ${requestScope.stu.sage}<br>
address = ${requestScope.stu.saddress}<br>

-------------------jstl----------------------<br>
<c:set target="${requestScope.stu}" property="sage" value="20"/>
id = <c:out value="${requestScope.stu.sno}" default="1" escapeXml=""/><br>
<%--这里没有null值，假装输出了默认值算了--%>
name = ${requestScope.stu.sname}<br>
age = ${requestScope.stu.sage}<br>
address = ${requestScope.stu.saddress}<br>

</body>
</html>
