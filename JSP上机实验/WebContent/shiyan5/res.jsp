<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="vote.service.User" %>
<html>
<%
request.setCharacterEncoding("utf-8");

%>

<head>

<title>返回结果</title>

<style type="text/css">
h1{
font-family:宋体;
font-size:40px;
color:red;
margin-top:250px;
}
body{
background-image:url('2.png');
background-size:cover;
}
</style>

</head>
<body>
<h1 align="center"><%=request.getParameter("name") %>最喜欢的老师是<%=request.getParameter("teacher") %></h1>
</body>
</html>
