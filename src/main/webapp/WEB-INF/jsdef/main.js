Ext.onReady(function(){
	
  var store = new Ext.data.JsonStore({
    	url: path + '/gridController/getOperList',
        remoteSort:true,
        root:'results',
        totalProperty:'totalRecords',
        sortInfo: {field:'id', direction:'ASC'},
        id:'company',
            fields: [
               {name: 'id'},
               {name: 'operator_name'},
               {name: 'org_id'},
               {name: 'operator_position'},
               {name: 'description'},
               {name: 'org_id_cn'},
               {name: 'showUrlEdit',align:'center'},
               {name: 'showUrlDel',align:'center'}
            ]
    });
    
      var grid = new Ext.grid.GridPanel({
        store: store,
        columns: [
            {id:'id',header: '柜员号', width: 100,  dataIndex: 'id',comparison:'id'},
            {header: '柜员姓名', width: 100,   dataIndex: 'operator_name'},
            {header: '所属机构', width: 200, hidden:true,   dataIndex: 'org_id'},
            {header: '所属机构', width: 200,   dataIndex: 'org_id_cn'},
            {header: '岗位职务', width: 100,   dataIndex: 'operator_position'},
            {header: '描述', width: 200,  dataIndex: 'description'},
            {header: '修改', width: 50,  align:'center', dataIndex:'showUrlEdit'},
            {header: '删除', width: 50,  align:'center', dataIndex:'showUrlDel'}
        ],
        viewConfig: {
        	forceFit:true,
        	columnsText:'显示/隐藏列',
			sortAscText:'正序排列',
			sortDescText:'倒序排列'
        },
        stripeRows: true,
        height:450,
        autoHeight:false,
        title:'柜员管理',
        frame:true,
        loadMask: true,  
        tbar:[{
            text:'添加',
            tooltip:'添加柜员',
            iconCls:'add',
            handler:function(){
            	
		    }
        },'-',{
        	text: '搜索',
	   	    tooltip: '搜索',
	   	    iconCls: 'find',
	   	    handler: function() {
	   	    	
	   	    }
        }],
        bbar:new Ext.PagingToolbar({
            pageSize: 25,
            store: store,
			afterPageText: '/ {0}',
			beforePageText:"第",
			displayInfo: true,
			displayMsg:'当前记录 {0} -- {1} 条 共 {2} 条记录',
			emptyMsg: '没有数据',
			firstText: '第一页',
			prevText: '前一页',
			nextText: '后一页',
			lastText: '最末页',
			refreshText: '刷新',
			afterPageText:"页 共{0}页"
//            plugins: [new Ext.ux.ProgressBarPager(),new Ext.ux.plugins.PageComboResizer()]
        })
        
    });
     store.load({params:{start:0, limit:25}});
     new Ext.Viewport({layout:'fit',items:grid});
});