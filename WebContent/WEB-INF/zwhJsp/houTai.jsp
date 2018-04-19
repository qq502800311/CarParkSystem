<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%-- <%@page import="Bean.Admin_Authority_Bean"%> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>*后台管理页面*</title>

 <base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/my/houTai.css">
	
	
	<script type="text/javascript" charset="UTF-8" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript" charset="UTF-8" src="js/bootstrap.js" ></script>
	<script type="text/javascript" src="js/my/houTai.js" charset="UTF-8"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" >
</head>
<body>

<!-- 	jsp向iframe传输参数方式开始		 -->

<!-- 	jsp向iframe传输参数方式结束		 -->

<!-- 	用户信息 开始		 -->
<%
HttpSession s = request.getSession(); 
%>

<span><%=s.getAttribute("emp_id")%></span>
<span><%=s.getAttribute("emp_name")%></span>

<!-- 	用户信息 结束		 -->


	<table >
		<tr>
			<td colspan="2" class="myheader">
			<div id="myheader_div1"></div>

			<div id="myheader_div2">
				<font><strong>共享文档系统</strong></font>
				
			</div>

			<div id="myheader_div3">
				
			</div>

			
			</td>
			
		</tr>
		<tr>
			<td colspan="2" class="myheader2">
			<div id="myheader_div4">
				<font color="white">
				<!-- 				此处显示用户名及相关信息 -->
				<label>欢迎！<s:property value="session.user.user_name"/></label>

<img src="<s:property value="userImage"/> " alt="图像无法显示" height="30" width="30"/>
				<img src="${sessionScope.user.user_avatarURL}  " alt="图像无法显示" height="30" width="30"/>
				<img src="<s:property value="session.user.user_avatarURL"/> " alt="图像无法显示" height="30" width="30"/>
				<a href="getMyInfo.action?req=myInfo&user.user_name=<s:property value="session.user.user_name"/>">我的信息</a>

				</font>
				
				<s:if test="#session.user == null">
				 	 看到这段代码说明session中是空的 
				</s:if>
<!-- 				<button class="btn btn-primary" data-toggle="modal" data-target="#myModal1">查看</button>	 -->
				
				<% if(((String)request.getAttribute("customerID"))==null){ %>
				
					<a href="#"  data-toggle="modal" data-target="#myModal2" >注销</a>
					<a href="#" data-toggle="modal" data-target="#myModal1" >更改密码</a>
					<a href="pageShift.action?req=uploadtest">文档上传</a>
<%-- 					<a class="navbar-brand" href="pageShift.action?req=uploadtest"><span class="glyphicon glyphicon-home"></span> 首页</a> --%>
				
				<% } %>
				<a href="#"  >返回首页</a>
			</div>
		</tr>	
		<tr>
			<td class="myleft">
			
				<div class="myselect" id="bigDiv">
<!----------------------------------	菜单列表开始	------------------------------------------------>		
					<ul>
							<!-- 					一级菜单一 -->
							<c:forEach var="i" items="${menu}">
								<li>
									<a onclick="myClick1(this)"><c:out value="${i.key}"></c:out></a>
									
										<div>
											<ul>
												<li>
													<c:forEach var="j" items="${i.value}">
														<a href="${j.menu_url}" target="view_window" ><c:out value="${j.second_menu_name}"></c:out></a>
													</c:forEach>
												</li>	
											</ul>
										</div>
								</li>
							</c:forEach>
					</ul>
<!----------------------------------	菜单列表结束	------------------------------------------------>	
				</div>
				
				

			</td>
			<td class="myright">
<!-------------------------------------------- iframe部分开始 ----------------------------------------------->			
				<iframe id="if1" name="view_window" frameborder="0" scrolling="auto" width=100% height=90%;></iframe>
<!-------------------------------------------- iframe部分结束 ----------------------------------------------->	
			</td>
			
		</tr>
		<tr>
			
			
		</tr>
	</table>
	
	
<!-- 				更改密码模态框开始 -->			
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">修改密码</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
									<!-- 				原来的密码 -->
									<div >
										<label >原来的密码：</label>
										<input type="password" id="ht_user_OldPsw">
									</div>
									<br></br>
									<!-- 				新的密码 -->
									<div >
										<label >新的密码：</label>
										<input type="password" id="ht_user_NewPsw1">
										
									</div>
									<br></br>
									<!-- 				再次确认新的密码 -->
									<div >
										<label >再次确认新的密码：</label>
										<input type="password" id="ht_user_NewPsw2">
									</div>
									<br></br>
									
									
<!-- 								模态框中表单结束 -->
							</div>
							<div class="modal-footer">
								<div class="col-sm-offset-2 col-sm-10">
<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
									<button type="button" onclick="changeEmpPsw()" class="btn btn-primary">更改密码</button>
									<button type="button" class="btn btn-default"
										data-dismiss="modal">返回</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
<!-- 				更改密码模态框结束 -->

<!-- 				注销密码模态框开始 -->			
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">退出登录</h4>
							</div>
							<div class="modal-body" align="center">
<!-- 								模态框中表单开始 -->
								<label >是否确认退出登录？确认后退出会关闭当前页面</label>
								<label >非IE浏览器不会关闭当前窗口</label>
<!-- 								模态框中表单结束 -->
							</div>
							<div class="modal-footer">
								<div class="col-sm-offset-2 col-sm-10">
<!-- 									<button type="submit" class="btn btn-primary">入库</button> -->
									<button type="button" onclick="empOffline()" class="btn btn-primary">确定</button>
									<button type="button" class="btn btn-default"
										data-dismiss="modal">返回</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
<!-- 				注销密码模态框结束 -->

</body>
</html>