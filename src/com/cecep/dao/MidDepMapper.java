package com.cecep.dao;

import java.util.List;


import java.util.Map;





















import com.cecep.model.CecepDep;
import com.cecep.model.DtDep;
import com.cecep.model.MidDep;

public interface MidDepMapper {
	
    int insert(MidDep record);
    int insertSelective(MidDep record);
    Integer selectByPrimaryKey(String iuCode);
    int updateByPrimaryKey(MidDep record);
    
    //下拉查询
    List<Map<String,Object>> load(String id);
    //查询需要同步数据条数
    Integer selectIsSynchronized();
    //同步数据
    List<DtDep> synchronize(Map<String,Object> map);
    //修改同步状态
    int updateIsSynchronized(Map<String, Object> map);
	List<String> selectCecepDep(String parentId);
	/** 更新中间表cecep_dep中已同步过的数据*/
	void updateHasSynchronized(Map<String,Object> map);
	Integer selectIsSynchronizedFirst();
	//初始化cecep_dep表
	List<String> selectBenBu();
	List<CecepDep> selectByIds(Map<String,Object> ids);
	void insertCecep(CecepDep cecepDep);
	List<CecepDep> selectByParentId(String parentId);
	String[] getAcdepSerialByParentId(String parentId);
	String[] getAcdepSerialByDepNo(String depNo);
	String getAcdepSerialByDepNo1(String parentId);
    int selectById(String depSerial);
	String selectParentId(String depSerial);
	void insertById(Map<String, Object> map);
	Integer selectById1(String parentId);
	int selectEmployeeCount(String depName);
	DtDep selectByIuCode(Map<String, Object> map);
	List<DtDep> selectByIuLssjdwId(Map<String, Object> map);
}