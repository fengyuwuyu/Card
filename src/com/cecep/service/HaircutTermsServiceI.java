package com.cecep.service;

import java.util.Map;

import com.cecep.model.HaircutTerms;

public interface HaircutTermsServiceI {
	Map<String,Object> dataList(HaircutTerms record);	
	Map<String,Object> save(HaircutTerms record);
	Map<String,Object> getById(HaircutTerms record);
	Map<String,Object> delete(HaircutTerms record);	

}
