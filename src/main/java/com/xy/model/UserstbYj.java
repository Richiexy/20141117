package com.xy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserstbYj 用户表.
 * 
 * @author xy
 */
@Entity
@Table(name="AD_USERSTB")
public class UserstbYj implements java.io.Serializable {

	@Id
	@Column(name="USERID",length=50)
	private String userid;//用户id
	
	@Column(name="USERNAME",length=50)
	private String username;//用户名称
	
	@Column(name="USERPASSWORD",length=256)
	private String userpassword;//用户密码
	
	@Column(name="USERSTATE")
	private Integer userstate;//
	
	@Column(name="MODULELIST")
	private String modulelist;//
	
	@Column(name="DESCRIBE")
	private String describe;//描述
	
	@Column(name="ORGID")
	private String orgid;//
	
	@Column(name="AREANO")
	private String areano;//
	
	@Column(name="LOGINFLAG")
	private Integer loginflag;//登陆标志
	
	@Column(name="PASSWORDEDITDATE")
	private String passwordeditdate;//密码有效期
	
	@Column(name="USERTYPE")
	private String usertype;//用户级别
	
	@Column(name="SEX")
	private String sex;//性别
	
	@Column(name="WORKORG")
	private String workorg;//
	
	@Column(name="AUDITPAPER")
	private String auditpaper;//
	
	@Column(name="POSITION")
	private String position;//职位
	
	@Column(name="EMAIL")
	private String email;//邮箱地址
	
	@Column(name="TELEPHONE")
	private String telephone;//联系方式
	
	@Column(name="AUDITMANFLAG")
	private String auditmanflag; //审计人员标志
	
	@Column(name="OWNORG")
	private String ownorg;//所属网点
	
	@Column(name="IP")
	private String ip;//登陆ip
	
	@Column(name="LOGINTIME")
	private String logintime;//登陆时间
	
	@Column(name="AUDIT_LEADER_FLAG")
	private Integer auditLeaderFlag;//是否是部门领导的标志 0不是 1是
	
	@Column(name="IS_DEL")
	private String isDel; //是否删除，1-删除、0-不删除
	
	@Column(name="AUDIT_ORG_ID")
	private String auditOrgId; //审计人员所属审计机构
	
	@Column(name="RID")
	private Integer rid;	//序号，增加时+1
	
	/**
	 * 得到 序号，增加时+1
	 */
	public Integer getRid() {
		return rid;
	}
	/**
	 * 设置 序号，增加时+1
	 * @param rid
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOwnorg() {
		return ownorg;
	}

	public void setOwnorg(String ownorg) {
		this.ownorg = ownorg;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWorkorg() {
		return workorg;
	}

	public void setWorkorg(String workorg) {
		this.workorg = workorg;
	}

	public String getAuditpaper() {
		return auditpaper;
	}

	public void setAuditpaper(String auditpaper) {
		this.auditpaper = auditpaper;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/** default constructor */
	public UserstbYj() {
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public Integer getUserstate() {
		return this.userstate;
	}

	public void setUserstate(Integer userstate) {
		this.userstate = userstate;
	}

	public String getModulelist() {
		return this.modulelist;
	}

	public void setModulelist(String modulelist) {
		this.modulelist = modulelist;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getAreano() {
		return this.areano;
	}

	public void setAreano(String areano) {
		this.areano = areano;
	}

	public Integer getLoginflag() {
		return this.loginflag;
	}

	public void setLoginflag(Integer loginflag) {
		this.loginflag = loginflag;
	}

	public String getPasswordeditdate() {
		return passwordeditdate;
	}

	public void setPasswordeditdate(String passwordeditdate) {
		this.passwordeditdate = passwordeditdate;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getAuditmanflag() {
		return auditmanflag;
	}

	public void setAuditmanflag(String auditmanflag) {
		this.auditmanflag = auditmanflag;
	}

	public Integer getAuditLeaderFlag() {
		return auditLeaderFlag;
	}

	public void setAuditLeaderFlag(Integer auditLeaderFlag) {
		this.auditLeaderFlag = auditLeaderFlag;
	}

	/**
	 * @return 审计人员所属审计机构
	 */
	public String getAuditOrgId() {
		return auditOrgId;
	}

	/**
	 * @param 审计人员所属审计机构
	 */
	public void setAuditOrgId(String auditOrgId) {
		this.auditOrgId = auditOrgId;
	}
	
}