package com.cecep.service;

import java.util.Map;

import com.cecep.model.StDevice;


public interface StDeviceServiceI {
	
	Map<String,Object> dataList(StDevice query);

}
