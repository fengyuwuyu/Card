package com.cecep.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.model.MedicineType;
import com.cecep.service.MedicineTypeServiceI;

@Controller
@RequestMapping(value = "MedicineTypeController")
@SessionAttributes(value = "currUser")
public class MedicineTypeController {
	private  MedicineTypeServiceI  medicineTypeServiceI;
	@Autowired
	public void setMedicineTypeServiceI(MedicineTypeServiceI medicineTypeServiceI) {
		this.medicineTypeServiceI = medicineTypeServiceI;
	}
	
	/**
	 * 根据条件分页查询药品分类
	 * @return Map
	 * @author FLD
	 * @date 2016-03-28
	 * */
	@RequestMapping(value = "dataList.do")
	@ResponseBody
	public Map<String, Object> dataList(MedicineType record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.medicineTypeServiceI.dataList(record);
		return map;
	}
	
	
	
	/**
	 * 保存分类信息
	 * @return Map
	 * @author FLD
	 * @date 2016-03-28
	 * */
	@RequestMapping(value = "save.do")
	@ResponseBody
	public Map<String, Object> save(MedicineType record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.medicineTypeServiceI.save(record);	
		return map;
	}
	
	
	/**
	 * 根据条件查询分类信息
	 * @return Map
	 * @author FLD
	 * @date 2016-03-28
	 * */
	@RequestMapping(value = "getById.do")
	@ResponseBody
	public Map<String, Object> getById(MedicineType record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String,Object> map = this.medicineTypeServiceI.getById(record);
		return map;
	}
	
	
	/**
	 * 删除分类信息
	 * @return Map
	 * @author FLD
	 * @date 2016-03-28
	 * */
	@RequestMapping(value = "delete.do")
	@ResponseBody
	public Map<String, Object> delete(MedicineType record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.medicineTypeServiceI.delete(record);
		return map;
	}
	

}
