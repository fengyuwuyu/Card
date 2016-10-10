package com.cecep.model;

import java.sql.Time;

public class KqSjManage {
	private Integer id;

	private Integer type;

	private Time sj;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Time getSj() {
		return sj;
	}

	public void setSj(Time sj) {
		this.sj = sj;
	}

	@Override
	public String toString() {
		return "KqSjManage [id=" + id + ", type=" + type + ", sj=" + sj + "]";
	}

}