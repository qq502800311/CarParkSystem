/**
 * 
 */

$(function(){
	searchFirstMenu();	//先查询一级菜单信息，再查菜单信息
});

//查询一级菜单信息
function searchFirstMenu(){
	$.ajax({
		type:"POST",
		url:"menu/searchFirstMenu.action",
		dataType:"json",
		async:true,	
		success: function(firstMenuList){
			//查询模态框中的一级菜单列表
			var roleNode = document.getElementById("firstMenuList");	//一级菜单节点
//			roleNode.options.length = 0; //清空菜单选项
//			roleNode.options.add(new Option("不限", "")); //默认项
			for(var i=0; i<firstMenuList.length; i++){
				roleNode.options.add(new Option(firstMenuList[i].menu_name, firstMenuList[i].menu_id));
			}
			//查询一次
			search();
			//新增菜单模态框中的选项
			var roleNode1 = document.getElementById("add_menu_pid");	//一级菜单节点
//			roleNode.options.length = 0; //清空菜单选项
			for(var i=0; i<firstMenuList.length; i++){
				roleNode1.options.add(new Option(firstMenuList[i].menu_name, firstMenuList[i].menu_id));
			}
			//修改菜单模态框中的选项
			var roleNode2 = document.getElementById("update_menu_pid");	//一级菜单节点
//			roleNode.options.length = 0; //清空菜单选项
			for(var i=0; i<firstMenuList.length; i++){
				roleNode2.options.add(new Option(firstMenuList[i].menu_name, firstMenuList[i].menu_id));
			}
		}
	})
}

//查询菜单
function search(){
	var msg = $('#searchMenuForm').serialize();	 
	$.ajax({
		type:"POST",
		url:"menu/search.action",
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
				for(var j=0;j<5;j++){
					var tdNode = trNode.insertCell();
					if(j==0){
						tdNode.innerHTML = a++;
					}else if(j==1){
						tdNode.innerHTML = list[i].menu_name;
					}else if(j==2){
						tdNode.innerHTML = list[i].menu_url;
					}else if(j==3){
						tdNode.innerHTML = list[i].second_menu_name;
					}else if(j==4){
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

//增加菜单
function addMenu(){
	var msg = $('#addMenuForm').serialize();	 
	$.ajax({
		type:"POST",
		url:"menu/add.action",
		data: msg,
		dataType:"json",
		async:true,	
		success: function(date){
			alert(date);
			search();
		}
	})
}

//修改菜单（按钮）
function updateMenu(node, list){
	var number = node.parentNode.parentNode.cells[0].innerHTML;	//对应序号
	var menu = list[number-1];	//对应用户对象数据
	
	document.getElementById("update_menu_id").value = menu.menu_id;	//菜单ID
	document.getElementById("update_menu_name").value = menu.menu_name;	//菜单名称
//	document.getElementById("update_menu_pid").innerHTML = menu.emp_id;	//菜单PID
	document.getElementById("update_menu_url").value = menu.menu_url;	//菜单URL
	
	//select下拉框设置选中option
	  var all_options = document.getElementById("update_menu_pid").options;
	   for (var i=0; i<all_options.length; i++){
	      if (all_options[i].value == menu.menu_pid){  // 根据option标签的value来进行判断  
	         all_options[i].selected = true;
	      }
	   }
	
}

//修改菜单
function updateMenuSubmit(){
	var msg = $('#updateMenuForm').serialize();	
	$.ajax({
		type:"POST",
		url:"menu/update.action",
		data: msg,
		dataType:"json",
		async:true,	
		success: function(date){
			alert(date);
			search();
		}
	})
}