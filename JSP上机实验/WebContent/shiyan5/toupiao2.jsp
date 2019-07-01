<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%
request.setCharacterEncoding("utf-8");
String username=request.getParameter("name");
String password=request.getParameter("pass");
%>
<jsp:useBean id="stu" class="vote.service.User" scope="application">
<jsp:setProperty property="username" name="stu" value="<%=username%>"/>
<jsp:setProperty property="password" name="stu" value="<%=password%>"/>

</jsp:useBean>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投票页面</title>
<style type="text/css">
h1{

font-family:宋体;
font-size:40px;
color:red;
}
#userDiv{
border-bottom:2px solid black;
padding:50px;

}
#user{
margin-right:5%;
display:inline-block;

border-bottom:2px solid red;

}  


#formvote{
line-height:30px;
}

body{
background-image:url('2.png');
background-size:cover;
}
</style>
</head>
<body>
<h1 align="center">投票吧</h1>
<div id="userDiv">
<strong id="user">欢迎你，尊敬的用户"<span style="font-size:2em;color:deepskyblue;"><a><%=username%></a></span>"</strong>
</div>
<form id="formvote" action="res.jsp" method="get">
<input  type="text" readonly="readonly" name="name" value=<%=username%>>
为你喜欢的老师投票<br>
<input type="radio" name="teacher" value="数据结构老师">数据结构老师<br>
<input type="radio" name="teacher" value="JSP老师">JSP老师<br>
<input type="radio" name="teacher" value="C++老师">C++老师<br>
<input type="radio" name="teacher" value="Java老师">Java老师<br>
<input type="radio" name="teacher" value="离散数学老师">离散数学老师<br>
<input type="submit" value="投票">
</form>

</body>
</html>