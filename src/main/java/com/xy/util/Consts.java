package com.xy.util;

import java.util.HashMap;
import java.util.Map;

public class Consts {
	
	public static final Integer PAGE_SIZE = 50;
	
	//登陆页面，首页图片设置，该属性跟top_sunyard.phg,login_sunyard.png 两张图片"_"之后的内容一样  该参数在config.properties配置
	public static String IMG_LOGIN_TYPE="sunyard";
	
	public static String SYSTEM_ROOT_PATH = "";   // 系统根目录当系统启动时赋值
	public static Integer SCAN_SERVER_PORT = null;  // 扫描仪服务器端端口
	public static String SCAN_SERVER_IP = null;    // 扫描仪服务器IP
	
	//字典表
	public static final String ORG_TYPE = "ORG_TYPE";//机构类型
	
	public static final String HEAD_OFFICE = "1";	//总行
	public static final String BRANCH_ORG = "2";	//支行
	public static final String LOCAL_BRANCH = "3";	//分理处
	public static final String DEPT = "4";	//部门
	
	public static final String FOLDER_TYPE = "FOLDER_TYPE";//文件夹类型 （1内规 2外规）
	public static final String MSG_TYPE = "MSG_TYPE";//消息类型
	public static final String POSITION = "POSITION";//职务
	public static final String BLANK_REGULATOR = "BLANK_REGULATOR";//外部检查机构
	public static final String BLANK_SUPERVISE = "BLANK_SUPERVISE"; //银行监管机构
	public static final String RULEANA_STATUS = "RULEANA_STATUS";//外规解读状态
	public static final String RULE_TYPE = "RULE_TYPE";//制度类型
	public static final String SECR_LEVEL = "SECR_LEVEL";//密级
	public static final String CST_PLA_STATUS = "CST_PLA_STATUS";//咨询板块状态、积分规则状态
	public static final String SCR_VAL_TYPE = "SCR_VAL_TYPE";//取值类型
	public static final String SCR_ST_TYPE = "SCR_ST_TYPE";//积分标准类型
	public static final String DATE_TYPE = "DATE_TYPE"; //节假日类型 （H 节假日 W 工作日）
	public static final String TR_RESULT = "TR_RESULT "; //核实结果（Y 举报属实 N 举报不实）
	public static final String BUSINESS_TYPE = "BUSINESS_TYPE";//合规举报业务类型
	public static final String CR_DEAL_TYPE = "CR_DEAL_TYPE";//举报人处理方式
	public static final String ANALYTIC_METHOD = "ANALYTIC_METHOD";//流程模型管理解析方式
	public static final String WORKFLOW_USER_PARSER = "WORKFLOW_USER_PARSER";//用户ID解析器
	public static final String WORKFLOW_BUSS_SERVICE = "WORKFLOW_BUSS_SERVICE";//业务执行服务
	public static final String WORKFLOW_BUSS_VIEW = "WORKFLOW_BUSS_VIEW";//业务操作视图
	public static final String PARAM_TYPE="PARAM_TYPE";//流程输入输出参数
	public static final String MODELBIG_TYPE = "MODELBIG_TYPE";//模板类别
	public static final String TPL_TYPE = "TPL_TYPE";//模板类型
	public static final String LABLE_DATA_TYPE = "LABLE_DATA_TYPE";  //标签取值方式为"系统取值"时，取值类别
	public static final String PROGRESSFLAG="PROGRESSFLAG";//项目状态
	
	public static final String PROBLEM_CORRECT_TYPE = "PROBLEM_CORRECT_TYPE"; //问题库整改方式
	public static final String PROB_SOURCE = "PROB_SOURCE";//问题库问题来源
	
	public static final String REPORT_TYPE = "REPORT_TYPE";//合规报告报告类型
	public static final String REPCONTYPE = "REPCONTYPE";//合规报告报告主体
	public static final String SEND_ORG = "SEND_ORG";    //报送机构（01人民银行、02银监会、03省联社、04本行领导、05其他）
	
	//参数表
	public static final String ORG_ROOT = "ORG_ROOT";//机构根节点黄海农商行 000000
	public static final String SYSTEM_NAME = "SYSTEM_NAME";//系统名称
	public static final String BANKER_DEPT = "BANKER_DEPT";//行长室
	//
	public static final String yyyyMMdd="yyyyMMdd";//日期格式化类型
	public static final String showDate="yyyy年MM月dd日";//日期格式化类型
	
