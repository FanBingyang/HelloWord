<!DOCTYPE html>
<html lang="utf-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
	<meta charset="UTF-8">
	<title>在线笔记本-写笔记</title>
	<%--为浏览器标签的标题前面加上图片--%>
	<link rel="Shortcut Icon" href="image/tb.ico" />
	<link rel="stylesheet" type="text/css" href="css/top.css"/>
	<link rel="stylesheet" type="text/css" href="css/write.css"/>
	<script type="text/javascript" src="./ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="js/my.js" ></script>

</head>
<body style="background-color: #f4f4f4;">
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
	<div id="write">
		<p class="msg"><font face="STXingkai">快来写下今天的学习心得吧！</font></p>
		<form action="writeArticle"method="post">
			<%--隐藏框，用来往后台传递用户的id--%>
			<input type="hidden" name="user_id" value="${user.id}">
			<input type="text" class="bijibiaoti" name="biaoti" placeholder="输入笔记标题" autocomplete="off"/>
			<div id="ck">
				<textarea class="ckeditor" id="biji" name="biji"></textarea>
				<script type="text/javascript">CKEDITOR.replace('biji');</script>
			</div>
			<div class="qita">
				<span style="font-size: 20px;">笔记标签:&nbsp;&nbsp;</span>
				<select class="select" name="lable" size="1">
					<option value="其他" selected="selected">选择分类</option>
					<option value="计算机">计算机</option>
					<option value="数学">数学</option>
					<option value="文学">文学</option>
					<option value="英语">英语</option>
					<option value="医学">医学</option>
					<option value="法学">法学</option>
					<option value="经济学">经济学</option>
					<option value="社会学">社会学</option>
				</select>
				<input type="submit" class="submit" name="submit" id="submit" value="发布笔记" onclick='javascript:return save();' />
			</div>
		</form>
	</div>
	<div class="bg_bottom"></div>

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
