<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>食堂用户数统计</title>

<%@include file="../resource.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ux/mess/whiteList.js"></script>
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
					<label class="ui-label">场所：</label>
							<select name="acdepSerial"
								id="acdepSerial1" class="easyui-combotree"
								data-options="method:'get',url:'${pageContext.request.contextPath}/messConsumeController/loadAcdep.do',panelWidth:220,panelHeight:220,editable:false,animate:true,hasDownArrow:false,lines:true"></select>
					<label class="ui-label">部门名称：</label> <select name="depSerials"
						id="depSerial1" class="easyui-combotree"
						data-options="multiple:true,method:'get',url:'${pageContext.request.contextPath}/messConsumeController/loadDep.do',panelWidth:220,panelHeight:220,editable:false,animate:true,hasDownArrow:false,lines:true"></select>&nbsp;&nbsp;&nbsp;
						<label class="ui-label">员工状态</label>
							<select name="userTypes" id="userTypes1" class="easyui-combobox" data-options="method:'get',url:'${msUrl}systemController/ttLizhiLoad.do',valueField:'value',textField:'text',width:100,height:22,panelHeight:100,editable:false,hasDownArrow:false,multiple:true"></select>&nbsp;&nbsp;&nbsp;
				</p>
				<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        		<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
			</form>
		</div>


		<form id="listForm" method="post">
			<table id="data-list"></table>
		</form>
		
		<div id="addWhiteList-window" class="easyui-dialog" title="为场所添加白名单" data-options="width:800,height:453,closed:true,iconCls:'icon-window',modal:true,buttons:'#dlg-buttons'" >
			<div class="easyui-panel warp" data-options="border:false">
				<div class="easyui-panel ui-search-panel"
					data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">
					<form id="whiteListForm" method="post">
						<p class="ui-fields">
							<label class="ui-label">场所：</label>
							<select name="acdepSerial"
								id="acdepSerial" class="easyui-combotree"
								data-options="method:'get',url:'${pageContext.request.contextPath}/messConsumeController/loadAcdep.do',panelWidth:220,panelHeight:220,editable:false,animate:true,hasDownArrow:false,lines:true"></select>
							<label class="ui-label">部门名称：</label> <select name="depSerials"
								id="depSerial" class="easyui-combotree"
								data-options="multiple:true,method:'get',url:'${pageContext.request.contextPath}/messConsumeController/loadDep.do',panelWidth:220,panelHeight:220,editable:false,animate:true,hasDownArrow:false,lines:true"></select>
							<label class="ui-label">员工状态</label>
							<select name="userTypes" id="userTypes" class="easyui-combobox" data-options="method:'get',url:'${msUrl}systemController/ttLizhiLoad.do',valueField:'value',textField:'text',width:100,height:22,panelHeight:100,editable:false,hasDownArrow:false,multiple:true"></select>&nbsp;&nbsp;&nbsp;
						</p>
						<a id="btn-search1" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset1" plain="false">查询</a>
		        		<div id="menu-reset1"><div id="btn-reset1" iconCls="icon-reset">重置</div></div>
					</form>
				</div>

				<form id="whiteListForm" method="post">
					<table id="addWhiteListTable"></table>
				</form>
			</div>
  	 	</div>
  	 	<div id="dlg-buttons">
				<!-- <a id="btn-save2" class="easyui-linkbutton">提交</a> -->
				<a id="btn-close2" href="#" class="easyui-linkbutton">关闭</a>
		</div>
	</div>
</body>
</html>
