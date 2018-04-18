

/*查看车位使用情况，使用中车位，剩余车位*/
function check_port_msg(){
	alert("查看车位使用信息");
		var check_msg="666";
	    str = {"check_msg":check_msg};
		$.ajax({
			url: "carport/checkParkMsg.action",
			type: "POST",
			async: true,
			data: str,
			dataType: "json",
			success: function(info) {
				$("#using_port").html(info.carport_using_num);
				$("#remain_port").html(info.carport_remain_num);
			}
		});
		
}