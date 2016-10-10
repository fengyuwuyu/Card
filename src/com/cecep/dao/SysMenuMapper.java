package com.cecep.dao;

import java.util.List;

import com.cecep.model.SysMenu;

public interface SysMenuMapper {
		
    int deleteByPrimaryKey(Integer menuId);
    int insert(SysMenu record);
    int insertSelective(SysMenu record);
    SysMenu selectByPrimaryKey(Integer menuId);
    int updateByPrimaryKeySelective(SysMenu record);
    int updateByPrimaryKey(SysMenu record);
    
    //分页查询
    List<SysMenu> selectByPage(SysMenu record);
    Integer selectCount(SysMenu record);
    
}