<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <title>医药分类</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/medicine/medicineType.js"></script>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">
 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">  
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
 	 	    		<label class="ui-label">名称：</label>
 	 	    		<input name="typeName" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
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
     		 	<input  type="hidden"  name="typeId">
     		 	<div class="ui-edit">
	     	  		<div class="ftitle">分类信息</div>    
	           		<div class="fitem">  
	               		<label>类型：</label>  
	               		<input class="easyui-validatebox ui-text" type="text" name="typeName" data-options="required:true,validType:'length[1,25]'">
	           		</div>  	            
	          	 	<div class="fitem">  
	               		<label>描述：</label>  
	               		<textarea class="easyui-validatebox" name="medicineDetailed" data-options="validType:'length[0,250]'"></textarea>
	               		<span>不超过125字</span>
	           		</div> 
	         	</div>
     			</form>
  	 		</div> 
		</div>
	</body>
</html>
