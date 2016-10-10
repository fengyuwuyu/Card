package com.cecep.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 门禁规则实体类(mj_rule_real表)
 * @date 2016-03-21
 * */
public class MjRuleReal {
	
    private Integer ruleNo;
    private String ruleName;
    private Integer ruleCount;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date sj;
    private String glyNo;
    private String regserial;
    
    public Integer getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(Integer ruleNo) {
        this.ruleNo = ruleNo;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    public Integer getRuleCount() {
        return ruleCount;
    }

    public void setRuleCount(Integer ruleCount) {
        this.ruleCount = ruleCount;
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

    public String getRegserial() {
        return regserial;
    }

    public void setRegserial(String regserial) {
        this.regserial = regserial == null ? null : regserial.trim();
    }
}