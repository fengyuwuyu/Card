package com.cecep.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.StDoorRealMapper;
import com.cecep.model.DtUser;
import com.cecep.model.StDoorReal;
import com.cecep.service.StDoorRealServiceI;
import com.cecep.util.KqStatisticsUtil;
import com.cecep.util.MapUtils;

@Service("stDoorRealService")
public class StDoorRealServiceImpl implements StDoorRealServiceI {
	
	private StDoorRealMapper stDoorRealMapper;
	
	@Autowired
	public void setStDoorRealMapper(StDoorRealMapper stDoorRealMapper) {
		this.stDoorRealMapper = stDoorRealMapper;
	}

	public Map<String, Object> dataList(StDoorReal record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StDoorReal> list = this.stDoorRealMapper.selectByPage(record);
		Integer count = this.stDoorRealMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}

	public List<Map<String,Object>> selectStDoor() {
		return this.stDoorRealMapper.selectStDoor();
	}

	public Map<String, Object> save(DtUser currUser, StDoorReal record) {
		String msg = "";
		if(record.getBh()==null||"".equals(record.getBh())){
			msg = "添加成功！";
			Date date = new Date();
			record.setSj(date);
			record.setBh(KqStatisticsUtil.formatDateToString6(date));
			record.setOperateLog("新增门,门名称是【"+record.getDoorName()+"】");
			record.setOperator(currUser.getUserLname());
			this.stDoorRealMapper.insert(record);
			this.stDoorRealMapper.insertDtGateReal(record);
			record.setLx(0);
			this.stDoorRealMapper.insertWtMjLogReal(record);
			if(record.getDevSerial()!=null){
				record.setDevHead("1");
				record.setDevHead2("0");
				record.setFx(0);
				this.stDoorRealMapper.insertStDoorFxReal(record);
				this.stDoorRealMapper.insertWtMjVer(record);
				record.setDevHead("0");
				record.setDevHead2("2");
				record.setFx(1);
				this.stDoorRealMapper.insertStDoorFxReal(record);
				this.stDoorRealMapper.insertWtMjVer(record);
				this.stDoorRealMapper.insertWtMjVer1(record);
			}
		}else{
			msg = "修改成功！";
			Date date = new Date();
			record.setSj(date);
			this.stDoorRealMapper.updateByPrimaryKeySelective(record);
			record.setOperateLog("修改门,门名称是【"+record.getDoorName()+"】");
			this.stDoorRealMapper.deleteStDoorFxReal(record);
			record.setDevHead("1");
			record.setDevHead2("0");
			record.setFx(0);
			this.stDoorRealMapper.insertStDoorFxReal(record);
			this.stDoorRealMapper.insertWtMjVer(record);
			record.setDevHead("0");
			record.setDevHead2("2");
			record.setFx(1);
			this.stDoorRealMapper.insertWtMjVer(record);
			this.stDoorRealMapper.insertStDoorFxReal(record);
			this.stDoorRealMapper.insertWtMjVer1(record);
			this.stDoorRealMapper.insertJrealNowcmd();
			this.stDoorRealMapper.insertJrealUpdate0(record);
			this.stDoorRealMapper.insertJrealUpdate0(record);
			record.setLx(1);
			this.stDoorRealMapper.insertWtMjLogReal(record);
			
		}
		return MapUtils.createSuccessMap("msg",msg);
	}

	public Map<String, Object> getById(StDoorReal record) {
		StDoorReal doorReal = this.stDoorRealMapper.selectByPrimaryKey(record.getBh());
		return MapUtils.createSuccessMap("data",doorReal);
	}

	public Map<String, Object> delete(StDoorReal query) {
		this.stDoorRealMapper.callDelete(query);
		return MapUtils.createSuccessMap("msg","删除成功！");
	}


}
