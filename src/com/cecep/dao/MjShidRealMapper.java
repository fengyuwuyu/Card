package com.cecep.dao;

import java.util.List;

import com.cecep.model.MjShidReal;

public interface MjShidRealMapper {
	
    int deleteByPrimaryKey(Integer bh);
    int insert(MjShidReal record);
    int insertSelective(MjShidReal record);
    MjShidReal selectByPrimaryKey(Integer bh);
    int updateByPrimaryKeySelective(MjShidReal record);
    int updateByPrimaryKey(MjShidReal record);
    
    //分页查询
    List<MjShidReal> selectByPage(MjShidReal record);
    Integer selectCount(MjShidReal record);
    
}