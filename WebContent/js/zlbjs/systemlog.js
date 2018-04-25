/**
 * 
 */


 $(function() {
 search();
 });
var moneynum = null;
function search() {
	var msg = $('#systemlog_from').serialize() + "&pageNum=" + "1";	
//    alert(msg);
	$("#myShowbody").html("");
	

	$.post("systemlog/searchsyslog.action",msg,

	function(data) {
		var list = data.list;
		var tablebadyNode = document.getElementById("myShowbody");

		var tr = "";
	
		for (var i = 0; i < list.length; i++) {
			tr += "<tr>";
			tr += "<td>" + (i + 1) + "</td>";
			tr += "<td>" + list[i].log_time + "</td>";
			tr += "<td>" + list[i].emp_id + "</td>";

			tr += "<td>" + list[i].emptb.emp_name + "</td>";
			tr += "<td>" + list[i].log_even+ "</td>";
		
			

		}
		$("#myShowbody").append(tr);
		//记录分页信息
		document.getElementById("pages").innerHTML = data.pages;	//总页数
		document.getElementById("total").innerHTML = data.total;	//查询总数
		
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
	});

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
		$("#myShowbody").html("");
		var msg = $('#systemlog_from').serialize() + "&pageNum=" + nextpageNum;
		
		$.post("systemlog/searchsyslog.action",msg,

				function(data) {
					var list = data.list;
					var tablebadyNode = document.getElementById("myShowbody");

					var tr = "";
				
					for (var i = 0; i < list.length; i++) {
						tr += "<tr>";
						tr += "<td>" + (i + 1) + "</td>";
						tr += "<td>" + list[i].log_time + "</td>";
						tr += "<td>" + list[i].emp_id + "</td>";

						tr += "<td>" + list[i].emptb.emp_name + "</td>";
						tr += "<td>" + list[i].log_even+ "</td>";
					}
					$("#myShowbody").append(tr);
					
					//赋值新页数
					document.getElementById("pageNum").text = nextpageNum;
					
					//按钮操作（只改变颜色，不会禁用）
					if(nextpageNum == pages){	// 当前页数 = 总页数 时
						document.getElementById("nextPage").style = "color: red";
					}else{
						document.getElementById("nextPage").style = "";
					}
					
					document.getElementById("lastPage").style = ""; //恢复上一页颜色
					
		});
		
		
		
		
		
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
		var msg = $('#searchMenuForm').serialize() + "&pageNum=" + nextpageNum;
		
		$("#myShowbody").html("");
	
		
		$.post("systemlog/searchsyslog.action",msg,
				
				function(data) {
					var list = data.list;
					var tablebadyNode = document.getElementById("myShowbody");

					var tr = "";
				
					for (var i = 0; i < list.length; i++) {
						tr += "<tr>";
						tr += "<td>" + (i + 1) + "</td>";
						tr += "<td>" + list[i].log_time + "</td>";
						tr += "<td>" + list[i].emp_id + "</td>";

						tr += "<td>" + list[i].emptb.emp_name + "</td>";
						tr += "<td>" + list[i].log_even+ "</td>";
					}
					$("#myShowbody").append(tr);
					//赋值新页数
					document.getElementById("pageNum").text = nextpageNum;
					
					//按钮操作（只改变颜色，不会禁用）
					if(nextpageNum == 1){	// 当前页数 = 1 时
						document.getElementById("lastPage").style = "color: red";
					}else{
						document.getElementById("lastPage").style = "";
					}
					
					document.getElementById("nextPage").style = ""; //恢复下一页颜色
					
		});
	}
}

