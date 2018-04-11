/**
 * 
 */

//$(window).ready(testTable());//此处方法为正在加载，如果未能加载完成，则会出现ID、标签等无法找到

$(function() {//此处方法为全部加载完成，能保证全部ID、标签等都能找到
	search();
	useGetRequest();
})

var applyVerifyPersonID;
var applyVerifyPersonName;
var myDate = new Date();//获取系统当前时间

function search() {
//	alert('点击函数触发');
	//页面查询部分参数
	var doc_name = document.getElementById("doc_name").value;
	var doc_type = document.getElementById("doc_type").value;
	var import_Date1 = document.getElementById("import_Date1").value;
	var import_Date2 = document.getElementById("import_Date2").value;
	var doc_point = document.getElementById("doc_point").value;
	
	
//	alert('获得日期'+testDate);
//	alert('起始卡ID为：'+cardStart_ID+','+'起始卡ID为：'+cardStart_ID+','+'目标卡状态：'+cardState);
	
	$.ajax({
		type:"POST",
		url:"4.2/userFind.action",
//		data:"dsb.d_name=" + doc_name + "&dsb.d_type=" + doc_type + 
//			 "&dsb.d_date1=" + import_Date1 +"&dsb.d_date2=" + import_Date2 +
//			 "&dsb.d_point=" + doc_point,
		dataType:"json",
		async:true,	
		success: function(msg){
			//清空表格
			$("#myShowtab tr:not(:first)").html("");
			//写入数据
			var cardList = jQuery.parseJSON(msg);
//			var arrayList = JSON.parse(msg);
//			var arrayList = JSON.stringify(msg);
//			alert(msg);
			var tabNode = document.getElementById("myShowtab");
			var a = 1;
			for(var i=0;i<cardList.length;i++){
				var trNode = tabNode.insertRow();
				for(var j=0;j<10;j++){
					var tdNode = trNode.insertCell();
					var emp_EnableName;
					var emp_EnableName2;
					if( cardList[i].user_enable==1){
						emp_EnableName = '启用';
						emp_EnableName2 = '禁用';
					}else{
						emp_EnableName = '禁用';
						emp_EnableName2 = '启用';
					}
					if(j==0){
						tdNode.innerHTML = a++;
					}else if(j==1){
						tdNode.innerHTML = cardList[i].user_name;	//用户名称
					}else if(j==2){
						tdNode.innerHTML = cardList[i].user_date;		//用户注册时间
					}else if(j==3){
						tdNode.innerHTML = cardList[i].user_point;		//用户积分
					}else if(j==4){
						tdNode.innerHTML = cardList[i].user_up_number;//用户上传文档数
					}else if(j==5){
						tdNode.innerHTML = cardList[i].user_dl_number;//用户下载文档数
					}else if(j==6){
						tdNode.innerHTML = emp_EnableName;//用户状态
					}else if(j==7){
						var btnb = document.createElement("input");
						btnb.type = "button";
						btnb.id = "button"+i;
						btnb.value = "查看";
						btnb.onclick = function(){
							updatemyModal1(this,cardList);
//							myDelete(this);
							
						}
						//启用禁用按钮
						var btnb1 = document.createElement("input");
						btnb1.type = "button";
						btnb1.id = "button1"+i;
						btnb1.value = emp_EnableName2;
						btnb1.onclick = function(){
							changeEmpEnableApply(this,cardList);
//							myDelete(this);
							
						}
//						<button class="btn btn-primary" data-toggle="modal" data-target="#myModal">查看</button>	
						var btnb2 = document.createElement("input");
//						btnb2.setAttribute('data-toggle',"modal");
//						btnb2.setAttribute('data-target',"#myModal1");
						btnb2.type = "button";
						btnb2.id = "button2"+i;
						btnb2.value = "备用按钮1";
						btnb2.onclick = function(){
							deleteEmpPswApply(this,cardList);
//							myDelete(this);
							
						}
						var btnb3 = document.createElement("input");
//						btnb3.setAttribute('data-toggle',"modal");
//						btnb3.setAttribute('data-target',"#myModal1");
						btnb3.type = "button";
						btnb3.id = "button3"+i;
						btnb3.value = "备用按钮2";
						btnb3.onclick = function(){
							changeEmpPswApply(this,cardList);
//							myDelete(this);
							
						}
						tdNode.appendChild(btnb);
						tdNode.appendChild(btnb1);
						tdNode.appendChild(btnb2);
						tdNode.appendChild(btnb3);
					}
				}
			}
		}
	})
}

