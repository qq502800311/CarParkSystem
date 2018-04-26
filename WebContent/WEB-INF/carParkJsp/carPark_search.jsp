
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

	<meta charset="utf-8">
	<title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
	 <base href="<%=basePath%>">
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- start: CSS -->
	<link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>

	<script type="text/javascript" charset="UTF-8" src="js/jquery-3.3.1.js" ></script>
	<script type="text/javascript" charset="UTF-8" src= "js/bootstrap.js"></script>
	<script src="js/laydate/laydate.js" ></script> <!-- 改成你的路径 -->
	
	<!------------ 日历引入 -------------->
	<script type="text/javascript" src="js/hbh/dist/js/bootstrap-datepicker.min.js" ></script>
	<script type="text/javascript" src="js/hbh/dist/locales/bootstrap-datepicker.zh-CN.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="js/hbh/calendar.js" charset="UTF-8"></script>	
	

	<script type="text/javascript" src="js/my/carPark_search.js"></script>


<style>
	body{
		 overflow:hidden;
		 width:95%;
		 margin:auto;
		 height:2000px; //这里要定义本页面最小高度，方便iframe自适应
	} 
</style>		
		
</head>

<body>		
	<!-- start: content -->
	<div id="content" class="span11">
		
		<!-- start: 页头 -->
<!-- 		<ul class="breadcrumb">
			<li>
				<i class="icon-home"></i>
				<a href="index.html">Home</a> 
				<i class="icon-angle-right"></i>
			</li>
			<li><a href="javascript:void(0)">菜单管理</a></li>
		</ul> -->
		<!-- end: 页头 -->
		
		<div class="row-fluid sortable">		
			<div class="box span12">
			
				<!-- start: box-header -->
				<div class="box-header" data-original-title>
					<h2><i class="halflings-icon white user"></i><span class="break"></span>车位查看</h2>
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

							&#8195 <span>车牌： <input name="carLisence" id="carLisence"
								type="text" aria-controls="DataTables_Table_0"></span> &#8195 <span>车辆类型：
								<select value="" name="carType" id="carType">
									<option value="">不限</option>
									<option value="4">VIP用户</option>
									<option value="3">包年月套餐用户</option>
									<option value="2">临时用户</option>
							</select> &#8195</span><br> 
							
							
							<table>
							<tr>
							<td>
								<span>进入日期：
								</span>										
							</td>
							<td>											
							<div id="date_div" class="input-group date datepicker">
								<input type="text" class="form-control" id="import_Date1"> 
								<div class="input-group-addon">
									<span class=""></span>
								</div>
						    </div> 
							</td>
							<td>
								<span>至：</span>										
							</td>
							<td>											
							<div id="date_div" class="input-group date datepicker">
								<input type="text" class="form-control" id="import_Date2"> 
								<div class="input-group-addon">
									<span class=""></span>
								</div>
						    </div> 
							</td>

					
							<td>
								<span>
								车辆所在分区：<select value="" name="carArea" id="carArea">
									<option value="">不限</option>
							</select>
							</span>
							</td> 
							<td><button type="button" class="btn btn-primary" onclick="search()">查询</button></td>
							<td><button type="button" class="btn btn-primary" onclick="useHelp()">使用帮助</button></td>
							</tr>										
						</table>								
							
<!-- 							<button type="button" class="btn btn-primary" onclick="search()">查询</button>
							</span>
							<button type="button" class="btn btn-primary" onclick="useHelp()">使用帮助</button> -->
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
									总共 <span id="total"></span> 条消息
								</div>
							</div>
							<!-- start: 分页-信息 -->

							<!-- end: 分页-按钮组 -->
							<div class="span12 center">
								<div class="dataTables_paginate paging_bootstrap pagination">
									<ul>
										<span id="pages" style="display: none"></span>
										<li class="prev"><a id="lastPage"
											href="javascript:void(0)" onclick="lastPage()">← 上一页</a></li>
										<li class="active"><a id="pageNum"
											href="javascript:void(0)">1</a></li>
										<!-- 										<li id="" ><a href="#">2</a></li> -->
										<li class="next"><a id="nextPage"
											href="javascript:void(0)" onclick="nextPage()">下一页 → </a></li>
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

</body>
</html>
	