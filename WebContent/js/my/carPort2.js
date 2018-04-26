/**
 * 
 */

//$(window).ready(testTable());//此处方法为正在加载，如果未能加载完成，则会出现ID、标签等无法找到
//全局变量
var canvas;//父画布全局变量
var allResultList;//查询车位车辆信息结果列表

$(function() {//此处方法为全部加载完成，能保证全部ID、标签等都能找到
	canvas = new fabric.Canvas("myCanvas");
	cleanCanvas();
	baseControl();
//	drawAllPort();
	searchPort();
//	drawCarOnPort();
	test();
});

//清空画布
function cleanCanvas(){
	//遍历当前画布上所有对象
	var objects = canvas.getObjects();
	for (var i = objects.length - 1; i >= 0; i--) {
	      var object = objects[i];
	    	   	canvas.remove(object);
	}
//	alert("清空画布");
}

//绘制多个车库函数
function drawAllPort(allResultList){
	//根据查询结果绘制停车场图片
	var h = 100;//车位长度
	var w = 50;//车位宽度
	var k =0;
	for(var j=0;j<2;j++){
		for(var i=0;i<10;i++){
			var x =0+i*(w+60);
			var y =0+j*(h+250);
			if(j%2!=0){
				y = y+100
			}
			drawOnePort(x,y,allResultList,k);
			k++;
		}
	}
}

//绘制单个车库函数
function drawOnePort(pointx,pointy,allResultList,k){
	// create a rectangle object
	var color = "green";
	if(allResultList[k].carport_status == "使用中"){
		color = "red";
	}else if(allResultList[k].carport_status == "维护中"){
		color = "yellow";
	}
	var rect = new fabric.Rect({
	  left: pointx,
	  top: pointy,
	  fill: color,
	  width: 100,
	  height: 200,
	  hasControls :false,//禁止改变控件大小
	  lockMovementX : true,//锁定X轴
	  lockMovementY : true,//锁定Y轴
	  id : allResultList[k].carport_num
	});
	var text = new fabric.Text(allResultList[k].carport_num, { 
		left: pointx, 
		top: pointy+90, 
		fontSize: 40,
		fontWeight: 'bold',
		evented : false//禁止选中
	});
	
	//添加到画布上
	canvas.add(rect);
	canvas.add(text);
	
	if(allResultList[k].carport_status == "使用中"){
		//在对应的车库里画车
		drawOneCar(pointx,pointy,allResultList[k].carport_num);
	}
}

//绘制一个车
function drawOneCar(x,y,id){
	fabric.Image.fromURL(getRootPath()+"Image/car2.png"  , function(img) {
		canvas.add(img.set({ 
			left: x+100, 
			top: y, 
			angle: 90, 
			evented : false,//禁止选中
			id :"img"+id
			}).scale(0.25));
		});
}

//控制配置函数
function baseControl(){
	//开启模块选中
	canvas.on('mouse:down', function(options) {
		  if (options.target) {
			  console.log('an object was clicked! ', options.target.type);
			  //如果车位是空车位
			  if(options.target.fill == "green"){ 
				  updatemyModal2(options.target.id);
			  }
			  //如果车位是有车位
			  else if(options.target.fill == "red"){
				  updatemyModal1(options.target.id);
			  }//如果车位是维护车位
			  else if(options.target.fill == "yellow"){
				  alert("车位正在维护中!请更换车位!");
			  }
		    
		  }
	});
}

//查询当前停车场状态得到结果列表启动绘制车库车辆函数
function searchPort() {
	$.ajax({
		type:"POST",
		url:"searchAllCarParkAndCarInfo.action",
		data:{},
		dataType:"json",
		async:true,	
		success: function(resultList){
			if(resultList.length>0){
				allResultList = resultList;
				drawAllPort(resultList);
			}else{
				alert("没有结果");
			}
		},
		error:function(resultList){
			alert("查询错误,请重试");
		}
	})
}

