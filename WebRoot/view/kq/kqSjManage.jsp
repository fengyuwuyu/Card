<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	    <title>考勤时间管理</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/kq/kqSjManage.js"></script>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">
		
		    <form id="listForm" method="post">
		     	<table id="data-list"></table>
			</form> 

	     	<div id="edit-win" class="easyui-dialog" title="考勤时间设置对话框" data-options="width:400,height:200,closed:true,iconCls:'icon-window',modal:true">  
	     		<form id="editForm" class="ui-form" method="post">  
	     		<input class="hidden" type="text" name="id">
	     		<div class="ui-edit">
		           <div class="fitem">  
		           	   <label>时间类型：</label>  
		               <input name="type" id="type" type="text" class="easyui-combobox" data-options="valueField:'id',textField:'text',data:[{'id':1,'text':'上班时间'},{'id':2,'text':'下班时间'}],disabled:true,editable:false,panelHeight:'auto'"  />
		               
		           </div>  
		           <div class="fitem">  
		               <label>时间：</label>  
		               <input name="sj" id="sj" type="text" class="easyui-timespinner" data-options="showSeconds:true" />
		           </div> 
		        </div>
	     		</form>
	  	 	</div> 
  
  
  		</div>
  	</body>
</html>
