<%@page import="HelloJSPServlet.student"%>
<%@page import="com.sun.xml.internal.ws.client.Stub"%>
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
		/* 1 */student stu = new student();
		/* 2 */stu.setName("tom");
		
		/* 3 */out.write(stu.getName());
		
		/* 4 */ //request.getRequestDispatcher("/HelloJSP/time.jsp").forward(request, response);
	%>
	
	<!-- 以下代码分别对应等价于上面Java代码，以下代码是用于给前端美工人员展示 -->
	<%-- 1 --%><jsp:useBean id="stu1" class="HelloJSPServlet.student"></jsp:useBean>
	<%-- 2 --%><jsp:setProperty property="name" name="stu1" value="tommm"/>
	<%-- 3 --%><jsp:getProperty property="name" name="stu1"/>
	<%-- 4 --%><jsp:forward page="/HelloJSP/time.jsp"></jsp:forward>
	
	<!--http://localhost:8080/HelloServlet/HelloJSP/login1.jsp?name=123,pwd=111 -->
	<!-- 要访问以上url，代码表示如下 -->
	<jsp:forward page="/HelloJSP/login1.jsp">
		<jsp:param value="123" name="name"/>
		<jsp:param value="111" name="pwd"/>
	</jsp:forward>
	
	
</body>
</html>