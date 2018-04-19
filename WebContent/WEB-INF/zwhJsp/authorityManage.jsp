

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
<title></title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" >  
<link rel="stylesheet" type="text/css" href="css/zwhCss/zTreeStyle.css" > 
<script type="text/javascript" charset="UTF-8" src="js/jquery-3.3.1.js" ></script>
<script type="text/javascript" charset="UTF-8" src= "js/bootstrap.js"></script>
<!-- <script type="text/javascript" charset="UTF-8" src= "js/zwhJs/jquery-1.4.4.min.js"></script> -->
<script type="text/javascript" charset="UTF-8" src= "js/zwhJs/jquery.ztree.core.js"></script>
<script type="text/javascript" charset="UTF-8" src= "js/zwhJs/jquery.ztree.excheck.js"></script>
<script type="text/javascript" charset="UTF-8" src= "js/zwhJs/authorityManage.js"></script>
	
</head>
</head>
  
<body>  
	<ul id="cityTree" class="ztree"></ul> 
	<button onclick="submit()">提交</button> 
</body>
  
</html>