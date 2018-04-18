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
<title>收款日结单</title>

<!---------- bootstrap引入 ----------->
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet">

<!------------ 日历引入 -------------->
<script type="text/javascript" src="js/hbh/dist/js/bootstrap-datepicker.min.js" ></script>
<script type="text/javascript" src="js/hbh/dist/locales/bootstrap-datepicker.zh-CN.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/hbh/calendar.js" charset="UTF-8"></script>

<script type="text/javascript" src="js/hbh/today_money_checkout.js" charset="UTF-8"></script>


</head>
<body>
<div class="container">

<table>
	<tr>
		<td><label>日结款查询:</label></td>
		<td><select class="form-control" onblur="chooseWorkTime()" id="work_time" style="width: 200px;">
			<option value="">请选择</option>
			<option value="早班">早班</option>
			<option value="中班">中班</option>
			<option value="晚班">晚班</option>
			</select>
		</td>
		<td><button type="button" onclick="seachMoney()" class="btn btn-default">查 询</button></td>
		<td><label id="work_time2"></label></td>
	</tr>
</table>
<br>
<div id="table_div">
	<table class="table table-striped" id="table" style="font-size:13px;">
		<tr>
			<th>编码</th>
			<th>时间</th>
			<th>车牌</th>
			<th>事项</th>
			<th>金额</th>
		</tr>
		<tbody id="mytable"></tbody>
	</table>
</div>
<div><label>金额合计:</label><label id="total_money"></label></div>

</div>

</body>
</html>































