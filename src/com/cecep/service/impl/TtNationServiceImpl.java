package com.cecep.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.TtNationMapper;
import com.cecep.model.TtNation;
import com.cecep.service.TtNationServiceI;

@Service("ttNationService")
public class TtNationServiceImpl implements TtNationServiceI {
	
	private TtNationMapper ttNationMapper;	
	
	@Autowired
	public void setTtNationMapper(TtNationMapper ttNationMapper) {
		this.ttNationMapper = ttNationMapper;
	}

	public List<Map<String, Object>> load(TtNation record) {
		List<Map<String,Object>> list = this.ttNationMapper.load(record);
		return list;
	}
	

}
