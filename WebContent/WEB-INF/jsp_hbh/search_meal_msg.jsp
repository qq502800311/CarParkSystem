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
<title>套餐查询:</title>

<!---------- bootstrap引入 ----------->
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet">

<!------------ 日历引入 -------------->
<script type="text/javascript" src="js/hbh/dist/js/bootstrap-datepicker.min.js" ></script>
<script type="text/javascript" src="js/hbh/dist/locales/bootstrap-datepicker.zh-CN.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/hbh/calendar.js" charset="UTF-8"></script>

<script type="text/javascript" src="js/hbh/search_meal_msg.js" charset="UTF-8"></script>
</head>
<body>
<div class="container">
	<div id="table_div">
	<h4>套餐详情:</h4>
		<table class="table table-striped" id="table">
			<tr>
				<th>编号</th>
				<th>套餐名</th>
				<th>套餐金额</th>
				<th>套餐详情</th>
			</tr>
			<tbody id="mytable"></tbody>
		</table>
	</div>
	<ul class="pager">
		<li><a href="#">上一页</a></li>
		<li><a href="#">下一页</a></li>
	</ul>
</div>
</body>
</html>