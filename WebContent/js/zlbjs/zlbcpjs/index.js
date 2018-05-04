window.onload = function() {
	$("#car_name").on("focus", function() {
		var car_name = $("#car_name").val();
		if (car_name == "输入车牌") {
			$("#car_name").val("");
		}
	});
	$(".next_step").on("click", function() {
		var car_name = $("#car_name").val().toUpperCase();
		if (car_name == "输入车牌" || car_name == "") {
			layer.open({
				content : '请输入车牌',
				skin : 'msg',
				time : 2
			});
		} else if (check_car_name(car_name) == false) {
			layer.open({
				content : '请输入正确车牌',
				skin : 'msg',
				time : 2
			});
		} else {

			var formElement = document.forms[0];
			if($("#WIDtotal_amount").val()!=null){
				
				formElement.submit();
			}
		}
	});
}
function changecarname() {

	var car_name = $("#car_name").val();
	alert(car_name);
	if (car_name == "输入车牌" || car_name == "") {
		layer.open({
			content : '请输入车牌',
			skin : 'msg',
			time : 2
		});
	} else if (check_car_name(car_name) == false) {
		layer.open({
			content : '请输入正确车牌',
			skin : 'msg',
			time : 2
		});
	} else {

		var formElement = document.forms[0];
		$.post("car/carfeiyong.action", {
			car_name : encodeURI(car_name),

		}, function(data) {
			if (data == "查无此车停车记录") {
				alert(data);

			} else {
//				alert(data.charge_money)
				$("#WIDtotal_amount").val(data.charge_money);
				alert("停车费用："+data.charge_money+"元   ,停车时间："+data.stop_time+"");
				$("#feiyong").html(data.charge_money+"元   ,停车时间："+data.stop_time+"");
			}

		});

	}

}
function check_car_name(car_name) {
	var re = /^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/;
	if (car_name.search(re) == -1) {
		return false;
	} else {
		return true;
	}
}