
//------计算各产品收入占比--
$(function(){
	$.ajax({
		url: "carport/getProductPre.action",
		contentType : "application/json;charset=utf-8", //如果采用requestbody那么一定要加
		type: "POST",
		dataType: "json",
		data: {"msg":"get"},
		async:false,
		success : function(date){
			var str1 = date.split(":")[0];
			var str2 = date.split(":")[1];
			var str3 = date.split(":")[2];
			var str4 = date.split(":")[3];
			getProductPre(str1,str2,str3,str4);
		}
	});
});


$(function(){
	$.ajax({
		url: "carport/getMonthPre.action",
		contentType : "application/json;charset=utf-8", //如果采用requestbody那么一定要加
		type: "POST",
		dataType: "json",
		data: {"msg":"get"},
		async:false,
		success : function(date){
			var str1 = date.split(":")[0];
			var str2 = date.split(":")[1];
			var str3 = date.split(":")[2];
			var str4 = date.split(":")[3];
			getMonthPre(str1,str2,str3,str4);
		}
	});
});


function getProductPre(str1,str2,str3,str4){	

	var data = [
	        	{name : '临时用户',value : str1,color:'#4572a7'},
	        	{name : '月套餐',value : str2,color:'#aa4643'},
	        	{name : '季套餐',value : str3,color:'#89a54e'},
	        	{name : '半年套餐',value : str4,color:'#80699b'}
        	];

	
	var chart = new iChart.Pie2D({
		render : 'canvasDiv',
		data: data,
		title : {
			text : '2018年4月传一智能停车场收入占比',
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
				.fillText('临时用户\n月套餐办理\n季套餐办理\n半年套餐',w-220,y-40,false,'#be5985',false,20);
			}
	}));
	
	chart.draw();
};






function getMonthPre(str1,str2,str3,str4){
	var data = [
	        	{name : '1月',value : str1,color:'#bc6666'},
	        	{name : '2月',value : str2,color:'#cbab4f'},
	        	{name : '3月',value : str3,color:'#76a871'},
	        	{name : '4月',value : str4,color:'#9f7961'}
        	];
	
	new iChart.Column3D({
		render : 'canvasDiv2',
		data: data,
		title : '2018年传一智能停车场个月收入总额',
		width : 800,
		height : 400,
		align:'left',
		offsetx:50,
		legend : {
			enable : true
		},
		sub_option:{
			label:{
				color:'#111111'
			}
		},
		coordinate:{
			width:600,
			scale:[{
				 position:'left',	
				 start_scale:0,
				 end_scale:40,
				 scale_space:8,
				 listeners:{
					parseText:function(t,x,y){
						return {text:t+"万"}
					}
				}
			}]
		}
	}).draw();
};
