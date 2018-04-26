
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
<!-- 	<script type="text/javascript" src="js/zwhJs/menuManage.js" ></script>  -->

	<link href="css/hbh/month_menber_manager.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="js/hbh/month_menber_manager.js"></script>


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
					<h2><i class="halflings-icon white user"></i><span class="break"></span>退费与充值</h2>
<!-- 					<div class="box-icon">
						<a href="javascript:void(0)" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
						<a href="javascript:void(0)" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
						<a href="javascript:void(0)" class="btn-close"><i class="halflings-icon white remove"></i></a>
					</div> -->
				</div>
				<!-- end: box-header -->
				
				<!-- start: box-content -->
				<div class="box-content" style="display: block;">		
					<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper" role="grid">
						<form id="searchMenuForm" method="post">

									<span>每页条量：
										<select name="pageSize" onchange="search()" size="1" aria-controls="DataTables_Table_0">
											<option value="10" selected="selected">10</option>
											<option value="20">20</option>
											<option value="30">30</option>
											<option value="50">50</option>
										</select> 
									</span>

							
									&#8195
									<span>身份证： <input id="userid" oninput="search()" placeholder="请输入身份证" type="text" aria-controls="DataTables_Table_0"></span>

									&#8195								
									<span>车牌号：
										 <input id="license" oninput="search()" placeholder="请输入车牌" aria-controls="DataTables_Table_0">
									</span>
							<!-- end: box-搜索-->
							
<!-- 									&#8195
									<button class="btn btn-primary" data-toggle="modal" data-target="#myModal1" onclick="searchUser()">查找</button> -->	
						</form>	
						<!-- start: table -->
						<table class="table table-striped table-bordered bootstrap-datatable datatable dataTable" id="DataTables_Table_0" aria-describedby="DataTables_Table_0_info">
							  <thead>
								  <tr role="row">
								  	<th class="sorting_asc" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Username: activate to sort column descending" >账号</th>
								  	<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" >身份证</th>
								  	<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" >车牌</th>
								  	<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" >手机号</th>
								  	<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" >套餐</th>
								  	<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" >启用时间</th>
								  	<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" >结束时间</th>
								  	<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" >充值金额</th>
								  	<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" >账号状态</th> 
								  	<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Actions: activate to sort column ascending" >操作</th>
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

<!----------------- 退款信息显示 -------------->
<div id="back_money">
	<!--startprint-->
    <table style="margin-top: 5%;margin-left: 10%;">
         <tr>
        	<td><label>当前时间:</label></td>
        	<td><label id="now_date"></label></td>
        </tr>   
        <tr>
        	<td><label>办理日期:</label></td>
        	<td><label id="start_date"></label></td>
        </tr>
        <tr>
        	<td><label>终止日期:</label></td>
        	<td><label id="stop_date"></label></td>
        </tr>
         <tr>
        	<td><label>剩余天数:</label></td>
        	<td><label id="remain_date"></label></td>
        </tr> 
          <tr>
        	<td><label>剩余金额:</label></td>
        	<td><label id="remain_money"></label></td>
        </tr>        
         <tr>
        	<td><label>退款金额:</label></td>
        	<td><label id="re_money"></label></td>
        </tr>
        </table>  
        <div>注：退款扣除余额30%手续费！</div>     
        <!--endprint-->
        <table> 
        <tr>
        	<td><button type="button" onclick="returnSure()" class="btn btn-default">退 款</button></td>
        	<td><button type="button" onclick="closeBackMoney()" class="btn btn-default">返 回</button></td>
        </tr>                         
    </table><br>
    <div id="userid_hidden" style="visibility:hidden;"></div>
    <div id="license_hidden" style="visibility:hidden;"></div>
</div>

<!--------------- 退款或到期用户重新充值 --------------->
<div id="recharge_money">
    <table style="margin-top: 5%;margin-left: 10%;">
         <tr>
        	<td><label>充值用户:</label></td>
        	<td><label id="recharge_name"></label></td>
        </tr>   
        <tr>
        	<td><label>证件号码:</label></td>
        	<td><label id="recharge_id"></label></td>
        </tr>
        <tr>
        	<td><label>车牌号码:</label></td>
        	<td><label id="recharge_license"></label></td>
        </tr>
        <tr>
			<td><label>选择套餐:</label></td>
			<td><select class="form-control" name="meal_id" onblur="selectMeal()" id="selectMeal" style="width: 100px;">
					<option value="">请选择</option>
					<option value="1">月套餐</option>
					<option value="2">季套餐</option>
					<option value="3">半年套餐</option>
				</select>
			</td> 
			<td><label id="meal2"></label></td>          
		</tr>
        <tr>
        	<td><button type="button" onclick="recharge()" class="btn btn-default">充 值</button></td>
        	<td><button type="button" onclick="closeRecharge()" class="btn btn-default">返 回</button></td>
        </tr>                         
    </table>
</div>

<!-- 背景颜色 -->
<div id="fade" class="black_overlay"></div>

</html>