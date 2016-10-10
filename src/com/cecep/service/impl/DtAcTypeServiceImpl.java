package com.cecep.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.DtAcTypeMapper;
import com.cecep.model.DtAcType;
import com.cecep.service.DtAcTypeServiceI;

@Service("dtAcTypeService")
public class DtAcTypeServiceImpl implements DtAcTypeServiceI {
	
	private DtAcTypeMapper dtAcTypeMapper;

	@Autowired
	public void setDtAcTypeMapper(DtAcTypeMapper dtAcTypeMapper) {
		this.dtAcTypeMapper = dtAcTypeMapper;
	}

	public Map<String, Object> dataList(DtAcType record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DtAcType> list = this.dtAcTypeMapper.selectByPage(record);
		Integer count = this.dtAcTypeMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}

	

	public Map<String, Object> getById(DtAcType record) {
		Map<String, Object> map = new HashMap<String, Object>();
		DtAcType type= this.dtAcTypeMapper.selectByPrimaryKey(record.getAcBh());
		map.put("data", type);	
		map.put("success", true);
		return map;
	}

	public Map<String, Object> save(DtAcType record) {
		Map<String, Object> map = new HashMap<String, Object>();		
		BigDecimal bc =new BigDecimal(100);
		//当日限额
		record.setDayMaxM(record.getDayMaxM().multiply(bc));
		//单次限额
		record.setTimeMaxM(record.getTimeMaxM().multiply(bc));
		//记账限额
		record.setTallyMaxM(record.getTallyMaxM() * 100);
		if(record.getAcBh() == null || record.getAcBh().equals("")){
			Date currentTime = Calendar.getInstance().getTime();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			Random rand = new Random();		
			//账户类型编号
			record.setAcBh(sdf.format(currentTime) + rand.nextInt(100));		
			this.dtAcTypeMapper.insert(record);
		}else{			
			this.dtAcTypeMapper.updateByPrimaryKeySelective(record);
		}			
		map.put("success", true);
		return map;
	}

	public Map<String, Object> delete(DtAcType record) {
		Map<String, Object> map = new HashMap<String, Object>();
		String acBh = record.getAcBh();
		if("0000000000000001".equals(acBh) || "0000000000000002".equals(acBh)) {
			map.put("msg", "此账户类型为系统固有账户类型，不能删除！");
			map.put("success", false);			
		}else {
			Integer count = this.dtAcTypeMapper.selectDtAcUser(acBh);
			if(count == 0) {
				this.dtAcTypeMapper.deleteByPrimaryKey(acBh);
				this.dtAcTypeMapper.deleteXfAcTime(acBh);
				map.put("success", true);
			}else {
				map.put("msg", "当前账户类型正在被使用，不能删除！");
				map.put("success", false);				
			}		
		}
		return map;
	}

	public List<Map<String, Object>> load(DtAcType record) {
		List<Map<String, Object>> list = this.dtAcTypeMapper.load(record);
		return list;
	}




}
