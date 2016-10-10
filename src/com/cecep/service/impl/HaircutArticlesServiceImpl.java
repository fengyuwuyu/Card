package com.cecep.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.HaircutArticlesMapper;
import com.cecep.model.HaircutArticles;
import com.cecep.service.HaircutArticlesServiceI;
@Service("haircutArticlesService")
public class HaircutArticlesServiceImpl  implements HaircutArticlesServiceI {
	
	HaircutArticlesMapper  haircutArticlesMapper;

	@Autowired
	public void setHaircutArticlesMapper(HaircutArticlesMapper haircutArticlesMapper) {
		this.haircutArticlesMapper = haircutArticlesMapper;
	}
	
	public Map<String, Object> dataList(HaircutArticles record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HaircutArticles> list = this.haircutArticlesMapper.selectByPage(record);
		Integer count = this.haircutArticlesMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}

	
	
	public Map<String, Object> save(HaircutArticles record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer articlesId=record.getArticlesId();
		Integer count = this.haircutArticlesMapper.selectCount1(record);
		
		if(articlesId==null){
			this.haircutArticlesMapper.insert(record);
		}else{
			this.haircutArticlesMapper.updateByPrimaryKey(record);	
		}
		map.put("success", true);
		return map;
	}


	
	public Map<String, Object> getById(HaircutArticles record) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		HaircutArticles articlesId = this.haircutArticlesMapper.selectByPrimaryKey(record.getArticlesId());
		resultMap.put("data", articlesId);	
		resultMap.put("success", true);
		return resultMap;
	}


	
	public Map<String, Object> delete(HaircutArticles record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer articlesId=record.getArticlesId();
		this.haircutArticlesMapper.deleteByPrimaryKey(articlesId);
		map.put("success", true);
		return map;
	}
	
}
