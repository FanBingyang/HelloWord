<!DOCTYPE html>
<html lang="utf-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<head>
		<meta charset="UTF-8">
		<title>在线笔记本-个人中心</title>
		<%--为浏览器标签的标题前面加上图片--%>
		<link rel="Shortcut Icon" href="image/tb.ico" />
		<link rel="stylesheet" type="text/css" href="css/top.css"/>
		<link rel="stylesheet" type="text/css" href="css/PerCenter.css"/>
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="js/my.js"></script>
	</head>
	<body scroll="no" style="overflow-x:hidden;overflow-y: auto;background-color: #f5f6f7;">
	<div id="top" class="bg_top">
		<div id="top_left">
			<img id="tubiao" src="image/tubiao.png"/>
			<span id="biaoti"><font face="STCaiyun">在线笔记本</font></span>
		</div>
		<div id="top_right">
			<a class="top_a" href="shouye?userid=${user.id}">首页&nbsp;<img src="image/shouye.png" width="20" height="20" /></a>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" name="sousuo" id="sousuo" placeholder="找笔记" style="height: 25px;font-size: 13px;"/>&nbsp;
			<a href="#" onclick="sousuo();return false;"><img src="image/sousuo.png" width="20" height="20" />&nbsp;&nbsp;&nbsp;&nbsp;</a>
			<a class="top_a" href="write.jsp">写笔记&nbsp;<img src="image/maobi.png" height="20"/></a>&nbsp;&nbsp;&nbsp;
			<a class="top_a" href="personal?userid=${user.id}">个人中心<img id="touxiang" src="${user.touxiang}" height="50" alt="个人中心" title="个人中心"></a>
		</div>
	</div>
		
		<div id="left">
			<ul class="menu">
				<li><a href="personal?userid=${user.id}">个人资料</a></li>
				<hr/>
				<li><a href="userArticle?userId=${user.id}">我的主页</a></li>
				<hr/>
				<li><a href="myBiji?authorId=${user.id}">我的笔记</a></li>
			</ul>
		</div>
		
		<div id="right">
			<h3>个人资料</h3>
			<hr style="width: 800px;margin-left: 40px;"/>
			<div id="right_tx">
				<img id="tx" src="${user.touxiang}" />
				<input type="button" id="gh" value="更换头像" onclick="javascript:change();" style="margin-top: 20px;margin-left: 50px;width: 100px;height: 30px;cursor: pointer;"/>
				<%--以下是用于更换头像的提交表单--%>
				<form action="change" method="post" enctype="multipart/form-data">

					<input type="hidden" name="id" value="${user.id}"/>
					<input type="file" id="liulan" name="file" style="visibility: hidden;" />
					<input type="submit" id="queding" value="确定" style="visibility: hidden;"/>
					<input type="button" id="quxiao"  value="取消" style="visibility: hidden;" onclick="javascript:fanhui();" />
				</form>
			</div>
			<div id="right_xinxi">
				<!--autocomplete="off"的用法是清除文本框记忆的缓存，放在某个input里面就是指这个文本框不记忆，
				如果放到form中，就是整个表单的文本框都不记忆-->
				<form action="update" method="post" autocomplete="off">
					<table class="table">
						<tr height="50px">
							<td width="100px">昵称:</td>
							<td><input  class="text" type="text" name="username" value="${user.username}"></td>
						</tr>
						<tr>
							<td>性别:</td>
							<td><input class="text" type="text" name="sex" value="${user.sex}"></td>
						</tr>
						<tr>
							<td>年龄:</td>
							<td><input class="text" type="text" name="age" value="${user.age}"></td>
						</tr>
						<tr>
							<td>密码:</td>
							<td><input class="text" type="password" name="password" ></td>
						</tr>
						<tr><!-- 传递用户id,空出一行单元格，用来填充位置，将按钮往下压 -->
							<input type="hidden" name="id" value="${user.id}">
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="submit" id="submit" class="submit"  name="submit" value="保存" >
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		
		<div id="foot" class="bg_bottom"></div>
	<script type="text/javascript">
        //按钮动态
        $(".submit").hover(
            function() {
                $(".submit").css("background-color","red");
                $(".submit").css("color","white");
            },
            function() {
                $(".submit").css("background-color","white");
                $(".submit").css("color","red");
            });
	</script>
	</body>
</html>
