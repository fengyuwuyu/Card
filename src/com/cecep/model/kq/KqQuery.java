package com.cecep.model.kq;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.Set;

import com.cecep.model.PageModel;

/**
 * 用于封装统计分析页面查询表单参数
 * 
 * @author lilei
 * 
 */
@SuppressWarnings("deprecation")
public class KqQuery extends PageModel {

	/** 部门id */
	private Integer[] depSerial;
	private Set<Long> depSerials;
	private Integer userDep;
	/** 上级部门id */
	private Integer serial;
	/** 员工姓名 */
	private String username;
	/** 员工号 */
	private String userNo;
	/** 开始时间 */
	private Date kssj;
	/** 结束时间 */
	private Date jssj;
	/** 个人考勤说明 */
	private int kqDescribe;
	/** 上班时间 */
	private Time sbsj = new Time(9, 5, 0);
	/** 下班时间 */
	private Time xbsj = new Time(16, 55, 0);
	/** 统计类型;1表示迟到早退，2表示加班 */
	private int type;
	/** 查询类型 */
	private int queryType;

	private Integer userSerial;
	/** 迟到早退等日期 */
	private String dates;

	private String[] timeArray;
	private Integer personal;

	public Integer getUserDep() {
		return userDep;
	}

	public void setUserDep(Integer userDep) {
		this.userDep = userDep;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo == null ? null : userNo.trim();
	}

	public Integer getPersonal() {
		return personal;
	}

	public void setPersonal(Integer personal) {
		this.personal = personal;
	}

	public Set<Long> getDepSerials() {
		return depSerials;
	}

	public void setDepSerials(Set<Long> depSerials) {
		this.depSerials = depSerials;
	}

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public String[] getTimeArray() {
		return timeArray;
	}

	public void setTimeArray(String[] timeArray) {
		this.timeArray = timeArray;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates == null ? null : dates.trim();
	}

	public Integer getUserSerial() {
		return userSerial;
	}

	public void setUserSerial(Integer userSerial) {
		this.userSerial = userSerial;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = (username == null || "".equals(username)) ? null
				: username.trim();
	}

	public Date getKssj() {
		return kssj;
	}

	public void setKssj(Date kssj) {
		if (kssj != null)
			this.kssj = kssj;
	}

	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		if (jssj != null)
			this.jssj = jssj;
	}

	public int getHasDescribe() {
		return kqDescribe;
	}

	public void setHasDescribe(int kqDescribe) {
		this.kqDescribe = kqDescribe;
	}

	public int getKqDescribe() {
		return kqDescribe;
	}

	public void setKqDescribe(int kqDescribe) {
		this.kqDescribe = kqDescribe;
	}

	public Time getSbsj() {
		return sbsj;
	}

	public void setSbsj(String sbsj) {
		if (sbsj == null) {
			return;
		}
		String[] ss = sbsj.trim().split(":");
		int hour = Integer.parseInt(ss[0]);
		int minute = Integer.parseInt(ss[1]);
		int second = Integer.parseInt(ss[2]);
		this.sbsj = new Time(hour, minute, second);
	}

	public Time getXbsj() {
		return xbsj;
	}

	public void setXbsj(String xbsj) {
		if (xbsj == null) {
			return;
		}
		String[] ss = xbsj.trim().split(":");
		int hour = Integer.parseInt(ss[0]);
		int minute = Integer.parseInt(ss[1]);
		int second = Integer.parseInt(ss[2]);
		this.xbsj = new Time(hour, minute, second);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Integer[] getDepSerial() {
		return depSerial;
	}

	public int getQueryType() {
		return queryType;
	}

	public void setQueryType(int queryType) {
		this.queryType = queryType;
	}

	public void setDepSerial(String depSerial) {
		if (depSerial != null && !"".equals(depSerial)) {
			String[] temp = depSerial.trim().split(",");
			this.depSerial = new Integer[temp.length];
			for (int i = 0; i < temp.length; i++) {
				this.depSerial[i] = Integer.valueOf(temp[i]);
			}
		}
	}

	@Override
	public String toString() {
		return "KqQuery [depSerial=" + Arrays.toString(depSerial)
				+ ", depSerials=" + depSerials + ", userDep=" + userDep
				+ ", serial=" + serial + ", username=" + username + ", userNo="
				+ userNo + ", kssj=" + kssj + ", jssj=" + jssj
				+ ", kqDescribe=" + kqDescribe + ", sbsj=" + sbsj + ", xbsj="
				+ xbsj + ", type=" + type + ", queryType=" + queryType
				+ ", userSerial=" + userSerial + ", dates=" + dates
				+ ", timeArray=" + Arrays.toString(timeArray) + ", personal="
				+ personal + "]";
	}

}
