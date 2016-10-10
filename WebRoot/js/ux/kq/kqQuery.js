/*声明命名空间*/
$package('YiYa.query');

/*封装变量（匿名自执行函数）*/
YiYa.query = function(){
	var _box = null;
	var _this = {
		config:{
			showButton : false,
  			dataGrid:{
	   			url:urls['msUrl'] + 'kqRecordController/kqQuery.do',
	   			idField:'xh',
	   			columns:[[
	   			          {field:'ck',checkbox:true},
	   			          {field:'xh',hidden:true},
	   			          {field:'username',title:'姓名',align:'center',width:70,sortable:true},
	   			          {field:'company',title:'所属二级公司',align:'center',width:150,sortable:true},
	   			          {field:'depName',title:'所属部门',align:'center',width:100,sortable:true},
	   			          {field:'fx',title:'方向',align:'center',width:100,sortable:true},
	   			          {field:'sj',title:'刷卡时间',align:'center',width:120,sortable:true},
						]],
				toolbar:[
							{id:'btn-export',text:'导出',btnType:'export',iconCls:'icon-uncompress',handler:function(){YiYa.confirm('询问信息','确认查询条件与要导出的数据一致？',function(r){if(r){$('#searchForm').attr('action',urls['msUrl'] + 'visitorController/recordExport.do');$('#searchForm').submit();}});}}
						] 
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
			
			$('#btn-search').bind('click', function() {
				// 判断起止时间是否为空
				var kssj = $('#kssj').datebox('getValue');
				var jssj = $('#jssj').datebox('getValue');
				if (kssj == "") {
					YiYa.alert("提示", "请输入起始日期");
					return;
				}
				if (jssj == "") {
					YiYa.alert("提示", "请输入结束日期");
					return;
				}
				$('#btn-export').show();
			});
			
			// 结束时间添加onSelect事件
			$('#jssj').datebox({
				onSelect : function(date) {
					var kssj = $('#kssj').datebox('getValue');
					var year = date.getFullYear();
					var month = date.getMonth() + 1;
					month = month < 10 ? '0' + month : month;
					var day = date.getDate();
					day = day < 10 ? '0' + day : day;
					var jssj = year + '-' + month + '-' + day;
					if (jssj < kssj) {
						$('#jssj').datebox('setValue', '');
						YiYa.alert('提示', "结束时间不能小于开始时间");
					}
				},
				editable : false
			});
		}
	}
	return _this;
}();

/*页面初始化*/
$(function(){
	YiYa.query.init();
	// 给清空按钮添加事件
//	$('#btn-reset').click(function() {
//		$('#depSerial').combotree('clear');
//		$('#username').val('');
//		$('#kssj').datebox('setValue',null);
//		$('#jssj').datebox('setValue',null);
//	});

	
});		