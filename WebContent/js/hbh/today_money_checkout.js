
/*-----------焦点监听，选择上班时间------*/
function chooseWorkTime(){
	var meal = $("#work_time").val();
	if (meal == '') {
		$("#work_time2").html("请选上班时间").css("color","red");
		return false;	
	}
	else {
		$("#work_time2").html("通过").css("color","green");
		return true;
	}	
}


function seachMoney(){
	var to_money = null;
	var msg = $("#work_time").val();
	if(msg==""){
		alert("请选择班次");
	}else{
	var str = "msg=" + msg;
	$.ajax({
		url: "carport/searchMoney.action",
//		contentType :"application/json;charset=utf-8", //如果采用requestbody那么一定要加
		type: "POST",
		dataType: "json",
		data: str,
		success: function(typelist){
			alert(typelist);
			var tableNode = document.getElementById("mytable");
			var a=1;
			for (var i = 0; i < typelist.length; i++) {
				var trNode = tableNode.insertRow();
				for(var j=0;j<5;j++){
					var tdNode = trNode.insertCell();
					switch (j) {
					case 0:
						tdNode.innerHTML = a++;
						break;
					case 1:
						tdNode.innerHTML = typelist[i].deal_time;
						break;
					case 2:
						tdNode.innerHTML = typelist[i].car_park_license;
						break;						
					case 3:
						tdNode.innerHTML =typelist[i].deal_matter;
						break;	
					case 4:
						tdNode.innerHTML = typelist[i].deal_money;
						break;							
					default:
//						to_money += typelist[i].deal_money;
						break;
					}
				}
			}
		}
	});	
}
}