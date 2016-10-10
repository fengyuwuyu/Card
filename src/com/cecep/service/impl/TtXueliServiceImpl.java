package com.cecep.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.TtXueliMapper;
import com.cecep.model.TtXueli;
import com.cecep.service.TtXueliServiceI;
@Service("ttXueliService")
public class TtXueliServiceImpl implements TtXueliServiceI {
	
	private TtXueliMapper ttXueliMapper;	
	
	@Autowired
	public void setTtXueliMapper(TtXueliMapper ttXueliMapper) {
		this.ttXueliMapper = ttXueliMapper;
	}

	public List<Map<String, Object>> load(TtXueli record) {
		List<Map<String,Object>> list = this.ttXueliMapper.load(record);
		return list;
	}

}
