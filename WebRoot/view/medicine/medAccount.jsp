<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>账号管理</title>
  	<%@include file="../resource.jsp"%>  		
  	<script type="text/javascript" src="../../js/ux/medicine/GridMedAccount.js"></script>
	<script type="text/javascript" src="../../js/ux/medicine/medAccount.js"></script>
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
        			<label class="ui-label">特殊用户：</label>
        			<select name="accType1">
        				<option value="">请选择</option>
        				<option value="0">否</option>
        				<option value="1">是</option>
        			</select>
        		</p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
       		    <div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
      			</form>  
     		</div> 

     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>


     		<div id="edit-win" class="easyui-dialog" title="账号对话框" data-options="width:500,height:450,closed:true,iconCls:'icon-window',modal:true">  
  	 			<form id="editForm" class="ui-form" method="post">  
     		 	<input  type="hidden"  name="amount">
     		 	<input  type="hidden"  name="accountId">
     		 	<div class="ui-edit">
	     	  		<div class="ftitle">员工信息</div>    
	           		<div class="fitem">  
	               		<label>员工姓名：</label>  
	               		<input   readonly="readonly"  type="text" name="userLname" >
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
	               		<input   readonly="readonly"  type="text" name="userDuty"  id="barCode" data-options="required:true"  validType="validteNum['#barCode']" >
	           		</div> 
           			<div class="fitem">  
	               		<label>部门：</label>  
	               		<input   readonly="readonly"  type="text" name="userDepname"  id="barCode" data-options="required:true"  validType="validteNum['#barCode']" >
	           		</div>  
	           		<div class="fitem">  
	               		<label>特殊用户：</label>  
	               		<select  id="accType" name="accType1">
	               			<option value="0">否</option>
	               			<option value="1">是</option>
	               		</select>
	           		</div> 	            
	         	</div>
     			</form>
  	 		</div> 
   </div>
  </body>
</html>
