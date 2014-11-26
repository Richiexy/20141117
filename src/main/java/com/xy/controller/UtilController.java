package com.xy.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xy.util.ExtFormResult;
import com.xy.util.StringUtil;

@Controller
@RequestMapping("/utilController")
@SessionAttributes("user")
public class UtilController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 查询字典表
	 * 
	 * @param fieldname
	 * @param showParam 需要显示的一些参数 'p1','p2'...
	 * @return
	 */
	@RequestMapping(value="/getDicinfo")
	@ResponseBody
	public ExtFormResult<Map<String,String>> getDicinfoByFieldName(String fieldName, String showParam) {
		ExtFormResult<Map<String,String>> ret = new ExtFormResult<Map<String,String>>();
		
		String sql = "select code,contant from AD_DICINFOTB where fieldname = '"+fieldName+"'";
		if (StringUtil.isNotNull(showParam)) {
			sql += " and code in (" + showParam + ") ";
		}
		sql += " order by code";
		List<Map<String,String>> list  = jdbcTemplate.query(sql, new RowMapper<Map<String,String>>(){
			public Map<String, String> mapRow(ResultSet rs, int index)
					throws SQLException {
				Map<String,String> map = new HashMap<String,String>();
				map.put("value", rs.getString(1));
				map.put("text", rs.getString(2));
				return map;
			}
		});
		
		ret.setResults(list);
		ret.setSuccess(true);
		
		return ret;
	}
	
	@RequestMapping(value="/getDicinfo/first")
	@ResponseBody
	public ExtFormResult<Map<Object, Object>> getDicinfoFirst(
			String query,String fieldName) {
		ExtFormResult<Map<Object, Object>> ret = new ExtFormResult<Map<Object, Object>>();
		String sql = "select contant from AD_DICINFOTB where code=? and fieldname=?";
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put(query, jdbcTemplate.queryForObject(sql,new Object[]{query,fieldName},String.class));
		ret.setData(map);
		return ret;
	}
	
	
}