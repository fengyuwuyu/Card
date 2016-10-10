package com.cecep.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.XfAcTimeMapper;
import com.cecep.model.XfAcTime;
import com.cecep.service.XfAcTimeServiceI;
@Service("xfAcTimeService")
public class XfAcTimeServiceImpl implements XfAcTimeServiceI {
	
	private XfAcTimeMapper xfAcTimeMapper;

	@Autowired
	public void setXfAcTimeMapper(XfAcTimeMapper xfAcTimeMapper) {
		this.xfAcTimeMapper = xfAcTimeMapper;
	}

	public Map<String, Object> dataList(XfAcTime record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<XfAcTime> list = this.xfAcTimeMapper.selectByPage(record);
		Integer count = this.xfAcTimeMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}

	public Map<String, Object> getById(XfAcTime record) {
		Map<String, Object> map = new HashMap<String, Object>();
		XfAcTime time= this.xfAcTimeMapper.selectByPrimaryKey(record.getXh());
		map.put("data", time);	
		map.put("success", true);
		return map;
	}

	public Map<String, Object> save(XfAcTime record) {
		Map<String, Object> map = new HashMap<String, Object>();
		//时段限额
		record.setTimeMaxM(record.getTimeMaxM() * 100);
		if(record.getXh() == null) {
			Integer count = this.xfAcTimeMapper.selectCount(record);
			if(count == 0) {	
				this.xfAcTimeMapper.insert(record);
				map.put("success", true);	
			}else {
				map.put("msg", "此账户时段已经存在，无法重复添加！");	
				map.put("success", false);					
			}			
		}else{			
			this.xfAcTimeMapper.updateByPrimaryKeySelective(record);
			map.put("success", true);	
		}		
		return map;
	}

	public Map<String, Object> delete(XfAcTime record) {
		Map<String, Object> map = new HashMap<String, Object>();
		this.xfAcTimeMapper.deleteByPrimaryKey(record.getXh());
		map.put("success", true);	
		return map;
	}

}
