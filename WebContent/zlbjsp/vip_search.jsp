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
<title>管理端使用的用户查询页面</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script type="text/javascript" charset="UTF-8" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" charset="UTF-8" src="js/bootstrap.js"></script>
<!-- laydate控件方式,layDate 采用原生 JavaScript 编写，不依赖任何第三方库，兼容所有浏览器（IE6/7除外） -->
<!-- <script src="js/laydate/laydate.js"></script> -->
<!-- 改成你的路径 -->
<script type="text/javascript" src="js/zlbjs/vip_search.js"></script>



</head>
<body>
	<h1>白名单查询与管控</h1>
	<!-- 	查询条件框部分开始 -->
	<div>
		<div>查询条件：</div>
		<div>
			<form id="condition_from">
				<label>车牌号：</label> <input type="text" name="car_park_license">
				<button type="button" class="btn btn-primary" onclick="search()">查询</button>
			</form>
			<!-- 按钮触发模态框 -->
			<button class="btn btn-primary" data-toggle="modal"
				data-target="#myModal1">增加</button>

		</div>
		<div></div>
		<div>
			

		</div>
	</div>
	<!-- 	查询条件框部分结束 -->

	<!-- 	查询结果表格部分开始 -->
	<div>
		<table class="table table-striped" id="myShowtab">
			<thead>
				<tr>
					<td>序号</td>
					<td>车牌</td>
					<td>车辆状态</td>
					<td>操作</td>

				</tr>
			</thead>
			<tbody id="myShowbody"></tbody>
		</table>
	</div>
	<!-- 	查询结果表格部分结束 -->

	<!-- 				查看单模态框开始 -->

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="myModalLabel">新增车辆白名单</h4>
				</div>
				<div class="modal-body" align="center">
					<!-- 								模态框中表单开始 -->
					<!-- 				要增加的人员姓名 -->
					<div>
						<label>车牌号</label> <input id="newvip_Name" type="text">
					</div>
					<br></br>
					<!-- 				设置密码1 -->
					<div>
						

					</div>
					<br></br>
					<!-- 				设置密码2 -->
					<div>
						
					</div>
					<br></br>
					<!-- 				选择所属科室 -->
					<div>
						
					</div>
					<br></br>
					<!-- 				选择所属角色 -->
					<div>
						
					</div>
					<br></br>


					<!-- 								模态框中表单结束 -->
				</div>
				<div class="modal-footer">
					<div class="col-sm-offset-2 col-sm-10">
						<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
						<!-- 									<button type="button" onclick="" class="btn btn-primary">审核通过</button> -->
						<button type="button" class="btn btn-primary"
							onclick="addVipcar()" data-dismiss="modal">提交</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- 				查看单模态框结束 -->

	<!-- 				修改人员模态框开始 -->

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="myModalLabel" >修改白名单</h4>
				</div>
				<div class="modal-body" align="center">
					<!-- 								模态框中表单开始 -->
					<!-- 				要增加的人员姓名 -->
					<div>
						<label> 当前车牌 </label> <label id="changecar_park_license">---</label>
					</div>
					<br></br>
					<!-- 				要修改的车牌号 -->
					<div>
						<label>车牌号：</label> <input  type="text" id="modifiercarparkchangeCarparklicense"> 
					</div>
					<br></br>
					
					<div>
						
					</div>
					<br></br>
					
					<div>
						
					</div>
					<br></br>


					<!-- 								模态框中表单结束 -->
				</div>
				<div class="modal-footer">
					<div class="col-sm-offset-2 col-sm-10">
						
						<button type="button" class="btn btn-primary"
							onclick="changeCarparklicense()" data-dismiss="modal">修改</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- 			修改人员模态框结束 -->
</body>
</html>