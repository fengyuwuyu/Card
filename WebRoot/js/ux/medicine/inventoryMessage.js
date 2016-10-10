/*声明命名空间*/
$package('YiYa.inventoryMessage');

/*封装变量（匿名自执行函数）*/
YiYa.inventoryMessage = function(){
	var _box = null;
	var _this = {
		config:{
  			dataGrid:{
	   			url:urls['msUrl'] + 'InventoryController/inventoryMessage.do',
	   			idField:'medicine_id',
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'medicineId',hidden:true},
						{field:'medicineName',title:'药品名称',align:'left',width:300,sortable:true},
						{field:'number',title:'入库总数量',align:'center',width:150,sortable:true},
						{field:'cou',title:'销售数量',align:'center',width:150,sortable:true},
						{field:'quantity',title:'库存数量',align:'center',width:150,sortable:true},
						{field:'childMenus',title:'入库信息',align:'center',width:120,formatter:function(value,row,index){
							var html ='<a href=\'#\' onclick=\'inventoryList('+row.medicineId+')\'>入库明细</a>';
							return html;
						}},
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
	YiYa.inventoryMessage.init();
	
});	


$.extend($.fn.validatebox.defaults.rules, {
	validaDate: {
		validator: function(value, param){
		var beginDate=	$("#beginDate").datebox('getValue');
		var endDate=$("#endDate").datebox('getValue');
		var b=true;
		if(endDate!="" &&beginDate!=""){
			b=colomplteDate(beginDate,endDate);
		}
		return b;
		},
		message: '开始日期不能大于结束日期！'
	}
});

function  colomplteDate (beg,end){
	  var date1 = new Date(Date.parse(beg));  
      var date2 = new Date(Date.parse(end));  
      if (date1.getTime() > date2.getTime()) {  
          return false;  
      }  
     return true; 
      
}

function   inventoryList(){
	$("#inventoryList").dialog("open").load(urls['msUrl'] + 'InventoryController/inventoryList.do');
}


	