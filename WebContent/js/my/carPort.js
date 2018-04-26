
//-------------------------------------------------------//
//------------------原本的车辆入库页面--------------------//
//-------------------------------------------------------//
$(function() {//此处方法为全部加载完成，能保证全部ID、标签等都能找到
	carSensor1();
//	getCurDate();
//	setInterval("getCurDate()", 100);//控制页面时间跳动
})



function clickBtn2() {
	var carLisence = $(" input[ name='carLisence' ] ").val();
	alert("获取到的车牌:" + carLisence);
	$.ajax({
		url : "park/entranceDisplay.action",
		type : "POST",
		data : {
			"carLisence" : carLisence
		},
		success : function(res) {
			$(" font[ id='displayboard' ] ").text("欢迎!" + res.car_park_license + "的车主");
		}
	});
}

//触发传感器1
function carSensor1() {
	$.ajax({
		url : "park/entranceDisplaySearch.action",
		type : "POST",
		success : function(res) {
			$(" font[ id='displayboard' ] ").text("欢迎光临!当前空余车位:" + res);
		}
	});
}

//
function doUploadIn() {  
    var formData = new FormData($( "#uploadForm" )[0]);  
    $.ajax({  
         url: 'park/carPortUploadIn.action',  
         type: 'POST',  
         data: formData,  
         async: false,  
         cache: false,  
         contentType: false,  
         processData: false,  
         success: function (returndata) {  
             alert("成功" + returndata.car_park_license); 
             $(" font[ id='displayboard' ] ").text("欢迎!" + returndata.car_park_license + "的车主");
         },  
         error: function (returndata) {  
             alert("提交车辆照片失败");  
         }  
    });  
} 

//最终测试成功的上传车牌文件ajax方法
function doUploadOut() {  
    var formData = new FormData($( "#uploadForm" )[0]);  
    $.ajax({  
         url: 'park/carPortUploadOut.action',  
         type: 'POST',  
         data: formData,  
         async: false,  
         cache: false,  
         contentType: false,  
         processData: false,  
         success: function (returndata) {  
             alert("成功" + returndata.car_park_license); 
             $(" font[ id='displayboard' ] ").text("再见!" + returndata.car_park_license + "的车主");
         },  
         error: function (returndata) {  
             alert("提交车辆照片失败");  
         }  
    });  
} 


// -------------------LED显示效果JS开始 -------------------//
//function getCurDate(){
//	var d = new Date();
//	var week;
//	switch (d.getDay()) {
//	case 1:
//		week = "星期一";
//		break;
//	case 2:
//		week = "星期二";
//		break;
//	case 3:
//		week = "星期三";
//		break;
//	case 4:
//		week = "星期四";
//		break;
//	case 5:
//		week = "星期五";
//		break;
//	case 6:
//		week = "星期六";
//		break;
//	default:
//		week = "星期天";
//	}
//	var years = d.getFullYear();
//	var month = add_zero(d.getMonth() + 1);
//	var days = add_zero(d.getDate());
//	var hours = add_zero(d.getHours());
//	var minutes = add_zero(d.getMinutes());
//	var seconds = add_zero(d.getSeconds());
//	var ndate = years + "年" + month + "月" + days + "日 " + hours + ":" + minutes
//			+ ":" + seconds + " " + week;
//	var divT = document.getElementById("systimeshow");
//	divT.innerHTML = ndate;
//}
//
//function add_zero(temp) {
//	if (temp < 10)
//		return "0" + temp;
//	else
//		return temp;
//}

//-------------------LED显示效果JS结束 -------------------//