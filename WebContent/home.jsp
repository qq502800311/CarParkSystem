<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到主页</title>

<script type="text/javascript" charset="UTF-8" src="js/jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script type="text/javascript" charset="UTF-8" src="js/bootstrap.js"></script>
	

	
</head>
<body>
	<nav class="navbar navbar-inverse">
<!-- 	头部导航栏开始 -->
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="pageShift.action?req=home"><span class="glyphicon glyphicon-home"></span> 首页</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      
			</ul>
      
      <ul class="nav navbar-nav navbar-right">
        <!-- 	停车场入口开始 -->
      	<li><a href="park/entrance.action">停车入口</a></li>
      	<!-- 	停车场入口结束 -->
      	 <!-- 	停车场车库开始 -->
      	<li><a href="park/carPort.action">车场车库界面</a></li>
      	<!-- 	停车场车库结束 -->
      	 <!-- 	停车场出口开始 -->
      	<li><a href="park/export.action">停车出口</a></li>
      	<!-- 	停车场出口结束 -->
       	<li><a href="emp/pageLogin.action">员工登录</a></li>
       	<li><a href="pageShift.action?req=admin_login">会员登录</a></li>
        <li><a href="#">帮助</a></li>
        
      </ul>
    </div>
  </div>
<!-- 	头部导航栏结束 -->

<!-- 	中部轮放图片开始 -->
  <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-12 column">
				</div>
			</div>
			<div class="carousel slide" id="carousel-359342">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-359342">
					</li>
					<li data-slide-to="1" data-target="#carousel-359342">
					</li>
					<li data-slide-to="2" data-target="#carousel-359342">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="Image/BMW_I8.jpg"> />
						<div class="carousel-caption">
							<h4>
								传一智能停车场
							</h4>
							<p>
								智慧停车独角兽传一科技：将再造万亿级价值新市场
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="Image/TESLA.jpg"/>
						<div class="carousel-caption">
							<h4>
								传一智能停车场
							</h4>
							<p>
								智慧停车巨头传一科技正式进军共享单车行业
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="Image/BMW_I8.jpg"/>
						<div class="carousel-caption">
							<h4>
								第三张图片标题
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-359342" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-359342" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div>
	</div>
<!-- 	中部轮放图片结束 -->	


</div>
</nav>

</body>
</html>