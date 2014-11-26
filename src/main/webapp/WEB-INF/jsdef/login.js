
Ext.onReady(function() {
		
	Ext.BLANK_IMAGE_URL = 'images/default/s.gif';
	
    Ext.QuickTips.init();
    
   var loginForm = new Ext.FormPanel({
   		labelAlign:'right',
   		monitorValid:true,//只有输入都正确后登录按钮才有用
   		frame:true,
   		defaults: {
			allowBlank: false,
			anchor: '80%',
			msgTarget: 'side'
		},
   		items:[{
   			fieldLabel:'用户名',
   			balanText:'请输入用户名',
   			name:'userName',
   			xtype:'textfield'
   		},{
   			fieldLabel:'密码',
   			balanText:'请输入密码',
   			name:'userPwd',
   			xtype:'textfield',
   			inputType:'password',
   			minLength:1,
   			maxLength:6
   		}]
   });
//   
   var loginWin = new Ext.Window({
   		closable:false,
   		title:'用户登录',
   		frame:true,
   		width:300,
   		height:170,
   		layout:'fit',
   		items:[loginForm],
   		buttons:[{
   			text:'保存',
   			formBind:true,
   			handler:function(){
   				loginForm.getForm().submit({
					url : path + '/loginController/login',
					method : 'POST',
					waitMsg : '系统登录中.....',
					success : function(form, action) {
						Ext.Msg.alert('提示','登录成功,即将跳转主页面',function(){
							window.location.href = path + "/loginController/mainPage";
						});
						
					},
					failure : function(form, action) {
						Ext.Msg.alert('登录失败'+action.result.errorMessage);
					}
				});
   			}
   		},{
   			text:'取消',
   			handler:function(){
   				loginForm.getForm().reset();
   			}
   		}]
   });
//   
   loginWin.show();
    
});