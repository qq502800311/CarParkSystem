<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head >
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>停车场车库页面</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" > </link>  
<script type="text/javascript" charset="UTF-8" src="js/jquery-3.3.1.js" ></script>
<script type="text/javascript" charset="UTF-8" src= "js/bootstrap.js"></script>
<script type="text/javascript" charset="UTF-8" src= "js/my/carPort.js"></script>

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
					停车场车库页面
				</h1>
				<p>
					车辆出入库操作
				</p>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<font color="white">
		<div class="col-md-8 column">
				


			<form id= "uploadForm">  
				<!-- 		手工输入车库编号部分开始 -->
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-4 control-label">请输入车库编号：</label>
					<div class="col-sm-4">
						<input class="form-control" type="text" id="carPort_num" name="carPort_num"/>
					</div>
					<div class="col-sm-2">
<!-- 						 <button onclick="clickBtn2()" class="btn btn-default">提交车库号</button> -->
					</div>
   				</div>
				<!-- 		手工输入车库编号部分结束 -->	
				<!-- 		上传车牌照片部分开始 -->		
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-5 control-label">上传车牌照片：</label>
					
						<div class="col-sm-3">
							<input type="file" name="file"/>
						</div>
						<div class="col-sm-2">
							<input type="button" value="入库" onclick="doUploadIn()" class="btn btn-default"/>  
							<input type="button" value="出库" onclick="doUploadOut()" class="btn btn-default"/>  
						</div>
					
   				</div>
   				<!-- 		上传车牌照片部分结束 --> 
   			</form>  
  
<!-- 		车辆传感器部分开始 -->			
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-5 control-label">车库进入传感器：</label>
					<div class="col-sm-6">
						<button onclick="carSensor1()" class="btn btn-default">触发传感器</button>
					</div>
					<label for="inputEmail3" class="col-sm-5 control-label">车库离开传感器：</label>
					<div class="col-sm-6">
						<button onclick="carSensor1()" class="btn btn-default">触发传感器</button>
					</div>	
				</div>
<!-- 		车辆传感器部分结束 -->   	

	

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
		  <span id="systimeshow" style="color:#FF0000"></span>
		  </TD>
          <TD width=850>
		  <MARQUEE 
            style="FILTER: glow(color=red); LINE-HEIGHT: 60px; WIDTH: 100%; FONT-FAMILY: '黑体','黑体_GB2312','黑体';
			 COLOR: #ffff00; FONT-SIZE: 50px; text-shadow: #ff0000 1px 1px 0px" 
            scrollAmount=8><B><FONT  id="displayboard" name="displayboard"
            face=Verdana>欢迎光临!</FONT></B>
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