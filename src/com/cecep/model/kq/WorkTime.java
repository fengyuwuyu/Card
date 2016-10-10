package com.cecep.model.kq;

import java.sql.Time;

public class WorkTime {

	private int id;
	/** 上班或下班时间 */
//	 @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
	private Time time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
