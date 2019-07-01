
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/css/login.css">
      <!-- <script type="text/javascript">
         window.onload=function(){//ajax最好是用在在每一项的后面直接验证输入是否合法
            //1、获取XMLHttpRequest对象
            var req = getXMLHttpRequest();
            //4、处理响应结果
            req.onreadystatechange=function(){
               if(req.readyState==4){//请求一切正常
                    if(req.status==200){//服务器响应一切正常
                        
                    }
               }
            }
            //2、创建一个连接
            req.open("get","${pageContext.request.contextPath}/registUserServlet");
            //3、发送请求
            req.send(null);
         }
      
      </script> -->
      
  </head>
 
  <body>
    <div class="wrap">
    <div class="container">
        <h1 id="msg" style="color:red;font-size=12px;text-align=center;">${msg }</h1>
        <h1>Regist</h1>
        <form action="${pageContext.request.contextPath }/registUserServlet" method="post" >
            <input type="text" name="username" placeholder="Your username"/>
            <input type="password" id="pw1" name="userpass1" placeholder="password" />
             <input type="password" id="pw2" name="userpass2" placeholder="Please confirm your password" /><span id="sp"></span>
             <input type="text" name="useremail" placeholder="Your email"/>   

            <input type="submit" id="sub" value="Set up"/>
            <p class="change_link" align="center">
                <span class="text">Already a member ?</span>
                <a href="${pageContext.request.contextPath }/admin/login/Login.jsp" class="to_login"> Go and login </a>
            </p>  
        </form>
    </div>
    <ul>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
   <!--  <script>
        window.onload =  $(function(){
           $("#sub").click(function(){
              var pwd1 = $("input[name='pass1']").val();
              var pwd2 = $("input[name='pass2']").val();
              alert(pwd1+pwd2);
              if(pwd1!=pwd2){
               
              }
              $("input[name='pass1']").val();
              $("input[name='pass2']").val();
              return false;
           });
           
        });
     </script> -->
       <script type="text/javascript">
     
       var pw2 = document.getElementById("pw2");
       pw2.onfoucus = function(){}
       pw2.onblur = function(){
           var pw1 = document.getElementById("pw1");
           var val1 = pw1.value;
           var val2 = pw2.value;
          if(val1!=val2)
          {
            alert("两次密码不一致，请重新输入！");
            pw1.value="";
            pw2.value="";
          }
       }
 
  </script> 
</div>
 
  </body>
</html>
