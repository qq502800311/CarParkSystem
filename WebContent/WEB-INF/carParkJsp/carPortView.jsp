<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String basepath = application.getContextPath();
	
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当前停车场鸟瞰图页面</title>

<link rel="stylesheet" type="text/css" href=<%=basepath+"/css/bootstrap.css"%> >
<script type="text/javascript" charset="UTF-8" src=<%=basepath+"/js/jquery-3.3.1.js"%>></script>
<script type="text/javascript" charset="UTF-8" src=<%=basepath+"/js/bootstrap.js"%>></script>
<script type="text/javascript" charset="UTF-8" src=<%=basepath+"/js/my/fabric.min.js"%>></script>
<!-- laydate控件方式,layDate 采用原生 JavaScript 编写，不依赖任何第三方库，兼容所有浏览器（IE6/7除外） -->
<script type="text/javascript" src=<%=basepath+"/js/my/carParkView.js"%> ></script>  
	

	
</head>
<body>
	<h1>停车场鸟瞰图</h1>
<!-- 	查询条件框部分开始 -->
	<div >
			<button class="btn btn-primary" data-toggle="modal" data-target="#myModal1">待用按钮</button>	
			<button type="button" class="btn btn-primary" onclick="useHelp()">使用帮助</button>		
	</div>
<!-- 	查询条件框部分结束 -->
	<canvas id="myCanvas" width="2000" height="3000"></canvas>
<!-- 	车位鸟瞰图画布开始 -->
	<div>
		
	</div>
<!-- 	车位鸟瞰图画布结束 -->



<!-- 				查看车位信息模态框开始 -->
				
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">查看车位详细信息</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
									<!-- 				要增加的人员姓名 -->
									<div >
										<label >车位编号：</label>
										<label id="carPort_id">车位编号</label>
									</div>
									<br></br>
									<!-- 				要增加的人员姓名 -->
									<div >
										<label >车位状态：</label>
										<label id="carPort_status">车位状态</label>
									</div>
									<br></br>
									<!-- 				选择所属科室 -->
									<div >
										<label >车位车辆车牌：</label>
										<label id="carPort_license">车位车辆车牌</label>
									</div>
									<br></br>
									<!-- 				选择所属角色 -->
									<div >
										<label >车位停放车辆照片</label>
										<img src=""  alt="暂无图片" id="carPort_pic" width=300px/>
									</div>
									<br></br>
									
									
<!-- 								模态框中表单结束 -->
							</div>
							<div class="modal-footer">
								<div class="col-sm-offset-2 col-sm-10">
<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
<!-- 									<button type="button" onclick="" class="btn btn-primary">审核通过</button> -->
<!-- 									<button type="button" class="btn btn-default" onclick="changeEmpApply()" data-dismiss="modal">修改</button>		 -->
									<button type="button" class="btn btn-primary"
										data-dismiss="modal">确定</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
<!-- 			查看车位信息模态框结束 -->
</body>
</html>