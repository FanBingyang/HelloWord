<%@page import="com.zls.domain.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function changeColor(){ 
	var color="#f00|#0f0|#00f|#880|#808|#088|green|blue|gray"; 
	color=color.split("|"); 
	document.getElementById("blink").style.color=color[parseInt(Math.random() * color.length)]; 
	} 
	setInterval("changeColor()",200); 
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
      #welcome{
      position:absolute;
      /*  margin-top:10px; */ 
      width:100%;
      height:50px;
      background-color:#F6FAFF;
      text-align:center;
      /* padding-top:15px; */
      }
      span{
        font-size:26px;
        font-weight:bold;
      }
   </style>
   
  </head>
  <body>
    <div id="container">
        <div id="welcome">
          <span id="blink">欢迎&nbsp;<%=((User)session.getAttribute("user")).getUsername() %>&nbsp;来到软创文件管理系统</span>
        </div>
    </div>
  </body>
</html>
