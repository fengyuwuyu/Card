package com.cecep.dao;

import java.util.List;
import java.util.Map;

import com.cecep.model.XfTime;

public interface XfTimeMapper {
	
    int deleteByPrimaryKey(String bh);
    int insert(XfTime record);
    int insertSelective(XfTime record);
    XfTime selectByPrimaryKey(String bh);
    int updateByPrimaryKeySelective(XfTime record);
    int updateByPrimaryKey(XfTime record);
    int update(XfTime record);
    
    //分页查询
    List<XfTime> selectByPage(XfTime record);
    List<XfTime> selectByPageI(XfTime record);
    Integer selectCount(XfTime record);
    //下拉查询
    List<Map<String,Object>> load(XfTime record);
	void save(XfTime record);
	XfTime getById(String bh);
	List<XfTime> getExternalXfTimes();
//	List<String> queryByDepSerial(Integer depSerial);
	void saveDevTime(Map<String, Object> param);
	void deleteByDepSerial(Integer depSerial);
	String getMaxBh();
	/** 根据编号查询该餐类与账户类型绑定的数量*/
	int getAcTypeCountByBh(String bh);
	/** 根据编号查询该餐类与区域绑定的数量*/
	int getRegionCountByBh(String bh);
}