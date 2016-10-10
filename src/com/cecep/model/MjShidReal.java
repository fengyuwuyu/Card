package com.cecep.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 门禁时段实体类(mj_shid_real表)
 * @date 2016-03-21
 * */
public class MjShidReal extends PageModel {
	
    private Integer bh;
    private String sdName;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date kssj;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date jssj;
    private Integer ksMonth;
    private Integer jsMonth;
    private Integer ksDay;
    private Integer jsDay;
    private Integer ksWeek;
    private Integer jsWeek;
    private String ksSj1;
    private String jsSj1;
    private String ksSj2;
    private String jsSj2;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date sj;
    private String glyNo;
    private String ksSj3;
    private String jsSj3;
    private String ksSj4;
    private String jsSj4;
    private String regserial;
    
    /**
     * 关联属性
     * */
    private String ruleName;//规则名称
    

    public Integer getBh() {
        return bh;
    }

    public void setBh(Integer bh) {
        this.bh = bh;
    }

    public String getSdName() {
        return sdName;
    }

    public void setSdName(String sdName) {
        this.sdName = sdName == null ? null : sdName.trim();
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

    public Integer getKsMonth() {
        return ksMonth;
    }

    public void setKsMonth(Integer ksMonth) {
        this.ksMonth = ksMonth;
    }

    public Integer getJsMonth() {
        return jsMonth;
    }

    public void setJsMonth(Integer jsMonth) {
        this.jsMonth = jsMonth;
    }

    public Integer getKsDay() {
        return ksDay;
    }

    public void setKsDay(Integer ksDay) {
        this.ksDay = ksDay;
    }

    public Integer getJsDay() {
        return jsDay;
    }

    public void setJsDay(Integer jsDay) {
        this.jsDay = jsDay;
    }

    public Integer getKsWeek() {
        return ksWeek;
    }

    public void setKsWeek(Integer ksWeek) {
        this.ksWeek = ksWeek;
    }

    public Integer getJsWeek() {
        return jsWeek;
    }

    public void setJsWeek(Integer jsWeek) {
        this.jsWeek = jsWeek;
    }

    public String getKsSj1() {
        return ksSj1;
    }

    public void setKsSj1(String ksSj1) {
        this.ksSj1 = ksSj1 == null ? null : ksSj1.trim();
    }

    public String getJsSj1() {
        return jsSj1;
    }

    public void setJsSj1(String jsSj1) {
        this.jsSj1 = jsSj1 == null ? null : jsSj1.trim();
    }

    public String getKsSj2() {
        return ksSj2;
    }

    public void setKsSj2(String ksSj2) {
        this.ksSj2 = ksSj2 == null ? null : ksSj2.trim();
    }

    public String getJsSj2() {
        return jsSj2;
    }

    public void setJsSj2(String jsSj2) {
        this.jsSj2 = jsSj2 == null ? null : jsSj2.trim();
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

    public String getKsSj3() {
        return ksSj3;
    }

    public void setKsSj3(String ksSj3) {
        this.ksSj3 = ksSj3 == null ? null : ksSj3.trim();
    }

    public String getJsSj3() {
        return jsSj3;
    }

    public void setJsSj3(String jsSj3) {
        this.jsSj3 = jsSj3 == null ? null : jsSj3.trim();
    }

    public String getKsSj4() {
        return ksSj4;
    }

    public void setKsSj4(String ksSj4) {
        this.ksSj4 = ksSj4 == null ? null : ksSj4.trim();
    }

    public String getJsSj4() {
        return jsSj4;
    }

    public void setJsSj4(String jsSj4) {
        this.jsSj4 = jsSj4 == null ? null : jsSj4.trim();
    }

    public String getRegserial() {
        return regserial;
    }

    public void setRegserial(String regserial) {
        this.regserial = regserial == null ? null : regserial.trim();
    }

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName == null ? null : ruleName.trim();
	}
    
    
}