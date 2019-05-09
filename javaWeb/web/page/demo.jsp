<%--
  Created by IntelliJ IDEA.
  User: Benjamin
  Date: 2019/4/26
  Time: 17:06
  To ChangeOff this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demoJSP</title>
</head>
<body>
<%
    out.println(request.getParameter("name") +
            ", " +
            request.getParameter("id"));
%>
</body>
</html>
