package com.cecep.controller.impower;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.model.DtAcDep;
import com.cecep.model.DtDep;
import com.cecep.model.DtUser;
import com.cecep.model.MjRuleReal;
import com.cecep.model.MjUserRuleReal;
import com.cecep.model.StDoorReal;
import com.cecep.service.DtAcDepServiceI;
import com.cecep.service.DtDepServiceI;
import com.cecep.service.DtUserServiceI;
import com.cecep.service.MjRuleRealServiceI;
import com.cecep.service.MjUserRuleRealServiceI;
import com.cecep.service.StDoorRealServiceI;
/**
 * 卡授权模块后台控制器
 * @date 2016-03-22
 * */
@Controller
@RequestMapping(value = "impowerController")
@SessionAttributes(value = "currUser")
public class ImpowerController {
	
	private DtUserServiceI dtUserServiceI;
	private DtDepServiceI dtDepServiceI;
	private StDoorRealServiceI stDoorRealServiceI;
	private DtAcDepServiceI dtAcDepServiceI;
	private MjRuleRealServiceI mjRuleRealServiceI;	
	private MjUserRuleRealServiceI mjUserRuleRealServiceI;

	@Autowired
	public void setDtUserServiceI(DtUserServiceI dtUserServiceI) {
		this.dtUserServiceI = dtUserServiceI;
	}
	
	@Autowired
	public void setDtDepServiceI(DtDepServiceI dtDepServiceI) {
		this.dtDepServiceI = dtDepServiceI;
	}
	
	@Autowired
	public void setStDoorRealServiceI(StDoorRealServiceI stDoorRealServiceI) {
		this.stDoorRealServiceI = stDoorRealServiceI;
	}
	
	@Autowired
	public void setDtAcDepServiceI(DtAcDepServiceI dtAcDepServiceI) {
		this.dtAcDepServiceI = dtAcDepServiceI;
	}

	@Autowired
	public void setMjRuleRealServiceI(MjRuleRealServiceI mjRuleRealServiceI) {
		this.mjRuleRealServiceI = mjRuleRealServiceI;
	}
		
	@Autowired
	public void setMjUserRuleRealServiceI(
			MjUserRuleRealServiceI mjUserRuleRealServiceI) {
		this.mjUserRuleRealServiceI = mjUserRuleRealServiceI;
	}

	/**
	 * 员工--分页查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "dtUserDataList.do")
	@ResponseBody
	public Map<String, Object> dtUserDataList(DtUser record,HttpServletRequest request,HttpServletResponse response) {
		record.setCardXh(1);
		Map<String,Object> map = this.dtUserServiceI.dataList(record);
		return map;
	}
	
	/**
	 * 部门--分页查询
	 * @return Map
	 * @author BYP
	 * @date 2016-02-23
	 * */
	@RequestMapping(value = "dtDepDataList.do")
	@ResponseBody
	public Object dtDepDataList(Integer id,DtDep record,HttpServletRequest request,HttpServletResponse response) {
		record.setDepParent(id);
		Object o = this.dtDepServiceI.dataList(record);
		return o;
	}
	
	/**
	 * 门--分页查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "doorDataList.do")
	@ResponseBody
	public Map<String, Object> doorDataList(StDoorReal record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.stDoorRealServiceI.dataList(record);
		return map;
	}
	
	/**
	 * 场所--分页查询
	 * @return Map
	 * @author BYP
	 * @date 2016-02-23
	 * */
	@RequestMapping(value = "siteDataList.do")
	@ResponseBody
	public Object siteDataList(Integer id,DtAcDep record,HttpServletRequest request,HttpServletResponse response) {
		record.setDepParent(id);
		Object o = this.dtAcDepServiceI.dataList(record);
		return o;
	}
	
	/**
	 * 场所--下拉查询
	 * @return List
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "siteLoad.do")
	@ResponseBody
	public List<Map<String,Object>> siteLoad(Integer id,HttpServletRequest request,HttpServletResponse response) {
		List<Map<String,Object>> list = this.dtAcDepServiceI.load(id);
		return list;					
	}
	
	/**
	 * 授权记录--分页查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "recordDataList.do")
	@ResponseBody
	public Map<String, Object> recordDataList(MjUserRuleReal record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.mjUserRuleRealServiceI.dataList(record);
		return map;
	}
	
	/**
	 * 授权记录--保存
	 * @return Map
	 * @author BYP
	 * @date 2016-02-23
	 * */
	@RequestMapping(value = "recordSave.do")
	@ResponseBody
	public Map<String, Object> recordSave(@ModelAttribute("currUser") DtUser currUser,String userSerials,String depSerials,String doorSerials,String siteSerials,String ruleNo,String ruleNo2,MjUserRuleReal record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.mjUserRuleRealServiceI.save(userSerials, depSerials, doorSerials, siteSerials, ruleNo, ruleNo2,currUser.getUserLname());
		return map;
	}
	
	/**
	 * 授权记录--删除
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "recordDelete.do")
	@ResponseBody
	public Map<String, Object> recordDelete(String xhs,MjUserRuleReal record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.mjUserRuleRealServiceI.delete(xhs);
		return map;
	}
	
	/**
	 * 门禁规则--下拉查询
	 * @return List
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "mjRuleLoad.do")
	@ResponseBody
	public List<Map<String,Object>> mjRuleLoad(MjRuleReal record,HttpServletRequest request,HttpServletResponse response) {
		List<Map<String,Object>> list = this.mjRuleRealServiceI.load(record);
		return list;					
	}

}
