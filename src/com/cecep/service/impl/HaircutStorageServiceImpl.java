package com.cecep.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.HaircutStorageMapper;
import com.cecep.model.HaircutStorage;
import com.cecep.service.HaircutStorageServiceI;


@Service("haircutStorageService")
public class HaircutStorageServiceImpl implements HaircutStorageServiceI {
	HaircutStorageMapper  haircutStorageMapper;
	
	@Autowired
	public void setHaircutStorageMapper(HaircutStorageMapper haircutStorageMapper) {
		this.haircutStorageMapper = haircutStorageMapper;
	}


	
	public Map<String, Object> dataList(HaircutStorage record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HaircutStorage> list = this.haircutStorageMapper.selectByPage(record);
		Integer count = this.haircutStorageMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}

}
