/**
 * 
 */

/*查询套餐详情，插入表格*/
$(function(){
	search_meal_msg();
})

function search_meal_msg(){
	var meal_msg="777";
    str = {"meal_msg":meal_msg};
	$.ajax({
		url: "carport/searchMealMsg.action",
		type: "POST",
		async: true,
		data: str,
		dataType: "json",
		success: function(typelist) {	
			var tableNode = document.getElementById("mytable");
	        var a=1;
			for (var i = 0; i < typelist.length; i++) {
				var trNode = tableNode.insertRow();
				
				for(var j=0;j<4;j++){
					var tdNode = trNode.insertCell();
					switch (j) {
					case 0:
						tdNode.innerHTML = a++;
						break;
					case 1:
						tdNode.innerHTML = typelist[i].meal_name;
						break;
					case 2:
						tdNode.innerHTML = typelist[i].meal_money;
						break;						
					case 3:
						tdNode.innerHTML =typelist[i].meal_detail;
						break;							
					default:
						break;
					}
				}
			}		
		}
	});
}