package com.cecep.model.kq;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class KqCollect {

	private String username;

	private String depName;

	private Long userSerial;

	private String goOutTimes;

	private String lateTimes;

	private String leaveEarlyTimes;

	private int lateCount;

	private int leaveEarlyCount;

	private int goOutCount;

	private String jbTimes;

	private int jbCount;

	@JsonIgnore
	private Integer allWork;

	@JsonIgnore
	private Date amSj;

	@JsonIgnore
	private Date pmSj;

	@JsonIgnore
	private KqArrayList jbTime;
	@JsonIgnore
	private KqArrayList goOutTime;
	@JsonIgnore
	private KqArrayList lateTime;
	@JsonIgnore
	private KqArrayList leaveEarlyTime;

	public Long getUserSerial() {
		return userSerial;
	}

	public void setUserSerial(Long userSerial) {
		this.userSerial = userSerial;
	}

	public String getGoOutTimes() {
		return goOutTime == null ? "" : goOutTime.getStringValue();
	}

	public void setGoOutTimes(String goOutTimes) {
		this.goOutTimes = goOutTimes;
	}

	public String getLateTimes() {
		return lateTime == null ? "" : lateTime.getStringValue();
	}

	public void setLateTimes(String lateTimes) {
		this.lateTimes = lateTimes;
	}

	public String getLeaveEarlyTimes() {
		return leaveEarlyTime == null ? "" : leaveEarlyTime.getStringValue();
	}

	public void setLeaveEarlyTimes(String leaveEarlyTimes) {
		this.leaveEarlyTimes = leaveEarlyTimes;
	}

	public Integer getAllWork() {
		return allWork;
	}

	public void setAllWork(Integer allWork) {
		this.allWork = allWork;
	}

	public Date getAmSj() {
		return amSj;
	}

	public void setAmSj(Date amSj) {
		this.amSj = amSj;
	}

	public Date getPmSj() {
		return pmSj;
	}

	public void setPmSj(Date pmSj) {
		this.pmSj = pmSj;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public KqArrayList getGoOutTime() {
		return goOutTime;
	}

	public void setGoOutTime(KqArrayList goOutTime) {
		this.goOutTime = goOutTime;
	}

	public KqArrayList getLateTime() {
		return lateTime;
	}

	public void setLateTime(KqArrayList lateTime) {
		this.lateTime = lateTime;
	}

	public KqArrayList getLeaveEarlyTime() {
		return leaveEarlyTime;
	}

	public void setLeaveEarlyTime(KqArrayList leaveEarlyTime) {
		this.leaveEarlyTime = leaveEarlyTime;
	}

	public int getLateCount() {
		return lateTime == null ? null : lateTime.size();
	}

	public int getLeaveEarlyCount() {
		return leaveEarlyTime == null ? null : leaveEarlyTime.size();
	}

	public int getGoOutCount() {
		return goOutTime == null ? null : goOutTime.size();
	}

	public KqArrayList getJbTime() {
		return jbTime;
	}

	public void setJbTime(KqArrayList jbTime) {
		this.jbTime = jbTime;
	}

	public String getJbTimes() {
		return jbTime==null?"":jbTime.getStringValue();
	}

	public int getJbCount() {
		return jbTime==null?null:jbTime.size();
	}

	@Override
	public String toString() {
		return "KqCollect [username=" + username + ", depName=" + depName
				+ ", userSerial=" + userSerial + ", goOutTimes=" + goOutTimes
				+ ", lateTimes=" + lateTimes + ", leaveEarlyTimes="
				+ leaveEarlyTimes + ", lateCount=" + lateCount
				+ ", leaveEarlyCount=" + leaveEarlyCount + ", goOutCount="
				+ goOutCount + ", jbTime=" + jbTime + ", jbTimes=" + jbTimes
				+ ", jbCount=" + jbCount + ", allWork=" + allWork + ", amSj="
				+ amSj + ", pmSj=" + pmSj + ", goOutTime=" + goOutTime
				+ ", lateTime=" + lateTime + ", leaveEarlyTime="
				+ leaveEarlyTime + "]";
	}

}