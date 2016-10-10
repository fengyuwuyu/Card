package com.cecep.model.mess;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 食堂消费统计Entity
 * 
 * @author lilei
 * 
 */
/**
 * @author lilei
 */
public class MessStatisticsInfo {

	private String date;
	private String depName = "所有部门";
	private String region = "所有区域";
	private String machine = "所有设备";
	private float zaocMoney;
	private int zaocCount;
	private float zcMoney;
	private int zcCount;
	private float wcMoney;
	private int wcCount;
	private float yxMoney;
	private int yxCount;
	private float totalPrice;
	private int totalCount;
	@JsonIgnore
	private List<ConsumeRecord> consumeRecords;

	/**
	 * 用于统计早中晚及夜宵的金额和次数
	 * 
	 * @param summary
	 *            封装统计信息的对象
	 */
	public void statistics(MessSummary summary, MessQuery query) {
		if (consumeRecords != null && consumeRecords.size() > 0) {
			for (ConsumeRecord record : consumeRecords) {
				if ("早餐".equals(record.getType())) {
					zaocCount++;
					summary.setZaocCount();
					zaocMoney += record.getMoney();
					summary.setZaocMoney(record.getMoney());
					;
				} else if ("午餐".equals(record.getType())) {
					zcCount++;
					summary.setZcCount();
					zcMoney += record.getMoney();
					summary.setZcMoney(record.getMoney());
				} else if ("晚餐".equals(record.getType())) {
					wcCount++;
					summary.setWcCount();
					wcMoney += record.getMoney();
					summary.setWcMoney(record.getMoney());
				} else if ("夜宵".equals(record.getType())) {
					yxCount++;
					summary.setYxCount();
					yxMoney += record.getMoney();
					summary.setYxMoney(record.getMoney());
				}
				if (!"非时段".equals(record.getType())
						&& !"加班餐".equals(record.getType())) {
					totalPrice += record.getMoney();
					totalCount++;
					summary.setTotalCount();
					summary.setTotalPrice(record.getMoney());
				}
			}
		}
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public float getZaocMoney() {
		return zaocMoney;
	}

	public void setZaocMoney(float zaocMoney) {
		this.zaocMoney = zaocMoney;
	}

	public int getZaocCount() {
		return zaocCount;
	}

	public void setZaocCount(int zaocCount) {
		this.zaocCount = zaocCount;
	}

	public float getZcMoney() {
		return zcMoney;
	}

	public void setZcMoney(float zcMoney) {
		this.zcMoney = zcMoney;
	}

	public int getZcCount() {
		return zcCount;
	}

	public void setZcCount(int zcCount) {
		this.zcCount = zcCount;
	}

	public float getWcMoney() {
		return wcMoney;
	}

	public void setWcMoney(float wcMoney) {
		this.wcMoney = wcMoney;
	}

	public int getWcCount() {
		return wcCount;
	}

	public void setWcCount(int wcCount) {
		this.wcCount = wcCount;
	}

	public float getYxMoney() {
		return yxMoney;
	}

	public void setYxMoney(float yxMoney) {
		this.yxMoney = yxMoney;
	}

	public int getYxCount() {
		return yxCount;
	}

	public void setYxCount(int yxCount) {
		this.yxCount = yxCount;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setConsumeRecords(List<ConsumeRecord> consumeRecords) {
		this.consumeRecords = consumeRecords;
	}

	@Override
	public String toString() {
		return "MessStatisticsInfo [depName=" + depName + ", region=" + region
				+ ", machine=" + machine + ", zaocMoney=" + zaocMoney
				+ ", zaocCount=" + zaocCount + ", zcMoney=" + zcMoney
				+ ", zcCount=" + zcCount + ", wcMoney=" + wcMoney
				+ ", wcCount=" + wcCount + ", yxMoney=" + yxMoney
				+ ", yxCount=" + yxCount + ", totalPrice=" + totalPrice
				+ ", totalCount=" + totalCount + "]";
	}

}