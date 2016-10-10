<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>入库信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="../../js/ux/medicine/addInventory.js"></script>
  </head>
  
  <body>
	<div class="easyui-panel warp" data-options="border:false">
		<p class="ui-fields">
    		<label class="ui-label">条码：</label>
    		<input id="barCode1" type="text"  onkeypress="getkey();"   class="ui-text">&nbsp;&nbsp;&nbsp;
    		<input  type="hidden"  id="barCode">
   		</p>
	   	<form id="addInventoryForm" method="post">
	     	<table id="addInventory"></table>
		</form>
	</div>
  </body>
</html>
