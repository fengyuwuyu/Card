/*声明命名空间*/
var arr = new Array();
var arr1 = new Array();
$(function(){
	$("#userCard").focus();
    $('#data-list').datagrid({
    			title: '药品信息',
    			//url:urls['msUrl'] + 'InventoryController/getNum.do',
			    iconCls:"icon-window",
			    collapsible: true,
			    minimizable: true,
			    maximizable: true,
			    resizable: true,
			    modal: true,
			    singleSelect:false,
			    width:1100,
				height:365,
				columns:[[
					{field:'ck',checkbox:true},
					{field:'medicineId',hidden:true},
					{field:'medicineName',title:'药品名称',align:'left',width:150,sortable:true},
					{field:'price',title:'药品价格',align:'center',width:60,sortable:true},
					{field:'quantity',title:'数量',align:'center',width:100,sortable:true,editor:{type:'numberbox1',options:{required:true}}},
					{field:'xiaoji',title:'小计',align:'center',width:100,sortable:true}
				]],
				toolbar: ["-", {
		            id: '',
		            text: '结算',
		            iconCls:'icon-yes',
					btnType:'add',
		            handler: function () {
		            	var rows = $('#data-list').datagrid('getRows');
		            	if(rows.length==0){
		            		 YiYa.alert('警告','请选择购买药品！','warning');  
		            		 return;	
		            	}
		            	var userLname= $("#userLname").val();
		            	if(userLname==""){
		            		 YiYa.alert('警告','请选择购买药品的员工！','warning');  
		            		 return;	
		            	}
		            	/**
		            	 *扣除员工消费
		            	 */
		            	var  userSerial=$("#userSerial").val();
		            	var totalAmount=$("#totalAmount").val();
		            	var amount=$("#amount").val();
		            	var  accType1= $("#accType1").val();
		            	if(accType1!='1'){
			            	if( parseFloat(amount)<parseFloat(totalAmount)){
			            		//$("#accountMoneyMsg").val(amount);
			            		$("#accountMoneyMsg").append("<b  id='addText1' style='font-size:18px;'>"+amount+"</b>");
			            		$("#accountMoney").dialog("open");
			            		return;
				           	}
		            	}
		            	
		            	var medIds="" ;
		            	var quantitys="";
		            	  for(var i=0;i<rows.length;i++){
		            		  medIds+=rows[i].medicineId+",";
		            		  quantitys+=rows[i].quantity+",";
					      }
		            	  $.ajax({
			   			     type:'post',
			   			     url:urls['msUrl'] + 'PurchaseController/addPurchaseForm.do', 
			   			     data: {
			   			    	userSerial:userSerial,
			   			    	accType1:accType1,
			   			    	totalAmount:totalAmount,
			   			    	medIds:medIds,
			   			    	quantitys:quantitys
			   			     } ,
			   			     dataType: "json",
			   			     success:function(reponse) { 
			   			    	 if(reponse&&reponse.success){
			   			    		$("#medicine").dialog("open");
			   			    		$("#totalAmount111").append("<b   id='addText2' style='font-size:18px;'>"+totalAmount+"</b>");
			   			    		$("#accountMoney11").append("<b   id='addText3'  style='font-size:18px;'>"+reponse.amount+"</b>");
			   			    	  }else{
			   			    		 YiYa.alert('警告',reponse.msg,'warning');  
				            		 return;  
			   			    	  }
			   			     }
			   			});	
		            }
		        }, "-", {
		            id: '',
		            text:'提现结算',
					iconCls:'icon-yes',
					btnType:'add',
		            handler: function () {
		            	$("#tiXian").dialog("open");
		            	$('#settlementForm').form('reset');
		            }
		        } ,"-", {
		            id: '',
		            text:'删除',
					iconCls:'icon-remove',
					btnType:'remove',
		            handler: function () {
		            	 var rows = $('#data-list').datagrid('getSelections');
		            	 if( rows.length==0){
		            		 YiYa.alert('警告','未选中记录！','warning');  
		            		 return;
							}
		                for (var i = 0; i < rows.length; i++) {
		                	var index=$('#data-list').datagrid('getRowIndex',rows[i]); 
		                	for (var j = 0; j < arr.length; j++) {  
		                        if (arr[j] == rows[i].medicineId) {  
		                        	  var de = arr.indexOf(rows[i].medicineId);  
		                        	  if (de > -1) {  
		                        	        arr.splice(de, 1);  
		                        	    } 
		                        }  
		                    }  
		                	$('#data-list').datagrid("deleteRow",index);
		                	
		                }
		                totalAmount();
		            }
		        }],
				onClickCell:function(rowIndex, field, value){
					var rows = $('#data-list').datagrid('getRows');
					if(rows.length>0){
						for (var i = 0; i < rows.length; i++) {
							var index=$('#data-list').datagrid('getRowIndex',rows[i]); 
							if(rowIndex!=index){
								$('#data-list').datagrid("endEdit",index);
							}
		                }
					}
					 $('#data-list').datagrid("beginEdit",rowIndex);
					 $("#rowIndex").val(rowIndex);
	   			}
    });	
    
	  $('#medicine').dialog({  
	        closable:false  
	   });  
	  
	  $('#accountMoney').dialog({  
	        closable:false  
	   });
    
});
/**
 * 判断是否包含数组中
 */
