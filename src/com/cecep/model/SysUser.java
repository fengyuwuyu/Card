package com.cecep.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SysUser extends PageModel {

	private Integer userId;
	private String userName;
	private String loginName;
	private String password;
	private String sex;
	private String email;
	private Integer orgId;
	private Integer depId;
	private Integer postId;
	private Integer roleId;
	private Integer userStatus;//状态
	private Integer userDeleted;//状态
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime;//添加时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date deleteTime;//删除时间
	private String userDes;//描述

	/**
	 * 关联属性
	 * */
	private String orgName;
	private String depName;
	private String postName;
	private String roleName;
	private Integer roleStatus;
	private Integer roleDeleted;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName == null ? null : loginName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getUserDeleted() {
		return userDeleted;
	}

	public void setUserDeleted(Integer userDeleted) {
		this.userDeleted = userDeleted;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getUserDes() {
		return userDes;
	}

	public void setUserDes(String userDes) {
		this.userDes = userDes == null ? null : userDes.trim();
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName == null ? null : orgName.trim();
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName == null ? null : depName.trim();
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName == null ? null : postName.trim();
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public Integer getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(Integer roleStatus) {
		this.roleStatus = roleStatus;
	}

	public Integer getRoleDeleted() {
		return roleDeleted;
	}

	public void setRoleDeleted(Integer roleDeleted) {
		this.roleDeleted = roleDeleted;
	}

	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", userName=" + userName
				+ ", loginName=" + loginName + ", password=" + password
				+ ", sex=" + sex + ", email=" + email + ", orgId=" + orgId
				+ ", depId=" + depId + ", postId=" + postId + ", roleId="
				+ roleId + ", userStatus=" + userStatus + ", userDeleted="
				+ userDeleted + ", createTime=" + createTime + ", deleteTime="
				+ deleteTime + ", userDes=" + userDes + ", orgName=" + orgName
				+ ", depName=" + depName + ", postName=" + postName
				+ ", roleName=" + roleName + ", roleStatus=" + roleStatus
				+ ", roleDeleted=" + roleDeleted + "]";
	}

}