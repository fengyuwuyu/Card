$package('YiYa.xfTime');

YiYa.xfTime = function() {
	var _box = null;
	var _this = {
		close : function() {
			YiYa.confirm('询问信息', '确认要关闭窗口吗？', function(r) {
				if (r) {
					$('#edit-win').dialog('close');
				}
			});
		},
		config : {
			showGridTitle : false,
			action : {
				save : urls['msUrl'] + 'xfTimeController/save.do',// 保存Action
				getById : urls['msUrl'] + 'xfTimeController/getById.do',// 查询Action
				remove : urls['msUrl'] + 'xfTimeController/remove.do'
			},
			dataGrid : {
				height : 425,
				url : urls['msUrl'] + 'messConsumeController/messTimeList.do',
				idField : 'bh',
				singleSelect : true,
				columns : [ [ {
					field : 'ck',
					checkbox : true
				}, {
					field : 'lname',
					title : '餐类',
					align : 'center',
					width : 120,
					sortable : true
				}, {
					field : 'kssj',
					title : '开始时间',
					align : 'center',
					width : 80,
					sortable : true
				}, {
					field : 'jssj',
					title : '结束时间',
					align : 'center',
					width : 60,
					sortable : true
				}, {
					field : 'sj',
					title : '添加时间',
					align : 'center',
					width : 120,
					sortable : true
				} ] ],
			}
		},
		init : function() {
			_box = new YDataGrid(_this.config);
			_box.init();
//			$('#btn-save').hide();
//			$('#btn-close').hide();
		}
	};
	return _this;
}();

/* 页面初始化 */
$(function() {
	YiYa.xfTime.init();
});