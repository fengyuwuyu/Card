/*声明命名空间*/
$package('YiYa.openCard');

/* 封装变量（匿名自执行函数） */
YiYa.openCard = function() {
	var _box = null;
	var _this = {
		toContinue : function(isContinue) {
			if (isContinue) {
				var checked = _box.utils.getCheckedRows();
				if (_box.utils.checkSelectOne(checked)) {
					if (_box.utils.checkNextOne(checked)) {
						_box.handler.edit(function(result) {// 调用edit方法
							$('.readCardMessage').html('请连接读卡器，然后点击开卡。');
							$('#btn-openCard').linkbutton('enable');
							$('#isContinue').prop('checked', true);
						});
					}
				}
			}
		},
		config : {
			action : {
				getById : urls['msUrl'] + 'cardController/dtUserGetById.do',// 查询Action
			},
			event : {
				close : function() {
					_box.handler.close(function() {// 调用close方法
						_box.handler.refresh();
					});
				}
			},
			dataGrid : {
				url : urls['msUrl'] + 'cardController/dtUserDataList.do',
				idField : 'userSerial',
				columns : [ [ {
					field : 'ck',
					checkbox : true
				}, {
					field : 'userSerial',
					hidden : true
				}, {
					field : 'userNo',
					title : '工号',
					align : 'center',
					width : 80,
					sortable : true
				}, {
					field : 'userLname',
					title : '姓名',
					align : 'center',
					width : 80,
					sortable : true
				}, {
					field : 'userSex',
					title : '性别',
					align : 'center',
					width : 60,
					sortable : true
				}, {
					field : 'userTelephone',
					title : '电话',
					align : 'center',
					width : 120,
					sortable : true
				}, {
					field : 'userDuty',
					title : '职务',
					align : 'center',
					width : 120,
					sortable : true
				}, {
					field : 'userDepname',
					title : '部门',
					align : 'center',
					width : 120,
					sortable : true
				}, {
					field : 'acName',
					title : '账户类型',
					align : 'center',
					width : 120,
					sortable : true
				}, {
					field : 'userTypeName',
					title : '状态',
					align : 'center',
					width : 120,
					sortable : true
				} ] ],
				toolbar : [ {
					id : 'btn-open',
					text : '开卡',
					btnType : 'open',
					iconCls : 'icon-open',
					handler : function() {
						var checked = _box.utils.getCheckedRows();
						if (_box.utils.checkSelectOne(checked)) {
							_box.handler.edit(function(result) {
								$('.readCardMessage').html('请连接读卡器，然后点击开卡。');
								$('#btn-openCard').linkbutton('enable');
							});
						}
					}
				} ]
			}
		},
		init : function() {
			_box = new YDataGrid(_this.config);
			_box.init();
			$('#btn-openCard').click(
					function() {
						YiYa.readCard(YiYa.port, 'readCardMessage', function(
								physicsCard) {
							$('.readCardMessage').html(physicsCard);
						});
					});
		}
	}
	return _this;
}();

/* 页面初始化 */
$(function() {
	YiYa.openCard.init();
});