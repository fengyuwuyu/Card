package com.cecep.model.mess;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MessConsumeInfo {

	/** 部门 */
	private String depName = "所有部门";
	/** 区域 */
	private String region = "所有区域";
	/** 机器 */
	private String machine = "所有设备";
	/** 姓名 */
	private String username = "";
	/** 卡号 */
	private String cardSerial = "";
	/** 人员编号 */
	private String userNo = "";
	/** 证件号码 */
	private String certificateNo = "";
	/** 交易金额 */
	private float money;
	/** 余额 */
	private float remainMoney;
	/** 交易日期 */
	@JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date tradeDate;
	/** 餐类 */
	private String type;
	/** 操作员 */
	private String operator = "";
	/** 结算账户 */
	private String account = "";

	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCardSerial() {
		return cardSerial.length() > 8 ? cardSerial.substring(
				cardSerial.length() - 8, cardSerial.length()) : cardSerial;
	}

	public void setCardSerial(String cardSerial) {
		this.cardSerial = cardSerial;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public float getRemainMoney() {
		return remainMoney;
	}

	public void setRemainMoney(float remainMoney) {
		this.remainMoney = remainMoney;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "MessConsumeInfo [depName=" + depName + ", region=" + region
				+ ", machine=" + machine + ", username=" + username
				+ ", cardSerial=" + cardSerial + ", userNo=" + userNo
				+ ", certificateNo=" + certificateNo + ", money=" + money
				+ ", remainMoney=" + remainMoney + ", tradeDate=" + tradeDate
				+ ", type=" + type + ", operator=" + operator + ", account="
				+ account + "]";
	}

}
