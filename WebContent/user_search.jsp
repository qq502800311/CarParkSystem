<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String basepath = application.getContextPath();
	
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理端使用的用户查询页面</title>

<link rel="stylesheet" type="text/css" href=<%=basepath+"/css/bootstrap.css" %>>
<script type="text/javascript" charset="UTF-8" src=<%=basepath+"/js/jquery-3.3.1.js" %>></script>
<script type="text/javascript" charset="UTF-8" src=<%=basepath+"/js/bootstrap.js" %>></script>
<!-- laydate控件方式,layDate 采用原生 JavaScript 编写，不依赖任何第三方库，兼容所有浏览器（IE6/7除外） -->
<script src=<%=basepath+"/js/laydate/laydate.js" %>></script> <!-- 改成你的路径 -->
<script type="text/javascript" src="<%=basepath%>/js/my/user_search.js" ></script>  
	

	
</head>
<body>
	<h1>用户查询与管控</h1>
<!-- 	查询条件框部分开始 -->
	<div >
		<div>查询条件：</div>
		<div>
			<label>用户名称：</label>
			<input type="text" id="doc_name">
			<label>用户类型：</label>
			<select value="" name="doc_type" id="doc_type">
					<option value ="" >不限</option>
					<option value ="doc" >doc</option>
					<option value ="ppt" >ppt</option>
					<option value ="txt" >txt</option>
			</select>
			<!-- 按钮触发模态框 -->
			<button class="btn btn-primary" data-toggle="modal" data-target="#myModal1">待用按钮</button>	
		</div>
		<div>
			<label>注册日期：</label>
			<input type="text" id="import_Date1">至
			<input type="text" id="import_Date2">
			
			<label>所需积分：</label>
			<select value="" name="doc_point" id="doc_point">
					<option value ="" >不限</option>
					<option value ="5"  >5分</option>
					<option value ="10" >10分</option>
					<option value ="15" >15分</option>
					<option value ="20" >20分</option>
					<option value ="25" >25分</option>
					<option value ="30" >30分</option>
			</select>	
			<button type="button" class="btn btn-primary" onclick="search()">查询</button>		
		</div>
		<div>		
			<button type="button" class="btn btn-primary" onclick="useHelp()">使用帮助</button>
			
		</div>
	</div>
<!-- 	查询条件框部分结束 -->

<!-- 	查询结果表格部分开始 -->
	<div>
		<table class="table table-striped" id="myShowtab" >
			<tr>
				<td>序号</td><td>用户名</td><td>注册时间</td><td>积分</td><td>上传文档数</td><td>下载文档数</td><td>用户状态</td><td>操作</td>
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
								<h4 class="modal-title" id="myModalLabel">新增人员</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
									<!-- 				要增加的人员姓名 -->
									<div >
										<label >人员姓名：</label>
										<input id="newEmp_Name">
									</div>
									<br></br>
									<!-- 				设置密码1 -->
									<div >
										<label >密码：</label>
										<input id="newEmp_Psw1">
										
									</div>
									<br></br>
									<!-- 				设置密码2 -->
									<div >
										<label >确认密码密码：</label>
										<input id="newEmp_Psw2">
										
									</div>
									<br></br>
									<!-- 				选择所属科室 -->
									<div >
										<label >所属科室：</label>
										<select value="" name="newEmp_D_ID" id="newEmp_D_ID">
											<option value ="1" >内科</option>
											<option value ="2" >IT部</option>
											<option value ="3" >业务部</option>
										</select>
									</div>
									<br></br>
									<!-- 				选择所属角色 -->
									<div >
										<label >所属角色：</label>
										<select value="" name="newEmp_ER_ID" id="newEmp_ER_ID">
											<option value ="1" >管理员</option>
											<option value ="2" >医生</option>
											<option value ="3" >业务员</option>
										</select>
									</div>
									<br></br>
									
									
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

<!-- 				修改人员模态框开始 -->
				
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">修改人员</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
									<!-- 				要增加的人员姓名 -->
									<div >
										<label >人员工号：</label>
										<label id="changeEmp_ID">人员工号：</label>
									</div>
									<br></br>
									<!-- 				要增加的人员姓名 -->
									<div >
										<label >人员姓名：</label>
										<input id="changeEmp_Name">
									</div>
									<br></br>
									<!-- 				选择所属科室 -->
									<div >
										<label >所属科室：</label>
										<select value="" name="changeEmp_D_ID" id="changeEmp_D_ID">
											<option value ="1" >内科</option>
											<option value ="2" >IT部</option>
											<option value ="3" >业务部</option>
										</select>
									</div>
									<br></br>
									<!-- 				选择所属角色 -->
									<div >
										<label >所属角色：</label>
										<select value="" name="changeEmp_ER_ID" id="changeEmp_ER_ID">
											<option value ="1" >管理员</option>
											<option value ="2" >医生</option>
											<option value ="3" >业务员</option>
										</select>
									</div>
									<br></br>
									
									
<!-- 								模态框中表单结束 -->
							</div>
							<div class="modal-footer">
								<div class="col-sm-offset-2 col-sm-10">
<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
<!-- 									<button type="button" onclick="" class="btn btn-primary">审核通过</button> -->
									<button type="button" class="btn btn-primary" onclick="changeEmpApply()" data-dismiss="modal">修改</button>		
									<button type="button" class="btn btn-default"
										data-dismiss="modal">返回</button>
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