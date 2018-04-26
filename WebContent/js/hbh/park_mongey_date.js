		$(function() {
			var data = [
						{name : 'MAY\n2018',value : 0.4,color : '#c52120'},
						{name : 'JUN\n2018',value : 10,color : '#c52120'},
						{name : 'JUL\n2018',value : 1,color : '#c52120'},
						{name : 'AUG\n2018',value : 1.2,color : '#c52120'},
						{name : 'SEP\n2018',value : 2,color : '#c52120'},
						{name : 'OCT\n2018',value : 3.2,color : '#c52120'},
						{name : 'NOV\n2018',value : 4.8,color : '#c52120'},
						{name : 'DEC\n2018',value : 7.8,color : '#c52120'},
						{name : 'JAN\n2018',value : 11.8,color : '#c52120'}
					];
			var data1 = [
				        	{
				        		name : '',
				        		value:[16,20,100,52,92,81,88,78,96],
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
						end_scale : 12,
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
						 end_scale:120,
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
		});
