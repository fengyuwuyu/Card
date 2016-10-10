<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	    <title>机构管理</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YTreeGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/sys/dtDep.js"></script>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">


 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search'" style="width:97%;"> 
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
            		<label class="ui-label">部门名称：</label>
            		<input name="depName" type="text" class="ui-text">&nbsp;&nbsp;&nbsp; 
        		</p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        		<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
      			</form>  
     		</div> 


     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>


     		<div id="edit-win" class="easyui-dialog" title="部门对话框" data-options="width:500,height:450,closed:true,iconCls:'icon-window',modal:true">  
     			<form id="editForm" class="ui-form" method="post">
					<input class="hidden" type="text" name="depSerial" id="depSerial">
					<div class="ui-edit">
						<div class="fitem">
							<label>部门名称：</label> <input class="easyui-validatebox ui-text"
								type="text" name="depName" id="depName"  style='width:200px;' data-options="required:true">
						</div>
						<div class="fitem">
							<label>上级部门：</label> 
							<input name="depParent" id="depParent" class="easyui-combotree" data-options="url:'${pageContext.request.contextPath }/systemController/dtDepGetAll.do',editable:false,panelHeight:'auto',required:true,animate:true,hasDownArrow:false,lines:true" style='width:200px;' />
						</div>
						<div class="fitem">
							<label>部门编号：</label> <input name="depNo" class="easyui-textbox" data-options="required:true,editable:false" value="99999999" style='width:200px;'/>
						</div>
					</div>
				</form>
  	 		</div> 
  	 		
  	 		<%-- <div id="edit-win2" class="easyui-dialog" title="接收对话框" data-options="width:500,height:'auto',closed:true,iconCls:'icon-window',modal:true,buttons:'#dlg-buttons'" >  
     			<form id="editForm2" class="ui-form" method="post">     		 	     		 		 
	           	<div class="ui-edit">
	           		<div class="fitem">  
	               		<label></label> 
	               		<input class="settings" type="radio" name="rad" value="0" checked /> 自动选择（默认全部）
	               		<input class="settings" type="radio" name="rad" value="1"/> 手动选择
	           		</div> 
     		 		<div class="fitem settingOption">  
     		 			<label>部门：</label>  
	               		<input name="depNos" class="easyui-combobox option" data-options="method:'get',url:'${msUrl}systemController/midDepLoad.do',valueField:'value',textField:'text',width:300,height:25,panelHeight:200,editable:false,hasDownArrow:false,multiple:true,separator:',',required:true" />
	               	</div>
	           	</div>
     			</form>
  	 		</div>  --%>
  	 		
  	 		<div id="dlg-buttons">
				<a id="btn-save2" href="#" class="easyui-linkbutton">保存</a>
				<a id="btn-close2" href="#" class="easyui-linkbutton">关闭</a>
			</div>

	  		<div id="edit-win3" class="easyui-dialog" title="绑定场所对话框" data-options="width:500,height:'auto',closed:true,iconCls:'icon-window',modal:true,buttons:'#dlg-buttons1'" >  
	     			<form id="editForm3" class="ui-form" method="post">    
	     			<input name="depSerial" id="depSerial" type="hidden"> 
	     			<input name="type" id="type" type="hidden">
	     			<div class="ui-edit">
		           		<label>已绑定的场所：</label> 
		           		<input id="hasBinded" type="text" readonly="readonly">
		           	</div>		 	     		 		 
		           	<div class="ui-edit">
		           		<label>请选择场所：&nbsp;&nbsp;&nbsp;&nbsp;</label> 
		           		<select class="easyui-combobox" name="ids" id="ids"  
   							data-options="valueField:'id',textField:'text',url:'${pageContext.request.contextPath }/systemController/acDepLoad.do',multiple:true,panelHeight:'auto',width:140,editable:false,separator:','" ></select>
		           	</div>
	     			</form>
	  	 		</div> 
			</div>
			<div id="dlg-buttons1">
				<a id="btn-save3" href="#" class="easyui-linkbutton">保存</a>
				<a id="btn-close3" href="#" class="easyui-linkbutton">关闭</a>
			</div>
			
			<div id="edit-win4" class="easyui-dialog" title="同步HR部门对话框" data-options="width:400,height:'auto',closed:true,iconCls:'icon-window',modal:true,buttons:'#dlg-buttons4'" >  
	     			<form id="editForm4" class="ui-form" method="post">    
	     			<input name="depSerial" id="depSerial4" type="hidden"> 
		           	<div class="ui-edit">
		           		<label>请选HR部门：&nbsp;&nbsp;&nbsp;&nbsp;</label> 
		           		<select name="iuCode" class="easyui-combotree" data-options="method:'get',url:'${msUrl}systemController/midDepLoad.do',width:120,height:22,panelWidth:300,panelHeight:300,editable:false,animate:true,hasDownArrow:false,lines:true"></select>&nbsp;&nbsp;&nbsp;            		    
		           		<label>级联：<input name="all" id="cascade" type="checkbox" style="width:25px;position:relative;top:3px"></label>
            		         	</div>
		           	
	     			</form>
	  	 		</div> 
			</div>
			<div id="dlg-buttons4">
				<a id="btn-save4" href="#" class="easyui-linkbutton">保存</a>
				<a id="btn-close4" href="#" class="easyui-linkbutton">关闭</a>
			</div>
	</body>
</html>
