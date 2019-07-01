<%@page import="java.util.ArrayList"%>
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
		String str1 = null;
		request.setAttribute("str1",str1);
		
		String str2="";
		request.setAttribute("str2",str2);
		
		String str3="abc";
		request.setAttribute("str3",str3);
		
		List list1 = new ArrayList();
		request.setAttribute("list1",list1);
		
		List list2 = new ArrayList();
		list2.add("asfd");
		request.setAttribute("list2",list2);
	
		
		int sex = 1;
		request.setAttribute("s", sex);
		
		
	%>
	
	<!-- empty：判断null，空字符串和没有元素的集合（即使集合对象本身不为nul）都返回true -->
	${empty str1 }<!-- 返回结果是true --><br/>
	${empty str2 }<!-- 返回结果是true --><br/>
	${empty str3 }<!-- 返回结果是false --><br/>
	${empty list1 }<!-- 返回结果是true --><br/>
	${empty list2 }<!-- 返回结果是false --><br/>
	
	${empty list1?"空-返回true":"非空-返回false" }<br/>
	
	
	<input type="radio" name="sex" value="nan" ${s==0?"checked='checked'":"" }/>男<br/>
	<input type="radio" name="sex" value="nv" ${s==1?"checked='checked'":"" }/>女<br/>
	
	
	
	
	
	
	
</body>
</html>