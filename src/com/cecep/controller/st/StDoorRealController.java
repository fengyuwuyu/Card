package com.cecep.controller.st;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.model.DtUser;
import com.cecep.model.StDevice;
import com.cecep.model.StDoorReal;
import com.cecep.service.StDeviceServiceI;
import com.cecep.service.StDoorRealServiceI;

/**
 * @author ll
 * 
 */
@Controller
@RequestMapping("stDoorReal")
@SessionAttributes("currUser")
public class StDoorRealController {

	private StDoorRealServiceI doorServiceI;
	private StDeviceServiceI stDeviceServiceI;

	@Autowired
	public void setStDeviceServiceI(StDeviceServiceI stDeviceServiceI) {
		this.stDeviceServiceI = stDeviceServiceI;
	}

	@Autowired
	public void setDoorServiceI(StDoorRealServiceI doorServiceI) {
		this.doorServiceI = doorServiceI;
	}

	@RequestMapping("dataList.do")
	@ResponseBody
	public Map<String, Object> dataList(StDoorReal record) {
		return doorServiceI.dataList(record);
	}

	@RequestMapping("save.do")
	@ResponseBody
	public Map<String, Object> save(
			@ModelAttribute("currUser") DtUser currUser, StDoorReal record) {
		return doorServiceI.save(currUser, record);
	}

	@RequestMapping("getById.do")
	@ResponseBody
	public Map<String, Object> getById(StDoorReal record) {
		return doorServiceI.getById(record);
	}

	@RequestMapping("selectStDoor.do")
	@ResponseBody
	public List<Map<String, Object>> selectStDoor() {
		return this.doorServiceI.selectStDoor();
	}

	@RequestMapping("selectMjDev.do")
	@ResponseBody
	public Map<String,Object> selectMjDev(StDevice query){
		return this.stDeviceServiceI.dataList(query);
	}
	
	@RequestMapping("delete.do")
	@ResponseBody
	public Map<String,Object> delete(@ModelAttribute("currUser") DtUser currUser,StDoorReal query){
		query.setOperator(currUser.getUserLname());
		return this.doorServiceI.delete(query);
	}
}
