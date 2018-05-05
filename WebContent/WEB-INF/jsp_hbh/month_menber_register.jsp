
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
	<script type="text/javascript" src="js/hbh/ichart.1.2.min.js"></script>
	<script type="text/javascript" src="js/hbh/month_menber_register.js"></script>

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
					<h2><i class="halflings-icon white user"></i><span class="break"></span>月缴注册</h2>
				</div>
				
					<div id="register" style="margin-left: 30%;margin-top: 3%;height:px;">
	
	<table style=" border-collapse:   separate;   border-spacing:   10px;">
	<tr>
		<td><label for="firstname">用户名:</label></td>
		<td><input type="text" class="form-control" id="username" name="user_name" placeholder="请输入账号" onblur="checkName()" style="width: 200px;"></td>
		<td><label id="username2"></label></td>	
	</tr>
	
	<tr>
		<td><label for="lastname" >密码:</label></td>
		<td><input type="password" class="form-control" name="user_pwd" id="pwd" placeholder="请输入密码" onblur="checkPwd()" style="width: 200px;"></td>
		<td><label id="pwd2"></label></td>
	</tr>
	
	<tr>
		<td><label for="lastname" >确认密码:</label></td>
		<td><input type="password" class="form-control" id="repwd" placeholder="请输入密码" onblur="checkRePwd()" style="width: 200px;"></td>
		<td><label id="repwd2"></label></td>
	</tr>
	<tr>
		<td><label for="lastname">身份证:</label></td>
		<td><input type="text" class="form-control" name="user_id" id="userid" placeholder="请输入身份证" onblur="checkUserid()" style="width: 200px;"></td>
		<td><label id="userid2"></label></td>
	</tr>
	<tr>
		<td><label for="lastname">车牌号码:</label></td>
		<td><input type="text" class="form-control" name="car_park_license" id="licence" placeholder="请输入车牌" onblur="checkLicense()" style="width: 200px;"></td>
		<td><label id="licence2"></label></td>
	</tr>
	<tr>
		<td><label>选择套餐:</label></td>
		
		<td>
		<select class="form-control" name="meal_id" onblur="selectMeal()" id="selectMeal" style="width: 200px;">
				<option value="">请选择</option>
				<c:forEach var="i" items="${meals}" varStatus="vrolemenus">
					<option value="${i.meal_id}">${i.meal_name}</option>
				</c:forEach>
		</select>		
		</td>
		
		
		<td><label id="meal2"></label></td>
	</tr>
	<tr>
		<td><label>手机号:</label></td>
		<td><input type="text" class="form-control" id="phone" placeholder="请输入手机号" name="user_phone" onblur="checkPhone()" style="width: 200px;"></td>
		<td><label id="phone2"></label></td>
	</tr>
	<tr>
		<td colspan="3" style="text-align: center;"><button type="button" onclick="addUser()" class="btn btn-default">注册</button></td>
	</tr>	
	</table>

	</div>
			</div>
		</div>
		</div>

	
</body>
</html>