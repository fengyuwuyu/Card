$package('YiYa.mess');
YiYa.mess = {
		validateSearchForm : function(){
			var statisticType = $('#statisticType').combobox('getValue');
			if(statisticType==1){
				var depSerial = $('#depSerial').combobox('getValues');
				if(depSerial==null||depSerial.length==0){
					YiYa.alert("提示", "请选择部门");
					return false;
				}
			}else if(statisticType==2){
				var depNo = $('#depNo').combobox('getValue');
				if(depNo==null||depNo.length==0){
					YiYa.alert("提示", "请选择区域");
				}
			}else if(statisticType==3){
				var machineBh = $('#machineBh').combobox('getValue');
				if(machineBh==null||machineBh.length==0){
					YiYa.alert("提示", "请选择设备");
				}
			}else {
				return false;
			}
			return true;
		},
		showDateColumn : function(){
			var byDay = $('input[name="byDay"]:checked').val();
			if(byDay=='on'){
				$('#data-list').datagrid('showColumn','date');
			}else{
				$('#data-list').datagrid('hideColumn','date');
			}
		},
		initSearchForm : function(){
			$('#btn-export').hide();
			$('#btn-exportword').hide();
			var personal = $('#personal').attr('value');
//			if(personal==1){
//				$('#statisticType').combobox('setValue','3');
//			}else{
			if(personal!=1){
				$('#statisticType').combobox('setValue','1');
			}
//			}
			$('#depNo').combobox('setValue','00');
			$('#machineBh').combobox('setValue','00');
			$('#type').combobox('setValue','0000000000000000');
		}
};

$(function() {
	depSerialCon();
	$('#data-list').datagrid({
//		title : '营业报表',
		iconCls : 'icon-grid',
		height : 375,
		width : 1100,
		fitColumns : true,
		nowrap : false,
		autoRowHeight : true,
		striped : true,
		collapsible : true,
		remoteSort : false,
		pagination : true,
		showFooter : true,
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		selectOnCheck : true,
		url : urls['msUrl'] + 'messConsumeController/statistics.do',
		method : 'post',
		loadMsg : '正在处理 ... '/*,
		columns : [[{
			field:'date',title:'日期',align:'center',width:100,sortable:true,rowspan:2
		},{
			field:'depName',title:'所属部门',align:'center',width:80,sortable:true,rowspan:2
		},{
			field:'region',title:'区域',align:'center',width:80,sortable:true,rowspan:2
		},{
			field:'machine',title:'机器',align:'center',width:80,sortable:true,rowspan:2
		},{
			field:'zaocMoney',title:'早餐',align:'center',width:60,sortable:true,rowspan:2
		},{
			field:'zaocCount',title:'早餐笔数',align:'center',width:60,sortable:true,rowspan:2
		},{
			field:'zcMoney',title:'中餐',align:'center',width:60,sortable:true,rowspan:2
		},{
			field:'zcCount',title:'中餐笔数',align:'center',width:60,sortable:true,rowspan:2
		},{
			field:'wcMoney',title:'晚餐',align:'center',width:60,sortable:true,rowspan:2
		},{
			field:'wcCount',title:'晚餐笔数',align:'center',width:60,sortable:true,rowspan:2
		},{
			field:'yxMoney',title:'夜宵',align:'center',width:60,sortable:true,rowspan:2
		},{
			field:'yxCount',title:'夜宵笔数',align:'center',width:60,sortable:true,rowspan:2
		},{
			title:'小计',align:'center',width:150,sortable:true,colspan:2
		},{
			field:'totalPrice',title:'金额小计',align:'center',width:80,sortable:true
		},{
			field:'totalCount',title:'笔数小计',align:'center',width:80,sortable:true
		} ]]*/
	});

	// 查询按钮添加点击事件
	$('#btn-search').bind('click', function() {
		//判断部门是否为空
//		if(!YiYa.mess.validateSearchForm()){
//			return false;
//		}
		// 判断起止时间是否为空
		var kssj = $('#kssj').datebox('getValue');
		var jssj = $('#jssj').datebox('getValue');
		if (kssj=="") {
			YiYa.alert("提示", "请输入起始日期");
			return false;
		}
		if (jssj=="") {
			YiYa.alert("提示", "请输入结束日期");
			return false;
		}
		YiYa.mess.showDateColumn();
		var formData = $('#searchForm').serializeObject();
		formData = YiYa.filterNull(formData);
		$('#data-list').datagrid('load',formData);
		$('#btn-export').show();
		$('#btn-exportword').show();
	});
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
	YiYa.mess.showDateColumn();
	YiYa.mess.initSearchForm();
	$('#menu-reset').click(function(){
		$('#depSerial').combotree('clear');
		$('#kssj').datebox('setValue',null);
		$('#jssj').datebox('setValue',null);
		$('#byDay').attr('checked',false);
	});
});