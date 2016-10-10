package com.cecep.model.mess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.cecep.model.PageModel;

public class WhiteList extends PageModel {

	/**
	 * 查询条件
	 */
	/** 表dt_ac_dep_user中的xh字段集合 */
	private List<Integer> ids;
	/** 设备序号 */
	private Integer devSerial;
	/** 用户序号集合 */
	private List<Long> userSerials;
	/** 员工类型 */
	private List<Integer> userTypes;
	/** 部门编号 */
	private Long userDep;
	private List<Long> depSerials;
	private Set<Long> depSerialss;
	/** 场所编号 */
	private Integer acdepSerial;

	private Date sj;

	private Integer out = 0;

	private Integer param = 3;
	/** 操作员 */
	private String optName;

	public Integer getParam() {
		return param;
	}

	public void setParam(Integer param) {
		this.param = param;
	}

	public String getOptName() {
		return optName;
	}

	public void setOptName(String optName) {
		this.optName = optName;
	}

	public Integer getOut() {
		return out;
	}

	public void setOut(Integer out) {
		this.out = out;
	}

	public Date getSj() {
		return sj;
	}

	public void setSj(Date sj) {
		this.sj = sj;
	}

	public List<Long> getDepSerials() {
		return depSerials;
	}

	public void setDepSerials(List<Long> depSerials) {
		this.depSerials = depSerials;
	}

	/**
	 * 查询结果
	 */
	/** 记录序号 */
	private Integer xh;
	/** 员工姓名 */
	private String userLname;
	private String userSerialss;
	private Long userSerial;
	/** 场所序号 */
	private Integer depSerial;
	/** 用户编号 */
	private String userNo;
	/** 所属公司 */
	private String companyName;
	/** 所属部门 */
	private String department;
	/** 关联的场所 */
	private String acdepName;
	/** 用户类型 */
	private Integer userType;
	/** 用户类型名称 */
	private String userTypeName;

	public Long getUserSerial() {
		return userSerial;
	}

	public void setUserSerial(Long userSerial) {
		this.userSerial = userSerial;
	}

	public String getUserSerialss() {
		return userSerialss;
	}

	public void setUserSerialss(String userSerialss) {
		this.userSerialss = userSerialss;
	}

	public Set<Long> getDepSerialss() {
		return depSerialss;
	}

	public void setDepSerialss(Set<Long> depSerialss) {
		this.depSerialss = depSerialss;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getDepSerial() {
		return depSerial;
	}

	public void setDepSerial(Integer depSerial) {
		this.depSerial = depSerial;
	}

	public List<Integer> getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(List<Integer> userTypes) {
		this.userTypes = userTypes;
	}

	public Integer getAcdepSerial() {
		return acdepSerial;
	}

	public void setAcdepSerial(Integer acdepSerial) {
		this.acdepSerial = acdepSerial;
	}

	public Long getUserDep() {
		return userDep;
	}

	public void setUserDep(Long userDep) {
		this.userDep = userDep;
	}

	public Integer getXh() {
		return xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAcdepName() {
		return acdepName;
	}

	public void setAcdepName(String acdepName) {
		this.acdepName = acdepName;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Integer getDevSerial() {
		return devSerial;
	}

	public void setDevSerial(Integer devSerial) {
		this.devSerial = devSerial;
	}

	public List<Long> getUserSerials() {
		if (userSerials == null) {
			if (userSerialss != null) {
				String[] serials = userSerialss.split(",");
				List<Long> list = new ArrayList<Long>();
				if (serials.length == 1) {
					list.add(Long.valueOf(serials[0]));
					return list;
				}
				for (String serial : serials) {
					list.add(Long.valueOf(serial));
				}
				return list;
			}
		}
		return userSerials;
	}

	public void setUserSerials(List<Long> userSerials) {
		this.userSerials = userSerials;
	}

	@Override
	public String toString() {
		return "WhiteList [ids=" + ids + ", devSerial=" + devSerial
				+ ", userSerials=" + userSerials + ", userTypes=" + userTypes
				+ ", userDep=" + userDep + ", depSerials=" + depSerials
				+ ", depSerialss=" + depSerialss + ", acdepSerial="
				+ acdepSerial + ", sj=" + sj + ", out=" + out + ", param="
				+ param + ", optName=" + optName + ", xh=" + xh
				+ ", userLname=" + userLname + ", userSerialss=" + userSerialss
				+ ", userSerial=" + userSerial + ", depSerial=" + depSerial
				+ ", userNo=" + userNo + ", companyName=" + companyName
				+ ", department=" + department + ", acdepName=" + acdepName
				+ ", userType=" + userType + ", userTypeName=" + userTypeName
				+ "]";
	}

}
