package com.cecep.service;

import java.util.List;
import java.util.Map;









import com.cecep.model.XfTime;

public interface XfTimeServiceI {
	
	Map<String,Object> dataList(XfTime record);	
	Map<String,Object> getById(XfTime record);
    List<Map<String,Object>> load(XfTime record);
    Map<String, Object> selectByPage(XfTime record);
    Map<String, Object> save(XfTime record);
	Map<String, Object> getExternalXfTimes(Integer record);
	Map<String, Object> saveDevTime(String[] addTimes, Integer depSerial, String string);
	Map<String, Object> remove(String bh);
}
