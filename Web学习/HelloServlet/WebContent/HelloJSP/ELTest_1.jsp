<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List list = new ArrayList();
		list.add("0-aaa");
		list.add("1-bbbb");
		list.add("2-ccc");
		
		request.setAttribute("list",list);
		
		Map map = new HashMap();
		map.put("a","aaa");
		map.put("b","bbb");
		map.put("c","ccc");
		
		
		request.setAttribute("m",map);
		
	%>
	
	${list[0] }<%-- ${list[i] 取出list集合中的角标为i的值} --%><br/>
	
	${m["b"] }<%-- 等价${m.b } --%>
	
	
	
</body>
</html>