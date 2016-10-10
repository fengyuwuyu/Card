<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	    <title>授权记录</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/impower/record.js"></script>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">


 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search'" style="width:97%;">
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">	 	    		
 	 	    		<label class="ui-label">用户姓名：</label>
	 	    		<input name="userLname" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
 	 	    		<label class="ui-label">部门：</label>
            		<select name="depSerial" class="easyui-combotree" data-options="method:'get',url:'${msUrl}systemController/dtDepLoad.do',width:120,height:22,panelWidth:300,panelHeight:300,editable:false,animate:true,hasDownArrow:false,lines:true"></select>&nbsp;&nbsp;&nbsp;
            		<label class="ui-label">门名称：</label>
	 	    		<input name="doorName" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
 	 	    		<label class="ui-label">场所：</label>
            		<select name="acDepSerial" class="easyui-combotree" data-options="method:'get',url:'${msUrl}impowerController/siteLoad.do',width:120,height:22,panelWidth:300,panelHeight:300,editable:false,animate:true,hasDownArrow:false,lines:true"></select>&nbsp;&nbsp;&nbsp;
            		<label class="ui-label">方向：</label>
            		<select class="easyui-combobox" name="fx" data-options="width:100,height:23,panelHeight:72,editable:false">
	                	<option value="" selected="selected">-- 请选择 --</option>
	                  	<option value="0">进门</option>
	                  	<option value="1">出门</option>
	                </select>&nbsp;&nbsp;&nbsp;
        		</p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        		<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
      			</form>  
     		</div> 


     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>


     		<div id="edit-win" class="easyui-dialog" title="消费时段对话框" data-options="width:500,height:450,closed:true,iconCls:'icon-window',modal:true">  
     			<form id="editForm" class="ui-form" method="post">  
     		 	
     			</form>
  	 		</div> 

  	
		</div>
	</body>
</html>
