//匿名函数
var YDataGrid = function(config){
		config = config || {};
		var dataGrid = config.dataGrid || {};
		var actionUrl =  config.action || {};
		var Action = {	
						'save':actionUrl.save || 'save.do',
						'getById':actionUrl.getById || 'getById.do',
						'remove':actionUrl.remove || 'remove.do'
						};		
		//数据表格
		var Grid = $('#data-list');
		//表单
		var Form = {
						search:$('#searchForm'),
						list:$ ('#listForm'),
						edit:$ ('#editForm')
					};
		//添加、修改对话框
		var Win = { edit:$('#edit-win') };		
		//默认方法
		var Handler = {
						//查询方法
						search:function(callback){
							Events.refresh();
							//回调函数
							if(jQuery.isFunction(callback)){
								callback();
							}
							return false;	
						},
						//添加方法
						add:function(callback){
							var  rows=$("#data-list").datagrid("getSelections");
							if(rows.length==0){
								YiYa.alert('警告','未选中记录！','warning');  
								return false;
							}
							if(rows.length>1){
								YiYa.alert('警告','只能选择一行记录！','warning');  
								return false;
							}
							
							var  post=$("#data-list").datagrid("getSelected"); 
							if(post==undefined){
								YiYa.alert('警告','未选中记录！','warning');  
								return false;
							}
							
							var  userSerial=post.userSerial;
							$("#changeMoney").dialog("open").load(urls['msUrl'] + 'MedAccountController/changeMoney.do?userSerial='+userSerial);
							
						},
						//修改方法
						edit:function(){
							var  post=$("#data-list").datagrid("getSelected"); 
							if(post==undefined){
								YiYa.alert('警告','未选中记录！','warning');  
								return false;
							}
							
							var  userSerial=post.userSerial;
							 $.ajax( {  
					             type : "POST",  
					             url : urls['msUrl'] + 'MedAccountController/getById.do?userSerial='+userSerial,  
					             success : function(reponse,data) {  
					            	 if(reponse&&reponse.success){
					            		 $("#edit-win").dialog("open");
					            		 $("#editForm").form('load',reponse.data);
							    	 }
					             }
						    });
						},
						//刷新方法
						refresh:function(callback){
							var param = Form.search.serializeObject();
							$("#cardHao").val('');
							Grid.datagrid('reload',param);
							//回调函数
							if(jQuery.isFunction(callback)){
								callback();
							}
						},
						//删除方法
						remove:function(callback){
							$("#batchRecharge").dialog("open");
						},
						//保存方法
						save:function(callback){
							var money=$("#money").val();
							var  rows=$("#data-list").datagrid("getSelections");
							var  accountIds="";
							for(var i=0;i<rows.length;i++){
								accountIds+=rows[i].userSerial+",";
							}
							
							$.ajax({
							     type:'post',
							     url:urls['msUrl'] + 'MedAccountController/saveMoney.do', 
							     data: {
							    	 money:money,
							    	 accountIds:accountIds
							     } ,
							     dataType: "json",
							     success:function(reponse) {  
							    	 if(reponse&&reponse.success){
							    		 YiYa.alert('提示',"充值成功！",'ok');
					            		 $("#edit-win").dialog("close");
					            		 $('#data-list').datagrid('reload'); 
							    	 }
							    }
							});
							
							
							
						},
						//关闭方法
						close:function (callback){
							YiYa.confirm('询问','确认要关闭窗口吗？',function(r){  
							    if (r){  
							     	Win.edit.dialog('close');
							     	//回调函数
									if(jQuery.isFunction(callback)){
										callback(data);
									}
							    }
							});
						}
					};		
		//工具类
		var Utils = {
						getCheckedRows:function(){
							return Grid.datagrid('getChecked');			
						},
						//检查数据表格是否有勾选的行, 有返回 true,没有返回false
						checkSelect:function(rows){
							if(rows && rows.length > 0){
								return true;
							}
							YiYa.alert('警告','未选中记录！','warning');  
							return false;
							
						},
						//检查数据表格是否只勾选了一行,是返回 true,否返回false
						checkSelectOne:function(rows){
							if(!Utils.checkSelect(rows)){
								return false;
							}
							if(rows.length == 1){
								return true;
							}
							YiYa.alert('警告','只能选择一行记录！','warning');  
							return false;
						}
					};		
		//自定义事件
		var evt= config.event || {};		
		//默认事件
		var Events ={
						//查询事件
						search:evt.search || Handler.search,
						//添加事件
						add:evt.add || Handler.add,
						//修改事件
						edit:evt.edit || Handler.edit,
						//刷新事件
						refresh:evt.refresh || Handler.refresh,
						//删除事件
						remove:evt.remove || Handler.remove,
						//保存事件
						save:evt.save || Handler.save,
						//关闭事件
						close:evt.close ||  Handler.close
					};		
		//初始化工具栏并绑定事件
		var bar_add = {	
						id:'btn-add',
						text:'金额转移',
						iconCls:'icon-add',
						btnType:'add',
						handler: Events.add
					  };
		var bar_edit = {
							id:'btn-edit',
							text:'充值',
							iconCls:'icon-edit',
							btnType:'edit',
							handler: Events.edit
					   };
		var bar_remove = { 	id:'btn-remove',
							text:'批量充值',
							iconCls:'icon-save',
							btnType:'remove',
							handler:Events.remove	
						 };
		var toolbarConfig = [bar_edit,bar_add];
		var getToolbar = function (){
			var tbars = [];
			if (dataGrid.toolbar != undefined && dataGrid.toolbar.length > 0) {
				for ( var i = 0; i < dataGrid.toolbar.length; i++) {
					var bar = dataGrid.toolbar[i];
					if(!bar){
						continue;
					}
					if(bar.btnType=='add'){
						tbars.push({id:bar.id || bar_add.id,text:bar.text || bar_add.text ,iconCls: bar.iconCls || bar_add.iconCls, btnType: bar.btnType || bar_add.btnType,handler:bar.handler || bar_add.handler});
						continue;
					}
					if(bar.btnType=='edit'){
						tbars.push({id:bar.id || bar_edit.id,text:bar.text || bar_edit.text ,iconCls: bar.iconCls || bar_edit.iconCls,btnType: bar.btnType || bar_edit.btnType,handler:bar.handler || bar_edit.handler});
						continue;
					}
					if(bar.btnType=='remove'){
						tbars.push({id:bar.id || bar_remove.id,text:bar.text || bar_remove.text ,iconCls: bar.iconCls || bar_remove.iconCls,btnType: bar.btnType || bar_remove.btnType,handler:bar.handler || bar_remove.handler});
						continue;
					}
					tbars.push({id:bar.id,text:bar.text,iconCls:bar.iconCls,btnType: bar.btnType,handler:bar.handler,disabled:bar.disabled});
				}
			}else{
				tbars = toolbarConfig;
			}
			return tbars;
		};	
		//初始化数据表格
		var initGrid = function(){
			var dataconfig = {
				title:dataGrid.title || '数据表格',
				iconCls:dataGrid.iconCls || 'icon-grid',
				height:dataGrid.height || 365,
				width:dataGrid.width || 1100,
				nowrap:false,
				autoRowHeight:true,
				striped:true,
				collapsible:true,
				remoteSort:false,
				pagination:true,
				rownumbers:true,
				singleSelect:false,
				checkOnSelect:true,
				selectOnCheck:true,
				url:dataGrid.url,
				method:dataGrid.method || 'post',
				loadMsg:dataGrid.loadMsg || '正在处理 ... ',
			//	idField:dataGrid.idField || 'id',
				columns:dataGrid.columns,
				toolbar:getToolbar(),
				onLoadSuccess:dataGrid.onLoadSuccess || function(){
					Grid.datagrid('clearSelections');
					Grid.datagrid('clearChecked');
					//Grid.datagrid('unselectAll');
					//Grid.datagrid('uncheckAll');
				}
			};
			Grid.datagrid(dataconfig);
		};	
		//为查询按钮绑定事件
		var initForm = function(){
			if(Form.search && Form.search[0]){
				Form.search.find('#btn-search').click(Events.search); 
			}
		};	
		//为保存、关闭按钮绑定事件
		var initWin = function(){
			if(Win.edit && Win.edit[0]){
				//判断页面是否设置buttons，如果没有设置默认按钮
				var btns = Win.edit.attr('buttons');
				if(!btns){
					//设置保存,关闭按钮
					Win.edit.dialog({
						buttons:[
							{
								text:'保存',
								handler:Events.save
							},
							{
								text:'关闭',
								handler:Events.close
							}
						]
					});
				}else{
					Win.edit.find('#btn-submit').click(Events.save);//保存事件
					Win.edit.find('#btn-close').click(Events.close);//关闭窗口
				}
			}
		};		
		//返回属性		
		this.grid = Grid;		
		this.form = Form;
		this.win = Win;
		this.handler = Handler;		
		this.utils = Utils;		
		//初始化方法
		this.init = function(){
			initGrid();
			initForm();
			initWin();
		}
};