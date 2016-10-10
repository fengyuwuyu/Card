package com.cecep.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.MjRuleRealMapper;
import com.cecep.model.MjRuleReal;
import com.cecep.service.MjRuleRealServiceI;
@Service("mjRuleRealService")
public class MjRuleRealServiceImpl implements MjRuleRealServiceI {
	
	private MjRuleRealMapper mjRuleRealMapper;
	
	@Autowired
	public void setMjRuleRealMapper(MjRuleRealMapper mjRuleRealMapper) {
		this.mjRuleRealMapper = mjRuleRealMapper;
	}

	public List<Map<String, Object>> load(MjRuleReal record) {
		List<Map<String, Object>> list = this.mjRuleRealMapper.load(record);
		return list;
	}

}
