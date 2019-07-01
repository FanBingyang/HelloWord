<%@page import="HelloJSPServlet.student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		student stu = (student)request.getAttribute("s");
		//out.print(stu);	
		//out.print(stu.getName());
	%>
	
	<%-- ${s } --%><!-- ${s}==pageContext.findSttribute("s"); -->
	<%-- ${s.name } --%><!-- ${s.name}走的是getName()方法，并且它具有输出功能 -->
	<!-- EL表达式对于null空值，在页面显示空字符串"" -->
	<!-- 属性导航EL表达式 -->
	${s.city.address }<!-- ${s.city["address"] }登记于前面语句 -->
	
	
	
</body>
</html>