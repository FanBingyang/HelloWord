<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FBY
  Date: 2019/5/15
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <!--为了确保适当的绘制和触屏缩放,添加 viewport 元数据标签-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--引入bootstrap的css样式文件-->
    <link rel="stylesheet" href="css/bootstrap.min.css" />

    <!--引入依赖的jQuery文件-->
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <!--引入bootstrap的js文件，再次之前一定要先引入jQuery.js文件-->
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <!--引入该css文件，可使用FontAwesome的图标文件-->
    <link href="css/font-awesome.min.css" rel="stylesheet"type="text/css">
    <title>宠物医院</title>
  </head>
  <body>
      <div class="container" style="padding-top: 150px;">
          <div class="col-md-offset-4">
              <h1><span class="fa fa-hospital-o fa-fw" style="color: red;"></span> 欢迎来到宠物医院管理系统</h1>
              <h2><small>Welcome to the pet hospital management system.</small></h2>
          </div>
          <br><br><br><br>
          <form  action="${pageContext.request.contextPath}/login.action" method="post" class="form-horizontal">
              <div class="form-group" style="padding: 20px">
                  <label for="name" class="col-md-1 control-label col-md-offset-4">用户名:</label>
                  <div class="col-md-4">
                      <input type="text" class="form-control " id="name" name="userName" placeholder="用户名">
                  </div>
              </div>
              <div class="form-group">
                  <label for="password" class="col-md-1 control-label  col-md-offset-4">密码:</label>
                  <div class="col-md-4">
                      <input type="password" class="form-control" id="password" name="password" placeholder="密码">
                  </div>
              </div>
              <div class="form-group">
                  <div class="col-md-offset-5 col-md-1">
                      <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">注册</button>
                  </div>
                  <div class="col-md-offset-1 col-md-3">
                      <button type="submit" class="btn btn-primary btn-lg">登录</button>
                  </div>
              </div>
          </form>
          <div class="form-group" style="padding: 20px">
              <span class="col-md-3 control-label col-md-offset-6" style="color: red;">${error}</span>
          </div>

          <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
              <div class="modal-dialog" role="document">
                  <div class="modal-content">
                      <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                          <h3 class="modal-title" id="myModalLabel">员工注册</h3>
                      </div>
                      <div class="modal-body">
                          <form class="form-horizontal" id="login_user">
                              <div class="form-group">
                                  <label for="username" class="col-sm-2 control-label col-sm-offset-2">用户名:</label>
                                  <div class="col-sm-4">
                                      <input type="text" class="form-control " id="username" name="userName" placeholder="用户名">
                                  </div>
                              </div>
                              <div class="form-group">
                                  <label for="userpassword" class="col-sm-2 control-label  col-sm-offset-2">密码:</label>
                                  <div class="col-sm-4">
                                      <input type="password" class="form-control" id="userpassword" name="password" placeholder="密码">
                                  </div>
                              </div>

                              <div class="form-group">
                                  <label for="age" class="col-sm-2 control-label col-sm-offset-2">年龄:</label>
                                  <div class="col-sm-4">
                                      <input type="text" class="form-control " id="age" name="userAge" placeholder="年龄">
                                  </div>
                              </div>
                              <div class="form-group">
                                  <label for="sex" class="col-sm-2 control-label col-sm-offset-2">性别:</label>
                                  <div class="col-sm-4">
                                      <input type="text" class="form-control " id="sex" name="userSex" placeholder="性别">
                                  </div>
                              </div>
                              <div class="form-group">
                                  <label for="address" class="col-sm-2 control-label col-sm-offset-2">住址:</label>
                                  <div class="col-sm-4">
                                      <input type="text" class="form-control " id="address" name="userAddress" placeholder="住址">
                                  </div>
                              </div>
                              <div class="form-group">
                                  <label for="tel" class="col-sm-2 control-label col-sm-offset-2">电话:</label>
                                  <div class="col-sm-4">
                                      <input type="text" class="form-control " id="tel" name="userTel" placeholder="电话">
                                  </div>
                              </div>
                              <div class="form-group">
                                  <div class="col-sm-offset-3 col-sm-2">
                                      <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">取消</button>
                                  </div>
                                  <div class="col-sm-offset-1 col-sm-2">
                                      <button type="submit" class="btn btn-primary btn-lg" onclick="loginUser()">注册</button>
                                  </div>
                              </div>
                          </form>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  <script type="text/javascript">
      function loginUser() {
          alert("注册成功！");
          $.post("${pageContext.request.contextPath}/insertUser.action",$("#login_user").serialize(),function(data){
              window.location.reload();
          });
      }
  </script>

  </body>
</html>
