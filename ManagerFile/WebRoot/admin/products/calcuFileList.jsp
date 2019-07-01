<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!--  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/css/search.css" />-->
	<link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
     <script type="text/javascript">
         function checkAll(){
			  //得到ckAll元素，并得到它的选中状态
			  var flag = docunment.getElementById("ckAll").checked;
			  alert(flag);
			  //得到所有复选框ids的元素
			  var ids =  document.getElementsByName("ids");
			  //循环给每个复选框赋值
			  for(var i=0;i<ids.length();i++){
			    ids[i].checked = flag;//把ckAll元素的状态赋值给每一个ids[i]的元素
			  }
		}
    </script>
   <style type="text/css">
   * {
           box-sizing: border-box;
        }
    body{
     margin:0px;
     background-color:#EFF4F8; 
    }
    #container{
         background-color:#FFFFFF;
         border-radius:12px;
         width:100%;
         height:800px;
     }
     
     #top{
       position:absolute;
       width:100%;
       height:100px;
       /* background-color:#3B8CFF; */
       margin-top:20px;
     }
/*---------------搜索框--------------------------------*/    
     #top_2{
       posiition:absolute;
       width:500px;
       height:70px;
       margin-left:750px;
       /*margin-top:7px;*/
       /*background-color:red;*/
     }
     
      #top3{
			position:absolute;
			width: 370px;
			height: 120px;
			margin: 0 auto;
			/*background-color:green;*/
			/*border:2px solid yellow;*/
			margin-left:80px;
		}
        .top3 div.search {padding: 2px 0;}
        .top3 form {
            position: relative;
            width: 300px;
            margin: 0 auto;
        }
        .top3 input, button {
            border: none;
            outline: none;
        }
        .top3 input {
            width: 100%;
            height: 42px;
            padding-left: 13px;
        }
        .button {
            height: 42px;
            width: 42px;
            cursor: pointer;
            position: absolute;
        }
        
        
        /*搜索框*/
        .bar1 {background: #B46381;}
		.bar1 form {
            height: 42px;
        }
        .bar1 input {
            /*border: 2px solid #7BA7AB;*/
            border-radius: 5px;
            /*background: #F9F0DA;
            color: #9E9C9C;*/
			border-bottom: 2px solid transparent;
			background: transparent;
            transition: .3s linear;
        }
		.bar1 input:focus {
            width: 300px;
            z-index: 1;
            border-bottom: 2px solid #F9F0DA;
        }
        .bar1 button {
            top: 0;
            right: 0;
            background: #683B4D;
            border-radius: 0 5px 5px 0;
        }
        .bar1 button:before {
           content: "\f002";
            font-family: FontAwesome;
            font-size: 16px;
            color: #F9F0DA;
        } 
        
        
   /*------------------------------------------------*/
/*--------------------------上传文件样式-----------------------*/
     /*设置span的样式*/
    .td_01 {
    position: relative;/*使用relative时，可以用top,left来设置DIV在页面中的偏移，但是此时不可使用层叠*/  
    display: inline-block;  /*具有对内部元素的包裹性，可与文字，图片混排，可内嵌block属性元素。*/
    background: #D0EEFF;  
    border: 1px solid #99D3F5;  
    border-radius: 4px;  
    padding: 4px 12px;  
    overflow: hidden;  /*hidden内容会被修剪，并且其余内容是不可见的。*/
    color: #1E88C7;  
    text-indent: 0;  /*作用是css缩进字符功能*/
    line-height: 20px;
}

    /* 设置input的样式，让input随着span的变化而变化    */
    .td_01 input {
    position: absolute;/*使用absolute时，可以用top,left来设置DIV在页面中的偏移，但是此时可使用层叠*/  
    font-size: 100px;
    right:0;
    top: 0;
    opacity: 0;/*规定不透明度。从 0.0 （完全透明）到 1.0（完全不透明）。*/
    cursor:pointer
}
   /*设置焦点在上传文件上时，span的样式改变*/
    .td_01:hover {
    background: #AADFFD;
    border-color: #3B8CFF;
    color: #004974;
}


   .td_02 {
    position: relative;  
    display: inline-block;  
    background: #D0EEFF;  
    border: 1px solid #99D3F5;  
    border-radius: 4px;  
    padding: 4px 12px;  
    overflow: hidden;  
    color: #1E88C7;  
    text-indent: 0;  
    line-height: 20px;
}
 .td_02 input {
    position: absolute;
    font-size: 100px;
    right:0;
    top: 0;
    opacity: 0;
    cursor:pointer
}
  .td_02:hover {
    background: #AADFFD;
    border-color: #3B8CFF;
    color: #004974;
}
/*-----------------------------------*/
  #center{
     position:absolute;
     width:100%;
     height:30px;
     /*background-color:red;*/
     margin-top:65px;
  }
  #left{
    font-size:15px;
  }
  #main{
  position:absolute;
    width:100%;
    height:500px;
    /*background-color:red;*/
    margin-top:90px;
  }
  table{
     /* BORDER-RIGHT: gray 1px solid; */ 
     /*BORDER-TOP: gray 1px solid; */
     /* BORDER-LEFT: gray 1px solid ;*/ 
     /*BORDER-BOTTOM: gray 1px solid; */
     WIDTH: 100%; 
     WORD-BREAK: break-all; 
     BORDER-COLLAPSE: collapse; 
    /* BACKGROUND-COLOR: #f5fafe; */
     WORD-WRAP: break-word;
     border:solid 1px #E5E5E5;
     -moz-box-shadow:rgba(0,0,0,0.1) 0px 0px 8px;
     -webkit-box-shadow:rgba(0,0,0,0.1) 0px 0px 8px;
  }
   </style>
  </head>
  <script type="text/javascript">
			function delFile(id, name) {
				if (confirm("是否要删除" + name)) {
					location.href = "${pageContext.request.contextPath}/delFileServlet?id="
							+ id;
				}
			}
			function upFile2() {
				location.href = "${pageContext.request.contextPath}/byTimeSortServlet";
			}

			function editFile(id) {
				location.href = "${pageContext.request.contextPath}/editFileServlet?name="
						+ name+"&fileType=storeFile";
			}
		</script>
  <body>
  <div id="container">
	 <div id="top" class="search">
	  <!-- <div style="position:absolute;width:50px;height:50px;margin-left:1310px;padding-top:12px;">
	    <span ><a href="#" style="text-decoration:none;">搜索</a></span>
	    style="position:absolute;height:120px;width:1350px;padding-top:12px;spadding-left:1310px;background-color:red;" 
	  </div>-->
	    <div id="top_1" style="position:absolute;margin-top:0;/* background-color:red; */width:300px;height:50px;">
		    <form action="${pageContext.request.contextPath }/upLoadServlet?fileType=calcuFile" enctype="multipart/form-data" method="post" >
		         &nbsp;&nbsp;&nbsp;&nbsp;<span class="td_01" ><input type="file" name="file" value="上传" style="cursor:pointer"/>选择文件</span>
		          &nbsp;&nbsp;&nbsp;&nbsp;<span class="td_02" ><input type="submit" name="submit" value="提价" style="cursor:pointer"/>上传文件</span>
		         
		    </form>
	    </div>
	    <div id="top_2" >
				<div id="top3" class="top3">
					<div class="search bar1">
						<!--表示该元素同时拥有两个类-->
						<form action="${pageContext.request.contextPath}/searchFileServlet" method="post">
							<input type="text" placeholder="请输入您要搜索的内容..." name="filename">
							<button type="submit" class="button"></button> 
						</form>
					</div>
				</div>
			</div>	
	  </div>
	    
	  <div id="center">
	       <div id="left">&nbsp;&nbsp;&nbsp;&nbsp;计算机程序设计大赛文件</div>
	       <div id=""></div>
	  </div>
      <div id="main">
          <form action="#" method="post"><!-- bordercolor="gray"  -->
          		<table frame="hsides" cellspacing="0" cellpadding="1" rules="rows"
							  id="DataGrid1">
                      <tr style="FONT-WEIGHT: bold; FONT-SIZE: 10pt; HEIGHT: 40px;border="0"">
                          <td align="center" width="6%"  style="cursor:hand;"><input type="checkbox" id="ckAll" onclick="checkAll()"/>全选/全不选</td>
                          <td align="center" width="8"   style="cursor:hand;">文件编号</td>
						  <td align="center" width="20%" style="cursor:hand;">文件名称</td>
						  <td align="center" width="18%" style="cursor:hand;">文件大小</td>
						  <td align="center" width="20%" style="cursor:hand;"><span onClick="upFile2()">上传日期</span></td>
						  <td width="9%" align="center"  style="cursor:hand;">下载</td>
						 <!--  <td width="6%" align="center"  style="cursor:hand;">编辑</td> -->
						  <td width="9%" align="center"  style="cursor:hand;">删除</td>
                      </tr>
                       <c:forEach items="${files }" var="file">
                          <tr onmouseover="this.style.backgroundColor = '#F6FAFF' "
									onmouseout="this.style.backgroundColor = '#FFFFFF'" height="40px" >
                               <td style="cursor:hand;height:22px;width:6%;color:#999999;" align="center">
                                 <input type="checkbox" align="center" name="ids" value="${file.fileid }"/>
                               </td>
                               <td style="cursor:hand;height:22px;width:8%;" align="center">${file.fileid }</td>
                               <td style="cursor:hand;height:22px;width:20%;" align="center">${file.filename }</td>
                               <td style="cursor:hand;height:22px;width:18%;" align="center">${file.filesize }</td>
                               <td style="cursor:hand;height:22px;width:20%;" align="center">${file.uptime }</td>
                               <td align="center" style="HEIGHT: 22px"  width="9%"><a href="${pageContext.request.contextPath}/downloadFileServlet?filepath=${file.filepath }">
                               <!--   --> 
											<img
											src="${pageContext.request.contextPath}/admin/images/download.png"
											border="0" style="CURSOR: hand"> </a>
							   </td>
							  <%--  <td align="center" style="HEIGHT: 22px" width="6%"><a
										href="javascript:editFile('${file.fileid }')">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a>
							  </td> --%>
							   <td align="center" style="HEIGHT: 22px" width="9%"><a
										href="javascript:delFile('${file.fileid }','${file.filename }')">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a>
							  </td>
                          </tr> 
                      </c:forEach>
                </table>
          </form>
      </div>
  </div>

  </body>
</html>
