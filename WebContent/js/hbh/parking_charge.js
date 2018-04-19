

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
			success : function(carout){
				if(carout.car_license==null){
					alert("查无此车牌");
				}else{
					$("#car_license").html(carout.car_license);        //车牌照
					$("#in_date").html(carout.in_time);                 //车进场时间
					$("#out_date").html(carout.out_time);      
					$("#car_type").html(carout.car_type);   //车的类型				
					$("#user_time").html(carout.stop_time);
					$("#total_money").html(carout.charge_money);
					openParkingCharge();
				}
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
	var money2 = -money;
	var in_time = $("#in_date").html();                  //车辆进场时间--用于车辆日志列表
	var out_time =$("#out_date").html();                 //车辆出场时间--用于车辆日志列表
	//暂时发车牌号过去，用于删除停车信息表
	var str = '{"car_park_license":"'+license+'","deal_money":"'+money2+'","deal_time":"'+out_time+'"}';
	$.ajax({
		url: "carport/deleteOutCarMsg.action",
		contentType : "application/json;charset=utf-8", //如果采用requestbody那么一定要加
		type: "POST",
		dataType: "json",
		data: str,
		success: function(date){
			alert(date);
			
		}
	});	
}	





