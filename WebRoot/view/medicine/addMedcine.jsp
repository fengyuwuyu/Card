<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>代购药品详细</title>
     <script type="text/javascript" src="../../js/ux/medicine/addMedcine.js"></script>
  </head>
  
  <body>
  <div class="easyui-panel warp" data-options="border:false">
  <input  type="hidden"  id="rowIndex">
  <input  type="hidden" id="totalAmount">
  <input  type="hidden" id="updateId" value="${updateId}">
	   	<form id="addInventoryForm" method="post">
	   	<p class="ui-fields">
		   		<label class="ui-label">员工卡号：</label>
		   		<input  id="userCard1" name="userCard" type="text" class="ui-text"  >&nbsp;&nbsp;&nbsp;
	     	<table id="addMedcine"></table>
		</form>
	</div>
  </body>
</html>
