<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生页面</title>
</head>
<body>
	<form action="addServlet" method="post">
		<table border="1" width="250">
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<input type="radio" name="sex" value="男">男
				<input type="radio" name="sex" value="女">女
			</td>
		</tr>
		<tr>
			<td>专业</td>
			<td><input type="text" name="zhuanye"></td>
		</tr>
		<tr>
			<td>班级</td>
			<td><input type="text" name="banji"></td>
		</tr>
		<tr>
			<td>学号</td>
			<td><input type="text" name="xuehao"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="添加"></td>
		</tr>
		</table>
	</form>
</body>
</html>