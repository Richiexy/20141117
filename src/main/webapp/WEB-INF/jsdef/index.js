
Ext.onReady(function() {
		
	Ext.BLANK_IMAGE_URL = 'images/default/s.gif';
	
    Ext.QuickTips.init();
    
    var oprations = {
    	userName:'11111111111111',
    	cuurDate:'2014-07-07'
    };
    
    var xtp = new Ext.XTemplate(
			'<div id="divTemplate" >',
			'<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3" class="main_table">',
			'<tr>',
				'<td width="40%" align="left" ></td>','<td align="left" width="30%"></td>',
				'<td width="8%" align="left" >用户名：</td>','<td align="left" width="7%">{userName}</td>',
				'<td width="8%" align="left" >当前日期：</td>','<td align="left" width="7%">{cuurDate}</td>', 
			'</tr>', 
			'</table>', 
			'</div>'
	);
    
    var northPanel = new Ext.Panel({
    	region: 'north',
    	split: true,
    	frame :true,
    	height :100,
    	itemId :'northPanel',
    	title :' 系统首页 !',
    	headerAsText :true,
    	html : xtp.applyTemplate(oprations)
    });
    
    var leftPanel = new Ext.tree.TreePanel({
    	region : 'west',
    	rootVisible : false,
	    title: '左侧菜单',
	    id: 'tree-panel', 
	    split: true,
	    width: 200,
	    minSize: 175,
	    maxSize: 400,
	    collapsible: true,
	    autoScroll:true, 
	    margins: '0 0 0 5',
	    animate:true,
	    containerScroll: true, 
	    loader: new Ext.tree.TreeLoader({
	        dataUrl: path +'/treeController/getTreeJsonData'
	    }),
	    root: {
	       nodeType: 'async',
	       text: '菜单',
	       id:'000000',
	       draggable: false,
	       expanded: true
	    }   
    });
    
    
    leftPanel.on("click",function(node,e) {
    	var type = node.attributes.type;
    	var tabName = node.attributes.text;
    	var pageUrl = path + node.attributes.url;
    	
		if(type=='e'){
			//tab页
			addTabPanel(node.id, tabName, pageUrl);
		}else{
			e.preventDefault(); 
	   	 	node.select(); 
		}
	});
    
    
    var tabPanel = new Ext.TabPanel({
        region:'center',
        name:'main_tab',
        activeTab:0,
        autoScroll :true,
        items:[{
        	xtype:'panel',
        	layout:'fit',
        	autoScroll :true,
        	title:'欢饮面板',
        	height: '100%'
        }]
    });
    
    addTabPanel = function(id,name,pageUrl){
    	//判断TabPanel是否超过限制
		if(tabPanel.items.length > 10){
			MSG.info("您打开的页面超过限制，请关闭部分页面再操作！");
			return;
		}
		var tab = tabPanel.getComponent('main_tab_'+id);
		if(tab){
//			tabPanel.remove(tab);	//如果已经打开tab页，则移除
			tabPanel.setActiveTab(tab);
		}else{
			tab=Ext.create({
	            xtype:'panel',
	            title:name,
	            closable:true,
	            id:'main_tab_'+id,
	            html:'<iframe src="'+pageUrl+'" name="ifr_main_'+id+'" width="100%" marginwidth="0" height="100%" marginheight="0" scrolling="auto" frameborder="0"></iframe>'
	        });
        	tabPanel.add(tab).show();
		}
		
    }
    
    new Ext.Viewport({
		layout: 'border',
		items:[northPanel,leftPanel , tabPanel]
	});
	
});