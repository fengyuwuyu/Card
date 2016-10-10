<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>食堂消费统计</title>

<%@include file="../resource.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ux/mess/messStatistics.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ux/mess/mess.js"></script>
<style type="text/css">
#kq_query input,select {
	width: 120px;
}

#kq_query .search_label {
	width: 60px;
}

#data-statistics{
  margin: 0;
  padding: 0;
}

#kq_query .search_label {
	width: 60px;
}

#data-statistics td{
  border-width: 0 1px 1px 1px;
  border-style: dotted;
  margin: 0;
  padding: 0;
}

#byDay{
  margin: 0;
  padding: 0;
}

.datagrid-cell-c1-depName,.datagrid-cell-c1-region,.datagrid-cell-c1-machine,.datagrid-cell-c1-zaocMoney,.datagrid-cell-c1-zaocCount,
.datagrid-cell-c1-zcMoney,.datagrid-cell-c1-zcCount,.datagrid-cell-c1-wcMoney,.datagrid-cell-c1-wcCount,.datagrid-cell-c1-yxMoney,
.datagrid-cell-c1-yxCount,.datagrid-cell-c1-totalPrice,.datagrid-cell-c1-totalCount{
	text-align: center;
}

</style>
</head>
<body>
	<div class="easyui-panel warp" data-options="border:false">
		<div class="easyui-panel ui-search-panel" title="查询条件"
			data-options="striped: true,collapsible:true,iconCls:'icon-search',width:1100">
			<form id="searchForm" method="post">
				<p class="ui-fields">
					<input type="hidden" id="personal" name="personal" value="${personal }"/> 
				<table id="kq_query">
					<% 
						Integer personal = (Integer)request.getAttribute("personal");
						if(personal!=1){
					%>
						<tr>
						<td class="search_label">部门：</td>
						<td><select name="depSerial" id="depSerial" class="easyui-combotree" data-options="multiple:true,method:'get',url:'${pageContext.request.contextPath}/messConsumeController/loadDep.do',queryParams:{'personal':${personal }},panelWidth:260,panelHeight:300,editable:false,animate:true,hasDownArrow:false,lines:true"></select>&nbsp;&nbsp;&nbsp;
						</td>
						<td class="search_label">刷卡机器：</td>
						<td><input name="machineBh" id="machineBh" type="text" class="easyui-combobox" 
						data-options="multiple:true,valueField:'bh',textField:'mc',panelHeight:'auto',method:'get',url:'${pageContext.request.contextPath}/deviceController/select.do',editable:false"></td>
						<td class="search_label">餐类：</td>
						<td><input name="type" id="type"></input></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td class="search_label">起始日期：</td>
						<td><input name="kssj" id="kssj" type="text"
							class="easyui-datebox" editable="false" /></td>
						<td class="search_label">结束日期：</td>
						<td><input type="text" name="jssj" id="jssj"
							class="easyui-datebox" editable="false" /></td>
						<td class="search_label">统计方式：</td>
						<td><input name="statisticType" id="statisticType" type="text" class="easyui-combobox" 
						data-options="valueField:'key',textField:'value',panelHeight:'auto',data:[{key:'1',value:'部门'},
						{key:'3',value:'机器'}],editable:false"></td>
						<td ><label><input id="byDay" name="byDay" type="checkbox" style="width:30px;"/>每天 </label></td>
						<td ><a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        					<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
							<a id="btn-export" href="${pageContext.request.contextPath}/kqRecordController/exportExcel.do?type=1&filename=_messStatistics.xls"
							class="easyui-linkbutton" >导出Excel</a>
							<a id="btn-exportword" href="${pageContext.request.contextPath}/kqRecordController/exportExcel.do?type=2"
							class="easyui-linkbutton" data-options="iconCls:'icon-load'" >导出word</a>
						</td>
					</tr>
					<%	}else{%>
					<tr>
						<td class="search_label">刷卡机器：</td>
						<td><input name="machineBh" id="machineBh" type="text" class="easyui-combobox" 
						data-options="multiple:true,valueField:'bh',textField:'mc',panelHeight:'auto',method:'get',url:'${pageContext.request.contextPath}/deviceController/select.do',editable:false"></td>
						<td class="search_label">餐类：</td>
						<td><input name="type" id="type"></input></td>
						<td class="search_label">起始日期：</td>
						<td><input name="kssj" id="kssj" type="text"
							class="easyui-datebox" editable="false" /></td>
						<td class="search_label">结束日期：</td>
						<td><input type="text" name="jssj" id="jssj"
							class="easyui-datebox" editable="false" /></td>
						<td ><label><input id="byDay" name="byDay" type="checkbox" style="width:30px;"/>每天 </label></td>
						<td ><a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        					<div id="menu-reset"><div id="btn-reset" iconCls="icon-reset">重置</div></div>
							<a id="btn-export" href="${pageContext.request.contextPath}/kqRecordController/exportExcel.do?type=1&filename=_messStatistics.xls"
							class="easyui-linkbutton" >导出Excel</a>
							<a id="btn-exportword" href="${pageContext.request.contextPath}/kqRecordController/exportExcel.do?type=2"
							class="easyui-linkbutton" data-options="iconCls:'icon-load'" >导出word</a>
						</td>
					</tr>
					<%}%>
				</table>

			</form>
		</div>
		<form id="listForm" method="post" >
			<table id="data-list">
				<thead>
			<tr>
				<th rowspan="2" field="date" width="100" align="center">日期</th>
				<th rowspan="2" field="depName" width="80" align="center">所属部门</th>
				<% if(personal!=1){%>
				<th rowspan="2" field="region" width="80" align="center">区域</th>
				<%}%>
				<th rowspan="2" field="machine" width="80" align="center">机器</th>
				<th rowspan="2" field="zaocMoney" width="80" align="center">早餐金额</th>
				<th rowspan="2" field="zaocCount" width="60" align="center">早餐笔数</th>
				<th rowspan="2" field="zcMoney" width="80" align="center">中餐金额</th>
				<th rowspan="2" field="zcCount" width="60" align="center">中餐笔数</th>
				<th rowspan="2" field="wcMoney" width="80" align="center">晚餐金额</th>
				<th rowspan="2" field="wcCount" width="60" align="center">晚餐笔数</th>
				<th rowspan="2" field="yxMoney" width="80" align="center">夜宵金额</th>
				<th rowspan="2" field="yxCount" width="60" align="center">夜宵笔数</th>
				<th colspan="2">小计</th>
			</tr>
			<tr>
				<th field="totalPrice" width="80" align="right">金额小计</th>
				<th field="totalCount" width="80" align="right">笔数小计</th>
			</tr>
		</thead>
			</table>
		</form>
	</div>
</body>
</html>
