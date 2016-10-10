package com.cecep.service;

import java.util.Map;


import com.cecep.model.MjUserRuleReal;

public interface MjUserRuleRealServiceI {
	
	Map<String,Object> dataList(MjUserRuleReal record);	
	Map<String,Object> save(String userSerials,String depSerials,String doorSerials,String siteSerials,String ruleNo,String ruleNo2,String glyNo);
	Map<String,Object> delete(String xhs);

}
