package com.cecep.service.impl;

import java.util.HashMap;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.MjShidRealMapper;
import com.cecep.model.MjShidReal;
import com.cecep.service.MjShidRealServiceI;
@Service("MjShidRealService")
public class MjShidRealServiceImpl implements MjShidRealServiceI {
	
	private MjShidRealMapper mjShidRealMapper;	
	
	@Autowired
	public void setMjShidRealMapper(MjShidRealMapper mjShidRealMapper) {
		this.mjShidRealMapper = mjShidRealMapper;
	}

	public Map<String, Object> dataList(MjShidReal record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MjShidReal> list = this.mjShidRealMapper.selectByPage(record);
		Integer count = this.mjShidRealMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}

	


}
