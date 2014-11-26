package com.xy.util;

import java.util.List;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
/**
 * 树型结构组件的返回对象 
 *
 */
@JsonSerialize(include=Inclusion.NON_NULL)
public class TreeNode {
	private String id;
	private String text;
	private String cls;
	private String icon;
	private String iconCls;
	private String href;
	private String hrefTarget;
	private boolean leaf;
	private boolean expanded = false;
	private Boolean checked = null;//带复选框
	private Integer childcount;
	private String parentId;
	private boolean menuHead;
	private List<TreeNode> children;	
	private String type;// "r":root,"f":folder,"e":leaf
	private Integer authType;
	private String url;//链接地址
	private long openflag;
	private long enableflag;
	public TreeNode(){
		
	}

	public TreeNode(String id, String text, boolean leaf) {
		super();
		this.id = id;
		this.text = text;
		this.leaf = leaf;
	}
	public TreeNode(String id, String text, boolean leaf, String href) {
		super();
		this.id = id;
		this.text = text;
		this.leaf = leaf;
		this.href = href;
	}
	
	public TreeNode(String id, String text, String cls, boolean leaf,
			String href) {
		super();
		this.id = id;
		this.text = text;
		this.cls = cls;
		this.leaf = leaf;
		this.href = href;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getHrefTarget() {
		return hrefTarget;
	}

	public void setHrefTarget(String hrefTarget) {
		this.hrefTarget = hrefTarget;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Integer getChildcount() {
		return childcount;
	}

	public void setChildcount(Integer childcount) {
		this.childcount = childcount;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	public long getOpenflag() {
		return openflag;
	}

	public void setOpenflag(long openflag) {
		this.openflag = openflag;
	}

	public long getEnableflag() {
		return enableflag;
	}

	public void setEnableflag(long enableflag) {
		this.enableflag = enableflag;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Integer getAuthType() {
		return authType;
	}
	public void setAuthType(Integer authType) {
		this.authType = authType;
	}
	
	public boolean isMenuHead() {
		return menuHead;
	}

	public void setMenuHead(boolean menuHead) {
		this.menuHead = menuHead;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
