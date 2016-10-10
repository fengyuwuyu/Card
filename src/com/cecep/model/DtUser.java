package com.cecep.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.util.DigestUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 人员实体类(dt_user表)
 * 
 * @date 2016-03-16
 * */
public class DtUser extends PageModel {

	private Long userSerial;// 人员序号
	private String userNo;// 人员工号
	private String userLname;// 姓名
	private String userFname;// 班组
	private String depNo;// 部门编号
	private Integer userDep;// 部门序号
	private String userDepname;// 部门名称
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date userWorkday;// 工作日期
	private String userDuty;// 职务
	private String userCard;// 最后使用的卡片物理号
	private String userFinger;// 指纹
	private String userPassword;// 密码
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date pwdBegin;// 密码有效期始
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date pwdEnd;// 密码有效期末
	private Short userType;// 档案类型
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date pactBegin;// 档案有效期始
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date pactEnd;// 档案有效期末
	private Integer userLevel;// 是否管理考勤机
	private Integer userPhoto;
	private String userSex;
	private String userNation;
	private String userXueli;
	private String userNative;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date userBirthday;
	private String userId;// 身份证号
	private String userPost;
	private String userLinkman;
	private String userTelephone;
	private String userAddress;
	private String userEmail;
	private String user1;
	private String user2;
	private String userBz;
	private String kqRule;// 考勤规则
	private String kqTaoban;// 自动套班班次选择
	private Integer kqTiaoxiu;// 可用调休时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date xfTime;// 最后消费时间
	private Integer xfJiange;// 消费间隔
	private Integer xfJe;// 账户金额
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date userSj;
	private String userRank;
	private Integer glyImg;
	private Integer userAc;
	private String userGsbh;
	private String userYglx;
	private String userZhbh;
	private String userZhlx;
	private String userTxm;
	private Integer userLx;
	private Integer userMj;
	private String oldUserPassword;
	private java.sql.Date deadline;
	/**
	 * 卡片关联属性
	 * */
	private Integer cardXh;// 卡片序号
	private String cardHao;// 卡片物理号
	private String cardSerial;// 卡片顺序号(逻辑号)
	private Integer cardLx;// 卡片类型
	private String ttName;// 卡片类型名称
	private Integer cardType;// 卡片状态
	private Integer cardLossCount;// 卡片挂失次数
	private String cardBz;// 挂失原因、备注
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date cardSj;// 操作变更时间
	/**
	 * 角色关联属性
	 * */
	private Integer roleId;// 角色标识(主键)
	private String roleName;// 角色名称
	/**
	 * 账户类型关联属性
	 * */
	private String acBh;// 账户编号
	private String acName;// 账户名称
	private Integer passMax;// 密码状态
	private String acPass;// 账户密码
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date acBegin;// 账户启用日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date acEnd;// 账户结束日期
	private Integer acMoney;// 食堂剩余金额
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date acSj;// 卡片发行日期
	/**
	 * 档案类型关联属性
	 * */
	private String userTypeName;// 状态名称(档案类型名称)
	/**
	 * 医药关联属性
	 * */
	private Integer medMoney;// 医药剩余金额
	/**
	 * 其他属性
	 * */
	private String ip;
	private String glyNo;

	/** 初始化员工记录使用的字段 */
	private Integer id;
	/** 公司的编号 */
	private Integer companySerial;
	/** 公司名称 */
	private String company;
	private String privilege1;
	/** 是否级联查询 */
	private Boolean all;
	private Integer openCard;
	private Set<Long> userDeps;
	/** 同步时的HR库中员工所属二级或三级公司 */
	private String mainCompany;
	/** 同步时的HR库中员工所属二级或三级公司的部门 */
	private String mainDepname;
	private Integer userOrder;

	/**
	 * 白名单员工查询
	 * */
	private List<Long> depSerials;
	private List<Integer> userTypes;
	/** 1.表示是白名单查询，用于忽略是否开发条件 */
	private Integer whiteList;

