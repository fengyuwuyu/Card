package com.cecep.dao;

import java.util.List;
import java.util.Map;

import com.cecep.model.TtLizhi;

public interface TtLizhiMapper {
	
    int insert(TtLizhi record);
    int insertSelective(TtLizhi record);
    
    //下拉查询
    List<Map<String,Object>> load(TtLizhi record);
    
}