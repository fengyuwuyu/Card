
/*页面初始化*/
$(function(){
    $('#medicineLoad').datagrid({
    			title: '药品信息',
			    iconCls:"icon-window",
			    collapsible: true,
			    minimizable: true,
			    maximizable: true,
			    resizable: true,
			    pagination:true,
			    rownumbers:true,
				url:urls['msUrl'] + 'MedicineController/dataList.do',
			    pageSize:10,
			    pageList:[10,20,20,40,50],
			    modal: true,
				width:860,
				height:355,
				singleSelect:false,
				columns:[[
					{field:'ck',checkbox:true},
					{field:'medicineId',hidden:true},
					{field:'medicineName',title:'药品名称',align:'left',width:150,sortable:true},
					{field:'price',title:'药品价格',align:'center',width:60,sortable:true},
					{field:'vendor',title:'生产厂家',align:'center',width:230,sortable:true},
					{field:'medicineDesc',title:'药品描述',align:'center',width:350,sortable:true,nowrap:false},
					{field:'barCode',title:'药品条码',align:'center',width:230,sortable:true,hidden:true},
				]]
    });
	
    $('#search').linkbutton({    
        iconCls: 'icon-search'   
    }); 
    
    $("#search").click(function(){
    	  $('#medicineLoad').datagrid('load',{
    	    	 medicineName:$("#medicineName").val()
	    });
    });
   var status= $("#status").val();//用于判断赋值单选还是多选
   var singleSelect=$('#medicineLoad').datagrid('options').singleSelect;
   if(status==1){
	   singleSelect=false;
   }else{
	   singleSelect=false;
   }
   $('#medicineLoad').datagrid('options').singleSelect=singleSelect;
});	
    

	function getSelected() {
	    var selected = $('#medicineLoad').datagrid('getSelections');
	 if (selected==null) {
			YiYa.alert('警告','未选中记录！','warning');  
	    	return;
	    }else{
	    	var rows =$("#data-list").datagrid("getRows");
	    		if(rows.length>0){
	    			for(var j=0;j<rows.length ;j++){
	    				for(var i=0;i<selected.length;i++){
			    		if(rows[j].medicineId==selected[i].medicineId){
			    			YiYa.alert('警告','药品【'+selected[i].medicineName+'】已存在,请编辑数量！','warning');
							return;
			    		}
	    			}
	    		}
	    		addMedicine();		
	    }else{
	    	addMedicine();	
	    }
	}
}

    