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

import com.cecep.model.HaircutTerms;
import com.cecep.service.HaircutTermsServiceI;


@Controller
@RequestMapping(value = "HaircutTermsController")
@SessionAttributes(value = "currUser")

public class HaircutTermsController {
	private HaircutTermsServiceI  haircutTermsService;

	@Autowired
	public void setHaircutTermsService(HaircutTermsServiceI haircutTermsService) {
		this.haircutTermsService = haircutTermsService;
	}
	
	/**
	 * 根据条件分页查询理发用品形容词
	 * @return Map
	 * @author FLD
	 * @date 2016-08-29
	 * */
	@RequestMapping(value = "dataList.do")
	@ResponseBody
	public Map<String, Object> dataList(HaircutTerms record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.haircutTermsService.dataList(record);
		return map;
	}
	
	
	/**
	 * 保存理发用品形容词
	 * @return Map
	 * @author FLD
	 * @date 2016-08-29
	 * */
	@RequestMapping(value = "save.do")
	@ResponseBody
	public Map<String, Object> save(HaircutTerms record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.haircutTermsService.save(record);	
		return map;
	}
	
	/**
	 * 根据条件查询理发用品形容词
	 * @return Map
	 * @author FLD
	 * @date 2016-08-29
	 * */
	@RequestMapping(value = "getById.do")
	@ResponseBody
	public Map<String, Object> getById(HaircutTerms record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String,Object> map = this.haircutTermsService.getById(record);
		return map;
	}
	
	
	/**
	 * 删除理发理发用品形容词
	 * @return Map
	 * @author FLD
	 * @date 2016-08-29
	 * */
	@RequestMapping(value = "delete.do")
	@ResponseBody
	public Map<String, Object> delete(HaircutTerms record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.haircutTermsService.delete(record);
		return map;
	}
	
}
