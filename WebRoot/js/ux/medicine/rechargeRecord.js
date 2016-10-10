/*声明命名空间*/
$package('YiYa.rechargeRecord');

/*封装变量（匿名自执行函数）*/
YiYa.rechargeRecord = function(){
	var _box = null;
	var _this = {
		config:{
  			dataGrid:{
	   			url:urls['msUrl'] + 'MedAccountController/dataList1.do',
	   			idField:'medicineId',
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'userSerial',hidden:true},
						{field:'depSerial',hidden:true},
						{field:'userLname',title:'员工姓名',align:'left',width:80,sortable:true},
						{field:'userNo',title:'工号',align:'center',width:80,sortable:true},
						{field:'userDepname',title:'部门',align:'center',width:150,sortable:true},
						//{field:'cardNumber',title:'医药账号',align:'center',width:150,sortable:true},
						{field:'amount',title:'账户余额',align:'center',width:100,sortable:true},
						{field:'amount1',title:'充值总金额',align:'center',width:100,sortable:true},
						{field:'childMenus',title:'充值信息',align:'center',width:120,formatter:function(value,row,index){
							var html ='<a href=\'#\' onclick=\'userMessage()\'>充值明细</a>';
							return html;
						}},
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
	YiYa.rechargeRecord.init();
	$("#btn-reset").click(function(){
		 $('#data-list').datagrid('load',{
	    });
	});
	
});	

$.extend($.fn.validatebox.defaults.rules, {
	validaDate: {
		validator: function(value, param){
		var beginDate=	$("#beginDate").datebox('getValue');
		var endDate=$("#endDate").datebox('getValue');
		var b=true;
		if(endDate!="" &&beginDate!=""){
			b=colomplteDate(beginDate,endDate);
		}
		return b;
		},
		message: '开始日期不能大于结束日期！'
	}
});

function  userMessage(){
	$("#userMessage").dialog("open").load(urls['msUrl'] + 'MedAccountController/userMessage.do');
}

function  colomplteDate (beg,end){
	  var date1 = new Date(Date.parse(beg));  
    var date2 = new Date(Date.parse(end));  
    if (date1.getTime() > date2.getTime()) {  
        return false;  
    }  
   return true; 
    
}

	