package com.cecep.service.impl;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.JrealUpdateMapper;
import com.cecep.dao.MjUserRuleRealMapper;
import com.cecep.model.JrealUpdate;
import com.cecep.model.MjUserRuleReal;
import com.cecep.service.MjUserRuleRealServiceI;

@Service("mjUserRuleRealService")
public class MjUserRuleRealServiceImpl implements MjUserRuleRealServiceI {
	
	private MjUserRuleRealMapper mjUserRuleRealMapper;	
	private JrealUpdateMapper jrealUpdateMapper;

	@Autowired
	public void setMjUserRuleRealMapper(MjUserRuleRealMapper mjUserRuleRealMapper) {
		this.mjUserRuleRealMapper = mjUserRuleRealMapper;
	}

	@Autowired
	public void setJrealUpdateMapper(JrealUpdateMapper jrealUpdateMapper) {
		this.jrealUpdateMapper = jrealUpdateMapper;
	}


	public MjUserRuleRealMapper getMjUserRuleRealMapper() {
		return mjUserRuleRealMapper;
	}


	public Map<String, Object> dataList(MjUserRuleReal record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MjUserRuleReal> list = this.mjUserRuleRealMapper.selectByPage(record);
		Integer count = this.mjUserRuleRealMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}

	public Map<String, Object> save(String userSerials, String depSerials,String doorSerials, String siteSerials, String ruleNo,String ruleNo2,String glyNo) {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		List<MjUserRuleReal> list = new ArrayList<MjUserRuleReal>();
		List<JrealUpdate> list3 = new ArrayList<JrealUpdate>();
		if(userSerials != null && !userSerials.equals("")) {
			String[] userSeriala = userSerials.split(",");
			Long[] userSeriala_l = new Long[userSeriala.length];
			for(int i = 0;i < userSeriala.length; i++) {
				userSeriala_l[i] = Long.parseLong(userSeriala[i]);
				MjUserRuleReal mrr = new MjUserRuleReal();
				mrr.setUserSerial(userSeriala_l[i]);
				list.add(mrr);
			}
			List<JrealUpdate> juList = this.jrealUpdateMapper.selectByUser(userSeriala_l);
			list3.addAll(juList);
		}else {
			String[] depSeriala = depSerials.split(",");
			Long[] depSeriala_l = new Long[depSeriala.length];
			for(int i = 0;i < depSeriala.length; i++) {
				depSeriala_l[i] = Long.parseLong(depSeriala[i]);
			}
			List<MjUserRuleReal> mrrList = this.mjUserRuleRealMapper.selectByDep(depSeriala_l);
			list.addAll(mrrList);
			List<JrealUpdate> juList = this.jrealUpdateMapper.selectByDep(depSeriala_l);
			list3.addAll(juList);
		}
		//用户姓名
		for(MjUserRuleReal m:list) {
			m.setGlyNo(glyNo);
		}
		List<MjUserRuleReal> list2 = new ArrayList<MjUserRuleReal>();
		List<JrealUpdate> list4 = new ArrayList<JrealUpdate>();
		if(doorSerials != null && !doorSerials.equals("")) {
			String[] doorSeriala = doorSerials.split(",");
			List<MjUserRuleReal> mrrList = this.mjUserRuleRealMapper.selectByDoor(doorSeriala);
			list2.addAll(mrrList);
			List<JrealUpdate> juList = this.jrealUpdateMapper.selectByDoor(doorSeriala);
			list4.addAll(juList);
		}else {
			String[] siteSeriala = siteSerials.split(",");
			Integer[] siteSeriala_i = new Integer[siteSeriala.length];
			for(int k = 0;k < siteSeriala.length; k++) {
				siteSeriala_i[k] = Integer.parseInt(siteSeriala[k]);
			}
			List<MjUserRuleReal> mrrList = this.mjUserRuleRealMapper.selectBySite(siteSeriala_i);
			list2.addAll(mrrList);
			List<JrealUpdate> juList = this.jrealUpdateMapper.selectBySite(siteSeriala_i);
			list4.addAll(juList);
		}	
		//门禁规则
		for(MjUserRuleReal mrr:list2) {
			if(mrr.getFx() == 0) {
				mrr.setRuleNo(Integer.parseInt(ruleNo));
			}else {
				mrr.setRuleNo(Integer.parseInt(ruleNo2));
			}
		}
		Map<String, Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("list", list);
		parameterMap.put("list2", list2);
		Map<String, Object> parameterMap2 = new HashMap<String,Object>();
		parameterMap2.put("list", list3);
		parameterMap2.put("list2", list4);
		this.mjUserRuleRealMapper.deleteByMap(parameterMap);
		this.jrealUpdateMapper.deleteByMap(parameterMap2);
		this.mjUserRuleRealMapper.insertByMap(parameterMap);
		this.jrealUpdateMapper.insertByMap(parameterMap2);
		resultMap.put("success", true);
		return resultMap;
	}

	public Map<String, Object> delete(String xhs) {
		Map<String, Object> map = new HashMap<String,Object>();
		String[] xha = xhs.split(",");
		Integer[] xha_i = new Integer[xha.length];
		for(int i = 0;i < xha.length; i++) {
			xha_i[i] = Integer.parseInt(xha[i]);
		}
		this.jrealUpdateMapper.deleteByPrimaryKey(xha_i);
		this.mjUserRuleRealMapper.deleteByPrimaryKey(xha_i);
		map.put("success", true);
		return map;
	}

	

}
