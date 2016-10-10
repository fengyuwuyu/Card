package com.cecep.service;

import java.util.List;
import java.util.Map;

import com.cecep.model.MidDep;

public interface MidDepServiceI {
	
	void save(MidDep record);
	List<Map<String,Object>> load(String id);
	Map<String,Object> selectIsSynchronized(MidDep record);
	Map<String,Object> synchronize(String[] depNos);
	Map<String, Object> midDepCount();
	List<Map<String, Object>> acDepLoad();
	Map<String, Object> saveAcdepAndDep(String[] ids,String depSerial);
	Map<String, Object> selectAcdepAndDep(String depSerial);
	public Map<String, Object> synchronizeFirst(String parentId);
	//初始化数据使用
	void insertInitData();
	Map<String, Object> saveAcdepAndDep1(String[] ids, String depSerial);
	Map<String, Object> syncMidDep(Long depSerial, String iuCode, Boolean all);
	/** 与ESB同步部门时更新部门排序*/
	void updateDepOrder(String[] arr2);
	void updateUserOrder(String[] arr2);
	void test();
	void updateMidUserOrder(String[] arr2);
	void updateMidDepOrder(String[] arr2);
}
