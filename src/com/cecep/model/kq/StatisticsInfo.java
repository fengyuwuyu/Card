package com.cecep.model.kq;

/**
 * 存储统计信息
 * 
 * @author lilei
 * 
 */
public class StatisticsInfo {
	/** 公司部门:中国节能环保集团 人数：352 */
	private String depInfo;
	/** 总晚到早走人次:349 */
	private String personNum;
	/** 日期:2016-03-01 至 2016-03-28 */
	private String dateInfo;
	/** 全勤人员 */
	private String allWorkInfo;
	private String depName;

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepInfo() {
		return depInfo;
	}

	public void setDepInfo(String depInfo) {
		this.depInfo = depInfo == null ? null : depInfo.trim();
	}

	public String getPersonNum() {
		return personNum;
	}

	public void setPersonNum(String personNum) {
		this.personNum = personNum == null ? null : personNum.trim();
	}

	public String getDateInfo() {
		return dateInfo;
	}

	public void setDateInfo(String dateInfo) {
		this.dateInfo = dateInfo == null ? null : dateInfo.trim();
	}

	public String getAllWorkInfo() {
		return allWorkInfo;
	}

	public void setAllWorkInfo(String allWorkInfo) {
		this.allWorkInfo = allWorkInfo == null ? null : allWorkInfo.trim();
	}

	@Override
	public String toString() {
		return "StatisticsInfo [depInfo=" + depInfo + ", personNum="
				+ personNum + ", dateInfo=" + dateInfo + ", allWorkInfo="
				+ allWorkInfo + ", depName=" + depName + "]";
	}

}
