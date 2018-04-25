/**
 * 
 */


function addcarport() {
	var flag_carport_area = blur_carport_area();
	var flag_carport_num1 = blur_carport_num1();

	if (flag_carport_area != true) {
		alert("请输入正确值");
	} else if (flag_carport_num1 != true) {
		alert("请输入正确值");

	} else {

		var carport_area = $("#carport_area").val();
		var carport_num1 = $("#carport_num1").val();
		// var carport_num2 = $("#carport_num2").val();
		$.post("carport/addcarport.action", {
			"carport_area" : carport_area,
			"carport_num1" : carport_num1

		},

		function(data) {
			search();
//			alert(data);

		});
	}
}

function search() {
	$("#myShowbody").html("");
	
	var msg = $('#carport_from').serialize() + "&pageNum=" + "1";	
	$.post("carport/searchcarport.action",msg,

	function(data) {
		var list = data.list;
		var tablebadyNode = document.getElementById("myShowbody");

		var tr = "";

		for (var i = 0; i < list.length; i++) {
			
			tr += "<tr>";
			tr += "<td>" + (i + 1) + "</td>";
			tr += "<td>" + list[i].carport_area + "</td>";
			tr += "<td>" + list[i].carport_num + "</td>";

			tr += "<td>" + list[i].parameter_tb.parameter_name + "</td>";

			if (list[i].carport_status == '8') {
				tr += "<td><button class='btn btn-primary' value=" + i
						+ " onclick='initiatemode(this);' >启用</button>";
			} else {
				tr += "<td><button class='btn btn-danger' value=" + i
						+ " onclick='initiatemode(this);' >维护</button>";
			}

			tr += "<input type='hidden' class='hiddecarport_id'value='"
					+ list[i].carport_id + "'>";
			tr += "<input type='hidden' class='hiddecarport_status'value='"
					+ list[i].carport_status + "'>";
			tr += "<input type='hidden' class='hiddecarport_area'value='"
					+ list[i].carport_area + "'><td>";

		}
		$("#myShowbody").append(tr);
		//记录分页信息
		document.getElementById("pages").innerHTML = data.pages;	//总页数
		document.getElementById("total").innerHTML = data.total;	//查询总数
		
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
	});

}
$(function(){
	search();
})
//下一页
function nextPage(){
	var pageNum = document.getElementById("pageNum").text;	//当前页数
	var nextpageNum = Number(pageNum) + 1;	//下一页页数
	
	var pages = document.getElementById("pages").innerHTML;	//总页数

	//页数判断
	if(nextpageNum > pages){
//		alert("已经是最后一页了");
	}else{
		$("#myShowbody").html("");
		var msg = $('#carport_from').serialize() + "&pageNum=" + nextpageNum;
		
		$.post("carport/searchcarport.action",msg,

				function(data) {
					var list = data.list;
					var tablebadyNode = document.getElementById("myShowbody");

					var tr = "";
				
					for (var i = 0; i < list.length; i++) {
						tr += "<tr>";
						tr += "<td>" + (i + 1) + "</td>";
						tr += "<td>" + list[i].carport_area + "</td>";
						tr += "<td>" + list[i].carport_num + "</td>";

						tr += "<td>" + list[i].parameter_tb.parameter_name + "</td>";

						if (list[i].carport_status == '8') {
							tr += "<td><button class='btn btn-primary' value=" + i
									+ " onclick='initiatemode(this);' >启用</button>";
						} else {
							tr += "<td><button class='btn btn-danger' value=" + i
									+ " onclick='initiatemode(this);' >维护</button>";
						}

						tr += "<input type='hidden' class='hiddecarport_id'value='"
								+ list[i].carport_id + "'>";
						tr += "<input type='hidden' class='hiddecarport_status'value='"
								+ list[i].carport_status + "'>";
						tr += "<input type='hidden' class='hiddecarport_area'value='"
								+ list[i].carport_area + "'><td>";

					}
					$("#myShowbody").append(tr);
					
					//赋值新页数
					document.getElementById("pageNum").text = nextpageNum;
					
					//按钮操作（只改变颜色，不会禁用）
					if(nextpageNum == pages){	// 当前页数 = 总页数 时
						document.getElementById("nextPage").style = "color: red";
					}else{
						document.getElementById("nextPage").style = "";
					}
					
					document.getElementById("lastPage").style = ""; //恢复上一页颜色
					
		});
		
		
		
		
		
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
		var msg = $('#carport_from').serialize() + "&pageNum=" + nextpageNum;
		
		$("#myShowbody").html("");
	
		
		$.post("carport/searchcarport.action",msg,

				function(data) {
					var list = data.list;
					var tablebadyNode = document.getElementById("myShowbody");

					var tr = "";
				
					for (var i = 0; i < list.length; i++) {
						tr += "<tr>";
						tr += "<td>" + (i + 1) + "</td>";
						tr += "<td>" + list[i].carport_area + "</td>";
						tr += "<td>" + list[i].carport_num + "</td>";

						tr += "<td>" + list[i].parameter_tb.parameter_name + "</td>";

						if (list[i].carport_status == '8') {
							tr += "<td><button class='btn btn-primary' value=" + i
									+ " onclick='initiatemode(this);' >启用</button>";
						} else {
							tr += "<td><button class='btn btn-danger' value=" + i
									+ " onclick='initiatemode(this);' >维护</button>";
						}

						tr += "<input type='hidden' class='hiddecarport_id'value='"
								+ list[i].carport_id + "'>";
						tr += "<input type='hidden' class='hiddecarport_status'value='"
								+ list[i].carport_status + "'>";
						tr += "<input type='hidden' class='hiddecarport_area'value='"
								+ list[i].carport_area + "'><td>";

					}
					$("#myShowbody").append(tr);
					//赋值新页数
					document.getElementById("pageNum").text = nextpageNum;
					
					//按钮操作（只改变颜色，不会禁用）
					if(nextpageNum == 1){	// 当前页数 = 1 时
						document.getElementById("lastPage").style = "color: red";
					}else{
						document.getElementById("lastPage").style = "";
					}
					
					document.getElementById("nextPage").style = ""; //恢复下一页颜色
					
		});
	}
}


