$package('YiYa.statistics');

YiYa.statistics = {
		top : 50,
		showTable : function(statisticsInfo) {
			// 清除上次查询添加的表格
			$("#data-statistics tr:not(:first)").remove();
			var type = $('#type').combobox('getValue');
			var table = $("#data-statistics");
			$('#depInfo').html(statisticsInfo.depInfo);
			$('#personNum').html(statisticsInfo.personNum);
			$('#dateInfo').html(statisticsInfo.dateInfo);
			if (type == 1) {
				var tr = $('<tr></tr>');
				var td = $('<td colspan="3">' + "全勤人员" + '</td>');
				td.appendTo(tr);
				tr.appendTo(table);
			}
			if (statisticsInfo.allWorkInfo) {
				this.top = 50;
				var usernames = statisticsInfo.allWorkInfo.split(',');
				if (usernames.length > 0 && usernames[0] != "") {
					for (var i = 0; i < usernames.length; i++) {
						var tr = $('<tr></tr>');
						var td = $('<td colspan="3">' + usernames[i] + '</td>');
						td.appendTo(tr);
						tr.appendTo(table);
						this.top+=20;
					}
				}
			}
			table.show();
		},
		// 格式化时间
		formatDate : function(date) {
			if (date && date.length > 10) {
				var kssj = $('#kssj').datebox('getValue');
				var jssj = $('#jssj').datebox('getValue');
				var year_kssj = kssj.substr(0, 5);
				var year_jssj = jssj.substr(0, 5);
				var second = ((Math.random() * 50 + 10) + '').substr(0, 2);
				if (year_kssj != year_jssj) {
					var month_kssj = kssj.substr(5, 2);
					var month_date = date.split('-')[0];
					if (month_date < month_kssj) {
						return year_jssj + '-' + date + ':' + second;
					}
				} else {
					return year_kssj + date + ':' + second;
				}
			}
			return date;
		},
		onLoadSuccess : function(data) {
			// datagrid头部 table 的第一个tr的td们，即columns的集合
			var headerTds = $(".datagrid-header-inner table tr:first-child").children();
			// datagrid主体 table 的第一个tr的td们，即第一个数据行
			var bodyTds = $(".datagrid-body table tr:first-child").children();
			bodyTds.each(function(i, obj) {
				var headerTd = $(headerTds.get(i));
				var bodyTd = $(bodyTds.get(i));
				var headerTdWidth = headerTd.width();
				bodyTd.width(headerTdWidth);
			});
			var statisticsInfo = data.statisticsInfo;
			if (statisticsInfo) {
				YiYa.statistics.showTable(statisticsInfo);
			}
		},
		initSearchForm : function() {
			$('#sbsj').combobox({
				valueField : 'time',
				textField : 'time',
				panelMinHeight : 20,
				panelHeight : 'auto',
				url : urls['msUrl'] + 'kqRecordController/sbsj.do',
				value : '09:05:00',
				editable : false
			});
			$('#xbsj').combobox({
				valueField : 'time',
				textField : 'time',
				panelMinHeight : 20,
				panelHeight : 'auto',
				url : urls['msUrl'] + 'kqRecordController/xbsj.do',
				value : '16:55:00',
				editable : false
			});
			$('#kqDescribe').combobox({
				valueField : 'id',
				textField : 'time',
				panelMinHeight : 20,
				panelHeight : 'auto',
				url : urls['msUrl'] + 'kqRecordController/kqDescribe.do',
				editable : false
			});
			$('#type').combobox('setValue', 1);
		},
		showDetail : function(config) {
			var type = config.split('**')[1];
			var url = config.split('**')[0];
			var title = '';
			if (type == 1) {
				title = '迟到';
			} else if (type == 2) {
				title = '早退';
			} else if (type == 3) {
				title = '外出';
			} else {
				title = '加班';
			}
			$('#tab-box').scrollTop(this.top);
			$('#personalDetailJb').window(
					{
						title : '个人' + title + '记录查询结果　　日期:'
								+ $('#kssj').datebox('getValue') + '至'
								+ $('#jssj').datebox('getValue'),
						width : 1000,
						height : 450,
//						top : this.top,
						href : url,
						draggable : false,
						minimizable : false,
						maximizable : false,
						collapsible : false,
						closable : true,
						modal : true,
					});
		}
		
};



