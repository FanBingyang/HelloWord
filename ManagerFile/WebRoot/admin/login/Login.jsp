<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/css/regist.css">

  <script type="text/javascript" src="${pageContext.request.contextPath }/admin/js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript">
$(function(){
	$(".screenbg ul li").each(function(){
		$(this).css("opacity","0");
	});
	$(".screenbg ul li:first").css("opacity","1");
	var index = 0;
	var t;
	var li = $(".screenbg ul li");	
	var number = li.size();
	function change(index){
		li.css("visibility","visible");//visibility 属性设置元素框是否可见。
		li.eq(index).siblings().animate({opacity:0},2000);/*siblings()查找每个 p 元素的所有类名为 "selected" 的所有同胞元素*/
		                                                  /*$("p").siblings(".selected").css("background", "yellow");*/
		li.eq(index).animate({opacity:1},2000);/*li为index的那个元素*/
	}
	function show(){ 
		index = index + 1;
		if(index<=number-1){
			change(index);
		}else{
			index = 0;
			change(index);
		}
	}
	t = setInterval(show,4000);
	//根据窗口宽度生成图片宽度
	var width = $(window).width();
	$(".screenbg ul img").css("width",width+"px");
});
</script>
</head>
  <body>
    <div class="login-box">
	<h1>文件系统后台登录</h1>
	<form method="post" action="${pageContext.request.contextPath }/loginServlet">
		<div class="name">
			<label>管理员账号：</label>
			<input type="text" name="username" id="" tabindex="1" autocomplete="off" />
		</div>
		<div class="password">
			<label>密  码：</label>
			<input type="password" name="userpass" maxlength="16" id="" tabindex="2"/>
		</div>
		<%-- <div class="code">
			<label>验证码：</label>
			<input type="text" name="" maxlength="4" id="code" tabindex="3"/>
			<div class="codeImg">
				<img src="${pageContext.request.contextPath }/admin/images/captcha.jpeg.jpg" />
			</div>
		</div> --%>
		<div class="remember">
			<input type="checkbox" name="aotu_login" id="remember" tabindex="4">
			<label>记住密码</label>
		</div>
		<div class="login">
			<button type="submit" tabindex="5">登录</button>
		</div>
	</form>
</div>
<!--
<div class="bottom">©2014 Leting <a href="javascript:;" target="_blank">关于</a> <span>京ICP证030173号</span><img width="13" height="16" src="images/copy_rignt_24.png" />
</div>
-->
<div class="screenbg">
	<ul>
		<li><a href="javascript:;"><img src="${pageContext.request.contextPath }/admin/images/0.jpg"></a></li>
		<li><a href="javascript:;"><img src="${pageContext.request.contextPath }/admin/images/1.jpg"></a></li>
		<li><a href="javascript:;"><img src="${pageContext.request.contextPath }/admin/images/2.jpg"></a></li>
	</ul>
</div>
  </body>
</html>

