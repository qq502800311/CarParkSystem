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
<title>停车场出入口页面</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" > </link>  
<script type="text/javascript" charset="UTF-8" src= "js/jquery-3.3.1.js" ></script>
<script type="text/javascript" charset="UTF-8" src= "js/bootstrap.js"></script>
<script type="text/javascript" charset="UTF-8" src= "js/my/doorCar.js"></script>
<script type="text/javascript" charset="UTF-8" src= "js/my/fabric.min.js"></script>
<script type="text/javascript" language="javascript">

</script>

</head>
<body>

<!-- 		LED显示屏部分开始 -->
<TABLE border=0 cellSpacing=0 cellPadding=0 width=1000 
      background=Image/led.png align=center height=40>
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
            face=Verdana>欢迎光临!欢迎光临2!欢迎光临3!欢迎光临4!欢迎光临5!欢迎光临6!欢迎光临7!欢迎光临8!欢迎光临9!</FONT></B>
			</MARQUEE>
		  </TD>
		</TR>
		</TBODY>
		</TABLE>
<!-- 		LED显示屏部分结束 -->		

<!-- 	停车场出入口画布开始style="background: Black" -->
	<canvas id="myCanvas" width="1500" height="650" ></canvas>
<!-- 	停车场出入口画布结束 -->

<!-- 				车辆入场模态框开始 -->
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">车辆入场</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
					<!-- 		上传车牌照片部分开始 -->
						<form id="uploadForm1">
							<div class="col-sm-5">
								<label for="inputEmail3" class="col-sm-5 control-label">上传车牌照片：</label>
								<input type="file" name="file" />
							</div>
						</form>
					<!-- 		上传车牌照片部分结束 -->
<!-- 								模态框中表单结束 -->
							</div>
							<div class="modal-footer">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="button" class="btn btn-default" onclick="carInUpload()" data-dismiss="modal">上传</button>		
									<button type="button" class="btn btn-primary" data-dismiss="modal">返回</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
<!-- 			车辆入场模态框结束 -->

<!-- 				车辆出场模态框开始 -->
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">车辆出场</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
					<!-- 		上传车牌照片部分开始 -->
						<form id="uploadForm2">
							<div class="col-sm-5">
								<label for="inputEmail3" class="col-sm-5 control-label">上传车牌照片：</label>
								<input type="file" name="file" />
							</div>
						</form>
					<!-- 		上传车牌照片部分结束 -->
<!-- 								模态框中表单结束 -->
							</div>
							<div class="modal-footer">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="button" class="btn btn-default" onclick="carOutUpload()" data-dismiss="modal">上传</button>		
									<button type="button" class="btn btn-primary" data-dismiss="modal">返回</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
<!-- 			车辆出场模态框结束 -->


</body>
</html>