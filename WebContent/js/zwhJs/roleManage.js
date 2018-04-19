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
						
						var btnc = document.createElement("input");
						btnc.type = "button";
						btnc.value = "修改菜单";
						btnc.setAttribute('data-toggle', 'modal');
						btnc.setAttribute('data-target', '#myModal3');	
						btnc.onclick = function(){
							updateMenu(this, list);
						}
						
						tdNode.appendChild(btnb);
						tdNode.appendChild(btnc);
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

//修改对应菜单
function updateMenu(node, list){
	var number = node.parentNode.parentNode.cells[0].innerHTML;	//对应序号
	var role = list[number-1];	//对应用户对象数据
	
	//获取角色ID并记录
	document.getElementById("ztree_role_id").value = role.role_id;//角色ID	
	//生成角色对应的菜单树
	getAllMenu();	//ztree
}









/**
 * 		ztree 移过来的JS
 */

/**ztree的参数配置，setting主要是设置一些tree的属性，是本地数据源，还是远程，动画效果，是否含有复选框等等**/     
var setting = {  
 check: { /**复选框**/  
  enable: true,  //显示checkbox/radio
  chkboxType: { "Y" : "ps", "N" : "ps"}  //勾选 checkbox 对于父子节点的关联关系
 },  
 view: {                                    
  //dblClickExpand: false,  
  expandSpeed: 300 //设置树展开的动画速度，IE6下面没效果，  
 },                            
 data: {                                    
  simpleData: {   //简单的数据源，一般开发中都是从数据库里读取，API有介绍，这里只是本地的                           
   enable: true,  
   idKey: "id",  //id和pid，这里不用多说了吧，树的目录级别  
   pIdKey: "pId",  
   rootPId: 0   //根节点  
  }                            
 }                           
//  callback: {     /**回调函数的设置，随便写了两个**/  
//   beforeClick: beforeClick,                                    
//   onCheck: onCheck                            
//  }  
};  
// function beforeClick(treeId, treeNode) {  
//  alert("beforeClick");  
// }  
// function onCheck(e, treeId, treeNode) {  
//  alert("onCheck");  
// }       
  
  
//初始化
//$(document).ready(function(){
//  getAllMenu();
//});

//获取全部菜单
function getAllMenu(){
	$.ajax({
		type:"POST",
		url:"authority/searchAllMenu.action",
		data: "",
		dataType:"json",
		async:true,	
		success: function(menuList){
			
		    var zTreeDemo = $.fn.zTree.init($("#cityTree"),setting, menuList); //初始化生成ztree对象  
		    var treeObj = $.fn.zTree.getZTreeObj("cityTree");	//获得tree对象
		    treeObj.expandAll(true);	//展开全部节点
		    
		    getRoleMenu();
		}	
	
	})
}

//获取角色拥有的菜单并选中
function getRoleMenu(){
	var treeObj = $.fn.zTree.getZTreeObj("cityTree");	//获得tree对象
	var msg = $('#ztreeForm').serialize();	  	//选择的角色ID
	$.ajax({
		type:"POST",
		url:"authority/searchRoleMenu.action",
		data: msg,
		dataType:"json",
		async:true,	
		success: function(roleMenuList){
			//选中已有菜单
			for(var i=0;i<roleMenuList.length;i++){
				treeObj.checkNode(treeObj.getNodeByParam("id", roleMenuList[i].menu_id, null), true, true);	//根据条件选中
			}		    
		}	
	
	})
}

//提交
function submit(){
	var treeObj = $.fn.zTree.getZTreeObj("cityTree");	//获得tree对象
	var node = treeObj.getNodes();	//获得全部节点
	var nodes = treeObj.transformToArray(node);
	
	var str = "";
	//遍历节点
	for(var i=0;i<nodes.length;i++){
		//判断是不是父节点
		if(!nodes[i].isParent){
			//判断节点是否选中
		    if(nodes[i].checked){
	    		//拼接字符串
	    		if(str == ""){
	    			str = str + nodes[i].id;
	    		}else{
	    			str = str + "," + nodes[i].id;
	    		}
		    }
			
		}
	}
	
	var role_id = document.getElementById("ztree_role_id").value; //对应角色ID
	
	var msg = "str=" + str + "&role_id=" + role_id;
	$.ajax({
		type:"POST",
		url:"authority/updateRoleMenu.action",
		data: msg,
		dataType:"json",
		async:true,	
		success: function(data){
			alert(data);
		}	
	
	})
	
	
}
