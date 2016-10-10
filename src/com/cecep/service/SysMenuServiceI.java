package com.cecep.service;

import java.util.Map;

import com.cecep.model.SysMenu;

public interface SysMenuServiceI {
	
	Map<String,Object> dataList(SysMenu record);	
	Map<String,Object> getById(SysMenu record);
	Map<String,Object> save(SysMenu record);
	Map<String,Object> delete(SysMenu record);

}
