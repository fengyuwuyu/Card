$package('YiYa.depNumQuery');

/* 页面初始化 */
$(function() {
	$('#menu-reset').click(function(){
		$('#depSerial').combotree('clear');
	});
	depSerialCon();
	$('#data-list').datagrid({
		title : '食堂用户数统计',
		iconCls : 'icon-grid',
		height : 365,
		width : 1100,
		fitColumns : true,
		nowrap : false,
		autoRowHeight : true,
		striped : true,
		pagination : true,
		collapsible : true,
		remoteSort : false,
		showFooter : true,
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		selectOnCheck : true,
		url : urls['msUrl'] + 'messConsumeController/depNum.do',
		method : 'post',
		loadMsg : '正在处理 ... ',
		columns : [ [ {
			field : 'depSerial',
			hidden : 'true'
		}, {
			field : 'depName',
			title : '部门名称',
			align : 'center',
			width : 150
		}, {
			field : 'depNo',
			title : '部门编号',
			align : 'center',
			width : 150
		}, {
			field : 'depParent',
			title : '上级部门',
			align : 'center',
			width : 150,
			formatter : function(value){
				if(!value){
					return '';
				}
				return value;
			}
		}, {
			field : 'num',
			title : '可用餐人数',
			align : 'center',
			width : 150
		} ] ]
	});

	$('#btn-search').bind('click', function() {
		var formData = $('#searchForm').serializeObject();
		formData = YiYa.filterNull(formData);
		$('#data-list').datagrid('load',formData);
	});
});