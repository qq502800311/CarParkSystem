/**
 * 
 */

$(function(){
	searchAllRole();	//先查询角色信息，再查用户信息
});

//查询全部角色
function searchAllRole(){
	$.ajax({
		type:"POST",
		url:"role/search.action",
		dataType:"json",
		async:true,	
		success: function(roleList){
			//查询一次
			search(roleList);
			//新增用户模态框中的角色选项
			var roleNode = document.getElementById("new_role_id");	//角色节点
			roleNode.options.length = 0; //清空角色选项
			for(var i=0; i<roleList.length; i++){
				roleNode.options.add(new Option(roleList[i].role_name, roleList[i].role_id));
			}
		}
	})
}

//查询
function search(roleList){
	var msg = $('#searchForm').serialize();	
	$.ajax({
		type:"POST",
		url:"emp/search.action",
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
				for(var j=0;j<7;j++){
					var tdNode = trNode.insertCell();
					if(j==0){
						tdNode.innerHTML = a++;
					}else if(j==1){
						tdNode.innerHTML = list[i].emp_id;
					}else if(j==2){
						tdNode.innerHTML = list[i].emp_name;
					}else if(j==3){
						tdNode.innerHTML = list[i].emp_pwd;
					}else if(j==4){
						for(var k=0;k<list[i].empRoleList.length;k++){
							tdNode.innerHTML += "[" + list[i].empRoleList[k].role.role_name + "]";
						}
					}else if(j==5){
						tdNode.innerHTML = list[i].emp_status;
					}else if(j==6){
						var btnb = document.createElement("input");
						btnb.type = "button";
						btnb.value = "增加角色";
						btnb.setAttribute('data-toggle', 'modal');
						btnb.setAttribute('data-target', '#myModal2');	
						btnb.onclick = function(){
							addRole(this, list, roleList);
						}
						
						var btnc = document.createElement("input");
						btnc.type = "button";
						btnc.value = "删除角色";
						btnc.setAttribute('data-toggle', 'modal');
						btnc.setAttribute('data-target', '#myModal3');	
						btnc.onclick = function(){
							deleteRole(this, list, roleList);
						}

						var btnd = document.createElement("input");
						btnd.type = "button";
						if(list[i].emp_status == "启用"){
							btnd.value = "禁用";
						}else{
							btnd.value = "启用";
						}
						btnd.setAttribute('data-toggle', 'modal');
						btnd.setAttribute('data-target', '#myModal4');							
						btnd.onclick = function(){
							updateEmpStatus(this, list);
						}	

						
						var btne = document.createElement("input");
						btne.type = "button";
						btne.value = "重置密码";
						btne.onclick = function(){
							updatePwd(this, list);
						}
						btne.setAttribute('data-toggle', 'modal');
						btne.setAttribute('data-target', '#myModal5');		
						
						tdNode.appendChild(btnb);
						tdNode.appendChild(btnc);
						tdNode.appendChild(btnd);
						tdNode.appendChild(btne);

					}
				}
			}			
		}
	})
}

//增加角色（按钮）
function addRole(node, list, roleList){
	var number = node.parentNode.parentNode.cells[0].innerHTML;	//对应序号
	var emp = list[number-1];	//对应用户对象数据
	
	document.getElementById("add_emp_id").innerHTML = emp.emp_id;	//用户ID
	document.getElementById("add_emp_name").innerHTML = emp.emp_name;	//用户名
		
	var roleNode = document.getElementById("add_role_id");	//角色节点
	roleNode.options.length = 0; //清空角色选项
	
	//全部角色
	var flag = 0;
	for(var i=0; i<roleList.length; i++){
		//用户拥有角色
		flag = 1;
		for(var j=0; j<emp.empRoleList.length; j++){
			if(roleList[i].role_id == emp.empRoleList[j].role.role_id){
				flag = 0;
			}
		}
		//存在用0，不存在用1
		if(flag == 1){
			//new Option(text,value)
			roleNode.options.add(new Option(roleList[i].role_name, roleList[i].role_id));
		}
	}
	
}

