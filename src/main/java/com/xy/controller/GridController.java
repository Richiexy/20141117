package com.xy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xy.model.UserstbYj;
import com.xy.service.HqlOperate;
import com.xy.service.IGridService;
import com.xy.util.ExtFormResult;

@Controller
@RequestMapping("/gridController")
@SessionAttributes("user")
public class GridController extends BaseController {
	
	private Logger logger = LoggerFactory.getLogger(GridController.class);

	@Autowired
	private IGridService gridService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired(required = false)
	private HqlOperate hqlOperate;
	
	@RequestMapping("/getOperList")
	@ResponseBody
	public String getOperList(String start,String limit){
		
		return gridService.getOperList(start,limit);
	}
	
	@RequestMapping("/editGridPage")
	public String editGridPage(){
		return "edit_grid";
	}
	
	@RequestMapping("/gridPage")
	public String gridPage(){
		return "grid";
	}

	@RequestMapping(value="/getUsersGridJson")
	@ResponseBody
	public ExtFormResult<UserstbYj> getUsersGridJson(int start , int limit) {
		ExtFormResult<UserstbYj> ret = new ExtFormResult<UserstbYj>();
		try {
			List<UserstbYj> users = hqlOperate.getPagedByHql("from UserstbYj ", start , limit);
			ret.setTotalRecords(jdbcTemplate.queryForLong("select count(*) from AD_USERSTB"));
			ret.setResults(users);
			ret.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			ret.setSuccess(false);
			ret.setErrorMessage("查询数据出错！");
		}
		return ret;
	}
	
	@RequestMapping(value="/getUsersGridJson2")
	@ResponseBody
	public ExtFormResult<UserstbYj> getUsersGridJson2(int start , int limit) {
		ExtFormResult<UserstbYj> ret = new ExtFormResult<UserstbYj>();
		try {
			List<UserstbYj> users = hqlOperate.getPagedByHql("from UserstbYj ", start , limit);
			ret.setTotalRecords(jdbcTemplate.queryForLong("select count(*) from AD_USERSTB"));
			ret.setResults(users);
			ret.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			ret.setSuccess(false);
			ret.setErrorMessage("查询数据出错！");
		}
		return ret;
	}
}
