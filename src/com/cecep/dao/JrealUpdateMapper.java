package com.cecep.dao;

import java.util.List;
import java.util.Map;

import com.cecep.model.JrealUpdate;

public interface JrealUpdateMapper {
	
    int deleteByPrimaryKey(Integer[] xha);
    int insert(JrealUpdate record);
    int insertSelective(JrealUpdate record);
    JrealUpdate selectByPrimaryKey(Integer jsig);
    int updateByPrimaryKeySelective(JrealUpdate record);
    int updateByPrimaryKey(JrealUpdate record);
    
    //根据员工查询
    List<JrealUpdate> selectByUser(Long[] depSeriala);
    //根据部门查询
    List<JrealUpdate> selectByDep(Long[] depSeriala);
    //根据门查询
    List<JrealUpdate> selectByDoor(String[] doorSeriala);
    //根据场所查询
    List<JrealUpdate> selectBySite(Integer[] siteSeriala);
    //根据卡号、设备(编号)删除授权记录
    int deleteByMap(Map<String,Object> map);
    //根据卡号、设备(编号)、门方向添加授权记录
    int insertByMap(Map<String,Object> map);
}