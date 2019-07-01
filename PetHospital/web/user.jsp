<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<%String path = request.getContextPath();%>

<title>宠物医院</title>

<!-- Bootstrap Core CSS -->
<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<%=path%>/css/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="<%=path%>/css/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=path%>/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<%=path%>/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/css/boot-crm.css" rel="stylesheet"
	type="text/css">

<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>


</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">宠物医院管理系统</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">

			<li class="dropdown">
				<a class="dropdown-toggle"data-toggle="dropdown" href="#">
					<i class="fa fa-user fa-fw"></i>
					<i class="fa fa-caret-down"></i>
				</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="${pageContext.request.contextPath}/user.action?userName=${UserName}"><i class="fa fa-user fa-fw"></i> 用户设置</a></li>
					<li class="divider"></li>
					<li><a href="index.jsp"><i class="fa fa-sign-out fa-fw"></i>退出登录</a></li>
				</ul> <!-- /.dropdown-user -->
			</li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li>
						<a href="${pageContext.request.contextPath}/vet.action">
							<i class="fa fa-user-md fa-fw"></i>
							医生管理
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/client.action">
							<i class="fa fa-th-list fa-fw"></i>
							客户管理
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/pet.action">
							<span class="glyphicon glyphicon-piggy-bank"></span>
							宠物管理
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/user.action" class="active">
							<i class="fa fa-user fa-fw"></i>
							员工管理
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/ill.action">
							<i class="fa fa-edit fa-fw"></i>
							病例查看
						</a>
					</li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">员工管理</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline" action="${pageContext.request.contextPath}/user.action" method="post">
						<div class="form-group">
							<label for="userName">客户名称</label>
							<input type="text" class="form-control" id="userName" value="${userName}" name="userName">
						</div>
						<div class="form-group">
							<label for="custLevel">员工性别</label>
							<select	class="form-control" id="custLevel" name="userSex">
								<option value="">--请选择--</option>
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">查询</button>
                        <%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#customerEditDialog" data-whatever="添加">添加员工</button>--%>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">员工信息列表</div>
						<!-- /.panel-heading -->
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>编号</th>
									<th>姓名</th>
									<th>性别</th>
									<th>年龄</th>
									<th>电话</th>
									<th>住址</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${users}" var="u">
									<tr>
										<td>${u.userId}</td>
										<td>${u.userName}</td>
										<td>${u.userSex}</td>
										<td>${u.userAge}</td>
										<td>${u.userTel}</td>
										<td>${u.userAddress}</td>
										<td>
											<a href="#" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#customerEditDialog" data-whatever="编辑" onclick="editUser(${u.userId},'${u.userName}')">编辑</a>
											<a href="#" class="btn btn-danger btn-sm" onclick="deleteUser(${u.userId})">删除</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
<%--						<div class="col-md-12 text-right">--%>
<%--							<itheima:page url="${pageContext.request.contextPath }/customer/list.action" />--%>
<%--						</div>--%>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- 客户编辑对话框 -->
	<div class="modal fade" id="customerEditDialog" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">编辑员工信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="edit_user_form">
						<input type="hidden" id="user_Id" name="userId"/>
						<div class="form-group">
							<label for="user_Name" class="col-sm-2 control-label">员工姓名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="user_Name" placeholder="员工姓名" name="userName">
							</div>
						</div>
						<div id="pwd" class="form-group">
							<label for="user_Password" class="col-sm-2 control-label">登录密码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="user_Password" placeholder="员工姓名" name="password">
							</div>
						</div>
						<div class="form-group">
							<label for="user_Sex" style="float:left;padding:7px 15px 0 27px;">员工性别</label>
							<div class="col-sm-10">
								<select	class="form-control" id="user_Sex" placeholder="员工性别" name="userSex">
									<option value="">--请选择--</option>
                                    <option value="男">男</option>
                                    <option value="女">女</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="user_Age" style="float:left;padding:7px 15px 0 27px;">员工年龄</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="user_Age" placeholder="员工年龄" name="userAge">
                            </div>
						</div>
						<div class="form-group">
							<label for="user_Tel" style="float:left;padding:7px 15px 0 27px;">固定电话</label>
							<div class="col-sm-10">
                                <input type="text" class="form-control" id="user_Tel" placeholder="固定电话" name="userTel">
							</div>
						</div>
						<div class="form-group">
							<label for="user_Address" class="col-sm-2 control-label">联系地址</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="user_Address" placeholder="联系地址" name="userAddress">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="updateUser()">保存修改</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="<%=path%>/js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<%=path%>/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="<%=path%>/js/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="<%=path%>/js/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/js/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<%=path%>/js/sb-admin-2.js"></script>
	
	<script type="text/javascript">


		function editUser(id,name) {
			$.ajax({
				type:"get",
				url:"${pageContext.request.contextPath}/editUser.action",
				//data:{"userId":id}
				//第一个参数是传参，后台接受的时候的参数名字，第二个是要传的参数
				data:{"userId":id},
				success:function(data) {  
					$("#user_Id").val(data.userId);
					$("#user_Name").val(data.userName);
                    $("#user_Password").val(data.password);
					if('${UserName}' === name) $('#pwd').show();
					else $('#pwd').hide();
					$("#user_Sex").val(data.userSex);
					$("#user_Age").val(data.userAge);
					$("#user_Tel").val(data.userTel);
					$("#user_Address").val(data.userAddress);
				}
			});
        }
		function updateUser() {
			$.post("${pageContext.request.contextPath}/updateUser.action",$("#edit_user_form").serialize(),function(data){
				alert("员工信息更新成功！");
				window.location.reload();
			});
		}
		
		function deleteUser(id) {
			if(confirm('确实要删除该员工吗?')) {
				$.post("${pageContext.request.contextPath}/deleteUser.action",{"userId":id},function(data){
					alert("员工删除更新成功！");
					window.location.reload();
				});
			}
		}
	</script>

</body>

</html>
