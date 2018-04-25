/**
 * 
 */

var numberzhengze = /0|(^[1-9]+\d*$)/;
function blur_meal_1() {
	var mealmoney_1 = $("#mealmoney_1").val();
	if (mealmoney_1 == '') {

		$("#meal_1_msg").html("不能为空").css("color", "red");
		return false;
	} else if (!numberzhengze.test(mealmoney_1)) {
		$("#meal_1_msg").html("请输入正整数").css("color", "red");
		return false;
	} else {
		$("#meal_1_msg").html("通过").css("color", "green");
		return true;
	}

}
function blur_meal_2() {
	var mealmoney_2 = $("#mealmoney_2").val();
	if (mealmoney_2 == '') {

		$("#meal_2_msg").html("不能为空").css("color", "red");
		return false;
	} else if (!numberzhengze.test(mealmoney_2)) {
		$("#meal_2_msg").html("请输入正整数").css("color", "red");
		return false;
	} else {
		$("#meal_2_msg").html("通过").css("color", "green");
		return true;
	}

}
function blur_meal_3() {
	var mealmoney_3 = $("#mealmoney_3").val();
	if (mealmoney_3 == '') {

		$("#meal_3_msg").html("不能为空").css("color", "red");
		return false;
	} else if (!numberzhengze.test(mealmoney_3)) {
		$("#meal_3_msg").html("请输入正整数").css("color", "red");
		return false;
	} else {
		$("#meal_3_msg").html("通过").css("color", "green");
		return true;
	}

}