	private String pinyin;

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public Integer getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(Integer userOrder) {
		this.userOrder = userOrder;
	}

	public java.sql.Date getDeadline() {
		return deadline;
	}

	public void setDeadline(java.sql.Date deadline) {
		this.deadline = deadline;
	}

	public Integer getWhiteList() {
		return whiteList;
	}

	public void setWhiteList(Integer whiteList) {
		this.whiteList = whiteList;
	}

	public List<Long> getDepSerials() {
		return depSerials;
	}

	public void setDepSerials(List<Long> depSerials) {
		this.depSerials = depSerials;
	}

	public List<Integer> getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(List<Integer> userTypes) {
		this.userTypes = userTypes;
	}

	public String getMainCompany() {
		return mainCompany;
	}

	public void setMainCompany(String mainCompany) {
		this.mainCompany = mainCompany;
	}

	public String getMainDepname() {
		return mainDepname;
	}

	public void setMainDepname(String mainDepname) {
		this.mainDepname = mainDepname;
	}

	public Set<Long> getUserDeps() {
		return userDeps;
	}

	public void setUserDeps(Set<Long> userDeps) {
		this.userDeps = userDeps;
	}

	public Integer getOpenCard() {
		return openCard;
	}

	public void setOpenCard(Integer openCard) {
		this.openCard = openCard;
	}

	public Boolean getAll() {
		return all;
	}

	public void setAll(Boolean all) {
		this.all = all;
	}

	/** 楼层门禁权限 */
	private int mj;

	public int getMj() {
		return mj;
	}

	public void setMj(int mj) {
		this.mj = mj;
	}

	public String getPrivilege1() {
		return privilege1;
	}

	public void setPrivilege1(String privilege1) {
		this.privilege1 = privilege1;
	}

	public Integer getCompanySerial() {
		return companySerial;
	}

	public void setCompanySerial(Integer companySerial) {
		this.companySerial = companySerial;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName == null ? null : userTypeName.trim();
	}

	public Long getUserSerial() {
		return userSerial;
	}

