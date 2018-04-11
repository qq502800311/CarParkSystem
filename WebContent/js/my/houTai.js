
$(function() {//此处方法为全部加载完成，能保证全部ID、标签等都能找到
//	sub() ;
//	alert("欢迎登录！如需退出，必须先注销用户，否则无法再次登录！");
//	getUserNameAndId();
})


//从页面获取当前登录的用户名和用户ID，全局变量

var userID;
var userName;

//从页面获取当前登录的用户名和用户ID
function getUserNameAndId(){
	var userIDNode = document.getElementById("userID");
	var userNameNode = document.getElementById("userName");
	userID = userIDNode.innerText.trim();
	userName = userNameNode.innerText.trim();
}

//二级菜单部分
function myClick1(node){
	var bigDivNode = document.getElementById("bigDiv");
	var divArr = bigDivNode.getElementsByTagName("div");//获取大Div下的所有子div集合
	var tdNode = node.parentNode;
	var arr = tdNode.getElementsByTagName("div");//获取当前点击的div元素
	var divNode = arr[0];
	for (var i = 0; i < divArr.length; i++) {
		if (arr[0] == divArr[i]) {
			divNode.style.display = "block";
		}else{
			divArr[i].style.display = "none";
		}
	}
}

//切换iframe部分
function turnIf1(a){
	/**************/
	var ifNode = document.getElementById("if1");
	ifNode.setAttribute("src",""+a);
}
//更改密码函数
function changeEmpPsw() {
//	alert('更改密码函数触发');
	var ht_user_OldPsw = document.getElementById("ht_user_OldPsw").value;
	var ht_user_NewPsw1 = document.getElementById("ht_user_NewPsw1").value;
	var ht_user_NewPsw2 = document.getElementById("ht_user_NewPsw2").value;
	
//	alert('原来的密码为：'+ht_user_OldPsw);
//	alert('新的密码1为：'+ht_user_NewPsw1);
//	alert('新的密码2为：'+ht_user_NewPsw2);
//	alert('进行操作的用户ID为：'+userID);
	
	$.ajax({
		type:"POST",
		url:"Emp_Servlet?action=changePsw",
		data:"ht_user_OldPsw=" + ht_user_OldPsw + 
				"&ht_user_NewPsw1=" + ht_user_NewPsw1 + 
				"&ht_user_NewPsw2=" + ht_user_NewPsw2 +
				"&userID=" + userID,
		dataType:"text",
		async:true,	
		success: function(msg){
			if(msg.trim() == 'true') {
		        //result就是servlet返回的数据
		        alert("修改密码成功");
		    }else{
		    	 alert("修改密码失败");
		    }

					
		}
	});
}

//用户下线注销函数
function empOffline() {
//	alert('注销函数触发');
	
//	alert('进行操作的用户ID为：'+userID);
	
	$.ajax({
		type:"POST",
		url:"Emp_Servlet?action=Offline",
		data:"userID=" + userID,
		dataType:"text",
		async:true,	
		success: function(msg){
			if(msg.trim() == 'true') {
		        //result就是servlet返回的数据
		        alert("用户下线注销成功");
		        logout();
		    }else{
		    	 alert("用户下线注销失败");
		    }

					
		}
	});
}

//关闭当前页面函数
function closeWin() {
	  window.opener=null;
	  window.open('','_self');
	  window.close();
	}
//关闭当前页面函数
function custom_close(){
	if 
	(confirm("您确定要关闭本页吗？")){
	window.opener=null;
	window.open('','_self');
	window.close();
	}
	else{}
	}

function logout() {
	if (confirm("你确定要注销身份吗？是－选择确定，否-选择取消")) {
		window.location.replace('http://localhost:9090/ThreeClassSystem3/home.jsp');
//		window.history.forward(1);  
//		window.location.href = "http://localhost:8080/CardOnlineSystem/jsp/Login_Admin.jsp";
//		window.history.forward(1);  
	}
//	window.onclose
}





