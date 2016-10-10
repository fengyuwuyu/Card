package com.cecep.service;

import java.util.List;
import java.util.Map;

import com.cecep.model.TtXueli;

public interface TtXueliServiceI {
	
	//下拉查询
    List<Map<String,Object>> load(TtXueli record);

}
