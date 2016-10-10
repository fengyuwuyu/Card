package com.cecep.model.kq;

import java.util.Date;
import java.util.List;

public class KqAnalyse {

	private String deptName;
	private Long userSerial;
	private String username;
	/** 晚到次数 */
	private int lateCount;
	/** 晚到时间列表 */
	private List<Date> lateTimes;
	/** 早退次数 */
	private int leaveEarlyCount;
	/** 早退时间列表 */
	private List<Date> leaveEarlyTimes;
	/** 外出次数 */
	private int goOutCount;
	/** 外出时间列表 */
	private List<Date> goOutTimes;

	public Long getUserSerial() {
		return userSerial;
	}

	public void setUserSerial(Long userSerial) {
		this.userSerial = userSerial;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName==null?null:deptName.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username==null?null:username.trim();
	}

	public int getLateCount() {
		return lateCount;
	}

	public void setLateCount(int lateCount) {
		this.lateCount = lateCount;
	}

	public List<Date> getLateTimes() {
		return lateTimes;
	}

	public void setLateTimes(List<Date> lateTimes) {
		this.lateTimes = lateTimes;
	}

	public int getLeaveEarlyCount() {
		return leaveEarlyCount;
	}

	public void setLeaveEarlyCount(int leaveEarlyCount) {
		this.leaveEarlyCount = leaveEarlyCount;
	}

	public List<Date> getLeaveEarlyTimes() {
		return leaveEarlyTimes;
	}

	public void setLeaveEarlyTimes(List<Date> leaveEarlyTimes) {
		this.leaveEarlyTimes = leaveEarlyTimes;
	}

	public int getGoOutCount() {
		return goOutCount;
	}

	public void setGoOutCount(int goOutCount) {
		this.goOutCount = goOutCount;
	}

	public List<Date> getGoOutTimes() {
		return goOutTimes;
	}

	public void setGoOutTimes(List<Date> goOutTimes) {
		this.goOutTimes = goOutTimes;
	}

	@Override
	public String toString() {
		return "KqAnalyse [deptName=" + deptName + ", userSerial=" + userSerial
				+ ", username=" + username + ", lateCount=" + lateCount
				+ ", lateTimes=" + lateTimes + ", leaveEarlyCount="
				+ leaveEarlyCount + ", leaveEarlyTimes=" + leaveEarlyTimes
				+ ", goOutCount=" + goOutCount + ", goOutTimes=" + goOutTimes
				+ "]";
	}

}
