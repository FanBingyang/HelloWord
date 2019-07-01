
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 String usernamel=(String)session.getAttribute("userNamel");
 if(usernamel==null){
	 request.setCharacterEncoding("UTF-8");
	 String username=request.getParameter("userName");
	  if(username==null){
		  response.sendRedirect("legin.jsp");
		  
	  }else{
		  session.setAttribute("userNamel", username);
		  out.println(username+"!欢迎您来到主页面，请选择您要购买的商品:");
	  }
 }else{
	 out.println(usernamel+"!欢迎您来到主页面，请选择您要购买的商品:");
 }
%>
      <form action="shoppingCart.jsp"method="post">
            <p>商品信息</p>
            <table border="1">
            <tr>
            <td><input type="checkbox"name="choice"value="U盘"></td>
            <td>U盘</td>
            </tr>
            <tr>
             <td><input type="checkbox"name="choice"value="移动硬盘"></td>
            <td>移动硬盘</td>
            </tr>
            <tr>
             <td><input type="checkbox"name="choice"value="鼠标"></td>
            <td>鼠标</td>
            </tr>
            <tr>
             <td><input type="checkbox"name="choice"value="键盘"></td>
            <td>键盘</td>
            </tr>
            <tr>
             <td><input type="checkbox"name="choice"value="平板"></td>
            <td>平板</td>
            </tr>
            </table>
            <input TYPE="submit"value="添加购物车">
            </form>
</body>
</html>