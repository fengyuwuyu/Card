<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>考勤统计分析</title>

<%@include file="../resource.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.0/extension/datagrid-scrollview.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ux/kq/statisticsAnalyse.js"></script>
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
							<td><select name="depSerial" id="depSerial" class="easyui-combotree" data-options="multiple:true,method:'get',url:'${pageContext.request.contextPath}/messConsumeController/loadDep.do?personal=0',panelWidth:220,panelHeight:220,editable:false,animate:true,hasDownArrow:false,lines:true"></select>&nbsp;&nbsp;&nbsp;
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
							<td class="search_label">上班时间：</td>
							<td><input name="sbsj" id="sbsj" /></td>
							<td class="search_label">下班时间：</td>
							<td><input name="xbsj" id="xbsj" /></td>
							<td class="search_label">统计类型：</td>
							<td><input name="type" id="type" type="text"
								class="easyui-combobox"
								data-options="valueField:'key',textField:'value',panelHeight:'auto',data:[{'key':1,'value':'迟到早退'},{'key':2,'value':'加班'}]"
								editable="false" /></td>
							<td ><a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" style="width:70px;" menu="#menu-reset" plain="false">查询</a>
				        		 <div id="menu-reset">
								    <div id="btn-reset" iconCls="icon-reset">重置</div>
								 </div></td>
							<td ><a id="btn-export" href="${pageContext.request.contextPath}/kqRecordController/exportExcel.do?type=1&filename=_kq.xls"
								class="easyui-linkbutton" data-options="iconCls:'icon-load'" >导出Excel</a></td>
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
							<td class="search_label">统计类型：</td>
							<td><input name="type" id="type" type="text"
								class="easyui-combobox"
								data-options="valueField:'key',textField:'value',panelHeight:'auto',data:[{'key':1,'value':'迟到早退'},{'key':2,'value':'加班'}]"
								editable="false" /></td>
						</tr>
						<tr>
							<td class="search_label">上班时间：</td>
							<td><input name="sbsj" id="sbsj" /></td>
							<td class="search_label">下班时间：</td>
							<td><input name="xbsj" id="xbsj" /></td>
							<td ><a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" style="width:70px;" menu="#menu-reset" plain="false">查询</a>
				        		 <div id="menu-reset">
								    <div id="btn-reset" iconCls="icon-reset">重置</div>
								 </div></td>
							<td ><a id="btn-export" href="${pageContext.request.contextPath}/kqRecordController/exportExcel.do?type=1&filename=_kq.xls"
								class="easyui-linkbutton" data-options="iconCls:'icon-load'" >导出Excel</a></td>
						</tr>	
						<%}%>
						
					
				</table>
				</p>

			</form>
		</div>
		<!-- 汇总数据 -->
		<table id="data-statistics" style="width:1100,height : 100;">
			<tr>
				<td id="depInfo" style="width:400px;"></td>
				<td id="personNum"  style="width:350px;"></td>
				<td id="dateInfo"  style="width:340px;"></td>
			</tr>
		</table>
		<!-- 记录数据 -->
		<div  id="panel1">
			<table id="data-list1"></table>
		</div>
		<div  id="panel2">
			<table id="data-list2"></table>
		</div>
	</div>
	<div id="personalDetail" ></div>
	<div id="personalDetailJb" ></div>
</body>
</html>
