package com.cecep.dao;

import java.util.List;




import java.util.Map;

import com.cecep.model.StDoorReal;

public interface StDoorRealMapper {
	
    int deleteByPrimaryKey(Integer xh);
    int insert(StDoorReal record);
    int insertSelective(StDoorReal record);
    StDoorReal selectByPrimaryKey(String bh);
    int updateByPrimaryKeySelective(StDoorReal record);
    int updateByPrimaryKey(StDoorReal record);
    
    //分页查询
    List<StDoorReal> selectByPage(StDoorReal record);
    Integer selectCount(StDoorReal record);
	List<Map<String,Object>> selectStDoor();
	void insertStDoorFxReal(StDoorReal record);
	void insertWtMjVer(StDoorReal record);
	void insertWtMjVer1(StDoorReal record);
	void insertDtGateReal(StDoorReal record);
	void insertWtMjLogReal(StDoorReal record);
	void callDelete(StDoorReal query);
	void deleteStDoorFxReal(StDoorReal record);
	void insertJrealNowcmd();
	void insertJrealUpdate0(StDoorReal record);
    
}