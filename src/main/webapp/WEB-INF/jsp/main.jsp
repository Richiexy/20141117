<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="<%=path%>/js/extjs/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="<%=path%>/js/extjs/ext-all.js"></script>
		<link rel="stylesheet" type="text/css"  href="<%=path%>/js/extjs/resources/css/ext-all.css" />
		
		<script type="text/javascript" src="<%=path%>/jsdef/main.js"></script>
	</head>
	<script type="text/javascript">
		var path = '<%=path%>' ;
	</script>
	
	<body>
	 	<div id="main-grid"></div>
	</body>
</html>
