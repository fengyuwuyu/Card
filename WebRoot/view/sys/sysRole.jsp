<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	    <title>角色管理</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/sys/sysRole.js"></script>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">
		
		
 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search'" style="width:97%;">
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
            		<label class="ui-label">角色名称：</label> 
            		<input name="roleName" class="ui-text">&nbsp;&nbsp;&nbsp;  
	        		<label class="ui-label">角色状态：</label>
	           		<select class="easyui-combobox" name="roleStatus" data-options="width:100,height:23,panelHeight:72,editable:false">
	                	<option value="" selected="selected">-- 请选择 --</option>
	                  	<option value="0">启用</option>
	                  	<option value="1">禁用</option>
	                </select>&nbsp;&nbsp;&nbsp;
                </p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        		<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
      			</form>  
     		</div> 
     

		    <form id="listForm" method="post">
		     	<table id="data-list"></table>
			</form> 


	     	<div id="edit-win" class="easyui-dialog" title="角色对话框" data-options="width:500,height:450,closed:true,iconCls:'icon-window',modal:true">  
	     		<form id="editForm" class="ui-form" method="post">  
	     		<input class="hidden" type="text" name="roleId">
	     		<div class="ui-edit">
		     	   <div class="ftitle">角色信息</div>    
		           <div class="fitem">  
		               <label>角色名称：</label>  
		               <input class="easyui-validatebox ui-text" type="text" name="roleName" data-options="required:true,validType:'length[1,25]'">
		           </div>  
		           <div class="fitem">  
		               <label>角色状态：</label>  
		               <select class="easyui-combobox" name="roleStatus" data-options="width:100,height:23,panelHeight:48,editable:false">
	                    	<option value="0">启用</option>
	                    	<option value="1">禁用</option>
	                   	</select>
		           </div>		           
		           <div class="fitem">  
		               <label>角色权限：</label>
		               <div class="menu-tree">  
		               		<ul id="menu-tree"></ul>
		               </div>
		           </div>		           
		           <div class="fitem">  
		               <label>备注：</label>  
		               <textarea class="easyui-validatebox" name="roleDes" data-options="validType:'length[0,50]'"></textarea>
		               <span>不超过50字</span>
		           </div>
		        </div>
	     		</form>
	  	 	</div> 
  
  
  		</div>
  	</body>
</html>
