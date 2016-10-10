package com.cecep.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cecep.dao.StDeviceMapper;
import com.cecep.model.StDevice;
import com.cecep.service.StDeviceServiceI;
import com.cecep.util.MapUtils;
@Service("stDeviceService")
public class StDeviceServiceImpl implements StDeviceServiceI {
	
	private StDeviceMapper stDeviceMapper;
	
	@Autowired
	public void setStDeviceMapper(StDeviceMapper stDeviceMapper) {
		this.stDeviceMapper = stDeviceMapper;
	}
	
	@RequestMapping("dataList")
	@ResponseBody
	public Map<String,Object> dataList(StDevice query){
		List<StDevice> list = this.stDeviceMapper.getByPage(query);
		int total = this.stDeviceMapper.getTotal(query);
		return MapUtils.createSuccessMap("rows",list,"total",total);
	}
	
}
