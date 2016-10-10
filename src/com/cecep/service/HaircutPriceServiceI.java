package com.cecep.service;

import java.util.Map;

import com.cecep.model.HaircutPrice;


public interface HaircutPriceServiceI {
	Map<String,Object> dataList(HaircutPrice record);	
	Map<String,Object> save(HaircutPrice record);
	Map<String,Object> getById(HaircutPrice record);
	Map<String,Object> delete(HaircutPrice record);	

}
