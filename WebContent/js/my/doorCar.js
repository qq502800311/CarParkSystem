
var canvas;//父画布全局变量

$(function() {//此处方法为全部加载完成，能保证全部ID、标签等都能找到
	canvas = new fabric.Canvas("myCanvas");//定义全局的父画布对象
	drawRoadgate();
	baseControl();
	carWelcome();
//	getCurDate();
//	setInterval("getCurDate()", 100);//控制页面时间跳动
})

//入口显示欢迎标语，并查询显示当前车库状态
function carWelcome() {
	$.ajax({
		url : "park/entranceDisplaySearch.action",
		type : "POST",
		success : function(res) {
			$(" font[ id='displayboard' ] ").text("欢迎光临!当前空余车位:" + res);
		}
	});
}

//弹出车辆入库的模态框
function updatemyModal1(){
	$('#myModal1').modal('show');
}

//弹出车辆入库的模态框
function updatemyModal2(){
	$('#myModal2').modal('show');
}

//入口车辆上传照片
function carInUpload() {  
    var formData = new FormData($( "#uploadForm1" )[0]);  
    $.ajax({  
         url: 'park/upload.action',  
         type: 'POST',  
         data: formData,  
         async: false,  
         cache: false,  
         contentType: false,  
         processData: false,  
         success: function (returndata) {  
             alert("成功" + returndata.car_park_license); 
             $(" font[ id='displayboard' ] ").text("欢迎!" + returndata.car_park_license + "的车主");
             inRoadgateRiseAndDown("up");
         },  
         error: function (returndata) {  
             alert("提交车辆照片失败");  
         }  
    });  
} 

//出口结算
function carOutUpload() {  
    var formData = new FormData($( "#uploadForm2" )[0]);  
    $.ajax({  
         url: 'park/exportFileact.action',  
         type: 'POST',  
         data: formData,  
         async: false,  
         cache: false,  
         contentType: false,  
         processData: false,  
         success: function (returndata) {  
//             alert("成功" + returndata.car_park_license); 
             $(" font[ id='displayboard' ] ").text("本次停车时长 " + returndata.stop_time + "停车费用:" + returndata.charge_money + "元！欢迎再次光临!" + returndata.car_license + "的车主");
             outRoadgateRiseAndDown("up");
         },  
         error: function (returndata) {  
             alert("提交车辆照片失败");  
         }  
    });  
}

//控制配置函数
function baseControl(){
	//开启模块选中
	canvas.on('mouse:down', function(options) {
		  if (options.target) {
		    console.log('an object was clicked! ', options.target.type);
//		    alert("选中内容的坐标:" + options.target.id);
//		    alert("选中内容的坐标:" + options.target.left + "," + options.target.top);
		    if(options.target.id == "inRoadgateBaseCamera"){ 
//		    	inRoadgateRiseAndDown("up");
//		    	updatemyModal1();
		    }else if(options.target.id == "outRoadgateBaseCamera"){ 
//		    	outRoadgateRiseAndDown("up");
		    	updatemyModal2();
		    }else if(options.target.id == "inRoadgateSensor"){ 
		    	inRoadgateRiseAndDown("down");
		    }else if(options.target.id == "outRoadgateSensor"){ 
		    	outRoadgateRiseAndDown("down");
		    }
		    
		  }
	});

}

//入口道闸收放控制函数
function inRoadgateRiseAndDown(key) {
	var angle = 0;
	if(key == "up"){
		angle = -90;
	}else if(key == "down"){
		angle = 0;
	}
	var Jpg;
	var objects = canvas.getObjects();
	for (var i = 0; i <= (objects.length - 1); i++) {
		var object = objects[i];
		if (object.id == "inRoadgate") {
			Jpg = object;
		}
	}
	Jpg.animate('angle', angle, {
		onChange : canvas.renderAll.bind(canvas),
		duration : 1000,// 动画持续时间
		easing : fabric.util.ease.easeOutExpo
	});// 延时动画
}
//出口道闸收放控制函数
function outRoadgateRiseAndDown(key) {
	var angle = 180;
	if(key == "up"){
		angle = 270;
	}else if(key == "down"){
		angle = 180;
	}
	var Jpg;
	var objects = canvas.getObjects();
	for (var i = 0; i <= (objects.length - 1); i++) {
		var object = objects[i];
		if (object.id == "outRoadgate") {
			Jpg = object;
		}
	}
	Jpg.animate('angle', angle, {
		onChange : canvas.renderAll.bind(canvas),
		duration : 1000,// 动画持续时间
		easing : fabric.util.ease.easeOutExpo
	});// 延时动画
}

