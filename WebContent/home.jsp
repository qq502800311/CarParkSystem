<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String basepath = application.getContextPath();
	
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到主页</title>

<script type="text/javascript" charset="UTF-8" src=<%=basepath+"/js/jquery-3.3.1.js" %>></script>
<link rel="stylesheet" type="text/css" href=<%=basepath+"/css/bootstrap.css" %>>
<script type="text/javascript" charset="UTF-8" src=<%=basepath+"/js/bootstrap.js" %>></script>
	

	
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
      <a class="navbar-brand" href="<%=basepath+"/pageShift.action?req=home" %>"><span class="glyphicon glyphicon-home"></span> 首页</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      
			</ul>
      
      <ul class="nav navbar-nav navbar-right">
       	<li><a href=<%=basepath+"/pageShift.action?req=login" %>>用户登录</a></li>
       	<li><a href=<%=basepath+"/pageShift.action?req=admin_login" %>>管理登录</a></li>
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
						<img alt="" src=<%=basepath+"/Image/IS2.jpg" %> />
						<div class="carousel-caption">
							<h4>
								第一张图片
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src=<%=basepath+"/Image/IV.jpg" %> />
						<div class="carousel-caption">
							<h4>
								第二张图片
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src=<%=basepath+"/Image/IV-D.jpg" %> />
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