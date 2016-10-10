/*声明命名空间*/
$package('YiYa.medicine');

/*封装变量（匿名自执行函数）*/
YiYa.medicine = function(){
	var _box = null;
	var _this = {
		config:{
			action:{
  				save:urls['msUrl'] + 'MedicineController/save.do',//保存Action  
  				getById:urls['msUrl'] + 'MedicineController/getById.do',//查询Action
  				remove:urls['msUrl'] + 'MedicineController/delete.do'//删除Action
  			},
  			dataGrid:{
	   			url:urls['msUrl'] + 'MedicineController/dataList.do',
	   			idField:'medicineId',
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'medicineId',hidden:true},
						{field:'typeName',title:'药品类型',align:'left',width:300,sortable:true},
						{field:'medicineName',title:'药品名称',align:'left',width:300,sortable:true},
						{field:'price',title:'药品价格',align:'center',width:80,sortable:true},
						{field:'vendor',title:'生产厂家',align:'center',width:150,sortable:true},
						{field:'medicineDesc',title:'药品描述',align:'center',width:150,sortable:true,nowrap:false}
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
	YiYa.medicine.init();
});	
