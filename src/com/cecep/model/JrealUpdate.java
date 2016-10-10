package com.cecep.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 门通讯日志实体类(jreal_update_1表)
 * @date 2016-03-21
 * */
public class JrealUpdate {
	
    private Integer jsig;
    private Integer jdevId;
    private String jdevBh;
    private Integer jdodata;
    private Integer juserId;
    private String jdataStr;
    private Integer jextType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date jtime;
    private String joperator;
    private String jipAddr;

    public Integer getJsig() {
        return jsig;
    }

    public void setJsig(Integer jsig) {
        this.jsig = jsig;
    }

    public Integer getJdevId() {
        return jdevId;
    }

    public void setJdevId(Integer jdevId) {
        this.jdevId = jdevId;
    }

    public String getJdevBh() {
        return jdevBh;
    }

    public void setJdevBh(String jdevBh) {
        this.jdevBh = jdevBh == null ? null : jdevBh.trim();
    }

    public Integer getJdodata() {
        return jdodata;
    }

    public void setJdodata(Integer jdodata) {
        this.jdodata = jdodata;
    }

    public Integer getJuserId() {
        return juserId;
    }

    public void setJuserId(Integer juserId) {
        this.juserId = juserId;
    }

    public String getJdataStr() {
        return jdataStr;
    }

    public void setJdataStr(String jdataStr) {
        this.jdataStr = jdataStr == null ? null : jdataStr.trim();
    }

    public Integer getJextType() {
        return jextType;
    }

    public void setJextType(Integer jextType) {
        this.jextType = jextType;
    }

    public Date getJtime() {
        return jtime;
    }

    public void setJtime(Date jtime) {
        this.jtime = jtime;
    }

    public String getJoperator() {
        return joperator;
    }

    public void setJoperator(String joperator) {
        this.joperator = joperator == null ? null : joperator.trim();
    }

    public String getJipAddr() {
        return jipAddr;
    }

    public void setJipAddr(String jipAddr) {
        this.jipAddr = jipAddr == null ? null : jipAddr.trim();
    }
}