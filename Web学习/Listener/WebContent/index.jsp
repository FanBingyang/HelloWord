<%@page import="domain.User"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My JSP 'index.jsp' starting page</title>
</head>
<body>
	My JSP 'index.jsp' starting page!<br>
	
	<%
		//session.invalidate();//使sesion销毁
		
		/* request.setAttribute("name", "tom");//添加。同时也是替换默认的属性
		request.setAttribute("name", "jerry");//替换上一个
		request.removeAttribute("name");//移除 */
		
		session.setAttribute("u", new User());
	%>
</body>
</html>





