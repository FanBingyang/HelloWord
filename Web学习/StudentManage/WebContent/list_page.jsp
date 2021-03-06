<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表页</title>
<script type="text/javascript">
	
	function doDelete(id) {
		var flag = confirm("是否确定删除？");
		/* 如果这里用户点击的是确定，就马上请求Servlet */
		if(flag){
			//表明点击了确定，访问Servlet，在当前页面打开超链接
			//window.location.href="deleteServlet?id="+id;//等价于下一句
			location.href="deleteServlet?id="+id;
		}
	}
</script>
<style type="text/css">
	a{
		text-decoration: none/* 清除超链接的下划线 */
	}
</style>

</head>
<body>
	<form action="searchStudentServlet" method="post">
		<table border="1" width="700">
		<tr>
			<td colspan="7">
				按姓名查询<input type="text" name="nam">&nbsp;&nbsp;
				按性别查询<select name="sex">
							<option value="">--请选择--</option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select>&nbsp;&nbsp;&nbsp;
				<input type="submit" value="查询">&nbsp;
				<a href="add.jsp" >添加</a>
			</td>
		</tr>
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>专业</td>
			<td>班级</td>
			<td>学号</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pageBean.list }" var="stu">
			<tr align="center">
				<td>${stu.id }</td>
				<td>${stu.nam }</td>
				<td>${stu.sex }</td>
				<td>${stu.zhuanye }</td>
				<td>${stu.banji }</td>
				<td>${stu.xuehao }</td>							<!-- 再给a标签设置点击事件时，在调用函数的后面加上return false；页面不发生跳转，执行后还是在页面的当前位置 -->
				<td><a href="editServlet?id=${stu.id }">更新</a> | <a href="#"" onclick="doDelete(${stu.id});return false;">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7">
				第 ${pageBean.currentPage }/ ${pageBean.totalPage }页 &nbsp;&nbsp;
				每页显示${pageBean.pageSize }条&nbsp;
				总记录数${pageBean.totalSize }条&nbsp;
				<c:if test="${pageBean.currentPage != 1 }">
					<a href="studentListPageServlet?currentPage=1">首页</a> | <a href="studentListPageServlet?currentPage=${pageBean.currentPage - 1}">上一页</a>
				</c:if>
				页数&nbsp;
				<c:forEach begin="1" end="${pageBean.totalPage }" var="i">
					<c:if test="${pageBean.currentPage == i }">
						${i }
					</c:if>
					
					<c:if test="${pageBean.currentPage != i }">
						<a href="studentListPageServlet?currentPage=${i }">${i }</a>
					</c:if>
					&nbsp;
				</c:forEach>
				<c:if test="${pageBean.currentPage !=  pageBean.totalPage}">
					<a href="studentListPageServlet?currentPage=${pageBean.currentPage + 1}">下一页 </a>| <a href="studentListPageServlet?currentPage=${pageBean.totalPage}">[尾页]</a>
				</c:if>
				
			</td>
		</tr>
		</table>
	</form>
</body>
</html>