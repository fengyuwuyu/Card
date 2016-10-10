<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 	<head>
  		<title></title>	
		<%@include file="../resource.jsp"%>    	
    	<link rel="stylesheet" type="text/css" href="../../css/login.css"></link>
    	<script type="text/javascript" src="${pageContext.request.contextPath }/js/ux/login.js"></script>
  	</head> 
	<body class="loginbg">			
		<div class="login">
	  		<div class="from">	  
	    		 <form id="loginForm" action="${pageContext.request.contextPath }/main/login.do" method="post"> 
		    		<ul>
		      			<li><span>用户名：</span><input class="easyui-validatebox txtusernamecssclass" id="username" data-options="required:true,missingMessage:'姓名、工号不能为空.',validType:'length[1,25]'" type="text" name="loginid" /></li>
		      			<li><span>密　码：</span><input class="easyui-validatebox txtpasswordcssclass"   data-options="required:true,missingMessage:'密码不能为空.',validType:'length[1,25]'" type="password" name="password" /></li>
		      			<li><input type="button" value="登录" class="button2" /></li>
		    		</ul>
	    		 </form> 
	  		</div>
		</div>
	</body>
</html>
