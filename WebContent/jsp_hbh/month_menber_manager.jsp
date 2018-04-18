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
<link href="css/hbh/month_menber_manager.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/hbh/month_menber_manager.js"></script>
</head>
<body>
<div class="container">

	<table style="border-collapse:separate;border-spacing:10px;">
		<tr>
		<td><label>身份证:</label></td>
		<td><input type="text" class="form-control" id="userid" placeholder="请输入身份证" style="width: 200px;"></td>
		<td><label>车牌号:</label></td>
		<td><input type="text" class="form-control" id="license" placeholder="请输入车牌" style="width: 200px;"></td>
		<td><button type="button" onclick="searchUser()" class="btn btn-default">查 找</button></td>
		</tr>
	</table>

	<div id="table_div">
		<table class="table table-striped" id="table" style="font-size:13px;">
			<tr>
				<th>账号</th>
				<th>身份证</th>
				<th>车牌</th>
				<th>手机号</th>
				<th>套餐</th>
				<th>启用时间</th>
				<th>结束时间</th>
				<th>充值金额</th>
				<th>账号状态</th>
				<th>操作</th>
			</tr>
			<tbody id="mytable"></tbody>
		</table>
	</div>
 	<label id="username"></label>
	<ul class="pager">
		<li><a href="#">上一页</a></li>
		<li><a href="#">下一页</a></li>
	</ul>
</div>

<!----------------- 退款信息显示 -------------->
<div id="back_money">
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

        <tr>
        	<td><button type="button" onclick="returnSure()" class="btn btn-default">退 款</button></td>
        	<td><button type="button" onclick="closeBackMoney()" class="btn btn-default">返 回</button></td>
        </tr>                         
    </table><br>
    <div>注：退款扣除余额30%手续费！</div>
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
</body>
</html>