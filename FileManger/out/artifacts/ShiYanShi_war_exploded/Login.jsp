<!DOCTYPE html>
<html lang="utf-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>软创实验室比赛项目管理系统</title>

    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            background: url("images/bg.png");
            width: 100%;
            height: 100%;
        }
        .content{
            position:absolute;/*相对定位*/
            overflow: hidden;
            width: 100%;
            height: 100%;
            /*这是星星*/
            background: url("images/bg1.png");
            /*animation: star 3s alternate infinite;*/
        }
        /*@keyframes star {*/
            /*0%{*/
                /*!*opacity透明度,1是完全不透明,0是全透明*!*/
                /*opacity: 1;*/
            /*}*/
            /*100%{*/
                /*opacity: 0.5;*/
            /*}*/
        /*}*/

        /*一大堆山*/
        .mountain{
            width: 100%;
            /*超出盒子隐藏*/
            overflow: hidden;
        }
        .moun3{
            position: absolute;
            bottom: 0;
            left: 0;
            width: 3800px;
            height: 55%;
            background: url("images/shan3.png");
            background-size: auto 100%;
            animation: moun 160s infinite;
        }
        .moun2{
            position: absolute;
            bottom:-40px;
            left: 0;
            width: 3800px;
            height: 40%;
            background: url("images/shan2.png");
            background-size: auto 100%;
            animation: moun 120s infinite;
        }
        .moun1{
            /*绝对定位*/
            position: absolute;
            bottom: 0;/*下对齐*/
            left: 0;/*左对齐*/
            width: 3800px;
            height: 25%;
            background: url("images/shan1.png");
            /*背景缩放 x 水平 y 垂直 auto 水平自动 100% 垂直和父亲一样background-size: x水平,y垂直;*/
            background-size: auto 100%;
            /*让山动起来,  infinite无限循环做动画*/
            animation: moun 80s infinite;
        }
        @keyframes moun {
            0%{
                transform: translate(0);
            }
            100%{
                /*translate(-50%)向左走自己宽度的50%,原宽度是3800*/
                transform: translate(-50%);
            }
        }
        .bear{
            position: absolute;
            bottom: 25px;
            left: 0;
            width: 120px;
            height: 60px;
            /*forwards 到100%目标位置停在该处,不再返回*/
            animation: bear 10s forwards;
        }
        @keyframes bear {

            0%{
                left: 0;
            }
            100%{
                /*translate(50%)表示走自己宽度的一半;如果写精确单位那就是走精确单位*/
                /*跑到父亲的50%,即是屏幕宽度的50%*/
                left: 50%;
            }
        }
        .caihong{
            position: absolute;
            top: 0;
            left: 50%;
            transform: translate(-50%);
            width: 1100px;
            height: 700px;
            /*no-repeat背景不重复*/
            /*background: url(./caihong.png) no-repeat;*/
            background-size: 100%;
            animation: ch 3s alternate infinite;
        }
        @keyframes ch {
            0%{
                /*opacity透明度,1是完全不透明,0是全透明*/
                opacity: 1;
            }
            100%{
                opacity: 0.5;
            }
        }

        .biaodan{
            position: absolute;
            float: left;
            top: 22%;
            left: 420px;
            /*transform: translate(-50%);*/
            /*width: 1100px;*/
            /*height: 700px;*/
        }

        .button{
            height: 40px;
            width: 80px;
            border-radius: 10px;
            cursor: pointer;
            background-color: darkgray;
        }

        .menu{
            position: absolute;
            float: left;
            top: 70px;
            height:30px;
            padding-top: 10px;
            text-align: center;/*文字在div中剧中*/
            overflow: hidden;/*超出边界后隐藏*/
            opacity: 0.4; /*设置透明度，1是完全不透明,0是全透明*/
            cursor: pointer;  /*设置当鼠标放在该div上时形状变成手的形状*/
        }
        #login{
            left: 420px;
            width: 109px;
            border-top-left-radius: 10px;/*设置左上角为圆角*/
            background-color: honeydew;
        }
        #register{
            left: 529px;
            width: 108px;
            border-top-right-radius: 10px;/*设置右上角为圆角*/
            background-color: grey;
        }

    </style>
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
        <div class="bear"><img src="images/bear.gif" alt=""></div>
        <!--彩虹的效果-->
        <%--<div class="caihong"></div>--%>
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
    <div id="date_1" class="biaodan" style="background-color:honeydew;opacity: 0.4;width: 217px;">
        <form action="/loginServlet" method="post" >
            <table align="center" name="table" style="text-align: center">
                <tr>
                    <td height="20px" style="font-size: 13px">身份登录:</td>
                    <td height="20px">
                        <select name="" style="background-color: honeydew;border: 1px;font-size: 13px">
                            <option value="学员" selected>--用户--</option>
                            <option value="管理员">--管理员--</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td height="30" style="font-size: 15px;color: black">用户名:</td>
                    <td><input type="text"  name="username"style="background-color: darkgray;"/></td>&nbsp;&nbsp;
                </tr>
                    <td style="font-size: 15px;">密码 :</td>
                    <td><input type="password"  name="password" style="background-color: darkgray;"/></td>
                </tr>
                <tr>
                    <td colspan="2"><span style="color: red;font-size: 10px;height: 10px;">${error}</span></td>
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
    <div id="date_2" class="biaodan" style="background-color:honeydew;opacity: 0.4;width: 217px;display: none">
        <form action="/registerServlet" method="post" >
            <table align="center" name="table_2" style="text-align: center">
                <tr>
                    <td height="30" style="font-size: 12px;color: black">用户名:</td>
                    <td><input height="30" type="text" name="username"style="background-color: darkgray;"/></td>
                </tr>
                    <td height="30" style="font-size: 12px;color: black">密码 :</td>
                    <td><input height="30" type="password"  name="password" style="background-color: darkgray;"/></td>
                </tr>
                </tr>
                    <td height="30" style="font-size: 12px;color: black;width: 60px">确认密码 :</td>
                    <td><input height="30" type="password"  name="repsw" style="background-color: darkgray;"/></td>
                </tr>
                <tr>
                    <td colspan="2"><span style="color: red;font-size: 10px;height: 10px;">${error2}</span></td>
                </tr>
                <tr>
                    <td colspan="2"><span style="color: red;font-size: 10px;height: 10px;">${error3}</span></td>
                </tr>
                <tr>
                    <td height="30" style="font-size: 12px;color: black">验证码 :</td>
                    <td><input height="30" type="text"  name="code"style="background-color: darkgray;width: 40px"/>
                        <img id="code"height="30"  width="70px" src="/codeServlet" alt="验证码" onclick="changeCode()"/></td>
                        <%--<a href="javascript:changeCode()" >看不清，换一张</a></td>--%>
                </tr>
                <tr>
                    <td colspan="2"><span style="color: red;font-size: 10px;height: 10px;">${yanzhengma}</span></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="sign" value="1" ></td>
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
        //img.setAttribute("src","/HelloServlet/httpdemo4");//XML Dom语法
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
    <%--if ((${zcmsg})=="zc"){--%>
        <%--change_2()--%>
    <%--}--%>
</script>
</html>