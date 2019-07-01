<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
JSP引擎名及Servlet版本号:<%=application.getServerInfo() %>
<br>
<%
application.setAttribute("name", "Java程序设计与项目实训教程");
out.print(application.getAttribute("name")+"<br>");
application.removeAttribute("name");
out.print(application.getAttribute("name")+"<br>");
%>
</body>
</html>