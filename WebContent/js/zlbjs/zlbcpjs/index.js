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
			    //提交表单，提交到action属性指定的地方
			    formElement.submit();
		}
	});
}

function check_car_name(car_name) {
	var re = /^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/;
	if (car_name.search(re) == -1) {
		return false;
	} else {
		return true;
	}
}