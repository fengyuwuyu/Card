<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>账号管理</title>
  	<%@include file="../resource.jsp"%>  		
  	<script type="text/javascript" src="../../js/ux/medicine/GridRecharge.js"></script>
	<script type="text/javascript" src="../../js/ux/medicine/recharge.js"></script>
  </head>
  
  <body>
   <div class="easyui-panel warp" data-options="border:false">
 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">  
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
 	 				<label class="ui-label">员工卡号：</label>
			   		<input  id="cardHao" name="cardHao" type="text" class="ui-text" >&nbsp;&nbsp;&nbsp;
 	 	    		<label class="ui-label">名称：</label>
 	 	    		<input name="userLname" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
        		<label class="ui-label">部门：</label>
            		<select name="depSerial" class="easyui-combotree" data-options="method:'get',url:'${msUrl}systemController/dtDepLoad.do',width:120,panelWidth:300,panelHeight:300,editable:false,animate:true,hasDownArrow:false,lines:true"></select>&nbsp;&nbsp;&nbsp;
        		</p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
       		    <div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
      			</form>  
     		</div> 

     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>


     		<div id="edit-win" class="easyui-dialog" title="充值对话框" data-options="width:290,height:130,closed:true,iconCls:'icon-window',modal:true">  
  	 			<form id="editForm" class="ui-form" method="post">  
     		 	<input  type="hidden"  name="accountId">
     		 	<div class="ui-edit">
	     	  	<!--	<div class="ftitle">药品信息</div>    
	           		 <div class="fitem">  
	               		<label>员工姓名：</label>  
	               		<input   readonly="readonly"  type="text" name="userLname" data-options="required:true,validType:'length[1,25]'">
	           		</div>  	            
	          	 	<div class="fitem">  
	               		<label>工号：</label>  
	               		<input  type="text"   readonly="readonly"  name="userNo" data-options="required:true,min:0,precision:2">
	          	 	</div> 
	          	 	<div class="fitem">  
	               		<label>性别：</label>  
	               		<input  readonly="readonly"  type="text" name="sexName" data-options="required:true,validType:'length[1,100]'">
	          	 	</div> 
	          	 	<div class="fitem">  
	               		<label>职务：</label>  
	               		<input   readonly="readonly"  type="text" name="userDuty"  id="barCode" data-options="required:true"  >
	           		</div> 
           			<div class="fitem">  
	               		<label>部门：</label>  
	               		<input   readonly="readonly"  type="text" name="userDepname"  >
	           		</div>   --> 
	           		<div class="fitem">  
	               		<label style="margin-left: -50px;">金额：</label>  
	               		<input   class="easyui-numberbox" type="text" name="money"  id="money" data-options="required:true,min:0,precision:2"  >
	           		</div>   	            
	         	</div>
     			</form>
  	 		</div> 
  	 	<!-- <div  id="batchRecharge" class="easyui-dialog" style="width:600px;height:300px" data-options="title:'批量充值对话框',modal:true,closed:true,iconCls:'icon-window',buttons: [{  text: '确定',    handler: function () {  uploadFile(); } }, {text: '关闭',   handler: function () { $('#batchRecharge').dialog('close'); }  }]">
				<form enctype="multipart/form-data" method="post" id="uploadForm">
				<h5>請選擇要上載的充值记录</h5>
						<ul>
							<li><span>選擇文件&nbsp;</span>
								<strong><input  class="easyui-filebox"  missingMessage="该输入项为必输项"   buttonText='选择文件'    data-options="required:true"   validType="fileupload['#_fileUpload']"    name="file"/></strong>
							</li>
							<li><span>支持格式&nbsp;</span>
								<font style="color:red;">excel文件格式為“.xls”</font>
							</li>
							<li><span>標準問卷模版&nbsp;</span>
								<a id="_uploadDemandTemplate" href="" style="color:blue;">下载充值标准模板</a>
							</li>
						</ul>
				</form>
		</div>	 -->
		
		<div  id="changeMoney" class="easyui-dialog" style="width:800px;height:500px" data-options="title:'人员对话框',modal:true,closed:true,iconCls:'icon-window',buttons: [{  text: '确定',    handler: function () {  openDialog(); } }, {text: '关闭',   handler: function () { $('#changeMoney').dialog('close'); }  }]">
		</div>
		
		<div  id="updateDialog" class="easyui-dialog" style="width:290px;height:200px" data-options="title:'转移金额对话框',modal:true,closed:true,iconCls:'icon-window',buttons: [{  text: '确定',    handler: function () {  changeMoney(); } }, {text: '关闭',   handler: function () { $('#updateDialog').dialog('close'); }  }]">
			<div class="ui-edit"  style="margin-left: 20px;margin-top: 30px;">
				<div class="fitem">  
	               		<label style="margin-left: -50px;">账户金额：</label>  
	               		<input  type="text"  id="userMoney" readonly="readonly"  >
	           		</div>
				<div class="fitem">  
	               		<label style="margin-left: -50px;">转移金额：</label>  
	               		<input   class="easyui-numberbox" type="text" name="updatemoney"  id="updatemoney" data-options="required:true,min:0,precision:2"  >
        		</div>  
  			</div>  
		</div>
			
   </div>
  </body>
</html>
