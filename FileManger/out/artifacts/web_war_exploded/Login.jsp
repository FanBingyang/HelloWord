<%--
  Created by IntelliJ IDEA.
  User: FBY
  Date: 2018/8/9
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<head>
    <meta charset="UTF-8">
    <title>欢迎来到软创实验室比赛项目管理系统</title>
    <script type="text/javascript">
        function changeCode() {
            //得到图片元素
            var img = document.getElementsByTagName("img")[0];
            //img.setAttribute("src","/HelloServlet/httpdemo4");//XML Dom语法
            img.src = "/codeServlet?time=" + new Date().getTime();
        }
    </script>
    <style type="text/css">
        /*设置适应屏幕大小*/
        body {
            width: 100%;
            height: 100%;
            overflow: hidden;
        }
        /*设置图片占屏比*/
        body {
            background: url("images/denglu.jpg");
            background-size: 100%;
        }
        h1{
            margin-top: 100px;
            font-family: "新宋体";
            font-style: italic;
        }
        table{
            margin-top: 50px;
        }
    </style>
</head>
<body>
<h1 align="center">软创实验室比赛项目管理系统</h1><br>
<hr style="height:1px;border:none;border-top:5px dashed blue;" />
<form action="/loginServlet" method="post">
    <table align="center">
        <tr>
            <td height="30" style="font-size: 20px;">用户名:</td>
            <td><input type="text"  name="username"/></td>&nbsp;&nbsp;
            <td><span style="color: red">${error}</span></td>
        </tr>
        <tr>
            <td style="font-size: 20px;">密码 :</td>
            <td><input type="password"  name="password"/></td>
        </tr>
        <tr>
            <td style="font-size: 20px;">验证码 :</td>
            <td><input type="text"  name="code"/></td>
            <td> <img src="/codeServlet" alt="验证码" onclick="changeCode()"/>
                <a href="javascript:changeCode()" >看不清，换一张</a></td>&nbsp;&nbsp;
            <td><span style="color: red">${yanzhengma}</span><br></td>
        </tr>
        <tr>
            <td height="70" align="center" colspan="2">
                <input style="height: 40px;width: 80px" type="submit" value="登录"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <input style="height: 40px;width: 80px" type="reset" value="取消"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
