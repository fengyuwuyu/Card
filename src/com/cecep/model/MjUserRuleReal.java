package com.cecep.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 门授权记录实体类(mj_user_rule_real表)
 * @date 2016-03-21
 * */
public class MjUserRuleReal extends PageModel {
	
    private Integer xh;
    private Long userSerial;
    private String gateBh;
    private Integer fx;
    private Integer ruleNo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date sj;
    private String glyNo;
    
    /**
     * 关联属性
     * */
    private String userLname;//人员姓名
    private String ruleName;//规则名称
    private String doorName;//门名称
    private Long depSerial;//部门序号
    private String depName;//部门名称   
    private Integer acDepSerial;//场所序号
    private String acDepName;//场所名称
      
    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public Long getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    public String getGateBh() {
        return gateBh;
    }

    public void setGateBh(String gateBh) {
        this.gateBh = gateBh == null ? null : gateBh.trim();
    }

    public Integer getFx() {
        return fx;
    }

    public void setFx(Integer fx) {
        this.fx = fx;
    }

    public Integer getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(Integer ruleNo) {
        this.ruleNo = ruleNo;
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

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname == null ? null : userLname.trim();
	}

	public String getDoorName() {
		return doorName;
	}

	public void setDoorName(String doorName) {
		this.doorName = doorName == null ? null : doorName.trim();
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName == null ? null : ruleName.trim();
	}

	public Long getDepSerial() {
		return depSerial;
	}

	public void setDepSerial(Long depSerial) {
		this.depSerial = depSerial;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName == null ? null : depName.trim();
	}

	public Integer getAcDepSerial() {
		return acDepSerial;
	}

	public void setAcDepSerial(Integer acDepSerial) {
		this.acDepSerial = acDepSerial;
	}

	public String getAcDepName() {
		return acDepName;
	}

	public void setAcDepName(String acDepName) {
		this.acDepName = acDepName == null ? null : acDepName.trim();
	}

	@Override
	public String toString() {
		return "MjUserRuleReal [xh=" + xh + ", userSerial=" + userSerial
				+ ", gateBh=" + gateBh + ", fx=" + fx + ", ruleNo=" + ruleNo
				+ ", sj=" + sj + ", glyNo=" + glyNo + ", userLname="
				+ userLname + ", ruleName=" + ruleName + ", doorName="
				+ doorName + ", depSerial=" + depSerial + ", depName="
				+ depName + ", acDepSerial=" + acDepSerial + ", acDepName="
				+ acDepName + "]";
	}

    
    
}