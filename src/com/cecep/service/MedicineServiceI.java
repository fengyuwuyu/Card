package com.cecep.service;

import java.util.List;
import java.util.Map;

import com.cecep.model.Medicine;
import com.cecep.model.SysUser;


public interface MedicineServiceI {
	Map<String,Object> dataList(Medicine record);	
	Map<String,Object> save(Medicine record);
	Map<String,Object> getById(Medicine record);
	Map<String,Object> delete(Medicine record);	
	List<Map<String,Object>> load(SysUser record);
	List<Map<String,Object>> selectType(Medicine record);

}
