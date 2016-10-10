package com.cecep.service.kq;

import java.util.Map;

import com.cecep.model.kq.VacationParam;

public interface HolidayServiceI {

	Map<String, Object> dataList(VacationParam record);

	Map<String, Object> save(String vacations);

	 void delete(String holiday);

}
