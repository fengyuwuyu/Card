/*声明命名空间*/
$package('YiYa.medAccount');

/*封装变量（匿名自执行函数）*/
YiYa.medAccount = function(){
	var _box = null;
	var _this = {
		config:{
			action:{
  				save:urls['msUrl'] + 'MedAccountController/save.do',//保存Action  
  				getById:urls['msUrl'] + 'MedAccountController/getById.do',//查询Action
  				remove:urls['msUrl'] + 'MedAccountController/delete.do'//删除Action
  			},
  			dataGrid:{
	   			url:urls['msUrl'] + 'MedAccountController/dataList.do',
	   			idField:'medicineId',
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'userSerial',hidden:true},
						{field:'userLname',title:'员工姓名',align:'left',width:80,sortable:true},
						{field:'userNo',title:'工号',align:'center',width:80,sortable:true},
						{field:'userDepname',title:'部门',align:'center',width:150,sortable:true},
						{field:'cardNumber',title:'医药账号',align:'center',width:150,sortable:true},
						{field:'amount',title:'账户余额',align:'center',width:100,sortable:true},
						{field:'accType',title:'特殊用户',align:'center',width:100,sortable:true}
						
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
	YiYa.medAccount.init();
	$("#btn-reset").click(function(){
		$('#searchForm').form('reset');
	});
});	



	