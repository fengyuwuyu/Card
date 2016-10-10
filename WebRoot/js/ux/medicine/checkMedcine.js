$(function(){
	var preOrderId1= $("#checkId").val();
	$('#checkMedcinePage').datagrid({
		title: '药品信息',
		url:urls['msUrl'] + 'PreOrderDetaiController/getUserMedcineList.do?preOrderId1='+preOrderId1,
		iconCls:"icon-window",
	    pagination:true,
	    singleSelect:false,
	    rownumbers:true,
	    width:550,
		height:300,
		columns:[[
			{field:'preOrderId',hidden:true},
			{field:'medName',title:'药品名称',align:'left',width:150,sortable:true},
			{field:'quantity',title:'数量',align:'center',width:100,sortable:true},
			{field:'price',title:'价格',align:'center',width:100,sortable:true},
			{field:'xiaoji',title:'合计',align:'center',width:100,sortable:true,formatter:function(value,row,index){
				return  row.quantity*row.price;
			}}
		]]
	});
});