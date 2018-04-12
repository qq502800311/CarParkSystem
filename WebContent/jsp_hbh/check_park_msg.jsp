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
<title>停车场实况查看</title>

<!---------- bootstrap引入 ----------->
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet">

<!------------ 日历引入 -------------->
<script type="text/javascript" src="js/hbh/dist/js/bootstrap-datepicker.min.js" ></script>
<script type="text/javascript" src="js/hbh/dist/locales/bootstrap-datepicker.zh-CN.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/hbh/calendar.js" charset="UTF-8"></script>

<script type="text/javascript" src="js/hbh/check_park_msg.js" charset="UTF-8"></script>

</head>
<body>
<div class="container">

	<div class="form-group">
	<h4><label>车位信息查看：</label></h4>
	<table style="border-collapse:separate;border-spacing:0px 10px;" style="border-collapse:separate;border-spacing:0px 5px;">
		<tr>
			<td>已使用车位:</td>
			<td><input type="text" class="form-control" id="using_port"></td>
			<td>空余车位:</td>
			<td><input type="text" class="form-control" id="remain_port"></td>
			<td><button class="btn btn-default" type="button" onclick="check_port_msg()">查 看</button></td>
		</tr>	
	</table>
	</div>
</div>

</body>
</html>































