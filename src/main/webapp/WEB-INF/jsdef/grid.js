Ext.onReady(function() {
		
	Ext.BLANK_IMAGE_URL = 'images/default/s.gif';
	
    Ext.QuickTips.init();
    
    var mask = new Ext.LoadMask(Ext.getBody(),{
    	msg: '系统正在处理，请稍等...',
    	removeMask: true
    });
    
	var sm = new Ext.grid.CheckboxSelectionModel(); 
	
    var store = new Ext.data.JsonStore({
    	url: path + '/gridController/getUsersGridJson2',
    	baseParams: {
    		start : 0,
    		limit : pageRecorder
    	},
        remoteSort:true,
        root:'results',
        totalProperty:'totalRecords',
        sortInfo: {field:'id', direction:'ASC'},
        id:'company',
            fields: [
               {name: 'userid', type: 'string'},
		    	{name: 'username', type: 'string'},
		    	{name: 'userstate', type: 'int'},
		    	{name: 'isDel', type: 'string'}
            ]
    });
    
    var editor = new Ext.ux.grid.RowEditor({
    	saveText:'保存',
    	cancelText: '取消',
        errorText: '错误',
        errorSummary: false
    });
    
     editor.on({
	  scope: this,
	  afteredit: function(roweditor, changes, record, rowIndex) {
	     mask.show();
	     Ext.Ajax.request({
	     	url: path + '/gridController/getUsersGridJson2',
	     	params: record.data,
	     	method: 'post',
	     	callback: function(o,s,response) {
	     		mask.hide();
	     		var json = Ext.util.JSON.decode(response.responseText);
	     		if(!json.success) {
	     			MSG.error(json.errorMessage);
	     		}
	     		store.reload();
	     	}
	     });
	  },
	  canceledit: function(roweditor, changes, record, rowIndex) {
	  	  store.reload();
	  }
	});
    
   var gridPanel = new Ext.grid.GridPanel({
   		name:'gridPanel',
   		store: store,
   		title:'用户管理',
   		frame:true,
   		autoScroll:true,
//   		height:450,
        autoHeight:false,
   		stripeRows:false,
        viewConfig: {
            forceFit: true,
            columnsText:'显示/隐藏列',
			sortAscText:'正序排列',
			sortDescText:'倒序排列'
        },
        columns: [
        	sm,{	
		    	header: '用户号',
		    	dataIndex: 'userid',
		    	width: 70,
		    	editor: {xtype: 'textfield',allowBlank: false}
		    },{
		    	header: '用户名',
		    	dataIndex: 'username',
		    	width: 80,
		    	editor: {xtype: 'textfield',allowBlank: false}
		    },{
		    	header: '用户状态',
		    	dataIndex: 'userstate',
		    	width: 30,
		    	editor: {xtype: 'textfield',allowBlank: false}
		    },{
		    	header: '是否删除',
		    	dataIndex: 'isDel',
		    	width: 30,
		        editor: {
		        	xtype: 'combo',
		            allowBlank: false,
		            combodata: [['1','是'],['0','否']]
		        },
		        renderer: function(v) {
		        	return '1' == v ? '是' : '否';
		        }
		    }],
		tbar:['-',{
            text:'添加用户',
            tooltip:'添加用户',
            iconCls:'add',
            handler: function () {
            	alert();
            }
		},'-'],
		bbar: new Ext.PagingToolbar({
            pageSize: pageRecorder,
            store: store,
            displayInfo: true,
            beforePageText:"第",
            displayMsg:'当前记录 {0} -- {1} 条 共 {2} 条记录',
            emptyMsg: "没有记录",
            firstText: '第一页',
			prevText: '前一页',
			nextText: '后一页',
			lastText: '最末页',
			refreshText: '刷新',
			afterPageText:"页 共{0}页",
            plugins: [new Ext.ux.ProgressBarPager(),new Ext.ux.plugins.PageComboResizer()]
        })
            
   });
    
    new Ext.Viewport({
		layout: 'fit',
		items:gridPanel
	});
	store.load({params : {start : 0,limit : pageRecorder}	});
});