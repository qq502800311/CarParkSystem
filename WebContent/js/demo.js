/**
 * 
 */
$(function(){
	$("a").button();
	$("#div2").draggable({
		start :function(){
			$("#div2").html("拖动开始");
		},
		drag :function(){
			$("#div2").html("拖动进行");
		},
		stop :function(){
			$("#div2").html("拖动结束");
		}
	});
	//以中点判断进入和出界
	$("#div1").droppable({
		activate :function(){
			$("#div1").html("激活");
		},
		out :function(){
			$("#div1").html("移出");
		},
		over :function(){
			$("#div1").html("进入");
		}
	});
	
	$("#myol").sortable();
//	$("#mytab").sortable();
	$("#mytab").draggable();
	$("#div3").dialog({
		autoOpen:false,
		close: function(){
			$("#div1").html("对话框关闭");
		}
	});
	
	$("a").on({
		click :function(){
			$("#div3").dialog("open");
		},
		
	});
		
		
});
