<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link rel='stylesheet'
	href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
<link rel="stylesheet" href="css/zlb/reset.css">
<link rel="stylesheet" href="css/zlb/supersized.css">
<link rel="stylesheet" href="css/zlb/style.css">

<!-- 自己的包-->
<script type="text/javascript" charset="UTF-8" src="js/jquery-3.3.1.js" ></script>
<script type="text/javascript" charset="UTF-8" src="js/zwhJs/empLogin.js"></script>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<title>用户登录</title>
</head>
<body>
      <div class="page-container">
            <h1>登录</h1>
            <form action="emp/login.action" method="post">
                <input type="text" id="inputEmail3" name="emp_id" class="username" placeholder="用户名" value="${emp_id}">
                <span style="color:red" >${errorMsg}</span>
                
                <input type="password" id="inputPassword3" name="emp_pwd" class="password" placeholder="密码">
                
                <input id="code" name="code" type="text" size="5" placeholder="验证码"/>&#8195
						<img src="emp/createCode.action" alt="验证码" title="点击更换" id="codeImg"/>
                <button type="submit">登录</button>
                <div class="error"><span>+</span></div>
            </form>
            
        </div>
        

        <!-- Javascript -->
        <script src="js/zlbjs/assets/jquery-1.8.2.min.js"></script>
        <script src="js/zlbjs/assets/supersized.3.2.7.min.js"></script>
        <script src="js/zlbjs/assets/supersized-init.js"></script>
        <script src="js/zlbjs/assets/scripts.js"></script>
     
</body>
</html>