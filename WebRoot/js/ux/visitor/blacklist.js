/*声明命名空间*/
$package('YiYa.blacklist');

/*封装变量（匿名自执行函数）*/
YiYa.blacklist = function(){
	var _box = null;
	var _this = {
		config:{
  			dataGrid:{
	   			url:urls['msUrl'] + 'visitorController/visitorDataList2.do',
	   			idField:'id',
	   			columns:[[
	   			          {field:'ck',checkbox:true},
	   			          {field:'id',hidden:true},
	   			          {field:'userLname',title:'姓名',align:'center',width:80,sortable:true},
	   			          {field:'userSex',title:'性别',align:'center',width:60,sortable:true},
	   			          {field:'userTelephone',title:'电话',align:'center',width:100,sortable:true},
	   			          {field:'userId',title:'身份证号',align:'center',width:100,sortable:true},
	   			          {field:'userDepname',title:'单位',align:'center',width:100,sortable:true},
	   			          {field:'count',title:'开卡',align:'center',width:60,sortable:true,formatter:function(value,row,index){							  						  
							  return value + '次';
						  }}, 
	   			          {field:'autoCount',title:'系统退卡',align:'center',width:60,sortable:true,formatter:function(value,row,index){							  						  
	   			        	  return value + '次';
						  }}, 
	   			          {field:'manualCount',title:'手动还卡',align:'center',width:60,sortable:true,formatter:function(value,row,index){							  						  
	   			        	  return value + '次';
						  }}, 
						  {field:'notReturnCount',title:'未还卡',align:'center',width:60,sortable:true,formatter:function(value,row,index){							  						  
							  var count = row.count-row.autoCount-row.manualCount;
	   			        	  return count + '次';
						  }}, 
	   			          {field:'userSj',title:'登记|修改时间',align:'center',width:120,sortable:true}
						]],
				toolbar:[
							{id:'btn-remove',text:'移除黑名单<div style="color:red;display:inline">（未还卡）</div>',btnType:'remove',iconCls:'icon-register3',handler:function(){
								var checked = _box.utils.getCheckedRows();
								if ( _box.utils.checkSelectOne(checked)){
									YiYa.confirm('询问信息','确认访客未还卡，并将其移除黑名单吗？',function(r){
										if(r){
											var option ={};
											option['userSerial'] = checked[0]['userSerial'];
											YiYa.remove(urls['msUrl'] + 'visitorController/visitorDelete.do',option,function(result){
												_box.handler.refresh();
												});
											}
										});
									}
								}
							},
							{id:'btn-remove2',text:'移除黑名单<div style="color:blue;display:inline">（还卡）</div>',btnType:'remove2',iconCls:'icon-register4',handler:function(){var checked = _box.utils.getCheckedRows();if ( _box.utils.checkSelectOne(checked)){YiYa.confirm('询问信息','确认访客已还卡，并将其移除黑名单吗？',function(r){if(r){var option ={};option['userSerial'] = checked[0]['userSerial'];option['manualCount'] = 1;YiYa.remove(urls['msUrl'] + 'visitorController/visitorDelete.do',option,function(result){_box.handler.refresh();});}});}}},
							{id:'btn-export',text:'导出',btnType:'export',iconCls:'icon-uncompress',handler:function(){YiYa.confirm('询问信息','确认查询条件与要导出的数据一致？',function(r){if(r){$('#searchForm').attr('action',urls['msUrl'] + 'visitorController/visitorExport2.do');$('#searchForm').submit();}});}}
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
	YiYa.blacklist.init();
});		