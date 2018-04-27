

$(function(){
	search();
});

//支付方式统计
function search(){
	var meth = $("#meth").val();
	var startDate = $("#startDate").val();
	var stopDate = $("#stopDate").val();
	var weichat = 0;
	var alipay = 0;
	var cash = 0;
	
	var msg = $('#searchMenuForm').serialize()+"&pageNum=" + "1"+"&meth=" +meth+"&startDate="+startDate+"&stopDate="+stopDate;
	$.ajax({
		url: "carport/chargeMeth.action",
//		contentType : "application/json;charset=utf-8",  //如果采用requestbody那么一定要加
		type:"POST",
		data: msg,
		dataType:"json",
		async:true,	
		success: function(date){
			$("#mytable tr:not(:first)").html("");
			var typelist = date.list;
			var tableNode = document.getElementById("mytable");
			var a = 1;
//			var tabNode = document.getElementById("DataTables_Table_0");
			for (var i = 0; i < typelist.length; i++) {
				var trNode = tableNode.insertRow();
				for(var j=0;j<6;j++){
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
						if(typelist[i].deal_method=="现金"){
							cash += typelist[i].deal_money;
						}else if(typelist[i].deal_method=="微信"){
							weichat += typelist[i].deal_money;
						}else if(typelist[i].deal_method=="支付宝"){
							alipay += typelist[i].deal_money;
						}
						
						break;
					case 5:
						tdNode.innerHTML = typelist[i].deal_method;
						break;	
					default:
						break;
					}
				}
			}
			
			$("#cash").html(cash);
			$("#weichat").html(weichat);
			$("#alipay").html(alipay);
			
			//---------饼状图显示页面----------
			var total = cash+weichat+alipay;
			var str1 = cash/total*100;
			var str2 = weichat/total*100;
			var str3 = alipay/total*100;
//			alert(str1);
//			alert(str2);
//			alert(str3);
			getProductPre(str1,str2,str3);
		
			//记录分页信息
			document.getElementById("pages").innerHTML = date.pages;	//总页数
			document.getElementById("total").innerHTML = date.total;	//查询总数
			
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
		}
	})
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
		var msg = $('#searchMenuForm').serialize() + "&pageNum="+ nextpageNum+"&meth="+"&startDate="+"&stopDate=";
		$.ajax({
			url: "carport/chargeMeth.action",
//			contentType : "application/json;charset=utf-8",  //如果采用requestbody那么一定要加
			type: "POST",
			dataType: "json",
			data: msg,
			success: function(date){
				
				$("#mytable tr:not(:first)").html("");
				var typelist = date.list;
				var tableNode = document.getElementById("mytable");
				var a = 1;
				for (var i = 0; i < typelist.length; i++) {
					var trNode = tableNode.insertRow();
					for(var j=0;j<6;j++){
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
						case 5:
							tdNode.innerHTML = typelist[i].deal_method;
							break;	
						default:
							break;
						}
					}
				}
				//赋值新页数
				document.getElementById("pageNum").text = nextpageNum;
				
				//按钮操作（只改变颜色，不会禁用）
				if(nextpageNum == 1){	// 当前页数 = 1 时
					document.getElementById("lastPage").style = "color: red";
				}else{
					document.getElementById("lastPage").style = "";
				}
				
				document.getElementById("nextPage").style = ""; //恢复下一页颜色
			}
		})
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
		var msg = $('#searchMenuForm').serialize()+"&pageNum="+nextpageNum+"&meth="+"&startDate="+"&stopDate=";
		$.ajax({
			url: "carport/chargeMeth.action",
//			contentType : "application/json;charset=utf-8",  //如果采用requestbody那么一定要加
			type: "POST",
			dataType: "json",
			data: msg,
			success: function(date){
				$("#mytable tr:not(:first)").html("");
				var typelist = date.list;
				var tableNode = document.getElementById("mytable");
				var a = 1;
				for (var i = 0; i < typelist.length; i++) {
					var trNode = tableNode.insertRow();
					for(var j=0;j<6;j++){
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
						case 5:
							tdNode.innerHTML = typelist[i].deal_method;
							break;	
						default:
							break;
						}
					}
				}
				//赋值新页数
				document.getElementById("pageNum").text = nextpageNum;
				
				//按钮操作（只改变颜色，不会禁用）
				if(nextpageNum == 1){	// 当前页数 = 1 时
					document.getElementById("lastPage").style = "color: red";
				}else{
					document.getElementById("lastPage").style = "";
				}
				
				document.getElementById("nextPage").style = ""; //恢复下一页颜色
			}
		})
	}
}


function getProductPre(str1,str2,str3){	

	var data = [
	        	{name : '现金支付',value : str1,color:'#4572a7'},
	        	{name : '微信支付',value : str2,color:'#aa4643'},
	        	{name : '支付宝支付',value : str3,color:'#89a54e'}
        	];

	
	var chart = new iChart.Pie2D({
		render : 'canvas_charge_meth',
		data: data,
		title : {
			text : '传一智能停车场缴费方式收入占比',
			color : '#3e576f'
		},
		footnote : {
			text : '传一智能停车场',
			color : '#486c8f',
			fontsize : 11,
			padding : '0 38'
		},
		sub_option : {
			label : {
				background_color:null,
				sign:false,//设置禁用label的小图标
				padding:'0 4',
				border:{
					enable:false,
					color:'#666666'
				},
				fontsize:11,
				fontweight:600,
				color : '#4572a7'
			},
			border : {
				width : 2,
				color : '#ffffff'
			}
		},
		shadow : true,
		shadow_blur : 6,
		shadow_color : '#aaaaaa',
		shadow_offsetx : 0,
		shadow_offsety : 0,
		background_color:'#fefefe',
		offsetx:-60,//设置向x轴负方向偏移位置60px
		offset_angle:-120,//逆时针偏移120度
		showpercent:true,
		decimalsnum:2,
		width : 800,
		height : 400,
		radius:120
	});
	//利用自定义组件构造右侧说明文本
	chart.plugin(new iChart.Custom({
			drawFn:function(){
				//计算位置
				var y = chart.get('originy'),
					w = chart.get('width');
				
				//在右侧的位置，渲染说明文字
				chart.target.textAlign('start')
				.textBaseline('middle')
				.textFont('600 16px Verdana')
				.fillText('现金支付\n微信支付\n支付宝支付',w-220,y-40,false,'#be5985',false,20);
			}
	}));
	
	chart.draw();
};




