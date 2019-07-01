<%--
  Created by IntelliJ IDEA.
  User: FBY
  Date: 2018/8/13
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>软创实验室比赛项目管理系统</title>
    <style type="text/css">
        .frame{
            border-width: 0px;
            border-style: none;
        }
    </style>
</head>
    <frameset rows="80,*,30" frameborder="NO" border="0" framespacing="0">
        <%--<frame>属性：frameborder=0或1是否显示框架周围的边框  noresiz 设置框架大小无法改变 src框架地址  name框架名称  scrolling="no"设置是否需要滚动条 --%>
        <frame frameborder=0 noresize src="Top.jsp" name="top" scrolling="no">
        <frameset cols="160,5,*"  frameborder="NO"   border="0"   framespacing="0">
            <frame frameborder=0 noresize src="Left.jsp" name="left">
            <frame frameborder=0 noresize src="JianGe.jsp" name="jiange" scrolling="no" >
            <frameset rows="50,*" frameborder="NO" border="0" framespacing="0">
                <frame frameborder=0 noresize src="RightTop.jsp" name="righttop">
                <frame frameborder=0 noresize src="Right.jsp" name="right">
            </frameset>
        </frameset>
        <frame frameborder=0 noresize src="bottom.jsp" name="bottom" scrolling="no">
    </frameset>
</html>
