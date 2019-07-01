<%--
  Created by IntelliJ IDEA.
  User: FBY
  Date: 2018/9/3
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style type="text/css">
        body{
            background-color: skyblue;
        }
    </style>
</head>
<body>
<h1 align="center">文件上传</h1>
<!--
private String savepath;     //记住文件的位置
private Date uploadtime;     //文件的上传时间
private String description;  //文件的描述
 -->
<form action="/uploadServlet" method="post" enctype="multipart/form-data">
    <table align="center">
        <tr>
            <td>项目名称</td><td><input type="text" name="xiangmu" width="100"></td>
        </tr>
        <tr>
            <td>项目源码</td><td><input type="file" name="filename"></td>
        </tr>
        <tr>
            <td>上传者</td><td><input type="text" name="shangchuanzhe" value="<%=request.getSession().getAttribute("username")%>"></td>
        </tr>
        <tr>
            <td>项目描述</td><td><textarea name="miaoshu" rows="5" cols="30"></textarea></td>
        </tr>
        <tr>
          <td colspan="2" align="center">
              <input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="reset" value="重置">
          </td>
        </tr>
    </table>
</form>
</body>
</html>
