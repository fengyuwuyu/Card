package com.cecep.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.HaircutPriceMapper;
import com.cecep.model.HaircutPrice;
import com.cecep.service.HaircutPriceServiceI;

@Service("haircutpriceService")
public class haircutPriceServiceImpl implements HaircutPriceServiceI {
	
	HaircutPriceMapper  haircutPriceMapper;


	@Autowired
	public void setHaircutPriceMapper(HaircutPriceMapper haircutPriceMapper) {
		this.haircutPriceMapper = haircutPriceMapper;
	}


	
	public Map<String, Object> dataList(HaircutPrice record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HaircutPrice> list = this.haircutPriceMapper.selectByPage(record);
		Integer count = this.haircutPriceMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}

	
	
	public Map<String, Object> save(HaircutPrice record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer haircutId=record.getHaircutId();
		if(haircutId==null){
			this.haircutPriceMapper.insert(record);
		}else{
			this.haircutPriceMapper.updateByPrimaryKey(record);	
		}
		map.put("success", true);
		return map;
	}


	
	public Map<String, Object> getById(HaircutPrice record) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		HaircutPrice haircutId = this.haircutPriceMapper.selectByPrimaryKey(record.getHaircutId());
		resultMap.put("data", haircutId);	
		resultMap.put("success", true);
		return resultMap;
	}


	
	public Map<String, Object> delete(HaircutPrice record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer haircutId=record.getHaircutId();
		this.haircutPriceMapper.deleteByPrimaryKey(haircutId);
		map.put("success", true);
		return map;
	}

}
