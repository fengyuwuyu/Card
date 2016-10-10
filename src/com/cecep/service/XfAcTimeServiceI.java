package com.cecep.service;

import java.util.Map;


import com.cecep.model.XfAcTime;

public interface XfAcTimeServiceI {
	
	Map<String,Object> dataList(XfAcTime record);	
	Map<String,Object> getById(XfAcTime record);
	Map<String,Object> save(XfAcTime record);
	Map<String,Object> delete(XfAcTime record);

}
