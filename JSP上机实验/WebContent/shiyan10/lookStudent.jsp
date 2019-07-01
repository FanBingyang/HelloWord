<%@page import="studentManage.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>学生信息查询</title>
    </head>
    <body bgcolor="CCCFFF">
        <center>
            <br> <br> <br> <br> <br>
            <%
            ArrayList al=(ArrayList)session.getAttribute("al");
            %>
            你要查询的学生数据表中共有
            <font size="5" color="red">
               <%=al.size()%>
            </font>
            人
            <table border="2" bgcolor= "CCCEEE" width="600">
                <tr bgcolor="CCCCCC" align="center">
                    <th>学号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>体重(公斤)</th>
                </tr>
                <%
                    for(int i=0;i<al.size();i++){
                       Student st=(Student)al.get(i);
                %>
                <tr align="center">
                    <td><%=st.getStudentNumber()%> </td>
                    <td><%=st.getStudentName()%> </td>
                    <td><%=st.getStudentSex()%> </td>
                    <td><%=st.getStudentAge()%> </td>
                    <td><%=st.getStudentWeight()%> </td>
                </tr>
                <%
                     }
                %>
            </table>
        </center>
    </body>
</html>
