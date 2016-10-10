var arr = new Array();
var arr1 = new Array();
/*页面初始化*/
$(function(){
	$("#barCode1").focus();
    $('#addInventory').datagrid({
    			title: '药品信息',
    			//url:urls['msUrl'] + 'InventoryController/getNum.do',
			    iconCls:"icon-window",
			    collapsible: true,
			    minimizable: true,
			    maximizable: true,
			    resizable: true,
			    modal: true,
			    singleSelect:false,
			    width:840,
				height:333,
				columns:[[
					{field:'ck',checkbox:true},
					{field:'medicineId',hidden:true},
					{field:'medicineName',title:'药品名称',align:'left',width:150,sortable:true},
					{field:'price',title:'药品价格',align:'center',width:60,sortable:true},
					{field:'vendor',title:'生产厂家',align:'center',width:180,sortable:true},
					{field:'medicineDesc',title:'药品描述',align:'center',width:150,sortable:true,nowrap:false},
					{field:'quantity',title:'数量',align:'center',width:100,sortable:true,editor:{type:'numberbox',options:{required:true}}},
					//{field:'outTime',title:'过期日期',align:'center',width:120,sortable:true,editor:{type:'datebox',options:{required:true,editable:false}}},
				]],
				toolbar: ["-", {
		            id: '',
		            text: '添加',
		            iconCls:'icon-add',
					btnType:'add',
		            handler: function () {
		            	$("#medicine").dialog({    
			            	    title: '药品信息',    
			            	    closed: false,    
			            	    cache: false,    
			            	    modal: true ,
			            	    buttons: [{
			                        text: '确定',
			                        handler: function () {
			                        	getSelections();
			                        }
			                    }, {
			                        text: '关闭',
			                        handler: function () {
			                            $('#medicine').dialog('close');
			                        }
			                    }]
			            	}).dialog("open").load(urls['msUrl'] + 'InventoryController/goPage.do?status=2');  
		            }
		        }, "-", {
		            id: '',
		            text:'删除',
					iconCls:'icon-remove',
					btnType:'remove',
		            handler: function () {
		            	 var rows = $('#addInventory').datagrid('getSelections');
		            	 if( rows.length==0){
		            		 YiYa.alert('警告','未选中记录！','warning');  
		            		 return;
							}
		            	 
		                for (var i = 0; i < rows.length; i++) {
		                	var index=$('#addInventory').datagrid('getRowIndex',rows[i]); 
		                	$('#addInventory').datagrid("deleteRow",index);
		                	var len=arr.indexOf (rows[i].medicineId);
		                	arr.splice(len, 1);
		                	
		                }
		            }
		        }],
				onClickCell:function(rowIndex, field, value){
					 $('#addInventory').datagrid("beginEdit",rowIndex);
	   			}
    });	
});
    
	function getSelections() {
		var rows = $('#medicineLoad').datagrid('getSelections');
		for (var i = 0; i < rows.length; i++) {
			if(!contains(arr, rows[i].medicineId)){
				arr.push(rows[i].medicineId);
		    	$('#addInventory').datagrid('insertRow',{
		            index: 0,
		            row: {
		            	medicineId:rows[i].medicineId,
		            	medicineName:rows[i].medicineName,
		            	price:rows[i].price,
		            	vendor:rows[i].vendor,
		            	medicineDesc:rows[i].medicineDesc,
		            	}
		            });	
			}else{
				YiYa.alert('警告','药品【'+rows[i].medicineName+'】已存在,,请编辑入库数量!','warning');
				return;
			}
        }
		$("#medicine").dialog("close");
		 $('#addInventory').datagrid("beginEdit",0);
	}


	function  edtior(obj){
		var ele=$(obj).val();
		var re = /^[1-9]+[0-9]*]*$/;
		if(!re.test(ele)){
			YiYa.alert('警告','请输入正整数！','warning');  
			$(obj).val('');
			return;
		}
	}
	
	function contains(a,obj){
		var i=a.length;
		while(i--){
			if(a[i]==obj){
				return true;
			}
		}
		return false;
	}
	
	
	  function  getkey(){
		 var event=arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异  
		  if(event.keyCode==13){  
			  	addBarCode();
			  $("#barCode1").focus();
		 }   
	  }
	
	
	/**
	 * 获取条形码
	 */
	  function  addBarCode(){
		 $("#barCode").val($("#barCode1").val());
		 var barCode1= $("#barCode1").val();
		 if(barCode1!=""){
			 $("#barCode1").val('');  
			 insertMedicineMsg();
		 }
	  }	
	
	function  insertMedicineMsg(){
		var barCode	=$("#barCode").val();
		$.ajax({
		     type:'post',
		     url:urls['msUrl'] + 'PurchaseController/medicineMsg.do', 
		     data: {
		    	 barCode:barCode
		     } ,
		     dataType: "json",
		     success:function(reponse) { 
		    	 if(reponse&&reponse.success){
		    		 if(!contains(arr1,reponse.map.medicine_id)){
	    				  arr1.push(reponse.map.medicine_id); 
	    				  arr.push(reponse.map.medicine_id);
	    				  $('#addInventory').datagrid('insertRow',{
	    			            index: 0,
	    			            row: {
	    			            	medicineId:reponse.map.medicine_id,
					            	medicineName:reponse.map.medicine_name,
					            	price:reponse.map.price,
	    			            	vendor:reponse.map.vendor,
	    			            	medicineDesc:reponse.map.medicine_desc
	    			            	}
	    			            });	 
		    		 }else{
		    			 YiYa.alert('警告',"【"+reponse.map.medicine_name+"】已存在,请编辑入库数量",'warning');  
		    			 return; 
		    		 }  
		    		 
		    	 }else{
		    		YiYa.alert('警告','请输入正确条码！','warning');  
		 			return;
		 		}
		    }
		});
	}

