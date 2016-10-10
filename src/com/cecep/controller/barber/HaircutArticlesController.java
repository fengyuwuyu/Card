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

import com.cecep.model.HaircutArticles;
import com.cecep.service.HaircutArticlesServiceI;

@Controller
@RequestMapping(value = "HaircutArticlesController")
@SessionAttributes(value = "currUser")

public class HaircutArticlesController {
	private  HaircutArticlesServiceI  haircutArticlesService;

	@Autowired
	public void setHaircutArticlesService(HaircutArticlesServiceI haircutArticlesService) {
		this.haircutArticlesService = haircutArticlesService;
	}
	
	/**
	 * 根据条件分页查询理发用品信息
	 * @return Map
	 * @author FLD
	 * @date 2016-08-29
	 * */
	@RequestMapping(value = "dataList.do")
	@ResponseBody
	public Map<String, Object> dataList(HaircutArticles record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.haircutArticlesService.dataList(record);
		return map;
	}
	
	
	/**
	 * 保存理发用品信息
	 * @return Map
	 * @author FLD
	 * @date 2016-08-29
	 * */
	@RequestMapping(value = "save.do")
	@ResponseBody
	public Map<String, Object> save(HaircutArticles record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.haircutArticlesService.save(record);	
		return map;
	}
	
	/**
	 * 根据条件查询理发用品信息
	 * @return Map
	 * @author FLD
	 * @date 2016-08-29
	 * */
	@RequestMapping(value = "getById.do")
	@ResponseBody
	public Map<String, Object> getById(HaircutArticles record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String,Object> map = this.haircutArticlesService.getById(record);
		return map;
	}
	
	
	/**
	 * 删除理发理发信息
	 * @return Map
	 * @author FLD
	 * @date 2016-08-29
	 * */
	@RequestMapping(value = "delete.do")
	@ResponseBody
	public Map<String, Object> delete(HaircutArticles record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.haircutArticlesService.delete(record);
		return map;
	}

}
