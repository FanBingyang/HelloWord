<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="../servlet" method="post">
<table align="center" name="table_2" style="text-align: center;width: 250px;margin-top: 4%;">
<tr>
    <td height="30" style="font-size: 18px;color: black;width: 100px;">用户名:</td>
    <td><input height="30" type="text" name="username"style="height: 20px;"/></td>
</tr>
<tr>
    <td height="30" style="font-size: 18px;color: black;width: 100px;">性&nbsp;&nbsp;&nbsp;别:</td>
    <td><input height="30" type="text" name="sex"style="height: 20px;"/></td>
</tr>
<tr>
    <td height="30" style="font-size: 18px;color: black;width: 100px;">年&nbsp;&nbsp;&nbsp;龄:</td>
    <td><input height="30" type="text" name="age"style="height: 20px;"/></td>
</tr>
<tr>
    <td height="30" style="font-size: 18px;color: black;width: 100px;">密&nbsp;&nbsp;&nbsp;码 :</td>
    <td><input height="30" type="password"  name="password" style="height: 20px;"/></td>
    </tr>
    
    <tr>
        <td height="70" align="center" colspan="2">
            <input class="button" type="submit" value="注册"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <input class="button" type="reset" value="取消"/>
        </td>
    </tr>
</table>
</form>
</body>
</html>