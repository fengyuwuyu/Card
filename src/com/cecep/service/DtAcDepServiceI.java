package com.cecep.service;

import java.util.List;
import java.util.Map;

import com.cecep.model.DtAcDep;

public interface DtAcDepServiceI {
	
	Object dataList(DtAcDep record);	
    List<Map<String,Object>> load(Integer depParent);

}
