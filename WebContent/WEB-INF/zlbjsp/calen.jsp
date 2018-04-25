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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收费员排班</title>
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
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<style>
body {
	margin-top: 40px;
	text-align: center;
	font-size: 14px;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
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
</body>
</html>