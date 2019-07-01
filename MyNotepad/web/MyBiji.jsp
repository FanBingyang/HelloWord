<!DOCTYPE html>
<html lang="utf-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta charset="UTF-8">
	<title>在线笔记本-我的笔记</title>
	<%--为浏览器标签的标题前面加上图片--%>
	<link rel="Shortcut Icon" href="image/tb.ico" />
	<link rel="stylesheet" type="text/css" href="css/top.css"/>
	<link rel="stylesheet" type="text/css" href="css/Mybiji.css"/>
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
	<h3>我的笔记</h3>
	<form action="userLable" method="post">
		<div class="lablecha">
			<a href="myBiji?authorId=${user.id}" class="all">原创</a>&nbsp;|&nbsp;
			<a href="others?user_id=${user.id}" class="all">转载</a>&nbsp;|&nbsp;
			<input type="hidden" name="userid" value="${user.id}">
			<input type="text" name="lable" class="chazhao" placeholder="输入标签" /><input type="submit" value="标签分类" style="height: 26px;"/>&nbsp;|&nbsp;
			<span>笔记数量</span>&nbsp;&nbsp;<span>${count}</span>&nbsp;&nbsp;
		</div>
	</form>
	<hr style="width: 820px;float: left;margin-left: 40px;margin-bottom: 20px;"/>
	<%--如果有文章，那么以表格的形式显示出来--%>
	<c:if test="${!empty MyBiji}">
		<table class="table gridtable" align="center" border="2">
			<tr>
				<th style="width: 320px;height: 40px;">笔记标题</th>
				<th style="width: 100px;height: 40px;">标签</th>
				<th style="height: 40px;">发表时间</th>
				<th style="width: 130px;height: 40px;">操作</th>
			</tr>
				<%--${mb:fmt("00",s.index + 1)}--%>
			<c:forEach items="${MyBiji}" var="mb" varStatus="s">
				<tr>
					<td style="width: 320px;height: 40px;"><a href="articleId?article_id=${mb.article_id}" id="articleName">${mb.article_name}</a></td>
					<td style="width: 100px;height: 40px;">${mb.lable}</td>
					<td style="height: 40px;">${mb.article_time}</td>
					<td style="width: 130px;height: 40px;"><a href="#" id="delete" onclick="doDelete(${user.id},${mb.article_id});return false;"><img id="scImg" width="20px" src="image/shanchu.png">&nbsp;删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<%--如果没有文章，那就显示该图片--%>
	<c:if test="${empty MyBiji}">
		<img src="image/null.png" id="null" width="300" height="300" style="margin-left: 250px;margin-top: 50px;"/>
	</c:if>
</div>
<div id="foot" class="bg_bottom"></div>


</body>
</html>
