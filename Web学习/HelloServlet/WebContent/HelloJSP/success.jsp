<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	欢迎你：<%
		/* String userName=request.getParameter("userName");
		out.write(userName); */
		String userName=(String)session.getAttribute("name");
		out.write(userName);
	%>
	<a href="/HelloServlet/HelloJSP/home.jsp">跳转到主页</a>
</body>
</html>