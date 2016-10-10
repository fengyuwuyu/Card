$(function(){
	var post = $('#data-list').datagrid('getSelected');
	var medicineName=$("#medicineName").val();
	var	beginDate=	$("#beginDate").datebox('getValue');
	var	endDate=$("#endDate").datebox('getValue');
	var	medicineId=post.medicineId;
	var  number=post.number;
	$("#number").val(number);
	$("#medicineId").val(medicineId);
	$('#inventoryListGrid').datagrid({
		//title: '入库信息',
		url:urls['msUrl'] + 'InventoryController/inventoryListGrid.do?medicineName='+medicineName+"&beginDate="+beginDate+"&endDate="+endDate+"&medicineId="+parseInt(medicineId),
	    iconCls:"icon-window",
	    width:650,
		height:353,
		nowrap:false,
		autoRowHeight:false,
		striped:true,
		remoteSort:false,
		pagination:true,
		rownumbers:true,
		singleSelect:true,
		checkOnSelect:true,
		selectOnCheck:true,
		method:'post',
		columns:[[
			{field:'inventoryId',hidden:true},
			{field:'medicineName',title:'药品名称',align:'left',width:300,sortable:true},
			{field:'number',title:'入库数量',align:'center',width:150,sortable:true},
			{field:'invTime',title:'入库时间',align:'center',width:150,sortable:true},
		]],
		toolbar:[{
			text:'导出',
			iconCls: 'icon-uncompress',
			handler: function(){
				$('#searchForm').form('submit', {    
				    url:urls['msUrl'] + 'InventoryController/ExportExcel2.do', 
				    success:function(data){    
				      if(data.success){
				    	  YiYa.alert('提示',data.msg,'ok');  
				      }else{
				    	  YiYa.alert('警告信息','导出失败，请重试！','warning');  
				    	  return false;  
				      }
				    }    
				});  
			}
	}],	
	});	
});