<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册QQ</title>
    <style type="text/css">
      h2{

        margin: 0px;
        padding: 10px;
        text-align: center;
      }
      form{
        background-color:#ccc;
        margin：30px;
        padding: 30px;
      }
      .button1{
        width: 100px;height: 30px;
      }
      .kuang{
        width: 300px;
      }
    </style>
  </head>
  <body style="background-color: #cccccc">
  <h2 align="center">欢迎注册QQ</h2>
  <div>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <table align="center">
          <tr>
            <td>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</td>
            <td> <img src="../img/2.0.png" width="15" height="15" alt="必填"> <input class="kuang" value="" name="user" placeholder="请输入姓名"></td>
          </tr>
          <tr>
             <td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
              <td> <img src="../img/2.0.png" width="15" height="15" alt="必填"> <input class="kuang" name="psw" type="password" ></td>
          </tr>
          <tr>
            <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
            <td><input type="radio" name="sex" value="男" checked>男
              <input type="radio" name="sex" value="女">女</td>
          </tr>
          <tr>
            <td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
            <td><input type="text" name="age"></td>
          </tr>
          <tr>
            <td>个性签名：</td>
            <td><input type="text" name="qianming"></td>
          </tr>

          <tr>
            <td align="center" colspan="2">
              <input class="button1" type="submit" value="注册"/>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input class="button1" type="reset" value="重置"/>
            </td>
          </tr>
      </table>
    </form>
  </div>
  </body>
</html>


