/*声明命名空间*/
$package('YiYa.rule');

/*封装变量（匿名自执行函数）*/
YiYa.rule = function(){
	var _box = null;
	var _this = {
		config:{
  			dataGrid:{
	   			url:urls['msUrl'] + 'parameterController/ruleDataList.do',
	   			idField:'bh',
	   			columns:[[
	   			          {field:'ck',checkbox:true,rowspan:2},
	   			          {field:'bh',hidden:true,rowspan:2},
	   			          {field:'sdName',title:'时段名称',align:'center',width:65,sortable:true,rowspan:2},
	   			          {field:'ruleName',title:'规则名称',align:'center',width:65,sortable:true,rowspan:2},
	   			          {field:'kssj',title:'开始时间',align:'center',width:80,sortable:true,rowspan:2},
	   			          {field:'jssj',title:'结束时间',align:'center',width:80,sortable:true,rowspan:2},
	   			          {title:'每年',align:'center',colspan:2},
	   			          {title:'每月',align:'center',colspan:2},
	   			          {title:'每周',align:'center',colspan:2},
	   			          {title:'每日',align:'center',colspan:2}
						],[
						  {field:'ksMonth',title:'开始月份',align:'center',width:65,sortable:true},
						  {field:'jsMonth',title:'结束月份',align:'center',width:65,sortable:true},
						  {field:'ksDay',title:'开始日期',align:'center',width:65,sortable:true},
						  {field:'jsDay',title:'结束日期',align:'center',width:65,sortable:true},
						  {field:'ksWeek',title:'开始日期',align:'center',width:65,sortable:true},
						  {field:'jsWeek',title:'结束日期',align:'center',width:65,sortable:true},
						  {field:'ksSj1',title:'开始时间',align:'center',width:65,sortable:true},
						  {field:'jsSj1',title:'结束时间',align:'center',width:65,sortable:true}
						]],
  				toolbar:[
						{id:'btn-add',text:'添加',btnType:'add',handler:function(){YiYa.alert('警告信息','默认规则无法添加时段！','warning');}},
						{id:'btn-edit',text:'修改',btnType:'edit',handler:function(){var checked = _box.utils.getCheckedRows();if ( _box.utils.checkSelectOne(checked)){YiYa.alert('警告信息','默认规则无法修改时段！','warning');}	}},
						{id:'btn-remove',text:'删除',btnType:'remove',handler:function(){	var checked = _box.utils.getCheckedRows();if ( _box.utils.checkSelectOne(checked)){YiYa.alert('警告信息','默认规则无法删除时段！','warning');}}}
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
	YiYa.rule.init();
});		