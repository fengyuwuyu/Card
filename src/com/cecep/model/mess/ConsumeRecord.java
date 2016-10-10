package com.cecep.model.mess;

public class ConsumeRecord {

	private int xh;
	private String region = "";
	private String machine = "";
	/** 交易金额 */
	private float money;
	/** 餐类 */
	private String type;

	public int getXh() {
		return xh;
	}

	public void setXh(int xh) {
		this.xh = xh;
	}

	public float getMoney() {
		return money/100;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type==null?null:type.trim();
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region==null?null:region.trim();
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine==null?null:machine.trim();
	}

	@Override
	public String toString() {
		return "ConsumeRecord [money=" + money + ", type=" + type + "]";
	}

}
