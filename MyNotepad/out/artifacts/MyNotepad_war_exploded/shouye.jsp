<!DOCTYPE html>
<html lang="utf-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>在线笔记本</title>
		<%--为浏览器标签的标题前面加上图片--%>
		<link rel="Shortcut Icon" href="image/tb.ico" />
		<link rel="stylesheet" type="text/css" href="css/shouye.css"/>
		<link rel="stylesheet" type="text/css" href="css/top.css"/>
		<link rel="stylesheet" type="text/css" href="css/menu.css">
		<script type="text/javascript" src="js/jquery-3.3.1.js" ></script>
		<script type="text/javascript" src="js/my.js" ></script>


	</head>
	<!--首页不显示水平滚动条，竖直滚动条自动-->
	<body scroll="no" style="overflow-x:hidden;overflow-y: auto;" >
		<div id="top" class="bg_top">
			<div id="top_left">
				<img id="tubiao" src="image/tubiao.png"/>
				<span id="biaoti"><font face="STCaiyun">在线笔记本</font></span>
			</div>
			<div id="top_right">
				<a class="top_a" href="shouye?userid=${user.id}">首页&nbsp;<img src="image/shouye.png" width="20" height="20" /></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" name="sousuo" id="sousuo" placeholder="找笔记" style="height: 25px;font-size: 13px;"/>&nbsp;
				<a href="javascript:void(0);" onclick="sousuo()"><img src="image/sousuo.png" width="20" height="20" /></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="top_a" href="write.jsp">写笔记&nbsp;<img src="image/maobi.png" height="20"/></a>&nbsp;&nbsp;&nbsp;
				<a class="top_a" href="personal?userid=${user.id}">个人中心<img id="touxiang" src="${user.touxiang}" height="50" alt="个人中心" title="个人中心"></a>
			</div>
		</div>
		<div id="left">
			<nav>
				<ul>
					<li><a href="shouye?userid=${user.id}" data-hover="最新">最新</a></li>
					<li><a href="lableArctile?lable=计算机" data-hover="计算机">计算机</a></li>
					<li><a href="lableArctile?lable=数学" data-hover="数学">数学</a></li>
					<li><a href="lableArctile?lable=文学" data-hover="文学">文学</a></li>
					<li><a href="lableArctile?lable=英语" data-hover="英语">英语</a></li>
					<li><a href="lableArctile?lable=医学" data-hover="医学">医学</a></li>
					<li><a href="lableArctile?lable=法学" data-hover="法学">法学</a></li>
					<li><a href="lableArctile?lable=经济学" data-hover="经济学">经济学</a></li>
					<li><a href="lableArctile?lable=社会学" data-hover="社会学">社会学</a></li>
					<li><a href="lableArctile?lable=其他" data-hover="其他">其他</a></li>
				</ul>
			</nav>
		</div>

		<div id="right">
			<%--
			下面记得这些笔记最终没有用上，因为总是报错，暂未找到解决办法search.html
				用<c:forEach items="labeArticles" var="la" varStatus="i">遍历后台传输过来的数据集合
				items:后台传输的数据集合
				var:定义临时变量
				varStatus:定义类似计数的变量
				遍历后台传输的第二个数据集合时用${authors[i-1].touxiang}
				authors时第二个数据集合，.头像是其集合中元素的一个属性
			--%>
			<c:forEach items="${labeArticles}" var="la" varStatus="i">
				<div class="wenzhangList">
					<h3><a class="articleName" href="articleId?article_id=${la.article_id}">${la.article_name}</a></h3>
					<a href="userArticle?userId=${la.author.id}">
						<img class="wenzhangList_touxiang" src="${la.author.touxiang}" alt=""/>&nbsp;
						<span class="authorName">${la.author.username}</span>
					</a>
					&nbsp;<span style="color: #6b6b6b;">|</span>&nbsp;
					<a href="lableArctile?lable=${la.lable}"><span class="text">${la.lable}</span></a>
					&nbsp;<span style="color: #6b6b6b;">|</span>&nbsp;
					<span class="text">${la.article_time}</span>
					<hr style="color: #fcfcfc;"/>
				</div>
			</c:forEach>
            <%--判断从后台获取的数据集合是否为空，如果为空那就显示图片--%>
            <c:if test="${empty labeArticles}">
                <img src="image/null.png" id="null" width="300" height="300" style="margin-left: 450px;margin-top: 100px;"/>
            </c:if>
		</div>
		<div id="foot" class="bg_bottom"></div>

    <script type="text/javascript">
        /*左侧菜单点击事件*/
        $(function(){
            var caidan=$("menu").find("li");
            caidan.click(function(){
                //改变所选元素的背景色
                $(this).css("background-color","skyblue");
                //恢复同一级元素的原有色
                $(this).siblings().css("background-color","azure");
            });
        })
    </script>
	</body>
	
	
</html>
