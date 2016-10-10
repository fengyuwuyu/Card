package com.cecep.service;

import java.util.List;



import java.util.Map;

import com.cecep.model.SysRole;
import com.cecep.model.TreeNode;

public interface SysRoleServiceI {
		
	Map<String,Object> dataList(SysRole record);	
	Map<String,Object> getById(SysRole record);
	Map<String,Object> save(SysRole record,Integer[] menuIds);
	Map<String,Object> delete(SysRole record);
	List<Map<String,Object>> load(SysRole record);
    List<TreeNode> getMenuTree(Integer parentId);
}
