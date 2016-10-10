package com.cecep.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.HaircutTermsMapper;
import com.cecep.model.HaircutTerms;
import com.cecep.service.HaircutTermsServiceI;
@Service("haircutTermsService")
public class HaircutTermsServiceImpl implements HaircutTermsServiceI {
	
	HaircutTermsMapper  haircutTermsMapper;

	@Autowired
	public void setHaircutTermsMapper(HaircutTermsMapper haircutTermsMapper) {
		this.haircutTermsMapper = haircutTermsMapper;
	}
	
	public Map<String, Object> dataList(HaircutTerms record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HaircutTerms> list = this.haircutTermsMapper.selectByPage(record);
		Integer count = this.haircutTermsMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}

	
	
	public Map<String, Object> save(HaircutTerms record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer termsId=record.getTermsId();
		Integer count = this.haircutTermsMapper.selectCount1(record);
		if(count>0){
			map.put("success", false);
			map.put("msg", "用品量词已经存在!");
			return map;
		}
		if(termsId==null){
			this.haircutTermsMapper.insert(record);
		}else{
			this.haircutTermsMapper.updateByPrimaryKey(record);	
		}
		map.put("success", true);
		return map;
	}


	
	public Map<String, Object> getById(HaircutTerms record) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		HaircutTerms termsId = this.haircutTermsMapper.selectByPrimaryKey(record.getTermsId());
		resultMap.put("data", termsId);	
		resultMap.put("success", true);
		return resultMap;
	}


	
	public Map<String, Object> delete(HaircutTerms record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer termsId=record.getTermsId();
		this.haircutTermsMapper.deleteByPrimaryKey(termsId);
		map.put("success", true);
		return map;
	}

}
