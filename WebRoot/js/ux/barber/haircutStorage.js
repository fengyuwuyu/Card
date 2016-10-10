/*声明命名空间*/
$package('YiYa.haircutArticles');

/*封装变量（匿名自执行函数）*/
YiYa.haircutArticles = function(){
	var _box = null;
	var _this = {
		config:{
			action:{
  				save:urls['msUrl'] + 'HaircutStorageController/save.do',//保存Action  
  				getById:urls['msUrl'] + 'HaircutStorageController/getById.do',//查询Action
  				remove:urls['msUrl'] + 'HaircutStorageController/delete.do'//删除Action
  			},
  			dataGrid:{
	   			url:urls['msUrl'] + 'HaircutStorageController/dataList.do',
	   			idField:'storageId',
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'storageId',hidden:true},
						{field:'articlesName',title:'名称',align:'left',width:150,sortable:true},
						{field:'articlesPrice',title:'价格',align:'center',width:80,sortable:true},
						{field:'articlesAddress',title:'产地',align:'center',width:80,sortable:true},
						{field:'storageNum',title:'数量',align:'center',width:80,sortable:true},
						{field:'articlesDesc',title:'描述',align:'center',width:250,sortable:true,nowrap:false}
				]],
				toolbar: [{
					iconCls: 'icon-add',
					text:"入库",
					handler: function(){
						StorageArticles();
					}
				}]

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
/*
 * 
 */
 function  StorageArticles(){
	 $("#ArticlesList").dialog("open").load(urls['msUrl'] + 'HaircutStorageController/addHaircutStorage.do');
 }
