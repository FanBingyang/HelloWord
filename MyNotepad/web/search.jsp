<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<head>
		<meta charset="UTF-8">
		<title>在线笔记本</title>
		<%--为浏览器标签的标题前面加上图片--%>
		<link rel="Shortcut Icon" href="image/tb.ico" />
		<link rel="stylesheet" type="text/css" href="css/shouye.css"/>
		<link rel="stylesheet" type="text/css" href="css/search.css"/>
		<link rel="stylesheet" type="text/css" href="css/top.css"/>
	</head>
	<!--首页不显示水平滚动条，竖直滚动条自动-->
	<body scroll="no" style="overflow-x:hidden;overflow-y: auto;">
		<div id="top" class="bg_top">
			<div id="top_left">
				<img id="tubiao" src="image/tubiao.png"/>
				<span id="biaoti"><font face="STCaiyun">在线笔记本</font></span>
			</div>
			<div id="top_right">
				<a class="top_a" href="shouye?userid=${user.id}">首页&nbsp;<img src="image/shouye.png" width="20" height="20" /></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" name="sousuo" id="sousuo" placeholder="找笔记" style="height: 25px;font-size: 13px;"/>&nbsp;
				<a href="#" onclick="sousuo();return false;"><img src="image/sousuo.png" width="20" height="20" /></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="top_a" href="write.jsp">写笔记&nbsp;<img src="image/maobi.png" height="20"/></a>&nbsp;&nbsp;&nbsp;
				<a class="top_a" href="personal?userid=${user.id}">个人中心<img id="touxiang" src="${user.touxiang}" height="50" alt="个人中心" title="个人中心"></a>
			</div>
		</div>
		
		<div id="nav">
			<c:forEach items="${searchArticle}" var="sa">
				<div class="wenzhangList">
					<h3><a class="articleName" href="articleId?article_id=${sa.article_id}">${sa.article_name}</a></h3>
					<a href="userArticle?userId=${sa.author.id}">
						<img class="wenzhangList_touxiang" src="${sa.author.touxiang}" alt=""/>&nbsp;
						<span class="authorName">${sa.author.username}</span>
					</a>
					&nbsp;<span style="color: #6b6b6b;">|</span>&nbsp;
					<a href="lableArctile?lable=${sa.lable}"><span class="text">${sa.lable}</span></a>
					&nbsp;<span style="color: #6b6b6b;">|</span>&nbsp;
					<span class="text">${sa.article_time}</span>
					<hr style="color: #fcfcfc;"/>
				</div>
			</c:forEach>
            <%--判断从后台获取的数据集合是否为空，如果为空那就显示图片--%>
			<c:if test="${empty searchArticle}">
				<img src="image/null.png" id="null"/>
			</c:if>
		</div>
		
		<div id="foot" class="bg_bottom"></div>
	</body>
	
	
</html>
