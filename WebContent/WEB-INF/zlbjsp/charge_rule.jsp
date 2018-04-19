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
	<h1>计费规则查询与管控</h1>
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
					<td>半小时之内</td>
					<td>三小时之内</td>
					<td>超过三小时低于五小时，超出部分费用</td>
					<td>超过五小时低于八小时，超出部分费用</td>
					<td>超过八小时低于二十四小时，超出部分费用</td>
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
					<h4 class="modal-title" id="myModalLabel">新增计费规则</h4>
				</div>
				<div class="modal-body" align="center">
					<!-- 								模态框中表单开始 -->
					<!-- 				要增加的计费半小时 -->
					<form id="addcharge_from">
					<div><label id="charge_rule_1_msg"></label></br>
						<label>半小时内费用</label> <input maxlength="5" name="charge_rule_1" id="charge_rule_1" type="text" onblur="blur_charge_rule_1()" >
					</div>
					<br></br>
					<!-- 				设置三小时之内 -->
					<div>
					<label id="charge_rule_2_msg"></label></br>
						<label>三小时之内费用</label> <input maxlength="5" name="charge_rule_2" id="charge_rule_2" type="text" onblur="blur_charge_rule_2()" >
					

					</div>
					<br></br>
					<!-- 				设置超过三小时低于五小时，超出部分费用	-->
					<div>
					<label id="charge_rule_3_msg"></label></br>
						<label>超过三小时低于五小时，超出部分费用</label> <input maxlength="5" name="charge_rule_3" id="charge_rule_3" type="text" onblur="blur_charge_rule_3()" >
					
					</div>
					<br></br>
					<!-- 				超过三小时低于五小时，超出部分费用 -->
					<div>
					<label id="charge_rule_4_msg"></label></br>
							<label>超过五小时低于八小时，超出部分费用</label> <input maxlength="5" name="charge_rule_4" id="charge_rule_4" type="text" onblur="blur_charge_rule_4()" >
					
					</div>
					<br></br>
					<!-- 				超过八小时低于二十四小时，超出部分费用 -->
					<div>
					<label id="charge_rule_5_msg"></label></br>
							<label>超过八小时低于二十四小时，超出部分费用</label> <input maxlength="5" name="charge_rule_5" id="charge_rule_5" type="text" onblur="blur_charge_rule_5()">
					
					</div>
					</form>
					<br></br>


					<!-- 								模态框中表单结束 -->
				</div>
				<div class="modal-footer">
					<div class="col-sm-offset-2 col-sm-10">
						<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
						<!-- 									<button type="button" onclick="" class="btn btn-primary">审核通过</button> -->
						<button type="button" class="btn btn-primary"
							onclick="addchargerule()" data-dismiss="modal">提交</button>
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
				<form id="modifiercharge_from">
					<div><label id="modifier_charge_rule_1_msg"></label></br>
						<label>半小时内费用</label> <input maxlength="5" name="charge_rule_1" id="modifier_charge_rule_1" type="text" onblur="modifier_blur_charge_rule_1()" >
					</div>
					<br></br>
					<!-- 				设置三小时之内 -->
					<div>
					<label id="modifier_charge_rule_2_msg"></label></br>
						<label>三小时之内费用</label> <input maxlength="5" name="charge_rule_2" id="modifier_charge_rule_2" type="text" onblur="modifier_blur_charge_rule_2()" >
					

					</div>
					<br></br>
					<!-- 				设置超过三小时低于五小时，超出部分费用	-->
					<div>
					<label id="modifier_charge_rule_3_msg"></label></br>
						<label>超过三小时低于五小时，超出部分费用</label> <input maxlength="5" name="charge_rule_3" id="modifier_charge_rule_3" type="text" onblur="modifier_blur_charge_rule_3()" >
					  <label ></label>
					</div>
					<br></br>
					<!-- 				超过三小时低于五小时，超出部分费用 -->
					<div>
					<label id="modifier_charge_rule_4_msg"></label></br>
							<label>超过五小时低于八小时，超出部分费用</label> <input maxlength="5" name="charge_rule_4" id="modifier_charge_rule_4" type="text" onblur="modifier_blur_charge_rule_4()" >
					
					</div>
					<br></br>
					<!-- 				超过八小时低于二十四小时，超出部分费用 -->
					<div>
					<label id="modifier_charge_rule_5_msg"></label></br>
							<label>超过八小时低于二十四小时，超出部分费用</label> <input maxlength="5" name="charge_rule_5" id="modifier_charge_rule_5" type="text" onblur="modifier_blur_charge_rule_5()">
					
					</div>
					</form>
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
<script type="text/javascript" src="js/zlbjs/charge_rule.js"></script>
</html>