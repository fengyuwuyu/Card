package com.cecep.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cecep.cache.DepCache;
import com.cecep.dao.CecepWordsMapper;
import com.cecep.dao.MidUserMapper;
import com.cecep.model.DtUser;
import com.cecep.service.DtDepServiceI;
import com.cecep.service.DtUserServiceI;
import com.cecep.service.MidDepServiceI;
import com.cecep.service.MidUserServiceI;
import com.cecep.service.kq.KqRecordServiceI;
import com.cecep.util.MapUtils;

@Controller
@RequestMapping("test")
public class TestController {


	private MidDepServiceI depServiceI;

	private DtUserServiceI dtUserServiceI;
	
	private DtDepServiceI dtDepServiceI;
	
	private MidUserServiceI midUserServiceI;
	
	private MidUserMapper midUserMapper;
	
	private MidDepServiceI midDepServiceI;

	private CecepWordsMapper cecepWordsMapper;
	
	private KqRecordServiceI kqRecordServiceI;
	
	@Autowired
	public void setKqRecordServiceI(KqRecordServiceI kqRecordServiceI) {
		this.kqRecordServiceI = kqRecordServiceI;
	}

	@Autowired
	public void setCecepWordsMapper(CecepWordsMapper cecepWordsMapper) {
		this.cecepWordsMapper = cecepWordsMapper;
	}

	@Autowired
	public void setMidDepServiceI(MidDepServiceI midDepServiceI) {
		this.midDepServiceI = midDepServiceI;
	}

	@Autowired
	public void setMidUserMapper(MidUserMapper midUserMapper) {
		this.midUserMapper = midUserMapper;
	}

	@Autowired
	public void setMidUserServiceI(MidUserServiceI midUserServiceI) {
		this.midUserServiceI = midUserServiceI;
	}

	@Autowired
	public void setDtUserServiceI(DtUserServiceI dtUserServiceI) {
		this.dtUserServiceI = dtUserServiceI;
	}

	@Autowired
	public void setDepServiceI(MidDepServiceI depServiceI) {
		this.depServiceI = depServiceI;
	}
	
	@Autowired
	public void setDtDepServiceI(DtDepServiceI dtDepServiceI) {
		this.dtDepServiceI = dtDepServiceI;
	}

	@RequestMapping("test.do")
	public void test(HttpServletResponse response) throws IOException {
		this.kqRecordServiceI.kqRecordAnalyse1();
	}
	
	@RequestMapping("initCecepDep.do")
	public void initCecepDep(HttpServletResponse response) throws IOException {
//		depServiceI.insertInitData();
	}
	
	@RequestMapping("initCecepUser.do")
	@ResponseBody
	public Map<String,Object> initCecepUser(){
		return this.midUserServiceI.initInternalUser();
	}
	
	/**
	 * 清空员工表及删除添加用户时所涉及表的数据
	 * @return
	 */
	@RequestMapping("clearUser.do")
	@ResponseBody
	public Map<String,Object> clearUser(){
		this.dtUserServiceI.deleteAllUser();
		return MapUtils.createSuccessMap();
	}
	
	/**
	 * 清空员工表及删除添加用户时所涉及表的数据
	 * @return
	 */
	@RequestMapping("clearDep.do")
	@ResponseBody
	public Map<String,Object> clearDep(){
		return this.dtDepServiceI.clearDtDDep();
	}
	
	@RequestMapping("queryDep.do")
	@ResponseBody
	public Map<String,Object> queryAllDepByParentId(Long serial){
		Set<Long> depSerials = DepCache.getChildren(serial);
		return MapUtils.createMap("result",depSerials);
	}
	
	@RequestMapping("insertAdmin.do")
	@ResponseBody
	public Map<String,Object> insertAdmin(){
		DtUser record = new DtUser();
		record.setUserNo("99999998");
		record.setUserLname("admin");
		record.setRoleId(1);
		record.setAcBh("0000000000000001");
		record.setUserSex("男");
		record.setUserId("111111111111111111");
		record.setUserDep(10000);
		record.setUserType((short)0);
		this.dtUserServiceI.save(record, null);
		
		return MapUtils.createSuccessMap();
	}
	
	@RequestMapping("initExternalUser.do")
	@ResponseBody
	public Map<String,Object> initExternalUser(){
		return this.midUserServiceI.initExternalUser();
	}
	
	@RequestMapping("insertTestKqJl.do")
	@ResponseBody
	public Map<String,Object> insertTestKqJl(){
		return this.midUserServiceI.insertTestKqJl();
	}
	
	public static void main(String[] args) {
		"".split(",");
	}
}
