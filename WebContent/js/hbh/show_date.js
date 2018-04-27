
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
			var str5 = date.split(":")[4];
			var str6 = date.split(":")[5];
			var str7 = date.split(":")[6];
			var str8 = date.split(":")[7];
			var str9 = date.split(":")[8];
			var str10 = date.split(":")[9];
			var str11 = date.split(":")[10];
			var str12 = date.split(":")[11];
			
			var fou = date.split(":")[12];
			var fiv = date.split(":")[13];
			var six = date.split(":")[14];
			var sev = date.split(":")[15];
			var eig = date.split(":")[16];
			var nig = date.split(":")[17];
			var tex = date.split(":")[18];
			var elv = date.split(":")[19];
			var tew = date.split(":")[20];
			
			
			getMonthPre(str1,str2,str3,str4);
			parkAndMoney(str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,fou,fiv,six,sev,eig,nig,tex,elv,tew);
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


//-------车流量与明细统计----------
/*$(function(){
	parkAndMoney();
});*/


function parkAndMoney(str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,fou,fiv,six,sev,eig,nig,tex,elv,tew) {
	var data = [
				{name : '1月\n2018',value : 7.4,color : '#c52120'},
				{name : '2月\n2018',value : 6.7,color : '#c52120'},
				{name : '3月\n2018',value : 5.5,color : '#c52120'},
				{name : '4月\n2018',value : fou,color : '#c52120'},
				{name : '5月\n2018',value : fiv,color : '#c52120'},
				{name : '6月\n2018',value : six,color : '#c52120'},
				{name : '7月\n2018',value : sev,color : '#c52120'},
				{name : '8月\n2018',value : eig,color : '#c52120'},
				{name : '9月\n2018',value : nig,color : '#c52120'},
				{name : '10月\n2018',value : tex,color : '#c52120'},
				{name : '11月\n2018',value :elv,color : '#c52120'},
				{name : '12月\n2018',value : tew,color : '#c52120'}
			];
	var data1 = [
		        	{
		        		name : '',
		        		value:[str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12],
		        		color:'#34a1d9',
		        		line_width:5
		        	}
		       ];
       
	var chart = new iChart.Column2D({
		render : 'canvasDiv_DD',
		data : data,
		title:{
			text:'车流量与收入',
			color:'#4572a7',
			textAlign:'left',
			padding:'0 40',
			border:{
				enable:true,
				width:[0,0,4,0],
				color:'#4572a7'
			},
			height:40
		},
		footnote : {
			text : '传一智能停车场',
			height:30,
			color:'#c52120',
			fontweight : 600,
			padding : '0 40'
		},
		width : 800,
		height : 400,
		padding:0,
		label : {
			fontsize:11,
			fontweight:600,
			color : '#666666'
		},
		shadow : true,
		shadow_blur : 2,
		shadow_color : '#aaaaaa',
		shadow_offsetx : 1,
		shadow_offsety : 0,
		background_color : '#f7f7f7',
		column_width : 62,
		sub_option : {
			label : false,
			border : {
				width : 2,
				radius : '5 5 0 0',//上圆角设置
				color : '#ffffff'
			}
		},
		coordinate : {
			background_color : null,
			grid_color : '#c0c0c0',
			width : 680,
			height:220,
			axis : {
				color : '#c0d0e0',
				width : [0, 0, 1, 0]
			},
			scale : [{
				position : 'left',
				start_scale : 0,
				end_scale : 10,
				scale_space : 2,
				scale_enable : false,
				label : {
					fontsize:11,
					fontweight:600,
					color : '#666666'
				}
			},{
				 position:'right',	
				 start_scale:0,
				 scale_space:20,
				 end_scale:100,
				 scale_enable : false,
				 scaleAlign:'right',
				 label:{
					fontsize:11,
					fontweight:600,
					color:'#666666'
				 }
			}]
		}
	});
	//构造折线图
	var line = new iChart.LineBasic2D({
		z_index:1000,
		data: data1,
		label:{
			color:'#4c4f48'
		},
		point_space:chart.get('column_width')+chart.get('column_space'),
		scaleAlign : 'right',
		sub_option : {
			label:false,
			point_size:22
		},
		coordinate:chart.coo//共用坐标系
	});
	
	chart.plugin(line);
	
	
	//利用自定义组件构造左侧说明文本
	chart.plugin(new iChart.Custom({
			drawFn:function(){
				//计算位置
				var coo = chart.getCoordinate(),
					x = coo.get('originx'),
					y = coo.get('originy');
				//在左上侧的位置，渲染一个单位的文字
				chart.target.textAlign('start')
				.textBaseline('bottom')
				.textFont('600 14px Verdana')
				.fillText('车流量统计',x-20,y-20,false,'#c52120')
				.textFont('600 11px Verdana')
				.fillText('千次',x-20,y-10,false,'#c52120');

				//在右上侧的位置，渲染一个单位的文字
				chart.target.textAlign('end')
				.textBaseline('bottom')
				.textFont('600 14px Verdana')
				.fillText('收费支出统计',x+20+coo.width,y-20,false,'#34a1d9')
				.textFont('600 11px Verdana')
				.fillText('万元',x+20+coo.width,y-10,false,'#34a1d9');
				
			}
	}));
	
	chart.draw();
};


















