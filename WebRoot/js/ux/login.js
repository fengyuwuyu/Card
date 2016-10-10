/*声明命名空间 */
$package('YiYa.login');

/*封装变量（利用匿名自执行函数）*/
YiYa.login = function(){
	return {
		login:function(){			
			var form = $('#loginForm');
			if(form.form('validate')){
				YiYa.progress('登录中 ... ');
				YiYa.submitForm(form,function(data){
					if(data&&data.success){
					 	window.top.location = urls['msUrl'] + 'main/main.html';
				    }
				});
			}			
		},
		onkeypressListener : function(){
			if (document.addEventListener)  
		    {//如果是Firefox   
		        document.forms[0].addEventListener("keypress", handler, true);   
		    } else {   
		        document.forms[0].attachEvent("onkeypress", handler);   
		    }   
		    function handler(evt)  
		    {   
		        if (evt.keyCode == 13)  
		        {   
		        	YiYa.login.login();   
		        }   
		    }   
		},
		init:function(){
			$('#username').focus();
			$('.button2').click(YiYa.login.login);
			YiYa.login.onkeypressListener();
		}
	}
}();

/*页面初始化*/
$(function(){
	YiYa.login.init();
});		