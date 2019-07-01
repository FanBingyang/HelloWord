<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.Date" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>最简单的jsp页面</title>
</head>
<body>
<h3>JSP技术带你进入动态网页时代！</h3>
<%
	String st = "我将成为一名优秀的Java Web工程师！";
	String st1 = "一分耕耘一分收获，Are you ready?";
%>
<hr>
<%=st %>
<br>
<%=st1 %>
<hr>
<%Date date = new Date(); %>
<%=date %>
<%for(int i=1;i<=6;i++){ %>
<h<%=i%> align="center">欢迎访问最简单的jsp页面！ </h<%=i%>>
<%} %>
</body>
</html>