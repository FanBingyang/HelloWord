<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- forEach:普通for循环  var="i"：声明一个变量i begin="1"：变量的初始值   end="10"：变量的最终值    step="1"：步长，相当于i=i+1 -->
	<c:forEach var="i" begin="1" end="10" step="1">
		${i }<br/>
	</c:forEach>
	
	
	<%
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		request.setAttribute("list", list);
	%>
	<!-- 高级for循环，items：集合，var：循环内的变量 -->
	<c:forEach items="${list }" var="l" >
		${l }<br/>
	</c:forEach>
	
	
</body>
</html>