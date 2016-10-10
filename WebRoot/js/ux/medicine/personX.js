/*声明命名空间*/
$package('YiYa.personX');

/*封装变量（匿名自执行函数）*/
YiYa.personX = function(){
	var _box = null;
	var _this = {
		config:{
  			dataGrid:{
	   			url:urls['msUrl'] + 'PurchaseController/personalRecharge.do',
	   			idField:'medicineId',
	   			columns:[[
					{field:'ck',checkbox:true},
					{field:'userSerial',hidden:true},
					{field:'depSerial',hidden:true},
					{field:'medicineName',title:'药品名称',align:'center',width:150,sortable:true},
					{field:'price',title:'药品价格',align:'center',width:150,sortable:true},
					{field:'quantity',title:'购买数量',align:'center',width:150,sortable:true},
					{field:'total',title:'消费总计',align:'center',width:150,sortable:true},
					{field:'createTime',title:'购买时间',align:'center',width:150,sortable:true},
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
	YiYa.personX.init();
});	
