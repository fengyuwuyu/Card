package com.cecep.controller.parameter;






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

import com.cecep.controller.BaseController;
import com.cecep.model.DtAcType;
import com.cecep.model.DtUser;
import com.cecep.model.MjShidReal;
import com.cecep.model.XfAcTime;
import com.cecep.model.XfTime;
import com.cecep.service.DtAcTypeServiceI;
import com.cecep.service.MjShidRealServiceI;
import com.cecep.service.XfAcTimeServiceI;
import com.cecep.service.XfTimeServiceI;
/**
 * 卡参数模块后台控制器
 * @date 2016-03-22
 * */
@Controller
@RequestMapping(value = "parameterController")
@SessionAttributes(value = "currUser")
public class ParameterController extends BaseController {
	
	private DtAcTypeServiceI dtAcTypeServiceI;
	private XfTimeServiceI xfTimeServiceI;
	private MjShidRealServiceI mjShidRealServiceI;
	private XfAcTimeServiceI xfAcTimeServiceI;
	
	
	@Autowired
	public void setDtAcTypeServiceI(DtAcTypeServiceI dtAcTypeServiceI) {
		this.dtAcTypeServiceI = dtAcTypeServiceI;
	}
	
	@Autowired
	public void setXfTimeServiceI(XfTimeServiceI xfTimeServiceI) {
		this.xfTimeServiceI = xfTimeServiceI;
	}
	
	@Autowired
	public void setMjShidRealServiceI(MjShidRealServiceI mjShidRealServiceI) {
		this.mjShidRealServiceI = mjShidRealServiceI;
	}

	@Autowired
	public void setXfAcTimeServiceI(XfAcTimeServiceI xfAcTimeServiceI) {
		this.xfAcTimeServiceI = xfAcTimeServiceI;
	}
	
	/**
	 * 账户类型--分页查询
	 * @return Map
	 * @author BYP
	 * @date 2016-03-15
	 * */
	@RequestMapping(value = "accountDataList.do")
	@ResponseBody
	public Map<String, Object> accountDataList(DtAcType record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.dtAcTypeServiceI.dataList(record);
		return map;
	}
	
	/**
	 * 账户类型--主键查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "accountGetById.do")
	@ResponseBody
	public Map<String, Object> accountGetById(DtAcType record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.dtAcTypeServiceI.getById(record);
		return map;
	}
		
	/**
	 * 账户类型--保存
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "accountSave.do")
	@ResponseBody
	public Map<String, Object> accountSave(DtAcType record,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = this.dtAcTypeServiceI.save(record);
		return map;
	}
	
	/**
	 * 账户类型--删除
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "accountDelete.do")
	@ResponseBody
	public Map<String, Object> accountDelete(DtAcType record,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = this.dtAcTypeServiceI.delete(record);
		return map;
	}
	
	/**
	 * 账户类型--下拉查询
	 * @return List
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "accountLoad.do")
	@ResponseBody
	public List<Map<String,Object>> accountLoad(DtAcType record,HttpServletRequest request,HttpServletResponse response) {
		List<Map<String,Object>> list = this.dtAcTypeServiceI.load(record);
		return list;					
	}
	
	/**
	 * 消费时段--下拉查询
	 * @return List
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "timeLoad.do")
	@ResponseBody
	public List<Map<String,Object>> loadTime(XfTime record,HttpServletRequest request,HttpServletResponse response) {
		List<Map<String,Object>> list = this.xfTimeServiceI.load(record);
		return list;					
	}
	
	/**
	 * 账户时段--分页查询
	 * @return Map
	 * @author BYP
	 * @date 2016-03-18
	 * */
	@RequestMapping(value = "accountTimeDataList.do")
	@ResponseBody
	public Map<String, Object> accountTimeDataList(XfAcTime record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.xfAcTimeServiceI.dataList(record);
		return map;
	}
	
	/**
	 * 账户时段--主键查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "accountTimeGetById.do")
	@ResponseBody
	public Map<String, Object> accountTimeGetById(XfAcTime record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.xfAcTimeServiceI.getById(record);
		return map;
	}

	/**
	 * 账户时段--保存
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "accountTimeSave.do")
	@ResponseBody
	public Map<String, Object> accountTimeSave(@ModelAttribute("currUser") DtUser currUser,XfAcTime record,HttpServletRequest request,HttpServletResponse response) {
		//用户姓名
		record.setGlyNo(currUser.getUserLname());
		Map<String,Object> map = this.xfAcTimeServiceI.save(record);
		return map;
	}
	
	/**
	 * 账户时段--删除
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "accountTimeDelete.do")
	@ResponseBody
	public Map<String, Object> accountTimeDelete(XfAcTime record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.xfAcTimeServiceI.delete(record);
		return map;
	}
	
	/**
	 * 门禁时段--分页查询
	 * @return Map
	 * @author BYP
	 * @date 2016-03-18
	 * */
	@RequestMapping(value = "ruleDataList.do")
	@ResponseBody
	public Map<String, Object> ruleDataList(MjShidReal record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.mjShidRealServiceI.dataList(record);
		return map;
	}
}
