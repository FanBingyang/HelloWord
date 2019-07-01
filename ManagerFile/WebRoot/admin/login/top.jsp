<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	body{
	margin:0px;
	   background-color:#EFF4F8;
	}
	
	.top_img{
	 /* background-color:red;*/
	 position:absolute;
	  height:75;
	  width:100;
	  margin-top:10px;
	  margin-left:15px;
	  /*border:1px solid red;*/
	}
	.top_img img{
	  
	  height:80px;
	  width:100px;
	  /*border:1px solid green;*/
	}
	.title{
	  position:absolute;
	  height:80px;
	  width:800px;
	 /* background-color:red;*/
	  margin-left:120px;
	  margin-top:30px;
	}
	.title span{
	   font-size:36px;
	   color:#5058A3;
	   font-weight:900;
	}

	</style>

  </head>
  <body>
  <div class="">
      <div class="top_img">
         <img src="${pageContext.request.contextPath }/admin/images/topImg.png" >
      </div>
      <div class="title">
         <span>软件创新实验室文件管理系统</span>
      </div>
      
  </div>
  </body>
</html>
