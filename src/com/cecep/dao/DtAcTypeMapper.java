package com.cecep.dao;

import java.util.List;

import java.util.Map;


import com.cecep.model.DtAcType;

public interface DtAcTypeMapper {
	
    int deleteByPrimaryKey(String acBh);
    int insert(DtAcType record);
    int insertSelective(DtAcType record);
    DtAcType selectByPrimaryKey(String acBh);
    int updateByPrimaryKeySelective(DtAcType record);
    int updateByPrimaryKey(DtAcType record);
    
    //分页查询
    List<DtAcType> selectByPage(DtAcType record);
    Integer selectCount(DtAcType record);
    //下拉查询
    List<Map<String,Object>> load(DtAcType record);
    //查询人员账户
    Integer selectDtAcUser(String acBh);
    //删除账户时段
    int deleteXfAcTime(String acBh);
}