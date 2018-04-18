
/*查找数据库月缴费用户*/
function searchUser(){
	$("#mytable").html("");
	var user_id = $("#userid").val();
	var license = $("#license").val();
	var str = '{"user_id":"'+user_id+'","car_park_license":"'+license+'"}';
		$.ajax({
			url: "carport/searchUser.action",
			contentType : "application/json;charset=utf-8",  //如果采用requestbody那么一定要加
			type: "POST",
			dataType: "json",
			data: str,
			success: function(typelist){
				var tableNode = document.getElementById("mytable");
		
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
			}
		});	
};

/*界面显示退款信息*/
function moneyback(node){
	var nowtime = getNowFormatDate();
	var trNode = node.parentNode.parentNode;
	var rows = trNode.cells;
    for(var i=0;i<rows.length;i++)
    {
    	start_date  = rows[5].innerHTML     /*账号启用时间 .substr(0,10); */
    	stop_date  =rows[6].innerHTML;      /*账号结束时间*/
    	money = rows[7].innerHTML;          /* 充值金额*/
    	userid = rows[1].innerHTML;         /* 用户id*/
    	lisence = rows[2].innerHTML;
    } 	
    //----信息显示----
    $("#now_date").html(nowtime);
    $("#start_date").html(start_date);
    $("#stop_date").html(stop_date);
    //----余额计算----
    var stop = stop_date.substr(0,10);
    var now  = nowtime.substr(0,10);
    var start = start_date.substr(0,10);
    var total = dateNumber(stop,start);        //套餐总天数
    var single = Math.ceil(money/total);       //算出每日单价
    var date = dateNumber(stop,now);           //剩余天数
    var remain_money = parseInt(single*date);  //剩余金额
    
    var back_money = parseInt(remain_money*0.7);       //退款金额，剩余金额的70%
    $("#remain_date").html(date);
    $("#remain_money").html(remain_money); 
    $("#re_money").html(back_money);
    $("#userid_hidden").html(userid);          //用户id，用于隐藏标签
    $("#license_hidden").html(lisence);          //车牌，用于隐藏标签
    
    openBackMoney();
    
}

//获取系统当前时间
function getNowFormatDate() {  
    var date = new Date();  
    var seperator1 = "-";  
    var seperator2 = ":";  
    var year = date.getFullYear();  
    var month = date.getMonth() + 1;  
    var strDate = date.getDate();  
    if (month >= 1 && month <= 9) {  
        month = "0" + month;  
    }  
    if (strDate >= 0 && strDate <= 9) {  
        strDate = "0" + strDate;  
    }  
    var currentdate = year + seperator1 + month + seperator1 + strDate  
            + " " + date.getHours() + seperator2 + date.getMinutes()  
            + seperator2 + date.getSeconds();  
    return currentdate;  
} 

/*打开隐藏的退款金额div*/
function openBackMoney(){
	document.getElementById('back_money').style.display='block';
	document.getElementById('fade').style.display='block';
}

function closeBackMoney(){
	document.getElementById('back_money').style.display='none';
	document.getElementById('fade').style.display='none';	
}

/*打开、关闭充值div*/
function openRecharge(){
	document.getElementById('recharge_money').style.display='block';
	document.getElementById('fade').style.display='block';
}

function closeRecharge(){
	document.getElementById('recharge_money').style.display='none';
	document.getElementById('fade').style.display='none';	
}

/*计算两个时间差*/
function dateNumber(stop_date,now_date){        
	strDate1=stop_date.replace(/-/g,"/"); 
	strDate2=now_date.replace(/-/g,"/"); 
	var date1 = Date.parse(strDate1); 
	var date2 = Date.parse(strDate2); 
	var date = Math.ceil((date1-date2)/(24*60*60*1000));
	return date;
}

/*--------确认退款-------*/
function returnSure(){
	if(confirm('确认退款了？')){
		var user_id = $("#userid_hidden").html();   //退款用户
		var now_date = $("#now_date").html();        //退款日期
		var charge_money = $("#re_money").html();    //退款金额
		var car_park_license = $("#license_hidden").html();                 //车牌号
		var str = '{"car_park_license":"'+car_park_license+'","meal_id":"'+charge_money+'","user_id":"'+user_id+'"}';
		$.ajax({
			url: "carport/returnMoney.action",
			contentType : "application/json;charset=utf-8", //如果采用requestbody那么一定要加
			type: "POST",
			dataType: "json",
			data: str,
			success: function(date){
				$("#mytable").html("");
				closeBackMoney();
				alert(date);
				
			}
		});	
	}	
}

/*界面充值用户信息*/
function recharge_open(node){
	var trNode = node.parentNode.parentNode;
	var rows = trNode.cells;
    for(var i=0;i<rows.length;i++)
    {
    	user_name  = rows[0].innerHTML       /*当前用户*/
    	user_id    = rows[1].innerHTML;      /*用户id*/
    	license    = rows[2].innerHTML;      /*充值金额*/
    } 	
    //------jsp信息显示------
    $("#recharge_name").html(user_name);
    $("#recharge_id").html(user_id);
    $("#recharge_license").html(license);
    openRecharge();
}

/*选择套餐焦点监听*/
function selectMeal(){
	var meal = $("#selectMeal").val();
	if (meal == '') {
		$("#meal2").html("请选择套餐").css("color","red");
		return false;	
	}
	else {
		$("#meal2").html("通过").css("color","green");
		return true;
	}	
}


/*用户充值金额*/
function recharge(){
	var meal_id = $("#selectMeal option:selected").val();
	if(meal_id==""){
		alert("请选择套餐");
	}else{
	
	if(confirm('确认充值？')){
		var car_park_license = $("#recharge_license").html(); //退款用户
		
		var str = '{"car_park_license":"'+car_park_license+'","meal_id":"'+meal_id+'"}';
		$.ajax({
			url: "carport/rehchargeMoney.action",
			contentType : "application/json;charset=utf-8", //如果采用requestbody那么一定要加
			type: "POST",
			dataType: "json",
			data: str,
			success: function(date){
				
				$("#mytable").html("");
				closeRecharge();
				alert(date);
				
			}
		});	
	}	
}
}






