package com.cecep.service.impl;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.TtLizhiMapper;
import com.cecep.model.TtLizhi;
import com.cecep.service.TtLizhiServiceI;

@Service("ttLizhiService")
public class TtLizhiServiceImpl implements TtLizhiServiceI {
	
	private TtLizhiMapper ttLizhiMapper;

	@Autowired
	public void setTtLizhiMapper(TtLizhiMapper ttLizhiMapper) {
		this.ttLizhiMapper = ttLizhiMapper;
	}

	public List<Map<String, Object>> load(TtLizhi record) {
		List<Map<String,Object>> list = this.ttLizhiMapper.load(record);
		return list;
	}
	
	
	

}
