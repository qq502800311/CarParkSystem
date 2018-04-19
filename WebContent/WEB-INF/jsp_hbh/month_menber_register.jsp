<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>月缴费用户办理</title>
<!---------- bootstrap引入 ----------->
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet">

<script type="text/javascript" src="js/hbh/month_menber_register.js"></script>
</head>
<body>

	<div id="register" style="margin-left: 30%;margin-top: 1%;">
	
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
		<td><select class="form-control" name="meal_id" onblur="selectMeal()" id="selectMeal" style="width: 200px;">
				<option value="">请选择</option>
				<option value="1">月套餐</option>
				<option value="2">季套餐</option>
				<option value="3">半年套餐</option>
			</select>
		</td>
		<td><label id="meal2"></label></td>
	</tr>
	<tr>
		<td><label>手机号:</label></td>
		<td><input type="text" class="form-control" id="phone" placeholder="请输入手机号" name="user_phone" onblur="checkPhone()" style="width: 200px;"></td>
		<td><label id="phone2"></label></td>
	</tr>
	
	</table>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" onclick="addUser()" class="btn btn-default">注册</button>
		</div>
	</div>
	</div>
</body>
</html>