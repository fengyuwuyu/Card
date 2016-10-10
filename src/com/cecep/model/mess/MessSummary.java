package com.cecep.model.mess;

import com.cecep.util.CommonsUtil;

public class MessSummary {

	private float zaocMoney = 0f;
	private float zcMoney = 0f;
	private float wcMoney = 0f;
	private float yxMoney = 0f;
	private int zaocCount = 0;
	private int zcCount = 0;
	private int wcCount = 0;
	private int yxCount = 0;
	private String machine = "汇总：";
	private int totalCount;
	private float totalPrice;

	public String getTotalCount() {
		return CommonsUtil.getCss(totalCount);
	}

	public void setTotalCount() {
		this.totalCount ++;
	}

	public String getTotalPrice() {
		return CommonsUtil.getCss(totalPrice);
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice += totalPrice;
	}

	public String getZaocMoney() {
		return CommonsUtil.getCss(zaocMoney);
	}

	public void setZaocMoney(float zaocMoney) {
		this.zaocMoney += zaocMoney;
	}

	public String getZcMoney() {
		return CommonsUtil.getCss(zcMoney);
	}

	public void setZcMoney(float zcMoney) {
		this.zcMoney += zcMoney;
	}

	public String getWcMoney() {
		return CommonsUtil.getCss(wcMoney);
	}

	public void setWcMoney(float wcMoney) {
		this.wcMoney += wcMoney;
	}

	public String getYxMoney() {
		return CommonsUtil.getCss(yxMoney);
	}

	public void setYxMoney(float yxMoney) {
		this.yxMoney += yxMoney;
	}

	public String getZaocCount() {
		return CommonsUtil.getCss(zaocCount);
	}

	public void setZaocCount() {
		this.zaocCount++;
	}

	public String getZcCount() {
		return CommonsUtil.getCss(zcCount);
	}

	public void setZcCount() {
		this.zcCount++;
	}

	public String getWcCount() {
		return CommonsUtil.getCss(wcCount);
	}

	public void setWcCount() {
		this.wcCount++;
	}

	public String getYxCount() {
		return CommonsUtil.getCss(yxCount);
	}

	public void setYxCount() {
		this.yxCount++;
	}

	public String getMachine() {
		return CommonsUtil.getCss(machine);
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	@Override
	public String toString() {
		return "MessSummary [zaocMoney=" + zaocMoney + ", zcMoney=" + zcMoney
				+ ", wcMoney=" + wcMoney + ", yxMoney=" + yxMoney
				+ ", zaocCount=" + zaocCount + ", zcCount=" + zcCount
				+ ", wcCount=" + wcCount + ", yxCount=" + yxCount + "]";
	}

}
