/*声明命名空间*/
$package('YiYa.sysRole');

/*封装变量（利用匿名自执行函数）*/
YiYa.sysRole = function(){
	var _box = null;
	var _this = {
		initTreeData:function(){
			$('#menu-tree').tree({
				url:urls['msUrl'] + 'systemController/getMenuTree.do',
				method:'get',
				animate:true,
				checkbox:true,
				cascadeCheck:true,
				onlyLeafCheck:false,
				lines:true,
				onLoadSuccess:function(){
					$(this).tree('expandAll');
				}
			});
		},
		getTreeData:function(nodes){				
			$.each(nodes,function(i,n){				
				var $id = $('<input type=\'hidden\' name=\'menuIds\' class=\'c_menus\'>');
				var id = n.id;
				$id.val(id);
				_box.form.edit.append($id);
			});
		},
		setTreeData:function(id){
			var node = $('#menu-tree').tree('find',id);
			$('#menu-tree').tree('check',node.target);
		
		},
		clearTreeData:function(){
			$('.tree-checkbox1').removeClass('tree-checkbox1').addClass('tree-checkbox0')
			$('.tree-checkbox2').removeClass('tree-checkbox2').addClass('tree-checkbox0')
			$('.c_menus').remove();			
		},
		config:{
			action:{
  				save:urls['msUrl'] + 'systemController/sysRoleSave.do',//保存Action  
  				getById:urls['msUrl'] + 'systemController/sysRoleGetById.do',//查询Action
  				remove:urls['msUrl'] + 'systemController/sysRoleDelete.do'//删除Action
  			},	
			event:{
				add:function(){
					_box.handler.add(function(){//调用add方法
						_this.clearTreeData();
					});
				},
				edit:function(){
					_box.handler.edit(function(result){//调用edit方法
						_this.clearTreeData();
						$.each(result.data.menuRoles,function(i,n){
							_this.setTreeData(n.menuId);
						});
					});
				},
				save:function(){	
					var checkdNodes = $('#menu-tree').tree('getChecked');
					if(checkdNodes.length > 0){
						_this.getTreeData(checkdNodes);
					}
					_box.handler.save()//调用save方法;
				}
			},
  			dataGrid:{
	   			url: urls['msUrl'] + 'systemController/sysRoleDataList.do',
	   			idField:'roleId',
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'roleId',hidden:true},
						{field:'roleName',title:'角色名称',align:'center',width:120,sortable:true},
						{field:'roleStatus',title:'角色状态',align:'center',width:120,sortable:true,styler:function(value,row,index){
								if(value == 0){
								  	return 'color:#449d44;font-weight:bold;';  
								}
								if(value == 1){
								  	return 'color:#d9534f;font-weight:bold;'; 
								}
							},
							formatter:function(value,row,index){
								if(value == 0){
									return '启用';
								}
								if(value == 1){
									return '禁用';
								}
							}},
						{field:'roleDes',title:'备注',align:'center',width:150,sortable:true}						
				]]
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();			
			_this.initTreeData();
		}
	}
	return _this;
}();

/*页面初始化*/
$(function(){
	YiYa.sysRole.init();
});		