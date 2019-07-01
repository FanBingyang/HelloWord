<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP page</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String username=request.getParameter("username");
String password=request.getParameter("password");
String sex=request.getParameter("r");
String school=request.getParameter("s");
String course=request.getParameter("c");
String s="注册成功!欢迎你！ "+username+"<br><p>你所在的学院是："+school+"<br><p> 你选的课程是："+course+"";

out.println(s);
%>
</body>
</html>