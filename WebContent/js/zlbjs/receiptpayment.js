/**
 * 
 */

// var numberzhengze = /0|(^[1-9]+\d*$)/;
// function blur_meal_1() {
// var mealmoney_1 = $("#mealmoney_1").val();
// if (mealmoney_1 == '') {
//
// $("#meal_1_msg").html("不能为空").css("color", "red");
// return false;
// } else if (!numberzhengze.test(mealmoney_1)) {
// $("#meal_1_msg").html("请输入正整数").css("color", "red");
// return false;
// } else {
// $("#meal_1_msg").html("通过").css("color", "green");
// return true;
// }
//
// }
// function blur_meal_2() {
// var mealmoney_2 = $("#mealmoney_2").val();
// if (mealmoney_2 == '') {
//
// $("#meal_2_msg").html("不能为空").css("color", "red");
// return false;
// } else if (!numberzhengze.test(mealmoney_2)) {
// $("#meal_2_msg").html("请输入正整数").css("color", "red");
// return false;
// } else {
// $("#meal_2_msg").html("通过").css("color", "green");
// return true;
// }
//
// }
// function blur_meal_3() {
// var mealmoney_3 = $("#mealmoney_3").val();
// if (mealmoney_3 == '') {
//
// $("#meal_3_msg").html("不能为空").css("color", "red");
// return false;
// } else if (!numberzhengze.test(mealmoney_3)) {
// $("#meal_3_msg").html("请输入正整数").css("color", "red");
// return false;
// } else {
// $("#meal_3_msg").html("通过").css("color", "green");
// return true;
// }
//
// }
//
// function addmeal() {
// var flag_meal_1 = blur_meal_1();
// var flag_meal_2 = blur_meal_2();
// var flag_meal_3 = blur_meal_3();
//
// if (flag_meal_1 != true) {
// alert("请输入正确值");
// } else if (flag_meal_2 != true) {
// alert("请输入正确值");
//
// } else if (flag_meal_3 != true) {
// alert("请输入正确值");
//
// } else {
// var mealmoney_1 = $("#mealmoney_1").val();
// var mealmoney_2 = $("#mealmoney_2").val();
// var mealmoney_3 = $("#mealmoney_3").val();
//
// // alert("提交"+JSON.stringify(saveDataAry););
// $.post("paymonth/addpaymoth.action", $("#addmeal_from").serialize(),
// function(data) {
// search();
//
// });
//
// }
// }
// $(function() {
// search();
// });
var moneynum = null;
function search() {
	$("#myShowbody").html("");
	var starttime_moneydetail = $("#starttime_moneydetail").val();
	var endtime_moneydetail = $("#endtime_moneydetail").val();

	$.post("reciptpay/searchmoneydetail.action", {
		"starttime_moneydetail" : starttime_moneydetail,
		"endtime_moneydetail" : endtime_moneydetail
	},

	function(data) {

		var tablebadyNode = document.getElementById("myShowbody");

		var tr = "";
		alert(data);
		for (var i = 0; i < data.length; i++) {
			tr += "<tr>";
			tr += "<td>" + (i + 1) + "</td>";
			tr += "<td>" + data[i].deal_time + "</td>";
			tr += "<td>" + data[i].deal_matter + "</td>";

			tr += "<td>" + data[i].deal_money + "</td>";
			moneynum += data[i].deal_money;
			// if (data[i].carport_status == '8') {
			// tr += "<td><button class='btn btn-primary' value=" + i
			// + " onclick='initiatemode(this);' >启用</button>";
			// } else {
			// tr += "<td><button class='btn btn-danger' value=" + i
			// + " onclick='initiatemode(this);' >维护</button>";
			// }
			//
			// tr += "<input type='hidden' class='hiddecarport_id'value='"
			// + data[i].carport_id + "'>";
			// tr += "<input type='hidden' class='hiddecarport_status'value='"
			// + data[i].carport_status + "'>";
			// tr += "<input type='hidden' class='hiddecarport_area'value='"
			// + data[i].carport_area + "'><td>";

		}
		$("#myShowbody").append(tr);
		alert("收入="+moneynum);
	});

}

