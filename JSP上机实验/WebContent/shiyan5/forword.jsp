<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="vote.service.User" %>
<html>
<%
request.setCharacterEncoding("utf-8");

%>

<head>

<title>Title</title>

</head>
<body>
<jsp:useBean id="stu" class="vote.service.User" scope="application"/>
<%
	String name= stu.getUsername();
	String poem=request.getParameter("1");
%>


</body>
</html>