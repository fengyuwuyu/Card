package com.cecep.model;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 消费时段实体类(xf_time表)
 * 
 * @date 2016-03-21
 * */
public class XfTime extends PageModel {

	private String bh;//时段编号(16位整数组成年月日时分秒+2位随机数)
	private Time kssj;
	private Time jssj;
	private Integer dayOffset;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date sj;
	private String glyNo;
	private String devSerial;
	private Integer dayOrder;
	private String lname;
	private String regserial;
	@JsonIgnore
	private Integer kssjI;
	@JsonIgnore
	private Integer jssjI;
	
	

	public XfTime() {
	}

	public String getBh() {
		return bh;
	}

	public void setBh(String bh) {
		this.bh = bh == null ? null : bh.trim();
	}

	public void setKssjI(Integer kssjI) {
		this.kssjI = kssjI;
	}

	public void setJssjI(Integer jssjI) {
		this.jssjI = jssjI;
	}

	public Integer getKssjI() {
		return (int) (kssj.getTime()/1000+8 * 3600);
	}

	public Integer getJssjI() {
		return (int) (jssj.getTime()/1000+8 * 3600);
	}

	public Time getKssj() {
		if(kssjI==null){
			return null;
		}
		Time time = new Time((kssjI - 8 * 3600) * 1000);
		return time;
	}

	public void setKssj(Time kssj) {
		this.kssj = kssj;
	}

	public Time getJssj() {
		if(kssjI==null){
			return null;
		}
		Time time = new Time((jssjI - 8 * 3600) * 1000);
		return time;
	}

	public void setJssj(Time jssj) {
		this.jssj = jssj;
	}

	public Integer getDayOffset() {
		return dayOffset;
	}

	public void setDayOffset(Integer dayOffset) {
		this.dayOffset = dayOffset;
	}

	public Date getSj() {
		return sj==null?new Date():sj;
	}

	public void setSj(Date sj) {
		this.sj = sj;
	}

	public String getGlyNo() {
		return glyNo;
	}

	public void setGlyNo(String glyNo) {
		this.glyNo = glyNo == null ? null : glyNo.trim();
	}

	public String getDevSerial() {
		return devSerial;
	}

	public void setDevSerial(String devSerial) {
		this.devSerial = devSerial == null ? null : devSerial.trim();
	}

	public Integer getDayOrder() {
		return dayOrder;
	}

	public void setDayOrder(Integer dayOrder) {
		this.dayOrder = dayOrder;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname == null ? null : lname.trim();
	}

	public String getRegserial() {
		return regserial;
	}

	public void setRegserial(String regserial) {
		this.regserial = regserial == null ? null : regserial.trim();
	}
}