package com.cecep.model;

/**
 * 部门类(dt_dep表)
 * 
 * @date 2016-03-16
 * */
public class DtDep extends PageModel {

	private Long depSerial;// 部门序号
	private Integer depParent;// 父级部门序号
	private Integer depOrder;// 同级顺序、排序
	private String depName;// 部门名称
	private String depNo;// 部门编号
	private String depRule;// 规则
	private String depRegserial;
	private String acdepSerial;
	private Integer extend;

	/**
	 * 关联属性
	 * */
	private String state;
	private Integer total;
	private Integer count;

	public Integer getExtend() {
		return extend;
	}

	public void setExtend(Integer extend) {
		this.extend = extend;
	}

	public Long getDepSerial() {
		return depSerial;
	}

	public void setDepSerial(Long depSerial) {
		this.depSerial = depSerial;
	}

	public Integer getDepParent() {
		return depParent;
	}

	public void setDepParent(Integer depParent) {
		this.depParent = depParent;
	}

	public Integer getDepOrder() {
		return depOrder;
	}

	public void setDepOrder(Integer depOrder) {
		this.depOrder = depOrder;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName == null ? null : depName.trim();
	}

	public String getDepNo() {
		return depNo;
	}

	public void setDepNo(String depNo) {
		this.depNo = depNo == null ? null : depNo.trim();
	}

	public String getDepRule() {
		return depRule;
	}

	public void setDepRule(String depRule) {
		this.depRule = depRule == null ? null : depRule.trim();
	}

	public String getDepRegserial() {
		return depRegserial;
	}

	public void setDepRegserial(String depRegserial) {
		this.depRegserial = depRegserial == null ? null : depRegserial.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getAcdepSerial() {
		return acdepSerial;
	}

	public void setAcdepSerial(String acdepSerial) {
		this.acdepSerial = acdepSerial;
	}

	@Override
	public String toString() {
		return "DtDep [depSerial=" + depSerial + ", depParent=" + depParent
				+ ", depOrder=" + depOrder + ", depName=" + depName
				+ ", depNo=" + depNo + ", depRule=" + depRule
				+ ", depRegserial=" + depRegserial + ", acdepSerial="
				+ acdepSerial + ", extend=" + extend + ", state=" + state
				+ ", total=" + total + ", count=" + count + "]";
	}

}