/*声明命名空间*/
$package('YiYa.time');

/*封装变量（匿名自执行函数）*/
YiYa.time = function(){
	var _box = null;
	var _this = {
		config:{
			action:{
  				save:urls['msUrl'] + 'cardController/timeSave.do',//保存Action  
  				getById:urls['msUrl'] + 'cardController/timeGetById.do',//查询Action
  				remove:urls['msUrl'] + 'impowerController/recordDelete.do'//删除Action
  			},	
  			dataGrid:{
	   			url:urls['msUrl'] + 'impowerController/recordDataList.do',
	   			idField:'xh',
	   			singleSelect:false,
	   			columns:[[
	   			          {field:'ck',checkbox:true},
	   			          {field:'xh',hidden:true},
	   			          {field:'userLname',title:'用户',align:'center',width:150,sortable:true},
	   			          {field:'depName',title:'部门',align:'center',width:150,sortable:true},
	   			          {field:'doorName',title:'门',align:'center',width:150,sortable:true},
	   			          {field:'acDepName',title:'场所',align:'center',width:150,sortable:true},
	   			          {field:'fx',title:'方向',align:'center',width:150,sortable:true,styler:function(value,row,index){
								if(value == 0){
								  	return 'color:#f0ad4e;font-weight:bold;';  
								}
								if(value == 1){
								  	return 'color:#449d44;font-weight:bold;'; 
								}
							},formatter:function(value,row,index){
								if(value == 0){
									return '进门';
								}
								if(value == 1){
									return '出门';
								}
							}},
	   			          {field:'ruleName',title:'规则',align:'center',width:150,sortable:true},
	   			          {field:'sj',title:'操作时间',align:'center',width:150,sortable:true}
						]],
				toolbar:[
							{id:'btn-delete',text:'取消授权',btnType:'delete',iconCls:'icon-delete',handler:function(){var checked = _box.utils.getCheckedRows();if ( _box.utils.checkSelect(checked)){YiYa.confirm('询问信息','确认要取消授权记录吗？',function(r){if (r){var xhs = '';$.each(checked, function(i, n){if(xhs.length == 0){xhs = xhs + n.xh;}else{xhs = xhs + ',' + n.xh;}});var option = {};option['xhs'] = xhs;YiYa.progress('请求中...');YiYa.ajaxJson(urls['msUrl'] + 'impowerController/recordDelete.do',option,function(data){if(data.success){$('#data-list').datagrid('reload');}else{YiYa.alert('提示信息',data.msg,'info');}});}});}}}
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
	YiYa.time.init();
});		