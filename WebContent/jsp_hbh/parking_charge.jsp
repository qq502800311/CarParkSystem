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
<title>车辆出场收费</title>
<!---------- bootstrap引入 ----------->
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet">
<link href="css/hbh/parking_charge.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/hbh/parking_charge.js"></script>
</head>
<body>
<div class="container">
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
    <table style="margin-top: 5%;margin-left: 10%;">
         <tr>
        	<td><label>出场车牌:</label></td>
        	<td><label id="car_license"></label></td>
        </tr>    
         <tr>
        	<td><label>入场时间:</label></td>
        	<td><label id="in_date"></label></td>
        </tr> 
          <tr>
        	<td><label>出场时间:</label></td>
        	<td><label id="out_date"></label></td>
        </tr>           
        <tr>
        	<td><label>停车时间:</label></td>
        	<td><label id="user_time"></label><label>小时</label></td>
        </tr>
        <tr>
        	<td><label>车辆类型:</label></td>
        	<td><label id="car_type"></label></td>
        </tr>
         <tr>
        	<td><label>支付金额:</label></td>
        	<td><label id="total_money"></label><label>元</label></td>
        </tr>              
        <tr>
        	<td><button type="button" onclick="openDoor()" class="btn btn-default">收费放行</button></td>
        </tr>                         
    </table>
</div>
<div id="tem_hidden" style="visibility:hidden;"></div>
<!-- 背景颜色 -->
<div id="fade" class="black_overlay"></div>
</body>
</html>