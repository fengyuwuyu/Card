package com.cecep.dao;

import java.util.List;


import com.cecep.model.VisitorRecord;

public interface VisitorRecordMapper {
	
    int deleteByPrimaryKey(Long recordId);
    int insert(VisitorRecord record);
    int insertSelective(VisitorRecord record);
    VisitorRecord selectByPrimaryKey(Long recordId);
    int updateByPrimaryKeySelective(VisitorRecord record);
    int updateByPrimaryKey(VisitorRecord record);
    
    //分页查询
    List<VisitorRecord> selectByPage(VisitorRecord record);
    Integer selectCount(VisitorRecord record);
    //导出查询
    List<VisitorRecord> export(VisitorRecord record);
    
}