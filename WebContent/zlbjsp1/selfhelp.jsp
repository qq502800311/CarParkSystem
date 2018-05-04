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
<%@ page import="java.util.UUID"%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/zlb/index.css" />
<link rel="stylesheet" type="text/css" href="css/zlb/layer.css" />
<link rel="stylesheet" type="text/css" href="css/zlb/jquery.css" />
</head>
<body>
	<%
		UUID uuid = UUID.randomUUID();
		String WIDout_trade_no = uuid.toString();
	%>
	<form name=alipayment action=alipay.trade.page.pay.jsp method=post
		target="_blank">
		<div class="main_div">

			<div class="bottom_div">
				<%-- 					<dt>商户订单号    WIDout_trade_no：</dt> 一定要有订单号 --%>
				<input id="WIDout_trade_no" name="WIDout_trade_no" type="hidden"  value="WIDout_trade_no"/>
				<%--//订单名称，必填 WIDsubject  --%>
				<input id="WIDsubject" name="WIDsubject" value="停车场收费" type="hidden" />
				<input id="WIDbody" name="WIDbody" value="这次测试" type="hidden" />

				<%--//商品描述，可空 WIDbody--%>
				<div class="bottom_text">输入新绑定的车牌</div>

				<div class="car_input">
					<input type="text" name="car_name" id="car_name" value="输入车牌" onchange="changecarname();"
						maxlength="7" />
				</div>
				<%--//付款金额，必填   WIDtotal_amount --%>
				<div class="bottom_text" >停车费用:<label   maxlength="7"  id="feiyong" /> </label> </div>
				<div class="car_input">
					<input type="hidden"  maxlength="7"  id="WIDtotal_amount" name="WIDtotal_amount"/>
				
				</div>
				<div class="next_step">下一步</div>
			</div>
		</div>
	</form>
</body>

<script type="text/javascript" src="js/zlbjs/zlbcpjs/jquery.min.js"></script>
<script src="js/zlbjs/zlbcpjs/jquery.autocomplete.js"
	type="text/javascript"></script>
<script src="js/zlbjs/zlbcpjs/data.js" type="text/javascript"></script>
<script src="js/zlbjs/zlbcpjs/autocomplete.js" type="text/javascript"></script>
<script src="js/zlbjs/zlbcpjs/layer.js" type="text/javascript"></script>
<script src="js/zlbjs/zlbcpjs/index.js" type="text/javascript"></script>
<script>
function GetDateNow() {
	var vNow = new Date();
	var sNow = "";
	sNow += String(vNow.getFullYear());
	sNow += String(vNow.getMonth() + 1);
	sNow += String(vNow.getDate());
	sNow += String(vNow.getHours());
	sNow += String(vNow.getMinutes());
	sNow += String(vNow.getSeconds());
	sNow += String(vNow.getMilliseconds());
	document.getElementById("WIDout_trade_no").value =  sNow;


}
GetDateNow();

</script>
</html>