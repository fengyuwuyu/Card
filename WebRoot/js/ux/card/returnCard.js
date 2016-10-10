/*声明命名空间*/
$package('YiYa.returnCard');

/*封装变量（匿名自执行函数）*/
YiYa.returnCard = function(){
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
						{field:'cardSj',title:'操作变更时间',align:'center',width:120,sortable:true}
						
						
				]],
				toolbar:[
							{id:'btn-return',text:'退卡',btnType:'return',iconCls:'icon-return',handler:function(){var checked = _box.utils.getCheckedRows();if( _box.utils.checkSelectOne(checked)){_box.handler.edit(function(result){$('#btn-readCard').linkbutton('disable');	$('#btn-returnCard').linkbutton('enable');$('#btn-returnCard2').linkbutton('disable');var acMoney = result.data.acMoney / 100;var medMoney = result.data.medMoney || 0;$('#acMoney').val(acMoney + '元');$('#medMoney').val(medMoney + '元');	$('.readCardMessage').html('请直接点击退卡。');});}}},							
							{id:'btn-returnWithCard',text:'持卡退卡',btnType:'returnWithCard',iconCls:'icon-returnWithCard',handler:function(){_box.handler.add();$('#btn-readCard').linkbutton('enable');$('#btn-returnCard').linkbutton('disable');$('#btn-returnCard2').linkbutton('disable');$('.readCardMessage').html('请连接读卡器，然后点击读卡。');}},
							{id:'btn-return2',text:'补卡',btnType:'return2',iconCls:'icon-return2',handler:function(){var checked = _box.utils.getCheckedRows();if( _box.utils.checkSelectOne(checked)){_box.handler.edit(function(result){$('#btn-readCard').linkbutton('disable');$('#btn-returnCard').linkbutton('disable');$('#btn-returnCard2').linkbutton('enable');var acMoney = result.data.acMoney / 100;var medMoney = result.data.medMoney || 0;$('#acMoney').val(acMoney + '元');$('#medMoney').val(medMoney + '元');$('.readCardMessage').html('请连接读卡器，然后点击补卡。');});}}}						
						] 			
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
			$('#btn-readCard').click(function(){var port = $('#port').combobox('getValue');YiYa.readCard(port,'readCardMessage',function(physicsCard){var option = {};option['cardHao'] = physicsCard;$('.readCardMessage').html($('.readCardMessage').html() + '<br/>读卡中，请稍候...');YiYa.ajaxJson(urls['msUrl'] + 'cardController/readCard.do',option,function(data){if(data.success){$('#btn-readCard').linkbutton('disable');$('#btn-returnCard').linkbutton('enable');$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);$('#editForm').form('reset');$('#editForm').form('load',data.user);	var acMoney = data.user.acMoney / 100;var medMoney = data.user.medMoney || 0;$('#acMoney').val(acMoney + '元');$('#medMoney').val(medMoney + '元');}else{$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);}});});});
			$('#btn-returnCard').click(function(){$('.readCardMessage').html($('.readCardMessage').html() + '<br/>退卡中，请稍候...');var option = {};option['userSerial'] = $('#userSerial').val();option['cardSerial'] = $('#cardSerial').val();option['cardHao'] = $('#cardHao').val();option['cardLx'] = $('#cardLx').val();YiYa.ajaxJson(urls['msUrl'] + 'cardController/returnCard.do',option,function(data){if(data.success){$('#btn-returnCard').linkbutton('disable');$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);}else{$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);}});});
			$('#btn-returnCard2').click(function(){var port = $('#port').combobox('getValue');YiYa.readCard(port,'readCardMessage',function(physicsCard){$('.readCardMessage').html($('.readCardMessage').html() + '<br/>补卡中，请稍候...');var option = {};option['userSerial'] = $('#userSerial').val();option['cardSerial'] = $('#cardSerial').val();option['cardHao'] = $('#cardHao').val();option['cardLx'] = $('#cardLx').val();option['physicsCard'] = physicsCard;YiYa.ajaxJson(urls['msUrl'] + 'cardController/upCard.do',option,function(data){if(data.success){$('#btn-returnCard2').linkbutton('disable');$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);}else{$('.readCardMessage').html($('.readCardMessage').html() + '<br/>' + data.msg);}});});});
		}
	}
	return _this;
}();

/*页面初始化*/
$(function(){
	YiYa.returnCard.init();
});		