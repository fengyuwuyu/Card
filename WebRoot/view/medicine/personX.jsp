<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>个人消费信息查询页面</title>
     <%@include file="../resource.jsp"%> 
    <script type="text/javascript" src="../../js/ux/medicine/personMessage.js"></script>
     <script type="text/javascript" src="../../js/ux/medicine/personX.js"></script>
  </head>
  <body>
    <div class="easyui-panel warp" data-options="border:false">
 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">  
 	 			<form id="searchForm" method="post">
        		<p class="ui-fields">
        		<label class="ui-label">开始时间：</label>
	 	 	    	<input name="beginDate"  id="beginDate" type="text" class="easyui-datebox" validType="validaDate['#endDate']">&nbsp;&nbsp;&nbsp;	
 	 	    		<label class="ui-label">结束时间：</label>
	 	 	    	<input name="endDate"  id="endDate" type="text" class="easyui-datebox"     validType="validaDate['#beginDate']" >&nbsp;&nbsp;&nbsp;	
        		
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
       		    <div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
        		</p>
      			</form>  
     		</div> 
     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>
   </div>
  </body>
</html>
