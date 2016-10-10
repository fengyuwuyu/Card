package com.cecep.model.kq;

public class PersonalQuery {
	
	private Integer userSerial;

	private String username;

	private String depName;

	private String cardSerial;
	/** 查询类型：1、迟到 2、早退 3、外出 4、加班 */
	private int queryType;
	private String jbTimes;
	
	public Integer getUserSerial() {
		return userSerial;
	}

	public void setUserSerial(Integer userSerial) {
		this.userSerial = userSerial;
	}

	public int getQueryType() {
		return queryType;
	}

	public void setQueryType(int queryType) {
		this.queryType = queryType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username==null?null:username.trim();
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName==null?null:depName.trim();
	}

	public String getCardSerial() {
		return cardSerial;
	}

	public void setCardSerial(String cardSerial) {
		this.cardSerial = cardSerial==null?null:cardSerial.trim();
	}

	public String getJbTimes() {
		return jbTimes;
	}

	public void setJbTimes(String jbTimes) {
		this.jbTimes = jbTimes==null?null:jbTimes.trim();
	}

}
