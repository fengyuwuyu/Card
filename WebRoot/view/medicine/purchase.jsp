<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>员工领药</title>
   	<%@include file="../resource.jsp"%>  		
	<script type="text/javascript" src="../../js/ux/medicine/purchase.js"></script>
	

  </head>
  
  <body>
  <input  type="hidden"  id="rowIndex">
   <div class="easyui-panel warp" data-options="border:false">
	<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">  
			<form id="searchForm" method="post">
			<p class="ui-fields">
		   		<label class="ui-label">员工卡号：</label>
		   		<input  id="userCard" name="userCard" type="text" class="ui-text"  oninput="checkUser();" >&nbsp;&nbsp;&nbsp;
		   		<label class="ui-label">药品条码：</label>
		   		<input  type="text" id="barCode1"  class="ui-text"    onkeypress="getkey();"  >&nbsp;&nbsp;&nbsp;
		   		<label class="ui-label">药品名称：</label>
		   		<input  type="text" class="ui-text"   onclick="checkMedicine();">&nbsp;&nbsp;&nbsp;
	   			<input  type="hidden"  id="barCode" >
	   			<input  type="hidden"  id="medicineId">
	   		</p>
 			</form>  
	</div> 
	<div  style="height: 80px;width:1100"  class="easyui-panel warp" data-options="border:true">
		<form id="userMessage" method="post">
		<p class="ui-fields">
				<input id="userSerial"  type="hidden">
				<input id="accType1"  type="hidden">
	 			<label class="ui-label">员工姓名：</label>
 	    		<input id="userLname"   readonly="readonly" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	    		<label class="ui-label">公司：</label>
 	    		<input id="userDepname"  readonly="readonly" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
 	    		<label class="ui-label">职务：</label>
 	    		<input name="userDuty"  id="userDuty"  readonly="readonly"  type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
 	   <p>
 	   <p class="ui-fields">
	 			<label class="ui-label">账户余额：</label>
 	    		<input name="amount" id="amount"  readonly="readonly" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	   <p>
		<label class="ui-label"  style="margin-left:577px;">消费总计：</label>
   		<input id="totalAmount" type="text" class="ui-text"  readonly="readonly" >&nbsp;&nbsp;&nbsp;
	</form>
	</div>
  		<form id="listForm" method="post">
  			<table id="data-list"></table>
  		</form>
   </div>
   <div  id="tiXian" class="easyui-dialog" style="width:450px;height:450px" data-options="title:'提现信息',modal:true,closed:true,iconCls:'icon-window',buttons: [{  text: '确定',    handler: function () {  submitForm(); } }, {text: '关闭',   handler: function () { $('#tiXian').dialog('close'); }  }]">
	<form id="settlementForm"  method="post">
	<input id="userSerial1" name="cardNumber" type="hidden">
	<input id="accType11"  name="type"  type="hidden">
	<div class="fitem" style="margin-top: 15px;">
		<label class="ui-label">员工卡号：</label> 
		<input id="userCard1" name="userCard1" class="easyui-validatebox ui-text" type="text" required="true" oninput="checkUser1();">
	</div>
	<div class="fitem">
		<label class="ui-label">员工姓名：</label> <input id="userLname1"  readonly="readonly" type="text" class="ui-text">
	</div>
	<div class="fitem">
		<label class="ui-label">公司：</label> <input id="userDepname1"	readonly="readonly" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
	</div>
	<div class="fitem">
		<label class="ui-label">职务： </label> <input id="userLname1"  readonly="readonly" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
	</div>
	<div class="fitem">
		<label class="ui-label">账户余额：</label> <input name="amount1" id="amount11"  readonly="readonly" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<div class="fitem">
		<label class="ui-label">消费金额：</label>
		 <input  class="easyui-numberbox ui-text" id="money"  name="money" data-options="required:true,min:0,precision:2">
	</div>
		<label  style="margin-left: 65px;margin-top: 50px;" class="ui-label">备注：</label> 
	<div>
		<textarea rows="12" cols="35"   name="remarks"  class="easyui-validatebox"  required="true" data-options="validType:'length[0,250]'"  style="margin-left: 108px;margin-top: -10px;" ></textarea>
	</div>
	</form>	
	<div  id="medicine" class="easyui-dialog" style="width:500px;height:300px" data-options="title:'提示',modal:true,closed:true,iconCls:'icon-window',buttons: [{  text: '确定',    handler: function () { closeDialog();  } }  ]">
		<div style="margin-left: 160px; width: 200px;height: 50px;margin-top: 50px;"  >
			<p class="ui-fields">
				<label class="ui-label" style="font-size: 30px;">消费成功!</label>&nbsp;&nbsp;&nbsp;
   			</p>&nbsp;&nbsp;&nbsp;
			 <p class="ui-fields">
				&nbsp;<label class="ui-label" style="font-size: 20px;" id="totalAmount111" >本次消费:</label>
	   		</p>
			 <p class="ui-fields">
		   		&nbsp;<label class="userDepname" style="font-size: 20px;"  id="accountMoney11">账户余额:</label>
	   		</p>
	   	</div>
	 </div>
	 
	 <div  id="accountMoney" class="easyui-dialog" style="width:500px;height:300px" data-options="title:'提示',modal:true,closed:true,iconCls:'icon-window',buttons: [{  text: '确定',    handler: function () { closeAccountMoney();  } }  ]">
		<div style="margin-left: 100px;height: 50px;margin-top: 50px;"  >
			<p class="ui-fields">
				<label class="ui-label" style="font-size: 25px;">账户余额不足，请充值！</label>&nbsp;&nbsp;&nbsp;
   			</p>
		
		</div>
		<div style="margin-left: 100px;">
			 <p class="ui-fields">
				<label class="ui-label" style="font-size: 20px;"  id="accountMoneyMsg">账户余额:</label>
	   		</p>
		</div>
	 </div>
	</div>
	<div  id="medicineMsg" class="easyui-dialog" style="width:900px;height:500px" data-options="title:'药品信息',modal:true,closed:true,iconCls:'icon-window',buttons: [{  text: '确定',    handler: function () {  getSelected(); } }, {text: '关闭',   handler: function () { $('#medicineMsg').dialog('close'); }  }]">
	</div>
  </body>
</html>
