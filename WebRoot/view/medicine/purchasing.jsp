<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>药品代购</title>
    
	 <%@include file="../resource.jsp"%>  		
	 <script type="text/javascript" src="../../js/ux/medicine/purchasingGrid.js"></script>
	 <script type="text/javascript" src="../../js/ux/medicine/purchasing.js"></script>
  </head>
  
  <body>
   <div class="easyui-panel warp" data-options="border:false">
 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">  
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
 	 	    		<label class="ui-label">名称：</label>
 	 	    		<input name="medicineName" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
 	 	    		<label class="ui-label">状态：</label>
 	 	    		<select name="preType">
 	 	    			<option  value="-1">请选择</option>
 	 	    			<option value="0">未完成</option>
 	 	    			<option value="1">已完成</option>
 	 	    		</select>
        		</p>
        		<a id="btn-search" href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      			</form>  
     		</div> 

     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>

     		<div id="edit-win" class="easyui-dialog" title="代购对话框" data-options="width:500,height:450,closed:true,iconCls:'icon-window',modal:true">  
     			<form id="editForm" class="ui-form" method="post">  
   		 		<input name="preOrderId1"  type="hidden">
     		 	<input id="userSerial" name="cardNumber" type="hidden"> 
     		 	<div class="ui-edit">
	     	  		<div class="ftitle">人员信息</div>    
	           		<div class="fitem">  
	               		<label>卡号：</label>  
	               		<input  id="userCard" name="cardHao" type="text" class="easyui-validatebox" data-options="required:true" onchange="checkUser();" >&nbsp;&nbsp;&nbsp;
	           		</div> 
	           		<div class="fitem">  
	               		<label>员工姓名：</label>  
	               		<input id="userLname"  name="userLname" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	           		</div> 	            
	          	 	<div class="fitem">  
	               		<label>联系人电话：</label>  
	               		<input class="easyui-validatebox" type="text" name="phone"  id="phone"   required="required" validType="checkPhone['#phone']"   >
	           		</div>
	         	</div>
     			</form>
  	 		</div> 
		</div>
		<div  id="addMedcinePage" class="easyui-dialog" style="width:600px;height:430px" data-options="title:'药品信息',modal:true,closed:true,iconCls:'icon-window',buttons: [{  text: '确定',    handler: function () {  addMedicineMsg(true); } }, {text: '关闭',   handler: function () { $('#addMedcinePage').dialog('close'); }  }]">
		</div>
		<div  id="checkMedcine" class="easyui-dialog" style="width:600px;height:430px" data-options="title:'药品信息',modal:true,closed:true,iconCls:'icon-window',buttons: [{text: '关闭',  handler: function () { $('#checkMedcine').dialog('close'); }  }]">
		</div>
		 <div  id="medicineAmount" class="easyui-dialog" style="width:500px;height:300px" data-options="title:'提示',modal:true,closed:true,iconCls:'icon-window',buttons: [{  text: '确定',    handler: function () { $('#medicineAmount').dialog('close'); } }  ]">
		 <p class="ui-fields">
			<label class="ui-label">消费成功!</label>&nbsp;&nbsp;&nbsp;
   		</p>
		 <p class="ui-fields">
			<label class="ui-label">本次消费：</label>
	   		<input id="totalAmount1"  readonly="readonly" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
   		</p>
   		 <p class="ui-fields">
	   		<label class="userDepname">账户余额：</label>
	   		<input id="amount1"  readonly="readonly"  type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
   		</p>
   		<div  id="printPage" class="easyui-dialog" style="width:600px;height:430px" data-options="title:'药品信息',modal:true,closed:true,iconCls:'icon-window',buttons: [{  text: '打印',    handler: function () {  addMedicineMsg(true); } }, {text: '关闭',   handler: function () { $('#printPage').dialog('close'); }  }]">
		</div>
	</div>
  </body>
</html>
