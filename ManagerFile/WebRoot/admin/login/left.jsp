<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>...........</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <script type="text/javascript" src="${pageContext.request.contextPath }/admin/js/jquery-3.3.1.min.js" ></script>
   <!--导入自定义js文件-->
   <script type="text/javascript" src="${pageContext.request.contextPath }/admin/js/navMenu.js" ></script>
   <!--导入自定义css-->
   <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/navMenu.css" />
   <!--导入Font Awesome图标字库css文件-->
   <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/font-awesome.min.css" />
   <script type="text/javascript">
     function show(id){
       var div = document.getElementById(id);
       div.style.background="#F2F2F2";
 
     }
     function back(id){
       var div = document.getElementById(id);
       div.style.background="#FFFFFF";
     
     }
   </script>
   <style type="text/css">
   *{
      margin:0px;
      padding:0px;
   }
			.navMenuBox{
			    padding-top:15px;
				width: 200px;
				height: 500px;
			}
   </style>
  </head>
  
  <body>
 <!--包裹层-->
		<div class="navMenuBox">
			<!--一级菜单-->
			<ul class="navMenu">
				
				<li>
				   <div id="div1" onMouseover="show('div1')" onMouseout="back('div1')" class="arrow" style="cursor: pointer;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;文件管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;></div>
				   <!-- 子菜单 -->
				   <ul class="subMenu">
				       <li><a href="${pageContext.request.contextPath}/fileListServlet?fileType=storeFile" target="mainFrame">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所有文件</li>
				       <li><a href="${pageContext.request.contextPath }/fileListServlet?fileType=calcuFile" target="mainFrame">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计赛文件</a></li>
				       <li><a href="${pageContext.request.contextPath }/fileListServlet?fileType=blueFile" target="mainFrame">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;蓝桥杯文件</a></li>
				   </ul>
				</li>
				<li>
					<!--arrow类给具有下级菜单项添加箭头图标-->
					<div id="div2" onMouseover="show('div2')" onMouseout="back('div2')" class="arrow" style="cursor: pointer;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;></div>
					<!--子菜单-->
					<ul class="subMenu">
						<li><a href="${pageContext.request.contextPath }/admin/products/userManager.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户管理</a></li>
						<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;角色管理</a></li>
						<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;权限管理</a></li>
						<!-- <li>
							<div class="arrow" id="div1_div">&nbsp;&nbsp;我的任务</div>
							
							<ul class="subMenu">
								<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;任务一</a></li>
								<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;任务二</a></li>
								<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;任务三</a></li>
								<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;任务四</a></li>
							</ul>
						</li> -->
					</ul>
				</li>
				<li>
					<div id="div3" onMouseover="show('div3')" onMouseout="back('div3')" class="arrow" style="cursor: pointer;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;网站管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;></div>
					<!--子菜单-->
					<ul class="subMenu">
						<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;网站设置</a></li>
						<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;友情链接</a></li>
						<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分类管理</a></li>
						<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系统日志</a></li>
					</ul>
				</li>
			</ul>
			</ul>
		</div>
  </body>
</html>
