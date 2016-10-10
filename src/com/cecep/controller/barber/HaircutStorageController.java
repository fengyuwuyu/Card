package com.cecep.controller.barber;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.model.HaircutStorage;
import com.cecep.service.HaircutStorageServiceI;

@Controller
@RequestMapping(value = "HaircutStorageController")
@SessionAttributes(value = "currUser")
public class HaircutStorageController {
	HaircutStorageServiceI  haircutStorageService;
	

	@Autowired
	public void setHaircutStorageService(HaircutStorageServiceI haircutStorageService) {
		this.haircutStorageService = haircutStorageService;
	}


	/**
	 * 根据条件分页查询理发类型
	 * @return Map
	 * @author FLD
	 * @date 2016-08-29
	 * */
	@RequestMapping(value = "dataList.do")
	@ResponseBody
	public Map<String, Object> dataList(HaircutStorage record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.haircutStorageService.dataList(record);
		return map;
	}
	
	
	
	
	
	
	
	
	/**
	 * 理发用品入库页面
	 * @return
	 */
	@RequestMapping(value="addHaircutStorage.do")  
	public String addInventory(){  
		return "view/barber/addHaircutStorage";  
	} 
	

}
