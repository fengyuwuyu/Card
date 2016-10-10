$(function(){
	var post = $('#data-list').datagrid('getSelected');
	var	userSerial=post.userSerial;
	var	beginDate=	$("#beginDate").datebox('getValue');
	var	endDate=$("#endDate").datebox('getValue');
	var	depSerial=post.depSerial;
	var  price=post.price;
	
	if(depSerial==null){
		depSerial='0';
	}
	if(userSerial==null){
		userSerial='-1';
	}
	var  selectType=$("#selectType").val();
	$("#depSerialAccount").val(depSerial);
	$("#userSerial").val(userSerial);
	$("#price").val(price);
	$('#userMessageGrid').datagrid({
		//title: '购买信息',
		url:urls['msUrl'] + 'PurchaseController/userMessageGrid.do?userSerial='+parseInt(userSerial)+"&beginDate="+beginDate+"&endDate="+endDate+"&depSerial="+parseInt(depSerial)+"&selectType="+selectType,
	    iconCls:"icon-window",
	    width:780,
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
			{field:'userLname',title:'员工姓名',align:'left',width:80,sortable:true},
			{field:'userNo',title:'工号',align:'center',width:80,sortable:true},
			{field:'medicineName',title:'药品名称',align:'center',width:150,sortable:true},
			{field:'price',title:'药品价格',align:'center',width:150,sortable:true},
			{field:'quantity',title:'购买数量',align:'center',width:150,sortable:true},
			{field:'total',title:'消费总计',align:'center',width:150,sortable:true},
			{field:'totalPrice',title:'消费总计',align:'center',width:150,sortable:true},
			{field:'createTime',title:'购买时间',align:'center',width:150,sortable:true},
		]],
		toolbar:[{
			text:'导出',
			iconCls: 'icon-uncompress',
			handler: function(){
				$('#searchForm').form('submit', {    
				    url:urls['msUrl'] + 'PurchaseController/ExportExcel2.do', 
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
			if(selectType=='1'){
				$("#userMessageGrid").datagrid('showColumn','userLname');
				$("#userMessageGrid").datagrid('hideColumn','total');
				$("#userMessageGrid").datagrid('hideColumn','medicineName');
				$("#userMessageGrid").datagrid('hideColumn','price');
				$("#userMessageGrid").datagrid('hideColumn','quantity');
				$("#userMessageGrid").datagrid('hideColumn','createTime');
				
			}else{
				$("#userMessageGrid").datagrid('hideColumn','userLname');
				$("#userMessageGrid").datagrid('hideColumn','userNo');
				$("#userMessageGrid").datagrid('hideColumn','totalPrice');
			}
		}
	});	
});