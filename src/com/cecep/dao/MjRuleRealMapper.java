package com.cecep.dao;

import java.util.List;
import java.util.Map;

import com.cecep.model.MjRuleReal;

public interface MjRuleRealMapper {
	
    int deleteByPrimaryKey(Integer ruleNo);
    int insert(MjRuleReal record);
    int insertSelective(MjRuleReal record);
    MjRuleReal selectByPrimaryKey(Integer ruleNo);
    int updateByPrimaryKeySelective(MjRuleReal record);
    int updateByPrimaryKey(MjRuleReal record);
    
    //下拉查询
    List<Map<String,Object>> load(MjRuleReal record);
    
}