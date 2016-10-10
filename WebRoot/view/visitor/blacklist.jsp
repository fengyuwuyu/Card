<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	    <title>黑名单管理</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/visitor/blacklist.js"></script>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">


 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search'" style="width:97%;">
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
 	 	    		<label class="ui-label">姓名：</label>
 	 	    		<input name="userLname" type="text" class="ui-text">&nbsp;&nbsp;&nbsp; 	 	    		
 	 	    		<label class="ui-label">电话：</label>
 	 	    		<input name="userTelephone" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;   
 	 	    		<label class="ui-label">身份证号：</label>
 	 	    		<input name="userId" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;   		              			 	    		 	    		
 	 	    		<label class="ui-label">单位：</label>
 	 	    		<input name="userDepname" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;  	 	    			 	    		
            		<label class="ui-label">登记|修改时间：</label>
            		<input name="userSj" class="easyui-datebox" data-options="width:120,height:22,editable:false"></input>&nbsp;&nbsp;&nbsp;            		             		
        		</p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        		<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
      			</form>  
     		</div> 


     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>


     		<div id="edit-win" class="easyui-dialog" title="对话框" data-options="width:550,height:480,closed:true,iconCls:'icon-window',modal:true">  
     			<form id="editForm" class="ui-form" method="post">  
     		 	
     			</form>
  	 		</div> 
  	 		
  	 		
  	 		
  	 		
  	
		</div>
	</body>
</html>