function addmeal() {
	var flag_meal_1 = blur_meal_1();
	var flag_meal_2 = blur_meal_2();
	var flag_meal_3 = blur_meal_3();

	if (flag_meal_1 != true) {
		alert("请输入正确值");
	} else if (flag_meal_2 != true) {
		alert("请输入正确值");

	} else if (flag_meal_3 != true) {
		alert("请输入正确值");

	} else {
		var mealmoney_1 = $("#mealmoney_1").val();
		var mealmoney_2 = $("#mealmoney_2").val();
		var mealmoney_3 = $("#mealmoney_3").val();

		// alert("提交"+JSON.stringify(saveDataAry););
		$.post("paymonth/addpaymoth.action", $("#addmeal_from").serialize(),
				function(data) {
					search();

				});

	}
}
$(function() {
	search();
});
function search() {
	$("#myShowbody").html("");
	var msg = $('#paymonthly_from').serialize() + "&pageNum=" + "1";	
	$  
			.post(
					"paymonth/searchpay.action",msg,

					function(data) {
						var list = data.list;
						var tablebadyNode = document
								.getElementById("myShowbody");

						var tr = "";
						var n=1;
						var k=-1;
						for (var i = 0; i < list.length; i++) {
							tr += "<tr>";
							if (i == (n + k)) {
								tr += "<td rowspan='3'>"+n+"</td>";
							}
							tr += "<td>" + list[i].meal_name + "</td>";
							tr += "<td>" + list[i].meal_money + "</td>";
							tr += "<td>" + list[i].meal_status + "</td>";
							tr += "<td>" + list[i].meal_detail + "";
							// 隐藏标签
							tr += "<input type='hidden' class='hiddemeal_id'value='"
									+ list[i].meal_id + "'>";
							tr += "<input type='hidden' class='hiddemeal_money'value='"
									+ list[i].meal_money + "'>";
							tr += "<input type='hidden' class='hiddemeal_name'value='"
									+ list[i].meal_name + "'>";
							tr += "<input type='hidden' class='hiddemeal_status'value='"
									+ list[i].meal_status + "'>";
							tr += "<input type='hidden' class='hiddemeal_pid'value='"
									+ list[i].meal_pid + "'></td>";
							// tr += "<td>" + data[i].charge_rule_5 + "</td>";
							// tr += "<td>" + data[i].charge_status + "</td>";
							if (i == (n + k)) {
								if (list[i].meal_status == '禁用') {
									tr += "<td  rowspan='3'><button class='btn btn-primary' value="
											+ i
											+ " onclick='initiatemode(this);' >启用</button>";
									tr += "<button class='btn btn-primary' value="
											+ i
											+ " data-toggle='modal' data-target='#myModal2' onclick='setmealtext(this);' >修改</button> ";
									tr += "<button class='btn btn-primary' value="
											+ i
											+ " onclick='deletecharge(this);' >删除</button>";
								} else {
									
									tr += "<td  rowspan='3'><button class='btn btn-primary'  value="
											+ i
											+ "  data-toggle='modal' data-target='#myModal2' onclick='setmealtext(this);' >修改</button>";
								}
								n += 1;
								k+=2;
							}
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
		var msg = $('#paymonthly_from').serialize() + "&pageNum=" + nextpageNum;
		
		$  
		.post(
				"paymonth/searchpay.action",msg,

				function(data) {
			var list = data.list;
			var tablebadyNode = document
					.getElementById("myShowbody");

			var tr = "";
			var n=1;
			var k=-1;
			for (var i = 0; i < list.length; i++) {
				tr += "<tr>";
				if (i == (n + k)) {
					tr += "<td rowspan='3'>"+n+"</td>";
				}
				tr += "<td>" + list[i].meal_name + "</td>";
				tr += "<td>" + list[i].meal_money + "</td>";
				tr += "<td>" + list[i].meal_status + "</td>";
				tr += "<td>" + list[i].meal_detail + "";
				// 隐藏标签
				tr += "<input type='hidden' class='hiddemeal_id'value='"
						+ list[i].meal_id + "'>";
				tr += "<input type='hidden' class='hiddemeal_money'value='"
						+ list[i].meal_money + "'>";
				tr += "<input type='hidden' class='hiddemeal_name'value='"
						+ list[i].meal_name + "'>";
				tr += "<input type='hidden' class='hiddemeal_status'value='"
						+ list[i].meal_status + "'>";
				tr += "<input type='hidden' class='hiddemeal_pid'value='"
						+ list[i].meal_pid + "'></td>";
				// tr += "<td>" + data[i].charge_rule_5 + "</td>";
				// tr += "<td>" + data[i].charge_status + "</td>";
				if (i == (n + k)) {
					if (list[i].meal_status == '禁用') {
						tr += "<td  rowspan='3'><button class='btn btn-primary' value="
								+ i
								+ " onclick='initiatemode(this);' >启用</button>";
						tr += "<button class='btn btn-primary' value="
								+ i
								+ " data-toggle='modal' data-target='#myModal2' onclick='setmealtext(this);' >修改</button> ";
						tr += "<button class='btn btn-primary' value="
								+ i
								+ " onclick='deletecharge(this);' >删除</button>";
					} else {
						
						tr += "<td  rowspan='3'><button class='btn btn-primary'  value="
								+ i
								+ "  data-toggle='modal' data-target='#myModal2' onclick='setmealtext(this);' >修改</button>";
					}
					n += 1;
					k+=2;
				}
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
		var msg = $('#paymonthly_from').serialize() + "&pageNum=" + nextpageNum;
		
		$("#myShowbody").html("");
	
		
		$  
		.post(
				"paymonth/searchpay.action",msg,

				function(data) {
			var list = data.list;
			var tablebadyNode = document
					.getElementById("myShowbody");

			var tr = "";
			var n=1;
			var k=-1;
			for (var i = 0; i < list.length; i++) {
				tr += "<tr>";
				if (i == (n + k)) {
					tr += "<td rowspan='3'>"+n+"</td>";
				}
				tr += "<td>" + list[i].meal_name + "</td>";
				tr += "<td>" + list[i].meal_money + "</td>";
				tr += "<td>" + list[i].meal_status + "</td>";
				tr += "<td>" + list[i].meal_detail + "";
				// 隐藏标签
				tr += "<input type='hidden' class='hiddemeal_id'value='"
						+ list[i].meal_id + "'>";
				tr += "<input type='hidden' class='hiddemeal_money'value='"
						+ list[i].meal_money + "'>";
				tr += "<input type='hidden' class='hiddemeal_name'value='"
						+ list[i].meal_name + "'>";
				tr += "<input type='hidden' class='hiddemeal_status'value='"
						+ list[i].meal_status + "'>";
				tr += "<input type='hidden' class='hiddemeal_pid'value='"
						+ list[i].meal_pid + "'></td>";
				// tr += "<td>" + data[i].charge_rule_5 + "</td>";
				// tr += "<td>" + data[i].charge_status + "</td>";
				if (i == (n + k)) {
					if (list[i].meal_status == '禁用') {
						tr += "<td  rowspan='3'><button class='btn btn-primary' value="
								+ i
								+ " onclick='initiatemode(this);' >启用</button>";
						tr += "<button class='btn btn-primary' value="
								+ i
								+ " data-toggle='modal' data-target='#myModal2' onclick='setmealtext(this);' >修改</button> ";
						tr += "<button class='btn btn-primary' value="
								+ i
								+ " onclick='deletecharge(this);' >删除</button>";
					} else {
						
						tr += "<td  rowspan='3'><button class='btn btn-primary'  value="
								+ i
								+ "  data-toggle='modal' data-target='#myModal2' onclick='setmealtext(this);' >修改</button>";
					}
					n += 1;
					k+=2;
				}
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


// 启用 或者禁用状态
function initiatemode(node) {

	var number = $(node).val();
	var meal_status = $("#myShowbody tr").eq(number).find(".hiddemeal_status")
			.val();
	var meal_pid = $("#myShowbody tr").eq(number).find(".hiddemeal_pid").val();
	if (meal_status == '启用') {
		var mymessage = confirm("请选择，是否禁用");
		if (mymessage == true) {
			$.post("paymonth/changestatus.action", {

				meal_status : meal_status,
				meal_pid : meal_pid
			}, function(data) {
				alert("123");
				search();

			});
		} else if (mymessage == false) {

		}
	} else {

		var mymessage = confirm("请选择，是否启用");
		if (mymessage == true) {
			$.post("paymonth/changestatus.action", {

				meal_status : meal_status,
				meal_pid : meal_pid
			}, function(data) {
				// alert("删除" + currentcarparklicense + "完成");
				search();
			});
		} else if (mymessage == false) {

		}
	}

}
// 设置在修改模态框里面原来的值
var hiddemeal_id1 = null;
var hiddemeal_pid1 = null;
var hiddemeal_name1 = null;
var hiddemeal_status1 = null;
var hiddemeal_money1 = null;

var hiddemeal_id2 = null;
var hiddemeal_pid2 = null;
var hiddemeal_name2 = null;
var hiddemeal_status2 = null;
var hiddemeal_money2 = null;

var hiddemeal_id3 = null;
var hiddemeal_pid3 = null;
var hiddemeal_name3 = null;
var hiddemeal_status3 = null;
var hiddemeal_money3 = null;

function setmealtext(node) {
	var number = $(node).val();

	hiddemeal_id1 = $("#myShowbody tr").eq(number).find(".hiddemeal_id").val();

	hiddemeal_pid1 = $("#myShowbody tr").eq(number).find(".hiddemeal_pid")
			.val();
	hiddemeal_name1 = $("#myShowbody tr").eq(number).find(".hiddemeal_name")
			.val();
	hiddemeal_status1 = $("#myShowbody tr").eq(number)
			.find(".hiddemeal_status").val();
	hiddemeal_money1 = $("#myShowbody tr").eq(number).next("tr").find(".hiddemeal_money")
			.val();
	hiddemeal_id2 = $("#myShowbody tr").eq(number ).next("tr").find(".hiddemeal_id")
			.val();

	hiddemeal_pid2 = $("#myShowbody tr").eq(number ).next("tr").find(".hiddemeal_pid")
			.val();
	hiddemeal_name2 = $("#myShowbody tr").eq(number ).next("tr")
			.find(".hiddemeal_name").val();
	hiddemeal_status2 = $("#myShowbody tr").eq(number ).next("tr").find(
			".hiddemeal_status").val();
	hiddemeal_money2 = $("#myShowbody tr").eq(number ).next("tr").find(
			".hiddemeal_money").val();

	hiddemeal_id3 = $("#myShowbody tr").eq(number).next("tr").next("tr").find(".hiddemeal_id")
			.val();
	hiddemeal_pid3 = $("#myShowbody tr").eq(number).next("tr").next("tr").find(".hiddemeal_pid")
			.val();
	hiddemeal_name3 = $("#myShowbody tr").eq(number ).next("tr").next("tr")
			.find(".hiddemeal_name").val();
	hiddemeal_status3 = $("#myShowbody tr").eq(number ).next("tr").next("tr").find(
			".hiddemeal_status").val();
	hiddemeal_money3 = $("#myShowbody tr").eq(number ).next("tr").next("tr").find(
			".hiddemeal_money").val();

	$("#modifier_mealmoney_1").attr("value", hiddemeal_money1);
	$("#modifier_mealmoney_2").attr("value", hiddemeal_money2);
	$("#modifier_mealmoney_3").attr("value", hiddemeal_money3);

}

function modifier_blur_money_1() {
	var modifier_mealmoney_1 = $("#modifier_mealmoney_1").val();
	if (modifier_mealmoney_1 == '') {

		$("#modifier_mealmoney_1_msg").html("不能为空").css("color", "red");
		return false;
	} else if (!numberzhengze.test(modifier_mealmoney_1)) {
		$("#modifier_mealmoney_1_msg").html("请输入正整数").css("color", "red");
		return false;
	} else {
		$("#modifier_mealmoney_1_msg").html("通过").css("color", "green");
		return true;
	}

}
function modifier_blur_money_2() {
	var modifier_mealmoney_2 = $("#modifier_mealmoney_2").val();
	if (modifier_mealmoney_2 == '') {

		$("#modifier_mealmoney_2_msg").html("不能为空").css("color", "red");
		return false;
	} else if (!numberzhengze.test(modifier_mealmoney_2)) {
		$("#modifier_mealmoney_2_msg").html("请输入正整数").css("color", "red");
		return false;
	} else {
		$("#modifier_mealmoney_2_msg").html("通过").css("color", "green");
		return true;
	}

}
function modifier_blur_money_3() {
	var modifier_mealmoney_3 = $("#modifier_mealmoney_3").val();
	if (modifier_mealmoney_3 == '') {

		$("#modifier_mealmoney_3_msg").html("不能为空").css("color", "red");
		return false;
	} else if (!numberzhengze.test(modifier_mealmoney_3)) {
		$("#modifier_mealmoney_3_msg").html("请输入正整数").css("color", "red");
		return false;
	} else {
		$("#modifier_mealmoney_3_msg").html("通过").css("color", "green");
		return true;
	}

}

function changemodifier() {
	var flag_modifier_money_1 = modifier_blur_money_1();
	var flag_modifier_money_2 = modifier_blur_money_2();
	var flag_modifier_money_3 = modifier_blur_money_3();

	var charge_mealmoney_1 = $("#modifier_mealmoney_1").val()
	var charge_mealmoney_2 = $("#modifier_mealmoney_2").val()
	var charge_mealmoney_3 = $("#modifier_mealmoney_3").val()

	if (flag_modifier_money_1 != true) {
		alert("请输入正确值");
	} else if (flag_modifier_money_2 != true) {
		alert("请输入正确值");

	} else if (flag_modifier_money_3 != true) {
		alert("请输入正确值");

	} else if (charge_mealmoney_1 == hiddemeal_money1
			&& charge_mealmoney_2 == hiddemeal_money2
			&& charge_mealmoney_3 == hiddemeal_money3) {
		alert("不要提交相同的值");
	} else {
		$.post("paymonth/updatepaymoth.action", {
			"meal_id1" : hiddemeal_id1,
			"meal_id2" : hiddemeal_id2,
			"meal_id3" : hiddemeal_id3,
			"meal_money1" : charge_mealmoney_1,
			"meal_money2" : charge_mealmoney_2,
			"meal_money3" : charge_mealmoney_3
		}, function(data) {
			alert("修改成功");
			search();

		});

	}
}

// 删除
function deletecharge(node) {
	var number = $(node).val();
	var mealid = $("#myShowbody tr").eq(number).find(".hiddemeal_pid").val();

	var mymessage = confirm("请选择，是否删除");
	// alert(JSON.stringify(str));
	if (mymessage == true) {

		$.post("paymonth/deletemealtb.action", {
			"mealid" : mealid
		}, function(data) {
			alert("删除成功");
			search();

		});
	} else if (mymessage == false) {

	}
}