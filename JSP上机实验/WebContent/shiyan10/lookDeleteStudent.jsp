<%@page import="studentManage.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>学生信息删除</title>
    </head>
   <body bgcolor="CCCFFF">
        <center>
            <br><br><br>
            <br><br><br>
            <h2>删除学生信息</h2><br>
             <%
                 ArrayList al=(ArrayList)session.getAttribute("al");
            %>
            <form  action="../DeleteStudentServlet" method="post">
                <p>请选择要删除学生的学号:</p>
                <select name="NO">
                    <%
                        for(int i=0;i<al.size();i++){
                            Student st=(Student)al.get(i);
                    %>
                    <option value="<%=st.getStudentNumber()%>"><%=st.getStudentNumber()%></option>
                    <%
                        }
                    %>
                </select>
                 <p>
                    <input type="submit"  value="确定">&nbsp;
                    <input  type="button"  value="返回" onClick="javascript:history.go(-1)">
                </p>
            </form>
        </center>
    </body>
</html>



