package com.cecep.controller.mess;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cecep.model.XfTime;
import com.cecep.service.XfTimeServiceI;

@Controller
@RequestMapping(value="xfTimeController")
public class XfTimeController {
	
	private XfTimeServiceI xfTimeService;
	
	@Autowired
	public void setXfTimeService(XfTimeServiceI xfTimeService) {
		this.xfTimeService = xfTimeService;
	}

	@RequestMapping(value = "getById.do")
	@ResponseBody
	public Map<String, Object> getById(XfTime record) {
		return xfTimeService.getById(record);
	}
	
	@RequestMapping(value = "save.do")
	@ResponseBody
	public Map<String, Object> save(XfTime record) {
		return this.xfTimeService.save(record);
	}
	
	@RequestMapping(value = "remove.do")
	@ResponseBody
	public Map<String, Object> remove(String bh) {
		return this.xfTimeService.remove(bh);
	}
	
	@RequestMapping(value = "getExternalXfTimes.do")
	@ResponseBody
	public Map<String, Object> getExternalXfTimes(Integer depSerial) {
		return this.xfTimeService.getExternalXfTimes(depSerial);
	}
}
