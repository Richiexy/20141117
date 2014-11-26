package com.xy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xy.model.AdPrProblemstb;
import com.xy.service.IGridService;
import com.xy.util.StringUtil;

@Service("gridService")
@Transactional
public class GridServiceImpl  implements IGridService{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<AdPrProblemstb> getProblemsList() {
		List<AdPrProblemstb> temp = hibernateTemplate.find(" from AdPrProblemstb");
		return temp;
	}
	
	@Override
	public String getOperList(String start, String limit){
		List<String[]> tempList = new ArrayList<String[]>();
		for(int i=0;i<1000;i++){
			String[] tmp = new String[6];
			tmp[0] = i + "";
			tmp[1] = i+ "用户名";
			tmp[2] = i+ "机构编号";
			tmp[3] = i+ "职务";
			tmp[4] = i+ "描述";
			tmp[5] = i+ "机构名称";
			tempList.add(tmp);
		}
		
		//showFieldTwo 区别以上的查询字段，此处新增一个org_id_cn，所属机构中文显示。
				String showFieldTwo = "id,operator_name,org_id,operator_position,description,org_id_cn";
		String jsonStr = StringUtil.getJsonDate(tempList, showFieldTwo
				.split(","), 100); 

		return jsonStr;
	}

	
}
