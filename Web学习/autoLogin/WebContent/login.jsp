<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${msg }
	<form action="${pageContext.request.contextPath }/loginServlet">
		用户名：<input type="text" name="username"><br>
		 密 码：<input type="text" name="password"><br>
		<input type="checkbox" name="autologin">自动登录<br>
		<input type="submit" value="登录"><br>
	</form>
</body>
</html>