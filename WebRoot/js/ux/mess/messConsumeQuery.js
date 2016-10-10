$package('YiYa.mess');

YiYa.mess = {
		init : function(){
			var personal = $('#personal').attr('value');
			$('#btn-export').hide();
			$('#btn-exportword').hide();
			$('#depNo').combobox('setValue','00');
			$('#machineBh').combobox('setValue','00');
			$('#type').combobox({
				method:'get',
				panelHeight:'auto',
				url:urls['msUrl'] + 'messConsumeController/timeLoad.do',
				valueField:'value',
				textField:'text',
				editable:false,
				formatter: function(row){
					if(row.text=='非时段'){
						row.text = '全部';
					}
					return row.text;
				}
			});
			
			$('#type').combobox('setValue','0000000000000000');
			if(personal!=1){
				depSerialCon();
			}
			
			$('#data-list').datagrid({
				title : '数据表格',
				iconCls : 'icon-grid',
				height : 360,
				width : 1100,
				fitColumns : true,
				nowrap : false,
				autoRowHeight : true,
				striped : true,
				remoteSort : false,
				pagination : true,
				rownumbers : true,
				singleSelect : true,
				showFooter : true,
				checkOnSelect : true,
				selectOnCheck : true,
				url : urls['msUrl'] + 'messConsumeController/dataList.do',
				method : 'post',
				loadMsg : '正在处理 ... ',
				columns : [ [ 
				{
					field : 'company',
					title : '所属二级公司',
					align : 'center',
					width : 160,
					formatter : function(value,item){
						if(value==null){
							return item.depName;
						}
						return value;
					}
				},{
					field : 'depName',
					title : '所属部门',
					align : 'center',
					width : 140
				}, {
					field : 'region',
					title : '区域',
					align : 'center',
				 width : 70
				}, {
					field : 'machine',
					title : '机器',
					align : 'center',
				 width : 70
				}, {
					field : 'username',
					title : '员工姓名',
					align : 'center',
				 width : 70
				}/*, {
					field : 'cardSerial',
					title : '员工卡号',
					align : 'center',
				 width : 70,
				}, {
					field : 'userNo',
					title : '人员编号',
					align : 'center',
				 width : 70,
				}, {
					field : 'certificateNo',
					title : '证件号码',
					align : 'center',
				 width : 100,
				}*/, {
					field : 'money',
					title : '交易金额',
					align : 'center',
				 width : 70
				}, {
					field : 'remainMoney',
					title : '余额',
					align : 'center',
				 width : 70
				}, {
					field : 'tradeDate',
					title : '交易日期',
					align : 'center',
				 width : 140
				}, {
					field : 'type',
					title : '餐类',
					align : 'center',
				 width : 70
				}
				/*, {
					field : 'operator',
					title : '操作员',
					align : 'center',
				 width : 70,
				}, {
					field : 'account',
					title : '结算账户',
					align : 'center',
				 width : 100,
				}*/ ] ]
			});
			// 查询按钮添加点击事件
			$('#btn-search').bind('click', function() {
//				if(personal!=1){
					//判断部门是否为空
//					var depSerial = $('#depSerial').combobox('getValues');
//					var username = $('#username').val();
//					if((depSerial==null||depSerial.length==0)&&(username==null||username.trim()=='')){
//						YiYa.alert("提示", "请选择部门或输入员工姓名");
//						return;
//					}
//				}
				// 判断起止时间是否为空
				var kssj = $('#kssj').datebox('getValue');
				var jssj = $('#jssj').datebox('getValue');
				if (kssj=="") {
					YiYa.alert("提示", "请输入起始日期");
					return;
				}
				if (jssj=="") {
					YiYa.alert("提示", "请输入结束日期");
					return;
				}
				var formData = $('#searchForm').serializeObject();
				formData = YiYa.filterNull(formData);
				$('#data-list').datagrid('load',formData);
				$('#btn-export').show();
				$('#btn-exportword').show();
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
};

$(function() {
	YiYa.mess.init();
	$('#menu-reset').click(function(){
		$('#depSerial').combotree('clear');
		$('#username').val('');
		$('#kssj').datebox('setValue',null);
		$('#jssj').datebox('setValue',null);
	});
});