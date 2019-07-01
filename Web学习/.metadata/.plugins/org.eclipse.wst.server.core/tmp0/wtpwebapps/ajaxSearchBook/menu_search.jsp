<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/my.js">
</script>
<script type="text/javascript">

	window.onload = function(){
		//得到搜索框 对象
		var searchElement = document.getElementById("name");
		//得到显示板的div元素
		var div = document.getElementById("context1");
		
		
		searchElement.onkeyup = function(){//给文本框注册按键抬起事件
			//获取文本框的值
			var name = this.value;
		
			//搜索框没有值时隐藏显示板div
			if(name==""){
				div.style.display="none";
				return;
			}
		
			//1.获取XMLHttpRequest对象
			var xhr = getXMLHttpRequest();
			
			//处理结果
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4)
					if(xhr.status==200){
						var str = xhr.responseText;//得到服务器返回的数据
						
						var ss = str.split(",");
						var chilDivs="";
						//循环把数据放进小的div中
						for(var i=0;i<ss.length;i++){
							chilDivs+="<div onclick='writeText(this)' onmouseover='changeBackground_over(this)' onmouseout='changeBackground_out(this)'>"+ss[i]+"</div>"
						}
						div.innerHTML=chilDivs;
						div.style.display="block";
					}
			}
			
			
			xhr.open("get","${pageContext.request.contextPath}/searchBookAJAXServlet?name="+name+"&time="+new Date().getTime());//在最后加上实时时间，防止数据一样不发送数据
			
			xhr.send(null);
		}
	}
	
	function changeBackground_over(div) {
		div.style.backgroundColor = "gray";
	}
	
	function changeBackground_out(div) {
		div.style.backgroundColor = "";
	}
	
	//填充文本到搜索框
	function writeText(div) {
		//得到搜索框
		var searchElement = document.getElementById("name");
		searchElement.value = div.innerHTML;
		div.parentNode.style.display="none";//把父级div（context1）隐藏
	}
	
</script>

<div id="divmenu">
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=文学">文学</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=生活">生活</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=计算机">计算机</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=外语">外语</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=经营">经管</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=励志">励志</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=社科">社科</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=学术">学术</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=少儿">少儿</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=艺术">艺术</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=原版">原版</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=科技">科技</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=考试">考试</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=生活百科">生活百科</a>
	<a href="${pageContext.request.contextPath}/showProductByPage"
		style="color:#FFFF00">全部商品目录</a>
</div>
<div id="divsearch">
	<form action="${pageContext.request.contextPath}/findProductBySearch"
		method="post">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td style="text-align:right; padding-right:220px">
				Search <input
					type="text" name="name" class="inputtable" 
					id="name" /> 
					<input type="image" src="images/serchbutton.gif"
					border="0" style="margin-bottom:-4px">
				</td>
			</tr>
		</table>

	</form>
</div>
<div id="context1" style="display:block;background-color:white; width: 128px;position:absolute;left:810px;top: 135px">
	
</div>














