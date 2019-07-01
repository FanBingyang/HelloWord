<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function changeCode(){
		//得到图片元素
		var img = document.getElementsByTagName("img")[0];
		//img.setAttribute("src","/HelloServlet/httpdemo4");//XML Dom语法
		img.src="/HelloServlet/CodeServlet?time="+new Date().getTime();
}
</script>
</head>
<body>
	<%
		String msg = (String)request.getAttribute("msg");
		if(msg!=null){
			out.print(msg);
		}
		
	%>
	<form action="/HelloServlet/Dologin_1" method="post">
		用户名：<input type="text" name="userName"/><br>
		密码：<input type="password" name="pwd"/><br>
		验证码：<input type="text" name="code"/>
			<img alt="验证码" src="/HelloServlet/CodeServlet" onclick="changeCode()"/>
			<a href="javascript:changeCode()" >看不清，换一张</a><br>
		<input type="submit" value="登录"/><br>
	</form>
</body>
</html>