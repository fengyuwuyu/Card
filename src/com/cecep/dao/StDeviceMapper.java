package com.cecep.dao;

import java.util.List;

import com.cecep.model.StDevice;

public interface StDeviceMapper {
	
    int deleteByPrimaryKey(String bh);
    int insert(StDevice record);
    int insertSelective(StDevice record);
    StDevice selectByPrimaryKey(String bh);
    int updateByPrimaryKeySelective(StDevice record);
    int updateByPrimaryKey(StDevice record);
	List<StDevice> getByPage(StDevice query);
	int getTotal(StDevice query);
    
}