/*声明命名空间*/
$package('YiYa.inventory');

/*封装变量（匿名自执行函数）*/
YiYa.inventory = function(){
	var _box = null;
	var _this = {
		config:{
			action:{
  				save:urls['msUrl'] + 'InventoryController/save.do',//保存Action  
  				getById:urls['msUrl'] + 'InventoryController/import.do',//查询Action
  				remove:urls['msUrl'] + 'InventoryController/delete.do'//删除Action
  			},
  			dataGrid:{
	   			url:urls['msUrl'] + 'InventoryController/dataList.do',
	   			idField:'inventoryId',
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'inventoryId',hidden:true},
						{field:'medicineName',title:'药品名称',align:'left',width:300,sortable:true},
						{field:'price',title:'药品价格',align:'center',width:80,sortable:true},
						{field:'vendor',title:'生产厂家',align:'center',width:150,sortable:true},
						{field:'medicineDesc',title:'药品描述',align:'center',width:150,sortable:true},
						{field:'quantity',title:'库存数量',align:'center',width:150,sortable:true},
				]]

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
	YiYa.inventory.init();
	$("#btn-add").click(function(){
		$("#inventoryList").dialog("open").load(urls['msUrl'] + 'InventoryController/addInventory.do');
	});
	
	$("#btn-reset").click(function(){
		$('#searchForm').form('reset');
	});
	
	
});	

function  checkMedicine(){
	$("#medicine").dialog("open").load(urls['msUrl'] +"InventoryController/goPage.do?status=1");
}


function sumbitForm(){
	var b=true;
	var rows = $('#addInventory').datagrid('getRows');
	if(rows.length==0){
		YiYa.alert('警告','请选择入库的药品！','warning');  
		return;
	}
	for (var i = 0; i < rows.length; i++) {
		$('#addInventory').datagrid("endEdit",i);
	}
	for (var i = 0; i < rows.length; i++) {
		$('#addInventory').datagrid("endEdit",i);//关闭行编辑获取值
		if(rows[i].quantity==undefined){
			YiYa.alert('警告','请输入正确数据！','warning');  
			return;
		}
		
		$.ajax({
		     type:'post',
		     url:urls['msUrl'] + 'InventoryController/addInventoryForm.do', 
		     async: false,
		     data: {
		    	 examinerId:rows[i].medicineId,
		    	 quantity:rows[i].quantity
		     } ,
		     dataType: "json",
		     success:function(reponse) { 
		    	 if(reponse&&reponse.success){
		    	 }
		    }
		});
	}
	if(b){
		 YiYa.alert('提示',"入库成功",'ok');
  		 $("#inventoryList").dialog("close");
  		 $('#data-list').datagrid('reload'); 
	}
}


	function downLoadFile(){
		var path=$("#importtext").val();
		window.open(urls['msUrl'] + 'InventoryController/downLoadFile.do?path='+path);
	 }

	function  checkDate(date){
		var b=false;
		var d = new Date();
		var  month=d.getMonth()+1;
		var day=d.getDate();
		if(month<10){
			month="0"+month;
		}
		if(day<10){
			day="0"+day;
		}
		var str = d.getFullYear()+"-"+month+"-"+day;
		var nowDate = new Date(str);
		var checkDate = new Date(date);
		 if(nowDate.getTime()<checkDate.getTime()){
		       b=true;
		    } 
		return b;
	};

function  updateInventory(){
	var quantity=$("#quantity").val();
	var g = /^[1-9]*[1-9][0-9]*$/;
	var b=g.test(quantity);
	if(!b){
		  YiYa.alert('警告信息','请输入正确的数量！','warning'); 
		  $("#quantity").val(Number(0));
    	  return false;  
	}
	$('#InventoryForm').form('submit', {    
	    url:urls['msUrl'] + 'InventoryController/updateInventory.do', 
	    success:function(data){   
	    var post=$.parseJSON(data);
	      if(post.success){
	    	  $("#updateInventory").dialog("close");
	    	  $("#data-list").datagrid('reload');  
	    	  YiYa.alert('提示',post.msg,'ok');
	      }else{
	    	  YiYa.alert('警告信息','修改失败！','warning');  
	    	  return false;  
	      }
	    }    
	});  
	
	
}

	