//添加新人员
function addNewEmp() {
	//新增人员部分参数
	var newEmp_Name = document.getElementById("newEmp_Name").value;
	var newEmp_Psw1 = document.getElementById("newEmp_Psw1").value;
	var newEmp_Psw2 = document.getElementById("newEmp_Psw2").value;
	var newEmp_D_ID = document.getElementById("newEmp_D_ID").value;
	var newEmp_ER_ID = document.getElementById("newEmp_ER_ID").value;
//	alert('新员工名字：'+newEmp_Name+','+'密码1：'+newEmp_Psw1+','+'密码2：'+newEmp_Psw2+','+'部门ID：'+newEmp_D_ID+','+'角色ID：'+newEmp_ER_ID);
	if(newEmp_Psw1==newEmp_Psw2){
		$.ajax({
			type:"POST",
//			url:"",
			url:"../Emp_Servlet?action=addEmp",
			data:"newEmp_Name=" + newEmp_Name + 
				 "&newEmp_Psw1=" + newEmp_Psw1 +
				 "&newEmp_D_ID=" + newEmp_D_ID + 
				 "&newEmp_ER_ID=" + newEmp_ER_ID,
			dataType:"text",
			async:true,	
			success: function(msg){
				if(msg == "true\r\n") {
			        //result就是servlet返回的数据
			        alert("添加人员成功");
			        search();
			    }else if(msg == "false\r\n") {
			        //result就是servlet返回的数据
			        alert("添加人员失败");
			    }
				
			}
		});
	}else{
		alert('两次密码不一致');
	}
	
//	search();
	
	
}


//截取从URL传来的参数
function GetRequest() {   
	   var url = location.search; //获取url中"?"符后的字串   
	   var theRequest = new Object();   
	   if (url.indexOf("?") != -1) {   
	      var str = url.substr(1);   
	      strs = str.split("&");   
	      for(var i = 0; i < strs.length; i ++) {   
	         theRequest[strs[i].split("=")[0]]=decodeURI(strs[i].split("=")[1]);   
	      }   
	   }   
	   return theRequest;   
}  

//使用方法
function useGetRequest() {   
	var Request = new Object();
	Request = GetRequest();
//	var TEST1, TESTN;
//	TEST1 = Request["TEST1"];
//	TESTN = Request["TESTN"];
	var test = Request["userID"];
	var test2 = Request["userName"];
	applyVerifyPersonID = test;
	applyVerifyPersonName = test2;
//	alert("接收到传来的员工ID："+test+"接收到传来的员工名字："+test2);
//	alert("newApplyPersonID："+applyVerifyPersonID);
}


function getApplyID(buttonID,cardList){
//	alert("获取ID函数启动");
	var tdNode=$(buttonID).parent();
	var trNode=tdNode.parent();
	var idd=trNode.children().eq(0).html();
	var idd2=trNode.children().eq(6).html();
	var i = idd - 1;
//	//获取点击的申请序号
//	var applyID = cardList[i].applyID;
//	//获取点击的申请卡数量
//	var applyCardNumber = cardList[i].applyCardNumber;
//	alert("要审批的申请ID"+applyID);
//	return [i,applyCardNumber];
	return [i,idd2];
	
	   
}


//提交人员信息修改申请
function changeEmpApply(buttonID,cardList){
	var changeEmp_ID = document.getElementById("changeEmp_ID").innerText;
	var changeEmp_Name = document.getElementById("changeEmp_Name").value;
	var changeEmp_D_ID = document.getElementById("changeEmp_D_ID").value;
	var changeEmp_ER_ID = document.getElementById("changeEmp_ER_ID").value;
	var newApplyVerifyPerson = applyVerifyPersonID;

//	alert('applyID:'+applyID+'newApplyVerifyPerson:'+newApplyVerifyPerson+',applyCardNumber:'+applyCardNumber);
	$.ajax({
		type:"POST",
//		url:"",
		url:"../Emp_Servlet?action=changeEmpApply",
		data:"changeEmp_ID=" + changeEmp_ID + 
			 "&changeEmp_Name=" + changeEmp_Name + 
			 "&changeEmp_D_ID=" + changeEmp_D_ID + 
			 "&newApplyVerifyPerson=" + newApplyVerifyPerson + 
			 "&changeEmp_ER_ID=" + changeEmp_ER_ID,
		dataType:"text",
		async:true,	
		success: function(msg){
			if(msg == "true\r\n") {
		        //result就是servlet返回的数据
		        alert("提交修改成功");
		        search();
		    }else if(msg == "false\r\n") {
		        //result就是servlet返回的数据
		        alert("提交修改失败");
		    }
			
		}
	});
	
}

