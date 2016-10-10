package com.cecep.service.impl;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.DtAcDepMapper;
import com.cecep.model.DtAcDep;
import com.cecep.service.DtAcDepServiceI;
@Service("dtAcDepService")
public class DtAcDepServiceImpl implements DtAcDepServiceI {
	
	private DtAcDepMapper dtAcDepMapper;
	
	@Autowired
	public void setDtAcDepMapper(DtAcDepMapper dtAcDepMapper) {
		this.dtAcDepMapper = dtAcDepMapper;
	}
	
	public Object dataList(DtAcDep record) {
		if(record.getDepParent() == null) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<DtAcDep> list = this.dtAcDepMapper.selectByPage(record);
			Integer count = this.dtAcDepMapper.selectCount(record);
			map.put("rows", list);
			map.put("total",count);
			return map;
		}else {
			List<DtAcDep> list = this.dtAcDepMapper.selectByPage(record);
			return list;
		}
	}	

	public List<Map<String, Object>> load(Integer depParent) {
		List<Map<String, Object>> list = this.dtAcDepMapper.load(depParent);
		return list;
	}

}
