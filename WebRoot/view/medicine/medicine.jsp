<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <title>医药管理</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/medicine/medicine.js"></script>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">
 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">  
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
 	 				<label>条码：</label>  
	               	<input class="easyui-textbox"  type="text" name="barCode"  id="barCode" >
 	 	    		<label class="ui-label">名称：</label>
 	 	    		<input name="medicineName" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
        		</p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
       		    <div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
      			</form>  
     		</div> 

     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>

     		<div id="edit-win" class="easyui-dialog" title="药品对话框" data-options="width:500,height:450,closed:true,iconCls:'icon-window',modal:true">  
     			<form id="editForm" class="ui-form" method="post">  
     		 	<input  type="hidden"  name="medicineId">
     		 	<div class="ui-edit">
	     	  		<div class="ftitle">药品信息</div>    
	           		<div class="fitem">  
	               		<label>名称：</label>  
	               		<input class="easyui-validatebox ui-text" type="text" name="medicineName" data-options="required:true,validType:'length[1,25]'">
	           		</div>  	            
	          	 	<div class="fitem">  
	               		<label>价格：</label>  
	               		<input class="easyui-numberbox ui-text" type="text" name="price" data-options="required:true,min:0,precision:2">
	          	 	</div> 
	          	 	<div class="fitem">  
	               		<label>条码：</label>  
	               		<input class="easyui-textbox"  type="text" name="barCode"  id="barCode"  >
	           		</div>
	           		<div class="fitem">  
	               		<label>药品类型：</label>
	               		<select name="medicineType"  id="medicineType" class="easyui-combobox" data-options="method:'get',url:'${msUrl}MedicineController/selectType.do',valueField:'typeId',textField:'typeName',mode:'local',delay:0,filter:function(q,row){var opts = $(this).combobox('options');return row[opts.textField].indexOf(q)>-1;},width:100,panelHeight:120,editable:false"></select>&nbsp;&nbsp;&nbsp;
	          	 	</div>   	            
	          	 	<div class="fitem">  
	               		<label>生产厂家：</label>  
	               		<input class="ui-text" type="text" name="vendor" data-options="required:true,validType:'length[1,100]'">
	          	 	</div> 
	          	 	<div class="fitem">  
	               		<label>药品描述：</label>  
	               		<textarea class="easyui-validatebox" name="medicineDesc" data-options="validType:'length[0,250]'"></textarea>
	               		<span>不超过125字</span>
	           		</div> 
	         	</div>
     			</form>
  	 		</div> 
		</div>
	</body>
</html>
