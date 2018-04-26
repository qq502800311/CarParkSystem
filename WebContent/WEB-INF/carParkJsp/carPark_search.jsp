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
<title>当前停车场车辆查询页面</title>
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
<script type="text/javascript" src="js/my/carPark_search.js"></script>
<!-- laydate控件方式,layDate 采用原生 JavaScript 编写，不依赖任何第三方库，兼容所有浏览器（IE6/7除外） -->
<!-- <script src="js/laydate/laydate.js"></script> -->
<!-- 改成你的路径 -->

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
			<li><a href="javascript:void(0)">停车场车辆查询</a></li>
		</ul>
		<!-- end: 页头 -->

		<div class="row-fluid sortable">
			<div class="box span12">

				<!-- start: box-header -->
				<div class="box-header" data-original-title>
					<h2>
						<i class="halflings-icon white user"></i><span class="break"></span>停车场车辆查询
					</h2>
					<div class="box-icon">
						<a href="javascript:void(0)" class="btn-setting"><i
							class="halflings-icon white wrench"></i></a> <a
							href="javascript:void(0)" class="btn-minimize"><i
							class="halflings-icon white chevron-up"></i></a> <a
							href="javascript:void(0)" class="btn-close"><i
							class="halflings-icon white remove"></i></a>
					</div>
				</div>
				<!-- end: box-header -->

				<!-- start: box-content -->
				<div class="box-content" style="display: block;">
					<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper"
						role="grid">

						<!-- start: 搜索表单 -->




						<form id="carparkfrom" method="post">
							<!-- start: box-工具栏 -->
							<!-- 						<div class="row-fluid"> -->
							<!-- start: box-页数 -->
							<!-- 							<div class="span6"> -->
							<!-- class="dataTables_length"  class="dataTables_filter"  -->
							<!-- 								<div id="DataTables_Table_0_length"> -->
							<span>每页条量： <select id="pageSize" name="pageSize" onchange="search()"
								size="1" aria-controls="DataTables_Table_0">
									<option value="10" selected="selected">10</option>
									<option value="20">20</option>
									<option value="30">30</option>
									<option value="50">50</option>
							</select>
							</span>
							<!-- 								</div> -->
							<!-- 							</div> -->
							<!-- end: box-页数-->



							<!-- start: box-搜索-->
							<!-- 							<div class="span6"> -->
							<!-- 								<div id="DataTables_Table_0_filter"> -->
							&#8195 <span>车牌： <input name="carLisence" id="carLisence"
								type="text" aria-controls="DataTables_Table_0"></span> &#8195 <span>车辆类型：
								<select value="" name="carType" id="carType">
									<option value="">不限</option>
									<option value="4">VIP用户</option>
									<option value="3">包年月套餐用户</option>
									<option value="2">临时用户</option>
							</select> &#8195
							</span><br> <span>进入日期：<input type="text" id="import_Date1">至
								<input type="text" id="import_Date2"></span><span>
								车辆所在分区：<select value="" name="carArea" id="carArea">
									<option value="">不限</option>
							</select>
							</span>
							<button type="button" class="btn btn-primary" onclick="search()">查询</button>
							</span>
							<button type="button" class="btn btn-primary" onclick="useHelp()">使用帮助</button>
							<!-- 								</div> -->
							<!-- 							</div> -->

							<!-- end: box-搜索-->
						</form>

						<!-- 						</div> -->
						<!-- end: box-工具栏 -->
						<!-- end: 搜索表单 -->

						<!-- start: 翻页条件记录 -->
						<!-- 					<form id="pageRecondForm" method="post"> -->
						<!-- 						<span id="pageSizeRecond" name="pageSize"></span> -->

						<!-- 					</form>	 -->
						<!-- end: 搜索条件记录 -->

						<!-- start: table -->
						<table
							class="table table-striped table-bordered bootstrap-datatable datatable dataTable"
							id="DataTables_Table_0"
							aria-describedby="DataTables_Table_0_info">
							<thead>
								<tr role="row">

									<th class="sorting_asc" role="columnheader" tabindex="0"
										aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
										aria-sort="ascending"
										aria-label="Username: activate to sort column descending">序号</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
										aria-label="Date registered: activate to sort column ascending">车牌号</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
										aria-label="Date registered: activate to sort column ascending">入场时间</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
										aria-label="Date registered: activate to sort column ascending">车辆类型</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
										aria-label="Date registered: activate to sort column ascending">车位ID</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
										aria-label="Actions: activate to sort column ascending">缴费情况</th>
								</tr>
							</thead>

							<tbody role="alert" aria-live="polite" aria-relevant="all"
								id="myShowbody">


							</tbody>
						</table>
						<!-- end: table -->

						<div class="row-fluid">
							<!-- start: 分页-信息 -->
							<div class="span12">
								<div class="dataTables_info" id="DataTables_Table_0_info">
									Showing 1 to 25 of <span id="total"></span> entries
								</div>
							</div>
							<!-- start: 分页-信息 -->

							<!-- end: 分页-按钮组 -->
							<div class="span12 center">
								<div class="dataTables_paginate paging_bootstrap pagination">
									<ul>
										<span id="pages" style="display: none"></span>
										<li class="prev"><a id="lastPage"
											href="javascript:void(0)" onclick="lastPage()">← Previous</a></li>
										<li class="active"><a id="pageNum"
											href="javascript:void(0)">1</a></li>
										<!-- 										<li id="" ><a href="#">2</a></li> -->
										<li class="next"><a id="nextPage"
											href="javascript:void(0)" onclick="nextPage()">Next → </a></li>
									</ul>
								</div>
							</div>
							<!-- end: 分页-按钮组 -->
						</div>

					</div>
				</div>
				<!-- end: box-content -->

			</div>
		</div>

	</div>
	<!-- start: content -->





	<!-- 				查看单模态框开始 -->

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="myModalLabel">新增人员</h4>
				</div>
				<div class="modal-body" align="center">
					<!-- 								模态框中表单开始 -->
					<!-- 				要增加的人员姓名 -->
					<div>
						<label>人员姓名：</label> <input id="newEmp_Name">
					</div>
					<br></br>
					<!-- 				设置密码1 -->
					<div>
						<label>密码：</label> <input id="newEmp_Psw1">

					</div>
					<br></br>
					<!-- 				设置密码2 -->
					<div>
						<label>确认密码密码：</label> <input id="newEmp_Psw2">

					</div>
					<br></br>
					<!-- 				选择所属科室 -->
					<div>
						<label>所属科室：</label> <select value="" name="newEmp_D_ID"
							id="newEmp_D_ID">
							<option value="1">内科</option>
							<option value="2">IT部</option>
							<option value="3">业务部</option>
						</select>
					</div>
					<br></br>
					<!-- 				选择所属角色 -->
					<div>
						<label>所属角色：</label> <select value="" name="newEmp_ER_ID"
							id="newEmp_ER_ID">
							<option value="1">管理员</option>
							<option value="2">医生</option>
							<option value="3">业务员</option>
						</select>
					</div>
					<br></br>


					<!-- 								模态框中表单结束 -->
				</div>
				<div class="modal-footer">
					<div class="col-sm-offset-2 col-sm-10">
						<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
						<!-- 									<button type="button" onclick="" class="btn btn-primary">审核通过</button> -->
						<button type="button" class="btn btn-primary"
							onclick="addNewEmp()" data-dismiss="modal">提交</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- 				查看单模态框结束 -->

	<!-- 				修改人员模态框开始 -->

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="myModalLabel">修改人员</h4>
				</div>
				<div class="modal-body" align="center">
					<!-- 								模态框中表单开始 -->
					<!-- 				要增加的人员姓名 -->
					<div>
						<label>人员工号：</label> <label id="changeEmp_ID">人员工号：</label>
					</div>
					<br></br>
					<!-- 				要增加的人员姓名 -->
					<div>
						<label>人员姓名：</label> <input id="changeEmp_Name">
					</div>
					<br></br>
					<!-- 				选择所属科室 -->
					<div>
						<label>所属科室：</label> <select value="" name="changeEmp_D_ID"
							id="changeEmp_D_ID">
							<option value="1">内科</option>
							<option value="2">IT部</option>
							<option value="3">业务部</option>
						</select>
					</div>
					<br></br>
					<!-- 				选择所属角色 -->
					<div>
						<label>所属角色：</label> <select value="" name="changeEmp_ER_ID"
							id="changeEmp_ER_ID">
							<option value="1">管理员</option>
							<option value="2">医生</option>
							<option value="3">业务员</option>
						</select>
					</div>
					<br></br>


					<!-- 								模态框中表单结束 -->
				</div>
				<div class="modal-footer">
					<div class="col-sm-offset-2 col-sm-10">
						<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
						<!-- 									<button type="button" onclick="" class="btn btn-primary">审核通过</button> -->
						<button type="button" class="btn btn-primary"
							onclick="changeEmpApply()" data-dismiss="modal">修改</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- 			修改人员模态框结束 -->
</body>
</html>