/*声明命名空间*/
$package('YiYa.sysMenu');

/*封装变量（利用匿名自执行函数）*/
YiYa.sysMenu = function(){
	var _box = null;
	var _this = {
		toList:function(parentId){
				_box.form.search.resetForm();
				if(parentId){
					$('#search_parentId').val(parentId);
					$('#btn-back').linkbutton('enable');
					_box.grid.datagrid('hideColumn','childMenus');
				}else{
					$('#btn-back').linkbutton('disable');
					_box.grid.datagrid('showColumn','childMenus');
				}
				_box.handler.refresh();
		},
		config:{
  			action:{
  				save:urls['msUrl'] + 'systemController/sysMenuSave.do',//保存Action  
  				getById:urls['msUrl'] + 'systemController/sysMenuGetById.do',//查询Action
  				remove:urls['msUrl'] + 'systemController/sysMenuDelete.do'//删除Action
  			},		 
  			event:{
  				add:function(){
  					_box.handler.add(function(){//调用add方法
  						var parentId = $('#search_parentId').val();
  						if(parentId){
  							$('#edit_parentId').val(parentId);
  						}
  					});					
				}
  			},
  			dataGrid:{
	   			url:urls['msUrl'] + 'systemController/sysMenuDataList.do',
	   			idField:'menuId',
	   			columns:[[
					{field:'ck',checkbox:true},
					{field:'menuId',hidden:true},
					{field:'menuName',title:'菜单名称',align:'center',width:120,sortable:true},
					{field:'sequence',title:'菜单排序',align:'center',width:120,sortable:true},								
					{field:'childMenus',title:'子菜单',align:'center',width:120,formatter:function(value,row,index){
						var html ='<a href=\'#\' onclick=\'YiYa.sysMenu.toList('+row.menuId+')\'>子菜单管理</a>';
						return html;
					}},
					{field:'menuDes',title:'备注',align:'center',width:220,sortable:true}	
				]],
				toolbar:[
					{id:'btn-add',text:'添加',btnType:'add'},
					{id:'btn-edit',text:'修改',btnType:'edit'},
					{id:'btn-remove',text:'删除',btnType:'remove'},
					{
						id:'btn-back',
						text:'返回',
						disabled:true,
						iconCls:'icon-back',
						handler:function(){_this.toList();}
					}
				]
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
	YiYa.sysMenu.init();
});		