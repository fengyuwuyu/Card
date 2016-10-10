/*声明命名空间*/
$package('YiYa.lockCard');

/*封装变量（匿名自执行函数）*/
YiYa.lockCard = function(){
	var _box = null;
	var _this = {
		config:{
			action:{
  				getById:urls['msUrl'] + 'cardController/dtUserGetById.do',//查询Action
  			},	
  			event:{
  				close:function(){
  					_box.handler.close(function(){//调用close方法
  						_box.handler.refresh();
  					});					
				}
  			},
  			dataGrid:{
	   			url:urls['msUrl'] + 'cardController/dtUserDataList2.do',
	   			idField:'userSerial',
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'userSerial',hidden:true},
						{field:'userNo',title:'工号',align:'center',width:100,sortable:true},
						{field:'userLname',title:'姓名',align:'center',width:100,sortable:true},
						{field:'userDuty',title:'职务',align:'center',width:100,sortable:true},
						{field:'userDepname',title:'部门',align:'center',width:100,sortable:true},						
						{field:'cardHao',title:'物理卡号',align:'center',width:100,sortable:true},						
						{field:'cardSerial',title:'逻辑卡号',align:'center',width:100,sortable:true},
						{field:'cardType',title:'卡片状态',align:'center',width:60,sortable:true,styler:function(value,row,index){
							if(value == 0){
							  	return 'color:#449d44;font-weight:bold;';  
							}
							if(value == 1){
							  	return 'color:#f0ad4e;font-weight:bold;'; 
							}
						},formatter:function(value,row,index){
							if(value == 0){
								return '正常';
							}
							if(value == 1){
								return '挂失';
							}
					    }},
						{field:'cardSj',title:'操作变更时间',align:'center',width:120,sortable:true},
						{field:'cardBz',title:'挂失备注',align:'center',width:100,sortable:true}
						
						
				]],
				toolbar:[
							{id:'btn-lock',text:'挂失',btnType:'lock',iconCls:'icon-lock2',handler:function(){var checked = _box.utils.getCheckedRows();if ( _box.utils.checkSelectOne(checked)){if(checked[0].cardType == 0){_box.handler.edit(function(result){	$('.part').show();$('.part2').hide();$('#btn-lockCard').show();$('#btn-readCard').hide();$('#btn-unlockCard').hide();$('#btn-lockCard').linkbutton('enable');var acMoney = result.data.acMoney / 100;var medMoney = result.data.medMoney || 0;var cardLossCount = result.data.cardLossCount;$('#acMoney').val(acMoney + '元');$('#medMoney').val(medMoney + '元');$('#cardLossCount').val(cardLossCount + '次');$('.readCardMessage').html('请直接单击挂失。');});}else{YiYa.alert('警告消息','非正常状态卡片无法挂失！','warning');}}}},
							{id:'btn-unlock',text:'解挂',btnType:'unlock',iconCls:'icon-cancel2',handler:function(){var checked = _box.utils.getCheckedRows();if ( _box.utils.checkSelectOne(checked)){if(checked[0].cardType == 1){_box.handler.edit(function(result){$('.part').hide();$('.part2').show();$('#btn-lockCard').hide();$('#btn-readCard').show();$('#btn-unlockCard').show();$('#btn-readCard').linkbutton('disable');$('#btn-unlockCard').linkbutton('enable');var acMoney = result.data.acMoney / 100;var medMoney = result.data.medMoney || 0;$('#acMoney').val(acMoney + '元');$('#medMoney').val(medMoney + '元');$('.readCardMessage').html('请直接单击解挂。');});	}else{YiYa.alert('警告消息','非挂失状态卡片无法解挂！','warning');}}}},
							{id:'btn-unlock2',text:'持卡解挂',btnType:'unlock2',iconCls:'icon-cancelWithCard',handler:function(){_box.handler.add();$('.part').hide();$('.part2').show();$('#btn-lockCard').hide();$('#btn-readCard').show();$('#btn-unlockCard').show();$('#btn-readCard').linkbutton('enable');$('#btn-unlockCard').linkbutton('disable');$('.readCardMessage').html('请连接读卡器，然后点击读卡。');}}
						] 			
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
			$('#btn-lockCard').click(function(){$('.readCardMessage').html($('.readCardMessage').html() + '<br/>挂失中，请稍候...');var option = {};option['userSerial'] = $('#userSerial').val();option['cardHao'] = $('#cardHao').val();option['cardBz'] = $('#cardBz').val();YiYa.ajaxJson(urls['msUrl'] + 'cardController/lockCard.do',option,function(data){if(data.success){$('#btn-lockCard').linkbutton('disable');$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);}else{	$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);}});});
			$('#btn-readCard').click(function(){var port = $('#port').combobox('getValue');YiYa.readCard(port,'readCardMessage',function(physicsCard){var option = {};option['cardHao'] = physicsCard;$('.readCardMessage').html($('.readCardMessage').html() + '<br/>读卡中，请稍候...');YiYa.ajaxJson(urls['msUrl'] + 'cardController/readCard.do',option,function(data){if(data.success){$('#btn-readCard').linkbutton('disable');$('#btn-unlockCard').linkbutton('enable');$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);$('#editForm').form('reset');$('#editForm').form('load',data.user);var acMoney = data.user.acMoney / 100;var medMoney = data.user.medMoney || 0;$('#acMoney').val(acMoney + '元');$('#medMoney').val(medMoney + '元');if(data.user.cardType == 0){$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + '非挂失状态卡片无法解挂。');$('#btn-unlockCard').linkbutton('disable');}}else{$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);}});});});
			$('#btn-unlockCard').click(function(){$('.readCardMessage').html($('.readCardMessage').html() + '<br/>解挂中，请稍候...');var option = {};option['userSerial'] = $('#userSerial').val();option['cardSerial'] = $('#cardSerial').val();option['cardHao'] = $('#cardHao').val();option['cardLx'] = $('#cardLx').val();YiYa.ajaxJson(urls['msUrl'] + 'cardController/unlockCard.do',option,function(data){if(data.success){	$('#btn-unlockCard').linkbutton('disable');$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);}else{$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);}});});
		}
	}
	return _this;
}();

/*页面初始化*/
$(function(){
	YiYa.lockCard.init();
});		