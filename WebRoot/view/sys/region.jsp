<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>场所管理</title>
    <%@include file="../resource.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/commons/YTreeGrid.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/ux/sys/region.js"></script>
  </head>
  
  <body>
  	<div class="easyui-panel warp" data-options="border:false">
		<div class="easyui-panel ui-search-panel" title="查询条件"
			data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">
			<form id="searchForm" method="post">
				<p class="ui-fields">
					<label class="ui-label">场所：</label> <select name="depSerial"
						id="depSerial" class="easyui-combotree" style='width:200px;'
						data-options="panelHeight:'auto',method:'get',url:'${pageContext.request.contextPath}/regionController/selectAll.do',editable:false"></select>
				</p>
				<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        					<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
			</form>
		</div>

		<form id="listForm" method="post">
			<table id="data-list"></table>
		</form>

		<div id="edit-win" class="easyui-dialog" title="场所管理"
			data-options="closed:true,iconCls:'icon-window',modal:true" style='width:450px;height:200px;'>
			<form id="editForm" class="ui-form" method="post">
				<input class="hidden" type="text" name="depSerial" id="depSerial">
				<div class="ui-edit">
					<div class="fitem">
						<label>场所名称：</label> <input class="easyui-validatebox ui-text"
							type="text" name="depName" id="depName"  style='width:200px;' data-options="required:true">
					</div>
					<div class="fitem">
						<label>上级场所：</label> 
						<input name="depParent" id="depParent" class="easyui-combotree" data-options="url:'${pageContext.request.contextPath }/regionController/selectAll.do',editable:false,panelHeight:'auto',required:true,animate:true,hasDownArrow:false,lines:true" style='width:200px;' />
					</div>
					<div class="fitem">
						<label>场所类型：</label> <input name="moduleId" class="easyui-combobox" data-options="valueField:'id',textField:'text',url:'${pageContext.request.contextPath }/regionController/acdepType.do',editable:false,panelHeight:'auto',required:true" style='width:200px;'/>
					</div>
				</div>
			</form>
		</div>
		
	</div>
  </body>
</html>
