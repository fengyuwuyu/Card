package com.cecep.dao;

import java.util.List;


import java.util.Map;

import com.cecep.model.SysRole;
import com.cecep.model.TreeNode;

public interface SysRoleMapper {

	int deleteByPrimaryKey(Integer roleId);
    int insert(SysRole record);
    int insertSelective(SysRole record);
    SysRole selectByPrimaryKey(Integer roleId);
    int updateByPrimaryKeySelective(SysRole record);
    int updateByPrimaryKey(SysRole record);
    
    //分页查询
    List<SysRole> selectByPage(SysRole record);
    Integer selectCount(SysRole record);
    //下拉查询
    List<Map<String,Object>> load(SysRole record);
    //菜单树查询
    List<TreeNode> getMenuTree(Integer parentId);
    //删除菜单角色中间表记录
    int deleteForMenuRole(Integer roleId);
    //插入菜单角色中间表记录
    int insertForMenuRole(Map<String,Object> map);
}
