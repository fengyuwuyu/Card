
//登录
function userLoginClick(basePath) {
	
	var u = $("input[id='userLoginId']").val().trim();
	var p = $("#userPsw").attr("value").trim();
	var i = $("#imageCode").attr("value").trim();
	
	if (u=="" || u==null){
		window.alert('提示：请输入用户名！');
		return false;
	}	
	if (p=="" || p==null){
		window.alert('提示：请输入密码！');
		return false;
	}
	if (i=="" || i==null){
		window.alert('提示：请输入验证码！');
		return false;
	}

	$.ajax({
		url : basePath+"userController/login.do",
		type : "post",
		async: false,
		dataType : "json",
		data : {
			'username' : u,
			'password' : p,
			'code' : i
		},
		success : function(data) {
			if(data.success){				
				window.top.location= basePath + "pages/eval/index/randomCode.jsp";
			}else{
				window.alert('提示：'+data.msg);
			}
		}
	});
}

//处理回车符
function keypress(e){  
	if(e.keyCode==13){ 
		var basePath=getBathPath()+"/"
		userLoginClick(basePath);	
	} 
} 

//更换验证码
function changeImage(basePath){    
	var date=new Date();
	var time=date.getTime();
	$("#image").attr("src",basePath+"userController/createImage.do?time="+time)
}

//去字符串空格
String.prototype.trim = function() {
	return this.replace(/^\s+|\s+$/g, "");
}
