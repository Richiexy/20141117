package com.xy.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xy.util.Consts;
import com.xy.util.ExtFormResult;

@Controller
@RequestMapping("/loginController")
@SessionAttributes("user")
public class LoginController {
	
	private Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="/crudGrid")
	public String crudGrid(Model model){
		return "crud-grid";
	}
	
	@RequestMapping("/mainPage")
	public String mainPage(){
		return "index";
	}

	@RequestMapping(value="/login")
	@ResponseBody
	public ExtFormResult<String> login(HttpServletRequest request, 
			@RequestParam Map<String, String> paraMap,
			HttpSession session, ModelMap map){
		
		ExtFormResult<String> ret = new ExtFormResult<String>();
		
		String opercode = paraMap.containsKey("userName") ? paraMap.get("userName") : "";
		String passwd = paraMap.containsKey("userPwd") ? paraMap.get("userPwd") : "";
		
		Integer rightCount = jdbcTemplate.queryForInt("select count(*) from AD_USERSTB where USERNAME = '"+opercode+"' and USERPASSWORD = '"+passwd+"'");
		Integer passCount = jdbcTemplate.queryForInt("select count(*) from AD_USERSTB where USERPASSWORD = '"+passwd+"'");
		Integer opercodeCount = jdbcTemplate.queryForInt("select count(*) from AD_USERSTB where USERNAME = '"+opercode+"'");
		if(rightCount == 0){
			if( opercodeCount == 1 ){
				ret.setSuccess(false);
				ret.setErrorMessage("密码错误");
				return ret;
			}else if( passCount == 1 ){
				ret.setSuccess(false);
				ret.setErrorMessage("用户名错误");
				return ret;
			}else if( passCount == 0 && opercodeCount == 0){
				ret.setSuccess(false);
				ret.setErrorMessage("用户名密码错误");
				return ret;
			}
	    }else if(rightCount == 1){
	    	map.addAttribute("uKey", opercode);
		}
		
		session.setAttribute("pageRecorder", Consts.pageRecorder);
		log.debug("用户登录！");
		return ret;
	}
}
