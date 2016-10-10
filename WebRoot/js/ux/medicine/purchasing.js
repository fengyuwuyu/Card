/*声明命名空间*/
$package('YiYa.purchasing');
var  b=false;
/*封装变量（匿名自执行函数）*/
YiYa.purchasing = function(){
	
	var _box = null;
	var _this = {
		config:{
			action:{
  				save:urls['msUrl'] + 'PreOrderDetaiController/save.do',//保存Action  
  				getById:urls['msUrl'] + 'PreOrderDetaiController/getById.do',//查询Action
  				remove:urls['msUrl'] + 'PreOrderDetaiController/delete.do'//删除Action
  			},
  			dataGrid:{
	   			url:urls['msUrl'] + 'PreOrderDetaiController/dataList.do',
	   			idField:'preOrderId1',
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'preOrderId1',hidden:true},
						{field:'userLname',title:'人员名称',align:'left',width:300,sortable:true},
						{field:'phone',title:'电话',align:'center',width:150,sortable:true},
						{field:'cauoz',title:'操作',align:'center',width:150,sortable:true,formatter:function(value,row,index){
							if(row.preType=='0'){
								var html ='<a href=\'#\' onclick=\'addMedcine('+row.preOrderId1+')\'>添加/结算药品</a>';
							}else{
								var html ='<a href=\'#\' onclick=\'checkMedcine('+row.preOrderId1+')\'>查看详细</a>';
							}
							return html;
						}},
						{field:'preType1',title:'状态',align:'center',width:150,sortable:true}
				]],
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

/*页面初始化*/
$(function(){
	YiYa.purchasing.init();
});	


/**
 * 查询出员工信息
 */
function  checkUser(){
	 var  userCard=$("#userCard").val();
	 $.ajax({
		     type:'post',
		     url:urls['msUrl'] + 'PurchaseController/getUserData.do', 
		     async: false,
		     data: {
		    	 cardHao:userCard
		     } ,
		     dataType: "json",
		     success:function(reponse) { 
		    	 if(reponse&&reponse.success){
		    		$("#userLname").val(reponse.map.user_lname);
		    		$("#userSerial").val(reponse.map.user_serial);
		    	 }else{
		    		 YiYa.alert('警告',reponse.msg,'warning');   
		    		 return;
		    	 }
		    }
		});
	}


$.extend($.fn.validatebox.defaults.rules, {    
	checkPhone: {    
        validator: function(value,param){  
        	var isMob=/^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
            return  isMob.test($(param[0]).val());    
        },    
        message: '请输入正确的电话格式.'  
    }    
}); 

function   addMedcine(rowId){
	$("#addMedcinePage").dialog("open").load(urls['msUrl'] +"PreOrderDetaiController/goPage.do?updateId="+rowId);	
}

function   checkMedcine(rowId){
	$("#checkMedcine").dialog("open").load(urls['msUrl'] +"PreOrderDetaiController/checkMedcinePage.do?updateId="+rowId);	
}



function   addMedicineMsg(obj){
	var preOrderId1= $("#updateId").val();
	var rows = $('#addMedcine').datagrid('getRows');
	if(rows.length==0){
		YiYa.alert('警告','请选择需要代购的药品！','warning');  
		return;
	}
	for (var i = 0; i < rows.length; i++) {
		$('#addMedcine').datagrid("endEdit",i);
		var medName= rows[i].medName;
		var quantity= rows[i].quantity;
		var preOrderId=rows[i].preOrderId;
		var price= rows[i].price;
		if(medName==undefined){
			YiYa.alert('警告','请输入需要代购的药品名称！','warning');  
			return;		
		}
		if(quantity==undefined){
			YiYa.alert('警告','请选择需要代购的药品数量！','warning');  
			return;		
		}
		if(price==""){
			price=0;
		}
		
		$.ajax({
		     type:'post',
		     url:urls['msUrl'] + 'PreOrderDetaiController/addMedicineMsg.do', 
		     async: false,
		     data: {
		    	 medName:medName,
		    	 quantity:quantity,
		    	 preOrderId:preOrderId,
		    	 preOrderId1:preOrderId1,
		    	 price:price
		     } ,
		     dataType: "json",
		     success:function(reponse) { 
		    	 if(reponse&&reponse.success){
		    		 b=true;
		    		 if(obj==false){
		    			b=obj; 
		    		 }
		    	 }
		    }
		});
	}
	
	var  userCard=$("#userCard1").val();
	if(userCard==""&&b){
		 YiYa.alert('提示','添加成功！','ok');  
		 $("#addMedcinePage").dialog("close");
	}else{
		var sum=0;
		if(rows.length>0){
			 for(var i=0;i<rows.length;i++){
				 if(rows[i].price==0){
					 YiYa.alert('警告','请输入正确的金额！','warning');  
					 return;
				 }
				 sum+=rows[i].quantity*rows[i].price;
			 } 
			$("#totalAmount").val(sum);  
		  }
		
		var	 totalAmount=$("#totalAmount").val();
		$.ajax({
		     type:'post',
		     url:urls['msUrl'] + 'PreOrderDetaiController/settlement.do', 
		     async: false,
		     data: {
		    	 userCard:userCard,
		    	 totalAmount:totalAmount,
		    	 preOrderId1:preOrderId1
		     } ,
		     dataType: "json",
		     success:function(reponse) { 
		    	 if(reponse&&reponse.success){
		    		// YiYa.alert('提示',reponse.msg,'ok');  
		    		 $("#addMedcinePage").dialog("close");
		    		 $('#data-list').datagrid('reload');
		    		 $("#medicineAmount").dialog("open");
		    		 $("#totalAmount1").val(reponse.totalAmount);
		    		 $("#amount1").val(reponse.amount);
		    	 }else{
		    		 YiYa.alert('警告',reponse.msg,'warning');  
		    		 return;
		    	 }
		    }
		});
	}
	
}

	