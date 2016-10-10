/*声明命名空间*/
$package('YiYa.Region');

/*封装变量（匿名自执行函数）*/
YiYa.Region = function(){
	var _box = null;
	var _this = {
			config:{
				action:{
	  				save:urls['msUrl'] + 'regionController/save.do',//保存Action  
	  				getById:urls['msUrl'] + 'regionController/getById.do',//查询Action
	  				remove : urls['msUrl'] + 'regionController/delete.do'
	  			},	
	  			event : {
	  				edit : function(){
	  					var rows = _box.utils.getSelectedRows();
	  					if(_box.utils.checkSelectOne(rows)){
	  						var data ={};
							var idKey = _this.config.treeGrid.idField || 'id';//主键名称
		 					data[idKey] = (rows[0][idKey]);
							YiYa.getById(_this.config.action.getById,data,function(result){
								_box.form.edit.form('reset');
								_box.form.edit.form('load',result.data);									
								_box.win.edit.dialog('open'); 
								_this.initEditWin(2, rows);
							});
	  					}
	  				},
	  				add : function(){
	  					var rows = _box.utils.getSelectedRows();
	  					if(_box.utils.checkSelectOne(rows)){
	  					$('#editForm').form('reset');
	  					$('#edit-win').dialog('open');
	  						_this.initEditWin(1, rows);
//	  						
	  					}
	  				}
	  			},
	  			treeGrid:{
		   			url:urls['msUrl'] + 'regionController/dataList.do',
		   			idField : 'depSerial',
		   			treeField : 'depName',
		   			pagination:"false",
		   			columns:[[
							{field:'ck',checkbox:true},
							{field:'depSerial',hidden:true},
							{field:'depParent',hidden:true},
							{field:'depName',title:'场所名称',align:'left',width:80,sortable:true},
							{field:'depNo',title:'场所编号',align:'center',width:100,sortable:true},
							{field:'parentName',title:'上级场所',align:'center',width:80,sortable:true},
							{field:'moduleId',title:'场所类型',align:'center',width:60,sortable:true,formatter:function(value){
								if(value=='0025'){
									return "默认场所";
								}else if(value=='0004'){
									return "餐厅场所";
								}else if(value=='0005'){
									return "门禁场所";
								}else if(value=='0017'){
									return "会议场所";
								}
							}},
					]]
				}
			},
			initEditWin : function(type,rows){
					if(type==1){
						var depSerial = rows[0].depSerial;
						$('#depParent').combotree('setValue',depSerial);
					}else{
						var depParent = rows[0].depParent;
						if(depParent!=0){
							$('#depParent').combotree('setValue',depParent);
						}
					}
			},
			init:function(){
				_box = new YTreeGrid(_this.config); 
				_box.init();
			}
	}
	return _this;
}();

/*页面初始化*/
$(function(){
	YiYa.Region.init();
});		