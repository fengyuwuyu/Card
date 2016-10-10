/*声明命名空间*/
$package('YiYa.haircutTerms');

/*封装变量（匿名自执行函数）*/
YiYa.haircutTerms = function(){
	var _box = null;
	var _this = {
		config:{
			action:{
  				save:urls['msUrl'] + 'HaircutTermsController/save.do',//保存Action  
  				getById:urls['msUrl'] + 'HaircutTermsController/getById.do',//查询Action
  				remove:urls['msUrl'] + 'HaircutTermsController/delete.do'//删除Action
  			},
  			dataGrid:{
	   			url:urls['msUrl'] + 'HaircutTermsController/dataList.do',
	   			idField:'termsId',
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'termsId',hidden:true},
						{field:'termsName',title:'名称',align:'left',width:150,sortable:true},
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
	YiYa.haircutTerms.init();
});	
