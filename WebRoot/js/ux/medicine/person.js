/*声明命名空间*/
$package('YiYa.person');

/*封装变量（匿名自执行函数）*/
YiYa.person = function(){
	var _box = null;
	var _this = {
		config:{
  			dataGrid:{
	   			url:urls['msUrl'] + 'MedAccountController/personalRecharge.do',
	   			idField:'medicineId',
	   			columns:[[
					{field:'ck',checkbox:true},
					{field:'userSerial',hidden:true},
					{field:'depSerial',hidden:true},
					{field:'userLname',title:'员工姓名',align:'left',width:80,sortable:true},
					{field:'userNo',title:'工号',align:'center',width:80,sortable:true},
					{field:'userDepname',title:'部门',align:'center',width:150,sortable:true},
					{field:'amount',title:'充值金额',align:'center',width:150,sortable:true},
					{field:'createTime',title:'充值时间',align:'center',width:150,sortable:true}
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
	YiYa.person.init();
});	
