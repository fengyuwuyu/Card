package com.cecep.service;


import java.util.List;

import java.util.Map;

import com.cecep.model.DtAcType;

public interface DtAcTypeServiceI {
	
	Map<String,Object> dataList(DtAcType record);	
	Map<String,Object> getById(DtAcType record);
	Map<String,Object> save(DtAcType record);
	Map<String,Object> delete(DtAcType record);
    List<Map<String,Object>> load(DtAcType record);

}
