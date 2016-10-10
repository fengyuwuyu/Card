<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
String status=(String)request.getParameter("status");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <title>医药管理</title>
	    <style>
		 #search{
		 	 display: inline-block;
		    font-size: 12px;
		    line-height: 20px;
		    margin: 0 4px;
		    padding: 0;
		    vertical-align: top;
		    width: auto;
		 }
	</style>
	<script type="text/javascript" src="../../js/ux/medicine/medicineLoad.js"></script>
	</head>
	<body>
	<input  type="hidden" id="status" value="${status}">
		<div class="easyui-panel warp" data-options="border:false">
		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">  
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
 	 	    		<label class="ui-label">名称：</label>
 	 	    		<input id="medicineName" name="medicineName" type="text" class="ui-text" >
        		</p>
        		<a id="search"  href="#" class="easyui-linkbutton" >查询</a>
      			</form>  
    		</div> 
     		<form id="listForm" method="post">
     			<table  class="easyui-datagrid" id="medicineLoad"></table>
     		</form>
		</div>
	</body>
</html>
