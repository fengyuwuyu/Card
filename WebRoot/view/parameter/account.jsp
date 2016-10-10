<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	    <title>账户类型</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/parameter/account.js"></script>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">


 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search'" style="width:97%;"> 
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">	 	    		
 	 	    		<label class="ui-label">账户类型名称：</label>
 	 	    		<input name="acName" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
        		</p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        		<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
      			</form>  
     		</div> 


     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>


     		<div id="edit-win" class="easyui-dialog" title="账户类型对话框" data-options="width:480,height:350,closed:true,iconCls:'icon-window',modal:true">  
     			<form id="editForm" class="ui-form" method="post">  
     		 	<input class="hidden" type="text" name="acBh">
     		 	<div class="ui-edit">
	     	  		<div class="ftitle">基本信息</div>    
	           		<div class="fitem">  
	               		<label>类型名称：</label>  
	               		<input name="acName" class="easyui-validatebox ui-text" type="text" data-options="required:true,validType:'length[1,25]'">
	           		</div>  	            
	          	 	<div class="fitem">  
	               		<label>当日限额：</label>  
	               		<input id="dayMaxM" name="dayMaxM" class="easyui-numberspinner" data-options="value:0,min:0,max:1000,required:true,width:60,height:22,editable:false"> 
						<span>元</span>
						<label>当日限次：</label>  
	               		<input name="dayMaxT" class="easyui-numberspinner" data-options="value:0,min:0,max:100,required:true,width:60,height:22,editable:false"> 
						<span>次</span>			
	          	 	</div> 	 
	          	 	<div class="fitem">  	          
						<label>单次限额：</label>  
	               		<input id="timeMaxM" name="timeMaxM" class="easyui-numberspinner" data-options="value:0,min:0,max:100,required:true,width:60,height:22,editable:false"> 
						<span>元</span>
	          	 	</div> 	          	 	
	          	 	<div class="fitem">  
	               		<label>记账限额：</label>  
	               		<input id="tallyMaxM" name="tallyMaxM" class="easyui-numberspinner" data-options="value:0,min:0,max:1000,required:true,width:60,height:22,editable:false"> 
						<span>元</span>
						<label>记账限次：</label>  
	               		<input name="tallyMaxT" class="easyui-numberspinner" data-options="value:0,min:0,max:100,required:true,width:60,height:22,editable:false"> 
						<span>次</span>
	          	 	</div>
	          	 	<div class="ftitle">时效信息</div>    
	          	 	<div class="fitem">  
	               		<label>有效日期：</label> 
	               		<input class="dateFormatter" type="radio" name="rad" value="0" checked />使用周期设置
	               		<input class="dateFormatter" type="radio" name="rad" value="1"/>使用固定日期
	           		</div> 
	          	 	<div class="fitem cycleDate">  
	               		<label>周期设置：</label> 
	               		<input id="acLimit" name="acLimit" class="easyui-numberspinner" data-options="value:0,min:0,max:100,required:true,width:60,height:22,editable:false"> 
	               		<select name="acUnit" class="easyui-combobox" data-options="width:60,height:22,panelHeight:72,editable:false">
	                   		<option value="0" selected>年</option>
	                   		<option value="1">月</option>
	                   		<option value="2">日</option>
	                  	</select>
	           		</div> 
	           		<div class="fitem fixedDate">  
	               		<label>固定日期：</label>  
	               		<input name="acJssj" class="easyui-datebox" data-options="width:100,height:22,required:true,editable:false"></input>
	           		</div> 
	         	</div>
     			</form>
  	 		</div> 

  	
		</div>
	</body>
</html>
