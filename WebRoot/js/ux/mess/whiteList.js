/*声明命名空间*/
$package('YiYa.whiteList');

/*封装变量（利用匿名自执行函数）*/
YiYa.whiteList = function(){
	var _box = null;
	var _this = {
		obj : {
			addWhiteListWindow : $('#addWhiteList-window'),
			addWhiteListTable : $('#addWhiteListTable'),
			whiteListForm : $('#whiteListForm'),
		},
		config:{
  			action:{
  				save:urls['msUrl'] + 'whiteListController/save.do',//保存Action  
  				getById:urls['msUrl'] + 'whiteListController/getById.do',//查询Action
  				remove:urls['msUrl'] + 'whiteListController/delete.do'//删除Action
  			},		 
  			event:{
  				search : function(){
  					var acdepSerial1 = $('#acdepSerial1').combobox('getValue');
  					if(!acdepSerial1){
  						YiYa.alert("消息", "请选择场所。。。")
  						return false;
  					}
  					YiYa.whiteList.searchFormRefresh();
  				},
  				add:function(){
  					_box.handler.add(function(){//调用add方法
  						$('#addWhiteList-window').window('open');
  						$('#whiteListForm').form('reset');
  	  					$('#addWhiteListTable').datagrid({
  	  							url:urls['msUrl'] + 'systemController/dtUserDataList.do?whiteList=1',
  	  							width : 778,
  	  							height : 340,
  	  							fitColumns : true,
  	  							nowrap : false,
  	  							pagination : true,
		  	  		   			idField:'userSerial',
		  	  		   			singleSelect : false,
		  	  		   			rownumbers:true,
			  	  				checkOnSelect:true,
			  					selectOnCheck:true,
			  					autoRowHeight:false,
			  					striped:true,
		  	  		   			columns:[[
		  	  						{field:'ck',checkbox:true},
		  	  						{field:'userSerial',hidden:true},
		  	  						{field:'depSerial',hidden:true},
		  	  						{field:'userLname',title:'员工姓名',align:'center',width:120,sortable:true},
		  	  						{field:'userTypeName',title:'所属部门',align:'center',width:120,sortable:true},
		  	  						{field:'userNo',title:'员工编号',align:'center',width:120,sortable:true},								
		  	  						{field:'company',title:'所属公司',align:'center',width:160,sortable:true},	
		  	  						{field:'userDepname',title:'所属部门',align:'center',width:160,sortable:true}								
		  	  					]],
  	  					toolbar:[
  	  						{id:'btn-add2',text:'添加',btnType:'add',iconCls:'icon-add',handler:function(){
	  							if(YiYa.whiteList.checkAcdep($('#acdepSerial'))){
	  								var rows = $('#addWhiteListTable').datagrid('getChecked');
	  	  							if(_box.utils.checkSelect(rows)){
	  	  								var userSerial = '';
	  	  								for(var i=0;i<rows.length;i++){
	  	  									if(i==0){
	  	  										userSerial +=rows[i].userSerial;
	  	  									}else{
	  	  										userSerial +=','+rows[i].userSerial;
	  	  									}
	  	  								}
	  	  								var acdepSerial = YiYa.whiteList.getAcdepSerial();
	  	  								YiYa.ajaxJson(urls['msUrl']+'whiteListController/save.do', {'acdepSerial':acdepSerial,'userSerialss':userSerial}, function(data){
	  	  									if(data&&data.success){
	  	  										$('#addWhiteList-window').window('close');
	  	  										YiYa.whiteList.searchFormRefresh();
	  	  									}
	  	  									if(data&&data.msg){
	  	  										YiYa.alert("消息", data.msg);
	  	  									}
	  	  								});
	  	  							}
	  	  						}
	  						
								}},
  	  						{id:'btn-add3',text:'根据查询条件添加',btnType:'add',iconCls:'icon-add',handler:function(){
  	  	  						if(YiYa.whiteList.checkAcdep($('#acdepSerial'))){
  	  	  							if(YiYa.whiteList.checkParam()){
  	  	  								var param = YiYa.filterNull($('#whiteListForm').serializeObject());
  	  	  								YiYa.ajaxJson(urls['msUrl']+'whiteListController/saveList.do', param, function(data){
  	  	  									if(data&&data.success){
  	  	  									$('#addWhiteList-window').window('close');
  	  										var param = _box.form.search.serializeObject();
  	  										_box.grid.datagrid('reload',param);
  	  	  									}
  	  	  									if(data&&data.msg){
  	  	  										YiYa.alert("消息", data.msg, data.success==true?'info':'error');
  	  	  									}
  	  	  								});
  	  	  							}
  	  	  						}
  	  						}}
  	  					]
  	  				});
  				});					
				},
				remove : function(){
					var rows = _box.utils.getCheckedRows();
					if (rows&&rows.length>0){
						YiYa.confirm('提示','确认要删除记录吗？',function(r){  
						    if (r){
						    	var data ={};
								var ids = [];
								for(var i = 0;i<rows.length;i++){
									ids.push(rows[i].xh);
								}
								data['ids'] = ids;
						   		$.ajax(urls['msUrl'] + 'whiteListController/delete.do',{
						   			type:'post',
								 	dataType:'json',
								 	contentType:"application/json",
								 	data:JSON.stringify(ids),
						   			complete : function(result){
										if(result&&result.success){
											YiYa.whiteList.searchFormRefresh();
										}
										if(result&&result.msg){
											YiYa.alert("消息", result.msg);
										}
									}
						   		});
						    }  
						});
					}
				}
  			},
  			dataGrid:{
	   			url:urls['msUrl'] + 'whiteListController/dataList.do',
	   			idField:'xh',
	   			singleSelect : false,
	   			columns:[[
					{field:'ck',checkbox:true},
					{field:'xh',hidden:true},
					{field:'depSerial',hidden:true},
					{field:'userLname',title:'员工姓名',align:'center',width:120,sortable:true},
					{field:'userTypeName',title:'状态',align:'center',width:50,sortable:true},
					{field:'userNo',title:'员工编号',align:'center',width:120,sortable:true},								
					{field:'companyName',title:'所属公司',align:'center',width:220,sortable:true},	
					{field:'department',title:'所属部门',align:'center',width:120,sortable:true},								
					{field:'acdepName',title:'绑定场所',align:'center',width:220,sortable:true}
				]],
				toolbar:[
					{id:'btn-add',text:'添加',btnType:'add'},
					{id:'btn-remove',text:'删除',btnType:'remove'},
					{id:'btn-remove1',text:'按查询条件删除',btnType:'remove',handler : function(){
						if(!YiYa.whiteList.checkAcdep($('#acdepSerial1'))){
							return false;
						}
						var depSerial = $('#depSerial1').combotree('getValues');
						var userTypes = $('#userTypes1').combobox('getValues');
						if(depSerial.length==0&&userTypes.length==0){
							YiYa.confirm("提示", "您未选择部门和员工状态，确认删除该场所下的所有白名单吗？", function(r){
								YiYa.whiteList.deleteByQuery(r);
							});
						}else{
							YiYa.confirm("提示", "确认按照该条件删除白名单吗？", function(r){
								YiYa.whiteList.deleteByQuery(r);
							});
						}
					}}
				]
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();			
		},
		initWindow : function(){
			$('#btn-search1').click(function(){
				YiYa.whiteList.refresh();
			});
			$('#menu-reset1').click(function(){
				$('#whiteListForm').form('reset');
			});
		},
		getAcdepSerial : function(){
			return $('#acdepSerial').combobox('getValue');
		},
		deleteByQuery : function(r){
			if(r){
				var config = YiYa.filterNull(_box.form.search.serializeObject());
				YiYa.ajaxJson(urls['msUrl'] + 'whiteListController/deleteByQuery.do',config, function(data){
					if(data&&data.success){
						YiYa.whiteList.searchFormRefresh();
					}
					if(data&&data.msg){
						YiYa.alert("消息", data.msg);
					}
				});
			}
		},
		checkAcdep : function($acdepSerial){
			var acdepSerial = $acdepSerial.combobox('getValue');
			if(!acdepSerial){
				YiYa.alert("消息", "请选择场所。。。");
				return false;
			}
			return true;	
		},
		searchFormRefresh : function(){
			var param = _box.form.search.serializeObject();
			param = YiYa.filterNull(param);
			_box.grid.datagrid('reload',param);
		},
		checkParam :function(){
			var depSerial = $('#depSerial').combotree('getValues');
			var userTypes = $('#userTypes').combobox('getValues');
			if(depSerial.length==0&&userTypes.length==0){
				YiYa.alert("警告", "请选择部门或员工状态。。。","warning");
				return false;
			}
			if(userTypes.length==0&&depSerial.length>0){
				for(var i=0;i<depSerial.length;i++){
					if(depSerial[i]==10000){
						YiYa.alert("警告", "请选择员工状态。。。","warning");
						return false;
					}
				}
			}
			return true;
		},
		refresh : function(){
			var param = $('#whiteListForm').serializeObject();
			param.acdepSerial=null;
			param = YiYa.filterNull(param);
			$('#addWhiteListTable').datagrid('reload',param);
		},
		validateForm : function(){
			var depSerial = $('#depSerial').combotree('getValue');
			var userTypes = $('#userTypes').combobox('getValues');
//			if($())
			return false;
		}
	};
	return _this;
}();

/*页面初始化*/
$(function(){
	YiYa.whiteList.init();
	YiYa.whiteList.initWindow();
});		