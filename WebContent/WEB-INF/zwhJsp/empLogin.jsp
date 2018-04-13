<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head >
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录页面</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" > </link> 
<script type="text/javascript" charset="UTF-8" src="js/jquery-3.3.1.js" ></script>
<script type="text/javascript" charset="UTF-8" src= "js/bootstrap.js"></script>
<script type="text/javascript" charset="UTF-8" src="js/zwhJs/empLogin.js"></script>
	
	
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
			<a class="navbar-brand" href=<%=basePath+"/home.jsp" %>><span
				class="glyphicon glyphicon-home"></span> 首页</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<ul class="nav navbar-nav">
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">登录</a></li>
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
					管理员登录
				</h1>
				<p>
					登录之后可以使用更多功能
				</p>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-4 column">
		</div>
		<div class="col-md-4 column">
		
<!----------------------------------------- 登录部分开始 ------------------------------------------------------->		
			<form class="form-horizontal" role="form" action="emp/login.action" method="post">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-10">
						<input class="form-control" id="inputEmail3" name="emp_id" value="${emp_id}"/>
						<span style="color:red" >${errorMsg}</span>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3" name="emp_pwd"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="verifyCode" class="col-sm-2 control-label">验证码</label>
					<div class="col-sm-10">
						<input id="code" name="code" type="text" size="5"/>&#8195
						<img src="emp/createCode.action" alt="验证码" title="点击更换" id="codeImg"/>
					</div>
				</div>				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							 <label><input type="checkbox" name="autologin" value="ok"/>记住我</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-default">登录</button>
					</div>
				</div>
			</form>
		</div>
<!----------------------------------------- 登录部分结束 ------------------------------------------------------->			
		
		<div class="col-md-4 column">
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-4 column">
			<h2>
				Heading
			</h2>
			<p>
				Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
			</p>
			<p>
				 <a class="btn" href="#">View details »</a>
			</p>
		</div>
		<div class="col-md-4 column">
			<h2>
				Heading
			</h2>
			<p>
				Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
			</p>
			<p>
				 <a class="btn" href="#">View details »</a>
			</p>
		</div>
		<div class="col-md-4 column">
			<h2>
				Heading
			</h2>
			<p>
				Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
			</p>
			<p>
				 <a class="btn" href="#">View details »</a>
			</p>
		</div>
	</div>
</div>
<!-- 	下部内容结束 -->

</nav>

</body>
</html>