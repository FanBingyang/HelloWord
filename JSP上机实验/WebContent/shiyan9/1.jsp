<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
    <form action="register1.jsp"method="post"name="form">
        用户名:<input type="text"name="username"/><br><p>
        密码:<input type="password" name="password"/><br><p>
        性别：
     <input type="radio"name="r"value="男"/>男
     <input type="radio"name="r"value="女"/>女<br><p>
        请选择你的学院：
        <select name='s'>
           <option value='软件学院'>软件学院</option>
           <option value=‘软件学院’>软件学院</option>
           <option value=‘软件学院’>软件学院</option>
           <option value=‘软件学院’>软件学院</option>
           <option value=‘软件学院’>软件学院</option>
        </select><br><p>
        选择你本学期所上的课程：
        <input type="checkbox"name="c" value="c语言"/>C语言
        <input type="checkbox"name="c" value="java语言"/>C语言
        <input type="checkbox"name="c" value="java"/>C语言
        <input type="checkbox"name="c" value="c语言"/>C语言<br><p>
        
        
        
        <input type="submit" value="注册"/>
        <input type="submit" value="重置"/>
        
    </form>
</body>
</html>html>