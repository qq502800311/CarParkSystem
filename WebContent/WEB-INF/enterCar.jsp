<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String basepath = application.getContextPath();
%>

<html>
<head >
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>停车场入口页面</title>

<script type="text/javascript" charset="UTF-8" src="js/jquery-3.3.1.js" ></script>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" > </link>  
<script type="text/javascript" charset="UTF-8" src= "js/bootstrap.js"></script>

<!-- LED显示效果JS开始 -->
<script language="javascript">
	function getCurDate() {
		var d = new Date();
		var week;
		switch (d.getDay()) {
		case 1:
			week = "星期一";
			break;
		case 2:
			week = "星期二";
			break;
		case 3:
			week = "星期三";
			break;
		case 4:
			week = "星期四";
			break;
		case 5:
			week = "星期五";
			break;
		case 6:
			week = "星期六";
			break;
		default:
			week = "星期天";
		}
		var years = d.getFullYear();
		var month = add_zero(d.getMonth() + 1);
		var days = add_zero(d.getDate());
		var hours = add_zero(d.getHours());
		var minutes = add_zero(d.getMinutes());
		var seconds = add_zero(d.getSeconds());
		var ndate = years + "年" + month + "月" + days + "日 " + hours + ":"
				+ minutes + ":" + seconds + " " + week;
		var divT = document.getElementById("systimeshow");
		divT.innerHTML = ndate;
	}

	function add_zero(temp) {
		if (temp < 10)
			return "0" + temp;
		else
			return temp;
	}
	setInterval("getCurDate()", 100);
</script>
<!-- LED显示效果JS结束 -->

<script type="text/javascript" language="javascript">

	
</script>

</head>
<body>


	<nav class="navbar navbar-inverse">
<!-- 	头部导航栏开始 -->
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/park/home.action"><span class="glyphicon glyphicon-home"></span> 首页</a>
<%-- 			<a class="navbar-brand" href=<%="login.action?user.name=home" %>><span class="glyphicon glyphicon-home"></span> 首页</a> --%>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<ul class="nav navbar-nav">
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="pageShift.action?req=register">注册</a></li>
				<li><a href="#">帮助</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">备用菜单 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- 	头部导航栏结束 -->

<!-- 	下部内容开始 -->
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="jumbotron">
				<h1>
					停车场入口页面
				</h1>
				<p>
					综合显示停车场内所有信息
				</p>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<font color="white">
		<div class="col-md-8 column">
			<form class="form-horizontal" role="form" action="park/entranceDisplay.action" method="post">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-4 control-label">请输入车牌</label>
					<div class="col-sm-4">
						<input class="form-control" type="text" name="carLisence"/>
					</div>
   				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-4">
						 <button type="submit" class="btn btn-default">提交车牌</button>
					</div>
				</div>
			</form>
			
		</div>
		</font>
		<div class="col-md-2 column">
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
		</div>
	</div>
	<div class="row clearfix">
<!-- 		LED显示屏部分开始 -->
<TABLE border=0 cellSpacing=0 cellPadding=0 width=1000 
      background=img/led.png align=center height=40>
        <TBODY>
        <TR>
          <TD height=66 width=150>
		  <span id="systimeshow" style="color:#FF0000">
		  <script language="javascript">getCurDate();</script></span>
		  </TD>
          <TD width=850>
		  <MARQUEE 
            style="FILTER: glow(color=red); LINE-HEIGHT: 60px; WIDTH: 100%; FONT-FAMILY: '黑体','黑体_GB2312','黑体';
			 COLOR: #ffff00; FONT-SIZE: 50px; text-shadow: #ff0000 1px 1px 0px" 
            scrollAmount=8><B><FONT 
            face=Verdana>欢迎光临！您的车牌号是：闽D88888</FONT></B>
			</MARQUEE>
		  </TD>
		</TR>
		</TBODY>
		</TABLE>
<!-- 		LED显示屏部分结束 -->		
	</div>
</div>
<!-- 	下部内容结束 -->

</nav>

</body>
</html>