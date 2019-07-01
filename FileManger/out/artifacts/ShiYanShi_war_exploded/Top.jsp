<%--
  Created by IntelliJ IDEA.
  User: FBY
  Date: 2018/8/13
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body {
            width: 100%;
            height: 100%;
            overflow: hidden;
        }
        /*设置图片占屏比*/
        body {
            background-color: skyblue;
            background-image: url("images/topxiaoming.png");
            background-size:100% 90%;
        }
        #menu{
            position: absolute;
            right: 5px;
            bottom: 0px;
        }
        #menu img{margin-bottom:-2px;}
        #menu a{
            font-size: 14px;
            text-decoration:none;
            color: black;
        }
        #menu a:hover{
            color: red;
            cursor: pointer;
        }
        #guodong{
            position: absolute;
            width: 80%;
            bottom: 0px;
            font-size: 12px;
        }
    </style>
    <script type="text/javascript">
        function zhuxiao(e) {
            var con = confirm("你确定要注销吗？");
            if(!con){
                //针对不同的浏览器进行阻止跳转
                if(e && e.preventDefault){//判断是否是W3c标准的
                    e.preventDefault();
                }
                //判断是否是IE浏览器
                else{window.event.returnValue = false;}
            }
        }
    </script>
</head>
<body>
<div id="menu">

    <span style="font-size: 12px;float:right;margin-right:5px;"><%=request.getSession().getAttribute("time")%></span><br/>

    <a href="/Main.jsp" target="_top"><img src="images/shuaxin.png" height="16px" width="16px">刷新</a>&nbsp;|

    <a href="/Help.jsp" target="_blank"><img src="images/help.png">帮助</a>&nbsp;|

    <a href="/zhuXiao" target="_top" onclick="zhuxiao(event)"><img src="images/zhuxiao.png" height="16px" width="16px">注销</a>
    <%--<br/><hr style="color: skyblue">--%>
</div>
<div id="guodong">
    <marquee behavior="scroll" height="20" width="100%" direction="left" scrollamount="5" vspace="0px" onmouseover=this.stop() onmouseout=this.start() >
        <span>欢迎你：<%=request.getSession().getAttribute("username")%>同学！</span></marquee>
</div>
</body>
</html>
