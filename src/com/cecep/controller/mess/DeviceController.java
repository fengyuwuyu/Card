package com.cecep.controller.mess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cecep.model.mess.Device;
import com.cecep.service.mess.DeviceServiceI;

/**
 * 设备控制器
 * @author lilei
 * 
 */
@Controller
@RequestMapping(value = "deviceController")
public class DeviceController {

	private DeviceServiceI deviceServiceI;

	@Autowired
	public void setDeviceServiceI(DeviceServiceI deviceServiceI) {
		this.deviceServiceI = deviceServiceI;
	}

	/**
	 * 返回设备下拉框查询
	 * */
	@RequestMapping(value = "select.do")
	@ResponseBody
	public List<Device> select() {
		return deviceServiceI.select();
	}

}
