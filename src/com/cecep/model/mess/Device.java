package com.cecep.model.mess;

public class Device {

	/** 设备编号*/
	private String bh;
	/** 设备名称*/
	private String mc;

	public String getBh() {
		return bh;
	}

	public void setBh(String bh) {
		this.bh = bh==null?null:bh.trim();
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc==null?null:mc.trim();
	}

	@Override
	public String toString() {
		return "Device [bh=" + bh + ", mc=" + mc + "]";
	}

}
