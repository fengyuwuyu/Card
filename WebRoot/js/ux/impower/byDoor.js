/*声明命名空间*/
$package('YiYa.byDoor');

/*封装变量（匿名自执行函数）*/
YiYa.byDoor = function(){
	var _this = {
			datagridInit:function(){
				$('#data-list').datagrid({
					title:'数据表格',
					iconCls:'icon-grid',
					height:365,
					width:YiYa.fixWidth(),
					fitColumns:true,
					nowrap:false,
					autoRowHeight:false,
					striped:true,
					remoteSort:false,
					rownumbers:true,
					singleSelect:false,
					pagination:true,
					checkOnSelect:true,
					selectOnCheck:true,
					url:urls['msUrl'] + 'impowerController/doorDataList.do',
					method:'post',
					loadMsg:'加载中 ... ',
					idField:'xh',
					columns:[[
					          {field:'ck',checkbox:true},
					          {field:'xh',hidden:true},
					          {field:'doorName',title:'名称',align:'center',width:80,sortable:true},
					          {field:'depName',title:'所在场所',align:'center',width:60,sortable:true},
					          {field:'devName',title:'所属门控',align:'center',width:60,sortable:true},
					          {field:'sj',title:'操作时间',align:'center',width:60,sortable:true}
							]],
					toolbar:'#tb',
					onLoadSuccess:function(row,data){
						$('#data-list').datagrid('clearSelections');
						$('#data-list').datagrid('clearChecked');
					}
				});		
			},
			datagridInit2:function(){
				$('#data-list3').datagrid({
					height:213,
					width:'auto',
					fitColumns:true,
					nowrap:false,
					autoRowHeight:false,
					striped:true,
					remoteSort:false,
					rownumbers:true,
					singleSelect:false,
					pagination:true,
					checkOnSelect:true,
					selectOnCheck:true,
					pageSize:5,
					pageList:[5,10,20,30,40,50],
					url:urls['msUrl'] + 'impowerController/dtUserDataList.do',
					method:'post',
					loadMsg:'加载中 ... ',
					idField:'userSerial',
					columns:[[
					          {field:'ck',checkbox:true},
					          {field:'userSerial',hidden:true},
					          {field:'userNo',title:'工号',align:'center',width:80,sortable:true},
					          {field:'userLname',title:'姓名',align:'center',width:60,sortable:true},		     
					          {field:'userDepname',title:'部门',align:'center',width:100,sortable:true},		       
					          {field:'acName',title:'账户类型',align:'center',width:100,sortable:true}
							]],
					toolbar:'#tb3',
					onLoadSuccess:function(row,data){
						$('#data-list3').datagrid('clearSelections');
						$('#data-list3').datagrid('clearChecked');
					}
				});		
			},
			treegridInit:function(){
				$('#data-list2').treegrid({
					title:'数据表格',
					iconCls:'icon-grid',
					height:365,
					width:YiYa.fixWidth(),
					fitColumns:true,
					nowrap:false,
					autoRowHeight:false,
					striped:true,
					remoteSort:false,
					pagination:true,
					rownumbers:true,
					singleSelect:false,
					checkOnSelect:true,
					selectOnCheck:true,
					url:urls['msUrl'] + 'impowerController/siteDataList.do',
					method:'post',
					loadMsg:'加载中... ',
					idField:'depSerial',
					treeField:'depName',		
					columns:[[
			 			        {field:'ck',checkbox:true},
								{field:'depSerial',hidden:true},
								{field:'depName',title:'场所名称',align:'left',width:300,sortable:true,formatter:function(value,row,index){						
									return value + ' [ 共' + row.count + '扇门 ] ';					
							    }},
								{field:'depNo',title:'场所编号',align:'center',width:80,sortable:true},
								{field:'depOrder',title:'场所排序',align:'center',width:150,sortable:true}
					]],
					toolbar:'#tb2',
					animate:true,
					lines:true,
					onLoadSuccess:function(row,data){
						$('#data-list2').treegrid('clearSelections');
						$('#data-list2').treegrid('clearChecked');
						if(data.length == 0){
							YiYa.show('已经到底了！',2000,true);  
						}
					}
				});	
			},
			treegridInit2:function(){
				$('#data-list4').treegrid({
					height:213,
					width:'auto',
					fitColumns:true,
					nowrap:false,
					autoRowHeight:false,
					striped:true,
					remoteSort:false,
					rownumbers:true,
					singleSelect:false,
					pagination:true,
					checkOnSelect:true,
					selectOnCheck:true,
					pageSize:5,
					pageList:[5,10,20,30,40,50],
					url:urls['msUrl'] + 'impowerController/dtDepDataList.do',
					method:'post',
					loadMsg:'加载中 ... ',
					idField:'depSerial',
					treeField:'depName',
					columns:[[
						        {field:'ck',checkbox:true},
								{field:'depSerial',hidden:true},
								{field:'depName',title:'部门名称',align:'left',width:300,sortable:true,formatter:function(value,row,index){						
									return value + ' [ 已开卡' + row.count + '人 ] ';					
							    }},
								{field:'depNo',title:'部门编号',align:'center',width:80,sortable:true},
								{field:'depOrder',title:'部门排序',align:'center',width:150,sortable:true}
					]],
					toolbar:'#tb4',
					animate:true,
					lines:true,
					onLoadSuccess:function(row,data){
						$('#data-list4').treegrid('clearSelections');
						$('#data-list4').treegrid('clearChecked');
						if(data.length == 0){
							YiYa.show('已经到底了！',2000,true);  
						}
					}
				});		
			},
			init:function(){
				$('#searchForm2').hide();
				$('#listForm2').hide();				
				_this.datagridInit();
				_this.datagridInit2();
				_this.treegridInit();
				_this.treegridInit2();
				$('#btn-search').click(function(){var param = $('#searchForm').serializeObject();$('#data-list').datagrid('reload',param);});
				$('#btn-search2').click(function(){var param = $('#searchForm2').serializeObject();$('#data-list2').treegrid('reload',param);});
				$('#btn-search3').click(function(){var param = $('#searchForm3').serializeObject();$('#data-list3').datagrid('reload',param);});
				$('#btn-search4').click(function(){var param = $('#searchForm4').serializeObject();$('#data-list4').treegrid('reload',param);});
				$('#btn-reset').click(function(){$('#searchForm').form('reset');});
				$('#btn-reset2').click(function(){$('#searchForm2').form('reset');});
				$('#btn-reset3').click(function(){$('#searchForm3').form('reset');});
				$('#btn-reset4').click(function(){$('#searchForm4').form('reset');});					
				$('.byDoor').click(function(){$('#searchForm2').slideUp('slow',function(){$('#searchForm').slideDown('slow');});$('#listForm2').slideUp('slow',function(){$('#listForm').slideDown('slow',function(){$('#data-list').datagrid('reload');});});});
				$('.bySite').click(function(){$('#searchForm').slideUp('slow',function(){$('#searchForm2').slideDown('slow');});$('#listForm').slideUp('slow',function(){$('#listForm2').slideDown('slow',function(){$('#data-list2').treegrid('reload');});});});
				$('#byUser').click(function(){
					var rows = $('#data-list').datagrid('getChecked');
					if(rows && rows.length > 0){
						$('#searchForm3').form('reset');
						$('#editForm').form('reset');
						$('#edit-win').dialog('open');
						$('#data-list3').datagrid('reload');
						var doorSerials = '';
						$.each(rows, function(i, n){
							if(doorSerials.length == 0){
								doorSerials = doorSerials + n.bh;
							}else{
								doorSerials = doorSerials + ',' + n.bh;
							}	
						});
						$('#doorSerials').val(doorSerials);
						$('#siteSerials').val('');
					}else{
						YiYa.alert('警告信息','未选中记录！','warning');
					}
				});
				$('#byDep').click(function(){
					var rows = $('#data-list').datagrid('getChecked');
					if(rows && rows.length > 0){
						$('#searchForm4').form('reset');
						$('#editForm2').form('reset');
						$('#edit-win2').dialog('open');
						$('#data-list4').treegrid('reload');
						var doorSerials = '';
						$.each(rows, function(i, n){
							if(doorSerials.length == 0){
								doorSerials = doorSerials + n.bh;
							}else{
								doorSerials = doorSerials + ',' + n.bh;
							}	
						});
						$('#doorSerials2').val(doorSerials);
						$('#siteSerials2').val('');
					}else{
						YiYa.alert('警告信息','未选中记录！','warning');
					}
				});
				$('#byUser2').click(function(){
					var rows = $('#data-list2').treegrid('getChecked');
					if(rows && rows.length > 0){
						$('#searchForm3').form('reset');
						$('#editForm').form('reset');
						$('#edit-win').dialog('open');	
						$('#data-list3').datagrid('reload');
						var siteSerials = '';
						$.each(rows, function(i, n){
							if(siteSerials.length == 0){
								siteSerials = siteSerials + n.depSerial;
							}else{
								siteSerials = siteSerials + ',' + n.depSerial;
							}	
						});
						$('#doorSerials').val('');
						$('#siteSerials').val(siteSerials);
					}else{
						YiYa.alert('警告信息','未选中记录！','warning');
					}
				});
				$('#byDep2').click(function(){
					var rows = $('#data-list2').treegrid('getChecked');
					if(rows && rows.length > 0){
						$('#searchForm4').form('reset');
						$('#editForm2').form('reset');
						$('#edit-win2').dialog('open');
						$('#data-list4').treegrid('reload');
						var siteSerials = '';
						$.each(rows, function(i, n){
							if(siteSerials.length == 0){
								siteSerials = siteSerials + n.depSerial;
							}else{
								siteSerials = siteSerials + ',' + n.depSerial;
							}	
						});
						$('#doorSerials2').val('');
						$('#siteSerials2').val(siteSerials);
					}else{
						YiYa.alert('警告信息','未选中记录！','warning');
					}
				});
				$('#btn-save').click(function(){
					if($('#editForm').form('validate')){
						var rows = $('#data-list3').datagrid('getChecked');
						if(rows && rows.length > 0){
							var userSerials = '';
							$.each(rows, function(i, n){
								if(userSerials.length == 0){
									userSerials = userSerials + n.userSerial;
								}else{
									userSerials = userSerials + ',' + n.userSerial;
								}	
							});
							$('#userSerials').val(userSerials);
							$('#depSerials').val('');	
							$('#editForm').attr('action',urls['msUrl'] + 'impowerController/recordSave.do');
							YiYa.progress('请求中...');
							YiYa.submitForm($('#editForm'),function(data){
							 	if(data.success){
							 		$('#edit-win').dialog('close');
							 		$('#data-list').datagrid('reload');
							 		$('#data-list2').treegrid('reload');
						        }else{
						       	   YiYa.alert('提示信息',data.msg,'info');  
						        }
							});
						}else{
							YiYa.alert('警告信息','未选中记录！','warning');
						}
					}
				});
				$('#btn-save2').click(function(){
					if($('#editForm2').form('validate')){
						var rows = $('#data-list4').treegrid('getChecked');
						if(rows && rows.length > 0){
							var depSerials = '';
							$.each(rows, function(i, n){
								if(depSerials.length == 0){
									depSerials = depSerials + n.depSerial;
								}else{
									depSerials = depSerials + ',' + n.depSerial;
								}	
							});
							$('#userSerials2').val('');
							$('#depSerials2').val(depSerials);
							$('#editForm2').attr('action',urls['msUrl'] + 'impowerController/recordSave.do');
							YiYa.progress('请求中...');
							YiYa.submitForm($('#editForm2'),function(data){
							 	if(data.success){
							 		$('#edit-win2').dialog('close');
							 		$('#data-list').datagrid('reload');
							 		$('#data-list2').treegrid('reload');
						        }else{
						       	   YiYa.alert('提示信息',data.msg,'info');  
						        }
							});
						}else{
							YiYa.alert('警告信息','未选中记录！','warning');
						}
					}
				});
				$('#btn-close').click(function(){YiYa.confirm('询问信息','确认要关闭窗口吗？',function(r){if (r){$('#edit-win').dialog('close');}});});
				$('#btn-close2').click(function(){YiYa.confirm('询问信息','确认要关闭窗口吗？',function(r){if (r){$('#edit-win2').dialog('close');}});});
			}
	};
	return _this;
}();

/*页面初始化*/
$(function(){
	YiYa.byDoor.init();				
});	