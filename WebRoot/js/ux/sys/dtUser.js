/*声明命名空间*/
$package('YiYa.dtUser');

/*封装变量（匿名自执行函数）*/
YiYa.dtUser = function(){
	var _box = null;
	var _this = {
			editIndex : null,
			p:0,
			goSync : 0,
			isSynchronized:function(){	
				if(YiYa.dtUser.goSync==0){
					setTimeout(function(){
						if(_this.p == 0){
							YiYa.ajaxJson(urls['msUrl'] + 'systemController/midUserSynchronizeCount.do',null,function(data){
								if(data.count > 0){
									var now = YiYa.showTime();
									YiYa.show('截至' + now + '，有 ' + data.count + ' 条人员更新，去<a href=\'#\' onclick=\'YiYa.dtUser.synchronize()\'>接收</a>！',10000,true);
									_this.p ++;
								}
							});
						}
					},1000);	
				}
			},
			synchronize:function(){
				_this.openSyncWindow();
			},
			openSyncWindow:function(){
				YiYa.progress("请求中。。。");
						$.get(urls['msUrl'] + 'systemController/midUserSynchronize.do',function(data){
							if(data.success){
								if(data.data){
									YiYa.closeProgress();
									$('#check-window').window('open');
									$('#checkRecord').datagrid({
										fit : true,
										striped : true,
										fitColumns : true,
										pageSize : 50,
										rownumbers : true,
//										singleSelect : true,
										nowrap : false,
										idField : 'userSerial',
										columns : [ [
										        {
										        	field:'ck',checkbox:true
										        },
												{
													field : 'userSerial',
													hidden : true
												},{
													field : 'userNo',
													hidden : true
												},{
													field : 'userDep',
													hidden : true
												},{
													field : 'userType',
													hidden : true
												},
												{
													field : 'userLname',
													title : '员工姓名',
													align : 'center',
													width : 50,
												},
												{
													field : 'company',
													title : '所属二级公司',
													align : 'center',
													width : 130,
												},
												{
													field : 'userDepname',
													title : '所属部门',
													align : 'center',
													editor :{
														type: 'combotree',
														options:{
															method:'get',
															url:urls['msUrl'] + 'systemController/dtDepLoad.do',
															width:120,
															height:22,
															panelWidth:251,
															panelHeight:300,
															editable:false,
															animate:true,
															hasDownArrow:false,
															lines:true
														}
													},
													width : 70,
												},
												{
													field : 'mainCompany',
													title : 'HR库所属公司',
													align : 'center',
													width : 150,
												},
												{
													field : 'mainDepname',
													title : 'HR库所属部门',
													align : 'center',
													width : 70,
												},
												{
													field : 'userDuty',
													title : '职务',
													align : 'center',
													width : 50,
												},
												{
													field : 'userTypeName',
													title : '状态',
													align : 'center',
													width : 70,
													editor :{
														type: 'combobox',
														options:{
															method:'get',
															url:urls['msUrl'] + 'systemController/ttLizhiLoad.do',
															valueField:'value',
															textField:'text',
															width:70,
															height:22,
															panelHeight:100,
															editable:false,
															animate:true,
															hasDownArrow:false,
															lines:true
														}
													}
												}
												]],
												onEndEdit:function(index,row){
//													var ed = $(this).datagrid('getEditor', {
//														index: index,
//														field: 'userDepname'
//													});
//													var ed1 = $(this).datagrid('getEditor', {
//														index: index,
//														field: 'userTypeName'
//													});
//													row.userTypeName = $(ed1.target).combobox('setText',4);
												},
												onBeforeEdit:function(index,row){
													row.editing = true;
													$(this).datagrid('refreshRow', index);
												},
												onAfterEdit:function(index,row){
													row.editing = false;
													$(this).datagrid('refreshRow', index);
												},
												onCancelEdit:function(index,row){
													row.editing = false;
													$(this).datagrid('refreshRow', index);
												},
//												toolbar:[
//												         {
//												        	 id:'btn-sync',
//												        	 text:'同步',
//												        	 iconCls:'icon-sync',
//												        	 handler : function(){
//												        		 var checked = _box.utils.getCheckedRows();
//												        		 if ( _box.utils.checkSelectOne(checked)){
//												        			 
//												        		 }
//												        	 }
//												         }
//												         ],
												onClickCell: function(index,field){
											 		if(field!='userDepname'&&field!='userTypeName'){
											 			$('#checkRecord').datagrid('endEdit',YiYa.dtUser.editIndex||index);
											 			return false;
											 		}
											 		if (endEditing()){
											 			$('#checkRecord').datagrid('selectRow', index)
											 					.datagrid('beginEdit', index);
											 			YiYa.dtUser.editIndex = index;
											 			editIndex = index;
											 		} else {
											 			$('#checkRecord').datagrid('selectRow', editIndex);
											 		}
										 	}
												         
									});
									$('#checkRecord').datagrid('loadData',data.data);
								}
							}else{
								YiYa.alert('提示信息',data.msg,'info');
							}
						});
			},
			getRowIndex : function(target){
				var tr = $(target).closest('tr.datagrid-row');
				return parseInt(tr.attr('datagrid-row-index'));
			},
			initTreeData:function(){
				$('#door-tree').tree({
					url:urls['msUrl'] + 'systemController/getDoorTree.do',
					method:'get',
					animate:true,
					checkbox:true,
					cascadeCheck:true,
					onlyLeafCheck:true,
					lines:true,
					onLoadSuccess:function(){
						$(this).tree('expandAll');
					}
				});
			},
			getTreeData:function(nodes){				
				$.each(nodes,function(i,n){				
					var $id = $('<input type=\'hidden\' name=\'doorBhs\' class=\'c_doors\'>');
					var id = n.id;
					$id.val(id);
					_box.form.edit.append($id);
				});
			},
			setTreeData:function(id){				
				var node = $('#door-tree').tree('find',id);
				$('#door-tree').tree('check',node.target);
			},
			clearTreeData:function(){
				$('.tree-checkbox1').removeClass('tree-checkbox1').addClass('tree-checkbox0');
				$('.c_doors').remove();	
			},
			config:{
				action:{
	  				save:urls['msUrl'] + 'systemController/dtUserSave.do',//保存Action  
	  				getById:urls['msUrl'] + 'systemController/dtUserGetById.do',//查询Action
	  				remove:urls['msUrl'] + 'systemController/dtUserDelete.do'//删除Action
	  			},	
	  			event:{
	  				add:function(){	  					
	  					_box.handler.add(function(){//调用add方法		
	  						$('#tabs').tabs('select', 0);
	  						$('#tabs').tabs('disableTab', 2);
	  						$('#acBh').combobox('setValue','0000000000000001');
	  					});		
					},
					edit:function(){	  					
	  					_box.handler.edit(function(result){//调用edit方法		
	  						var rows = $('#data-list').datagrid('getChecked');
	  						if(rows){
	  							var mj = rows[0].mj;
	  							if(mj==1){
	  								$('#mj').combobox('setValue',mj);
	  							}else{
	  								$('#mj').combobox('setValue',0);
	  							}
	  						}
	  						$('#tabs').tabs('select', 0);
	  						if(result.data.cardXh&&result.data.cardType==0){
	  							$('#tabs').tabs('enableTab', 2);
	  						}else{
	  							$('#tabs').tabs('disableTab', 2);
	  						}	  						
	  					});		
					},
					save:function(){	
						var checkdNodes = $('#door-tree').tree('getChecked');
						if(checkdNodes.length > 0){
							_this.getTreeData(checkdNodes);							
						}				
						_box.handler.save();//调用save方法
					}
				},
	  			dataGrid:{
		   			url:urls['msUrl'] + 'systemController/dtUserDataList.do',
		   			idField:'userSerial',
		   			columns:[[
							{field:'ck',checkbox:true},
							{field:'userSerial',hidden:true},
							{field:'mj',hidden:true},
							{field:'userNo',title:'工号',align:'center',width:80,sortable:true},
							{field:'cardHao',title:'物理卡号',align:'center',width:100,sortable:true},
							{field:'userLname',title:'姓名',align:'center',width:80,sortable:true},
							{field:'userSex',title:'性别',align:'center',width:60,sortable:true},
							{field:'userDuty',title:'职务',align:'center',width:100,sortable:true},
							{field:'company',title:'所属公司',align:'center',width:100,sortable:true,formatter:function(value,item){
								if(value==null||value==""){
									return item.userDepname;
								}
								return value;
							}},
							{field:'userDepname',title:'部门',align:'center',width:80,sortable:true},
							{field:'acName',title:'账户类型',align:'center',width:100,sortable:true},
							{field:'userTypeName',title:'状态',align:'center',width:100,sortable:true},
							{field:'roleName',title:'角色类型',align:'center',width:100,sortable:true}
//							,{field:'isSynchronized',title:'同步',align:'center',width:100,formatter:function(value){
//								if(value==1){
//									return "<a href='#' onclick=''>同步</a>";
//								}
//							}}
					]],
					toolbar:[
								{id:'btn-add',text:'添加',btnType:'add'},
								{id:'btn-edit',text:'修改',btnType:'edit'},
								{id:'btn-remove',text:'删除',btnType:'remove'},
								{
									id:'btn-updating',
									text:'恢复密码',
									disabled:false,
									iconCls:'icon-updating',
									handler:function(){var checked = _box.utils.getCheckedRows();if ( _box.utils.checkSelectOne(checked)){YiYa.confirm('询问信息','确认要恢复密码吗？',function(r){if (r){var option = {};option['userSerial'] = checked[0]['userSerial'];option['userPassword'] = '123456';YiYa.ajaxJson(urls['msUrl'] + 'systemController/editPwd.do',option,function(data){if(data.success){YiYa.alert('提示信息',data.msg,'info');}else{YiYa.alert('提示信息',data.msg,'info');}});}});}}
								}
							] 
				}
			},
			init:function(){
				_box = new YDataGrid(_this.config); 
				_box.init();
				$('#btn-save2').click(function(){
					var checkeds = $('#checkRecord').datagrid('getChecked');
					if(checkeds&&checkeds.length>0){
						YiYa.progress("请求中。。。");
						var config = [];
						for(var i=0;i<checkeds.length;i++){
							config[i]=YiYa.filterNull(checkeds[i]);
						}
						$.ajax(urls['msUrl']+"systemController/synchronizeUsers.do",{
							type:'post',
						 	dataType:'json',
						 	contentType:"application/json",
						 	data:JSON.stringify(config),			 	
						 	complete:function(data){
						 		YiYa.closeProgress();
						 		$('#check-window').window('close');
						 		if(data&&data.success){
//						 			var param = $('#searchForm').serializeObject();
									$('checkRecord').datagrid('reload');
						 		}
						 		if(data&&data.msg){
						 			YiYa.alert("消息", "同步成功！");
						 		}
						 	}
					});
					}
				});
				
				$('#btn-close2').click(function(){$('#check-window').dialog('close');});
				$('#tabs').tabs({onSelect:function(t,i){
					if(i == 1){
						var option = {};
						option['acBh'] = $('#acBh').combobox('getValue');
						$('#data-list2').datagrid({
							height:213,width:'auto',fitColumns:true,nowrap:false,autoRowHeight:false,
							striped:true,remoteSort:false,rownumbers:false,singleSelect:true,
							pagination:false,checkOnSelect:true,selectOnCheck:true,
							url:urls['msUrl'] + 'systemController/selectXfAcTime.do',queryParams:option,
							method:'post',loadMsg:'加载中 ... ',idField:'xh',	
							columns:[[{field:'xh',hidden:true},{field:'acName',title:'账户类型名称',align:'center',width:150,sortable:true},{field:'lname',title:'时段名称',align:'center',width:150,sortable:true},{field:'timeMaxM',title:'时段限额',align:'center',width:150,sortable:true,formatter:function(value,row,index){return value / 100 + '元';}},{field:'timeMaxT',title:'时段限次',align:'center',width:120,sortable:true,formatter:function(value,row,index){return value + '次';}},{field:'timeLimit',title:'消费方式',align:'center',width:120,sortable:true,styler:function(value,row,index){if(value == 0){return 'color:#449d44;font-weight:bold;';}if(value == 1){return 'color:#f0ad4e;font-weight:bold;';}if(value == 2){return 'color:#d9534f;font-weight:bold;';}},formatter:function(value,row,index){if(value == 0){return '不限制消费';}if(value == 1){return '限额限次';}if(value == 2){return '禁止消费';}}}]]
						});
					}else if(i ==2){
						var option = {};
						option['userSerial'] = $('#userSerial').val();
						YiYa.ajaxJson(urls['msUrl'] + 'systemController/selectStDoorReal.do',option,function(result){
							_this.clearTreeData();
							$.each(result,function(i,n){
								_this.setTreeData(n.doorBh);
							});
						});
					}
				}});
				_this.initTreeData();
				YiYa.dtUser.goSync = $('#goSync').attr('value');
				if(YiYa.dtUser.goSync==1){
					_this.openSyncWindow();
				}
				_this.isSynchronized();
			}
	}
	return _this;
}();

/*页面初始化*/
$(function(){
	YiYa.dtUser.init();
});		

var editIndex = undefined;
function endEditing(){
	if (editIndex == undefined){return true}
	if ($('#checkRecord').datagrid('validateRow', editIndex)){
		$('#checkRecord').datagrid('endEdit', editIndex);
		editIndex = undefined;
		return true;
	} else {
		return false;
	}
}
