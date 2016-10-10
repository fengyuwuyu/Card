/*声明命名空间*/
$package('YiYa.account');

/*封装变量（匿名自执行函数）*/
YiYa.account = function(){
	var _box = null;
	var _this = {
		config:{
			action:{
  				save:urls['msUrl'] + 'parameterController/accountSave.do',//保存Action  
  				getById:urls['msUrl'] + 'parameterController/accountGetById.do',//查询Action
  				remove:urls['msUrl'] + 'parameterController/accountDelete.do'//删除Action
  			},	
  			event:{
  				add:function(){
  					_box.handler.add(function(){//调用add方法
  						$('.cycleDate').show();
  						$('.fixedDate').hide();
  						$('.easyui-datebox').datebox('disableValidation');
  					});
  				},
  				edit:function(){
  					_box.handler.edit(function(result){//调用edit方法	
  						var dayMaxM = result.data.dayMaxM / 100;
  						$('#dayMaxM').numberspinner('setValue',dayMaxM);
  						var timeMaxM = result.data.timeMaxM / 100;
  						$('#timeMaxM').numberspinner('setValue',timeMaxM);
  						var tallyMaxM = result.data.tallyMaxM / 100;
  						$('#tallyMaxM').numberspinner('setValue',tallyMaxM); 						
  						var acLimit = result.data.acLimit;
  						var acJssj = result.data.acJssj;
  						if(acLimit == 0 && acJssj != null){ 							
  							$('.dateFormatter:eq(1)').prop('checked',true);
  							$('.cycleDate').hide();
  	  						$('.fixedDate').show();
  	  						$('.easyui-datebox').datebox('enableValidation');
  						}else{
  							$('.dateFormatter:eq(0)').prop('checked',true);
  							$('.cycleDate').show();
  	  						$('.fixedDate').hide();   
  	  						$('.easyui-datebox').datebox('disableValidation');
  						}  						
					});
  				}
  			},
  			dataGrid:{
	   			url:urls['msUrl'] + 'parameterController/accountDataList.do',
	   			idField:'acBh',
	   			columns:[[
	   			          {field:'ck',checkbox:true,rowspan:2},
	   			          {field:'acBh',hidden:true,rowspan:2},
	   			          {field:'acName',title:'账户类型名称',align:'center',width:150,sortable:true,rowspan:2},
	   			          {title:'有效日期',align:'center',colspan:3},
	   			          {title:'限额限次',align:'center',colspan:3}
						],[
						  {field:'acLimit',title:'周期',align:'center',width:120,sortable:true},
						  {field:'acUnit',title:'单位',align:'center',width:120,sortable:true,formatter:function(value,row,index){
								if(value == 0){
									return '年';
								}
								if(value == 1){
									return '月';
								}
								if(value == 2){
									return '日';
								}
						  }},
						  {field:'acJssj',title:'结束日期',align:'center',width:120,sortable:true},
						  {field:'dayMaxM',title:'当日限额',align:'center',width:110,sortable:true,formatter:function(value,row,index){
							  return value / 100 + '元';
						  }},
						  {field:'dayMaxT',title:'当日限次',align:'center',width:110,sortable:true,formatter:function(value,row,index){
							  	return value + '次';								
						  }},
						  {field:'timeMaxM',title:'单次限额',align:'center',width:110,sortable:true,formatter:function(value,row,index){
							  return value / 100 + '元';
						  }}
						]]
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
			$('.dateFormatter').change(function(){var v = $('.dateFormatter:checked').val();if(v == 0){$('.cycleDate').show();$('.fixedDate').hide();$('.easyui-datebox').datebox('setValue','');$('.easyui-datebox').datebox('disableValidation');}else{$('.cycleDate').hide();$('.fixedDate').show();$('#acLimit').numberspinner('setValue',0);$('.easyui-datebox').datebox('enableValidation');}});
		}
	}
	return _this;
}();

/*页面初始化*/
$(function(){
	YiYa.account.init();
});		