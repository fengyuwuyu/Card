package com.cecep.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 场所实体类(dt_ac_dep表)
 * @date 2016-03-21
 * */
public class DtAcDep extends PageModel {
	
    private Integer depSerial;
    private Integer depParent;
    private Integer depOrder;
    private String depName;
    private String depNo;
    private String depRule;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date sj;
    private String moduleId;
    private Integer depType;
    private String regserial;
    private Integer depState;
    private Integer depLx;
    private Integer depPlace;
    private Integer depXPoint;
    private Integer depYPoint;
    private Integer depLock;
    private Integer depSex;
    private Integer depFloor;
    private String depNumber;
    
    /**
     * 关联属性
     * */
    private String state;
    private Integer count;
    

    public Integer getDepSerial() {
        return depSerial;
    }

    public void setDepSerial(Integer depSerial) {
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

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId == null ? null : moduleId.trim();
    }

    public Integer getDepType() {
        return depType;
    }

    public void setDepType(Integer depType) {
        this.depType = depType;
    }

    public String getRegserial() {
        return regserial;
    }

    public void setRegserial(String regserial) {
        this.regserial = regserial == null ? null : regserial.trim();
    }

    public Integer getDepState() {
        return depState;
    }

    public void setDepState(Integer depState) {
        this.depState = depState;
    }

    public Integer getDepLx() {
        return depLx;
    }

    public void setDepLx(Integer depLx) {
        this.depLx = depLx;
    }

    public Integer getDepPlace() {
        return depPlace;
    }

    public void setDepPlace(Integer depPlace) {
        this.depPlace = depPlace;
    }

    public Integer getDepXPoint() {
        return depXPoint;
    }

    public void setDepXPoint(Integer depXPoint) {
        this.depXPoint = depXPoint;
    }

    public Integer getDepYPoint() {
        return depYPoint;
    }

    public void setDepYPoint(Integer depYPoint) {
        this.depYPoint = depYPoint;
    }

    public Integer getDepLock() {
        return depLock;
    }

    public void setDepLock(Integer depLock) {
        this.depLock = depLock;
    }

    public Integer getDepSex() {
        return depSex;
    }

    public void setDepSex(Integer depSex) {
        this.depSex = depSex;
    }

    public Integer getDepFloor() {
        return depFloor;
    }

    public void setDepFloor(Integer depFloor) {
        this.depFloor = depFloor;
    }

    public String getDepNumber() {
        return depNumber;
    }

    public void setDepNumber(String depNumber) {
        this.depNumber = depNumber == null ? null : depNumber.trim();
    }

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}
    
    
}