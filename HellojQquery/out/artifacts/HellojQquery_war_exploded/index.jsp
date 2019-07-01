<%--
  Created by IntelliJ IDEA.
  User: FBY
  Date: 2018/11/13
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>First jQuery</title>

      <style type="text/css">
          h1{
              text-align: left;
              left: 300px;
          }
          h2{
              text-align: left;
          }
          button{
              width: 50px;
              height: 50px;
          }
          img{
              width:500px;
              height:300px;
          }

      </style>
  </head>
  <body>
  <h1>这是第一条h1</h1>
  <h1>这是第二条h1</h1>
  <h1>这是第三条h1</h1>
  <h2>这是第一条h2</h2>
  <h2>这是第二条h2</h2>
  <h2>这是第三条h2</h2>
  <img src="img/2.jpg" alt="图片">
  <%--<input type="button" value="确定">--%>
  <button type="button">ok</button>
  <script src="js/jquery-3.3.1.min.js"></script>
  <script>
      $(document).ready(function () { //web页面文档准备就绪时加载函数
          $("button").click(function () {
              alert("lalalalalala");
              $("h1").hide("slow");  //让所有h1元素慢慢消失
              $("h2").show("fast");  //让所有h2元素快速出现
              $("img").slideUp(1000);    //让所有img元素向上滑动并消失,参数为执行时间，单位毫秒
          });
      });
  </script>
  </body>
</html>
