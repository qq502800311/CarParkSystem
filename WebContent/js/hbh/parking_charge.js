
$(function(){
	getChargeRule();
})


/*打开隐藏的收费信息*/
function openParkingCharge(){
	document.getElementById('parking_msg').style.display='block';
	document.getElementById('fade').style.display='block';
}

function closeParkingCharge(){
	document.getElementById('parking_msg').style.display='none';
	document.getElementById('fade').style.display='none';	
}

/*输入车牌号焦点监听*/
function checkLicense() {
	var re = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
	var license = $("#out_license").val();
	if (license == '') {
		$("#licence2").html("请输入车牌").css("color","red");
		return false;
	}else if (!re.test(license)) {
		$("#licence2").text("请输入正确车牌号").css("color","red");
		return false;
	}else {
		$("#licence2").html("同过").css("color","green");
		return true;
	}
}

/*数据库查找停车信息*/
function searchParkingCar(){
	closeParkingCharge();
	var license = $("#out_license").val();    
	var nowTime = getNowDate();                 //系统当前时间
	var str = '{"car_park_license":"'+license+'"}';
	$.ajax({
			url: "carport/searchParking.action",
			contentType : "application/json;charset=utf-8", //如果采用requestbody那么一定要加
			type: "POST",
			dataType: "json",
			data: str,
			success : function(date){
				if(typeof date == "string"){
					alert(date);
				}else{
				$("#car_license").html(date.car_park_license);        //车牌照
				$("#in_date").html(date.car_in_time);                 //车进场时间
				$("#out_date").html(nowTime);      
				var carType = date.parameter.parameter_name;
				$("#car_type").html(carType);   //车的类型
				var middleTime = dateNumber(nowTime,date.car_in_time);  //时间差值，分钟为单位
				
				$("#user_time").html( Math.ceil(middleTime/60));
				//-------支付金额计算------
				//--1.车辆类型判断，白名单、月缴费用户缴费金额为0
				//--2.算停车时间，算停车费用
				var rules = $("#tem_hidden").text();
				alert("收费规则:"+rules);
				var fir = rules.split(":")[0];
				var sec = rules.split(":")[1];
				var thr = rules.split(":")[2];
				var fur = rules.split(":")[3];
				var fiv = rules.split(":")[4];
				if(carType!="临时车辆"){
					$("#total_money").html(fir)
				}else{
					
					if(middleTime<30){			
						$("#total_money").html(0);
						
					}else if(30<=middleTime && middleTime<180){
						var a = Math.ceil((middleTime-30)/60);
						$("#total_money").html(sec*a);
						
					}else if(180<=middleTime && middleTime<300){
						var b = Math.ceil((middleTime-180)/60);
						$("#total_money").html(3*sec+b*thr);
						
					}else if(300<=middleTime && middleTime<480){

						var c = Math.ceil((middleTime-300)/60);	
						$("#total_money").html(3*sec+2*thr+fur*c);
						
					}else{
						var d = Math.ceil((middleTime-480)/(60*24));
						$("#total_money").html(3*sec+2*thr+fur*3+fiv*d);
					}	
				}
				openParkingCharge();
			}
			}
		});
}

//-------获取收费规则信息-------
function getChargeRule(){
	var str = '{"car_park_license":"666"}';
	$.ajax({
		url: "carport/getChargeRule.action",
//		contentType : "application/json;charset=utf-8", //如果采用requestbody那么一定要加
		type: "POST",
		dataType: "json",
		data: str,
		success: function(date){
//			alert("这里:"+date);
			$("#tem_hidden").html(date);
		}
	});
}








//------获取系统当前时间，时间格式YY--MM--DD HH:MM:SS
function getNowDate() {
	var date = new Date();
	var seperator1 = "-";
	var seperator2 = ":";
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	if (month >= 1 && month <= 9) {
	month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
	strDate = "0" + strDate;
	}
	var Hours = date.getHours();
	var Minutes = date.getMinutes();
	var Seconds = date.getSeconds();

	if (Hours >= 0 && Hours <= 9) {
	Hours = "0" + Hours;
	}
	if (Minutes >= 0 && Minutes <= 9) {
	Minutes = "0" + Minutes;
	}
	if (Seconds >= 0 && Seconds <= 9) {
	Seconds = "0" + Seconds;
	}
	var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
	+ " " + Hours + seperator2 + Minutes
	+ seperator2 + Seconds;
	return currentdate;
	}

//时间差计算
function dateNumber(stop_date,now_date){        
	strDate1=stop_date.replace(/-/g,"/"); 
	strDate2=now_date.replace(/-/g,"/"); 
	var date1 = Date.parse(strDate1); 
	var date2 = Date.parse(strDate2); 
	var date = Math.ceil((date1-date2)/(60*1000));
	return date;
}

//车辆收费放行
function openDoor(){
	var license = $("#car_license").html();              //车牌号码---删除停车信息表单条数据，车辆日志列表
	var money   = $("#total_money").html();              //车辆停车费用--用于车辆日志列表
	var in_time = $("#in_date").html();                  //车辆进场时间--用于车辆日志列表
	var out_time =$("#out_date").html();                 //车辆出场时间--用于车辆日志列表
	//暂时发车牌号过去，用于删除停车信息表
	var str = '{"car_park_license":"'+license+'","deal_money":"'+money+'","deal_time":"'+out_time+'"}';
	$.ajax({
		url: "carport/deleteOutCarMsg.action",
		contentType : "application/json;charset=utf-8", //如果采用requestbody那么一定要加
		type: "POST",
		dataType: "json",
		data: str,
		success: function(date){
//			$("#mytable").html("");
//			closeBackMoney();
			alert(date);
			
		}
	});	
}	





