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

<% String path = request.getContextPath();%>

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
			<%--<button type="button" class="navbar-toggle" data-toggle="collapse"--%>
				<%--data-target=".navbar-collapse">--%>
				<%--<span class="sr-only">Toggle navigation</span> <span--%>
					<%--class="icon-bar"></span> <span class="icon-bar"></span> <span--%>
					<%--class="icon-bar"></span>--%>
			<%--</button>--%>
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
					<li><a href="<%=path%>/user.action?userName=${UserName}"><i class="fa fa-user fa-fw"></i> 用户设置</a></li>
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
                        <a href="<%=path%>/vet.action">
                            <i class="fa fa-user-md fa-fw"></i>
                            医生管理
                        </a>
                    </li>
                    <li>
                        <a href="<%=path%>/client.action" class="active">
                            <i class="fa fa-th-list fa-fw"></i>
                            客户管理
                        </a>
                    </li>
                    <li>
                        <a href="<%=path%>/pet.action">
                            <span class="glyphicon glyphicon-piggy-bank"></span>
                            宠物管理
                        </a>
                    </li>
                    <li>
                        <a href="<%=path%>/user.action">
                            <i class="fa fa-user fa-fw"></i>
                            员工管理
                        </a>
                    </li>
                    <li>
                        <a href="<%=path%>/ill.action">
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
					<h1 class="page-header">客户管理</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline" action="${pageContext.request.contextPath }/client.action" method="post">
						<div class="form-group">
							<label for="clientName">客户名称</label>
							<input type="text" class="form-control" id="clientName" value="${clientName }" name="clientName">
						</div>
						<button type="submit" class="btn btn-primary">查询</button>
						<button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#customerEditDialog" data-whatever="添加" onclick="insert()">添加客户</button>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">客户信息列表</div>
						<!-- /.panel-heading -->
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>编号</th>
									<th>姓名</th>
									<th>性别</th>
									<th>电话</th>
									<th>住址</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${clients}" var="cl">
									<tr>
										<td>${cl.clientId}</td>
										<td><a href="<%=path%>/selectPetByClientId.action?clientId=${cl.clientId}">${cl.clientName}</a></td>
										<td>${cl.clientSex}</td>
										<td>${cl.clientTel}</td>
										<td>${cl.clientAddress}</td>
										<td>
											<a href="#" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#customerEditDialog" data-whatever="修改" onclick="editClient(${cl.clientId})">编辑</a>
											<a href="#" class="btn btn-danger btn-sm" onclick="deleteClient(${cl.clientId})">删除</a>
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
					<h4 class="modal-title" id="myModalLabel">修改客户信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="edit_client_form">
						<input type="hidden" id="client_Id" name="clientId"/>
						<div class="form-group">
							<label for="client_Name" class="col-sm-2 control-label">客户姓名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="client_Name" placeholder="客户姓名" name="clientName">
							</div>
						</div>
						<div class="form-group">
							<label for="client_Sex" style="float:left;padding:7px 15px 0 27px;">客户性别</label>
							<div class="col-sm-10">
								<select	class="form-control" id="client_Sex" placeholder="客户性别" name="clientSex">
									<option value="">--请选择--</option>
									<option value="男">男</option>
									<option value="女">女</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="client_Tel" class="col-sm-2 control-label">固定电话</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="client_Tel" placeholder="固定电话" name="clientTel">
							</div>
						</div>
						<div class="form-group">
							<label for="client_Address" class="col-sm-2 control-label">联系地址</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="client_Address" placeholder="联系地址" name="clientAddress">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" id="update" class="btn btn-primary" style="display: none;" onclick="updateClient()">保存修改</button>
                    <button type="button" id="insert" class="btn btn-primary" onclick="insertClient()">确认添加</button>
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

        //根据触发的按钮不同，更改模态框的顶部标题
        //先获取到模态框，传参是event事件,'show.bs.modal'在调用 show 方法后触发。
        $('#customerEditDialog').on('show.bs.modal', function (event) {
            //获取触发事件的组件
            var button = $(event.relatedTarget);
            //获取组件上的‘data-whatever’里的数据
            var recipient = button.data('whatever');
            //获取到模态框的model
            var modal = $(this);
            //找到模态框的标题并修改
            modal.find('.modal-title').text(recipient + '客户信息');
            //将模态框的input标签里的值全部设置为空（添加用户时用，清空输入框）
            //因为在点击事件上是先执行这个，所以组件上的onclick事件是在此之后执行的，编辑信息时不会影响将数据再次写入input输入框
            modal.find('.modal-body input').val('');

        })

        function insert() {
            $('#insert').show();
            $('#update').hide();
        }

		function editClient(id) {

            $('#insert').hide();
            $('#update').show();

			$.ajax({
				type:"get",
				url:"${pageContext.request.contextPath}/editClient.action",
				data:{"clientId":id},
				success:function(data) {
				    $("#client_Id").val(data.clientId)
					$("#client_Name").val(data.clientName);
					$("#client_Sex").val(data.clientSex);
					$("#client_Tel").val(data.clientTel)
					$("#client_Address").val(data.clientAddress)
					
				}
			});
		}
		function updateClient() {
			$.post("${pageContext.request.contextPath}/updateClient.action",$("#edit_client_form").serialize(),function(data){
				alert("客户信息更新成功！");
				window.location.reload();
			});
		}

		function insertClient() {
            $.post("${pageContext.request.contextPath}/insertClient.action",$("#edit_client_form").serialize(),function (data) {
                alert("客户信息添加成功！")
                window.location.reload();
            })
        }
		
		function deleteClient(id) {
			if(confirm('确实要删除该客户吗?')) {
				$.post("${pageContext.request.contextPath}/deleteClient.action",{"clientId":id},function(data){
					alert("客户删除更新成功！");
					window.location.reload();
				});
			}
		}
	</script>

</body>

</html>
