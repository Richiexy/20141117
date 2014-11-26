package com.xy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {

	public Map<String,Object> getMap(List<?> t){

		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", t.size());
		modelMap.put("data", t);
		modelMap.put("success", true);

		return modelMap;
	}

}
