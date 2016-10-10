<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>食堂用户数统计</title>

<%@include file="../resource.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ux/mess/depNumQuery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ux/mess/mess.js"></script>
<style type="text/css">
select{
	width : 120px;
}
</style>
</head>
<body>
	<div class="easyui-panel warp" data-options="border:false">
		<div class="easyui-panel ui-search-panel" title="查询条件"
			data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">
			<form id="searchForm" method="post">
				<p class="ui-fields">
					<label class="ui-label">部门名称：</label> <select name="depSerial"
						id="depSerial" class="easyui-combotree"
						data-options="multiple:true,method:'get',url:'${pageContext.request.contextPath}/messConsumeController/loadDep.do',panelWidth:220,panelHeight:220,editable:false,animate:true,hasDownArrow:false,lines:true"></select>&nbsp;&nbsp;&nbsp;
				</p>
				<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        					<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
				<td ><a id="btn-export" href="${pageContext.request.contextPath}/kqRecordController/exportExcel.do?type=1&filename=_depNum.xls"
							class="easyui-linkbutton" data-options="iconCls:'icon-load'" >导出Excel</a></td>
			</form>
		</div>


		<form id="listForm" method="post">
			<table id="data-list"></table>
		</form>
	</div>
</body>
</html>
