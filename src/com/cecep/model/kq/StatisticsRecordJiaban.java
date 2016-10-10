package com.cecep.model.kq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cecep.util.KqStatisticsUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 考勤统计记录
 * 
 * @author lilei
 * 
 */
public class StatisticsRecordJiaban {

	/** 员工姓名 */
	private String username;
	// /** 员工卡号 */
	// private String userNo;
	/** 员工编号 */
	private int userSerial;
	/** 卡序列号 */
	private String cardSerial;
	/** 部门名称 */
	private String depName;
	/** 一段时间内的打卡记录 */
	@JsonIgnore
	private List<KqRecord> kqRecords;
	/** 加班次数 */
	private int jbCount;
	/** 加班日期 */
	private StringBuilder jbTimes = new StringBuilder();
	/** 加班考勤记录编号 */
	@JsonIgnore
	private Map<String, List<KqRecord>> recordsByHoliday = new TreeMap<String, List<KqRecord>>();

	public void statistics(int personNum) {
		if (kqRecords == null||kqRecords.size()==0) {
			return ;
		}
		for (KqRecord record : kqRecords) {
			Date sj = record.getSj();
			String formatDate = KqStatisticsUtil.formatDateToString1(sj);
			if (recordsByHoliday.get(formatDate) == null) {
				ArrayList<KqRecord> list = new ArrayList<KqRecord>();
				recordsByHoliday.put(formatDate, list);
			}
			recordsByHoliday.get(formatDate).add(record);
		}
		int format = 1;
		for (String s : recordsByHoliday.keySet()) {
			this.jbCount++;
			this.jbTimes.append(s + ",");
			if(format==2){
				this.jbTimes.append("<br>");
				format=0;
			}
			format++;
			personNum++;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username==null?null:username.trim();
	}

	public int getUserSerial() {
		return userSerial;
	}

	public void setUserSerial(int userSerial) {
		this.userSerial = userSerial;
	}

	public String getCardSerial() {
		return cardSerial;
	}

	public void setCardSerial(String cardSerial) {
		this.cardSerial = cardSerial;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName==null?null:depName.trim();
	}

	public List<KqRecord> getKqRecords() {
		return kqRecords;
	}

	public void setKqRecords(List<KqRecord> kqRecords) {
		this.kqRecords = kqRecords;
	}

	public int getJbCount() {
		return jbCount;
	}

	public void setJbCount(int jbCount) {
		this.jbCount = jbCount;
	}

	public String getJbTimes() {
		return KqStatisticsUtil.subLastChar(this.jbTimes);
	}

	@Override
	public String toString() {
		return "StatisticsRecordJiaban [username=" + username + ", userSerial="
				+ userSerial + ", cardSerial=" + cardSerial + ", depName="
				+ depName + ", kqRecords=" + kqRecords + ", jbCount=" + jbCount
				+ ", jbTimes=" + jbTimes + "]";
	}

}
