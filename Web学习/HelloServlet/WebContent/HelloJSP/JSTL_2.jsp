
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
	 <c:if test="${5>3}">
		aaaaaaaaa
	</c:if>
	 <c:if test="${5<3}">
		bbbbbbbb
	</c:if>
	<br/>
	
	<c:set var="num" value="${1 }"></c:set>
	<!-- 以下是swich语句 -->
	<c:choose>
		<c:when test="${num==1 }">111</c:when>
		<c:when test="${num==2 }">222</c:when>
		<c:when test="${num==3 }">333</c:when>
		<c:otherwise>000</c:otherwise>
	</c:choose>
</body>
</html>