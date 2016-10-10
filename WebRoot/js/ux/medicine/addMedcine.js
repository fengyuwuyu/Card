 
$(function(){
	var preOrderId1= $("#updateId").val();
	$('#addMedcine').datagrid({
		title: '药品信息',
		url:urls['msUrl'] + 'PreOrderDetaiController/getUserMedcineList.do?preOrderId1='+preOrderId1,
		iconCls:"icon-window",
	    pagination:true,
	    singleSelect:false,
	    width:550,
		height:300,
		columns:[[
			{field:'ck',checkbox:true},
			{field:'preOrderId',hidden:true},
			{field:'medName',title:'药品名称',align:'left',width:150,sortable:true,editor:{type:'validatebox',options:{required:true,validType:'length[1,25]'}}},
			{field:'quantity',title:'数量',align:'center',width:100,sortable:true,editor:{type:'numberbox',options:{required:true,min:1}}},
			{field:'price',title:'价格',align:'center',width:100,sortable:true,editor:{type:'numberbox1'}},
			{field:'xiaoji',title:'合计',align:'center',width:100,sortable:true}
		]],
		toolbar: ["-", {
            id: '',
            text: '添加',
            iconCls:'icon-add',
			btnType:'add',
            handler: function () {
            	 var rows = $('#addMedcine').datagrid("getRows");
            	$('#addMedcine').datagrid('insertRow',{
            		index:rows.length,	// 索引从0开始
            		row: {
            			
            		}
            	});
            }
        }, "-", {
            id: '',
            text:'删除',
			iconCls:'icon-remove',
			btnType:'remove',
            handler: function () {
            	 var rows = $('#addMedcine').datagrid('getSelections');
            	 if( rows.length==0){
            		 YiYa.alert('警告','未选中记录！','warning');  
            		 return;
					}
            	 
                for (var i = 0; i < rows.length; i++) {
                	var index=$('#addMedcine').datagrid('getRowIndex',rows[i]); 
                	$('#addMedcine').datagrid("deleteRow",index);
                }
            }
        }],
		onClickCell:function(rowIndex, field, value){
			 var rows = $('#addMedcine').datagrid('getRows');
				if(rows.length>0){
					for (var i = 0; i < rows.length; i++) {
						var index=$('#addMedcine').datagrid('getRowIndex',rows[i]); 
						if(rowIndex!=index){
							$('#addMedcine').datagrid("endEdit",index);
						}
	                }
				}
				 $('#addMedcine').datagrid("beginEdit",rowIndex);
				 $("#rowIndex").val(rowIndex);
			}
	});	
	
});

$.extend($.fn.datagrid.defaults.editors, {    
	  numberbox1: {    
	        init: function(container, options){    
	            var input = $('<input type="text" class="easyui-numberbox"  onblur="countTotal(this);">').appendTo(container);    
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
	$('#addMedcine').datagrid('clearChecked');
	$('#addMedcine').datagrid("endEdit",index);
	 $('#addMedcine').datagrid("beginEdit",index);
	$('#addMedcine').datagrid('selectRow',index);
	 var rows = $('#addMedcine').datagrid('getSelected');
	 var num=$(obj).val();
	 var re = /^(([1-9]\d{0,9})|0)(\.\d{1,2})?$/;
		if(!re.test(num)){
			YiYa.alert('警告','请输入正确的金额！','warning');  
			$(obj).val('');
			$("#totalAmount").val('');
			return;
		}
	 var xiaoji=num*rows.quantity;
	 $('#addMedcine').datagrid('updateRow',{
			index: index,
			row: {
				xiaoji: xiaoji,
				price:num
			}
		});
	}
/**
 * 计算消费总金额
 */
function  totalAmount(){
	  var sum=0;
	  var rows = $('#addMedcine').datagrid('getRows');
	  if(rows.length>0){
		 for(var i=0;i<rows.length;i++){
			 sum+=rows[i].xiaoji;
		 } 
		$("#totalAmount").val(sum);  
	  }
} 

