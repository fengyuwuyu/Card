<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String  loginPath=basePath+"login.jsp";
String msg=(String)request.getAttribute("msg");
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>单点登录失败跳转页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	<style>
body #error{
	width: 100%;
	height: 100%;
	padding: 0px;
	margin: 0px;
}

div#error_404 {
	width: 100%;
	height: 100%;
	margin: 0 auto;
	text-align: center;
	background: url("images/ssloginError/error_404_bg.gif") repeat-x scroll left top #fff;
}

div.error_404 {
	width: 520px;
	margin: 0 auto;
	text-align: left;
	font-size: 16px;
	font-family: "Microsoft YaHei", "微软雅黑";
	color: #333;
	clear: both;
}

div.error_404 div.errorIcon {
	background: url("images/ssloginError/error_404_icon.gif") no-repeat scroll left top transparent;
	width: 126px;
	height: 160px;
	margin: 160px 50px 0 0;
	float: left;
}

div.error_404 div.errorCont {
	float: left;
	margin: 200px 0 0;
}

div.error_404 div.errorCont p {
	padding: 0px;
	margin: 0 0 12px;
	letter-spacing: 2px;
}

div.error_404 div.errorCont p.errow_btn {
	background: url("images/ssloginError/btn-leftbg.png") no-repeat scroll left center transparent;
	height: 29px;
	line-height: 29px;
	letter-spacing: 1px;
}

div.error_404 div.errorCont p.errow_btn a {
	background: url("images/ssloginError/btn-rightbg.png") no-repeat scroll right top transparent;
	display: inline-block;
	margin: 0 0 0 4px;
	padding: 3 10px 0 3px;
	height: 29px;
	line-height: 22px;
	_line-height: 24px;
	font-size: 14px;
	text-decoration: none;
	color: #333;
}
</style>

	
  </head>
  <body >
	<input type="hidden" id="_sessionTimeOutFlag" />
	<div id="error_404">
		<div class="error_404">
			<div class="errorIcon"></div>
			<div class="errorCont">
				<p>對不起,${msg}</p>
				<p class="errow_btn">
					<a href="<%=loginPath %>">去往首頁</a>
				</p>
			</div>
		</div>
	</div>
	
	
  </body>
</html>
