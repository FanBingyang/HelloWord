<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>系统将随机生成一个数</title>
    </head>
    <body>
        <jsp:useBean id="guess" class="JavaBean.GuessNumber" scope="session"/>
        <% 
            //实例化一个对象，该对象可以产生随机数
            Random randomNumbers = new Random();
            //randomNumbers对象调用nextInt()方法生成一个随机数
            //randomNumbers.nextInt( 100 )表示生成0～99的任意个整数
            int answer=1 + randomNumbers.nextInt( 100 );  
            /*在使用URL重写几只的时候要注意，为了保证会话跟踪的正确性，所有的链接和重定向语句中的URL都需要调用encodeURL()或encodeRedirectURL()方法进行编码。*/
            String str=response.encodeRedirectURL("guess.jsp");
        %>
        <jsp:setProperty  name= "guess"  property="answer" value="<%=answer%>"/>
        <h3>随系统随机生成了一个1到100之间的整数，请猜是什么数？</h3>
        <hr>
        <form action="<%=str%>" method="get">
            输入你的猜的数：<input type="text" name="guessNumber">
            <input type="submit" value="提交">
        </form>
    </body>
</html>
