package com.cecep.model.mess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cecep.model.PageModel;
import com.cecep.model.XfTime;

public class Region extends PageModel {

	private Integer depSerial;
	private String depNo;
	private String depName;
	private Integer depParent;
	private String parentName;
	private String state;
	private Integer depOrder;
	/** 1:普通场所，2： */
	private int depType;
	private List<XfTime> times = new ArrayList<XfTime>();
	private Date sj;
	private String moduleId;

	public Integer getDepOrder() {
		return depOrder;
	}

	public void setDepOrder(Integer depOrder) {
		this.depOrder = depOrder;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getDepSerial() {
		return depSerial;
	}

	public void setDepSerial(Integer depSerial) {
		this.depSerial = depSerial;
	}

	public String getDepNo() {
		return depNo;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName == null ? null : depName.trim();
	}

	public void setDepNo(String depNo) {
		this.depNo = depNo == null ? null : depNo.trim();
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName == null ? null : parentName.trim();
	}

	public String getTimes() {
		if (times == null || times.size() == 0) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < times.size(); i++) {
			builder.append(times.get(i).getLname());
			if (i != times.size() - 1) {
				builder.append("，");
			}
		}
		return builder.toString();
	}

	public void setTimes(XfTime times) {
		this.times.add(times);
	}

	public Date getSj() {
		return sj;
	}

	public void setSj(Date sj) {
		this.sj = sj;
	}

	public Integer getDepParent() {
		return depParent;
	}

	public void setDepParent(Integer depParent) {
		this.depParent = depParent;
	}

	public int getDepType() {
		return depType;
	}

	public void setDepType(int depType) {
		this.depType = depType;
	}

	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	@Override
	public String toString() {
		return "Region [depSerial=" + depSerial + ", depNo=" + depNo
				+ ", depName=" + depName + ", depParent=" + depParent
				+ ", parentName=" + parentName + ", state=" + state
				+ ", depOrder=" + depOrder + ", depType=" + depType
				+ ", times=" + times + ", sj=" + sj + ", moduleId=" + moduleId
				+ "]";
	}

}
