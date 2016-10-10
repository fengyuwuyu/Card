package com.cecep.model;

import org.springframework.util.DigestUtils;

import it.sauronsoftware.base64.Base64;


public class UserAccount {
    private String uid;//帐号

    private String sn;//员工号

    private String cn;//中文名

    private String pwd;//密码

    private String uugender;//性别

    private String minzu;//民族

    private String uuidentitynumber;//身份证号

    private String uubirthday;//出生日期

    private String countrycity;//国籍

    private String department;//所属HR组织代码

    private String nbdwcode;//所属行政组织代码

    private String nbdwname;//所属行政组织名称

    private String uuposition;//职位

    private String uuemployeelevel;//职级

    private String grsf;//个人身份

    private String rylb;//人员类别

    private String uuaccountstatus;//员工状态

    private String uuusersigntype;//员工类型

    private String officetel;//办公电话

    private String telephone;//移动电话

    private String email;//电子邮箱
    
    private String is_synchronized;//是否同步  0是未同步，1 是已同步
    

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn == null ? null : cn.trim();
    }

    public String getPwd() {
    	return (Base64.decode(pwd) == null) ? null : DigestUtils.md5DigestAsHex(Base64.decode(pwd).getBytes());
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getUugender() {
        return uugender;
    }

    public void setUugender(String uugender) {
        this.uugender = uugender == null ? null : uugender.trim();
    }

    public String getMinzu() {
        return minzu;
    }

    public void setMinzu(String minzu) {
        this.minzu = minzu == null ? null : minzu.trim();
    }

    public String getUuidentitynumber() {
        return uuidentitynumber;
    }

    public void setUuidentitynumber(String uuidentitynumber) {
        this.uuidentitynumber = uuidentitynumber == null ? null : uuidentitynumber.trim();
    }

    public String getUubirthday() {
        return uubirthday;
    }

    public void setUubirthday(String uubirthday) {
        this.uubirthday = uubirthday == null ? null : uubirthday.trim();
    }

    public String getCountrycity() {
        return countrycity;
    }

    public void setCountrycity(String countrycity) {
        this.countrycity = countrycity == null ? null : countrycity.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getNbdwcode() {
        return nbdwcode;
    }

    public void setNbdwcode(String nbdwcode) {
        this.nbdwcode = nbdwcode == null ? null : nbdwcode.trim();
    }

    public String getNbdwname() {
        return nbdwname;
    }

    public void setNbdwname(String nbdwname) {
        this.nbdwname = nbdwname == null ? null : nbdwname.trim();
    }

    public String getUuposition() {
        return uuposition;
    }

    public void setUuposition(String uuposition) {
        this.uuposition = uuposition == null ? null : uuposition.trim();
    }

    public String getUuemployeelevel() {
        return uuemployeelevel;
    }

    public void setUuemployeelevel(String uuemployeelevel) {
        this.uuemployeelevel = uuemployeelevel == null ? null : uuemployeelevel.trim();
    }

    public String getGrsf() {
        return grsf;
    }

    public void setGrsf(String grsf) {
        this.grsf = grsf == null ? null : grsf.trim();
    }

    public String getRylb() {
        return rylb;
    }

    public void setRylb(String rylb) {
        this.rylb = rylb == null ? null : rylb.trim();
    }

    public String getUuaccountstatus() {
        return uuaccountstatus;
    }

    public void setUuaccountstatus(String uuaccountstatus) {
        this.uuaccountstatus = uuaccountstatus == null ? null : uuaccountstatus.trim();
    }

    public String getUuusersigntype() {
        return uuusersigntype;
    }

    public void setUuusersigntype(String uuusersigntype) {
        this.uuusersigntype = uuusersigntype == null ? null : uuusersigntype.trim();
    }

    public String getOfficetel() {
        return officetel;
    }

    public void setOfficetel(String officetel) {
        this.officetel = officetel == null ? null : officetel.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

	public String getIs_synchronized() {
		return is_synchronized;
	}

	public void setIs_synchronized(String is_synchronized) {
		this.is_synchronized = is_synchronized;
	}
    
    
}