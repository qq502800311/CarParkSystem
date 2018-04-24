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
<title>数据展示</title>

<!---------- bootstrap引入 ----------->
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet">

<!------------ 日历引入 -------------->
<script type="text/javascript" src="js/hbh/dist/js/bootstrap-datepicker.min.js" ></script>
<script type="text/javascript" src="js/hbh/dist/locales/bootstrap-datepicker.zh-CN.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/hbh/calendar.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/hbh/ichart.1.2.min.js"></script>
<script type="text/javascript" src="js/hbh/show_date.js" charset="UTF-8"></script>

</head>
<body>
<div id='canvasDiv'></div>
<div id='canvasDiv2'></div>
</body>
</html>