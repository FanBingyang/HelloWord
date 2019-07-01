<%--
  Created by IntelliJ IDEA.
  User: FBY
  Date: 2018/9/3
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        function shangchuan() {
            window.open ('ShangChuan.jsp', 'newwindow', 'height=400, width=800, top=100, left=100, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no')
        }
   /**     window.open 弹出新窗口的命令；
　　'page.html' 弹出窗口的文件名；
　　'newwindow' 弹出窗口的名字（不是文件名），非必须，可用空''代替；
　　height=100 窗口高度；
　　width=400 窗口宽度；
　　top=0 窗口距离屏幕上方的象素值；
　　left=0 窗口距离屏幕左侧的象素值；
　　toolbar=no 是否显示工具栏，yes为显示；
　　menubar，scrollbars 表示菜单栏和滚动栏。
　　resizable=no 是否允许改变窗口大小，yes为允许；
　　location=no 是否显示地址栏，yes为允许；
　　status=no 是否显示状态栏内的信息（通常是文件已经打开），yes为允许；*/

    </script>
    <style type="text/css">
        #menu{
            margin-top: 8px;
            float:right;
        }
    </style>
</head>
<body>
<div id="menu">
    <input type="text" name="chaxun" height="30" width="120" placeholder=项目名/上传者/日期>&nbsp;
    <input type="button" value="🔎 查询" height="30" onclick="">&nbsp;&nbsp;&nbsp;
    <input type="button" value="➕ 上传" height="30" onclick="shangchuan()">
</div>

</body>
</html>
