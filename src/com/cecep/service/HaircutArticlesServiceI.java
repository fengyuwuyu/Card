package com.cecep.service;

import java.util.Map;

import com.cecep.model.HaircutArticles;


public interface HaircutArticlesServiceI {
	Map<String,Object> dataList(HaircutArticles record);	
	Map<String,Object> save(HaircutArticles record);
	Map<String,Object> getById(HaircutArticles record);
	Map<String,Object> delete(HaircutArticles record);	

}
