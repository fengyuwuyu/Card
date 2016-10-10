<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>消费记录页面</title>
   <%@include file="../resource.jsp"%>  		
	<script type="text/javascript" src="../../js/ux/medicine/purchaseGrid.js"></script>
	<script type="text/javascript" src="../../js/ux/medicine/purchaseRecord.js"></script>
  </head>
  
  <body>
   <div class="easyui-panel warp" data-options="border:false">
 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">  
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
 	 				<input  type="hidden"  id="userSerial"  name="userSerial">
 	 				<input  type="hidden"  id="depSerialAccount"  name="depSerialAccount">
 	 				<input  type="hidden"  id="price"  name="price"> 
 	 				<label class="ui-label">员工卡号：</label>
			   		<input  id="cardHao" name="cardHao" type="text" class="ui-text" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	 	    		<label class="ui-label" style="margin-left: 45px;">名称：</label>
 	 	    		<input name="userLname" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		&nbsp;&nbsp;&nbsp;
 	 	    		<label class="ui-label">部门：</label>
            		<select name="depSerial"  id="depSerial" class="easyui-combotree" data-options="method:'get',url:'${msUrl}systemController/dtDepLoad.do',width:120,panelWidth:300,panelHeight:300,editable:false,animate:true,hasDownArrow:false,lines:true"></select>&nbsp;&nbsp;&nbsp;
        		</p>
        		<p class="ui-fields">
        		<label class="ui-label">开始时间：</label>
	 	 	    	<input name="beginDate"  id="beginDate" type="text" class="easyui-datebox" validType="validaDate['#endDate']">&nbsp;&nbsp;&nbsp;	
 	 	    		<label class="ui-label">结束时间：</label>
	 	 	    	<input name="endDate"  id="endDate" type="text" class="easyui-datebox"     validType="validaDate['#beginDate']" >&nbsp;&nbsp;&nbsp;	
        		
        		<input  id="selectType"  name="selectType" value="0" type="hidden">
        		
        		
        	<!-- 	<label class="ui-label">分类：</label><select  id="selectType"  name="selectType">
        				<option  value="-1">请选择</option>
        				<option  value="0">个人</option> 
        				<option value="1">单位</option> 
        		</select> -->
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
       		    <div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
        		</p>
      			</form>  
     		</div> 

     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>
  	 		<div  id="userMessage" class="easyui-dialog" style="width:820px;height:450px" data-options="title:'购买信息',modal:true,closed:true,iconCls:'icon-window',buttons: [ {text: '关闭',   handler: function () { $('#userMessage').dialog('close'); }  }]">
			</div>
   </div>
  </body>
</html>