// // 启用 或者禁用状态
// function initiatemode(node) {
//
// var number = $(node).val();
// var meal_status = $("#myShowbody tr").eq(number).find(".hiddemeal_status")
// .val();
// var meal_pid = $("#myShowbody tr").eq(number).find(".hiddemeal_pid").val();
// if (meal_status == '启用') {
// var mymessage = confirm("请选择，是否禁用");
// if (mymessage == true) {
// $.post("paymonth/changestatus.action", {
//
// meal_status : meal_status,
// meal_pid : meal_pid
// }, function(data) {
// alert("123");
// search();
//
// });
// } else if (mymessage == false) {
//
// }
// } else {
//
// var mymessage = confirm("请选择，是否启用");
// if (mymessage == true) {
// $.post("paymonth/changestatus.action", {
//
// meal_status : meal_status,
// meal_pid : meal_pid
// }, function(data) {
// // alert("删除" + currentcarparklicense + "完成");
// search();
// });
// } else if (mymessage == false) {
//
// }
// }
//
// }
// // 设置在修改模态框里面原来的值
// var hiddemeal_id1 = null;
// var hiddemeal_pid1 = null;
// var hiddemeal_name1 = null;
// var hiddemeal_status1 = null;
// var hiddemeal_money1 = null;
//
// var hiddemeal_id2 = null;
// var hiddemeal_pid2 = null;
// var hiddemeal_name2 = null;
// var hiddemeal_status2 = null;
// var hiddemeal_money2 = null;
//
// var hiddemeal_id3 = null;
// var hiddemeal_pid3 = null;
// var hiddemeal_name3 = null;
// var hiddemeal_status3 = null;
// var hiddemeal_money3 = null;
//
// function setmealtext(node) {
// var number = $(node).val();
//
// hiddemeal_id1 = $("#myShowbody tr").eq(number).find(".hiddemeal_id").val();
//
// hiddemeal_pid1 = $("#myShowbody tr").eq(number).find(".hiddemeal_pid")
// .val();
// hiddemeal_name1 = $("#myShowbody tr").eq(number).find(".hiddemeal_name")
// .val();
// hiddemeal_status1 = $("#myShowbody tr").eq(number)
// .find(".hiddemeal_status").val();
// hiddemeal_money1 = $("#myShowbody
// tr").eq(number).next("tr").find(".hiddemeal_money")
// .val();
// hiddemeal_id2 = $("#myShowbody tr").eq(number
// ).next("tr").find(".hiddemeal_id")
// .val();
//
// hiddemeal_pid2 = $("#myShowbody tr").eq(number
// ).next("tr").find(".hiddemeal_pid")
// .val();
// hiddemeal_name2 = $("#myShowbody tr").eq(number ).next("tr")
// .find(".hiddemeal_name").val();
// hiddemeal_status2 = $("#myShowbody tr").eq(number ).next("tr").find(
// ".hiddemeal_status").val();
// hiddemeal_money2 = $("#myShowbody tr").eq(number ).next("tr").find(
// ".hiddemeal_money").val();
//
// hiddemeal_id3 = $("#myShowbody
// tr").eq(number).next("tr").next("tr").find(".hiddemeal_id")
// .val();
// hiddemeal_pid3 = $("#myShowbody
// tr").eq(number).next("tr").next("tr").find(".hiddemeal_pid")
// .val();
// hiddemeal_name3 = $("#myShowbody tr").eq(number ).next("tr").next("tr")
// .find(".hiddemeal_name").val();
// hiddemeal_status3 = $("#myShowbody tr").eq(number
// ).next("tr").next("tr").find(
// ".hiddemeal_status").val();
// hiddemeal_money3 = $("#myShowbody tr").eq(number
// ).next("tr").next("tr").find(
// ".hiddemeal_money").val();
//
// $("#modifier_mealmoney_1").attr("value", hiddemeal_money1);
// $("#modifier_mealmoney_2").attr("value", hiddemeal_money2);
// $("#modifier_mealmoney_3").attr("value", hiddemeal_money3);
//
// }
//
// function modifier_blur_money_1() {
// var modifier_mealmoney_1 = $("#modifier_mealmoney_1").val();
// if (modifier_mealmoney_1 == '') {
//
// $("#modifier_mealmoney_1_msg").html("不能为空").css("color", "red");
// return false;
// } else if (!numberzhengze.test(modifier_mealmoney_1)) {
// $("#modifier_mealmoney_1_msg").html("请输入正整数").css("color", "red");
// return false;
// } else {
// $("#modifier_mealmoney_1_msg").html("通过").css("color", "green");
// return true;
// }
//
// }
// function modifier_blur_money_2() {
// var modifier_mealmoney_2 = $("#modifier_mealmoney_2").val();
// if (modifier_mealmoney_2 == '') {
//
// $("#modifier_mealmoney_2_msg").html("不能为空").css("color", "red");
// return false;
// } else if (!numberzhengze.test(modifier_mealmoney_2)) {
// $("#modifier_mealmoney_2_msg").html("请输入正整数").css("color", "red");
// return false;
// } else {
// $("#modifier_mealmoney_2_msg").html("通过").css("color", "green");
// return true;
// }
//
// }
// function modifier_blur_money_3() {
// var modifier_mealmoney_3 = $("#modifier_mealmoney_3").val();
// if (modifier_mealmoney_3 == '') {
//
// $("#modifier_mealmoney_3_msg").html("不能为空").css("color", "red");
// return false;
// } else if (!numberzhengze.test(modifier_mealmoney_3)) {
// $("#modifier_mealmoney_3_msg").html("请输入正整数").css("color", "red");
// return false;
// } else {
// $("#modifier_mealmoney_3_msg").html("通过").css("color", "green");
// return true;
// }
//
// }
//
// function changemodifier() {
// var flag_modifier_money_1 = modifier_blur_money_1();
// var flag_modifier_money_2 = modifier_blur_money_2();
// var flag_modifier_money_3 = modifier_blur_money_3();
//
// var charge_mealmoney_1 = $("#modifier_mealmoney_1").val()
// var charge_mealmoney_2 = $("#modifier_mealmoney_2").val()
// var charge_mealmoney_3 = $("#modifier_mealmoney_3").val()
//
// if (flag_modifier_money_1 != true) {
// alert("请输入正确值");
// } else if (flag_modifier_money_2 != true) {
// alert("请输入正确值");
//
// } else if (flag_modifier_money_3 != true) {
// alert("请输入正确值");
//
// } else if (charge_mealmoney_1 == hiddemeal_money1
// && charge_mealmoney_2 == hiddemeal_money2
// && charge_mealmoney_3 == hiddemeal_money3) {
// alert("不要提交相同的值");
// } else {
// $.post("paymonth/updatepaymoth.action", {
// "meal_id1" : hiddemeal_id1,
// "meal_id2" : hiddemeal_id2,
// "meal_id3" : hiddemeal_id3,
// "meal_money1" : charge_mealmoney_1,
// "meal_money2" : charge_mealmoney_2,
// "meal_money3" : charge_mealmoney_3
// }, function(data) {
// alert("修改成功");
// search();
//
// });
//
// }
// }
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
