/*声明命名空间*/
$package('YiYa.record');

/*封装变量（匿名自执行函数）*/
YiYa.record = function(){
	var _box = null;
	var _this = {
		config:{
  			dataGrid:{
	   			url:urls['msUrl'] + 'visitorController/recordDataList.do',
	   			idField:'recordId',
	   			columns:[[
	   			          {field:'ck',checkbox:true},
	   			          {field:'recordId',hidden:true},
	   			          {field:'userLname',title:'姓名',align:'center',width:70,sortable:true},
	   			          {field:'userSex',title:'性别',align:'center',width:50,sortable:true},
	   			          {field:'userTelephone',title:'电话',align:'center',width:100,sortable:true},
	   			          {field:'userDepname',title:'单位',align:'center',width:100,sortable:true},
	   			          {field:'time',title:'访问时间',align:'center',width:120,sortable:true},
	   			          {field:'visitorReason',title:'来访是由',align:'center',width:100,sortable:true},
	   			          {field:'visitorUser',title:'受访人员',align:'center',width:70,sortable:true},	   			          
	   			          {field:'visitorPhone',title:'受访人员电话',align:'center',width:100,sortable:true},
	   			          {field:'visitorDep',title:'受访单位',align:'center',width:100,sortable:true},
	   			          {field:'visitorDes',title:'来访备注',align:'center',width:150,sortable:true}
						]],
				toolbar:[
							{id:'btn-export',text:'导出',btnType:'export',iconCls:'icon-uncompress',handler:function(){YiYa.confirm('询问信息','确认查询条件与要导出的数据一致？',function(r){if(r){$('#searchForm').attr('action',urls['msUrl'] + 'visitorController/recordExport.do');$('#searchForm').submit();}});}}
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
	YiYa.record.init();
});		