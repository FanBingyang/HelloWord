<!DOCTYPE html>
<html lang="utf-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta charset="UTF-8">
	<title>在线笔记本</title>
	<%--为浏览器标签的标题前面加上图片--%>
	<link rel="Shortcut Icon" href="image/tb.ico" />
	<link rel="stylesheet" type="text/css" href="css/top.css"/>
	<link rel="stylesheet" type="text/css" href="css/gerenzhuye.css"/>
	<script type="text/javascript" src="js/my.js" ></script>
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
			<a href="#" onclick="sousuo();return false;"><img src="image/sousuo.png" width="20" height="20" />&nbsp;&nbsp;&nbsp;&nbsp;</a>
			<a class="top_a" href="write.jsp">写笔记&nbsp;<img src="image/maobi.png" height="20"/></a>&nbsp;&nbsp;&nbsp;
			<a class="top_a" href="personal?userid=${user.id}">个人中心<img id="touxiang" src="${user.touxiang}" height="50" alt="个人中心" title="个人中心"></a>
		</div>
	</div>

	<div id="left">
		<div id="per">
			<img src="${author.touxiang}" id="toux"/>
			<p class="xingming"><a style="font-family: STXingKai;font-size: 20px;" href="userArticle?userId=${author.id}">${author.username}</a></p>
			<hr style="color: #fcfcfc;"/>
			<p class="fenlei"><a href="userArticle?userId=${author.id}" >原创</a>&nbsp;&nbsp;
				<a href="#">${count}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="zhuanZaiArticle?user_id=${author.id}" >转载</a>&nbsp;&nbsp;
				<a href="#" >${zhuanzai}</a>
			</p>
		</div>

		<div class="kongbai"></div>

		<div class="wenTui">
			<div class="fubiaoti">作者最新文章</div>
			<div class="wenTuiList">
				<c:forEach items="${authorZuixin}" var="azx">
					<p><a href="articleId?article_id=${azx.article_id}">${azx.article_name}</a></p>
				</c:forEach>
				<c:if test="${empty authorZuixin}">
					<img src="image/null.png" id="null" width="183" height="183" style="margin-left: 45px;"/>
				</c:if>
			</div>
		</div>

		<div class="kongbai"></div>

		<div class="wenTui">
			<div class="fubiaoti">热门文章</div>
			<div class="wenTuiList">
				<c:forEach items="${tuijian}" var="tj">
					<p><a href="articleId?article_id=${tj.article_id}">${tj.article_name}</a></p>
				</c:forEach>
				<c:if test="${empty tuijian}">
					<img src="image/null.png" id="null" width="183" height="183" style="margin-left: 45px;"/>
				</c:if>
			</div>
		</div>
	</div>

	<div id="right">
		<div class="wenzhangList">
			<h3><a href="#">${article.article_name}</a></h3>
			<a href="lableArctile?lable=${article.lable}"><span class="text">${article.lable}</span></a>
			&nbsp;<span style="color: #6b6b6b;">|</span>&nbsp;
			<span class="text">${article.article_time}</span>
			<%--用el表达式判断文章作者和用户是否是同一个人，如果不是就可以显示转载按钮
				el表达式中 eq为等于，ne是不等于
			--%>
			<c:if test="${author.id ne user.id}">
				<form action="zhuanzai" method="post" style="float: right;">
					<input type="hidden" name="article_id" value="${article.article_id}">
					<input type="hidden" name="user_id" value="${user.id}">
					<input class="zhuangzai" type="submit" value="转载"  onclick='javascript:return zhuanzai();'/>
				</form>
			</c:if>
			<hr style="color: #fcfcfc;margin-top: 10px;"/>
		</div>
		<div id="neirong" style="height: auto;margin-left: 20px;">
			<%--获取文本内容，并显示--%>
			${article.content}
		</div>
	</div>

	<div id="foot" class="bg_bottom"></div>


</body>

	
</html>
