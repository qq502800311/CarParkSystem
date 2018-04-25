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

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<title>Insert title here</title>
</head>
<body>
      <div class="page-container">
            <h1>Login</h1>
            <form action="emp/login.action" method="post">
                <input type="text" id="inputEmail3" name="emp_id" class="username" placeholder="Username">
                <input type="password" id="inputPassword3" name="emp_pwd" class="password" placeholder="Password">
                <input id="code" name="code" type="text" size="5" placeholder="验证码"/>&#8195
						<img src="emp/createCode.action" alt="验证码" title="点击更换" id="codeImg"/>
                <button type="submit">Sign me in</button>
                <div class="error"><span>+</span></div>
            </form>
            <div class="connect">
                <p>Or connect with:</p>
                <p>
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                </p>
            </div>
        </div>
        <div align="center">Collect from <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">首页</a></div>

        <!-- Javascript -->
        <script src="js/zlbjs/assets/jquery-1.8.2.min.js"></script>
        <script src="js/zlbjs/assets/supersized.3.2.7.min.js"></script>
        <script src="js/zlbjs/assets/supersized-init.js"></script>
        <script src="js/zlbjs/assets/scripts.js"></script>
     
</body>
</html>