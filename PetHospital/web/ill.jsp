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
                        <a href="<%=path%>/vet.action">
                            <i class="fa fa-user-md fa-fw"></i>
                            医生管理
                        </a>
                    </li>
                    <li>
                        <a href="<%=path%>/client.action">
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
                        <a href="<%=path%>/ill.action" class="active">
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
					<h1 class="page-header">病例查看</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline" action="${pageContext.request.contextPath }/ill.action" method="post">
						<div class="form-group">
							<label for="petName">宠物名称</label>
							<input type="text" class="form-control " id="petName" value="${petName }" name="petName">
						</div>
						<div class="form-group">
							<label for="petKind">宠物种类</label>
							<select	class="form-control" id="petKind" placeholder="宠物种类" name="petKind">
								<option value="">--请选择--</option>
								<c:forEach items="${kind}" var="k">
									<option value="${k.petKind}"<c:if test="${k.petKind == petKind}"> selected</c:if>>${k.petKind}</option>
								</c:forEach>
							</select>
						</div>
						<%--<div class="form-group">--%>
							<%--<label for="clientName">客户名称</label>--%>
							<%--<input type="text" class="form-control" id="clientName" value="${clientName }" name="clientName">--%>
						<%--</div>--%>
						<div class="form-group">
							<label for="vetName">医生名称</label>
							<input type="text" class="form-control" id="vetName" value="${clientName }" name="vetName">
						</div>
						<div class="form-group">
							<label for="vetMajor">医生专业</label>
							<select	class="form-control" id="vetMajor" placeholder="医生专业" name="vetMajor">
								<option value="">--请选择--</option>
								<c:forEach items="${major}" var="m">
									<option value="${m.vetMajor}"<c:if test="${m.vetMajor == vetMajor}"> selected</c:if>>${m.vetMajor }</option>
								</c:forEach>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">查询</button>
						<button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#customerEditDialog" data-whatever="添加">添加病例</button>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">病例列表</div>
						<!-- /.panel-heading -->
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>宠物名称</th>
									<th>宠物种类</th>
									<th>客户名称</th>
									<th>医生名称</th>
									<th>医生专业</th>
                                    <th>病情描述</th>
                                    <th>就诊时间</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${ills}" var="il">
									<tr>
										<td><a href="${pageContext.request.contextPath}/pet.action?petName=${il.petName}">${il.petName}</a></td>
										<td>${il.petKind}</td>
										<td><a href="${pageContext.request.contextPath}/client.action?clientName=${il.clientName}">${il.clientName}</a></td>
										<td><a href="${pageContext.request.contextPath}/vet.action?vetName=${il.vetName}">${il.vetName}</a></td>
										<td>${il.vetMajor}</td>
                                        <td>${il.illness}</td>
										<td>${il.tim}</td>
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
					<h4 class="modal-title" id="myModalLabel">添加病例</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="edit_ill_form">
						<input type="hidden" id="client_Id" name="clientId"/>
						<div class="form-group">
							<label for="pet_name" class="col-sm-2 control-label">宠物名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="pet_name" placeholder="宠物名称" name="petName">
							</div>
						</div>
						<div class="form-group">
							<label for="pet_kind" style="float:left;padding:7px 15px 0 27px;">宠物种类</label>
							<div class="col-sm-10">
								<select	class="form-control" id="pet_kind" placeholder="宠物种类" name="petKind">
									<option value="">--请选择--</option>
									<c:forEach items="${kind}" var="k">
										<option value="${k.petKind}"<c:if test="${k.petKind == petKind}"> selected</c:if>>${k.petKind}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="client_name" class="col-sm-2 control-label">客户名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="client_name" placeholder="客户名称" name="clientName">
							</div>
						</div>
						<div class="form-group">
							<label for="vet_name" class="col-sm-2 control-label">医生名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="vet_name" placeholder="医生名称" name="vetName">
							</div>
						</div>
						<div class="form-group">
							<label for="vet_major" style="float:left;padding:7px 15px 0 27px;">医生专业</label>
							<div class="col-sm-10">
								<select	class="form-control" id="vet_major" placeholder="医生专业" name="vetMajor">
                                    <option value="">--请选择--</option>
                                    <c:forEach items="${major}" var="m">
                                        <option value="${m.vetMajor}"<c:if test="${m.vetMajor == vetMajor}"> selected</c:if>>${m.vetMajor }</option>
                                    </c:forEach>
								</select>
							</div>
						</div>

                        <div class="form-group">
                            <label for="ill_ness" class="col-sm-2 control-label">病情描述</label>
                            <div class="col-sm-10">
                                <textarea rows="2" cols="" class="form-control" id="ill_ness" placeholder="病情描述" name="illness"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="tim" class="col-sm-2 control-label">诊断时间</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="tim" placeholder="诊断时间" name="tim">
                            </div>
                        </div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" id="insert" class="btn btn-primary" onclick="insertIll()">确认添加</button>
                </div>
			</div>
		</div>
	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="/js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="/js/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="/js/jquery.dataTables.min.js"></script>
	<script src="/js/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/sb-admin-2.js"></script>
	
	<script type="text/javascript">
		function insertIll() {
            $.post("${pageContext.request.contextPath}/insertIll.action",$("#edit_ill_form").serialize(),function (data) {
                alert("病例添加成功！")
                window.location.reload();
            })
        }
	</script>

</body>

</html>
