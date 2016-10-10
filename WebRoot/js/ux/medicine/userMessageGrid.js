$(function(){
	var post = $('#data-list').datagrid('getSelected');
	var	userSerial=post.userSerial;
	$("#amount1").val(post.amount1);
	var	beginDate=	$("#beginDate").datebox('getValue');
	var	endDate=$("#endDate").datebox('getValue');
	var	depSerial=post.depSerial;
	if(depSerial==null){
		depSerial='0';
	}
	if(userSerial==null){
		userSerial='-1';
	}
	$("#depSerialAccount").val(depSerial);
	$("#userSerial").val(userSerial);
	$('#userMessageGrid').datagrid({
		//title: '充值信息',
		url:urls['msUrl'] + 'MedAccountController/userMessageGrid.do?userSerial='+parseInt(userSerial)+"&beginDate="+beginDate+"&endDate="+endDate+"&depSerial="+parseInt(depSerial),
	    iconCls:"icon-window",
	    width:430,
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
			{field:'userLname',title:'员工姓名',align:'left',width:80,sortable:true},
			{field:'amount',title:'充值金额',align:'center',width:150,sortable:true},
			{field:'amount2',title:'充值金额',align:'center',width:150,sortable:true},
			{field:'createTime',title:'充值时间',align:'center',width:150,sortable:true},
		]],
		toolbar:[{
				text:'导出',
				iconCls: 'icon-uncompress',
				handler: function(){
					$('#searchForm').form('submit', {    
					    url:urls['msUrl'] + 'MedAccountController/ExportExcel2.do', 
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
		onLoadSuccess:function(){
			if(depSerial!=0){
				$("#userMessageGrid").datagrid('showColumn','userLname');
				$("#userMessageGrid").datagrid('hideColumn','createTime');
				$("#userMessageGrid").datagrid('hideColumn','amount');
				$("#userMessageGrid").datagrid('showColumn','amount2');
			}else{
				$("#userMessageGrid").datagrid('hideColumn','userLname');
				$("#userMessageGrid").datagrid('showColumn','createTime');
				$("#userMessageGrid").datagrid('hideColumn','amount2');
				$("#userMessageGrid").datagrid('showColumn','amount');
			}
		}
	});	
});