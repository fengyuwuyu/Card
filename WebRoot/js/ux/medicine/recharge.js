/*声明命名空间*/
$package('YiYa.recharge');

/*封装变量（匿名自执行函数）*/
YiYa.recharge = function(){
	var _box = null;
	var _this = {
		config:{
			action:{
  				save:urls['msUrl'] + 'MedAccountController/save.do',//保存Action  
  				getById:urls['msUrl'] + 'MedAccountController/getById.do',//查询Action
  				remove:urls['msUrl'] + 'MedAccountController/delete.do'//删除Action
  			},
  			dataGrid:{
	   			url:urls['msUrl'] + 'MedAccountController/rechargeList.do',
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'userSerial',hidden:true},
						{field:'userDepname',title:'部门',align:'center',width:150,sortable:true},
						/*{field:'userDuty',title:'职务',align:'center',width:150,sortable:true},*/
						{field:'userLname',title:'员工姓名',align:'left',width:80,sortable:true},
						{field:'userNo',title:'工号',align:'center',width:80,sortable:true},
						/*{field:'sexName',title:'性别',align:'center',width:60,sortable:true},*/
						//{field:'cardNumber',title:'医药账号',align:'center',width:150,sortable:true},
						{field:'amount',title:'账户余额',align:'center',width:100,sortable:true},
						//{field:'accType',title:'特殊用户',align:'center',width:100,sortable:true}
						
				]]
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();


$.extend($.fn.filebox.defaults.rules, {    
    fileupload: {    
        validator: function(value, param){
        	var str=value.substring(value.length-4);
        	return str==".xls";
        },    
        message: '该上传excel文件格式為".xls".'   
    }    
});  



/*页面初始化*/
$(function(){
	YiYa.recharge.init();
	$("#btn-reset").click(function(){
		$('#searchForm').form('reset');
	});
});	
  

function  uploadFile(){
	  $('#uploadForm').form('submit', {    
		    url:urls['msUrl'] + 'MedAccountController/fileUpload.do', 
		    dataType:'json',
		    success:function(reponse){
		    	var ajaxobj = $.parseJSON(reponse);  
		    	if(reponse&&ajaxobj.success){
		    		YiYa.alert('提示',ajaxobj.msg,'ok');  
		    		$("#batchRecharge").dialog("close");
		    	}else{
		    		YiYa.alert('警告',ajaxobj.msg,'warning');  
		    	}
		    }    
		}); 
}





function  openDialog(){
	 $("#updateDialog").dialog("open");
	 var  post=$("#data-list").datagrid("getSelected"); 
	 var amount=post.amount;
	 $("#userMoney").val(amount);
}



/**
 * 转移金额的方法
 */
function changeMoney(){
	var  post=$("#data-list").datagrid("getSelected"); 
	var  cardNumber=post.cardNumber;
	var amount=post.amount;
	var updatemoney=$("#updatemoney").val();
	if(updatemoney>amount){
		YiYa.alert('警告',"转移金额大于账户金额！",'warning');  
		return;
	}
	
	var  post1=$("#dtUser").datagrid("getSelected"); 
	var  cardNumber1=post1.cardNumber;
	$.ajax({
	     type:'post',
	     url:urls['msUrl'] + 'MedAccountController/updateMoney.do', 
	     data: {
	    	 cardNumber2:cardNumber,
	    	 amountMoney:updatemoney,
	    	 cardNumber1:cardNumber1
	     } ,
	     dataType: "json",
	     success:function(reponse) {  
	    	 if(reponse&&reponse.success){
	    		 YiYa.alert('提示',"转移成功！",'ok');
	    		 $("#changeMoney").dialog("close");
	    		 $("#updateDialog").dialog("close");
	    		 $('#data-list').datagrid('reload'); 
	    	 }
	    }
	});
}
	