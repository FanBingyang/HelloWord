<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/myJS.js"></script>
<title>验证用户名</title>
<script type="text/javascript">
//在文本框有失去焦点事件时调用的函数
/* 	function ckName(){
		//获取用户名
		var name = document.getElementsByTagName("input")[0];
		//alert(name.value);
		//创建XMLhttp对象
		var req = getXMLHttpRequest();
		
		//处理结果
		req.onreadystatechange=function(){
			if(req.readyState==4){//请求正常
				if(req.status==200){//服务器响应正常
					//alert(req.responseText);//得到返回结果
					var msg = document.getElementById("msg");
					if(req.responseText=="true"){
						msg.innerHTML = "<font color='red'>用户名已存在！</font>";//既可以设置内容，也可以设置样式
						//msg.innerText = "<font color='red'>用户名已存在！</font>";//这个不能用来设置样式
					}else{
						msg.innerHTML = "<font color='green'>用户名可以使用</font>";
					}
				}
			}
		}
		
		//创建连接
		req.open("get","${pageContext.request.contextPath}/ckNameServlet?name="+name.value);	
		
		//发送请求
		req.send(null);
	} */
	
	
	//没有给文本框直接注册失去焦点事件使用的函数
	window.onload = function(){
		//必须写在窗口加载完函数里，不然下面没有加载，所以取不出来nameElement
		var nameElement = document.getElementsByName("username")[0];
		
		nameElement.onblur = function()//给文本框直接注册失去焦点事件
		{
			
			var name = this.value;//this等价于nameElement
				
			//创建XMLhttp对象
			var req = getXMLHttpRequest();
			
			//处理结果
			req.onreadystatechange=function(){
				if(req.readyState==4){//请求正常
					if(req.status==200){//服务器响应正常
						//alert(req.responseText);//得到返回结果
						var msg = document.getElementById("msg");
						if(req.responseText=="true"){
							msg.innerHTML = "<font color='red'>用户名已存在！</font>";//既可以设置内容，也可以设置样式
						}else{
							msg.innerHTML = "<font color='green'>用户名可以使用</font>";
						}
					}
				}
			}
			
			//创建连接
			req.open("get","${pageContext.request.contextPath}/ckNameServlet?name="+name);	
			
			//发送请求
			req.send(null);
		}
	}
	
	

</script>
</head>
<body>
												<!-- onblur:给文本框添加失去焦点事件 -->
	<!--  用户名：<input type="text" name="username"  onblur="ckName()"><span id="msg"></span><br>-->
	用户名：<input type="text" name="username"><span id="msg"></span><br>
	密    码：<input type="password" name="pwd"><br>
</body>
</html>















