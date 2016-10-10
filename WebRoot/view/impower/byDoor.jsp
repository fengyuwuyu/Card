<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	    <title>按门授权</title>
	    <%@include file="../resource.jsp"%>  	
		<script type="text/javascript" src="../../js/ux/impower/byDoor.js"></script>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">

 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search'" style="width:97%;"> 
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">	 	    		
 	 	    		<label class="ui-label">名称：</label>
 	 	    		<input name="doorName" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;  	 	    		
	               	<label>场所：</label>  
	               	<select name="depSerial" class="easyui-combotree" data-options="method:'get',url:'${msUrl}impowerController/siteLoad.do',width:120,height:22,panelWidth:300,panelHeight:300,editable:false,animate:true,hasDownArrow:false,lines:true"></select>&nbsp;&nbsp;&nbsp;  
        		</p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        		<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
      			</form>  
      			<form id="searchForm2" method="post">
 	 			<p class="ui-fields">
            		<label class="ui-label">场所名称：</label>
            		<input name="depName" type="text" class="ui-text">&nbsp;&nbsp;&nbsp; 
        		</p>
        		<a id="btn-search2" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset2" plain="false">查询</a>
        		<div id="menu-reset2"><div id="btn-reset2" iconCls="icon-reset">重置</div></div>
      			</form>  
     		</div> 

     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     			<div id="tb">
					<a href="#" class="easyui-menubutton" data-options="iconCls:'icon-select',plain:true,menu:'#menu-select'">选中</a>
					<a href="#" class="easyui-menubutton" data-options="iconCls:'icon-write',plain:true,menu:'#menu-impower'">授权</a>
				</div>	
				<div id="menu-select" >
				    <div class="byDoor" iconCls="icon-door">选门（默认）</div>
				    <div class="menu-sep"></div>
				    <div class="bySite" iconCls="icon-home">选场所</div>
				</div>
				<div id="menu-impower" >
				    <div id="byUser" iconCls="icon-account">选员工</div>
				    <div class="menu-sep"></div>
				    <div id="byDep" iconCls="icon-org">选部门</div>
				</div>
     		</form>
     		
     		<form id="listForm2" method="post">
     			<table id="data-list2"></table>
     			<div id="tb2">
					<a href="#" class="easyui-menubutton" data-options="iconCls:'icon-select',plain:true,menu:'#menu-select2'">选中</a>
					<a href="#" class="easyui-menubutton" data-options="iconCls:'icon-write',plain:true,menu:'#menu-impower2'">授权</a>
				</div>	
				<div id="menu-select2" >
				    <div class="byDoor" iconCls="icon-door">选门（默认）</div>
				    <div class="menu-sep"></div>
				    <div class="bySite" iconCls="icon-home">选场所</div>
				</div>
				<div id="menu-impower2" >
				    <div id="byUser2" iconCls="icon-account">选员工</div>
				    <div class="menu-sep"></div>
				    <div id="byDep2" iconCls="icon-org">选部门</div>
				</div>
     		</form>			
			
     		<div id="edit-win" class="easyui-dialog" title="授权对话框 -- 选员工" data-options="width:800,height:450,closed:true,iconCls:'icon-window',modal:true,buttons:'#dlg-buttons'">       			
     		 	<div class="ui-edit">       		 		
           			<form id="searchForm3" class="ui-form" method="post">
           			<div class="ftitle">员工列表</div>      
           			<table id="data-list3"></table>  
     				<div id="tb3">     					
     					<label class="ui-label">工号：</label>
	 	    			<input name="userNo" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
	 	    			<label class="ui-label">姓名：</label>
	 	    			<input name="userLname" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
            			<label class="ui-label">部门：</label>
           				<select name="userDep" class="easyui-combotree" data-options="method:'get',url:'${msUrl}systemController/dtDepLoad.do',width:120,height:22,panelWidth:300,panelHeight:300,editable:false,animate:true,hasDownArrow:false,lines:true"></select>&nbsp;&nbsp;&nbsp;
           				<a id="btn-search3" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset3" plain="false">查询</a>
	        			<div id="menu-reset3">
					    	<div id="btn-reset3" iconCls="icon-reset">重置</div>
						</div>				
					</div>	
					</form>
					<form id="editForm" class="ui-form" method="post">  
						<input id="userSerials" name="userSerials" type="hidden">
	          	 		<input id="depSerials" name="depSerials" type="hidden">
	          	 		<input id="doorSerials" name="doorSerials" type="hidden">
	          	 		<input id="siteSerials" name="siteSerials" type="hidden">
		           		<div class="ftitle">规则信息</div>                
		          	 	<div class="fitem">  
		               		<label>进门规则：</label>  
		               		<select name="ruleNo" class="easyui-combobox" data-options="method:'get',url:'${msUrl}impowerController/mjRuleLoad.do',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false,hasDownArrow:false,required:true"></select>
		               		<label>出门规则：</label>  
		               		<select name="ruleNo2" class="easyui-combobox" data-options="method:'get',url:'${msUrl}impowerController/mjRuleLoad.do',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false,hasDownArrow:false,required:true"></select>
		               		<span>此设置适用于可双向控制的门 !</span>	               		
		          	 	</div> 	 		          	
	          	 	</form>	          	 	      	 	
	         	</div>
  	 		</div> 
  	 		
  	 		<div id="dlg-buttons">
				<a id="btn-save" href="#" class="easyui-linkbutton">保存</a>
				<a id="btn-close" href="#" class="easyui-linkbutton">关闭</a>
			</div>
  	 		
  	 		<div id="edit-win2" class="easyui-dialog" title="授权对话框 -- 选部门" data-options="width:800,height:450,closed:true,iconCls:'icon-window',modal:true,buttons:'#dlg-buttons2'">  
     		 	<div class="ui-edit">  
     		 		<form id="searchForm4" class="ui-form" method="post">
           			<div class="ftitle">部门列表</div>      
           			<table id="data-list4"></table>  
     				<div id="tb4">     					
     					<label class="ui-label">部门名称：</label>
	 	    			<input name="depName" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;	 	    
           				<a id="btn-search4" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset4" plain="false">查询</a>
	        			<div id="menu-reset4">
					    	<div id="btn-reset4" iconCls="icon-reset">重置</div>
						</div>				
					</div>	
					</form>
	           		<form id="editForm2" class="ui-form" method="post">  
	           			<input id="userSerials2" name="userSerials" type="hidden">
	          	 		<input id="depSerials2" name="depSerials" type="hidden">
	          	 		<input id="doorSerials2" name="doorSerials" type="hidden">
	          	 		<input id="siteSerials2" name="siteSerials" type="hidden">
		           		<div class="ftitle">规则信息</div>                
		          	 	<div class="fitem">  
		               		<label>进门规则：</label>  
		               		<select name="ruleNo" class="easyui-combobox" data-options="method:'get',url:'${msUrl}impowerController/mjRuleLoad.do',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false,hasDownArrow:false,required:true"></select>
		               		<label>出门规则：</label>  
		               		<select name="ruleNo2" class="easyui-combobox" data-options="method:'get',url:'${msUrl}impowerController/mjRuleLoad.do',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false,hasDownArrow:false,required:true"></select>
		               		<span>此设置适用于可双向控制的门 !</span>	               		
		          	 	</div> 	 		          	
	          	 	</form>	        	 	
	         	</div>
  	 		</div> 
  	 		
  	 		<div id="dlg-buttons2">
				<a id="btn-save2" href="#" class="easyui-linkbutton">保存</a>
				<a id="btn-close2" href="#" class="easyui-linkbutton">关闭</a>
			</div>
  	
		</div>
	</body>
</html>
