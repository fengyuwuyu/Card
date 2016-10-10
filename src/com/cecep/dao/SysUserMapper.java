package com.cecep.dao;

import java.util.List;



import com.cecep.model.SysMenu;
import com.cecep.model.SysUser;

public interface SysUserMapper {

	int deleteByPrimaryKey(Integer userId);
    int insert(SysUser record);
    int insertSelective(SysUser record);
    SysUser selectByPrimaryKey(Integer userId);
    int updateByPrimaryKeySelective(SysUser record);
    int updateByPrimaryKey(SysUser record);
    
    //分页查询
    List<SysUser> selectByPage(SysUser record);
    Integer selectCount(SysUser record);
    //登录查询
    SysUser selectSelective(SysUser record);
    //查询菜单树
    List<SysMenu> getMenuTree(Integer roleId);
}
