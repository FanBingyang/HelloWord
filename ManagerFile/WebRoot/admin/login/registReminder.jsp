<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upReminder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
      var time=2;
      var timer;
      timer = setInterval(
             window.onload= function(){
                  var second = document.getElementById("second");
                  if(time>=1){
                     second.innerHTML = time;
                     time--;
                  }
                  else{
                       clearInterval(timer);//
                       location.href="${pageContext.request.contextPath}/admin/login/regist.jsp";
                  }
              },1000
              );
    </script>
	<style type="text/css">
	
	body{
     margin:0px;
     background-color:#EFF4F8; 
   }
      #container{
         background-color:#FFFFFF;
         border-radius:12px;
         width:100%;
         height:100%;
      }
      #page{
      width:100%;
      height:50px;
      background-color:#F6FAFF;
      text-align:center;
      padding-top:15px;
      }
	</style>

  </head>
    
  <body>
     <div id="container">
        <div id="page">
            <span style="font-size:26px">注册成功<span id="second" style="color:red;">2</span>秒后,自动跳转</span>
        </div>
     </div>
  </body>
 
</html>