	public static final String WORK_FLOW_BUSS_TYPE = "WORK_FLOW_BUSS_TYPE";   //工作流实例类型
	public static final String WORKFLOW_TYPE = "WORKFLOW_TYPE";   //流程类型
	/******工作流实例类型  begin*********************************/
	//合规审查
	public static final String CM_APPROVAL_DOC = "CM_APPROVAL_DOC";      //制度合同
	public static final String CM_APPROVAL_NEWPRO = "CM_APPROVAL_NEWPRO";  //新产品
	public static final String CM_APPROVAL_NEWBUSS = "CM_APPROVAL_NEWBUSS";  //新业务
	//员工积分
	public static final String CM_SCR_INFO = "CM_SCR_INFO";      //员工积分
	/******工作流实例类型  end***********************************/
	
	public static final String OUTRULE_ORG = "OUTRULE_ORG";//外规发布部门/监管部门类型
	
	public static final String FILETYPE_OUTRULE = "OUTRULE";//附件类型--外规文档
	public static final String FILETYPE_INSRULE = "INSRULE";//附件类型--内规文档
	public static final String FILETYPE_PLANCHECK = "PLANCHECK";//附件类型--计划检查文档
	public static final String FILETYPE_CHECKPROJECT = "CHECKPROJECT";//附件类型--检查项目文档
	public static final String FILETYPE_EXTERNALCHECK = "EXTERNALCHECK";//附件类型--外部检查文档
	
	public static final String PLNCHECK_PLNTYPE = "PLNTYPE";//检查计划--计划类型
	
	public static final String PLNCHECK_PLNYER = "PLNYER";//检查计划--年度
	
	public static final String PLNCHECK_PLNMON = "PLNMON";//检查计划--月度
	
	public static final String CHK_PROJECT_REAS="CHK_PROJECT_REAS";//检查立项依据
	
	public static final String CHK_PROJECT_TYPE="CHK_PROJECT_TYPE";//检查项目类型
	
	public static final String CHK_PROJECT_GRADE="CHK_PROJECT_GRADE";//检查项目级别
	
	public static final String PROJECT_PLN_TYPE="PROJECT_PLN_TYPE";//检查计划类型
	
	public static final String OUTCHK_TYPE = "OUTCHK_TYPE";  //外部检查类型
	
	public static final String ITM_SVND_ROOT="root";
	//工作计划
	public static final String WORKPLAN_YEAR = "WORKPLAN_YEAR";//工作计划年度
	//合规审查
	public static final String CHECK_APPR_TYPE="CHECK_APPR_TYPE";	//报审类型
	public static final String CHECK_TYPE_HT="HT"; //报审类型  涉法事务
	public static final String CHECK_TYPE_ZD="ZD";//报审类型  规章制度
	public static final String CHECK_TYPE_CP="CP";//报审类型  新产品
	public static final String CHECK_TYPE_LC="LC";//报审类型  新流程
	public static final String CHECK_TYPE_QT="QT";//报审类型  其他事务

	//功能模块
	public static final String SYS_TYPE="SYS_TYPE";//功能模块
	public static final String SCORE="score";//积分模块
	public static final String CHECK="CHECK";//审查模块
	public static final String MESSAGE="MESSAGE";//消息模块
	public static final String OUTCHECK = "OUTCHECK";  //外部检查

	public static final Integer pageRecorder = 30;
	
	/**
	 * 
	* @Description: 风险点类型与ID长度对于MAP
	* @creator：yuxf   
	* @createTime：2012-9-5 上午09:08:26   
	* @return Map<Integer,String>
	* @throws
	 */
	public static final Map<Integer,String> getRiskTypeGride(){
		Map<Integer,String> map = new HashMap<Integer, String>();
		map.put(3, "1");
		map.put(6, "2");
		map.put(9, "3");
		return map;
	}
	
	//-------------------------------------------------模型增加----------------------------
	public static String  DBTYPE="0";
	//当前所在地最高机构号
	public static String MainOrgId="";
	
//	是否 单独在审计查询查证目录下展示反洗钱管理目录
	public static boolean SHOW_FXQ_MENU = false;
	
//	是否 单独在审计查询查证目录下展示反洗钱管理目录id
	public static String FXQ_MENU_ID = "327";
	
//	是否 允许删除 抽样操作 当前节点下的子节点
	public static boolean IS_DELETE_SAMPLE_NODE = true;
	
	//0:表示以单个模型为单位进行任务分配 1:表示以机构为单位进行任务分配 2:表示以业务条线为单位进行任务分配
	public static String TRAIL_DIST_TYPE = "0";
	//------------------------------------------------------------------------------------
}