//弃用，但保留代码参考
//查询当前停车场状态,并绘制停车场车辆
function drawCarOnPort(){
	$.ajax({
		type:"POST",
		url:"searchAllCarInfo.action",
		data:{},
		dataType:"json",
		async:true,	
		success: function(resultList){
			if (resultList.length > 0) {
				for (var i = 0; resultList.length > i; i++) {
					// 遍历当前画布上所有对象
					var objects = canvas.getObjects();
					for (var j = objects.length - 1; j >= 0; j--) {
						var object = objects[j];
						//找到对应的出库
						if(object.id == resultList[i].carport_num){
							//将车库颜色更换成红色
							object.set('fill', 'red');
							//在对应的车库里画车
							drawOneCar(object.left,object.top,object.id);
						}
					}
				}
			}else{
				alert("没有结果");
			}
		}
	})
}

//获取当前工程下文件的路径

//车辆入库模态框
//弹出车辆入库的模态框
function updatemyModal2(id){
	var inCarPort_id = document.getElementById("inCarPort_id");
	var inCarPort_num = document.getElementById("inCarPort_num");
	allResultList;
	for(var i=0;allResultList.length>i;i++){
		if(allResultList[i].carport_num == id){
			inCarPort_id.innerText = allResultList[i].carport_num;
			inCarPort_num.value = allResultList[i].carport_num;
		}
	}
	$('#myModal2').modal('show');
}

//车辆出库模态框

//弹出车辆出库的模态框
function updatemyModal1(id){
	var outCarPort_id = document.getElementById("outCarPort_id");
	var outCarPort_num = document.getElementById("outCarPort_num");
	allResultList;
	for(var i=0;allResultList.length>i;i++){
		if(allResultList[i].carport_num == id){
			outCarPort_id.innerText = allResultList[i].carport_num;
			outCarPort_num.value = allResultList[i].carport_num;
		}
	}
	$('#myModal1').modal('show');
}

//车辆入库上传信息

//车辆入库上传信息
function doUploadIn() {  
    var formData = new FormData($( "#uploadForm" )[0]);  
    $.ajax({  
         url: 'carPortUploadIn.action',  
         type: 'POST',  
         data: formData,  
         async: false,  
         cache: false,  
         contentType: false,  
         processData: false,  
         success: function (returndata) {  
             alert("成功" + returndata.car_park_license + "已经入库!"); 
             cleanCanvas();
             searchPort();
         },  
         error: function (returndata) {  
             alert("提交车辆照片失败");  
         }  
    });  
} 

//车辆出库上传信息
function doUploadOut() {  
    var formData = new FormData($( "#uploadForm1" )[0]);  
    $.ajax({  
         url: 'carPortUploadOut.action',  
         type: 'POST',  
         data: formData,  
         async: false,  
         cache: false,  
         contentType: false,  
         processData: false,  
         success: function (returndata) {  
        	 alert("成功" + returndata.car_park_license + "已经出库!");
             cleanCanvas();
             searchPort();
//             $(" font[ id='displayboard' ] ").text("欢迎!" + returndata.car_park_license + "的车主");
         },  
         error: function (returndata) {  
             alert("提交车辆照片失败");  
         }  
    });  
} 

//测试获取项目路径
function test(){
	var strFullPath=window.document.location.href;
    var strPath=window.document.location.pathname;
    var pos=strFullPath.indexOf(strPath);
    var prePath=strFullPath.substring(0,pos);
    var postPath=strPath.substring(0,strPath.substr(1).indexOf('/')+1);
    var webPath=prePath+postPath;
//    alert(webPath);
    return webPath;
}
//获得项目根路径
function getRootPath() {  
    var pathName = window.location.pathname.substring(1);  
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));  
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';  
} 

function useHelp(){
	alert('使用帮助：\n 1、三个选择框都不操作，则默认查询所有数据\n 2、起始卡号都填写则按照卡号进行查询\n 3、选择卡状态则按照卡状态查询\n 4、都填写则将按照所有选择条件查询');
}

