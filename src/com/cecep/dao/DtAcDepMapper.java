package com.cecep.dao;

import java.util.List;
import java.util.Map;

import com.cecep.model.DtAcDep;

public interface DtAcDepMapper {
	
    int deleteByPrimaryKey(Integer depSerial);
    int insert(DtAcDep record);
    int insertSelective(DtAcDep record);
    DtAcDep selectByPrimaryKey(Integer depSerial);
    int updateByPrimaryKeySelective(DtAcDep record);
    int updateByPrimaryKey(DtAcDep record);
    
    //分页查询
    List<DtAcDep> selectByPage(DtAcDep record);
    Integer selectCount(DtAcDep record);
    //下拉查询
    List<Map<String,Object>> load(Integer depParent);
    
    List<Map<String,Object>> selectAcDepByDoor();
	void insertDtDev(Map<String,Object> map);
	String[] selectAcDepSerials(String depSerial);
	void deleteAcdepAndDep(String depSerial);
	void deleteAcdepAndDep1(Map<String, Object> createMap);
    
}