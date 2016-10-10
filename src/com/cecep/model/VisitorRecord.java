package com.cecep.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 访客记录实体类(visitor_record表)
 * @date 2016-03-21
 * */
public class VisitorRecord extends PageModel {
	
    private Long recordId;
    private Long userSerial;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;//开卡时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date enterTime;//进入时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date exitTime;//退出时间
    private String visitorReason;//来访是由
    private String visitorDep;//来访单位
    private String visitorUser;//来访人员
    private String visitorPhone;//来访人电话
    private String visitorDes;//来访备注
    
    /**
     * 关联属性
     * */    
    private String userLname;//姓名
    private String userSex;
    private String userNation;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date userBirthday;
    private String userAddress;
    private String userId;//身份证号
    private String userTelephone;
    private String userEmail;    
    private String userDuty;//职务
    private String userDepname;//部门名称   
    private String userBz;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date userSj;//操作变更时间

    
    
    public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress == null ? null : userAddress.trim();
	}

	public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(Long userSerial) {
        this.userSerial = userSerial;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public String getVisitorReason() {
        return visitorReason;
    }

    public void setVisitorReason(String visitorReason) {
        this.visitorReason = visitorReason == null ? null : visitorReason.trim();
    }

    public String getVisitorDep() {
        return visitorDep;
    }

    public void setVisitorDep(String visitorDep) {
        this.visitorDep = visitorDep == null ? null : visitorDep.trim();
    }

    public String getVisitorUser() {
        return visitorUser;
    }

    public void setVisitorUser(String visitorUser) {
        this.visitorUser = visitorUser == null ? null : visitorUser.trim();
    }

    public String getVisitorPhone() {
        return visitorPhone;
    }

    public void setVisitorPhone(String visitorPhone) {
        this.visitorPhone = visitorPhone == null ? null : visitorPhone.trim();
    }

    public String getVisitorDes() {
        return visitorDes;
    }

    public void setVisitorDes(String visitorDes) {
        this.visitorDes = visitorDes == null ? null : visitorDes.trim();
    }

    public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname == null ? null : userLname.trim();
	}

	public String getUserDepname() {
		return userDepname;
	}

	public void setUserDepname(String userDepname) {
		this.userDepname = userDepname == null ? null : userDepname.trim();
	}

	public String getUserDuty() {
		return userDuty;
	}

	public void setUserDuty(String userDuty) {
		this.userDuty = userDuty == null ? null : userDuty.trim();
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex == null ? null : userSex.trim();
	}

	public String getUserNation() {
		return userNation;
	}

	public void setUserNation(String userNation) {
		this.userNation = userNation == null ? null : userNation.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone == null ? null : userTelephone.trim();
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail == null ? null : userEmail.trim();
	}

	public String getUserBz() {
		return userBz;
	}

	public void setUserBz(String userBz) {
		this.userBz = userBz == null ? null : userBz.trim();
	}

	public Date getUserSj() {
		return userSj;
	}

	public void setUserSj(Date userSj) {
		this.userSj = userSj;
	}
    
    
}