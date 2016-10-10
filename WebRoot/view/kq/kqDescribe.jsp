<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <title>个人考勤说明单</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ux/kq/kqDescribe.js"></script>
			<style type="text/css">
#kq_query input,select {
	width: 150px;
}

#kq_query .search_label {
	width: 60px;
}

/* #btn-export{
	position : relative;
	top : 4px;
} */
.datagrid-toolbar{
	padding : 0;
}
</style>
	</head>
	<body>
		<div class="easyui-panel warp" data-options="border:false">


 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">  
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
 	 	    		<label class="ui-label">起始日期：</label>
 	 	    		<input name="kssj" id="kssj" type="text" class="easyui-datebox" editable="false" />
            		<label class="ui-label">结束日期：</label>
            		<input type="text" name="jssj" id="jssj" class="easyui-datebox" editable="false" />
            		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" style="width:70px;" menu="#menu-reset" plain="false">查询</a>
            		 <div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
            		 <%-- <a id="btn-export" href="${pageContext.request.contextPath}/kqRecordController/exportExcel.do?type=1&filename=_kq.xls"
								class="easyui-linkbutton" data-options="iconCls:'icon-load'">导出Excel</a> --%>
        		
      			</form>  
     		</div> 


     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>
		</div>
	</body>
</html>
