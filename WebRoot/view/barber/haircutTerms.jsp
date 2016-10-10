<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <title>理发用品管理</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/barber/haircutTerms.js"></script>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">
 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">  
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
 	 	    		<label class="ui-label">名称：</label>
 	 	    		<input name="termsName" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
        		</p>
        		<a id="btn-search" href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      			</form>  
     		</div> 

     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>

     		<div id="edit-win"   class="easyui-dialog" title="理发用品量词对话框" data-options="width:280,height:150,closed:true,iconCls:'icon-window',modal:true">  
     			<form id="editForm" class="ui-form" method="post">  
     		 	<input  type="hidden"    name="termsId">
     		 	<div class="ui-edit" style="margin-left: -50px;">
	           		<div class="fitem">  
	               		<label>名称：</label>
	          	 		<input class="easyui-validatebox ui-text" type="text" name="termsName" data-options="required:true,validType:'length[1,25]'">
	          	 	</div> 	            
	         	</div>
     			</form>
  	 		</div> 
		</div>
	</body>
</html>
