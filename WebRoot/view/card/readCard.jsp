<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	    <title>开卡管理</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/card/readCard.js"></script>
	</head>
	<body>
		<object id="object" classid="clsid:DE96678E-5929-4FC1-9640-D7FB380E4F93" class="hidden" ></object>
	
		<div class="easyui-panel warp" data-options="border:false">


 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search'" style="width:97%;">  
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">	 	    		
 	 	    		<label class="ui-label">工号/姓名：</label>
 	 	    		<input name="userNo" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
 	 	    		<label class="ui-label">电话：</label>
 	 	    		<input name="userTelephone" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;	 	    		
 	 	    		<label class="ui-label">部门：</label>
            		<select name="userDep" class="easyui-combotree" data-options="method:'get',url:'${msUrl}systemController/dtDepLoad.do',width:120,panelWidth:300,height:22,panelHeight:300,editable:false,animate:true,hasDownArrow:false,lines:true"></select>&nbsp;&nbsp;&nbsp;
            		<label>账户类型：</label>  
	               	<select name="acBh" class="easyui-combobox" data-options="method:'get',url:'${msUrl}parameterController/accountLoad.do',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false,hasDownArrow:false"></select>&nbsp;&nbsp;&nbsp;
            		<label>状态：</label>  
	               	<select name="userType" class="easyui-combobox" data-options="method:'get',url:'${msUrl}systemController/ttLizhiLoad.do',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false,hasDownArrow:false"></select>&nbsp;&nbsp;&nbsp;
        		</p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        		<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
      			</form>  
     		</div> 


     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>


     		<div id="edit-win" class="easyui-dialog" title="开卡对话框" data-options="width:550,height:470,closed:true,iconCls:'icon-window',modal:true" buttons='#dlg-buttons'>  
     			<form id="editForm" class="ui-form" method="post">  
     		 	<input id="userSerial" class="hidden" type="text" name="userSerial">
     		 	<div class="ui-edit">
	     	  		<div class="ftitle">人员信息</div>    
	           		<div class="fitem">  
	               		<label>工号：</label>  
	               		<input name="userNo" class="easyui-validatebox ui-text" type="text" readonly >
	               		<label>姓名 ：</label>  
	               		<input name="userLname" class="easyui-validatebox ui-text" type="text" readonly >
	           		</div> 
	           		<div class="fitem">  
	           			<label>职务：</label>  
	               		<input name="userDuty" class="easyui-validatebox ui-text" type="text" readonly >
	               		<label>部门：</label>  
	               		<input name="userDepname" class="easyui-validatebox ui-text" type="text" readonly >
	           		</div>  	  
	           		<div class="ftitle">账户信息</div>    
	           		<div class="fitem">  
	               		<label>类型名称：</label>  
	               		<input name="acName" class="easyui-validatebox ui-text" type="text" readonly >
	               		<label>启用日期：</label>  
	               		<input name="acBegin" class="easyui-validatebox ui-text" type="text" readonly >
	           		</div> 
	           		<div class="fitem">  
	               		<label>结束日期：</label>  
	               		<input name="acEnd" class="easyui-validatebox ui-text" type="text" readonly >
	           		</div> 	        	               
	           		<div class="ftitle">卡片操作信息</div>    
	           		<div class="fitem hidden">  
	               		<label>串口：</label>  
	               		<select id="port" class="easyui-combobox" data-options="method:'get',url:'port.json',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false">
	               			<option value="3" selected="selected">3</option>
	               		</select>
	               		<label>发卡器类型：</label>  
	               		<select class="easyui-combobox" data-options="width:120,height:22,disabled:true">
	               			<option value="2000" selected="selected">IC卡(CS-6C)</option>
	               		</select>
	           		</div> 	  	 	               
	          	 	<div class="fitem">  
	               		<label>操作提示：</label>  
	               		<div class="readCardMessage"></div>
	           		</div> 
	           		<div class="fitem">  
	               		<label></label>  
	               		<input id="isContinue" type="checkbox" >连续发卡
	           		</div> 
	         	</div>
     			</form>
  	 		</div> 
  	 		
  	 		<div id="dlg-buttons">
				<a id="btn-openCard" href="#" class="easyui-linkbutton">开卡</a>
				<a id="btn-close" href="#" class="easyui-linkbutton">关闭</a>
			</div>

  	
		</div>
	</body>
</html>
