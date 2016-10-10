package com.cecep.service;

import java.util.List;
import java.util.Map;

import com.cecep.model.SysMenu;
import com.cecep.model.SysUser;



public interface SysUserServiceI{    
    
	Map<String,Object> dataList(SysUser record);	
	Map<String,Object> getById(SysUser record);
	Map<String,Object> save(SysUser record);
	Map<String,Object> delete(SysUser record);
	Map<String,Object> editPwd(SysUser record);
	SysUser login(SysUser record);
	List<SysMenu> getMenuTree(Integer roleId);
}
