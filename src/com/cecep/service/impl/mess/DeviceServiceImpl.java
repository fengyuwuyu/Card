package com.cecep.service.impl.mess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.mess.DeviceMapper;
import com.cecep.model.mess.Device;
import com.cecep.service.mess.DeviceServiceI;

@Service("deviceServiceI")
public class DeviceServiceImpl implements DeviceServiceI {

	private DeviceMapper deviceDao;

	@Autowired
	public void setDeviceDao(DeviceMapper deviceDao) {
		this.deviceDao = deviceDao;
	}

	public List<Device> select() {
		List<Device> list = deviceDao.select();
		Device d = new Device();
		d.setBh("00");
		d.setMc("所有设备");
		list.add(0,d);
		return list;
	}

}