function contains(a,obj){
	var i=a.length;
	while(i--){
		if(a[i]==obj){
			return true;
		}
	}
	return false;
}



/**
 * 选取药品名称
 */
function  checkMedicine(){
	$("#medicineMsg").dialog("open").load(urls['msUrl'] +"InventoryController/goPage.do?status=1");
}

/**
 * 获取药品条形码和id
 */
function  addMedicine(){
	  var selected = $('#medicineLoad').datagrid('getSelections');
	 if (selected==null) {
			YiYa.alert('警告','未选中记录！','warning');  
	    	return;
	    }else{
	    	for(var i=0;i<selected.length;i++){
	    		if(!contains(arr, selected[i].medicineId)){
		    		arr.push(selected[i].medicineId);
		    		$("#medicineId").val(selected[i].medicineId);
			    	$("#barCode").val(selected[i].barCode);
			    	insertMedicineMsg(1);
		    	}else{
		    		YiYa.alert('警告','药品【'+selected[i].medicineName+'】已存在,请编辑数量！','warning');
					return;
		    	}
	    	}
	    	$("#medicineMsg").dialog("close");
	    }	
}
/**
 * 获取条形码
 */
  function  addBarCode(){
	  $("#barCode").val($("#barCode1").val());
	 var barCode1= $("#barCode1").val();
	 if(barCode1!=""){
		 insertMedicineMsg(2);
	 }
  }
  /**
   * 通过条形码或id查询药品信息 插入表格中
   */
  function  insertMedicineMsg(type){
	 var  quantity=1;
	var medicineId= $("#medicineId").val();
	var barCode	=$("#barCode").val();
	if(type==2){
		medicineId=null;	
	}
	var  xiaoji=0;
		$.ajax({
		     type:'post',
		     url:urls['msUrl'] + 'PurchaseController/medicineMsg.do', 
		     async: false,
		     data: {
		    	 medicineId:medicineId,
		    	 barCode:barCode
		     } ,
		     dataType: "json",
		     success:function(reponse) { 
		    	 if(reponse&&reponse.success){
		    		  if(type==2){
		    			  $("#barCode1").focus();
		    			  if(!contains(arr1,reponse.map.medicine_id)){
		    				  arr1.push(reponse.map.medicine_id);  
		    				  xiaoji=parseFloat(reponse.map.price).toFixed(2);
		    				  $('#data-list').datagrid('insertRow',{
						            index: 0,
						            row: {
						            	medicineId:reponse.map.medicine_id,
						            	medicineName:reponse.map.medicine_name,
						            	price:reponse.map.price,
						            	quantity:quantity,
						            	xiaoji:xiaoji
				            		}
					            });
		    			  }else{
		    				  var quantity1=0;
		    				  var updateIndex=0;
		    				  var rows = $('#data-list').datagrid('getRows');
		    				  for(var i=0;i<rows.length;i++){
		    					  if(reponse.map.medicine_id==rows[i].medicineId){
		    						  quantity1=rows[i].quantity;
		    						  updateIndex=$('#data-list').datagrid('getRowIndex',rows[i]);
		    					  }
		    				  }
		    				 quantity=parseInt(quantity1)+1;
		    				  xiaoji=parseFloat(quantity*reponse.map.price).toFixed(2);
		    				$('#data-list').datagrid('updateRow',{
		    						index: updateIndex,
		    						row: {
		    							xiaoji: xiaoji,
		    							quantity:quantity
		    						}
		    					});
		    			  }
		    			  $("#barCode1").val('');
		    			  $("#barCode").val('');
		    		  }else if(type==1){
		    			  $('#data-list').datagrid('insertRow',{
					            index: 0,
					            row: {
					            	medicineId:reponse.map.medicine_id,
					            	medicineName:reponse.map.medicine_name,
					            	price:reponse.map.price,
					            	quantity:quantity,
					            	xiaoji:parseFloat(reponse.map.price).toFixed(2)
			            		}
				            });  
		    		  }
		    		  totalAmount();
		    	 }else if(type==2){
		    		 $("#barCode1").val('');
		    		 YiYa.alert('警告','请输入正确的条形码！','warning');   
		    	 }
		    }
		});
  }
  
  
  /**
   * 重新定义class
   */
  
  $.extend($.fn.datagrid.defaults.editors, {    
	  numberbox1: {    
	        init: function(container, options){    
	            var input = $('<input type="text" class="datagrid-editable-input"  onblur="countTotal(this);">').appendTo(container);    
	            return input;    
	        },    
	        getValue: function(target){    
	            return $(target).val();    
	        },    
	        setValue: function(target, value){    
	            $(target).val(value);    
	        },    
	        resize: function(target, width){    
	            var input = $(target);    
	            if ($.boxModel == true){    
	                input.width(width - (input.outerWidth() - input.width()));    
	            } else {    
	                input.width(width);    
	            }    
	        }    
	    }    
	});  
  /**
   * 计算每种药品合计
   * @param obj
   */
  
  function  countTotal(obj){
	var index=$("#rowIndex").val();  
	$('#data-list').datagrid('clearChecked');
	$('#addMedcine').datagrid("endEdit",index);
	 $('#addMedcine').datagrid("beginEdit",index);
	$('#data-list').datagrid('selectRow',index);
	 var rows = $('#data-list').datagrid('getSelected');
	 var num=$(obj).val();
	 var re = /^[1-9]+[0-9]*]*$/;
		if(!re.test(num)){
			YiYa.alert('警告','请输入正整数！','warning');  
			$(obj).val('');
			$("#totalAmount").val('');
			return;
		}
	 var xiaoji=parseFloat(num*rows.price).toFixed(2);
	 
	 $('#data-list').datagrid('updateRow',{
			index: index,
			row: {
				xiaoji: xiaoji,
				quantity:num
			}
		});
	 	totalAmount();
  	}
  /**
   * 计算消费总金额
   */
  function  totalAmount(){
	  var sum=0;
	  var rows = $('#data-list').datagrid('getRows');
	  if(rows.length>0){
		 for(var i=0;i<rows.length;i++){
			var index=$('#data-list').datagrid('getRowIndex',rows[i]); 
			$('#data-list').datagrid("endEdit",index);
			 sum+=parseFloat(rows[i].xiaoji);
		 }
		$("#totalAmount").val(parseFloat(sum).toFixed(2));  
	  }else{
			 $("#totalAmount").val(0);
	  } 
  } 
  
  /**
   * 查询出员工信息
   */
  function  checkUser(){
	 var  userCard=$("#userCard").val();
	if(userCard.length!=8){
		 return;	
	}
	 $("#userCard").val('');
	 if(userCard!=undefined){
		 addUserMsg(userCard);
	 }
  }
  
  
  
  function  addUserMsg(userCard){
	  $.ajax({
		     type:'post',
		     url:urls['msUrl'] + 'PurchaseController/getUserData.do', 
		     data: {
		    	 cardHao:userCard
		     } ,
		     dataType: "json",
		     success:function(reponse) { 
		    	 if(reponse&&reponse.success){
		    		$("#amount").val(reponse.map.amount); 
		    		$("#userDepname").val(reponse.map.user_depname); 
		    		$("#userLname").val(reponse.map.user_lname);
		    		$("#userSerial").val(reponse.map.user_serial);
		    		$("#accType1").val(reponse.map.accType1);
		    		$("#userDuty").val(reponse.map.user_duty);
		    		$("#barCode1").focus();
		    	 }else{
		    		 YiYa.alert('警告',reponse.msg,'warning');   
		    		 return;
		    	 }
		    }
		});
  }
  
  
  
  
  /**
   * 查询出员工信息
   */
  function  checkUser1(){
	 var  userCard=$("#userCard1").val();
	 
	 if(userCard.length!=8){
		 return;
	 }
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
		    		$("#amount11").val(reponse.map.amount); 
		    		$("#userDepname1").val(reponse.map.user_depname); 
		    		$("#userLname1").val(reponse.map.user_lname);
		    		$("#userSerial1").val(reponse.map.user_serial);
		    		$("#accType11").val(reponse.map.accType1);
		    	 }else{
		    		 YiYa.alert('警告',reponse.msg,'warning');   
		    		 return;
		    	 }
		    }
		});
  }
  
  function  closeDialog(){
	  $('#medicine').dialog('close');
     $('#searchForm').form('reset');
	  $('#userMessage').form('reset');
	  var rows = $('#data-list').datagrid('getRows');
	  if (rows) {
		  for (var i = rows.length - 1; i >= 0; i--) {
			  var index = $('#data-list').datagrid('getRowIndex', rows[i]);
		  	$('#data-list').datagrid('deleteRow', index);
		  }
	  }
	  $("#userCard").focus();
	  arr=[];
	  arr1=[];
	  $('#addText2').remove();
      $('#addText3').remove(); 
  }
  
  
  function submitForm(){
	  var accType11=$("#accType11").val();
	  if(accType11=='0'){
		  var amount11=$("#amount11").val();
		  var  money=$("#money").val();
		 if(parseInt(amount11)<parseInt(money)){
			 YiYa.alert('警告',"账户余额不足，请充值！",'warning');   
    		 return; 
		 } 
	  }
	$('#settlementForm').form('submit', {    
		 	url:urls['msUrl'] + 'InventoryController/settlementForm.do', 
		 	method:"post",
		    success:function(data){ 
		        if(data){
		        	$('#settlementForm').form('reset');
		        	$("#tiXian").dialog("close");
		        	YiYa.alert('提示',"结算成功！",'ok');  
		        }
		    }    
		});
  }
  function  closeAccountMoney(){
	  $('#accountMoney').dialog('close');
	  $('#addText1').remove(); 
  }
	
  
  function  getkey(){
	  var event=arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异  
	  if(event.keyCode==13){  
		  	addBarCode();
	 }   
  }
  