package com.cecep.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 账户类型消费时段中间表实体类(xf_ac_time表)
 * @date 2016-03-21
 * */
public class XfAcTime extends PageModel {
	
    private Integer xh;
    private String devSerial;
    private String acType;
    private Integer timeMaxM;
    private Integer timeMaxT;
    private Integer dayOrder;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date sj;
    private String glyNo;
    private String timeNo;
    private Integer lx;
    private Integer dayOffset;
    private Integer acdepSerial;
    private BigDecimal timeSub;
    private Integer discountRate;
    private Integer timeLimit;
    private Integer eachUnit;
    private String regserial;
    private Integer isTimeout;
    private Integer timeoutRate;
    private Integer acTimeMould;
    private Integer acSubAuto;
    private Integer timeEachsub;
    
    /**
     * 关联属性
     * */
    private String acName;//账户类型名称
    private String lname;//时段名称
    
    
    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getDevSerial() {
        return devSerial;
    }

    public void setDevSerial(String devSerial) {
        this.devSerial = devSerial == null ? null : devSerial.trim();
    }

    public String getAcType() {
        return acType;
    }

    public void setAcType(String acType) {
        this.acType = acType == null ? null : acType.trim();
    }

    public Integer getTimeMaxM() {
        return timeMaxM;
    }

    public void setTimeMaxM(Integer timeMaxM) {
        this.timeMaxM = timeMaxM;
    }

    public Integer getTimeMaxT() {
        return timeMaxT;
    }

    public void setTimeMaxT(Integer timeMaxT) {
        this.timeMaxT = timeMaxT;
    }

    public Integer getDayOrder() {
        return dayOrder;
    }

    public void setDayOrder(Integer dayOrder) {
        this.dayOrder = dayOrder;
    }

    public Date getSj() {
        return sj;
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

    public String getTimeNo() {
        return timeNo;
    }

    public void setTimeNo(String timeNo) {
        this.timeNo = timeNo == null ? null : timeNo.trim();
    }

    public Integer getLx() {
        return lx;
    }

    public void setLx(Integer lx) {
        this.lx = lx;
    }

    public Integer getDayOffset() {
        return dayOffset;
    }

    public void setDayOffset(Integer dayOffset) {
        this.dayOffset = dayOffset;
    }

    public Integer getAcdepSerial() {
        return acdepSerial;
    }

    public void setAcdepSerial(Integer acdepSerial) {
        this.acdepSerial = acdepSerial;
    }

    public BigDecimal getTimeSub() {
        return timeSub;
    }

    public void setTimeSub(BigDecimal timeSub) {
        this.timeSub = timeSub;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getEachUnit() {
        return eachUnit;
    }

    public void setEachUnit(Integer eachUnit) {
        this.eachUnit = eachUnit;
    }

    public String getRegserial() {
        return regserial;
    }

    public void setRegserial(String regserial) {
        this.regserial = regserial == null ? null : regserial.trim();
    }

    public Integer getIsTimeout() {
        return isTimeout;
    }

    public void setIsTimeout(Integer isTimeout) {
        this.isTimeout = isTimeout;
    }

    public Integer getTimeoutRate() {
        return timeoutRate;
    }

    public void setTimeoutRate(Integer timeoutRate) {
        this.timeoutRate = timeoutRate;
    }

    public Integer getAcTimeMould() {
        return acTimeMould;
    }

    public void setAcTimeMould(Integer acTimeMould) {
        this.acTimeMould = acTimeMould;
    }

    public Integer getAcSubAuto() {
        return acSubAuto;
    }

    public void setAcSubAuto(Integer acSubAuto) {
        this.acSubAuto = acSubAuto;
    }

    public Integer getTimeEachsub() {
        return timeEachsub;
    }

    public void setTimeEachsub(Integer timeEachsub) {
        this.timeEachsub = timeEachsub;
    }

	public String getAcName() {
		return acName;
	}

	public void setAcName(String acName) {
		this.acName = acName == null ? null : acName.trim();
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname == null ? null : lname.trim();
	}
    
}