	public void setUserSerial(Long userSerial) {
		this.userSerial = userSerial;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo == null ? null : userNo.trim();
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname == null ? null : userLname.trim();
	}

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname == null ? null : userFname.trim();
	}

	public String getDepNo() {
		return depNo;
	}

	public void setDepNo(String depNo) {
		this.depNo = depNo == null ? null : depNo.trim();
	}

	public Integer getUserDep() {
		return userDep;
	}

	public void setUserDep(Integer userDep) {
		this.userDep = userDep;
	}

	public String getUserDepname() {
		return userDepname;
	}

	public void setUserDepname(String userDepname) {
		this.userDepname = userDepname == null ? null : userDepname.trim();
	}

	public Date getUserWorkday() {
		return userWorkday;
	}

	public void setUserWorkday(Date userWorkday) {
		this.userWorkday = userWorkday;
	}

	public String getUserDuty() {
		return userDuty;
	}

	public void setUserDuty(String userDuty) {
		this.userDuty = userDuty == null ? null : userDuty.trim();
	}

	public String getUserCard() {
		return userCard;
	}

	public void setUserCard(String userCard) {
		this.userCard = userCard == null ? null : userCard.trim();
	}

	public String getUserFinger() {
		return userFinger;
	}

	public void setUserFinger(String userFinger) {
		this.userFinger = userFinger == null ? null : userFinger.trim();
	}

	public String getUserPassword() {
		return (userPassword == null) ? null : DigestUtils
				.md5DigestAsHex(userPassword.getBytes());
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword == null ? null : userPassword.trim();
	}

	public Date getPwdBegin() {
		return pwdBegin;
	}

	public void setPwdBegin(Date pwdBegin) {
		this.pwdBegin = pwdBegin;
	}

	public Date getPwdEnd() {
		return pwdEnd;
	}

	public void setPwdEnd(Date pwdEnd) {
		this.pwdEnd = pwdEnd;
	}

	public Short getUserType() {
		return userType;
	}

	public void setUserType(Short userType) {
		this.userType = userType;
	}

	public Date getPactBegin() {
		return pactBegin;
	}

	public void setPactBegin(Date pactBegin) {
		this.pactBegin = pactBegin;
	}

	public Date getPactEnd() {
		return pactEnd;
	}

	public void setPactEnd(Date pactEnd) {
		this.pactEnd = pactEnd;
	}

	public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public Integer getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(Integer userPhoto) {
		this.userPhoto = userPhoto;
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

	public String getUserXueli() {
		return userXueli;
	}

	public void setUserXueli(String userXueli) {
		this.userXueli = userXueli == null ? null : userXueli.trim();
	}

	public String getUserNative() {
		return userNative;
	}

	public void setUserNative(String userNative) {
		this.userNative = userNative == null ? null : userNative.trim();
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getUserPost() {
		return userPost;
	}

	public void setUserPost(String userPost) {
		this.userPost = userPost == null ? null : userPost.trim();
	}

	public String getUserLinkman() {
		return userLinkman;
	}

	public void setUserLinkman(String userLinkman) {
		this.userLinkman = userLinkman == null ? null : userLinkman.trim();
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone == null ? null : userTelephone
				.trim();
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress == null ? null : userAddress.trim();
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail == null ? null : userEmail.trim();
	}

	public String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		this.user1 = user1 == null ? null : user1.trim();
	}

	public String getUser2() {
		return user2;
	}

	public void setUser2(String user2) {
		this.user2 = user2 == null ? null : user2.trim();
	}

	public String getUserBz() {
		return userBz;
	}

	public void setUserBz(String userBz) {
		this.userBz = userBz == null ? null : userBz.trim();
	}

	public String getKqRule() {
		return kqRule;
	}

	public void setKqRule(String kqRule) {
		this.kqRule = kqRule == null ? null : kqRule.trim();
	}

	public String getKqTaoban() {
		return kqTaoban;
	}

	public void setKqTaoban(String kqTaoban) {
		this.kqTaoban = kqTaoban == null ? null : kqTaoban.trim();
	}

	public Integer getKqTiaoxiu() {
		return kqTiaoxiu;
	}

	public void setKqTiaoxiu(Integer kqTiaoxiu) {
		this.kqTiaoxiu = kqTiaoxiu;
	}

	public Date getXfTime() {
		return xfTime;
	}

	public void setXfTime(Date xfTime) {
		this.xfTime = xfTime;
	}

	public Integer getXfJiange() {
		return xfJiange;
	}

	public void setXfJiange(Integer xfJiange) {
		this.xfJiange = xfJiange;
	}

	public Integer getXfJe() {
		return xfJe;
	}

	public void setXfJe(Integer xfJe) {
		this.xfJe = xfJe;
	}

	public Date getUserSj() {
		return userSj;
	}

	public void setUserSj(Date userSj) {
		this.userSj = userSj;
	}

	public String getUserRank() {
		return userRank;
	}

	public void setUserRank(String userRank) {
		this.userRank = userRank == null ? null : userRank.trim();
	}

	public Integer getGlyImg() {
		return glyImg;
	}

	public void setGlyImg(Integer glyImg) {
		this.glyImg = glyImg;
	}

	public Integer getUserAc() {
		return userAc;
	}

	public void setUserAc(Integer userAc) {
		this.userAc = userAc;
	}

	public String getUserGsbh() {
		return userGsbh;
	}

	public void setUserGsbh(String userGsbh) {
		this.userGsbh = userGsbh == null ? null : userGsbh.trim();
	}

	public String getUserYglx() {
		return userYglx;
	}

	public void setUserYglx(String userYglx) {
		this.userYglx = userYglx == null ? null : userYglx.trim();
	}

	public String getUserZhbh() {
		return userZhbh;
	}

	public void setUserZhbh(String userZhbh) {
		this.userZhbh = userZhbh == null ? null : userZhbh.trim();
	}

	public String getUserZhlx() {
		return userZhlx;
	}

	public void setUserZhlx(String userZhlx) {
		this.userZhlx = userZhlx == null ? null : userZhlx.trim();
	}

	public String getUserTxm() {
		return userTxm;
	}

	public void setUserTxm(String userTxm) {
		this.userTxm = userTxm == null ? null : userTxm.trim();
	}

	public Integer getUserLx() {
		return userLx;
	}

	public void setUserLx(Integer userLx) {
		this.userLx = userLx;
	}

	public Integer getUserMj() {
		return userMj;
	}

	public void setUserMj(Integer userMj) {
		this.userMj = userMj;
	}

	public String getCardSerial() {
		return cardSerial;
	}

	public void setCardSerial(String cardSerial) {
		this.cardSerial = cardSerial == null ? null : cardSerial.trim();
	}

	public String getCardHao() {
		return cardHao;
	}

	public void setCardHao(String cardHao) {
		this.cardHao = cardHao == null ? null : cardHao.trim();
	}

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public Date getCardSj() {
		return cardSj;
	}

	public void setCardSj(Date cardSj) {
		this.cardSj = cardSj;
	}

	public String getCardBz() {
		return cardBz;
	}

	public void setCardBz(String cardBz) {
		this.cardBz = cardBz == null ? null : cardBz.trim();
	}

	public Integer getCardXh() {
		return cardXh;
	}

	public void setCardXh(Integer cardXh) {
		this.cardXh = cardXh;
	}

	public Integer getCardLx() {
		return cardLx;
	}

	public void setCardLx(Integer cardLx) {
		this.cardLx = cardLx;
	}

	public String getTtName() {
		return ttName;
	}

	public void setTtName(String ttName) {
		this.ttName = ttName == null ? null : ttName.trim();
	}

	public String getAcBh() {
		return acBh;
	}

	public void setAcBh(String acBh) {
		this.acBh = acBh == null ? null : acBh.trim();
	}

	public String getAcName() {
		return acName;
	}

	public void setAcName(String acName) {
		this.acName = acName == null ? null : acName.trim();
	}

	public Integer getPassMax() {
		return passMax;
	}

	public void setPassMax(Integer passMax) {
		this.passMax = passMax;
	}

	public String getAcPass() {
		return acPass;
	}

	public void setAcPass(String acPass) {
		this.acPass = acPass == null ? null : acPass.trim();
	}

	public Date getAcBegin() {
		return acBegin;
	}

	public void setAcBegin(Date acBegin) {
		this.acBegin = acBegin;
	}

	public Date getAcEnd() {
		return acEnd;
	}

	public void setAcEnd(Date acEnd) {
		this.acEnd = acEnd;
	}

	public Date getAcSj() {
		return acSj;
	}

	public void setAcSj(Date acSj) {
		this.acSj = acSj;
	}

	public Integer getCardLossCount() {
		return cardLossCount;
	}

	public void setCardLossCount(Integer cardLossCount) {
		this.cardLossCount = cardLossCount;
	}

	public Integer getAcMoney() {
		return acMoney;
	}

	public void setAcMoney(Integer acMoney) {
		this.acMoney = acMoney;
	}

	public Integer getMedMoney() {
		return medMoney;
	}

	public void setMedMoney(Integer medMoney) {
		this.medMoney = medMoney;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	public String getGlyNo() {
		return glyNo;
	}

	public void setGlyNo(String glyNo) {
		this.glyNo = glyNo == null ? null : glyNo.trim();
	}

	public String getOldUserPassword() {
		return oldUserPassword;
	}

	public void setOldUserPassword(String oldUserPassword) {
		this.oldUserPassword = oldUserPassword;
	}

	@Override
	public String toString() {
		return "DtUser [userSerial=" + userSerial + ", userNo=" + userNo
				+ ", userLname=" + userLname + ", userFname=" + userFname
				+ ", depNo=" + depNo + ", userDep=" + userDep
				+ ", userDepname=" + userDepname + ", userWorkday="
				+ userWorkday + ", userDuty=" + userDuty + ", userCard="
				+ userCard + ", userFinger=" + userFinger + ", userPassword="
				+ userPassword + ", pwdBegin=" + pwdBegin + ", pwdEnd="
				+ pwdEnd + ", userType=" + userType + ", pactBegin="
				+ pactBegin + ", pactEnd=" + pactEnd + ", userLevel="
				+ userLevel + ", userPhoto=" + userPhoto + ", userSex="
				+ userSex + ", userNation=" + userNation + ", userXueli="
				+ userXueli + ", userNative=" + userNative + ", userBirthday="
				+ userBirthday + ", userId=" + userId + ", userPost="
				+ userPost + ", userLinkman=" + userLinkman
				+ ", userTelephone=" + userTelephone + ", userAddress="
				+ userAddress + ", userEmail=" + userEmail + ", user1=" + user1
				+ ", user2=" + user2 + ", userBz=" + userBz + ", kqRule="
				+ kqRule + ", kqTaoban=" + kqTaoban + ", kqTiaoxiu="
				+ kqTiaoxiu + ", xfTime=" + xfTime + ", xfJiange=" + xfJiange
				+ ", xfJe=" + xfJe + ", userSj=" + userSj + ", userRank="
				+ userRank + ", glyImg=" + glyImg + ", userAc=" + userAc
				+ ", userGsbh=" + userGsbh + ", userYglx=" + userYglx
				+ ", userZhbh=" + userZhbh + ", userZhlx=" + userZhlx
				+ ", userTxm=" + userTxm + ", userLx=" + userLx + ", userMj="
				+ userMj + ", oldUserPassword=" + oldUserPassword + ", cardXh="
				+ cardXh + ", cardHao=" + cardHao + ", cardSerial="
				+ cardSerial + ", cardLx=" + cardLx + ", ttName=" + ttName
				+ ", cardType=" + cardType + ", cardLossCount=" + cardLossCount
				+ ", cardBz=" + cardBz + ", cardSj=" + cardSj + ", roleId="
				+ roleId + ", roleName=" + roleName + ", acBh=" + acBh
				+ ", acName=" + acName + ", passMax=" + passMax + ", acPass="
				+ acPass + ", acBegin=" + acBegin + ", acEnd=" + acEnd
				+ ", acMoney=" + acMoney + ", acSj=" + acSj + ", userTypeName="
				+ userTypeName + ", medMoney=" + medMoney + ", ip=" + ip
				+ ", glyNo=" + glyNo + ", id=" + id + ", companySerial="
				+ companySerial + ", company=" + company + ", privilege1="
				+ privilege1 + ", all=" + all + ", openCard=" + openCard
				+ ", userDeps=" + userDeps + ", mainCompany=" + mainCompany
				+ ", mainDepname=" + mainDepname + ", depSerials=" + depSerials
				+ ", userTypes=" + userTypes + ", mj=" + mj + ", loginid="
				+ loginid + ", sn=" + sn + ", cname=" + cname + ", password="
				+ password + ", uuaccountstatus=" + uuaccountstatus + "]";
	}

	/*
	 * 登录字段 员工号sn关联dt_user user_no
	 */
	private String loginid;// 账号
	private String sn;// 员工号
	private String cname;// 中文名
	private String password;// 密码
	private String uuaccountstatus;// ESB推送人员状态 1挂起 0 正常

	public String getUuaccountstatus() {
		return uuaccountstatus;
	}

	public void setUuaccountstatus(String uuaccountstatus) {
		this.uuaccountstatus = uuaccountstatus;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = DigestUtils.md5DigestAsHex(password.getBytes());
	}

}