package com.cecep.service;



import java.util.List;
import java.util.Map;











import com.cecep.model.DtUser;
import com.cecep.model.MidUser;

public interface MidUserServiceI {

	void save(MidUser record);
	Map<String,Object> selectIsSynchronized(MidUser record);
	Map<String,Object> synchronize();
	Map<String, Object> synchronizeRepeatDtUser(String userSerial);
	Map<String,Object> initInternalUser();
	Map<String,Object> initExternalUser();
	
	Map<String,Object> saveInternalUser1();
	Map<String, Object> insertTestKqJl();
	Map<String,Object> midUserSynchronize();
	Map<String, Object> midUserSynchronizeCount();
	Map<String, Object> synchronizeUsers(List<DtUser> list);
}
