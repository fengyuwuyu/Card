/*声明命名空间*/
$package('YiYa.haircutArticles');

/*封装变量（匿名自执行函数）*/
YiYa.haircutArticles = function(){
	var _box = null;
	var _this = {
		config:{
			action:{
  				save:urls['msUrl'] + 'HaircutArticlesController/save.do',//保存Action  
  				getById:urls['msUrl'] + 'HaircutArticlesController/getById.do',//查询Action
  				remove:urls['msUrl'] + 'HaircutArticlesController/delete.do'//删除Action
  			},
  			dataGrid:{
	   			url:urls['msUrl'] + 'HaircutArticlesController/dataList.do',
	   			idField:'articlesId',
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'articlesId',hidden:true},
						{field:'articlesName',title:'名称',align:'left',width:150,sortable:true},
						{field:'articlesPrice',title:'价格',align:'center',width:80,sortable:true},
						{field:'articlesAddress',title:'产地',align:'center',width:80,sortable:true},
						{field:'articlesDesc',title:'描述',align:'center',width:250,sortable:true,nowrap:false}
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
	YiYa.haircutArticles.init();
});	
