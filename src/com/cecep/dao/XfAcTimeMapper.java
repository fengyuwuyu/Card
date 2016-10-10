package com.cecep.dao;

import java.util.List;

import com.cecep.model.XfAcTime;

public interface XfAcTimeMapper {
	
    int deleteByPrimaryKey(Integer xh);
    int insert(XfAcTime record);
    int insertSelective(XfAcTime record);
    XfAcTime selectByPrimaryKey(Integer xh);
    int updateByPrimaryKeySelective(XfAcTime record);
    int updateByPrimaryKey(XfAcTime record);
    
    //分页查询
    List<XfAcTime> selectByPage(XfAcTime record);
    Integer selectCount(XfAcTime record);
    
}