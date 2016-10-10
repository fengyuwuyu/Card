<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	    <title>账户时段</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/parameter/accountTime.js"></script>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">


 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search'" style="width:97%;">
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">	 	    		
 	 	    		<label class="ui-label">账户类型名称：</label>
 	 	    		<select name="acType" class="easyui-combobox" data-options="method:'get',url:'${msUrl}parameterController/accountLoad.do',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false,hasDownArrow:false"></select>&nbsp;&nbsp;&nbsp;
 	 	    		<label class="ui-label">时段名称：</label>
 	 	    		<select name="timeNo" class="easyui-combobox" data-options="method:'get',url:'${msUrl}parameterController/timeLoad.do',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false,hasDownArrow:false"></select>&nbsp;&nbsp;&nbsp;
        		</p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        		<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
      			</form>  
     		</div> 


     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>


     		<div id="edit-win" class="easyui-dialog" title="账户时段对话框" data-options="width:480,height:350,closed:true,iconCls:'icon-window',modal:true">  
     			<form id="editForm" class="ui-form" method="post">  
     		 	<input class="hidden" type="text" name="xh">
     		 	<div class="ui-edit">
     		 		<div class="ftitle">账户类型信息</div>    
	           		<div class="fitem">  
	               		<label>账户类型名称：</label>  
	               		<select name="acType" class="easyui-combobox disable" data-options="method:'get',url:'${msUrl}parameterController/accountLoad.do',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false,hasDownArrow:false,required:true"></select>
	           		</div>  
	     	  		<div class="ftitle">时段信息</div>    
	           		<div class="fitem">  
	               		<label>时段名称：</label>  
	               		<select name="timeNo" class="easyui-combobox disable" data-options="method:'get',url:'${msUrl}parameterController/timeLoad.do',valueField:'value',textField:'text',width:120,panelHeight:120,height:22,editable:false,hasDownArrow:false,required:true"></select>
	           		</div>  
	           		<div class="fitem">  
	               		<label>消费方式：</label>  
	               		<input class="consumeStyle" type="radio" name="timeLimit" value="0" checked>不限制消费	
	               		<input class="consumeStyle" type="radio" name="timeLimit" value="1">限额限次
	               		<input class="consumeStyle" type="radio" name="timeLimit" value="2">禁止消费		
	          	 	</div> 	
	           		<div class="fitem">  
	               		<label>时段限额：</label>  
	               		<input id="timeMaxM" name="timeMaxM" class="easyui-numberspinner" data-options="value:0,min:0,max:100,required:true,width:60,height:22,editable:false"> 
						<span>元</span>
						<label>时段限次：</label>  
	               		<input id="timeMaxT" name="timeMaxT" class="easyui-numberspinner" data-options="value:0,min:0,max:100,required:true,width:60,height:22,editable:false"> 
						<span>次</span>			
	          	 	</div> 		                   	 	
	         	</div>
     			</form>
  	 		</div> 

  	
		</div>
	</body>
</html>
