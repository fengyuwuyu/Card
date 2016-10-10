<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>绑定就餐时间</title>

<%@include file="../resource.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ux/mess/messTimeManage.js"></script>
</head>
<body>
	<div class="easyui-panel warp" data-options="border:false">
		<div class="easyui-panel ui-search-panel" title="查询条件"
			data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">
			<form id="searchForm" method="post">
				<p class="ui-fields">
					<label class="ui-label">就餐区域：</label> <input name="depNo"
						id="depNo" type="text" class="easyui-combobox"
						data-options="valueField:'depNo',textField:'depName',panelHeight:'auto',method:'get',url:'${pageContext.request.contextPath}/regionController/select.do',editable:false">
				</p>
				<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        					<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
			</form>
		</div>


		<form id="listForm" method="post">
			<table id="data-list"></table>
		</form>

		<div id="edit-win" class="easyui-dialog" title="对话框"
			data-options="closed:true,iconCls:'icon-window',modal:true" style='width:450px;height:300px;'>
			<form id="editForm" class="ui-form" method="post">
				<input class="hidden" type="text" name="depSerial" id="depSerial">
				<div class="ui-edit">
					<div class="ftitle">就餐时间设置</div>
					<div class="fitem">
						<label>就餐区域：</label> <input class="easyui-validatebox ui-text"
							type="text" name="depName" id="depName"  style='width:200px;' disabled>
					</div>
					<div class="fitem">
						<label>已添加餐类：</label> <input class="easyui-validatebox ui-text" style='width:200px;'
							name="times" id="times" disabled></input>
					</div>
					<div class="fitem">
						<label>餐类：</label> <select name="addTimes" id="addTimes" data-options="required:true,editable:false" style='width:160px;'></select>
					</div>
				</div>
			</form>
		</div>

	</div>
</body>
</html>
