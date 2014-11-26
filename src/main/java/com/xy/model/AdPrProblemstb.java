package com.xy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
@Entity
@Table(name="ad_pr_problemstb")
public class AdPrProblemstb {

	// Fields
	private Integer proId;              //问题ID 
	private String proCode;             //问题编号 xc+日期（yyyyMMdd）+0001（4位顺序号）问题编号规则： xc（现场问题）fx（非现场问题）wb（外部问题）qt（其他问题）
	private String proName;             //问题名称
	private String riskLevel;           //风险等级
	private String bussDate;            //业务日期 (yyyy-MM-dd)
	private String proRemark;           //问题备注
	private String proDesc;             //问题描述
	private String bussOrg;             //经办机构
	private String bussUserName;        //经办人
	private Integer proSrc;                // 问题来源 1：现场问题  2：非现场问题 3:外部导入问题 4：其他
	private String proSrcId;            //问题来源编号,现场问题结论表（AD_FLOW_AUDITRESULTSTB）编号，预警问题预警表（ad_warn_infotb）编号
	private String proBussType;         //问题业务类型
	private String wordId;              //问题词条编号
	private String wordName;            //问题词条名称
	private String wordLevel1;          //业务种类编号
	private String wordLevel1Name;      //业务种类名称
	private String wordLevel2;          //业务单元编号
	private String wordLevel2Name;      //业务单元名称
	private String wordLevel3;          //业务环节编号
	private String wordLevel3Name;      //业务环节名称 
	private String wordLevel4;          //控制点编号
	private String wordLevel4Name;      //控制点名称
	private String createTime;          //创建时间
	private String createUser;          //创建人
	private Integer isReport;      		//是否入报告（0：不需要 1 需要）

	@Id
	@Column(name="pro_id")
	public Integer getProId() {
		return this.proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	@Column(name="pro_code")
	public String getProCode() {
		return this.proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	@Column(name="pro_name")
	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	@Column(name="risk_level")
	public String getRiskLevel() {
		return this.riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	@Column(name="buss_date")
	public String getBussDate() {
		return this.bussDate;
	}

	public void setBussDate(String bussDate) {
		this.bussDate = bussDate;
	}

	@Column(name="pro_remark")
	public String getProRemark() {
		return this.proRemark;
	}

	public void setProRemark(String proRemark) {
		this.proRemark = proRemark;
	}

	@Column(name="pro_desc")
	public String getProDesc() {
		return this.proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}

	@Column(name="buss_org")
	public String getBussOrg() {
		return this.bussOrg;
	}

	public void setBussOrg(String bussOrg) {
		this.bussOrg = bussOrg;
	}

	@Column(name="buss_user_name")
	public String getBussUserName() {
		return this.bussUserName;
	}

	public void setBussUserName(String bussUserName) {
		this.bussUserName = bussUserName;
	}

	@Column(name="pro_src")
	public Integer getProSrc() {
		return this.proSrc;
	}

	public void setProSrc(Integer proSrc) {
		this.proSrc = proSrc;
	}

	@Column(name="pro_src_id")
	public String getProSrcId() {
		return this.proSrcId;
	}

	public void setProSrcId(String proSrcId) {
		this.proSrcId = proSrcId;
	}

	@Column(name="pro_buss_type")
	public String getProBussType() {
		return this.proBussType;
	}

	public void setProBussType(String proBussType) {
		this.proBussType = proBussType;
	}

	@Column(name="word_id")
	public String getWordId() {
		return this.wordId;
	}

	public void setWordId(String wordId) {
		this.wordId = wordId;
	}

	@Column(name="word_name")
	public String getWordName() {
		return this.wordName;
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	@Column(name="word_level1")
	public String getWordLevel1() {
		return this.wordLevel1;
	}

	public void setWordLevel1(String wordLevel1) {
		this.wordLevel1 = wordLevel1;
	}

	@Column(name="word_level1_name")
	public String getWordLevel1Name() {
		return this.wordLevel1Name;
	}

	public void setWordLevel1Name(String wordLevel1Name) {
		this.wordLevel1Name = wordLevel1Name;
	}

	@Column(name="word_level2")
	public String getWordLevel2() {
		return this.wordLevel2;
	}

	public void setWordLevel2(String wordLevel2) {
		this.wordLevel2 = wordLevel2;
	}

	@Column(name="word_level2_name")
	public String getWordLevel2Name() {
		return this.wordLevel2Name;
	}

	public void setWordLevel2Name(String wordLevel2Name) {
		this.wordLevel2Name = wordLevel2Name;
	}

	@Column(name="word_level3")
	public String getWordLevel3() {
		return this.wordLevel3;
	}

	public void setWordLevel3(String wordLevel3) {
		this.wordLevel3 = wordLevel3;
	}

	@Column(name="word_level3_name")
	public String getWordLevel3Name() {
		return this.wordLevel3Name;
	}

	public void setWordLevel3Name(String wordLevel3Name) {
		this.wordLevel3Name = wordLevel3Name;
	}

	@Column(name="word_level4")
	public String getWordLevel4() {
		return this.wordLevel4;
	}

	public void setWordLevel4(String wordLevel4) {
		this.wordLevel4 = wordLevel4;
	}

	@Column(name="word_level4_name")
	public String getWordLevel4Name() {
		return this.wordLevel4Name;
	}

	public void setWordLevel4Name(String wordLevel4Name) {
		this.wordLevel4Name = wordLevel4Name;
	}

	@Column(name="create_time")
	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Column(name="create_user")
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name="is_report")
	public Integer getIsReport() {
		return isReport;
	}

	public void setIsReport(Integer isReport) {
		this.isReport = isReport;
	}

}