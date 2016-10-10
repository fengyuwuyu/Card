package com.cecep.model.mess;

import java.sql.Date;
import java.util.Arrays;
import java.util.Set;

import com.cecep.model.PageModel;

public class MessQuery extends PageModel {

	/** 部门编号 */
	private Long[] depSerial;
	/** 区域编号 */
	private String[] depNo;
	/** 机器编号 */
	private String[] machineBh;
	/** 员工姓名 */
	private String username;
	/** 员工工号 */
	private String userNo;
	private Date kssj;
	private Date jssj;
	/** 餐类编号 */
	private String type;
	/** 统计类型 */
	private int statisticType = 1;
	/** 是否按天统计 */
	private String byDay;
	private Integer personal;

	private Long depSerialSingle;
	private Set<Long> depSerials;

	public Integer getPersonal() {
		return personal;
	}

	public void setPersonal(Integer personal) {
		this.personal = personal;
	}

	public Long[] getDepSerial() {
		return depSerial;
	}

	public void setDepSerial(String depSerial) {
		if (depSerial != null && !"".equals(depSerial)) {
			String[] temp = depSerial.split(",");
			this.depSerial = new Long[temp.length];
			for (int i = 0; i < temp.length; i++) {
				this.depSerial[i] = Long.valueOf(temp[i]);
			}
		}
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String[] getDepNo() {
		return depNo;
	}

	public void setDepNo(String[] depNo) {
		this.depNo = depNo;
	}

	public String[] getMachineBh() {
		return machineBh;
	}

	public void setMachineBh(String[] machineBh) {
		this.machineBh = machineBh;
	}

	public Date getKssj() {
		return kssj;
	}

	public void setKssj(Date kssj) {
		this.kssj = kssj;
	}

	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public int getStatisticType() {
		return statisticType;
	}

	public void setStatisticType(int statisticType) {
		this.statisticType = statisticType;
	}

	public Long getDepSerialSingle() {
		return depSerialSingle;
	}

	public void setDepSerialSingle(Long depSerialSingle) {
		this.depSerialSingle = depSerialSingle;
	}

	public Set<Long> getDepSerials() {
		return depSerials;
	}

	public void setDepSerials(Set<Long> depSerials) {
		this.depSerials = depSerials;
	}

	public String getByDay() {
		return byDay;
	}

	public void setByDay(String byDay) {
		this.byDay = byDay == null ? null : byDay.trim();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((depNo == null) ? 0 : depNo.hashCode());
		result = prime * result + Arrays.hashCode(depSerial);
		result = prime * result + ((jssj == null) ? 0 : jssj.hashCode());
		result = prime * result + ((kssj == null) ? 0 : kssj.hashCode());
		result = prime * result
				+ ((machineBh == null) ? 0 : machineBh.hashCode());
		result = prime * result + statisticType;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessQuery other = (MessQuery) obj;
		if (depNo == null) {
			if (other.depNo != null)
				return false;
		} else if (!depNo.equals(other.depNo))
			return false;
		if (!Arrays.equals(depSerial, other.depSerial))
			return false;
		if (jssj == null) {
			if (other.jssj != null)
				return false;
		} else if (!jssj.equals(other.jssj))
			return false;
		if (kssj == null) {
			if (other.kssj != null)
				return false;
		} else if (!kssj.equals(other.kssj))
			return false;
		if (machineBh == null) {
			if (other.machineBh != null)
				return false;
		} else if (!machineBh.equals(other.machineBh))
			return false;
		if (statisticType != other.statisticType)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MessQuery [depSerial=" + Arrays.toString(depSerial)
				+ ", depNo=" + Arrays.toString(depNo) + ", machineBh="
				+ Arrays.toString(machineBh) + ", username=" + username
				+ ", userNo=" + userNo + ", kssj=" + kssj + ", jssj=" + jssj
				+ ", type=" + type + ", statisticType=" + statisticType
				+ ", byDay=" + byDay + ", personal=" + personal
				+ ", depSerialSingle=" + depSerialSingle + ", depSerials="
				+ depSerials + "]";
	}

}
