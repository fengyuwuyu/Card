/*声明命名空间*/
$package('YiYa.kqSjManage');

/*封装变量（利用匿名自执行函数）*/
YiYa.kqSjManage = function(){
	var _box = null;
	var _this = {
		config:{
			action:{
  				save:urls['msUrl'] + 'kqRecordController/kqSjManageSave.do',//保存Action  
  				getById:urls['msUrl'] + 'kqRecordController/kqSjManageGetById.do',//查询Action
  			},	
  			event : {
  				edit:function(){
					_box.handler.edit(function(result){//调用edit方法
						var rows = _box.utils.getCheckedRows();
						if(_box.utils.checkSelectOne(rows)){
							_box.win.edit.window('open');
						}
					});
				},
				save:function(){	
					_box.handler.save()//调用save方法;
				}
  			},
  			dataGrid:{
	   			url: urls['msUrl'] + 'kqRecordController/kqSjManageDataList.do',
	   			idField:'id',
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'id',hidden:true},
						{field:'type',title:'时间类型',align:'center',width:120,sortable:true,
							formatter:function(value,row,index){
								if(value == 1){
									return '上班时间';
								}
								if(value == 2){
									return '下班时间';
								}
							}},
						{field:'sj',title:'时间',align:'center',width:150,sortable:true}						
				]],
				toolbar : [{
  					id : 'btn-edit',
  					text : '修改',
  					btnType:'edit',
  					iconCls : 'icon-edit'
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
	YiYa.kqSjManage.init();
});		