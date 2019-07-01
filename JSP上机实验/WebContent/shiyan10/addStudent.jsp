<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>学生信息添加</title>
    </head>
    <body bgcolor="CCCFFF">
        <center>
            <br><br><br>
            <h3>&nbsp;&nbsp;添加学生信息</h3>
            <form action="../AddStudentServlet"  method="get">
                <table border="1" width="230">
                    <tr>
                        <td>学号:</td>
                        <td><input type="text" name="studentNumber"/></td>
                    </tr>
                    <tr>
                        <td>姓名:</td>
                        <td><input type="text" name="studentName"/></td>
                    </tr>
                    <tr>
                        <td>性别:</td>
                        <td><input type="text" name="studentSex"/></td>
                    </tr>
                    <tr>
                        <td>年龄:</td>
                        <td><input type="text" name="studentAge"/></td>
                    </tr>
                    <tr>
                        <td>体重:</td>
                        <td><input type="text" name="studentWeight"/></td>
                    </tr>
                    <tr align="center">
                        <td colspan="2">
                            <input name="sure" type="submit" value="提  交"/>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <input name="clear" type="reset" value="取  消"/>
                        </td>
                    </tr>
                </table>
            </form>
        </center>
    </body>
</html>
