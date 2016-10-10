<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>员工列表</title>
 	<script type="text/javascript" src="../../js/ux/medicine/dtUser.js"></script>
  </head>
  <%
		Integer  userSerial=(Integer)request.getAttribute("userSerial");
  %>
  <body>
  <input  type="hidden"  id="userSerial"  value="<%=userSerial%>">
  	<div class="easyui-panel warp" data-options="border:false">
 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">  
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
 	 	    		<label class="ui-label">名称：</label>
 	 	    		<input name="userLname"  id="userLname" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;
        		</p>
        		<a id="search" href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      			</form>  
     		</div> 
   		<form id="listForm" method="post">
   			<table id="dtUser"></table>
   		</form>
  	</div>
  
  </body>
</html>
