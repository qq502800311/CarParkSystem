/**
 * 
 */

$(function(){	
	//更换验证码
	$('#codeImg').click(
		function(){
			$('#codeImg').attr("src", "emp/createCode.action?timestamp=" + (new Date()).valueOf());
		}
	); 
	
	
});
