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
<title>管理端使用的用户查询页面</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" >
<script type="text/javascript" charset="UTF-8" src="js/jquery-3.3.1.js" ></script>
<script type="text/javascript" charset="UTF-8" src= "js/bootstrap.js"></script>
<!-- laydate控件方式,layDate 采用原生 JavaScript 编写，不依赖任何第三方库，兼容所有浏览器（IE6/7除外） -->
<script src="js/laydate/laydate.js" ></script> <!-- 改成你的路径 -->
<script type="text/javascript" src="js/zwhJs/empManage.js" ></script>  
	

	
</head>
<body>
	<h1>用户管理</h1>
<!-- 	查询条件框部分开始 -->
	<div >
		<div>查询条件：</div>
		<div>
			<!-- 	查询条件框信息开始 -->
			<form id="searchForm" method="post">
				<label>用户ID：</label>
				<input type="text" name="emp_id">
				<label>用户名：</label>
				<input type="text" name="emp_name">
				<label>用户状态：</label>
				<select value="" name="emp_status">
					<option value ="" >不限</option>					
					<option value ="启用" >启用</option>
					<option value ="禁用" >禁用</option>
				</select>
			</form>	
			<!-- 	查询条件框信息结束 -->
			<button type="button" class="btn btn-primary" onclick="searchAllRole()">查询</button>	
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
				<td>序号</td><td>用户ID</td><td>用户名</td><td>用户密码</td><td>用户角色</td><td>用户状态</td><td>操作</td>
			</tr>
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
								<h4 class="modal-title" id="myModalLabel">新增用户</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
								<form id="addEmpForm" method="post">
									<!-- 				要增加的用户姓名 -->
									<div >
										<label >用户名：</label>
										<input id="new_emp_name" name="emp_name">
									</div>
									<br></br>
									<!-- 				选择用户角色 -->
									<div >
										<label >用户角色：</label>
										<select value="" name="role_id" id="new_role_id">

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
									<button type="button" class="btn btn-primary" onclick="addNewEmp()" data-dismiss="modal">提交</button>		
									<button type="button" class="btn btn-default"
										data-dismiss="modal">返回</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
<!-- 				查看单模态框结束 -->

<!-- 				增加角色模态框开始 -->
				
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">增加角色</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
								<form id="addEmpRoleForm" method="post">
									<!-- 				要增加的用户ID -->
										<div >
											<label >用户ID：</label>
											<label id="add_emp_id" name="emp_id"></label>
										</div>
										<br></br>
										<!-- 				要增加的用户姓名 -->
										<div >
											<label >用户名：</label>
											<label id="add_emp_name">
										</div>
										<br></br>
										<!-- 				要增加的用户角色 -->
										<div >
											<label >增加角色：</label>
											<select value ="" id="add_role_id" name="role_id">
												<option value ="" >--请选择--</option>	
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
									<button type="button" class="btn btn-primary" onclick="addRoleSubmit()" data-dismiss="modal">提交</button>		
									<button type="button" class="btn btn-default"
										data-dismiss="modal">返回</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
<!-- 			增加角色模态框结束 -->

<!-- 				删除角色模态框开始 -->
				
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">删除角色</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
									<form id="deleteEmpRoleForm" method="post">
										<!-- 				要增加的用户ID -->
										<div >
											<label >用户ID：</label>
											<label id="delete_emp_id" name="emp_id"></label>
										</div>
										<br></br>
										<!-- 				要增加的用户姓名 -->
										<div >
											<label >用户名：</label>
											<label id="delete_emp_name">
										</div>
										<br></br>
										<!-- 				要增加的用户角色 -->
										<div >
											<label >删除角色：</label>
											<select id="delete_role_id" name="role_id">
												<option value ="" >无</option>
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
									<button type="button" class="btn btn-primary" onclick="deleteRoleSubmit()" data-dismiss="modal">提交</button>		
									<button type="button" class="btn btn-default"
										data-dismiss="modal">返回</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
<!-- 			删除角色模态框结束 -->

<!-- 				修改用户状态模态框开始 -->
				
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal4" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">修改状态</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
									<form id="updateEmpStatusForm" method="post">
										<!-- 				要修改的用户ID -->
										<div >
											<label >用户ID：</label>
											<label id="update_emp_id" name="emp_id"></label>
										</div>
										<br></br>
										<!-- 				要增加的用户状态 -->
										<div >
											<label >用户状态：</label>
											<label id="update_emp_status" name="emp_status"></label>
										</div>
										<br></br>
									</form>
									
<!-- 								模态框中表单结束 -->
							</div>
							<div class="modal-footer">
								<div class="col-sm-offset-2 col-sm-10">
<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
<!-- 									<button type="button" onclick="" class="btn btn-primary">审核通过</button> -->
									<button type="button" class="btn btn-primary" onclick="updateEmpStatusSubmit()" data-dismiss="modal">提交</button>		
									<button type="button" class="btn btn-default"
										data-dismiss="modal">返回</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
<!-- 			修改用户状态模态框结束 -->

<!-- 				修改用户状态模态框开始 -->
				
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal5" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">重置密码</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
									<form id="updateEmpPwdForm" method="post">
										<!-- 				要修改的用户ID -->
										<div >
											<label >用户ID：</label>
											<label id="update_pwd_emp_id" name="emp_id"></label>
										</div>
										<br></br>
									</form>
									
<!-- 								模态框中表单结束 -->
							</div>
							<div class="modal-footer">
								<div class="col-sm-offset-2 col-sm-10">
<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
<!-- 									<button type="button" onclick="" class="btn btn-primary">审核通过</button> -->
									<button type="button" class="btn btn-primary" onclick="updateEmpPwdSubmit()" data-dismiss="modal">提交</button>		
									<button type="button" class="btn btn-default"
										data-dismiss="modal">返回</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
<!-- 			修改用户状态模态框结束 -->

<!-- 			按钮组 开始 -->
<div align="center">
	<ul class="pagination" >
		查询总数：<span id="total"></span>
		总页数：<span id="pages"></span>
		<span style="display:none" id=""></span>
		<li><a href="#" onclick="lastPage()">&laquo;</a></li>
		<li><a href="#" id="pageNum">1</a></li>
		<li><a href="#" onclick="nextPage()">&raquo;</a></li>
	</ul>	
</div>
<!-- 			按钮组 结束 -->

</body>
</html>