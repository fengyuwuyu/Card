
/*页面初始化*/
$(function(){
	
	var userSerial=parseInt($("#userSerial").val());
	$('#dtUser').datagrid({
		title: '员工信息',
	    iconCls:"icon-window",
	    collapsible: true,
	    minimizable: true,
	    maximizable: true,
	    resizable: true,
	    pagination:true,
	    rownumbers:true,
	    url:urls['msUrl'] + 'MedAccountController/dtUserList.do?userSerial='+userSerial,
	    pageSize:10,
	    pageList:[10,20,20,40,50],
	    modal: true,
		width:755,
		height:355,
		singleSelect:true,
		columns:[[
					{field:'ck',checkbox:true},
					{field:'userLname',title:'员工姓名',align:'left',width:80,sortable:true},
					{field:'userNo',title:'工号',align:'center',width:80,sortable:true},
					//{field:'sexName',title:'性别',align:'center',width:60,sortable:true},
					{field:'userDuty',title:'职务',align:'center',width:150,sortable:true},
					{field:'userDepname',title:'部门',align:'center',width:150,sortable:true},
					{field:'cardNumber',title:'医药账号',align:'center',width:150,sortable:true},
					{field:'amount',title:'账户金额',align:'center',width:80,sortable:true},
			]]
	});
	
		$('#search').linkbutton({    
	        iconCls: 'icon-search'   
	    }); 
	 
		 $("#search").click(function(){
	   	  $('#dtUser').datagrid('load',{
	   		  userLname:$("#userLname").val()
	    });
   });
});	







	