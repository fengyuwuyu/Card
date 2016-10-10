/*声明命名空间*/
$package('YiYa.haircutPrice');

/*封装变量（匿名自执行函数）*/
YiYa.haircutPrice = function(){
	var _box = null;
	var _this = {
		config:{
			action:{
  				save:urls['msUrl'] + 'HaircutPriceController/save.do',//保存Action  
  				getById:urls['msUrl'] + 'HaircutPriceController/getById.do',//查询Action
  				remove:urls['msUrl'] + 'HaircutPriceController/delete.do'//删除Action
  			},
  			dataGrid:{
	   			url:urls['msUrl'] + 'HaircutPriceController/dataList.do',
	   			idField:'haircutId',
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'haircutId',hidden:true},
						{field:'haircutType',title:'理发类型',align:'left',width:150,sortable:true},
						{field:'price',title:'理发价格',align:'center',width:80,sortable:true},
						{field:'haircutDesc',title:'理发描述',align:'center',width:250,sortable:true,nowrap:false}
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
	YiYa.haircutPrice.init();
});	
