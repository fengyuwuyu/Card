<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	    <title>门定义</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/sys/stDoorReal.js"></script>
		<script type="text/javascript" src="../../js/commons/placeholder.js"></script>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">


 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search'" style="width:97%;"> 
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
 	 	    		<label class="ui-label">名称：</label>
 	 	    		<input name="doorName" type="text" class="ui-text" placeholder="请输入门名称、设备名称或场所名称" style="width:200px;hight:15px;">	 	    		
        		</p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false" style="position:relative;top:3px;">查询</a>
        		<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
      			</form>  
     		</div> 


     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>


     	<div id="edit-win" class="easyui-dialog" title="门定义对话框"
			data-options="closed:true,iconCls:'icon-window',modal:true" style='width:450px;height:200px;'>
			<form id="editForm" class="ui-form" method="post">
				<input class="hidden" type="text" name="bh" id="bh">
				<input class="hidden" type="text" name="devSerial" id="devSerial">
				<input class="hidden" type="text" name="devOrder" id="devOrder">
				<div class="ui-edit">
					<div class="fitem">
						<label>门名称：</label> <input class="easyui-validatebox ui-text"
							type="text" name="doorName" id="depName"  style='width:192px;' data-options="required:true">
					</div>
					<div class="fitem">
						<label>所属场所：</label> 
						<input name="depSerial" id="depSerial" class="easyui-combotree" data-options="url:'${pageContext.request.contextPath }/regionController/selectAll.do',editable:false,panelHeight:'auto',required:true,animate:true,hasDownArrow:false,lines:true" style='width:200px;' />
					</div>
					<div class="fitem">
						<label>关联设备：</label> 
						<input name="devName" id="devName" class="easyui-textbox" data-options="required:true,editable:false,missingMessage:'该输入项为必输项'" style='width:200px;'/>
						<a type="button" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" id="selDev" >选择设备</a>
					</div>
				</div>
			</form>
		</div>
  	 	
  	 	<div id="chooseDev-win" class="easyui-dialog" title="选择设备对话框"
			data-options="closed:true,iconCls:'icon-window',modal:true,buttons:'#dlg-buttons2'" style='width:600px;height:460px;'>
			<form id="chooseDevForm" class="ui-form" method="post">
				<input class="hidden" type="text" name="bh" id="bh">
				<div class="ui-edit">
					<div class="ftitle">选择设备</div>
					<table id="data-list2"></table>
				</div>  
				<div class="ui-edit">
					<div class="ftitle">门锁接口</div>
					<input name="devOrder" type="radio" value="1" id="radio1" /><span id="devOrder1">1号门锁接口</span>
					<input name="devOrder" type="radio" value="2" id="radio2" /><span id="devOrder2">2号门锁接口</span>
				</div>
			</form>
		</div>
		
		<div id="dlg-buttons2">
				<a id="btn-save2" class="easyui-linkbutton">确定</a>
				<a id="btn-close2" href="#" class="easyui-linkbutton">返回</a>
			</div>
		</div>
	</body>
</html>
