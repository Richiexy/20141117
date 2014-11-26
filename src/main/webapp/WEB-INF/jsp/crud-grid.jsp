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
		
		<link rel="stylesheet" type="text/css"  href="<%=path%>/css/layout.css" />
		<script type="text/javascript" src="<%=path%>/jsdef/crud-grid.js"></script>
		
		<!-- Row Editor plugin css -->
	<link rel="stylesheet" type="text/css" href="<%=path%>/js/extjs/ux/css/rowEditorCustom.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/examples.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/js/extjs/ux/css/RowEditor.css" />

	<!-- Row Editor plugin js -->
	<script src="<%=path%>/js/extjs/ux/RowEditor.js"></script>
	</head>
	<script type="text/javascript">
		var path = '<%=path%>' ;
	</script>
	
	<body>
	 	<div id="crud-grid"></div>
	</body>
</html>
