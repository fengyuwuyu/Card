package com.cecep.model;

public class CecepDep {

	private Integer id;
	private String depSerial;
	private String depName;
	private String parentId;
	private Integer isSynchronized = 0;
	private Integer extend = 0;
	private String acdepSerial;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepSerial() {
		return depSerial;
	}

	public void setDepSerial(String depSerial) {
		this.depSerial = depSerial;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getIsSynchronized() {
		return isSynchronized;
	}

	public void setIsSynchronized(Integer isSynchronized) {
		this.isSynchronized = isSynchronized;
	}

	public Integer getExtend() {
		return extend;
	}

	public void setExtend(Integer extend) {
		this.extend = extend;
	}

	public String getAcdepSerial() {
		return acdepSerial;
	}

	public void setAcdepSerial(String acdepSerial) {
		this.acdepSerial = acdepSerial;
	}

	@Override
	public String toString() {
		return "CecepDep [id=" + id + ", depSerial=" + depSerial + ", depName="
				+ depName + ", parentId=" + parentId + ", isSynchronized="
				+ isSynchronized + ", extend=" + extend + ", acdepSerial="
				+ acdepSerial + "]";
	}

}
