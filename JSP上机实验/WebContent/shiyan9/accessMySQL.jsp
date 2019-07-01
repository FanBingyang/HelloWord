<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink">

      <h3 align="center">使用MySQL的JDBC驱动访问MySQL数据库</h3>
      <hr>
      <table border="1" bgcolor="#ccceee" align="center">
       <tr>
         <th width="87" align="center">学号</th>
          <th width="87" align="center">姓名</th>
           <th width="87" align="center">性别</th>
            <th width="87" align="center">年龄</th>
             <th width="87" align="center">体重</th>
       </tr>
       <%
       Connection con=null;
       Statement stmt=null;
       ResultSet rs=null;
       Class.forName("com.mysql.jdbc.Driver");
       String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=gbk";
       con=DriverManager.getConnection(url,"root","root");
       stmt=con.createStatement();
       String sql="select * from stuinfo";
       rs=stmt.executeQuery(sql);
       while(rs.next()){
     
       %>
       <tr>
          <td><%=rs.getString("SID") %></td>
          <td><%=rs.getString("SName") %></td>
          <td><%=rs.getString("SSex") %></td>
          <td><%=rs.getString("SAge") %></td>
          <td><%=rs.getString("SWeight") %></td>
        </tr>
        <% }
          rs.close();
          stmt.close();
          con.close();
        %>
       </table>
       <hr>    
</body>
</html>