<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	    <title>退卡管理</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/card/returnCard.js"></script>
	</head>
	<body>
	
		<object id="object" classid="clsid:DE96678E-5929-4FC1-9640-D7FB380E4F93" class="hidden" ></object>
	
		<div class="easyui-panel warp" data-options="border:false">


 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search'" style="width:97%;"> 
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">	 	    		
 	 	    		<label class="ui-label">工号：</label>
 	 	    		<input name="userNo" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
 	 	    		<label class="ui-label">姓名：</label>
 	 	    		<input name="userLname" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
 	 	    		<label class="ui-label">部门：</label>
            		<select name="userDep" class="easyui-combotree" data-options="method:'get',url:'${msUrl}systemController/dtDepLoad.do',width:120,height:22,panelWidth:300,panelHeight:300,editable:false,animate:true,hasDownArrow:false,lines:true"></select>&nbsp;&nbsp;&nbsp;
            		<label class="ui-label">物理/逻辑卡号：</label>
 	 	    		<input name="cardHao" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
 	 	    		<label class="ui-label">卡片状态：</label>
 	 	    		<select class="easyui-combobox" name="cardType" data-options="width:100,height:23,panelHeight:72,editable:false">
                   		<option value="" selected="selected">-- 请选择 --</option>
                   		<option value="0">正常</option>
                   		<option value="1">挂失</option>
                  	</select>&nbsp;&nbsp;&nbsp;
	               	<label>级联：<input name="all" type="checkbox" style="width:25px;position:relative;top:3px"></label>
        		</p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        		<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
      			</form>  
     		</div> 


     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>


     		<div id="edit-win" class="easyui-dialog" title="退卡对话框" data-options="width:550,height:470,closed:true,iconCls:'icon-window',modal:true" buttons='#dlg-buttons'>  
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
	           		<div class="fitem">  
	               		<label>卡片类型：</label>  
	               		<input name="ttName" class="easyui-validatebox ui-text" type="text" readonly >
	               		<input id="cardLx" name="cardLx" class="hidden" type="text">
	               		<label>物理卡号 ：</label>  
	               		<input id="cardHao" name="cardHao" class="easyui-validatebox ui-text" type="text" readonly >
	           		</div> 
	           		<div class="fitem">  
	               		<label>逻辑卡号：</label>  
	               		<input id="cardSerial" name="cardSerial" class="easyui-validatebox ui-text" type="text" readonly >
	               		<label>发卡日期：</label>  
	               		<input name="acSj" class="easyui-validatebox ui-text" type="text" readonly >
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
	               		<label>食堂剩余金额：</label>  
	               		<input id="acMoney" name="acMoney" class="easyui-validatebox ui-text" type="text" readonly >
	           		</div> 
	           		<div class="fitem">	               		
	               		<label>医药剩余金额：</label>  
	               		<input id="medMoney" name="medMoney" class="easyui-validatebox ui-text" type="text" readonly >
	           		</div>  	  	                      
	           		<div class="ftitle">卡片操作信息</div>    
	           		<div class="fitem hidden">  
	               		<label>串口：</label>  
	               		<select id="port" class="easyui-combobox" data-options="method:'get',url:'port.json',valueField:'value',textField:'text',width:120,height:22,panelHeight:72,editable:false">
	               			<option value="3" selected="selected">3</option>
	               		</select>
	               		<label>发卡器类型：</label>  
	               		<select class="easyui-combobox" data-options="width:120,height:22,disabled:true">
	               			<option value="20000" selected="selected">IC卡(CS-6C)</option>
	               		</select>
	           		</div>  	  	               
	          	 	<div class="fitem">  
	               		<label>提示信息：</label>  
	               		<div class="readCardMessage"></div>
	           		</div> 
	         	</div>
     			</form>
  	 		</div> 
  	 		
  	 		<div id="dlg-buttons">
				<a id="btn-readCard" href="#" class="easyui-linkbutton">读卡</a>
				<a id="btn-returnCard" href="#" class="easyui-linkbutton">退卡</a>
				<a id="btn-returnCard2" href="#" class="easyui-linkbutton">补卡</a>
				<a id="btn-close" href="#" class="easyui-linkbutton">关闭</a>
			</div>

  	
		</div>
	</body>
</html>
