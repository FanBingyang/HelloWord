<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">注册成功！</h1>
	<jsp:useBean id="user" scope="session" class="vote.service.User2"/>
	<h3>从后台获取的用户注册信息为：</h3>
	<p>姓名：<%=user.getUsername()%></p>
	<p>性别：<%=user.getSex() %></p>
	<p>年龄：<%=user.getAge() %></p>
	<p>密码：<%=user.getPassword() %></p>
	 
</body>
</html>