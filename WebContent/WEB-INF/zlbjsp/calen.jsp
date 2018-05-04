<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>

<title>收费员排班</title>
<base href="<%=basePath%>">
<meta name="description" content="Bootstrap Metro Dashboard">
<meta name="author" content="Dennis Ji">
<meta name="keyword"
	content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<!-- end: Meta -->

<!-- start: Mobile Specific -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- end: Mobile Specific -->

<!-- start: CSS -->
<link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link id="base-style" href="css/style.css" rel="stylesheet">
<link id="base-style-responsive" href="css/style-responsive.css"
	rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'
	rel='stylesheet' type='text/css'>
<!-- end: CSS -->

<!-- start:自己的包 -->

<link rel='stylesheet' type='text/css'
	href="css/zlb/caleadar/fullcalendar.min.css" >
<link rel='stylesheet' media='print'
	href="css/zlb/caleadar/fullcalendar.print.min.css" >
<script type="text/javascript"
	src="js/zlbjs/caleadar/moment.min.js" 
	charset="UTF-8"></script>
<script type="text/javascript"
	src="js/zlbjs/caleadar/jquery.min.js" 
	charset="UTF-8"></script>
<script type="text/javascript"
	src="js/zlbjs/caleadar/jquery-ui.min.js" 
	charset="UTF-8"></script>
<script type="text/javascript"
	src="js/zlbjs/caleadar/fullcalendar.min.js" 
	charset="UTF-8"></script>
<script type="text/javascript"
	src="js/zlbjs/caleadar/locale-all.js" 
	charset="UTF-8"></script>
<script type="text/javascript"
	src="js/zlbjs/caleadar/calendar.js"
	charset="UTF-8"></script>
	<link type='text/css'
	href="css/bootstrap.css" 
	rel="stylesheet" />
<script type="text/javascript"
	src="js/bootstrap.js"
	charset="UTF-8"></script>


<!-- 改成你的路径 -->


<!-- laydate控件方式,layDate 采用原生 JavaScript 编写，不依赖任何第三方库，兼容所有浏览器（IE6/7除外） -->


<!-- end:自己的包 -->

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="css/ie.css" rel="stylesheet">
	<![endif]-->

<!--[if IE 9]>
		<link id="ie9style" href="css/ie9.css" rel="stylesheet">
	<![endif]-->

<!-- start: Favicon -->

<!-- end: Favicon -->









</head>

<style>
body {
	overflow: hidden;
	width: 95%;
	margin: auto;
	height: 500px;
	//
	这里要定义本页面最小高度，方便iframe自适应
/* 	margin-top: 40px; */
/* 	text-align: center; */
/* 	font-size: 14px; */
/* 	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif; */
}

#wrap {
	width: 100%;
	margin: 0 auto;
}

#external-events {
	float: left;
	width: 13%;
	padding: 0 10px;
	border: 1px solid #ccc;
	background: #eee;
	text-align: left;
}

#external-events h4 {
	font-size: 16px;
	margin-top: 0;
	padding-top: 1em;
}

#external-events .fc-event {
	margin: 10px 0;
	cursor: pointer;
}

#external-events p {
	margin: 1.5em 0;
	font-size: 11px;
	color: #666;
}

#external-events p input {
	margin: 0;
	vertical-align: middle;
}

#calendar {
	float: right;
	width: 83%;
}
</style>
</head>
<body>

<div id="content" class="span11">

		<!-- start: 页头 -->
<!-- 		<ul class="breadcrumb"> -->
<!-- 			<li><i class="icon-home"></i> <a href="index.html">Home</a> <i -->
<!-- 				class="icon-angle-right"></i></li> -->
<!-- 			<li><a href="javascript:void(0)">收费员排班</a></li> -->
<!-- 		</ul> -->
		<!-- end: 页头 -->

		<div class="row-fluid sortable">
		<!-- 内容开始 -->


	<div id='wrap'>

		<div id='external-events'>
			<h4 dpt="早班">早班</h4>
			<c:forEach var="i" items="${emplist}">
				<div class='fc-event' id="${i.emp_id}" sc_class="早班">${i.emp_name}</div>
				</c:forEach>
				<h4 dpt="午班">午班</h4>
			<c:forEach var="i" items="${emplist}">
				<div class='fc-event' id="${i.emp_id}" sc_class="午班">${i.emp_name}</div>
			</c:forEach>
			<h4 dpt="午班">晚班</h4>
			<c:forEach var="i" items="${emplist}">
			<div class='fc-event' id="${i.emp_id}" sc_class="晚班">${i.emp_name}</div>
			</c:forEach>

		</div>

		<div id='calendar'></div>

		<div style='clear: both'></div>

	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">
					确认删除
				</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
         <div class="modal-body">确认删除！
         <input name='scid' type='hidden' size='15' id='scid' value='' />
         </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="sc_delete()">提交更改</button>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</body>
</html>