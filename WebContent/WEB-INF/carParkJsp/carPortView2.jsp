<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<!-- start: Meta -->
<meta charset="utf-8">
<title>当前停车场车位查询页面</title>
<base href="<%=basePath%>">
<meta name="description" content="Bootstrap Metro Dashboard">
<meta name="author" content="Dennis Ji">
<meta name="keyword"
	content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<!-- end: Meta -->

<!-- start: Mobile Specific -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- end: Mobile Specific -->

<!-- start: CSS -->
<link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link id="base-style" href="css/style.css" rel="stylesheet">
<link id="base-style-responsive" href="css/style-responsive.css"
	rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'
	rel='stylesheet' type='text/css'>
<!-- end: CSS -->

<!-- start:自己的包 -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script type="text/javascript" charset="UTF-8" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" charset="UTF-8" src="js/bootstrap.js"></script>
<script type="text/javascript" charset="UTF-8" src="js/my/fabric.min.js"></script>
<script type="text/javascript" src= "js/my/carParkView.js" ></script>  
<!-- laydate控件方式,layDate 采用原生 JavaScript 编写，不依赖任何第三方库，兼容所有浏览器（IE6/7除外） -->
<!-- <script src="js/laydate/laydate.js"></script> --> 
<script src="js/laydate/laydate.js"></script>
<!-- 改成你的路径 -->


<!-- laydate控件方式,layDate 采用原生 JavaScript 编写，不依赖任何第三方库，兼容所有浏览器（IE6/7除外） -->


<!-- end:自己的包 -->

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="css/ie.css" rel="stylesheet">
	<![endif]-->

<!--[if IE 9]>
		<link id="ie9style" href="css/ie9.css" rel="stylesheet">
	<![endif]-->

<!-- start: Favicon -->
<link rel="shortcut icon" href="img/favicon.ico">
<!-- end: Favicon -->

<style>
body {
	overflow: hidden;
	width: 95%;
	margin: auto;
	height: 2000px;
	//
	这里要定义本页面最小高度，方便iframe自适应
}
</style>










</head>
<body>
	<!-- start: content -->
	<div id="content" class="span11">

		<!-- start: 页头 -->
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="index.html">Home</a> <i
				class="icon-angle-right"></i></li>
			<li><a href="javascript:void(0)">停车场车位查询</a></li>
		</ul>
		<!-- end: 页头 -->

		<div class="row-fluid sortable">
		<!-- 内容开始 -->

		<h1>停车场鸟瞰图</h1>

		<canvas id="myCanvas" width="2000" height="1000"></canvas>
		
		<!-- 				查看车位信息模态框开始 -->
				
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">查看车位详细信息</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
									<!-- 				要增加的人员姓名 -->
									<div >
										<label >车位编号：</label>
										<label id="carPort_id">车位编号</label>
									</div>
									<br></br>
									<!-- 				要增加的人员姓名 -->
									<div >
										<label >车位状态：</label>
										<label id="carPort_status">车位状态</label>
									</div>
									<br></br>
									<!-- 				选择所属科室 -->
									<div >
										<label >车位车辆车牌：</label>
										<label id="carPort_license">车位车辆车牌</label>
									</div>
									<br></br>
									<!-- 				选择所属角色 -->
									<div >
										<label >车位停放车辆照片</label>
										<img src=""  alt="暂无图片" id="carPort_pic" width=300px/>
									</div>
									<br></br>
									
									
<!-- 								模态框中表单结束 -->
							</div>
							<div class="modal-footer">
								<div class="col-sm-offset-2 col-sm-10">
<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
<!-- 									<button type="button" onclick="" class="btn btn-primary">审核通过</button> -->
<!-- 									<button type="button" class="btn btn-default" onclick="changeEmpApply()" data-dismiss="modal">修改</button>		 -->
									<button type="button" class="btn btn-primary"
										data-dismiss="modal">确定</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
<!-- 			查看车位信息模态框结束 -->
		
		<!-- 内容结束 -->
		</div>

	</div>
	<!-- start: content -->

	


</body>
</html>