/* 页面初始化 */
$(function() {
	$('#data-statistics').hide();
	$('#btn-export').hide();
	depSerialCon();
	var datagrid1 = $('#data-list1');
	var datagrid2 = $('#data-list2');
	var panel1 = $('#panel1');
	var panel2 = $('#panel2');
	panel2.hide();
	// 初始化查询表单控件
	YiYa.statistics.initSearchForm();
	datagrid1.datagrid({
//				view : scrollview,
				height : 420,
				width : 1100,
				url : urls['msUrl'] + 'kqRecordController/dataList.do',
				striped : true,
				fitColumns : true,
//				pageSize : 30,
//				rownumbers : true,
				singleSelect : true,
				loadMsg : '正在处理 ... ',
				idField : 'userSerial',
				columns : [ [
						{
							field : 'userSerial',
							hidden : true
						},
						{
							field : 'username',
							title : '员工姓名',
							align : 'center',
							width : 70,
						},
						{
							field : 'depName',
							title : '所属部门',
							align : 'center',
							width : 130,
						},
						{
							field : 'lateCount',
							title : '晚到（次）',
							align : 'center',
							width : 50,
							formatter : function(value, row, index) {
								if (value == 0) {
									return 0;
								}
								if (typeof value != 'number') {
									return value;
								}
								var url = urls['msUrl']
										+ 'kqRecordController/personalQuery.do?username='
										+ encodeURI(row['username']) + '&kssj='
										+ $('#kssj').datebox('getValue')
										+ '&jssj=' + $('#jssj').datebox('getValue')
										+ '&depName='
										+ encodeURI(row['depName']) + '&cardSerial='
										+ row['cardSerial'] + '&userSerial='
										+ row['userSerial'] 
								+ '&dates=' + row.lateTimes.replace(/<br>/g, '') + '&queryType=1' + '**1';
								return "<a href='#' onclick='YiYa.statistics.showDetail(\""
										+ url + "\");'>" + value + "</a>";
							}
						},
						{
							field : 'lateTimes',
							title : '晚到日期',
							align : 'center',
							width : 170,
						},
						{
							field : 'leaveEarlyCount',
							title : '早退（次）',
							align : 'center',
							width : 50,
							formatter : function(value, row, index) {
								if (value == 0) {
									return 0;
								}
								if (typeof value != 'number') {
									return value;
								}
								var url = urls['msUrl']
										+ 'kqRecordController/personalQuery.do?username='
										+ encodeURI(row['username'])
										+ '&depName='
										+ encodeURI(row['depName'])
										+ '&cardSerial='
										+ row['cardSerial']
										+ '&userSerial='
										+ row['userSerial']
										+ '&kssj='
										+ $('#kssj').datebox('getValue')
										+ '&jssj='
										+ $('#jssj').datebox('getValue')
										+ '&dates='
										+ row.leaveEarlyTimes.replace(/<br>/g,'') 
										+ '&queryType=2' + '**2';
								return "<a href='#' onclick='YiYa.statistics.showDetail(\""
										+ url + "\");'>" + value + "</a>";
							}
						},
						{
							field : 'leaveEarlyTimes',
							title : '早退日期',
							align : 'center',
							width : 170,
						},
						{
							field : 'goOutCount',
							title : '外出（次）',
							align : 'center',
							width : 50,
							formatter : function(value, row, index) {
								if (value == 0) {
									return 0;
								}
								if (typeof value != 'number') {
									return value;
								}
								var url = urls['msUrl']
										+ 'kqRecordController/personalQuery.do?username='
										+ encodeURI(row['username']) + '&depName='
										+ encodeURI(row['depName']) + '&cardSerial='
										+ row['cardSerial'] + '&userSerial='
										+ row['userSerial'] + '&kssj='
										+ $('#kssj').datebox('getValue')
										+ '&jssj='
										+ $('#jssj').datebox('getValue')
										+ '&dates='
										+ row.goOutTimes.replace(/<br>/g, '')
										+ '&queryType=3' + '**3';
								return "<a href='#' onclick='YiYa.statistics.showDetail(\""
										+ url + "\");'>" + value + "</a>";
							}
						}, {
							field : 'goOutTimes',
							title : '外出日期',
							align : 'center',
							width : 120,
						} ] ],
				onLoadSuccess : YiYa.statistics.onLoadSuccess
			});

	datagrid2.datagrid({
//				view : scrollview,
				height : 420,
				width : 1100,
				url : urls['msUrl'] + 'kqRecordController/dataList.do',
				striped : true,
				fitColumns : true,
//				pageSize : 30,
				singleSelect : true,
				loadMsg : '正在处理 ... ',
				idField : 'userSerial',
				columns : [ [
						{
							field : 'userSerial',
							hidden : true
						},
						{
							field : 'username',
							title : '员工姓名',
							align : 'center',
							width : 80,
						},
						{
							field : 'depName',
							title : '所属部门',
							align : 'center',
							width : 80,
						},
						{
							field : 'jbCount',
							title : '加班（次）',
							align : 'center',
							width : 50,
							formatter : function(value, row, index) {
								if (value == 0) {
									return 0;
								}
								if (typeof value != 'number') {
									return value;
								}
								var url = urls['msUrl']
										+ 'kqRecordController/personalQuery.do?username='
										+ encodeURI(row['username']) + '&depName='
										+ encodeURI(row['depName']) + '&cardSerial='
										+ row['cardSerial'] + '&userSerial='
										+ row['userSerial'] + '&kssj='
										+ $('#kssj').datebox('getValue')
										+ '&jssj='
										+ $('#jssj').datebox('getValue')
										+ '&queryType=4' + '**4';
								return "<a href='#' onclick='YiYa.statistics.showDetail(\""
										+ url + "\");'>" + value + "</a>";
							}
						}, {
							field : 'jbTimes',
							title : '加班日期',
							align : 'center',
							width : 160,
						} ] ],
				onLoadSuccess : YiYa.statistics.onLoadSuccess
			});

	// 查询按钮添加点击事件
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
		var type = $('#type').combobox('getValue');
		var formData = $('#searchForm').serializeObject();
		var depSerial = formData.depSerial;
		formData = YiYa.filterNull(formData);
		if (depSerial && (typeof depSerial) != 'string') {
			formData.depSerial = depSerial.join(',');
		}
		if (type == 1) {
			panel1.show();
			panel2.hide();
			datagrid1.datagrid('reload', formData);
		} else {
			panel2.show();
			panel1.hide();
			datagrid2.datagrid('reload', formData);
		}
		$('#btn-export').show();
	});

	// 给清空按钮添加事件
	$('#btn-reset').click(function() {
		$('#depSerial').combotree('clear');
		$('#username').val('');
		$('#kssj').datebox('setValue',null);
		$('#jssj').datebox('setValue',null);
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
});
