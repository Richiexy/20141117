<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<base href="<%=basePath%>"></base>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<script type="text/javascript">
		var pageRecorder=${sessionScope.pageRecorder};
		var path = '<%=path%>';
	</script>
	
	<script type="text/javascript" src="<%=path%>/js/extjs/adapter/ext/ext-base.js"></script>
	<script type="text/javascript" src="<%=path%>/js/extjs/ext-all.js"></script>
	<script type="text/javascript" src="<%=path%>/js/extjs/ux/ProgressBarPager.js"></script>
	<script type="text/javascript" src="<%=path%>/js/extjs/ux/PanelResizer.js"></script>
	<script type="text/javascript" src="<%=path%>/js/extjs/ux/PagingMemoryProxy.js"></script>
	<script type="text/javascript" src="<%=path%>/js/extjs/ux/LockingGridView.js"></script>
	<script type="text/javascript" src="<%=path%>/js/extjs/ux/RowEditor.js"></script>
	<script type="text/javascript" src="<%=path%>/js/extjs/ext-lang-zh_CN.js"></script>
	
	<!-- bbar 50 100 显示条数下拉框 -->
	<script type="text/javascript" src="<%=path%>/js/pageSizes.js"></script>
	
	<link rel="stylesheet" type="text/css" href="<%=path%>/js/extjs/resources/css/ext-all.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/js/extjs/ux/css/PanelResizer.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/js/extjs/ux/css/RowEditor.css" />
    
    
	<script type="text/javascript" src="<%=path%>/jsdef/edit_grid.js"></script>
    
     <style type="text/css">
      	body .x-panel {
            margin-bottom:20px;
        }
        .showQueryWin {
            background-image:url(js/extjs/resources/images/icons/fam/find.gif) !important;
        }
        .add {
	        background-image:url(js/extjs/resources/images/icons/fam/set.gif) !important;
	    }
	    .send {
	        background-image:url(js/extjs/resources/images/icons/fam/rss_go.png) !important;
	    }
	    .rec {
	        background-image:url(js/extjs/resources/images/icons/fam/prop.gif) !important;
	    }
	    .mail {
	        background-image:url(images/messeage-close.gif) !important;
	    }
        .feed_add {
            background-image:url(js/extjs/resources/images/icons/fam/feed_add.png) !important;
        }
        .delete {
            background-image:url(js/extjs/resources/images/icons/fam/delete.gif) !important;
        }
    </style>
    
  </head>
  <body>
   <div id="griddiv"></div>
  </body>
</html>
