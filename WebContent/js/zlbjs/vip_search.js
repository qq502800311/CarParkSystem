/**
 * 
 */
$(function() {
	search();
});

var chepaizhenze = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/u;
function search() {

	$("#myShowbody").html("");
	// console.log("123");
	// console.log($("#condition_from").serialize());
	$
			.post(
					"car/vipsearch.action",
					$("#condition_from").serialize(),
					function(data) {

						var tablebadyNode = document
								.getElementById("myShowbody");

						var tr = "";
						for (var i = 0; i < data.length; i++) {
							tr += "<tr>";
							tr += "<td>" + (i + 1) + "</td>";
							tr += "<td>" + data[i].car_park_license + "</td>";
							tr += "<td>" + data[i].parameter_tb.parameter_name
									+ "</td>";
							tr += "<td><button class='btn btn-primary' value="
									+ i
									+ " data-toggle='modal' data-target='#myModal2' onclick='setcarcarparklicense(this);' >修改</button>"
									+ "<button class='btn btn-primary' value="
									+ i
									+ "  onclick='deletevipcar(this);' >删除</button>";

							tr += "<input type='hidden' class='hiddecar_park_license'value='"
									+ data[i].car_park_license + "'><td>";
						}
						$("#myShowbody").append(tr);
					});
}
// 点击某个修改 把车牌写入模态框。
// 车牌号
var currentcarparklicense = null;
function setcarcarparklicense(node) {
	var number = $(node).val();

	currentcarparklicense = $("#myShowbody tr").eq(number).find(
			".hiddecar_park_license").val();
	$("#changecar_park_license").text(currentcarparklicense);
	// alert(car_park_license);
}
// 修改模态框检验重名方法
var modiflag = null;
function changemoodife_carvip() {
	modiflag = null;
	var modifiercarparkchangeCarparklicense = $(
			"#modifiercarparkchangeCarparklicense").val();
	if (!chepaizhenze.test(modifiercarparkchangeCarparklicense)) {
		alert("请输入正确车牌");

	} else {

		$
				.post(
						"car/checkmodifcarparklicense.action",
						{
							modifiercarparkchangeCarparklicense : modifiercarparkchangeCarparklicense
						}, function(data) {
							// alert(data);
							if (data == 'yes') {
								modiflag = true;
							} else {
								modiflag = false;
							}

						});
	}
	// $.post("car/checkcarparklicense.action", {
	return modiflag

}
// 白名单车牌修改
function changeCarparklicense() {
	var modifiercarparkchangeCarparklicense = $(
			"#modifiercarparkchangeCarparklicense").val();

	if (!chepaizhenze.test(modifiercarparkchangeCarparklicense)) {
		alert("请输入正确车牌");
	} else if (modifiercarparkchangeCarparklicense == currentcarparklicense) {
		alert("请不要输入相同正品");
	} else {
		if (modiflag == true) {
			$
					.post(
							"car/vipcarmodifier.action",
							{
								currentcarparklicense : currentcarparklicense,
								modifiercarparkchangeCarparklicense : modifiercarparkchangeCarparklicense
							}, function(data) {
								alert("修改完成");
								search();
							});
		} else if (modiflag == false) {
			alert("车牌已存在 请换个车牌");
		} else {
			alert("请输入正确车牌");
		}
	}
}

function deletevipcar(node) {
	var number = $(node).val();
	currentcarparklicense = $("#myShowbody tr").eq(number).find(
			".hiddecar_park_license").val();
	var mymessage = confirm("请三思，是否要删除");
	if (mymessage == true) {
		$.post("car/deletevipcar.action", {
			currentcarparklicense : currentcarparklicense
		}, function(data) {
			alert("删除" + currentcarparklicense + "完成");
			search();
		});
	} else if (mymessage == false) {

	}
}
var flag = null;
function change_carvip() {
	flag = null;
	var newvip_Name = $("#newvip_Name").val();
	if (!chepaizhenze.test(newvip_Name)) {
		alert("请输入正确车牌");

	} else {

		$.post("car/checkcarparklicense.action", {
			newvip_Name : newvip_Name
		}, function(data) {
			if (data == 'yes') {
				flag = true;
			} else {
				flag = false;
			}

		});
	}
	// $.post("car/checkcarparklicense.action", {
	return flag

}

function addVipcar() {
	

	if (flag == true) {

		var newvip_Name = $("#newvip_Name").val();
		$.post("car/addvipcar.action", {
			newvip_Name : newvip_Name
		}, function(data) {
			alert("增加" + newvip_Name + "完成");
			search();
		});

	} else if (flag == false) {
		alert("车牌已存在");
	} else {
		alert("请输入正确车牌");
	}
	$("#newvip_Name").val("");		

}
function settext(){
	$("#newvip_Name").val("");
}

// function useHelp() {
// alert('使用帮助：\n 1、三个选择框都不操作，则默认查询所有数据\n 2、起始卡号都填写则按照卡号进行查询\n 3、选择卡状态则按照卡状态查询\n
// 4、都填写则将按照所有选择条件查询');
// }
