package com.cecep.service;

import java.util.Map;

import com.cecep.model.MedicineType;


public interface MedicineTypeServiceI {
	Map<String,Object> dataList(MedicineType record);	
	Map<String,Object> save(MedicineType record);
	Map<String,Object> getById(MedicineType record);
	Map<String,Object> delete(MedicineType record);	

}
