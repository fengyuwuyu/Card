<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	    <title>员工管理</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/sys/dtUser.js"></script>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">


 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search'" style="width:97%;"> 
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
 	 				<input type="hidden" id="goSync" value="${requestScope.goSync }">
 	 	    		<label class="ui-label">工号/姓名：</label>
 	 	    		<input name="userNo" type="text" class="ui-text" style="width:80px">&nbsp;&nbsp;&nbsp;  	 	    		
            		<label class="ui-label">部门：</label>
            		<select name="userDep" class="easyui-combotree" data-options="method:'get',url:'${msUrl}systemController/dtDepLoad.do',width:120,height:22,panelWidth:251,panelHeight:300,editable:false,animate:true,hasDownArrow:false,lines:true"></select>&nbsp;&nbsp;&nbsp;            		    
            		<label>账户类型：</label>  
	               	<select name="acBh" class="easyui-combobox" data-options="method:'get',url:'${msUrl}parameterController/accountLoad.do',valueField:'value',textField:'text',width:100,height:22,panelHeight:'auto',editable:false,hasDownArrow:false"></select>&nbsp;&nbsp;&nbsp;
	               	<label>状态：</label>  
	               	<select name="userType" class="easyui-combobox" data-options="method:'get',url:'${msUrl}systemController/ttLizhiLoad.do',valueField:'value',textField:'text',width:100,height:22,panelHeight:100,editable:false,hasDownArrow:false"></select>&nbsp;&nbsp;&nbsp;
	               	<label class="ui-label">卡片相关：</label>
            		<select class="easyui-combobox" name="cardXh" data-options="width:100,height:23,panelHeight:'auto',editable:false">
                   		<option value="" selected="selected">未开卡</option>
                   		<option value="1">已开卡</option>                   		
                  	</select>&nbsp;&nbsp;&nbsp; 
                  	<!-- <label class="ui-label">同步：</label>
	               	<select class="easyui-combobox" name="isSynchronized" data-options="width:80,height:23,panelHeight:'auto',editable:false">
                   		<option value="0" selected="selected">全部</option>
                   		<option value="1" >已同步</option>
                   		<option value="2">未同步</option> 
                   		<option value="3">可同步</option>                   		
                  	</select>&nbsp;&nbsp;&nbsp; -->
	               	<label>级联：<input name="all" type="checkbox" style="width:25px;position:relative;top:3px"></label> 
        		</p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        		<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
      			</form>  
     		</div> 


     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>


     		<div id="edit-win" class="easyui-dialog" title="员工对话框" data-options="width:560,height:500,closed:true,iconCls:'icon-window',modal:true" >
     			<form id="editForm" class="ui-form" method="post">      		 
     			<input id="userSerial" class="hidden" type="text" name="userSerial">  	
     		 	<div id="tabs" class="easyui-tabs" data-options="width:520,plain:true,border:false">
				    <div data-options="id:'tab',title:'员工信息',selected:true"> 				    	 
				        <div class="ftitle">基本信息</div>    
			           	<div class="ui-edit">
		     		 		<div class="fitem">  
		     		 			<label>工号：</label>  
			               		<input name="userNo" value="00000000"  class="easyui-validatebox ui-text" type="text" disabled>
			               		<label>姓名：</label>  
			               		<input name="userLname" class="easyui-validatebox ui-text" type="text" data-options="required:true,validType:'length[0,5]'" >
			               	</div>
			               	<div class="fitem">  
		     		 			<label>性别：</label>  
			               		<select name="userSex" class="easyui-combobox" data-options="width:120,height:23,panelHeight:48,editable:false">
			                   		<option value="男" selected="selected">男</option>
			                   		<option value="女">女</option>                   		
			                  	</select>
			               		<label>身份证号：</label>  
			               		<input name="userId" class="easyui-validatebox ui-text" type="text" data-options="validType:'length[0,18]'" >
			               	</div>
			               	<div class="fitem">      		 			
			               		<label>职位：</label>  
			               		<input name="userDuty" class="easyui-validatebox ui-text" type="text" data-options="validType:'length[0,20]'" >
			               		<label>部门：</label>  
			               		<select name="userDep" class="easyui-combotree" data-options="method:'get',url:'${msUrl}systemController/dtDepGetAll.do',width:120,height:22,panelWidth:300,panelHeight:300,editable:false,animate:true,hasDownArrow:false,lines:true,required:true"></select>
			               	</div> 
			          	 	<div class="fitem">  	
			          	 		<label>状态：</label>  
			               		<select name="userType" class="easyui-combobox" data-options="method:'get',url:'${msUrl}systemController/ttLizhiLoad.do',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false,hasDownArrow:false,required:true"></select>             
			               		<label>角色类型：</label>  
			               		<select name="roleId" class="easyui-combobox" data-options="method:'get',url:'${msUrl}systemController/sysRoleLoad.do',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false,hasDownArrow:false,required:true"></select>			               		
			          	 	</div> 	 
			          	 	<div class="fitem">  
			          	 		<label>楼层门禁：</label>  
			               		<select name="mj" id="mj" class="easyui-combobox" data-options="data:[{value:'1',text:'是'},{value:'0',text:'否'}],valueField:'value',textField:'text',width:120,height:22,panelHeight:'auto',editable:false,hasDownArrow:false,required:true" ></select>             
			          	 	</div> 	  	     	  		
			         	</div>
			         	<div class="ftitle">详细信息</div>    
			           	<div class="ui-edit">
			           		<div class="fitem">  
		     		 			<label>生日：</label> 
		     		 			<input name="userBirthday" class="easyui-datebox" data-options="width:120,height:22,editable:false"></input>
			               		<label>学历：</label>  
			               		<select name="userXueli" class="easyui-combobox" data-options="method:'get',url:'${msUrl}systemController/ttXueliLoad.do',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false,hasDownArrow:false"></select>
			               	</div>	               	
			               	<div class="fitem">      		 			
			               		<label>电话：</label>  
			               		<input name="userTelephone" class="easyui-validatebox ui-text" type="text" data-options="validType:'length[0,30]'">
			               		<label>邮箱：</label>  
			               		<input name="userEmail" class="easyui-validatebox ui-text" type="text" data-options="validType:'length[0,50]'">
			               	</div> 
			               	<div class="fitem">      		 			
			               		<label>籍贯：</label>  
			               		<input name="userNative" class="easyui-validatebox ui-text" type="text" data-options="validType:'length[0,10]'" >
			               		<label>民族：</label>  
			               		<select name="userNation" class="easyui-combobox" data-options="method:'get',url:'${msUrl}systemController/ttNationLoad.do',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false,hasDownArrow:false"></select>
			               	</div>  
			               	<div class="fitem">      		 			
			               		<label>邮编：</label>  
			               		<input name="userPost" class="easyui-validatebox ui-text" type="text" data-options="validType:'length[0,10]'">
			               		<label>住址：</label>  
			               		<input name="userAddress" class="easyui-validatebox ui-text" type="text" data-options="validType:'length[0,50]'">
			               	</div>  
			               	<div class="fitem">  
				               <label>备注：</label>  
				               <textarea name="userBz" class="easyui-validatebox" name="roleDes" data-options="validType:'length[0,50]'"></textarea>
				               <span>不超过50字</span>
				           </div>
			           	</div>
				    </div>
				    <div data-options="id:'tab2',title:'消费权限',selected:false">				    	
				    	<div class="ftitle">账户类型信息</div>    
			           	<div class="ui-edit">
					    	<div class="fitem">  
			               		<label>账户类型：</label>  
			               		<select id="acBh" name="acBh" class="easyui-combobox" data-options="method:'get',url:'${msUrl}parameterController/accountLoad.do',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false,hasDownArrow:false,required:true,onSelect:function(r){var option = {};option['acBh'] = r['value'];$('#data-list2').datagrid('reload',option);}"></select>			               		
			          	 	</div> 
		          	 	</div>
		          	 	<div class="ftitle">账户时段信息</div>  
		          	 	<table id="data-list2"></table>  
				    </div>
				    <div data-options="id:'tab3',title:'门禁权限',selected:false">
				    	<div class="ftitle">门禁信息</div>    
			           	<div class="ui-edit">
					    	<div class="fitem">  
			               		<label></label>  
								<div class="door-tree">  
		               				<ul id="door-tree"></ul>
		               			</div>			          	 	
		               		</div> 
		          	 	</div>
				    </div>
				</div>  
				</form>    			
  	 		</div> 
  	 		
  	 		<div id="check-window" class="easyui-dialog" title="请选择需要同步的数据" data-options="width:860,height:450,closed:true,iconCls:'icon-window',modal:true,buttons:'#dlg-buttons'" >
  	 			<div class="easyui-layout" data-options="fit:true">   
			        <div data-options="region:'center'">
			        	<!-- <form id="editForm2" method="post">    -->
			                <table id="checkRecord" class="easyui-datagrid" ></table>  
			            <!-- </form> -->
			        </div>   
   				</div>
  	 		</div>
  	 		
  	 		<%-- <div id="edit-win2" class="easyui-dialog" title="接收对话框" data-options="width:550,height:180,closed:true,iconCls:'icon-window',modal:true,buttons:'#dlg-buttons'" >  
     			<form id="editForm2" class="ui-form" method="post">    		 	     		 		 
	           	<div class="ui-edit">
	           		<div class="fitem">  
	               		<label></label> 
	               		<input class="settings" type="radio" name="rad" value="0" checked /> 自动选择（部门默认本地，状态默认全部）
	               		<input class="settings" type="radio" name="rad" value="1"/> 手动选择
	           		</div> 
     		 		<div class="fitem settingOption">  
     		 			<label>部门：</label>  
	               		<select name="depNos" class="easyui-combobox option" data-options="method:'get',url:'${msUrl}systemController/dtDepLoad2.do',valueField:'value',textField:'text',width:350,height:25,panelHeight:200,editable:false,hasDownArrow:false,multiple:true,required:true"></select>
	               	</div>
	               	<div class="fitem settingOption">  
     		 			<label>状态：</label>  
	               		<select name="userTypes" class="easyui-combobox option" data-options="method:'get',url:'${msUrl}systemController/ttLizhiLoad.do',valueField:'value',textField:'text',width:350,height:25,panelHeight:200,editable:false,hasDownArrow:false,multiple:true,required:true"></select>
	               	</div>
	           	</div>
     			</form>
  	 		</div> 
  	 		
  	 		 --%>
  	 		<div id="dlg-buttons">
				<a id="btn-save2" class="easyui-linkbutton">提交</a>
				<a id="btn-close2" href="#" class="easyui-linkbutton">关闭</a>
			</div>
  	 		
		</div>
	</body>
</html>
