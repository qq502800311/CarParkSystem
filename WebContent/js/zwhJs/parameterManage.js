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
	var msg = $('#searchParameterForm').serialize() + "&pageNum=" + "1";
	$.ajax({
		type:"POST",
		url:"parameter/search.action",
		data: msg,
		dataType:"json",
		async:true,	
		success: function(date){
			//清空表格
			$("#DataTables_Table_0 tr:not(:first)").html("");
			
			//写入数据
			var list = date.list;
			var tabNode = document.getElementById("DataTables_Table_0");
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
			
			//记录分页信息
			document.getElementById("pages").innerHTML = date.pages;	//总页数
			document.getElementById("total").innerHTML = date.total;	//查询总数
			
			//初始化页数
			document.getElementById("pageNum").text = 1;	//重置页码
			document.getElementById("lastPage").style = "color: red";	//上一页置灰
			//下一页置灰
			var pages = document.getElementById("pages").innerHTML;
			if(pages == 1){
				document.getElementById("nextPage").style = "color: red";
			}else{
				document.getElementById("nextPage").style = "";
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

//下一页
function nextPage(){
	var pageNum = document.getElementById("pageNum").text;	//当前页数
	var nextpageNum = Number(pageNum) + 1;	//下一页页数
	
	var pages = document.getElementById("pages").innerHTML;	//总页数

	//页数判断
	if(nextpageNum > pages){
//		alert("已经是最后一页了");
	}else{
		var msg = $('#searchParameterForm').serialize() + "&pageNum=" + nextpageNum;
		$.ajax({
			type:"POST",
			url:"parameter/search.action",
			data: msg,
			dataType:"json",
			async:true,	
			success: function(date){
				//清空表格
				$("#DataTables_Table_0 tr:not(:first)").html("");
				
				//写入数据
				var list = date.list;
				var tabNode = document.getElementById("DataTables_Table_0");
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
				//赋值新页数
				document.getElementById("pageNum").text = nextpageNum;
				
				//按钮操作（只改变颜色，不会禁用）
				if(nextpageNum == pages){	// 当前页数 = 总页数 时
					document.getElementById("nextPage").style = "color: red";
				}else{
					document.getElementById("nextPage").style = "";
				}
				
				document.getElementById("lastPage").style = ""; //恢复上一页颜色
				
			}
		
		})
	}
}

//上一页
function lastPage(){
	var pageNum = document.getElementById("pageNum").text;	//当前页数
	var nextpageNum = Number(pageNum) - 1;	//下一页页数
	
	var pages = document.getElementById("pages").innerHTML;	//总页数

	//页数判断
	if(nextpageNum == 0){
//		alert("已经是最后一页了");
	}else{
		var msg = $('#searchParameterForm').serialize() + "&pageNum=" + nextpageNum;
		$.ajax({
			type:"POST",
			url:"parameter/search.action",
			data: msg,
			dataType:"json",
			async:true,	
			success: function(date){
				//清空表格
				$("#DataTables_Table_0 tr:not(:first)").html("");
				
				//写入数据
				var list = date.list;
				var tabNode = document.getElementById("DataTables_Table_0");
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
				//赋值新页数
				document.getElementById("pageNum").text = nextpageNum;
				
				//按钮操作（只改变颜色，不会禁用）
				if(nextpageNum == 1){	// 当前页数 = 1 时
					document.getElementById("lastPage").style = "color: red";
				}else{
					document.getElementById("lastPage").style = "";
				}
				
				document.getElementById("nextPage").style = ""; //恢复下一页颜色
							
			}
		
		})
	}
}