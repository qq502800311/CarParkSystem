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
<script type="text/javascript" src="js/zwhJs/menuManage.js" ></script>  
	

	
</head>
<body>
	<h1>菜单管理</h1>
<!-- 	查询条件框部分开始 -->
	<div >
		<div>查询条件：</div>
		<div>
			<!-- 	查询条件框信息开始 -->
			<form id="searchMenuForm" method="post">
				<label>菜单名称：</label>
				<input type="text" name="menu_name">
				<label>一级菜单：</label>
				<select value="" name="menu_pid" id="firstMenuList">
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
				<td>序号</td><td>菜单名称</td><td>URL</td><td>上级菜单</td><td>操作</td>
			</tr>
		</table>
	</div>
<!-- 	查询结果表格部分结束 -->

<!-- 				新增菜单模态框开始 -->
				
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">新增角色</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
								<form id="addMenuForm" method="post">	
									<!-- 				要增加的菜单名 -->
									<div >
										<label >菜单名称：</label>
										<input id="add_menu_name" name="menu_name">
									</div>
									<br></br>
									<!-- 				上级菜单 -->
									<div >
										<label >上级菜单：</label>
										<select value="" name="menu_pid" id="add_menu_pid">
											<option value="0">根菜单</option>
										</select>
									</div>
									<br></br>
									<!-- 				URL单 -->
									<div >
										<label >URL：</label>
										<input id="add_menu_url" name="menu_url">
									</div>
									<br></br>										
								</form>	
<!-- 								模态框中表单结束 -->
							</div>
							<div class="modal-footer">
								<div class="col-sm-offset-2 col-sm-10">
<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
<!-- 									<button type="button" onclick="" class="btn btn-primary">审核通过</button> -->
									<button type="button" class="btn btn-primary" onclick="addMenu()" data-dismiss="modal">提交</button>		
									<button type="button" class="btn btn-default"
										data-dismiss="modal">返回</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
<!-- 				新增菜单模态框结束 -->

<!-- 				修改菜单名模态框开始 -->
				
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">修改菜单</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
								<form id="updateMenuForm" method="post">
										<!-- 				要修改的菜单ID -->
									<div >
										<label style="display:none">菜单ID：</label>
										<input style="display:none" id="update_menu_id" name="menu_id">
									</div>
									<br></br>
										<!-- 				要修改的菜单名 -->
									<div >
										<label >菜单名称：</label>
										<input id="update_menu_name" name="menu_name">
									</div>
									<br></br>
									<!-- 				上级菜单 -->
									<div >
										<label >上级菜单：</label>
										<select value="" name="menu_pid" id="update_menu_pid">
											<option value="0">根菜单</option>
										</select>
									</div>
									<br></br>
									<!-- 				URL单 -->
									<div >
										<label >URL：</label>
										<input id="update_menu_url" name="menu_url">
									</div>
									<br></br>			
								</form>
									
<!-- 								模态框中表单结束 -->
							</div>
							<div class="modal-footer">
								<div class="col-sm-offset-2 col-sm-10">
<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
<!-- 									<button type="button" onclick="" class="btn btn-primary">审核通过</button> -->
									<button type="button" class="btn btn-primary" onclick="updateMenuSubmit()" data-dismiss="modal">提交</button>		
									<button type="button" class="btn btn-default"
										data-dismiss="modal">返回</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
<!-- 			修改菜单模态框结束 -->

</body>
</html>