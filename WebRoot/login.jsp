<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>中国节能一卡通综合管理平台</title>	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="中节能咨询,图书管理,信息技术">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
		window.onload=function(){
			if (window != top) 
			top.location.href = location.href; 		
		};		
	</script>
</head>
	<frameset rows="76,*,40" frameborder="no" border="0" framespacing="0">
	  <frame id="topFrame" title="topFrame" name="topFrame" src="./view/login/login_header.jsp" scrolling="No" noresize="noresize"  />
	  <frame id="mainFrame" title="mainFrame" name="mainFrame" src="./view/login/login_main.jsp" scrolling="No" noresize="noresize" />
	  <frame id="bottomFrame" title="bottomFrame" name="bottomFrame" src="./view/login/footer.jsp" scrolling="No" noresize="noresize"  />
	</frameset>
	<noframes>
		<body>
		</body>
	</noframes>
</html>