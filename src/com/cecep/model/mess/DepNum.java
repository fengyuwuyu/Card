package com.cecep.model.mess;

public class DepNum {

	private Long depSerial;// 部门序号
	private String depParent;// 父级部门名称
	private String depName;// 部门名称
	private String depNo;// 部门编号
	/** 该部门可用餐人数 */
	private int num;

	public Long getDepSerial() {
		return depSerial;
	}

	public void setDepSerial(Long depSerial) {
		this.depSerial = depSerial;
	}

	public String getDepParent() {
		return depParent;
	}

	public void setDepParent(String depParent) {
		this.depParent = depParent==null?null:depParent.trim();
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName==null?null:depName.trim();
	}

	public String getDepNo() {
		return depNo;
	}

	public void setDepNo(String depNo) {
		this.depNo = depNo==null?null:depNo.trim();
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "DepNum [depSerial=" + depSerial + ", depParent=" + depParent
				+ ", depName=" + depName + ", depNo=" + depNo + ", num=" + num
				+ "]";
	}

}
