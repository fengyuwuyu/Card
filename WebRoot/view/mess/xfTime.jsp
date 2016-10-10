<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <title>就餐时间控制</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ux/mess/xfTime.js"></script>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">
     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>


     		<div id="edit-win" class="easyui-dialog" title="编辑就餐时间" data-options="closed:true,iconCls:'icon-window',modal:true"  style="width:500px;height:450px;">  
     			<form id="editForm" class="ui-form" method="post">  
     		 	<input class="hidden" type="text" name="userSerial">     		 	
     		 	<input class="hidden" type="text" name="bh">     		 	
     		 	<div class="ui-edit">
	               	<div class="fitem">  
	               		<label>餐类：</label>  
	               		<input name="lname" class="easyui-textbox" type="text" id="timeType" data-options="required:true,missingMessage:'该输入项为必输项'">
	               	</div>  
	               	<div class="fitem"> 
	               		<label>开始时间：</label>  
	               		<input name="kssj" class="easyui-timespinner" type="text" data-options="showSeconds:true,required:true,missingMessage:'该输入项为必输项'" >
	               	</div>  
	               	<div class="fitem">  
     		 			<label>结束时间：</label>  
	               		<input name="jssj" class="easyui-timespinner" type="text" data-options="showSeconds:true,required:true,missingMessage:'该输入项为必输项'" >
	               	</div> 
	         	</div>
     			</form>
  	 		</div> 
  	 		
  	 		<!-- <div id="dlg-buttons">
				<a id="btn-save" href="#" class="easyui-linkbutton">保存</a>
				<a id="btn-close" href="#" class="easyui-linkbutton">关闭</a>
			</div> -->
  	
		</div>
	</body>
</html>
