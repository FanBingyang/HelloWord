<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>个人信息</title>
  </head>
  <body style="background-color:pink;">
    <table border="1" align="center" style="background-color:2EA7FA;">
    <tr>
    <td colspan="2" align="center" >个人信息界面</td>
    </tr>
    <tr>
    <td>姓名：</td>
    <td>范秉洋</td>
     <tr>
    <td>性别：</td>
    <td>男</td>
     <tr>
    <td>年龄：</td>
    <td>20</td>
     <tr>
    <td>学校：</td>
    <td>郑州轻工业大学</td>
     <tr>
    <td>专业：</td>
    <td>软件工程</td>
     <tr>
    <td>班级：</td>
    <td>软件工程17-03</td>
     <tr>
    <td>兴趣爱好：</td>
    <td>听歌，写代码，打球</td>
    </table>
  </body>
</html>
