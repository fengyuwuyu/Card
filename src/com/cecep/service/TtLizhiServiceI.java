package com.cecep.service;

import java.util.List;

import java.util.Map;

import com.cecep.model.TtLizhi;


public interface TtLizhiServiceI {
	
	List<Map<String,Object>> load(TtLizhi record);
	
}
