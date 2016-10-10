package com.cecep.service;

import java.util.List;
import java.util.Map;

import com.cecep.model.MjRuleReal;

public interface MjRuleRealServiceI {
	
    List<Map<String,Object>> load(MjRuleReal record);

}
