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
						<a href="${pageContext.request.contextPath}/pet.action" class="active">
							<span class="glyphicon glyphicon-piggy-bank"></span>
							宠物管理
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/user.action">
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
					<h1 class="page-header">宠物管理</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline" action="${pageContext.request.contextPath }/pet.action" method="post">
						<div class="form-group">
							<label for="petName">宠物名称</label>
							<input type="text" class="form-control" id="petName" value="${petName }" name="petName">
						</div>
						<div class="form-group">
							<label for="customerFrom">宠物种类</label>
							<select	class="form-control" id="customerFrom" placeholder="宠物种类" name="petKind">
								<option value="">--请选择--</option>
								<c:forEach items="${kinds}" var="k">
									<option value="${k.petKind}"<c:if test="${k.petKind == petKind}"> selected</c:if>>${k.petKind}</option>
								</c:forEach>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">查询</button>
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#customerEditDialog" data-whatever="添加" onclick="insert()">添加宠物</button>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">宠物信息列表</div>
						<!-- /.panel-heading -->
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>编号</th>
									<th>名称</th>
									<th>种类</th>
									<th>主人</th>
									<th>生日</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pets}" var="p">
									<tr>
										<td>${p.petId}</td>
										<td>${p.petName}</td>
										<td>${p.petKind}</td>
                                       <td><a href="${pageContext.request.contextPath}/selectClient.action?clientId=${p.clientId}">${p.client.clientName}</a></td>
										<td>${p.petBir}</td>
										<td>
											<a href="#" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#customerEditDialog"  data-whatever="修改" onclick="editPet(${p.petId})">编辑</a>
											<a href="#" class="btn btn-danger btn-sm" onclick="deletePet(${p.petKind})">删除</a>
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
	<!-- 宠物编辑对话框 -->
	<div class="modal fade" id="customerEditDialog" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改宠物信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="edit_pet_form">
						<input type="hidden" id="pet_Id" name="petId"/>
						<div class="form-group">
							<label for="pet_Name" class="col-sm-2 control-label">宠物名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="pet_Name" placeholder="宠物名称" name="petName">
							</div>
						</div>
						<div class="form-group">
							<label for="pet_Kind" class="col-sm-2 control-label">宠物种类</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="pet_Kind" placeholder="宠物种类" name="petKind">
							</div>
						</div>
						<div class="form-group" id="pn">
							<label for="pet_ClientId" class="col-sm-2 control-label">宠物主人</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="pet_ClientId" placeholder="宠物主人ID" name="clientId">
							</div>
						</div>
						<div class="form-group">
							<label for="pet_Bir" class="col-sm-2 control-label">宠物生日</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="pet_Bir" placeholder="宠物生日" name="petBir">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="update" class="btn btn-primary" onclick="updatePet()" style="display: none;">保存修改</button>
					<button type="button" id="insert" class="btn btn-primary" onclick="insertPet()">确认添加</button>
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
			modal.find('.modal-title').text(recipient + '宠物信息');
			//将模态框的input标签里的值全部设置为空（添加用户时用，清空输入框）
			//因为在点击事件上是先执行这个，所以组件上的onclick事件是在此之后执行的，编辑信息时不会影响将数据再次写入input输入框
			modal.find('.modal-body input').val('');

		})
        
        function insert() {
            $('#insert').show();
            $('#pn').show();
            $('#update').hide();
        }

		function editPet(id) {

		    $('#insert').hide();
		    $('#pn').hide();
		    $('#update').show();

			$.ajax({
				type:"get",
				url:"${pageContext.request.contextPath}/editPet.action",
				data:{"petId":id},
				success:function(data) {
				    $("#pet_Id").val(data.petId);
					$("#pet_Name").val(data.petName);
					$("#pet_Kind").val(data.petKind);
					$("#pet_ClientId").val(data.clientId);
					$("#pet_Bir").val(data.petBir)
				}
			});
		}
		function updatePet() {
			$.post("${pageContext.request.contextPath}/updatePet.action",$("#edit_pet_form").serialize(),function(data){
				alert("宠物信息更新成功！");
				window.location.reload();
			});
		}

        function insertPet() {
            $.post("${pageContext.request.contextPath}/insertPet.action",$("#edit_pet_form").serialize(),function(data){
                alert("宠物信息添加成功！");
                window.location.reload();
            });
        }
		
		function deletePet(id) {
			if(confirm('确实要删除该宠物吗?')) {
				$.post("${pageContext.request.contextPath}/deletePet.action",{"petId":id},function(data){
					alert("宠物删除更新成功！");
					window.location.reload();
				});
			}
		}
	</script>

</body>

</html>
