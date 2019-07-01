<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>页面访问计数器</title>
</head>
<body>
<%
   if(session.getAttribute("visit")==null)
   {session.setAttribute("visit", "y");
   
   
   String strNum=(String)application.getAttribute("count");
   int count=0;
   if(strNum!=null)
	   count=Integer.parseInt(strNum)+1;
   else count++;
   application.setAttribute("count", String.valueOf(count));
   }
%>
您是第<%=application.getAttribute("count") %>位访问者！

</body>
</html>