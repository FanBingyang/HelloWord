
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>学生信息修改</title>
    </head>
    <body bgcolor="CCCFFF">
        <center>
            <br><br><br>
            <br><br><br>
            <form  action="../SelectUpdateStudentServlet" method="post">
                <p>请输入要修改学生的学号:<input type="text" Name="studentNumber">
                </p>
                 <p>
                    <input type="submit"  value="确定">&nbsp;
                    <input  type="button"  value="返回" onClick="javascript:history.go(-1)">
                </p>
            </form>
        </center>
    </body>
</html>