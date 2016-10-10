<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>考勤查询</title>

<%@include file="../resource.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ux/kq/kqQuery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ux/mess/mess.js"></script>
<style type="text/css">
#kq_query input,select {
	width: 150px;
}

#kq_query .search_label {
	width: 60px;
}

/* #btn-search {
	margin-left: 20px;
} */
#data-statistics{
  margin: 0;
  padding: 0;
}

#data-statistics td{
  border-width: 0 1px 1px 1px;
  border-style: dotted;
  margin: 0;
  padding: 0;
}

</style>

</head>
<body>
	<div class="easyui-panel warp" data-options="border:false">
		<div class="easyui-panel ui-search-panel" title="查询条件"
			data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">
			<form id="searchForm" method="post">
				<p class="ui-fields">
					<input type="hidden" id="personal" name="personal" value="${personal }" /> 
				<table id="kq_query">
						<% 
							Integer personal = (Integer)request.getAttribute("personal");
							if(personal!=1){
						%>
						<tr>
							<td class="search_label">部门：</td>
							<td><select name="userDep" id="depSerial" class="easyui-combotree" data-options="method:'get',url:'${pageContext.request.contextPath}/messConsumeController/loadDep.do?personal=0',panelWidth:270,panelHeight:220,editable:false,animate:true,hasDownArrow:false,lines:true"></select>&nbsp;&nbsp;&nbsp;
							</td>
							<td class="search_label">员工姓名：</td>
							<td><input id="username" name="username" type="text" class="ui-text">
							</td>	
							<td class="search_label">起始日期：</td>
							<td><input name="kssj" id="kssj" type="text"
								class="easyui-datebox" editable="false" /></td>
							<td class="search_label">结束日期：</td>
							<td><input type="text" name="jssj" id="jssj"
								class="easyui-datebox" editable="false" /></td>
						</tr>
						<tr>
							<td class="search_label">开始时间：</td>
							<td><input class='easyui-timespinner' name="sbsj" id="sbsj" data-options="value:'22:00:00',showSeconds: true" /></td>
							<td class="search_label">结束时间：</td>
							<td><input class='easyui-timespinner'  name="xbsj" id="xbsj"  data-options="value:'23:59:59',showSeconds: true " /></td>
							<td ><a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" style="width:70px;" menu="#menu-reset" plain="false">查询</a>
				        		 <div id="menu-reset">
								    <div id="btn-reset" iconCls="icon-reset">重置</div>
								 </div></td>
							<%-- <td ><a id="btn-export" href="${pageContext.request.contextPath}/kqRecordController/exportExcel.do?type=1&filename=_kq.xls"
								class="easyui-linkbutton" >导出Excel</a></td> --%>
						</tr>	
						<%	}
							if(personal==1){%>
							<tr>
							<td class="search_label">起始日期：</td>
							<td><input name="kssj" id="kssj" type="text"
								class="easyui-datebox" editable="false" /></td>
							<td class="search_label">结束日期：</td>
							<td><input type="text" name="jssj" id="jssj"
								class="easyui-datebox" editable="false" /></td>
							<td class="search_label">开始时间：</td>
							<td><input class='easyui-timespinner' name="sbsj" id="sbsj" data-options="value:'22:00:00',showSeconds: true" /></td>
							<td class="search_label">结束时间：</td>
							<td><input class='easyui-timespinner'  name="xbsj" id="xbsj"  data-options="value:'23:59:59',showSeconds: true " /></td>
							<td ><a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" style="width:70px;" menu="#menu-reset" plain="false">查询</a>
				        		 <div id="menu-reset">
								    <div id="btn-reset" iconCls="icon-reset">重置</div>
								 </div></td>
							<%-- <td ><a id="btn-export" href="${pageContext.request.contextPath}/kqRecordController/exportExcel.do?type=1&filename=_kq.xls"
								class="easyui-linkbutton" >导出Excel</a></td> --%>
						</tr>	
						<%}%>
						
					
				</table>
				</p>

			</form>
		</div>
		<form id="listForm" method="post">
			<table id="data-list"></table>
		</form>
	</div>
</body>
</html>
