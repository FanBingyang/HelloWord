<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 声明一个变量num -->
	<c:set var="num" value="10" scope="session"></c:set>
	
	输出变量：<c:out value="${num }"></c:out><br/>
	<!--移除变量  -->
	<c:remove var="num" scope="session"/>
	输出变量：<c:out value="${num }" default="默认值"></c:out>
	
</body>
</html>