/*声明命名空间*/
$package('YiYa.register');

/*封装变量（匿名自执行函数）*/
YiYa.register = function(){
	var _box = null;
	var _this = {
			readIdentityCard : function(imgType,cardType){
				//加载读卡器识别核心
				var succ = this.LoadRecogKenal();
				if(succ==1){
					//读取身份证信息
					this.RecognizeImg(imgType,cardType);
				}
			},
			LoadRecogKenal : function(){
//			    if(!objIDCard.IsLoaded()){
			       var nRet = objIDCard.InitIDCard('53174805200132598467',1);
			       if(nRet!=0){ 
			          YiYa.alert("消息", "加载身份证读卡器失败，错误码："+nRet);
			          return 0;
			       }else{
			    	   return 1;
			       }
//			    } else {
//			    	console.log("加载识别核心成功！");
//			    	return 1;
//			    }
			},
			//读取身份证信息
			RecognizeImg : function(imgType,cardType){
			    if(objIDCard.IsLoaded()){
			        //采集图像
			        var nResult = objIDCard.AcquireImage(imgType);
			        if(nResult!=0){
			           YiYa.alert("消息", "采集图像失败\r\n返回值："+nResult);
			           return;
			       }
			     	objIDCard.SetIDCardType(cardType,0);
					objIDCard.ProcessImage(2);
			      	nResult = objIDCard.RecogIDCard(); 
			      	if(nResult<=0){
			           var strError = "识别失败\r\n返回值：";
			           strError += nResult;
			           YiYa.alert("提示", strError);
			           return;
			        } 
			    //显示识别结果 
			    this.DisplayResult(cardType);
			    //保存图像
//			    objIDCard.SaveImage(document.IDScanRecog.ImgPath.value);
			    } else {
			    	YiYa.alert("消息", "加载识别核心失败，请再次尝试或联系管理员！"); 
			    }
			},
			//显示识别结果
			DisplayResult : function(cardType)
			{
			   var nFieldNum = objIDCard.GetRecogFieldNum();
			   if(nFieldNum>0){  
				   var username,userSex,userNation,userAddress,userId;
				   switch(cardType){
					    case 1:
					   	case 2:
						   username = objIDCard.GetRecogResult(1);
						   userSex = objIDCard.GetRecogResult(2);
						   userNation = objIDCard.GetRecogResult(3);
						   userAddress = objIDCard.GetRecogResult(5);
						   userId = objIDCard.GetRecogResult(6);
						   //保存头像
						   objIDCard.SaveHeadImage("C:/photo/user.jpg");
						   var base64 = objIDCard.EncodeToBase64("C:/photo/user.jpg");
						   $.post(urls['msUrl']+'visitorController/identityPhoto.do',{'userId':userId,'base64':base64},function(data){
							   if(data&&data.success){
								   var img = document.getElementById('img');
								   img.src = urls['msUrl']+'file/photos/'+userId+'.jpg';
							   }else{
								   YiYa.alert("消息", "读取头像失败！");
							   }
						   });
					   		break;
						case 5:
							username = objIDCard.GetRecogResult(2);
							userSex = objIDCard.GetRecogResult(3);
							userNation = "汉";
							userAddress = objIDCard.GetRecogResult(4);
							userId = objIDCard.GetRecogResult(1);   
							break;
						case 7:
							username = objIDCard.GetRecogResult(2);
							userSex = objIDCard.GetRecogResult(4);
							userNation = objIDCard.GetRecogResult(6);
							userAddress = objIDCard.GetRecogResult(5);
							userId = objIDCard.GetRecogResult(1);   
							break;
						default:
							username = "";
							userSex = "男";
							userNation = "汉";
							userAddress = "";
							userId = "";
				   }
				   
				   $('#username').val(username);                    //姓名 
				   $('#username').focus();
				   $('#userSex').combobox('setValue',userSex||"男");     //性别 
				   $('#userNation').combobox('setValue',userNation||'汉'+'族');  //民族 
				   $('#userAddress').val(userAddress);                 //住址 
				   $('#userId').val(userId);                      //身份证
			   }
			},
			openCard:function(id){	
				_box.grid.datagrid('selectRecord',id);
				var checked = _box.utils.getCheckedRows();
				$('#userSerial').val(checked[0]['userSerial']);
				$('.part').show();
				$('#btn-openCard').show();
				$('#btn-returnCard').hide();
				$('#btn-openCard').linkbutton('enable');
				$('#editForm2').form('reset');				
				$('#edit-win2').dialog('open');
				$('.readCardMessage').html('请连接读卡器，然后点击开卡。');				
			},
			returnCard:function(id){	
				_box.grid.datagrid('selectRecord',id);
				$('.part').hide();
				$('#btn-openCard').hide();
				$('#btn-returnCard').show();
				$('#btn-returnCard').linkbutton('enable');
				$('#editForm2').form('reset');				
				$('#edit-win2').dialog('open');
				$('.readCardMessage').html('请直接单击退卡。');
			},
			config:{
				action:{
	  				save:urls['msUrl'] + 'visitorController/visitorSave.do',//保存Action  
	  				getById:urls['msUrl'] + 'visitorController/visitorGetById.do',//查询Action
	  			},	
	  			event:{
	  				save:function(){
	  					_box.handler.save(function(data){//调用save方法
	  						var isContinue = $('#isContinue').prop('checked');
	  						if(isContinue){
	  							$('#userSerial').val(data['userSerial']);
	  							$('.part').show();
	  							$('#btn-openCard').show();
	  							$('#btn-returnCard').hide();
	  							$('#btn-openCard').linkbutton('enable');
	  							$('#editForm2').form('reset');				
	  							$('#edit-win2').dialog('open');
	  							$('.readCardMessage').html('请连接读卡器，然后点击开卡。');	
	  						}
	  					});					
					},
	  				close:function(){
	  					_box.handler.close(function(){//调用close方法
	  						_box.handler.refresh();
	  					});					
					}
	  			},
	  			dataGrid:{
		   			url:urls['msUrl'] + 'visitorController/visitorDataList.do',
		   			idField:'id',
		   			columns:[[
		   			          {field:'ck',checkbox:true},
		   			          {field:'id',hidden:true},
		   			          {field:'userLname',title:'姓名',align:'center',width:80,sortable:true},
		   			          {field:'userSex',title:'性别',align:'center',width:60,sortable:true},
		   			          {field:'userTelephone',title:'电话',align:'center',width:90,sortable:true},
		   			          {field:'userId',title:'身份证号',align:'center',width:110,sortable:true},
		   			          {field:'userDepname',title:'单位',align:'center',width:100,sortable:true},
		   			          {field:'notReturnCount',title:'未还卡（次）',align:'center',width:70,sortable:true}, 
		   			          {field:'cardXh',title:'卡片状态',align:'center',width:110,sortable:true,styler:function(value,row,index){
		   			        	  	if(value == null ||value == ''){
									  	return 'color:#f0ad4e;font-weight:bold;';  
									}
		   			        		if(value != null && value != ''){
									  	return 'color:#449d44;font-weight:bold;'; 
									}
								},
								formatter:function(value,row,index){
									if(value == null ||value == ''){
										return '无卡使用中';
									}
									if(value != null && value != ''){
										return '卡使用中 [ ' + '物理卡号：' + row.cardHao + ' 逻辑卡号：' + row.cardSerial + ' ]';
									}
								}},	   			    
		   			          {field:'userSj',title:'登记|修改时间',align:'center',width:120,sortable:true},
		   			          {field:'operation',title:'卡操作',align:'center',width:100,sortable:true,formatter:function(value,row,index){
		   			        	  var html = '';
		   			        	  if(row.cardXh == null || row.cardXh == ''){
		   			        		  html = '<a href=\'#\' onclick=\'YiYa.register.openCard('+row.id+')\'>开卡</a>';
		   			        		 	   			        	  }
		   			        	  if(row.cardXh != null && row.cardXh != ''){
		   			        		  html = '<a href=\'#\' onclick=\'YiYa.register.returnCard('+row.id+')\'>退卡</a>';
		   			        	  }
		   			        	  return html;
		   			          }}
							]],
					toolbar:[
								{id:'btn-add',text:'访客登记',btnType:'add',iconCls:'icon-register',
									handler:function(){
										_box.handler.add(function(result){
											document.getElementById('img').src = '';
//											$('#btn-readIDCard').linkbutton('enable');
										});
									}},
								{id:'btn-edit',text:'访客修改',btnType:'edit',iconCls:'icon-register2',
										handler:function(){
											document.getElementById('img').src = '';
											var checked = _box.utils.getCheckedRows();
											if ( _box.utils.checkSelectOne(checked)){
												_box.handler.edit(function(result){
//													$('#btn-readIDCard').linkbutton('disable');
													var userId = checked[0].userId;
													if(userId){
														document.getElementById('img').src = urls['msUrl']+'file/photos/'+userId+'.jpg';
													}
												});
											}
										}
								},
								{id:'btn-export',text:'导出',btnType:'export',iconCls:'icon-uncompress',handler:function(){YiYa.confirm('询问信息','确认查询条件与要导出的数据一致？',function(r){if(r){$('#searchForm').attr('action',urls['msUrl'] + 'visitorController/visitorExport.do');$('#searchForm').submit();}});}}

							] 
				}
			},
			init:function(){
				_box = new YDataGrid(_this.config); 
				_box.init();
				$('#btn-openCard').click(function(){if($('#editForm2').form('validate')){YiYa.readCard(YiYa.port,'readCardMessage',function(physicsCard){$('#cardHao').val(physicsCard);$('.readCardMessage').html($('.readCardMessage').html() + '<br/>开卡中，请求中...');$('#editForm2').attr('action',urls['msUrl'] + 'visitorController/openCard.do');YiYa.submitForm($('#editForm2'),function(data){if(data.success){$('#btn-openCard').linkbutton('disable');$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);}else{$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);}});});}});
				$('#btn-returnCard').click(function(){$('.readCardMessage').html($('.readCardMessage').html() + '<br/>退卡中，请稍候...');var checked = _box.utils.getCheckedRows();var option = {};	option['userSerial'] = checked[0]['userSerial'];option['cardSerial'] = checked[0]['cardSerial'];option['cardHao'] = checked[0]['cardHao'];option['cardLx'] = checked[0]['cardLx'];YiYa.ajaxJson(urls['msUrl'] + 'visitorController/returnCard.do',option,function(data){if(data.success){$('#btn-returnCard').linkbutton('disable');$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);}else{$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);}});});
				$('#btn-close2').click(function(){YiYa.confirm('询问信息','确认要关闭窗口吗？',function(r){if(r){$('#edit-win2').dialog('close');_box.handler.refresh();}});});
				$('#btn-readIDCard').click(function(){
					//点击读卡时先将照片位置置空
					//读取二代身份证
					document.getElementById('img').src = '';
					_this.readIdentityCard(2,2);
				});
				$('#btn-readIDCard2').click(function(){
					document.getElementById('img').src = '';
					//读取一代身份证
					_this.readIdentityCard(1,1);
				});
				$('#btn-readIDCard3').click(function(){
					document.getElementById('img').src = '';
					//读取驾驶证
					_this.readIdentityCard(1,5);
				});
				$('#btn-readIDCard4').click(function(){
					document.getElementById('img').src = '';
					//读取军官证
					_this.readIdentityCard(4,7);
				});
			}
	}
	return _this;
}();

/*页面初始化*/
$(function(){
	YiYa.register.init();
});		