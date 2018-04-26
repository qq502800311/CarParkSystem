
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
	<script type="text/javascript" src="js/hbh/ichart.1.2.min.js"></script>
	<script type="text/javascript" src="js/hbh/charge_meth.js"></script>


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
					<h2><i class="halflings-icon white user"></i><span class="break"></span>支付方式统计</h2>
<!-- 					<div class="box-icon">
						<a href="javascript:void(0)" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
						<a href="javascript:void(0)" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
						<a href="javascript:void(0)" class="btn-close"><i class="halflings-icon white remove"></i></a>
					</div> -->
				</div>
				<!-- end: box-header -->
				
				<!-- start: box-content -->
				<div id='canvas_charge_meth'></div>	
				<br><br>
				<div class="box-content" style="display: block;">		
					<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper" role="grid">
						<form id="searchMenuForm" method="post">
									<table>
										<tr>
										<td>									
											<span>每页条量：
											<select name="pageSize" onchange="search()" size="1" aria-controls="DataTables_Table_0">
												<option value="10" selected="selected">10</option>
												<option value="20">20</option>
												<option value="30">30</option>
												<option value="50">50</option>
											</select> 
											</span>
										</td>
										<td>
											<span>支付方式：
											<select id="meth" onchange="search()" size="1" aria-controls="DataTables_Table_0">
												<option value="">--请选择--</option>
												<option value="现金">现金</option>
												<option value="微信">微信</option>
												<option value="支付宝">支付宝</option>
											</select> 
											</span>										
										</td>
										</tr>
										</table>
										&#8195
										<table>
										<tr>
										<td>
											<span>开始日期：
											</span>										
										</td>
										<td>											
										<div id="date_div" class="input-group date datepicker">
											<input type="text" class="form-control" id="startDate"> 
											<div class="input-group-addon">
												<span class=""></span>
											</div>
									    </div> 
										</td>
										<td>
											<span>结束日期：</span>										
										</td>
										<td>											
										<div id="date_div" class="input-group date datepicker">
											<input type="text" class="form-control" id="stopDate"> 
											<div class="input-group-addon">
												<span class=""></span>
											</div>
									    </div> 
										</td>
										<td><button class="btn btn-primary" data-toggle="modal" data-target="#myModal1" onclick="search()">查找</button></td>
										</tr>										
									</table>
									<table>
										<tr>
											<td>现金总额:<span id="cash"></span>元</td>
											<td>&nbsp;&nbsp;微信总额:<span id="weichat"></span>元</td>
											<td>&nbsp;&nbsp;支付宝总额:<span id="alipay"></span>元</td>
										</tr>
									</table>
						</form>	
						<!-- start: table -->
						<table class="table table-striped table-bordered bootstrap-datatable datatable dataTable" id="DataTables_Table_0" aria-describedby="DataTables_Table_0_info">
							  <thead>
								  <tr role="row">
								  	<th class="sorting_asc" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Username: activate to sort column descending" >编号</th>
								  	<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" >时间</th>
								  	<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" >车牌</th>
								  	<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" >事项</th>
								  	<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" >金额</th>
								  	<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Actions: activate to sort column ascending" >支付方式</th>
								  </tr>
							  </thead>   
									  
							  <tbody id="mytable"  role="alert" aria-live="polite" aria-relevant="all">
							  		<tr class="odd">	
	
									</tr>
								</tbody>
						</table>
						<!-- end: table -->
											
						<div class="row-fluid">
							<!-- start: 分页-信息 -->
							<div class="span12">
								<div class="dataTables_info" id="DataTables_Table_0_info">总共 
								
								<span id="total"></span> 条消息			
								</div>
							</div>
							<!-- start: 分页-信息 -->
							
							<!-- end: 分页-按钮组 -->
							<div class="span12 center">
								<div class="dataTables_paginate paging_bootstrap pagination">
									<ul>
										<span id="pages" style="display: none"></span>
										<li class="prev"><a id="lastPage" href="javascript:void(0)" onclick="lastPage()">← 上一页</a></li>
										<li class="active"><a id="pageNum" href="javascript:void(0)">1</a></li>
										<li class="next"><a id="nextPage" href="javascript:void(0)" onclick="nextPage()">下一页 → </a></li>
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