//增加角色请求
function addRoleSubmit(){
	//空值判断
	if(document.getElementById("add_role_id").options.length != 0){
		var msg = $('#addEmpRoleForm').serialize() + "&emp_id=" + document.getElementById("add_emp_id").innerHTML;
		$.ajax({
			type:"POST",
			url:"empRole/add.action",
			data: msg,
			dataType:"json",
			async:true,	
			success: function(date){
				alert(date);
				searchAllRole();
			}
		})
	}else{
		alert("选项为空，角色已满");
	}
}

//删除角色（按钮）
function deleteRole(node, list, roleList){
	var number = node.parentNode.parentNode.cells[0].innerHTML;	//对应序号
	var emp = list[number-1];	//对应用户对象数据
	
	document.getElementById("delete_emp_id").innerHTML = emp.emp_id;	//用户ID
	document.getElementById("delete_emp_name").innerHTML = emp.emp_name;	//用户名
		
	var roleNode = document.getElementById("delete_role_id");	//角色节点
	roleNode.options.length = 0; //清空角色选项
	
	//全部角色
	var flag = 0;
	for(var i=0; i<roleList.length; i++){
		//用户拥有角色
		flag = 1;
		for(var j=0; j<emp.empRoleList.length; j++){
			if(roleList[i].role_id == emp.empRoleList[j].role.role_id){
				flag = 0;
			}
		}
		//存在用0，不存在用1
		if(flag == 0){
			//new Option(text,value)
			roleNode.options.add(new Option(roleList[i].role_name, roleList[i].role_id));
		}
	}
}

//删除角色请求
function deleteRoleSubmit(){
	//空值判断
	if(document.getElementById("delete_role_id").options.length != 1){
		var msg = $('#deleteEmpRoleForm').serialize() + "&emp_id=" + document.getElementById("delete_emp_id").innerHTML;
		$.ajax({
			type:"POST",
			url:"empRole/delete.action",
			data: msg,
			dataType:"json",
			async:true,	
			success: function(date){
				alert(date);
				searchAllRole();
			}
		})
	}else{
		alert("至少保留一个角色");
	}
}

//更改用户状态（按钮）
function updateEmpStatus(node, list){
	var number = node.parentNode.parentNode.cells[0].innerHTML;	//对应序号
	var emp = list[number-1];	//对应用户对象数据
	//在模态框中记录用户ID，状态
	document.getElementById("update_emp_id").innerHTML = emp.emp_id;
	document.getElementById("update_emp_status").innerHTML = emp.emp_status;
}

//更改用户状态请求
function updateEmpStatusSubmit(){
	var emp_id = document.getElementById("update_emp_id").innerHTML;
	var emp_status = document.getElementById("update_emp_status").innerHTML;
	
	var msg = "emp_id=" + emp_id + "&emp_status=" + emp_status;
	$.ajax({
		type:"POST",
		url:"emp/updateStatus.action",
		data: msg,
		dataType:"json",
		async:true,	
		success: function(date){
			alert(date);
			searchAllRole();
		}
	})
}

//重置用户密码（按钮）
function updatePwd(node, list){
	var number = node.parentNode.parentNode.cells[0].innerHTML;	//对应序号
	var emp = list[number-1];	//对应用户对象数据
	//在模态框中记录用户ID，状态
	document.getElementById("update_pwd_emp_id").innerHTML = emp.emp_id;
}

//重置用户密码请求
function updateEmpPwdSubmit(){
	var emp_id = document.getElementById("update_pwd_emp_id").innerHTML;
	
	var msg = "emp_id=" + emp_id;
	$.ajax({
		type:"POST",
		url:"emp/updatePwd.action",
		data: msg,
		dataType:"json",
		async:true,	
		success: function(date){
			alert(date);
			searchAllRole();
		}
	})
}
