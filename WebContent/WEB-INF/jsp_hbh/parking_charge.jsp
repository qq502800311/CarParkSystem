
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
	<link href="css/hbh/parking_charge.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" charset="UTF-8" src="js/jquery-3.3.1.js" ></script>
	<script type="text/javascript" charset="UTF-8" src= "js/bootstrap.js"></script>
	<script src="js/laydate/laydate.js" ></script> <!-- 改成你的路径 -->
	<script type="text/javascript" src="js/hbh/ichart.1.2.min.js"></script>
	<script type="text/javascript" src="js/hbh/parking_charge.js"></script>

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
					<h2><i class="halflings-icon white user"></i><span class="break"></span>出场收费</h2>
				</div>
				
<div class="container" style="margin-left: 35%;margin-top: 5%;height: 380px;">
    <table>
    	<tr>
    		<td>车牌号:</td>
    		<td><input type="text" class="form-control" id="out_license" onblur="checkLicense()"></td>
    		<td><label id="licence2"></label></td>
    		<td><button type="button" onclick="searchParkingCar()" class="btn btn-default">显示信息</button></td>
    	</tr>
    </table>
</div>
<br>
<!----------------- 收费信息显示 -------------->

<div id="parking_msg">
<!--startprint-->
    <table style="margin-top: 5%;margin-left: 10%;">
	    
         <tr>
        	<td><span>出场车牌:</span></td>
        	<td><span id="car_license"></span></td>
        </tr>    
         <tr>
        	<td><span>入场时间:</span></td>
        	<td><span id="in_date"></span></td>
        </tr> 
          <tr>
        	<td><span>出场时间:</span></td>
        	<td><span id="out_date"></span></td>
        </tr>           
        <tr>
        	<td><span>停车时间:</span></td>
        	<td><span id="user_time"></span></td>
        </tr>
        <tr>
        	<td><span>车辆类型:</span></td>
        	<td><span id="car_type"></span></td>
        </tr>
         <tr>
        	<td><span>支付金额:</span></td>
        	<td><span id="total_money"></span> 元</td>
        </tr> 
        </table>
        <!--endprint-->   
        <br>
        <table>
             
        <tr>
        	<td><button type="button" onclick="openDoor()" class="btn btn-default">收费放行</button></td>
        	<td><button type="button" onclick="closeParkingCharge()" class="btn btn-default">&nbsp;&nbsp;返 回</button></td>
        	<td><button type="button" onclick="MoneyChargePrint()" class="btn btn-default">&nbsp;&nbsp;打印小条</button></td>
        </tr>                         
    </table>
</div>
<div id="tem_hidden" style="visibility:hidden;"></div>


			</div>
		</div>
		</div>
<!-- 背景颜色 -->
<div id="fade" class="black_overlay"></div>	
</body>
</html>