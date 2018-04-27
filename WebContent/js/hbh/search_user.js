

$(function(){
	search();
});

//查询用户
function search(){
	var user_id = $("#userid").val();
	var license = $("#license").val();
	var msg = $('#searchMenuForm').serialize()+"&pageNum=" + "1"+"&user_id=" +user_id+"&license="+license;
	$.ajax({
		url: "carport/searchUser.action",
//		contentType : "application/json;charset=utf-8",  //如果采用requestbody那么一定要加
		type:"POST",
		data: msg,
		dataType:"json",
		async:true,	
		success: function(date){
			$("#mytable tr:not(:first)").html("");
			var typelist = date.list;
			var tableNode = document.getElementById("mytable");
//			var tabNode = document.getElementById("DataTables_Table_0");
			for (var i = 0; i < typelist.length; i++) {
				var trNode = tableNode.insertRow();
				for(var j=0;j<9;j++){
					var tdNode = trNode.insertCell();
					switch (j) {
					case 0:
						tdNode.innerHTML = typelist[i].user_name;
						break;
					case 1:
						tdNode.innerHTML = typelist[i].user_id;
						break;
					case 2:
						tdNode.innerHTML = typelist[i].car_park_license;
						break;						
					case 3:
						tdNode.innerHTML =typelist[i].user_phone;
						break;	
					case 4:
						tdNode.innerHTML = typelist[i].meal.meal_name;
						break;
					case 5:
						tdNode.innerHTML = typelist[i].user_register_date;
						break;
					case 6:
						tdNode.innerHTML = typelist[i].user_timeout_date;
						break;
					case 7:
						tdNode.innerHTML = typelist[i].meal.meal_money;
						break;	
					case 8:
						tdNode.innerHTML = typelist[i].user_status;
						break;								
					default:
						break;
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

//下一页
function nextPage(){
	var pageNum = document.getElementById("pageNum").text;	//当前页数
	var nextpageNum = Number(pageNum) + 1;	//下一页页数
	
	var pages = document.getElementById("pages").innerHTML;	//总页数

	//页数判断
	if(nextpageNum > pages){
//		alert("已经是最后一页了");
	}else{
		var msg = $('#searchMenuForm').serialize() + "&pageNum="+ nextpageNum+"&user_id="+"&license=";
		$.ajax({
			url: "carport/searchUser.action",
//			contentType : "application/json;charset=utf-8",  //如果采用requestbody那么一定要加
			type: "POST",
			dataType: "json",
			data: msg,
			success: function(date){
				
				$("#mytable tr:not(:first)").html("");
				var typelist = date.list;
				var tableNode = document.getElementById("mytable");
//				var tabNode = document.getElementById("DataTables_Table_0");
				for (var i = 0; i < typelist.length; i++) {
					var trNode = tableNode.insertRow();
					for(var j=0;j<10;j++){
						var tdNode = trNode.insertCell();
						switch (j) {
						case 0:
							tdNode.innerHTML = typelist[i].user_name;
							break;
						case 1:
							tdNode.innerHTML = typelist[i].user_id;
							break;
						case 2:
							tdNode.innerHTML = typelist[i].car_park_license;
							break;						
						case 3:
							tdNode.innerHTML =typelist[i].user_phone;
							break;	
						case 4:
							tdNode.innerHTML = typelist[i].meal.meal_name;
							break;
						case 5:
							tdNode.innerHTML = typelist[i].user_register_date;
							break;
						case 6:
							tdNode.innerHTML = typelist[i].user_timeout_date;
							break;
						case 7:
							tdNode.innerHTML = typelist[i].meal.meal_money;
							break;	
						case 8:
							tdNode.innerHTML = typelist[i].user_status;
							break;								
						case 9:
							if(typelist[i].user_status=="启用"){
								tdNode.innerHTML = '<button type="button" onclick="moneyback(this)">退款</button>'
							} else {
								tdNode.innerHTML = '<button type="button" onclick="recharge_open(this)">充值</button>'
							}
							
							break;								
						default:
							break;
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

//上一页
function lastPage(){
	var pageNum = document.getElementById("pageNum").text;	//当前页数
	var nextpageNum = Number(pageNum) - 1;	//下一页页数
	
	var pages = document.getElementById("pages").innerHTML;	//总页数

	//页数判断
	if(nextpageNum == 0){
//		alert("已经是最后一页了");
	}else{
		var msg = $('#searchMenuForm').serialize()+"&pageNum="+nextpageNum+"&user_id="+"&license=";
		$.ajax({
			url: "carport/searchUser.action",
//			contentType : "application/json;charset=utf-8",  //如果采用requestbody那么一定要加
			type: "POST",
			dataType: "json",
			data: msg,
			success: function(date){
				$("#mytable tr:not(:first)").html("");
				var typelist = date.list;
				var tableNode = document.getElementById("mytable");
//				var tabNode = document.getElementById("DataTables_Table_0");
				for (var i = 0; i < typelist.length; i++) {
					var trNode = tableNode.insertRow();
					for(var j=0;j<10;j++){
						var tdNode = trNode.insertCell();
						switch (j) {
						case 0:
							tdNode.innerHTML = typelist[i].user_name;
							break;
						case 1:
							tdNode.innerHTML = typelist[i].user_id;
							break;
						case 2:
							tdNode.innerHTML = typelist[i].car_park_license;
							break;						
						case 3:
							tdNode.innerHTML =typelist[i].user_phone;
							break;	
						case 4:
							tdNode.innerHTML = typelist[i].meal.meal_name;
							break;
						case 5:
							tdNode.innerHTML = typelist[i].user_register_date;
							break;
						case 6:
							tdNode.innerHTML = typelist[i].user_timeout_date;
							break;
						case 7:
							tdNode.innerHTML = typelist[i].meal.meal_money;
							break;	
						case 8:
							tdNode.innerHTML = typelist[i].user_status;
							break;								
						case 9:
							if(typelist[i].user_status=="启用"){
								tdNode.innerHTML = '<button type="button" onclick="moneyback(this)">退款</button>'
							} else {
								tdNode.innerHTML = '<button type="button" onclick="recharge_open(this)">充值</button>'
							}
							
							break;								
						default:
							break;
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




