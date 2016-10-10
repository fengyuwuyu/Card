package com.cecep.dao;

import java.util.List;
import java.util.Map;

import com.cecep.model.TtNation;

public interface TtNationMapper {
	
    int insert(TtNation record);
    int insertSelective(TtNation record);
    
    //下拉查询
    List<Map<String,Object>> load(TtNation record);
    
}