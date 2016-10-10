<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <title>理发用品入库管理</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/barber/haircutStorage.js"></script>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">
 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">  
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
 	 	    		<label class="ui-label">名称：</label>
 	 	    		<input name="articlesName" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
        		</p>
        		<a id="btn-search" href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      			</form>  
     		</div> 

     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>
		<div  id="ArticlesList" class="easyui-dialog" style="width:900px;height:460px" data-options="title:'入库信息',modal:true,closed:true,iconCls:'icon-window',buttons: [{  text: '入库',    handler: function () {  sumbitForm(); } }, {text: '关闭',   handler: function () { $('#inventoryList').dialog('close'); }  }]">
		</div>	
		</div>
	</body>
</html>
