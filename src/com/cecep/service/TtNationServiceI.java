package com.cecep.service;

import java.util.List;
import java.util.Map;

import com.cecep.model.TtNation;

public interface TtNationServiceI {
	
	//下拉查询
    List<Map<String,Object>> load(TtNation record);

}