//提交人员启用禁用修改申请
function changeEmpEnableApply(buttonID,cardList){
	var i = getApplyID(buttonID,cardList)[0];
	alert("选择了第："+i);
	var changeUser_ID = cardList[i].user_id;
	var changeUser_Name = cardList[i].user_name;
	var changeUser_Enable = getApplyID(buttonID,cardList)[1];
//	var newApplyVerifyPerson = applyVerifyPersonID;
	alert("当前要操作的用户情况：用户id："+changeUser_ID+",用户名称："+changeUser_Name+",用户启用情况："+changeUser_Enable);
	if(changeUser_Enable=="启用"){
		changeUser_Enable=0;
	}else{
		changeUser_Enable=1;
	}

	$.ajax({
		type:"POST",
//		url:"",
		url:"4.2/adminEnableUser.action",
		data:"user.user_id=" + changeUser_ID + 
			 "&user.user_enable=" + changeUser_Enable,
		dataType:"text",
		async:true,	
		success: function(msg){
			var flag = jQuery.parseJSON(msg);
			if(flag == true) {
		        //result就是servlet返回的数据
		        alert("提交修改成功");
		        search();
		    }else if(flag == false) {
		        //result就是servlet返回的数据
		        alert("提交修改失败");
		    }
			
		}
	});
	
}

//提交人员删除修改申请
function deleteEmpPswApply(buttonID,cardList){
	var i = getApplyID(buttonID,cardList)[0];
	var changeEmp_ID = cardList[i].emp_ID;
	var newApplyVerifyPerson = applyVerifyPersonID;
	
	$.ajax({
		type:"POST",
//		url:"",
		url:"../Emp_Servlet?action=deleteEmpPswApply",
		data:"changeEmp_ID=" + changeEmp_ID + 
			 "&newApplyVerifyPerson=" + newApplyVerifyPerson,
		dataType:"text",
		async:true,	
		success: function(msg){
			if(msg == "true\r\n") {
		        //result就是servlet返回的数据
		        alert("删除人员成功");
		        search();
		    }else if(msg == "false\r\n") {
		        //result就是servlet返回的数据
		        alert("删除人员失败");
		    }
			
		}
	});
	
}

//提交人员重置密码修改申请
function changeEmpPswApply(buttonID,cardList){
	var i = getApplyID(buttonID,cardList)[0];
	var changeEmp_ID = cardList[i].emp_ID;
	var changeEmp_Psw = 123456;
	var newApplyVerifyPerson = applyVerifyPersonID;
	
	$.ajax({
		type:"POST",
//		url:"",
		url:"../Emp_Servlet?action=changeEmpPswApply",
		data:"changeEmp_ID=" + changeEmp_ID + 
			 "&changeEmp_Psw=" + changeEmp_Psw + 
			 "&newApplyVerifyPerson=" + newApplyVerifyPerson,
		dataType:"text",
		async:true,	
		success: function(msg){
			if(msg == "true\r\n") {
		        //result就是servlet返回的数据
		        alert("重置密码成功");
		    }else if(msg == "false\r\n") {
		        //result就是servlet返回的数据
		        alert("重置密码失败");
		    }
			
		}
	});
	
}

//更新查看按钮弹出来的模态框内容
function updatemyModal1(buttonID,cardList){
	var i = getApplyID(buttonID, cardList)[0];
//	alert("要修改的人员工号ID"+i);
	var changeEmp_Name = document.getElementById("changeEmp_Name");
	var changeEmp_D_ID = document.getElementById("changeEmp_D_ID");
	var changeEmp_ER_ID = document.getElementById("changeEmp_ER_ID");
	
	document.getElementById("changeEmp_ID").innerText = cardList[i].emp_ID;
	changeEmp_Name.value = cardList[i].emp_Name;		//人名
	changeEmp_D_ID.value = cardList[i].d_ID;		//部门
	changeEmp_ER_ID.value = cardList[i].er_ID;		//角色
	$('#myModal2').modal('show');
//	alert("更新完成");
}
function useHelp(){
	alert('使用帮助：\n 1、三个选择框都不操作，则默认查询所有数据\n 2、起始卡号都填写则按照卡号进行查询\n 3、选择卡状态则按照卡状态查询\n 4、都填写则将按照所有选择条件查询');
}

//执行一个laydate实例，日期控件用，非常重要
laydate.render({
	elem : '#import_Date1' //指定元素
});
//同上截止日期
laydate.render({
	elem : '#import_Date2' //指定元素
});
