<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
#div1{
width:540px;
border:1px solid black;
background-color:hsla(0, 0%, 0%, .4);
margin:250px auto;
}

</style>
</head>
<body>
<div id="div1">
<form id="loginForm" method="post" action="toupiao1.jsp">
<table style="margin:auto">
<tr><td colspan="2" align="center">
请输入用户名和密码
</td>
</tr>
<tr>
<td>用户名：</td>
 <td><input id="name" type="text" name="name" required></td>
 </tr>
<tr>
 <td> &nbsp;密&nbsp;&nbsp;码 ：</td>
<td><input id="pass" type="password" name="pass" required></td>
</tr>
<tr>
<td colspan="2" align="center">
<input id="sub" type="submit" value="提交"/>
<input type="reset" value="重设"/>
</td>
</tr>
</table>
</form>
</div>
</body>
</html>