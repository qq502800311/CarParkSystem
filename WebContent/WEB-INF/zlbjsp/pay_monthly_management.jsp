<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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




</head>
<body>
	<h1>月缴产品查询与管控</h1>
	<!-- 	查询条件框部分开始 -->
	<div>
		
		<div>
			
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
					<td>套餐名</td>
					<td>套餐金额</td>
					<td>套餐详情</td>
				
					<td>状态</td>
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
					<h4 class="modal-title" id="myModalLabel">新增缴费套餐</h4>
				</div>
				<div class="modal-body" align="center">
					<!-- 								模态框中表单开始 -->
					<!-- 				要增加的月套餐 -->
					<form id="addmeal_from">
					<div><label id="meal_1_msg"></label></br>
						<label>月套餐</label> <input  maxlength="5" name="mealmoney_1" id="mealmoney_1" type="text" onblur="blur_meal_1()" >
					</div>
					<br></br>
					<!-- 				要增加的季套餐 -->
					<div>
					<label id="meal_2_msg"></label></br>
						<label>季套餐</label> <input maxlength="5" name="mealmoney_2" id="mealmoney_2" type="text" onblur="blur_meal_2()" >
					

					</div>
					<br></br>
					<!-- 				要增加的半年套餐	-->
					<div>
					<label id="meal_3_msg"></label></br>
						<label>半年套餐</label> <input maxlength="5" name="mealmoney_3" id="mealmoney_3" type="text" onblur="blur_meal_3()" >
					
					</div>
					<br></br>
					
					</form>
					<br></br>


					<!-- 								模态框中表单结束 -->
				</div>
				<div class="modal-footer">
					<div class="col-sm-offset-2 col-sm-10">
						<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
						<!-- 									<button type="button" onclick="" class="btn btn-primary">审核通过</button> -->
						<button type="button" class="btn btn-primary"
							onclick="addmeal()" data-dismiss="modal">提交</button>
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
					<h4 class="modal-title" id="myModalLabel" >修改套餐</h4>
				</div>
				<div class="modal-body" align="center">
					<!-- 								模态框中表单开始 -->
				<form id="modifiercharge_from">
					<div><label id="modifier_mealmoney_1_msg"></label></br>
						<label>月套餐</label> <input name="mealmoney_1" maxlength="5" id="modifier_mealmoney_1" type="text" onblur="modifier_blur_money_1()" >
					</div>
					<br></br>
					<!-- 				设置三小时之内 -->
					<div>
					<label id="modifier_mealmoney_2_msg"></label></br>
						<label>季套餐</label> <input name="mealmoney_2" maxlength="5" id="modifier_mealmoney_2" type="text" onblur="modifier_blur_money_2()" >
					

					</div>
					<br></br>
					<!-- 				设置超过三小时低于五小时，超出部分费用	-->
					<div>
					<label id="modifier_mealmoney_3_msg"></label></br>
						<label>半年套餐</label> <input name="mealmoney_3" maxlength="5" id="modifier_mealmoney_3" type="text" onblur="modifier_blur_money_3()" >
					  <label ></label>
					</div>
					<br></br>
					


					<!-- 								模态框中表单结束 -->
				</div>
				<div class="modal-footer">
					<div class="col-sm-offset-2 col-sm-10">
						
						<button type="button" class="btn btn-primary"
							onclick="changemodifier()" data-dismiss="modal">修改</button>
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
<script type="text/javascript" src="js/zlbjs/pay_monthly.js"></script>
</html>