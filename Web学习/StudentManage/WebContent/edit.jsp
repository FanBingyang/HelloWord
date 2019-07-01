<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生页面</title>
</head>
<body>
	<form action="updateServlet" method="post">
	<!-- 设置一个框用来保存id，不显示在页面上，只是在提交表单的时候提交到后台 -->
		<input type="hidden" name="id" value="${stu.id }" >
		<table border="1" width="250">
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name" value="${stu.nam }"></td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
			<!--用c：if来判断单选框应该选中那个，分别为其加上判断条件，满足就在input标签里加上checked  -->
				<input type="radio" name="sex" value="男" <c:if test="${stu.sex=='男' }">checked</c:if>>男
				<input type="radio" name="sex" value="女" <c:if test="${stu.sex=='女'}">checked</c:if> >女
			</td>
		</tr>
		<tr>
			<td>专业</td>
			<td><input type="text" name="zhuanye" value="${stu.zhuanye }"></td>
		</tr>
		<tr>
			<td>班级</td>
			<td><input type="text" name="banji" value="${stu.banji }"></td>
		</tr>
		<tr>
			<td>学号</td>
			<td><input type="text" name="xuehao" value="${stu.xuehao }"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="更新"></td>
		</tr>
		</table>
	</form>
</body>
</html>