<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
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
		Context initContext = new InitialContext();
		/* 扫描配置文件按，用此方法应该将cntext.xml文件配置到tomcat下的conf.xml文件中*/
		DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/HelloServlet");
		Connection conn = ds.getConnection();
		out.print(conn);
	%>
</body>
</html>