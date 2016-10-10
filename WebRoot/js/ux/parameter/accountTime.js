/*声明命名空间*/
$package('YiYa.accountTime');

/*封装变量（匿名自执行函数）*/
YiYa.accountTime = function(){
	var _box = null;
	var _this = {
		config:{
			action:{
  				save:urls['msUrl'] + 'parameterController/accountTimeSave.do',//保存Action  
  				getById:urls['msUrl'] + 'parameterController/accountTimeGetById.do',//查询Action
  				remove:urls['msUrl'] + 'parameterController/accountTimeDelete.do'//删除Action
  			},	
  			event:{
  				add:function(){
  					_box.handler.add(function(){//调用add方法
  						$('.disable').combobox('enable');
  					});
  				},
  				edit:function(){
  					_box.handler.edit(function(result){//调用edit方法	
  						$('.disable').combobox('disable');
  						var timeMaxM = result.data.timeMaxM / 100;
  						$('#timeMaxM').numberspinner('setValue',timeMaxM);
					});
  				}
  			},
  			dataGrid:{
	   			url:urls['msUrl'] + 'parameterController/accountTimeDataList.do',
	   			idField:'xh',
	   			columns:[[
	   			          {field:'ck',checkbox:true},
	   			          {field:'xh',hidden:true},
	   			          {field:'acName',title:'账户类型名称',align:'center',width:150,sortable:true},
	   			          {field:'lname',title:'时段名称',align:'center',width:150,sortable:true},
	   			          {field:'timeMaxM',title:'时段限额',align:'center',width:150,sortable:true,formatter:function(value,row,index){
		   			        	return value / 100 + '元';
						  }},
	   			          {field:'timeMaxT',title:'时段限次',align:'center',width:120,sortable:true,formatter:function(value,row,index){
							  	return value + '次';								
						  }},
	   			          {field:'timeLimit',title:'消费方式',align:'center',width:120,sortable:true,styler:function(value,row,index){
								if(value == 0){
								  	return 'color:#449d44;font-weight:bold;';  
								}
								if(value == 1){
								  	return 'color:#f0ad4e;font-weight:bold;'; 
								}
								if(value == 2){
								  	return 'color:#d9534f;font-weight:bold;'; 
								}
							},formatter:function(value,row,index){
								if(value == 0){
									return '不限制消费';
								}
								if(value == 1){
									return '限额限次';
								}
								if(value == 2){
									return '禁止消费';
								}
						  }},
						  {field:'sj',title:'操作变更时间',align:'center',width:150,sortable:true}
						]]
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

/*页面初始化*/
$(function(){
	YiYa.accountTime.init();
});		