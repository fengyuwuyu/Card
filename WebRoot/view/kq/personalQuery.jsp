<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>统计分析</title>
<%@include file="../resource.jsp"%>
</head>
<body>
	<div class="easyui-panel warp" data-options="border:false">
		<form id="listForm" method="post">
		<a id="btn-export" href="${pageContext.request.contextPath}/kqRecordController/exportExcel.do?type=1&filename=_personal.xls"
							class="easyui-linkbutton" >导出Excel</a>
			<table class="easyui-datagrid"  id="data-list"
				data-options="fitColumns:true ,height : 410,width : 970,nowrap : false,
				striped : true,collapsible : true,rownumbers:true,loadMsg : '正在处理 ... ',singleSelect:true">
				<thead>
					<tr>
						<th data-options="field : 'username',width:100,align:'center'">员工姓名</th>
						<th data-options="field : 'depName',width:100,align:'center'">所属部门</th>
						<!-- <th data-options="field : 'cardSerial',width:100,align:'center',
						formatter:function(value){return value=='null'?'':value;}">员工卡号</th> -->
						<th data-options="field : 'date',width:100,align:'center'">${title }</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="item">
						<tr>
							<td>${item.username }</td>
							<td>${item.depName }</td>
							<%-- <td>${item.cardSerial }</td> --%>
							<td>${item.date }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>
