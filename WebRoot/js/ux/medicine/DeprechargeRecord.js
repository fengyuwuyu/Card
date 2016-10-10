/*声明命名空间*/
$package('YiYa.DeprechargeRecord');

/*封装变量（匿名自执行函数）*/
YiYa.DeprechargeRecord = function(){
	var _box = null;
	var _this = {
		config:{
			treeGrid:{
	   			url:urls['msUrl'] + 'MedAccountController/dataList2.do',
	   			idField:'depSerial',
	   			treeField:'depName',
	   			pagination:"false",
	   			height:475,
	   			animate:true,
				checkbox:true,
				cascadeCheck:true,
				singleSelect:false,
	   			columns:[[
						{field:'ck',checkbox:true},
						{field:'depSerial',hidden:true},
						{field:'depName',title:'单位',align:'center',width:150,sortable:true},
						{field:'amount1',title:'充值总金额',align:'center',width:100,sortable:true},
						{field:'childMenus',title:'充值信息',align:'center',width:120,formatter:function(value,row,index){
							var html ='<a href=\'#\' onclick=\'userMessage()\'>充值明细</a>';
							return html;
						}},
				]],
				toolbar:[
				         	{id:'btn-export',text:'导出',btnType:'add',iconCls:'icon-uncompress',handler:function(){
				         	var ids=$('#data-list').treegrid('getSelections');
				         	if(ids.length==0){
				         		 YiYa.alert('警告','未选中记录！','warning');  
				         		return;
				         	}
				         	var depSerials="";
				         	for(var i=0;i<ids.length;i++){
				         		depSerials+=ids[i].depSerial+",";
				         	}
				         	$("#depSerials").val(depSerials);
				         		$('#searchForm').form('submit', {    
								    url:urls['msUrl'] + 'MedAccountController/ExportExcel1.do', 
								    success:function(data){    
								      if(data.success){
								    	  YiYa.alert('提示',data.msg,'ok');  
								      }else{
								    	  YiYa.alert('警告信息','导出失败，请重试！','warning');  
								    	  return false;  
								      }
								    }    
								});  
				         	}}  
				         ]
			}
		},
		init:function(){
			_box =  new YTreeGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

/*页面初始化*/
$(function(){
	YiYa.DeprechargeRecord.init();
	$("#btn-reset").click(function(){
		 $('#data-list').treegrid('load',{
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
	$('#data-list').treegrid('clearChecked');
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

	