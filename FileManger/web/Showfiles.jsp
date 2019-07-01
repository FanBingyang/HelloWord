<%--
  Created by IntelliJ IDEA.
  User: FBY
  Date: 2018/9/7
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

</head>
<body>
    <table align="center" border="1">
        <tr>
            <th>上传者</th>
            <th>文件名</th>
            <th>上传时间</th>
            <th>文件位置</th>
            <th>描述</th>
            <th>下载</th>
        </tr>
        <c:forEach var="file" items="${list}">
        <tr>
            <td>${file.username}</td>
            <td>${file.filename}</td>
            <td>${file.uploadtime}</td>
            <td>${file.savepath}</td>
            <td>${file.miaoshu}</td>
            <td><font color="red"><a href="/downloadServlet?id=${file.id}">下载</a> </font> </td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
