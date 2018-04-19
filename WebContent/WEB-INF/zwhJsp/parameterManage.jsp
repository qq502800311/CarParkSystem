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
<title>管理端使用的菜单管理页面</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" >
<script type="text/javascript" charset="UTF-8" src="js/jquery-3.3.1.js" ></script>
<script type="text/javascript" charset="UTF-8" src= "js/bootstrap.js"></script>
<!-- laydate控件方式,layDate 采用原生 JavaScript 编写，不依赖任何第三方库，兼容所有浏览器（IE6/7除外） -->
<script src="js/laydate/laydate.js" ></script> <!-- 改成你的路径 -->
<script type="text/javascript" src="js/zwhJs/parameterManage.js" ></script>  
	

	
</head>
<body>
	<h1>参数管理</h1>
<!-- 	查询条件框部分开始 -->
	<div >
		<div>查询条件：</div>
		<div>
			<!-- 	查询条件框信息开始 -->
			<form id="searchParameterForm" method="post">
				<label>参数名称：</label>
				<input type="text" name="parameter_name">
				<label>参数类型：</label>
				<select value="" name="parameter_pid" id="parameterTyleList">
					<option value="-1" >不限</option>		
				</select>
			</form>	
			<!-- 	查询条件框信息结束 -->
			<button type="button" class="btn btn-primary" onclick="search()">查询</button>	
			<!-- 按钮触发模态框 -->
			<button class="btn btn-primary" data-toggle="modal" data-target="#myModal1">增加</button>	
		</div>
		<div>		
<!-- 			<button type="button" class="btn btn-primary" onclick="useHelp()">使用帮助</button> -->
			
		</div>
	</div>
<!-- 	查询条件框部分结束 -->

<!-- 	查询结果表格部分开始 -->
	<div>
		<table class="table table-striped" id="tab" >
			<tr>
				<td>序号</td><td>参数名称</td><td>参数类型</td><td>操作</td>
			</tr>
		</table>
	</div>
<!-- 	查询结果表格部分结束 -->

<!-- 				新增参数模态框开始 -->
				
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">新增参数</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
								<form id="addParameterForm" method="post">	
									<!-- 				要增加的参数名 -->
									<div >
										<label >参数名称：</label>
										<input id="add_parameter_name" name="parameter_name">
									</div>
									<br></br>
									<!-- 				参数类型 -->
									<div >
										<label >参数类型：</label>
										<select value="" name="parameter_pid" id="add_parameter_pid">
											<option value="0">总类型</option>
										</select>
									</div>
									<br></br>										
								</form>	
<!-- 								模态框中表单结束 -->
							</div>
							<div class="modal-footer">
								<div class="col-sm-offset-2 col-sm-10">
<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
<!-- 									<button type="button" onclick="" class="btn btn-primary">审核通过</button> -->
									<button type="button" class="btn btn-primary" onclick="addParameter()" data-dismiss="modal">提交</button>		
									<button type="button" class="btn btn-default"
										data-dismiss="modal">返回</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
<!-- 				新增参数模态框结束 -->

<!-- 				修改参数模态框开始 -->
				
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">修改参数</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
								<form id="updateParameterForm" method="post">
										<!-- 				要修改的参数ID -->
									<div >
										<label style="display:none">参数ID：</label>
										<input style="display:none" id="update_parameter_id" name="parameter_id">
									</div>
									<br></br>
										<!-- 				要修改的参数名 -->
									<div >
										<label >参数名称：</label>
										<input id="update_parameter_name" name="parameter_name">
									</div>
									<br></br>
									<!-- 				参数类型 -->
									<div >
										<label >参数类型：</label>
										<select value="" name="parameter_pid" id="update_parameter_pid">
											<option value="0">总类型</option>
										</select>
									</div>
									<br></br>		
								</form>
									
<!-- 								模态框中表单结束 -->
							</div>
							<div class="modal-footer">
								<div class="col-sm-offset-2 col-sm-10">
<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
<!-- 									<button type="button" onclick="" class="btn btn-primary">审核通过</button> -->
									<button type="button" class="btn btn-primary" onclick="updateParameterSubmit()" data-dismiss="modal">提交</button>		
									<button type="button" class="btn btn-default"
										data-dismiss="modal">返回</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
<!-- 			修改参数模态框结束 -->

</body>
</html>