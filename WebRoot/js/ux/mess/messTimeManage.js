$package('YiYa.messTimeManage');

YiYa.messTimeManage.initWin  = function(){
	$('#edit-win').dialog('close');
	//设置保存,关闭按钮
	$('#edit-win').dialog({
		buttons:[
			{
				text:'保存',
				handler:function(){
					var form = $('#editForm');
					if(form.form('validate')){
						form.form('submit',{
							url :  urls['msUrl'] + 'messConsumeController/saveDevTime.do',
							success:function(data){   
								data = $.parseJSON(data);
						        if(data&&data.msg){
						        	$('#edit-win').dialog('close');
						        	YiYa.alert("标题", data.msg);
						        	$('#data-list').datagrid('reload');
						        }else{
						        	YiYa.alert("标题", "服务器内部错误");
						        }
						    }   
						});
					 }
				}
			},
			{
				text:'关闭',
				handler:function(){
					$('#edit-win').dialog('close');
				}
			}
		]
	});
};

/* 页面初始化 */
$(function() {
	//隐藏弹出框
	YiYa.messTimeManage.initWin();
	$('#data-list').datagrid({
		title : '就餐时间设置',
		iconCls : 'icon-grid',
		height : 425,
		width : 1100,
		fitColumns : true,
		pagination : true,
		nowrap : false,
		autoRowHeight : true,
		striped : true,
		collapsible : true,
		remoteSort : false,
		showFooter : true,
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		selectOnCheck : true,
		url : urls['msUrl'] + 'messConsumeController/regionList.do',
		method : 'post',
		loadMsg : '正在处理 ... ',
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'depSerial',
			hidden : 'true'
		}, {
			field : 'depName',
			title : '就餐区域',
			align : 'center',
			width : 150,
		}, {
			field : 'depNo',
			title : '区域编号',
			align : 'center',
			width : 150,
		}, {
			field : 'parentName',
			title : '上级区域',
			align : 'center',
			width : 150,
		}, {
			field : 'times',
			title : '餐类',
			align : 'center',
			width : 150,
		} ] ],
		toolbar : [ {
			id : 'btn-edit',
			text : '设置就餐时段',
			btnType : 'edit',
			iconCls : 'icon-edit',
			handler : function() {
				var row = $('#data-list').datagrid('getSelected');
				if(!row||row.length<1){
					YiYa.alert('警告信息','未选中记录！','warning');  
					return false;
				}
				$('#edit-win').dialog('open');
				var depSerial = row.depSerial;
				$('#depSerial').val(depSerial);
				$('#depName').val(row.depName);
				$('#times').val(row.times);
				$.ajax({
					url : urls['msUrl'] + 'xfTimeController/getExternalXfTimes.do',
					method : 'post',
					data : {'depSerial':depSerial},
					success : function(data){
						if(data.success){
							$('#addTimes').combobox({
								multiple : true,
								panelHeight:'auto',
								data : data.data,
								valueField : 'bh',
								textField : 'lname'
							});
						}else{
							YiYa.alert("提示", "系统异常，请联系管理员！");
						}
					}
				});
			}
		} ]
	});

	$('#btn-search').bind('click', function() {
		var formData = $('#searchForm').serializeObject();
		formData = YiYa.filterNull(formData);
		$('#data-list').datagrid('load', formData);
	});
	$('#menu-reset').click(function(){
		$('#depNo').combobox('clear');
	});
});