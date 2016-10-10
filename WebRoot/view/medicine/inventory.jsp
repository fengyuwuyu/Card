<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <title>库存管理</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/ux/medicine/YDataGridUpdate.js"></script>
		<script type="text/javascript" src="../../js/ux/medicine/inventory.js"></script>
	</head>
	
	<body>
		<div class="easyui-panel warp" data-options="border:false">
 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">  
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
 	 				<label>条码：</label>  
	               	<input class="easyui-textbox"  type="text" name="barCode"  id="barCode" >
 	 	    		<label class="ui-label">名称：</label>
 	 	    		<input  id="medicineName1" type="text" class="ui-text"  onclick="checkMedicine();">
        		</p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
       		    <div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
      			</form>  
    		</div> 
     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>
		</div>
		<div  id="medicine" class="easyui-dialog" style="width:900px;height:500px" data-options="title:'药品信息',modal:true,closed:true,iconCls:'icon-window',buttons: [{  text: '确定',    handler: function () {  getSelected(); } }, {text: '关闭',   handler: function () { $('#medicine').dialog('close'); }  }]">
		</div>
		<div  id="inventoryList" class="easyui-dialog" style="width:900px;height:460px" data-options="title:'入库信息',modal:true,closed:true,iconCls:'icon-window',buttons: [{  text: '入库',    handler: function () {  sumbitForm(); } }, {text: '关闭',   handler: function () { $('#inventoryList').dialog('close'); }  }]">
		</div>	
		<div  id="import" class="easyui-dialog" style="width:400px;height:150px" data-options="title:'下载页面',modal:true,closed:true,iconCls:'icon-window'">
		<input  type="hidden" id="importtext">
			<p  style="font-size: 16px;margin-left: 100px;">导出成功,请下载文件！</p>
		<a   id="importExcel" onclick="downLoadFile();" style="cursor: pointer;font-size: 16px;margin-left: 160px;" >点击下载</a>
		</div>
		<div  id="updateInventory" class="easyui-dialog" style="width:300,height:200" data-options="title:'库存对话框',modal:true,closed:true,iconCls:'icon-window',buttons: [{  text: '确定',    handler: function () {   updateInventory(); } }, {text: '关闭',   handler: function () { $('#updateInventory').dialog('close'); }  }]">
		<form id="InventoryForm" class="ui-form" method="post"> 
		<div class="ui-edit">
				<input  type="hidden"  name="inventoryId"  id="updateinventoryId">
	     	  		<div class="ftitle">库存信息</div>    
	           		<div class="fitem">  
	               		<label>名称：</label>  
	               		<input class="easyui-validatebox ui-text" type="text"  id="medicineName" name="medicineName" readonly="readonly">
	           		</div>  	            
	          	 	<div class="fitem">  
	               		<label>价格：</label>  
	               		<input class="easyui-validatebox ui-text" type="text" id="mednicePrice" name="price" readonly="readonly">
	          	 	</div> 
	          	 	<div class="fitem">  
	               		<label>库存数量：</label>  
	               		<input class="easyui-numberbox ui-text" type="text"  id="quantity" name="quantity">
	          	 	</div> 
	         	</div>
		</form>	
		</div>
		
	</body>
</html>