// 绘制停车场出入口道闸
function drawRoadgate(){
	//画布宽度1500，入口部分是从750到1500
	//画布高度650
	//绘制入口道闸基座
	var inRoadgateBase = new fabric.Rect({
		  left: 800,
		  top: 300,
		  fill: 'yellow',
		  width: 100,
		  height: 200,
		  hasControls :false,//禁止改变控件大小
		  lockMovementX : true,//锁定X轴
		  lockMovementY : true,//锁定Y轴
		  id : 'inRoadgateBase',//设置ID
		  evented : false//禁止选中
		});
	//绘制入口道闸传感器
	var inRoadgateSensor = new fabric.Rect({
		  left: 1000,
		  top: 300,
		  fill: 'green',
		  width: 100,
		  height: 200,
		  hasControls :false,//禁止改变控件大小
		  lockMovementX : true,//锁定X轴
		  lockMovementY : true,//锁定Y轴
		  id : 'inRoadgateSensor',//设置ID
		});
	
	//绘制出口道闸基座
	var outRoadgateBase = new fabric.Rect({
		  left: 600,
		  top: 300,
		  fill: 'yellow',
		  width: 100,
		  height: 200,
		  hasControls :false,//禁止改变控件大小
		  lockMovementX : true,//锁定X轴
		  lockMovementY : true,//锁定Y轴
		  id : 'outRoadgateBase',//设置ID
		  evented : false//禁止选中
		});
	//绘制出口道闸传感器
	var outRoadgateSensor = new fabric.Rect({
		  left: 400,
		  top: 300,
		  fill: 'green',
		  width: 100,
		  height: 200,
		  hasControls :false,//禁止改变控件大小
		  lockMovementX : true,//锁定X轴
		  lockMovementY : true,//锁定Y轴
		  id : 'outRoadgateSensor',//设置ID
		});
	
	//绘制入口道闸横杆测试
	var outRoadgateBasetest = new fabric.Image({
		left: 100,
		top: 100,
		fromURL:'Image/道闸2.png'
	});
	canvas.add(outRoadgateBasetest);
	//绘制入口道闸横杆
	fabric.Image.fromURL('Image/道闸2.png', function(oImg) {
		oImg.set('left' , 850),
		oImg.set('top' , 350),
		oImg.set('id' , 'inRoadgate'),
		oImg.set('evented' , false),//禁止选中
		oImg.set('lockMovementX' , true),//锁定X轴
		oImg.set('lockMovementY' , true),//锁定Y轴
		oImg.set('hasControls' , false),//禁止改变控件大小
		oImg.scale(0.5),
	  	canvas.add(oImg);
	});
	//绘制入口摄像头
	fabric.Image.fromURL('Image/摄像头.png', function(oImg) {
		oImg.set('left' , 800),
		oImg.set('top' , 170),
		oImg.set('id' , 'inRoadgateBaseCamera'),
		oImg.set('evented' , true),//禁止选中
		oImg.set('lockMovementX' , true),//锁定X轴
		oImg.set('lockMovementY' , true),//锁定Y轴
		oImg.set('hasControls' , false),//禁止改变控件大小
		// oImg.set('width' , 300),
		// oImg.set('height' , 200),
		oImg.scale(0.5),
	  	canvas.add(oImg);
	});
	//绘制出口道闸横杆
	fabric.Image.fromURL('Image/道闸2.png', function(oImg) {
		oImg.set('left' , 650),
		oImg.set('top' , 380),
		oImg.set('angle' , 180),
		oImg.set('id' , 'outRoadgate'),
		oImg.set('evented' , false),//禁止选中
		oImg.set('lockMovementX' , true),//锁定X轴
		oImg.set('lockMovementY' , true),//锁定Y轴
		oImg.set('hasControls' , false),//禁止改变控件大小
		oImg.scale(0.5),
	  	canvas.add(oImg);
	});
	//绘制出口摄像头
	fabric.Image.fromURL('Image/摄像头.png', function(oImg) {
		oImg.set('left' , 600),
		oImg.set('top' , 170),
		oImg.set('id' , 'outRoadgateBaseCamera'),
		oImg.set('evented' , true),//禁止选中
		oImg.set('lockMovementX' , true),//锁定X轴
		oImg.set('lockMovementY' , true),//锁定Y轴
		oImg.set('hasControls' , false),//禁止改变控件大小
		// oImg.set('width' , 300),
		// oImg.set('height' , 200),
		oImg.scale(0.5),
	  	canvas.add(oImg);
	});
	
	//添加到画布上
	canvas.add(inRoadgateBase);
	canvas.add(outRoadgateBase);
	canvas.add(inRoadgateSensor);
	canvas.add(outRoadgateSensor);
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