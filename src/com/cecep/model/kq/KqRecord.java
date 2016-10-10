package com.cecep.model.kq;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author lilei
 * 
 */
public class KqRecord {
	/** 员工姓名 */
	private String username;
	/** 所属部门 */
	private String depName;
	private Long userSerial;
	/** 员工卡号 */
	private String cardSerial;
	/** 刷卡方向 */
	private Short fx;
	/** 刷卡时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date sj;
	/** 刷卡日期 */
	private String date;
	/** 考勤记录编号 */
	private int bh;
	private Integer type = 0;
	/** 所属二级公司*/
	private String company;

	public KqRecord() {
	}

	public KqRecord(String username, String depName, String cardSerial,
			String date) {
		this.username = username;
		this.depName = depName;
		this.cardSerial = cardSerial;
		this.date = date;
	}

	/** 个人考勤异常类型：1：迟到，2：早退，3：未打卡*/
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Long getUserSerial() {
		return userSerial;
	}

	public void setUserSerial(Long userSerial) {
		this.userSerial = userSerial;
	}

	public Short getFx() {
		return fx;
	}

	public void setFx(Short fx) {
		this.fx = fx;
	}

	public Date getSj() {
		return sj;
	}

	public void setSj(Date sj) {
		this.sj = sj;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName == null ? null : depName.trim();
	}

	public String getCardSerial() {
		return cardSerial == null ? "" : cardSerial;
	}

	public void setCardSerial(String cardSerial) {
		this.cardSerial = cardSerial == null ? null : cardSerial.trim();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date == null ? null : date.trim();
	}

	public int getBh() {
		return bh;
	}

	public void setBh(int bh) {
		this.bh = bh;
	}

	@Override
	public String toString() {
		return "KqRecord [username=" + username + ", depName=" + depName
				+ ", cardSerial=" + cardSerial + ", fx=" + fx + ", sj=" + sj
				+ ", date=" + date + "]";
	}

}
