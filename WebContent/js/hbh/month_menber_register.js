
/*----------------月缴费用户焦点监听---------------*/
/*检查用户名，不能为空*/
function checkName(){
	var username = $("#username").val();
	if(username==''){
		$("#username2").html("请输入用户名").css("color","red");
	} else {
		$("#username2").text("通过").css("color","green");
	}
}

/*正则判断手机号*/
function checkPhone() {
	var re = /^[1][3,4,5,7,8][0-9]{9}$/;
	var phone1 = $("#phone").val();
	if (phone1 == '') {
		$("#phone2").html("请输入手机号").css("color","red");
		
		return false;
	}else if (!re.test(phone1)) {
		$("#phone2").text("请输入正确的手机号码").css("color","red");
		return false;
	}  
	else {
		$("#phone2").text("通过").css("color","green");
		return true;
	}
}

/*正则判断密码*/
function checkPwd() {
	var re = /^\d{6}$/;
	var pwd = $("#pwd").val();
	if (pwd == '') {
		$("#pwd2").html("请输入密码").css("color","red");
		return false;
	}else if (!re.test(pwd)) {
		$("#pwd2").text("请输入6位数字密码").css("color","red");
		return false;
	}  
	else {
		$("#pwd2").text("通过").css("color","green");
		return true;
	}
}

/*正则判断二次密码*/
function checkRePwd() {
	var pwd = $("#pwd").val();
	var repwd = $("#repwd").val();
	if (pwd == '') {
		$("#repwd2").html("不能为空").css("color","red");
		return false;	
	}
	if (pwd != repwd) {
		$("#repwd2").html("密码不相等").css("color","red");
		return false;
	} 
	else {
		$("#repwd2").text("通过").css("color","green");
		return true;
	}
}
	
/*------正则判断车牌号码，数据库判断唯一性-----*/
function checkLicense() {
	var re = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
	var license = $("#licence").val();
	if (license == '') {
		$("#licence2").html("请输入车牌").css("color","red");
		return false;
	}else if (!re.test(license)) {
		$("#licence2").text("请输入正确车牌号").css("color","red");
		return false;
	}else {
		$.post("carport/checkLicense.action",{
			"license":license,
			
		},function(date){
			if(date=="通过"){
			    $("#licence2").html(date).css("color","green");
			} else {
				$("#licence2").html(date).css("color","red");
			}
		})
		return true;
	}
}

/*选择套餐*/
function selectMeal(){
	var meal = $("#selectMeal").val();
	if (meal == '') {
		$("#meal2").html("请选择套餐").css("color","red");
		return false;	
	}
	else {
		$("#meal2").html("通过").css("color","green");
		return true;
	}	
}

/*---身份证号码判断,数据库判断唯一性-----*/
function checkUserid(){
	var re = /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
	var userid = $("#userid").val();
	if (userid == '') {
		$("#userid2").html("请输入身份证").css("color","red");
		return false;	
	}
	else if(!re.test(userid)){
		$("#userid2").text("请输入正确身份证号").css("color","red");
		return false;
	}  else {
		$.post("carport/checkUserId.action",{
			"user_id":userid,
			
		},function(date){
			if(date=="通过"){
			    $("#userid2").html(date).css("color","green");
			} else {
				$("#userid2").html(date).css("color","red");
			}
		})
		return true;
	}
}

/*---------------------数据库添加月缴用户----------------*/
function addUser(){
	if(username = $("#username").val()==""){
		alert("请输入用户名");
		return false;
	}else if($("#pwd").val()==""){
		alert("请输入密码");
		return false;
	}else if($("#userid").val()==""){
		alert("请输入身份证");
		return false;
	}else if($("#licence").val()==""){
		alert("请输入车牌");
		return false;
	}else if($("#selectMeal").val()==""){
		alert("请选择套餐");
		return false;
	}else if($("#phone").val()==""){
		alert("请输入手机号");
		return false;
	}else {
		
	
	var username = $("#username").val();
	var phone = $("#phone").val();
	var pwd = $("#pwd").val();
	var license = $("#licence").val();
	var meal = $("#selectMeal option:selected").val();
	var userid = $("#userid").val();
	var str = '{"user_name":"'+username+'","user_phone":"'+phone+'","user_pwd":"'+pwd+'","car_park_license":"'+license+'","meal_id":"'+meal+'","user_id":"'+userid+'"}';
	$.ajax({
			url: "carport/MonthUser.action",
			contentType : "application/json;charset=utf-8", //如果采用requestbody那么一定要加
			type: "POST",
			dataType: "json",
			data: str,
			success : function(flag){
				
				if(flag.user_name==username){
					alert("办理成功");
					$("#username").val("");
					$("#phone").val("");
					$("#pwd").val("");
					$("#licence").val("");
					$("#selectMeal option:selected").val("");
					$("#userid").val("");
					$("#repwd").val("");
				} else {
					alert("办理失败");
				}
			}
		});
	}
}






