package com.cecep.dao;

import java.util.List;
import java.util.Map;


import com.cecep.model.MjUserRuleReal;

public interface MjUserRuleRealMapper {
	
    int deleteByPrimaryKey(Integer[] xha);
    int insert(MjUserRuleReal record);
    int insertSelective(MjUserRuleReal record);
    MjUserRuleReal selectByPrimaryKey(Integer xh);
    int updateByPrimaryKeySelective(MjUserRuleReal record);
    int updateByPrimaryKey(MjUserRuleReal record);
    
    //分页查询
    List<MjUserRuleReal> selectByPage(MjUserRuleReal record);
    Integer selectCount(MjUserRuleReal record);
    //根据部门查询
    List<MjUserRuleReal> selectByDep(Long[] depSeriala);
    //根据门查询
    List<MjUserRuleReal> selectByDoor(String[] doorSeriala);
    //根据场所查询
    List<MjUserRuleReal> selectBySite(Integer[] siteSeriala);
    //根据人员、门(编号)删除授权记录
    int deleteByMap(Map<String,Object> map);
    //根据人员、门(编号)、门方向添加授权记录
    int insertByMap(Map<String,Object> map);
    
}