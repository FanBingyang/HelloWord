<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/HelloJSP/Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		//这里面声明的是全局变量
	%>
	<%="这相当于out.write()" %>
	<%
		//errorPage="/HelloJSP/Error.jsp"指定当该页面有错五的时候自动跳转到另一个页面，不至于报错
		int i = 10/0;
	%>
</body>
</html>