package com.xy.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.util.RootFilter;
import com.xy.util.Tree;
import com.xy.util.TreeNode;

@Controller()
@RequestMapping(value="/treeController")
public class TreeController {

	private Logger log = LoggerFactory.getLogger(TreeController.class);
	
	@RequestMapping("/getTreeJsonData")
	@ResponseBody
	public List<TreeNode> getTreeJsonData(){
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		TreeNode folder1 = new TreeNode();
		folder1.setId("f00001");
		folder1.setText("菜单1");
		folder1.setParentId("000000");
		folder1.setIconCls("send");
		folder1.setHref("");
		folder1.setType("f");
		folder1.setExpanded(true);
		folder1.setLeaf(false);
		list.add(folder1);
		
		TreeNode folder2 = new TreeNode();
		folder2.setId("f00002");
		folder2.setText("菜单2");
		folder2.setParentId("000000");
		folder2.setIconCls("send");
		folder2.setHref("");
		folder2.setType("f");
		folder2.setExpanded(true);
		folder2.setLeaf(false);
		list.add(folder2);
		
		TreeNode tmp1 = new TreeNode();
		tmp1.setId("e00011");
		tmp1.setText("菜单11");
		tmp1.setParentId("f00001");
		tmp1.setIconCls("rec");
		tmp1.setType("e");
		tmp1.setUrl("/gridController/editGridPage");
		tmp1.setExpanded(true);
		tmp1.setLeaf(true);
		list.add(tmp1);
		
		TreeNode tmp2 = new TreeNode();
		tmp2.setId("e00021");
		tmp2.setText("菜单21");
		tmp2.setParentId("f00002");
		tmp2.setIconCls("rec");
		tmp2.setType("e");
		tmp2.setUrl("/gridController/gridPage");
		tmp2.setExpanded(true);
		tmp2.setLeaf(true);
		list.add(tmp2);
		
		Tree root = new Tree(list);
		root.setRootFilter(new RootFilter() {
			public boolean isRoot(TreeNode node) {
				return "000000".equals(node.getParentId());
			}
		});	
		
		return root.getTreeNode();
	}
}
