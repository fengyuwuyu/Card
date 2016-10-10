<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>菜单管理</title>
    <%@include file="../resource.jsp"%>  	 	
	<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
  	<script type="text/javascript" src="../../js/ux/sys/sysMenu.js"></script>
  </head>
  <body>
	<div class="easyui-panel warp"  data-options="border:false">


 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search'" style="width:97%;">   
		 	 <form id="searchForm" method="post">
		 	 <input id='search_parentId' class="hidden" type="text" name="parentId">
		 	 <p class="ui-fields">
		        <label class="ui-label">菜单名称：</label> 
		     	<input name="menuName" class="ui-text">&nbsp;&nbsp;&nbsp;
		     </p>
		     <a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
       		 <div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
		     </form>  
     	</div> 
     	
     
	    <form id="listForm" method="post">
	    	<table id="data-list"></table>
	    </form> 
	    
	    
  	 	<div id="edit-win" class="easyui-dialog" title="菜单对话框" data-options="width:500,height:400,closed:true,iconCls:'icon-window',modal:true" >  
     		<form id="editForm" class="ui-form" method="post"> 
     		<input type="hidden" class="hidden" type="text" name="menuId">
    		<input id='edit_parentId' class="hidden" type="text" name="parentId">
   			<div class="ui-edit">  
            	<div class="ftitle">菜单信息</div>    
	           	<div class="fitem">  
	               	<label>菜单名称：</label>  
	               	<input class="easyui-validatebox ui-text" type="text" name="menuName" data-options="required:true,validType:'length[1,25]'">
	           	</div>  
	           	<div class="fitem">  
	               	<label>菜单排序：</label> 
	               	<input class="easyui-numberbox" type="text" name="sequence" data-options="width:120,height:22,required:true,min:0,max:100"> 		              		
	           	</div>  
	           	<div class="fitem">   
	               	<label>菜单路径：</label>  
	               	<input class="easyui-validatebox ui-text" type="text" name="url" data-options="validType:'length[0,50]'"></input>
	           	</div> 
	           	<div class="fitem">  
	               	<label>备注：</label>  
	               	<textarea class="easyui-validatebox" name="menuDes" data-options="validType:'length[0,50]'"></textarea>
	               	<span>不超过50字</span>
	           	</div> 
            </div>	            	    				
     		</form>    		
  	 	</div> 	 	
  	 	
	</div>	
	
	
	
  </body>
</html>
