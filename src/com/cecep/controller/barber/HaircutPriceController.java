package com.cecep.controller.barber;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.model.HaircutPrice;
import com.cecep.service.HaircutPriceServiceI;

@Controller
@RequestMapping(value = "HaircutPriceController")
@SessionAttributes(value = "currUser")
public class HaircutPriceController {
	
	private  HaircutPriceServiceI  haircutpriceService;

	@Autowired
	public void setHaircutpriceservice(HaircutPriceServiceI haircutpriceservice) {
		this.haircutpriceService = haircutpriceservice;
	}
	/**
	 * 根据条件分页查询理发类型
	 * @return Map
	 * @author FLD
	 * @date 2016-08-29
	 * */
	@RequestMapping(value = "dataList.do")
	@ResponseBody
	public Map<String, Object> dataList(HaircutPrice record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.haircutpriceService.dataList(record);
		return map;
	}
	
	
	/**
	 * 保存理发信息
	 * @return Map
	 * @author FLD
	 * @date 2016-08-29
	 * */
	@RequestMapping(value = "save.do")
	@ResponseBody
	public Map<String, Object> save(HaircutPrice record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.haircutpriceService.save(record);	
		return map;
	}
	
	/**
	 * 根据条件查询理发信息
	 * @return Map
	 * @author FLD
	 * @date 2016-08-29
	 * */
	@RequestMapping(value = "getById.do")
	@ResponseBody
	public Map<String, Object> getById(HaircutPrice record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String,Object> map = this.haircutpriceService.getById(record);
		return map;
	}
	
	
	/**
	 * 删除理发信息
	 * @return Map
	 * @author FLD
	 * @date 2016-08-29
	 * */
	@RequestMapping(value = "delete.do")
	@ResponseBody
	public Map<String, Object> delete(HaircutPrice record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.haircutpriceService.delete(record);
		return map;
	}
	
	
	
	

}
