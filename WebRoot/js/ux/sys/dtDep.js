/*声明命名空间*/
$package('YiYa.dtDep');

/*封装变量（匿名自执行函数）*/
YiYa.dtDep = function(){
	var _box = null;
	var _this = {
			p:0,
			isSynchronized:function(){				
				setTimeout(function(){
					if(_this.p == 0){
						YiYa.ajaxJson(urls['msUrl'] + 'systemController/midDepIsSynchronized.do',null,function(data){
							if(data.count > 0){
								var now = YiYa.showTime();
								YiYa.show('截至' + now + '，有 ' + data.count + ' 条部门更新，去<a href=\'#\' onclick=\'YiYa.dtDep.synchronize()\'>接收</a>！',5000,true);
								_this.p ++;
							}
						});
					}
				},0);				
			},
			synchronize:function(){
				$('#editForm2').form('reset');
				$('.option').combobox('disableValidation');	
				$('.settingOption').hide();											
				$('#edit-win2').dialog('open');	
			},
			config:{
				event : {
					add : function(){
	  					var rows = _box.utils.getSelectedRows();
	  					if(_box.utils.checkSelectOne(rows)){
		  					$('#editForm').form('reset');
		  					$('#edit-win').dialog('open');
		  					$('#depParent').combotree('setValue',rows[0].depSerial);
	  					}
	  				}
				},
				action : {
					save:urls['msUrl'] + 'systemController/save.do',//保存Action  
					getById:urls['msUrl'] + 'systemController/getById.do',//查询Action
					remove:urls['msUrl'] + 'systemController/dtDepDelete.do'//删除Action
				},
	  			treeGrid:{
		   			url:urls['msUrl'] + 'systemController/dtDepDataList.do',
		   			idField:'depSerial',
		   			treeField:'depName',
		   			pagination:"false",
		   			height:475,
		   			columns:[[
		   			        {field:'ck',checkbox:true},
							{field:'depSerial',hidden:true},
							{field:'depName',title:'部门名称',align:'left',width:300,sortable:true,formatter:function(value,row,index){	
								if(row.total == 0){
									return value + ' [ 共' + row.total + '人 ] ';					
								}else{
									var surplus =row.total - row.count;
									return value + ' [ 共' + row.total + '人，已开卡<mark>' + row.count + '</mark>人，未开卡' + surplus + '人  ] ';					
								}
								
						    }},
							{field:'depNo',title:'部门编号',align:'center',width:80,sortable:true},
							{field:'depOrder',title:'部门排序',align:'center',width:150,sortable:true}
					]],
					toolbar:[
								{id:'btn-add',text:'添加',btnType:'add',iconCls:'icon-add'},
								{id:'btn-edit',text:'修改',btnType:'edit',iconCls:'icon-edit'},
								{id:'btn-remove',text:'删除',btnType:'remove',iconCls:'icon-remove',handler:function(){

									YiYa.confirm("提示", "确定要删除该部门及其所有下级部门吗？", function(r){
										if(r){
											var checked = _box.utils.getSelectedRows();
											if ( _box.utils.checkSelectOne(checked)){
												var data1 ={};
												var idKey = _this.config.treeGrid.idField ;//主键名称
												data1[idKey] = (checked[0][idKey]);
							 					YiYa.progress('请求中...');
							 					YiYa.ajaxJson(urls['msUrl'] + 'systemController/dtDepDelete.do',data1,function(data){
							 							YiYa.closeProgress();
							 							if(data.success){
							 								var param = $('#searchForm').serializeObject();
							 								$('#data-list').treegrid('reload',param);
							 								if(data&&data.msg){
							 						       		YiYa.alert('提示信息',data.msg,'info');
							 								}
							 							}
							 					});
							 					
											}
										}
									});
								
								}},
								{id:'btn-define',text:'关联场所',btnType:'save',iconCls:'icon-save',handler:function(){
									var checked = _box.utils.getSelectedRows();
									if ( _box.utils.checkSelectOne(checked)){
										$('#type').val(1);
										var row = checked[0];
										$('#depSerial').attr('value',row.depSerial);
										$.get(urls['msUrl'] + 'systemController/selectAcdepAndDep.do',{depSerial : row.depSerial},function(data){
											$('#hasBinded').val(data.data);
										});
										$('#edit-win3').dialog('open');
									}
								}},{id:'btn-define1',text:'关联场所(包括下级部门)',btnType:'save1',iconCls:'icon-save',handler:function(){
									var checked = _box.utils.getSelectedRows();
									if ( _box.utils.checkSelectOne(checked)){
										$('#type').val(2);
										var row = checked[0];
										$('#depSerial').attr('value',row.depSerial);
										$.get(urls['msUrl'] + 'systemController/selectAcdepAndDep.do',{depSerial : row.depSerial},function(data){
											$('#hasBinded').val(data.data);
										});
										$('#edit-win3').dialog('open');
									}
										
								}},{
									id:'btn-sync',text:'同步HR部门',btnType:'sync',iconCls:'icon-sync',handler:function(){
										var checked = _box.utils.getSelectedRows();
										if ( _box.utils.checkSelectOne(checked)){
											$('#editForm4').form('reset');
											$('#depSerial4').attr('value',checked[0].depSerial);
											$('#edit-win4').dialog('open');
										}
									}
								}
							] 		
				}
			},
			init:function(){
				_box = new YTreeGrid(_this.config); 
				_box.init();
				_this.isSynchronized();
				$('.settings').click(function(){var v = $('.settings:checked').val();if(v == 0){$('.option').combobox('disableValidation');$('.option').combobox('clear');$('.settingOption').hide();}else{$('.option').combobox('enableValidation');$('.settingOption').show();}});
				$('#btn-save2').click(function(){if($('#editForm2').form('validate')){$('#editForm2').attr('action',urls['msUrl'] + 'systemController/midDepSynchronize.do');YiYa.progress('请求中...');YiYa.submitForm($('#editForm2'),function(data){if(data.msg){$('#edit-win2').dialog('close');YiYa.alert('提示信息',data.msg,'info');}});}	});
				$('#btn-close2').click(function(){YiYa.confirm('询问信息','确认要关闭窗口吗？',function(r){if (r){$('#edit-win2').dialog('close');}});});
				$('#btn-save3').click(function(){
					if($('#editForm3').form('validate')){
						var type = $('#type').val();
						if(type==1){
							$('#editForm3').attr('action',urls['msUrl'] + 'systemController/saveAcdepAndDep.do');
						}else if(type==2){
							$('#editForm3').attr('action',urls['msUrl'] + 'systemController/saveAcdepAndDep1.do');
						}
						YiYa.submitForm($('#editForm3'),function(data){
							$('#edit-win3').dialog('close');
							if(data.msg){
								YiYa.alert('提示信息',data.msg,'info');
							}
						});
					}	
					});
				$('#btn-close3').click(function(){
					YiYa.confirm('询问信息','确认要关闭窗口吗？',function(r){
						if (r){
							$('#edit-win3').dialog('close');
						}
					});
				});
				$('#btn-save4').click(function(){
					var all = document.getElementById('cascade').checked;
					if(all==true){
						YiYa.confirm("提示", "确定同步其所有下级部门吗？", function(r){
							if(r){
								if($('#editForm4').form('validate')){
									$('#editForm4').attr('action',urls['msUrl'] + 'systemController/syncMidDep.do');
									YiYa.submitForm($('#editForm4'),function(data){
										if(data.success){
											var param = $('#searchForm').serializeObject();
			 								$('#data-list').treegrid('reload',param);
										}
										$('#edit-win4').dialog('close');
										if(data.msg){
											YiYa.alert('提示信息',data.msg,'info');
										}
									});
								}	
							}
						});
					}else{
						if($('#editForm4').form('validate')){
							$('#editForm4').attr('action',urls['msUrl'] + 'systemController/syncMidDep.do');
							YiYa.submitForm($('#editForm4'),function(data){
								$('#edit-win4').dialog('close');
								if(data.success){
									var param = $('#searchForm').serializeObject();
	 								$('#data-list').treegrid('reload',param);
								}
								if(data.msg){
									YiYa.alert('提示信息',data.msg,'info');
								}
							});
						}	
					}
					
				});
				$('#btn-close4').click(function(){
					YiYa.confirm('询问信息','确认要关闭窗口吗？',function(r){
						if (r){
							$('#edit-win4').dialog('close');
						}
					});
				});
			}
	};
	return _this;
}();

/*页面初始化*/
$(function(){
	YiYa.dtDep.init();
});		