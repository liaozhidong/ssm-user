<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'success.jsp' starting page</title>
</head>

<body>
    <h1>${msg }</h1>
    <a href="${pageContext.request.contextPath }/Login.jsp">去登录</a>
</body>
</html>