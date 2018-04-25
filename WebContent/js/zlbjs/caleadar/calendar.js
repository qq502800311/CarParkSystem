function seleceemplist() {
	$("#external-events").html("");
	$
			.post(
					"calendar/searchemplist.action",
					$("#condition_from").serialize(),
					function(data) {

						var tablebadyNode = document
								.getElementById("myShowbody");

						var div = "<h4>早班</h4>";

						for (var i = 0; i < data.length; i++) {
							div += "<div class='fc-event' id='data[i].emp_id' sc_class='早班'>"
									+ data[i].emp_name + "</div>";

						}
						div+="<h4>午班</h4>";
						
						for (var i = 0; i < data.length; i++) {
							div += "<div class='fc-event' id='data[i].emp_id' sc_class='午班'>"
								+ data[i].emp_name + "</div>";
							
						}
						div+="<h4>晚班</h4>";
						for (var i = 0; i < data.length; i++) {
							div += "<div class='fc-event' id='data[i].emp_id' sc_class='晚班'>"
								+ data[i].emp_name + "</div>";
							
						}
						$("#external-events").append(div);
					});
}
$(function() {
//	seleceemplist();
})

$(document).ready(
		function() {
			/*
			 * initialize the external
			 * events-----------------------------------------------------------------
			 */
			$('#external-events .fc-event').each(function() {
				// store data so the calendar knows to render an event upon drop
				$(this).data('event', {
					title : $.trim($(this).text()), // use the element's text as
													// the event title
					sid : this.getAttribute("id"),
					uid : this.getAttribute("dpt"),
					stick : true
				// maintain when user navigates (see docs on the renderEvent
				// method)
				});
				// make the event draggable using jQuery UI
				$(this).draggable({
					zIndex : 999,
					revert : true, // will cause the event to go back to its
					revertDuration : 0
				// original position after the drag
				});
			});
			/*
			 * initialize the
			 * calendar-----------------------------------------------------------------
			 */

			$('#calendar').fullCalendar(
					{
						header : {
							left : 'prev,next today',
							center : 'title',
							right : 'month,agendaWeek,agendaDay'
						},
						buttonText : {
							today : '今天',
							month : '月',
							week : '周',
							day : '天'
						},
						allDayText : '全天',
						monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月',
								'七月', '八月', '九月', '十月', '十一月', '十二月' ],
						monthNamesShort : [ '1', '2', '3', '4', '5', '6', '7',
								'8', '9', '10', '11', '12' ],
						dayNames : [ '星期日', '星期一', '星期二', '星期三', '星期四', '星期五',
								'星期六' ],
						dayNamesShort : [ '周日', '周一', '周二', '周三', '周四', '周五',
								'周六' ],
						editable : false,
						droppable : true, // this allows things to be dropped
											// onto the calendar
						drop : function(date, allDay, jsEvent) {
							// is the "remove after drop" checkbox checked?
							var a = this.getAttribute("sc_class");
							var id = this.id;
							var sc_class = this.getAttribute("sc_class");
							var date1 = date._i;// 1970至今的毫秒数
							$.ajax({
								url : "calendar/addWork.action",
								type : "POST", // 请求方式
								dataType : "json",
								async : true,// 请求是否异步，默认为异步，这也是ajax重要特性
								data : {
									"emp_id" : id,
									"sc_class" : sc_class,
									"date" : date1
								}, // 参数值
								success : function(req) {
									alert(req);
									location.reload();
								},
								error : function() {
									// 请求出错处理
									alert("请求出错！");
								}
							});
						},
						events : [ {
							id : 999,
							title : '陈医生上班',
							start : "03 06 2018 16:00",
							allDay : false
						} ],
						events : function(start, end, timezone, callback) {// 生成日历
																			// //alert(calendar.fullCalendar('getDate'));
							$.ajax({
								'url' : "calendar/querycalendar.action",
								'data' : {
									111 : "111"
								},
								'dataType' : 'json',
								'type' : 'post',
								'error' : function(data) {
									alert("保存失败");
									return false;
								},
								'success' : function(msg) {
									
									var events = [];
									var event = msg;
//									alert(event);
									var name = "";
									for (var i = 0; i < event.length; i++) {
										if (event[i].schedule_shift == "早班") {
											name = event[i].empTb.emp_name + "(早)";
										}else if(event[i].schedule_shift == "午班"){
											name = event[i].empTb.emp_name + "(午)";
										}else {
											name = event[i].empTb.emp_name + "(晚)";
										}
									
										events.push({
											sid : event[i].schedule_id,
											title : name,
											start : event[i].schedule_date,
											allDay : true,
											id : event[i].emp_id
										});
									}
									callback(events);//
								}
							});
						},
						eventClick : function(event) {// 单机日历内已有事件
							alert("删除" + event.title + "的排班？");
							$('#myModal').modal('show');
							$('#scid').val(event.sid);
						}
					});
		});
function sc_delete() {
	var scid = $('#scid').val();
	$.ajax({
		url : "calendar/delete.action",
		type : "POST", // 请求方式
		dataType : "html",
		async : true,// 请求是否异步，默认为异步，这也是ajax重要特性
		data : {
			scid : scid
		}, // 参数值
		success : function(req) {
			alert(req);
			location.reload();
		},
		error : function() {
			// 请求出错处理
			alert("请求出错！");
		}
	});
}
