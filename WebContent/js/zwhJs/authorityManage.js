/**
 * 
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
$(document).ready(function(){
  getAllMenu();
});

//获取全部菜单
function getAllMenu(){
//	var msg = $('#searchForm').serialize();	
	$.ajax({
		type:"POST",
		url:"authority/searchAllMenu.action",
		data: "",
		dataType:"json",
		async:true,	
		success: function(menuList){
//			var aaa = jQuery.parseJSON(date);
			
			
		    var zTreeDemo = $.fn.zTree.init($("#cityTree"),setting, menuList); //初始化生成ztree对象  
		    var treeObj = $.fn.zTree.getZTreeObj("cityTree");	//获得tree对象
		    treeObj.expandAll(true);	//展开全部节点
		    
//		    treeObj.checkNode(treeObj.getNodeByParam("id", "2", null), true, true);	//根据条件选中
//	        treeObj.checkNode(treeObj.getNodeByParam("id", "2", null), true, true);
		    getRoleMenu();
		}	
	
	})
}

//获取角色拥有的菜单并选中
function getRoleMenu(){
	var treeObj = $.fn.zTree.getZTreeObj("cityTree");	//获得tree对象
	var msg = "role_id=" + "3";	
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
	var msg = "str=" + str + "&role_id=" + "3";
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