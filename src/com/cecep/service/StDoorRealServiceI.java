package com.cecep.service;


import java.util.List;
import java.util.Map;

import com.cecep.model.DtUser;
import com.cecep.model.StDoorReal;

public interface StDoorRealServiceI {
	
	Map<String,Object> dataList(StDoorReal record);

	List<Map<String,Object>> selectStDoor();

	Map<String, Object> save(DtUser currUser, StDoorReal record);

	Map<String, Object> getById(StDoorReal record);

	Map<String, Object> delete(StDoorReal query);	

}
