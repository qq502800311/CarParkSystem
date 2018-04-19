/**
 * 
 */

$(function(){
	searchParameterMenu();	//先查询一级菜单信息，再查菜单信息
});

//查询参数类型列表
function searchParameterMenu(){
	$.ajax({
		type:"POST",
		url:"parameter/searchParameterType.action",
		dataType:"json",
		async:true,	
		success: function(parameterTyleList){
			//查询模态框中的一级菜单列表
			var roleNode = document.getElementById("parameterTyleList");	//一级菜单节点
//			roleNode.options.length = 0; //清空菜单选项
//			roleNode.options.add(new Option("不限", "")); //默认项
			for(var i=0; i<parameterTyleList.length; i++){
				roleNode.options.add(new Option(parameterTyleList[i].parameter_name, parameterTyleList[i].parameter_id));
			}
			//查询一次
			search();
			//新增参数模态框中的选项
			var roleNode1 = document.getElementById("add_parameter_pid");	//一级菜单节点
//			roleNode.options.length = 0; //清空菜单选项
			for(var i=0; i<parameterTyleList.length; i++){
				roleNode1.options.add(new Option(parameterTyleList[i].parameter_name, parameterTyleList[i].parameter_id));
			}
			//修改参数模态框中的选项
			var roleNode2 = document.getElementById("update_parameter_pid");	//一级菜单节点
//			roleNode.options.length = 0; //清空菜单选项
			for(var i=0; i<parameterTyleList.length; i++){
				roleNode2.options.add(new Option(parameterTyleList[i].parameter_name, parameterTyleList[i].parameter_id));
			}
		}
	})
}

//查询
function search(){
	var msg = $('#searchParameterForm').serialize();	
	$.ajax({
		type:"POST",
		url:"parameter/search.action",
		data: msg,
		dataType:"json",
		async:true,	
		success: function(date){
			//清空表格
			$("#tab tr:not(:first)").html("");
			
			//写入数据
			var list = date;
			var tabNode = document.getElementById("tab");
			var a = 1;
			for(var i=0;i<list.length;i++){
				var trNode = tabNode.insertRow();
				for(var j=0;j<4;j++){
					var tdNode = trNode.insertCell();
					if(j==0){
						tdNode.innerHTML = a++;
					}else if(j==1){
						tdNode.innerHTML = list[i].parameter_name;
					}else if(j==2){
						tdNode.innerHTML = list[i].second_parameter_name;
					}else if(j==3){
						var btnb = document.createElement("input");
						btnb.type = "button";
						btnb.value = "修改";
						btnb.setAttribute('data-toggle', 'modal');
						btnb.setAttribute('data-target', '#myModal2');	
						btnb.onclick = function(){
							updateMenu(this, list);
						}
						
						tdNode.appendChild(btnb);
					}
				}
			}
		}
	})
}

//增加参数
function addParameter(){
	var msg = $('#addParameterForm').serialize();	 
	$.ajax({
		type:"POST",
		url:"parameter/add.action",
		data: msg,
		dataType:"json",
		async:true,	
		success: function(date){
			alert(date);
			search();
		}
	})
}

//修改角色（按钮）
function updateMenu(node, list){
	var number = node.parentNode.parentNode.cells[0].innerHTML;	//对应序号
	var parameter = list[number-1];	//对应用户对象数据
	
	document.getElementById("update_parameter_id").value = parameter.parameter_id;	//菜单ID
	document.getElementById("update_parameter_name").value = parameter.parameter_name;	//菜单名称
	
	//select下拉框设置选中option
	  var all_options = document.getElementById("update_parameter_pid").options;
	   for (var i=0; i<all_options.length; i++){
	      if (all_options[i].value == parameter.parameter_pid){  // 根据option标签的value来进行判断  
	         all_options[i].selected = true;
	      }
	   }
	
}

//修改菜单
function updateParameterSubmit(){
	var msg = $('#updateParameterForm').serialize();	
	$.ajax({
		type:"POST",
		url:"parameter/update.action",
		data: msg,
		dataType:"json",
		async:true,	
		success: function(date){
			alert(date);
			search();
		}
	})
}