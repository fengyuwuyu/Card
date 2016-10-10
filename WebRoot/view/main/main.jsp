<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>后台管理系统</title>
    <%@include file="../resource.jsp"%>  	
    <link rel="stylesheet" type="text/css" href="${msUrl}css/main.css">
    <script type="text/javascript" src="${msUrl}js/ux/main/main.js"></script>
  </head>
  <body class="easyui-layout">
  	
 	<div class="ui-header" data-options="region:'north',split:false,border:false,height:40" style="overflow: hidden;">
 		<h2>欢迎，${currUser.userLname}</h2>
	 	<div  class="ui-login">
	 		<div class="ui-login-info">
		 		<span class="orange" id="time"></span>&nbsp;&nbsp;&nbsp; 
		 		<a class="logout-btn" href="${msUrl}file/down/main/card_tools.rar">读卡控件</a> |		
		 		<a class="modify-pwd-btn"  href="javascript:void(0);">修改密码</a> |
	 			<%-- <a class="logout-btn" href="${msUrl}">退出</a>	 --%>		 					
	 		</div>
	 	</div>
 	</div>

	<div data-options="region:'west',title:'导航菜单',split:false,border:false,width:200">
		<div id="tree-box" class="easyui-accordion" data-options="fit:true,border:false,animate:true">		 	
			<c:forEach var="item" items="${menuList}">
				<div title="${item.menuName}">
					<c:forEach var="node" items="${item.children}">
						<a class="tree-item" href="${msUrl}${node.url}">${node.menuName}</a>
					</c:forEach>
				</div>
			</c:forEach>			
		</div>
	</div>


	<div data-options="region:'center',split:false,border:true" >
		<div class="easyui-tabs" id="tab-box" data-options="fit:true,border:false">
			<div title="首页" style="padding:20px;overflow:hidden;"> 
							
			</div>
		</div>	
	</div>
	
	
	<div data-options="region:'south',split:false,border:false,height:30" style="overflow:hidden;">	
		<div class="panel-header" style="border: none;text-align: right;" >
			中国节能环保集团公司 copyright @2016&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<a href="#" class="easyui-menubutton" data-options="iconCls:'icon-theme',plain:true,menu:'#menu-theme'">主题</a>
		</div>
	</div>
	
	<div id="menu-theme">
	    <div id="default" class="item-theme">默认</div>
	    <div class="menu-sep"></div>
	    <div id="gray" class="item-theme" iconCls="icon-yes">浅灰</div>
	    <div id="cupertino" class="item-theme">天蓝</div>
	    <div id="pepper" class="item-theme">棕红</div>
	    <div class="menu-sep"></div>
	    <div id="bootstrap" class="item-theme">Bootstrap</div>
	    <div id="metro" class="item-theme">Metro</div>
	    <div id="metro-blue" class="item-theme">Metro（蓝）</div>
	    <div id="metro-gray" class="item-theme">Metro（灰）</div>
	    <div id="metro-green" class="item-theme">Metro（绿）</div>
	    <div id="metro-orange" class="item-theme">Metro（橙）</div>
	    <div id="metro-red" class="item-theme">Metro（红）</div>
	</div>
	
	<div id="modify-pwd-win"  class="easyui-dialog" title="修改密码对话框" data-options="width:350,height:200,closed:true,iconCls:'icon-window',modal:true,buttons:'#editPwdbtn'" >
		<form id="pwdForm" action="modifyPwd.do" class="ui-form" method="post">
     	<div class="ui-edit">
	    	<div class="fitem">  
	        	<label>原密码:</label>  
	        	<input name="oldUserPassword" id="oldUserPassword" type="password" class="easyui-numberbox"  data-options="required:true,validType:'length[6,6]'"/>
	    	</div>
			<div class="fitem">  
		        <label>新密码:</label>  
		        <input name="password" id="userPassword" type="password" class="easyui-numberbox" data-options="required:true,validType:'length[6,6]'" />
			</div> 
			<div class="fitem">  
		        <label>再次输入:</label>  
		        <input name="userPassword1" id="userPassword1" type="password" class="easyui-numberbox" data-options="required:true,validType:'length[6,6]'" />
			</div> 
		</div>
     	</form>
     	<div id="editPwdbtn" class="dialog-button" >  
           	 <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-submit">保存</a>  
             <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-close">关闭</a>  
        </div>
	</div>
	<div><input type="hidden" id="needServerNotify" value="${needServerNotify}"></div>
  </body>
</html>
