package com.cecep.dao;

import java.util.List;
import java.util.Map;

import com.cecep.model.TtXueli;

public interface TtXueliMapper {
	
    int insert(TtXueli record);
    int insertSelective(TtXueli record);
    
    //下拉查询
    List<Map<String,Object>> load(TtXueli record);
    
}