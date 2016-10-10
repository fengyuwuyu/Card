package com.cecep.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.XfTimeMapper;
import com.cecep.model.XfTime;
import com.cecep.service.XfTimeServiceI;
import com.cecep.util.MapUtils;

@Service("xfTimeService")
public class XfTimeServiceImpl implements XfTimeServiceI {
	
	private XfTimeMapper xfTimeMapper;	
	
	@Autowired
	public void setXfTimeMapper(XfTimeMapper xfTimeMapper) {
		this.xfTimeMapper = xfTimeMapper;
	}

	public Map<String, Object> dataList(XfTime record) {
		List<XfTime> list = this.xfTimeMapper.selectByPageI(record);
		Integer total = this.xfTimeMapper.selectCount(record);
		return MapUtils.createSuccessMap("rows", list,"total", total);
	}

	public Map<String, Object> getById(XfTime record) {
		XfTime time= this.xfTimeMapper.getById(record.getBh());
		return MapUtils.createSuccessMap("data", time);
	}

	public List<Map<String, Object>> load(XfTime record) {
		List<Map<String, Object>> list = this.xfTimeMapper.load(record);
		return list;
	}

	public Map<String, Object> selectByPage(XfTime record) {
		List<XfTime> list = this.xfTimeMapper.selectByPageI(record);
		int total = this.xfTimeMapper.selectCount(record);
		return MapUtils.createSuccessMap("rows", list,"total", total);
	}

	public Map<String, Object> save(XfTime record) {
		if(record.getBh()!=null&&!"".equals(record.getBh())){
			this.xfTimeMapper.update(record);
		}else{
			record.setSj(new Date());
			String maxBh = this.xfTimeMapper.getMaxBh();
			Long bh = Long.valueOf(maxBh);
			bh++;
			record.setBh(bh.toString());
			this.xfTimeMapper.insert(record);
		}
		return MapUtils.createSuccessMap();
	}

	public Map<String, Object> getExternalXfTimes(Integer depSerial) {
		this.xfTimeMapper.deleteByDepSerial(depSerial);
		List<XfTime> list = this.xfTimeMapper.getExternalXfTimes();
		return MapUtils.createSuccessMap("data", list);
	}

	public Map<String, Object> saveDevTime(String[] addTimes,
			Integer depSerial, String username) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("depSerial", depSerial);
		param.put("username", username);
		for(String bh : addTimes){
			Date time = new Date();
			param.put("time", time);
			param.put("bh", bh);
			this.xfTimeMapper.saveDevTime(param);
		}
		return MapUtils.createSuccessMap("msg", "就餐时间绑定成功！");
	}

	public Map<String, Object> remove(String bh) {
		int num = this.xfTimeMapper.getAcTypeCountByBh(bh);
		if(num!=0){
			return MapUtils.createFailedMap("msg", "该餐类已与账户类型绑定，请先在卡参数管理中的账户时段功能中删除关联关系!");
		}
		int num1 = this.xfTimeMapper.getRegionCountByBh(bh);
		if(num1!=0){
			return MapUtils.createFailedMap("msg", "该餐类已与区域绑定，请先在绑定就餐时间功能中删除关联关系!");
		}
		this.xfTimeMapper.deleteByPrimaryKey(bh);
		return MapUtils.createSuccessMap();
	}
}
