package com.cecep.model.kq;


public class Holiday {
	private Integer id;

	private String holidayTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHolidayTime() {
		return holidayTime;
	}

	public void setHolidayTime(String holidayTime) {
		this.holidayTime = holidayTime==null?null:holidayTime.trim();
	}

}