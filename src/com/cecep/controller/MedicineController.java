package com.cecep.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.model.DtUser;
import com.cecep.model.Medicine;
import com.cecep.service.MedicineServiceI;

@Controller
@RequestMapping(value = "MedicineController")
@SessionAttributes(value = "currUser")
public class MedicineController {
	
	private MedicineServiceI  medicineService;

	@Autowired
	public void setDepService(MedicineServiceI medicineService) {
		this.medicineService = medicineService;
	}
	
	/**
	 * 根据条件分页查询药品
	 * @return Map
	 * @author FLD
	 * @date 2016-03-09
	 * */
	@RequestMapping(value = "dataList.do")
	@ResponseBody
	public Map<String, Object> dataList(Medicine record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.medicineService.dataList(record);
		return map;
	}
	/**
	 * 保存药品信息
	 * @return Map
	 * @author FLD
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "save.do")
	@ResponseBody
	public Map<String, Object> save(Medicine record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.medicineService.save(record);	
		return map;
	}
	
	/**
	 * 根据条件查询药品信息
	 * @return Map
	 * @author FLD
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "getById.do")
	@ResponseBody
	public Map<String, Object> getById(Medicine record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String,Object> map = this.medicineService.getById(record);
		return map;
	}
	
	
	/**
	 * 删除药品信息
	 * @return Map
	 * @author FLD
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "delete.do")
	@ResponseBody
	public Map<String, Object> delete(Medicine record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.medicineService.delete(record);
		return map;
	}
	
	
	
	
	
	
	/**
	 * 根据查询药品类型
	 * @return Map
	 * @author FLD
	 * @date 2016-03-09
	 * */
	@RequestMapping(value = "selectType.do")
	@ResponseBody
	public List<Map<String, Object>> selectType(Medicine record,HttpServletRequest request,HttpServletResponse response) {
		List<Map<String,Object>> list = this.medicineService.selectType(record);
		List<Map<String,Object>> orgs = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("typeId", 0);
		map.put("typeName", "-- 请选择 --");
		map.put("selected", true);			
		orgs.add(map);
		orgs.addAll(list);
		return orgs;
	}

}
