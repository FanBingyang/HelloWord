<!DOCTYPE html>
<html lang="utf-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>在线笔记本-注册登录</title>
    <link rel="stylesheet" href="css/login.css">
    <%--为浏览器标签的标题前面加上图片--%>
    <link rel="Shortcut Icon" href="image/tb.ico" />
</head>
<body>
<%--动画--%>
<div class="content">
    <div class="mountain">
        <!--白色的山3-->
        <div class="moun3"></div>
        <!--白色的山2-->
        <div class="moun2"></div>
        <!--白色的山1-->
        <div class="moun1"></div>
        <!--白色的小熊-->
        <div class="bear"><img src="image/bear.gif" alt=""></div>
    </div>

    <div>
        <div id="login" class="menu" onclick="change_1()">
            <span>登录</span>
        </div>
        <div id="register" class="menu" onclick="change_2()">
            <span>注册</span>
        </div>
    </div>

    <%--登录表单--%>
    <div id="date_1" class="biaodan" style="background-color:honeydew;opacity: 0.5;">
        <form action="login" method="post">
            <table align="center" name="table" style="text-align: center;width: 250px;margin-left: 19%;margin-top: 4%;" >
                <tr>
                    <td class="font">用户名:</td>
                    <td><input type="text" name="username"style="background-color: darkgray;height: 20px;"/></td>
                </tr>
                    <td class="font">密&nbsp;&nbsp;码 :</td>
                    <td><input type="password"  name="password" style="background-color: darkgray;height: 20px;"/></td>
                </tr>
                <tr>
                    <td colspan="2"><span class="erro">${error}</span></td>
                </tr>
                <tr>
                    <td colspan="2"><span class="erro">${error2}</span></td>
                </tr>
                <tr>
                    <td colspan="2"><span class="erro">${error3}</span></td>
                </tr>
                <tr>
                    <td height="70" align="center" colspan="2">
                        <input class="button" type="submit" value="登录"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="button" type="reset" value="取消"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <%--注册表单--%>
    <div id="date_2" class="biaodan" style="background-color:honeydew;opacity: 0.5;display: none">
        <form action="/register" method="post" autocomplete="off">
            <table align="center" name="table_2" style="text-align: center;width: 250px;margin-left: 19%;margin-top: 4%;">
                <tr>
                    <td height="30" class="font">用户名:</td>
                    <td><input height="30" type="text" name="username"style="background-color: darkgray;height: 20px;"/></td>
                </tr>
                <tr>
                    <td height="30" class="font">性&nbsp;&nbsp;&nbsp;别:</td>
                    <td><input height="30" type="text" name="sex"style="background-color: darkgray;height: 20px;"/></td>
                </tr>
                <tr>
                    <td height="30" class="font">年&nbsp;&nbsp;&nbsp;龄:</td>
                    <td><input height="30" type="text" name="age"style="background-color: darkgray;height: 20px;"/></td>
                </tr>
                <tr>
                    <td height="30" class="font">密&nbsp;&nbsp;&nbsp;码 :</td>
                    <td><input height="30" type="password"  name="password" style="background-color: darkgray;height: 20px;"/></td>
                </tr>
                <tr>
                    <td height="30" class="font">确认密码 :</td>
                    <td><input height="30" type="password"  name="repsw" style="background-color: darkgray;height: 20px;"/></td>
                </tr>

                <tr>
                    <td height="30"  class="font">验证码 :</td>
                    <td><input  type="text"  name="code"style="background-color: darkgray;width: 65px;height: 20px;"/>
                        <img id="code" height="30"  width="70px" src="/codeServlet" alt="验证码" onclick="changeCode()"/></td>
                    <%--<a href="javascript:changeCode()" >看不清，换一张</a></td>--%>
                </tr>
                <tr>
                    <td colspan="2"><span style="color: red;font-size: 10px;height: 10px;">${yanzhengma}</span></td>
                </tr>
                <tr>
                    <td height="70" align="center" colspan="2">
                        <input class="button" type="submit" value="注册"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="button" type="reset" value="取消"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
<script type="text/javascript">
    function changeCode() {
        //得到图片元素
        var img = document.getElementById("code");
        img.src = "/codeServlet?time=" + new Date().getTime();
    }
    function change_1() {
        document.getElementById("date_1").style.display="";
        document.getElementById("date_2").style.display="none";
        document.getElementById("register").style.backgroundColor="grey";
        document.getElementById("login").style.backgroundColor="honeydew";
    }
    function change_2() {
        document.getElementById("date_1").style.display="none";
        document.getElementById("date_2").style.display="";
        document.getElementById("login").style.backgroundColor="grey";
        document.getElementById("register").style.backgroundColor="honeydew";
    }
</script>
</html>