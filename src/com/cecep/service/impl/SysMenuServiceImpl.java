package com.cecep.service.impl;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.SysMenuMapper;
import com.cecep.model.SysMenu;
import com.cecep.service.SysMenuServiceI;

@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuServiceI {
	
	private SysMenuMapper sysMenuMapper;
	
	@Autowired
	public void setSysMenuMapper(SysMenuMapper sysMenuMapper) {
		this.sysMenuMapper = sysMenuMapper;
	}

	public Map<String, Object> dataList(SysMenu record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SysMenu> list = this.sysMenuMapper.selectByPage(record);
		Integer count = this.sysMenuMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}

	

	public Map<String, Object> delete(SysMenu record) {
		Map<String, Object> map = new HashMap<String, Object>();
		//状态
		record.setMenuDeleted(1);
		this.sysMenuMapper.updateByPrimaryKeySelective(record);			
		map.put("success", true);
		return map;
	}


	public Map<String, Object> getById(SysMenu record) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		SysMenu menu = this.sysMenuMapper.selectByPrimaryKey(record.getMenuId());
		resultMap.put("data", menu);	
		resultMap.put("success", true);
		return resultMap;
	}

	public Map<String, Object> save(SysMenu record) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(record.getMenuId() == null){
			this.sysMenuMapper.insert(record);		
		}else{
			this.sysMenuMapper.updateByPrimaryKey(record);		
		}			
		map.put("success", true);
		return map;
	}

	

	
}
