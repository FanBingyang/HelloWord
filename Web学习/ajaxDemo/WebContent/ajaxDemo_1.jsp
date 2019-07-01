<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 导入外部js文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/myJS.js"></script>
<title>Insert title here</title>
</head>
	<script type="text/javascript">
		window.onload = function(){
			//1，得到一个XMLHtttp对象
			var req = getXMLHttpRequest();
			
			//4，处理相应结果
			req.onreadystatechange = function () {
				//alert(req.readyState);//查看当前客户端状态
				if(req.readyState==4){
					//alert(req.status);//查看服务器端相应状态
					if(req.status==200){//说明服务器响应正常
						alert(req.responseText);//获取服务器返回的文本
					}
					
				}
			}
			
			
			//2，建立一个连接
			req.open("get","${pageContext.request.contextPath}/servletDemo_1");
			//3，发送请求
			req.send(null);
			
			
			
			
			
		}
		
		
	</script>
<body>

</body>
</html>