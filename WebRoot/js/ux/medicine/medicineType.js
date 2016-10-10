/*声明命名空间*/
$package('YiYa.medicineType');

/*封装变量（匿名自执行函数）*/
YiYa.medicineType = function(){
	var _box = null;
	var _this = {
		config:{
			action:{
  				save:urls['msUrl'] + 'MedicineTypeController/save.do',//保存Action  
  				getById:urls['msUrl'] + 'MedicineTypeController/getById.do',//查询Action
  				remove:urls['msUrl'] + 'MedicineTypeController/delete.do'//删除Action
  			},
  			dataGrid:{
	   			url:urls['msUrl'] + 'MedicineTypeController/dataList.do',
	   			idField:'typeId',
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'typeId',hidden:true},
						{field:'typeName',title:'药品类型',align:'left',width:300,sortable:true},
						{field:'medicineDetailed',title:'类型描述',align:'center',width:150,sortable:true}
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
	YiYa.medicineType.init();
});	






	