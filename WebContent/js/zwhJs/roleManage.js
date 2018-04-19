/**
 * 
 */


$(function(){
	searchAllRole();
});

//查询
function searchAllRole(){
	var msg = $('#searchRoleForm').serialize();
	$.ajax({
		type:"POST",
		url:"role/search.action",
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
				for(var j=0;j<3;j++){
					var tdNode = trNode.insertCell();
					if(j==0){
						tdNode.innerHTML = a++;
//					}else if(j==1){
//						tdNode.innerHTML = list[i].role_id;
					}else if(j==1){
						tdNode.innerHTML = list[i].role_name;
					}else if(j==2){
						var btnb = document.createElement("input");
						btnb.type = "button";
						btnb.value = "修改名称";
						btnb.setAttribute('data-toggle', 'modal');
						btnb.setAttribute('data-target', '#myModal2');	
						btnb.onclick = function(){
							updateRole(this, list);
						}
						
						tdNode.appendChild(btnb);

					}
				}
				}			
			}
	})

}

//修改名称
function updateRole(node, list){
	var number = node.parentNode.parentNode.cells[0].innerHTML;	//对应序号
	var role = list[number-1];	//对应用户对象数据

	document.getElementById("update_role_id").value = role.role_id;//角色ID
	document.getElementById("update_role_name").innerHTML = role.role_name;	//角色名		
}

//修改角色名称
function updateRoleSubmit(){
	var msg = $('#updateRoleForm').serialize();
	$.ajax({
		type:"POST",
		url:"role/updateName.action",
		data: msg,
		dataType:"json",	
		async:true,	
		success: function(date){
			alert(date);
			searchAllRole();
		}
	})
}

//增加角色
function addRole(){
	var msg = $('#addRoleForm').serialize();
	$.ajax({
		type:"POST",
		url:"role/add.action",
		data: msg,
		dataType:"json",
		async:true,	
		success: function(date){
			alert(date);
			searchAllRole();
		}
	})
}