// // 启用 或者禁用状态
function initiatemode(node) {
	var number = $(node).val();
	var carport_id = $("#myShowbody tr").eq(number).find(".hiddecarport_id")
			.val();
	var carport_status = $("#myShowbody tr").eq(number).find(
			".hiddecarport_status").val();
	if (carport_status == '8') {
		var mymessage = confirm("请选择，是否启用");
		if (mymessage == true) {
			var str = {
				carport_id : carport_id,
				carport_status : carport_status
			};
			alert(JSON.stringify(str));
			$.post("carport/changestatus.action", {
				carport_id : carport_id,
				carport_status : carport_status
			}, function(data) {
				alert("123");
				search();

			});
		} else if (mymessage == false) {

		}
	} else {
		var mymessage = confirm("请选择，是否需要维护");
		if (mymessage == true) {
			var str = {
				carport_id : carport_id,
				carport_status : carport_status
			};
			alert(JSON.stringify(str));
			$.post("carport/changestatus.action", {
				carport_id : carport_id,
				carport_status : carport_status
			}, function(data) {
				alert("123");
				search();

			});
		} else if (mymessage == false) {

		}
	}
}

function blur_carport_area() {
	var zimuzhengze = /^[a-zA-Z]+$/;
	var carport_area = $("#carport_area").val();
	if (carport_area == '') {

		$("#carport_area_msg").html("不能为空").css("color", "red");
		return false;
	} else if (!zimuzhengze.test(carport_area)) {
		$("#carport_area_msg").html("请输入字母").css("color", "red");
		return false;
	} else {
		$("#carport_area_msg").html("通过").css("color", "green");
		return true;
	}
}
function blur_carport_num1() {
	var numzhengze = /^[0-9]*$/;
	var carport_num1 = $("#carport_num1").val();
	if (carport_num1 == '') {

		$("#carport_num_msg").html("不能为空").css("color", "red");
		return false;
	} else if (!numzhengze.test(carport_num1)) {
		$("#carport_num_msg").html("请输入数字").css("color", "red");
		return false;
	} else {
		$("#carport_num_msg").html("通过").css("color", "green");
		return true;
	}
}


//
// // 删除
// function deletecharge(node) {
// var number = $(node).val();
// var mealid = $("#myShowbody tr").eq(number).find(".hiddemeal_pid").val();
//
// var mymessage = confirm("请选择，是否删除");
// // alert(JSON.stringify(str));
// if (mymessage == true) {
//
// $.post("paymonth/deletemealtb.action", {
// "mealid" : mealid
// }, function(data) {
// alert("删除成功");
// search();
//
// });
// } else if (mymessage == false) {
//
// }
// }
