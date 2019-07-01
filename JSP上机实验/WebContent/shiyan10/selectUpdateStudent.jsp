<%@page import="java.util.ArrayList"%>
<%@page import="studentManage.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="CCCFFF">
        <center>
            <br> <br> <br> 
            <h3>请修改学生信息！</h3>
            <form action="../UpdateStudentServlet">
            <table border="2" bgcolor= "CCCEEE" width="600">
                <%
                    ArrayList al=(ArrayList)session.getAttribute("al");
                   for(int i=0;i<al.size();i++){
                        Student st=(Student)al.get(i);
                %>
                <tr>
                    <td>学号:</td>
                    <td><input type="text" name="studentNumber" value="<%=st.getStudentNumber()%>"/></td>
                </tr>
                <tr>
                    <td>姓名:</td>
                    <td><input type="text" name="studentName" value="<%=st.getStudentName()%>"/></td>
                    </tr>
                    <tr>
                        <td>性别:</td>
                        <td><input type="text" name="studentSex" value="<%=st.getStudentSex()%>"/></td>
                    </tr>
                    <tr>
                        <td>年龄:</td>
                        <td><input type="text" name="studentAge" value="<%=st.getStudentAge()%>"/></td>
                    </tr>
                    <tr>
                        <td>体重:</td>
                         <td><input type="text" name="studentWeight" value="<%=st.getStudentWeight()%>"/></td>
                    </tr>
                    <tr align="center">
                        <td colspan="2">
                            <input name="sure" type="submit" value="修  改"/>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <input name="clear" type="reset" value="取  消"/>
                        </td>
                    </tr>
                <%
                   }
                %>
            </table>
        </center>
    </body>
</html>