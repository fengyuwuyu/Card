package com.cecep.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 访客黑名单实体类(visitor_blacklist表)
 * 
 * @date 2016-03-21
 * */
public class VisitorBlacklist extends PageModel {

	private Long id;
	private Long userSerial;
	private Integer flag;// 是否在黑名单(0 否 1 是)
	private Integer count;// 开卡次数
	private Integer autoCount;// 系统退还卡次数
	private Integer manualCount;// 手动退还卡次数
	private Integer notReturnCount;// 未还卡次数
	/**
	 * 人员关联属性一
	 * */
	private String userLname;// 姓名
	private String userSex;
	private String userNation;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date userBirthday;
	private String userAddress;
	private String userId;// 身份证号
	private String userTelephone;
	private String userEmail;
	private String userDuty;// 职务
	private String userDepname;// 部门名称
	private String userBz;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userSj;// 操作变更时间

	/**
	 * 卡片关联属性
	 * */
	private Integer cardXh;// 卡序号
	private String cardHao;// 物理卡号
	private String cardSerial;// 顺序、逻辑卡号
	private Integer cardLx;// 卡片类型

	public Integer getNotReturnCount() {
		if(count!=null&&autoCount!=null&&manualCount!=null){
			notReturnCount = count-autoCount-manualCount;
			return notReturnCount;
		}
		return 0;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress == null ? null : userAddress.trim();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserSerial() {
		return userSerial;
	}

	public void setUserSerial(Long userSerial) {
		this.userSerial = userSerial;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getAutoCount() {
		return autoCount;
	}

	public void setAutoCount(Integer autoCount) {
		this.autoCount = autoCount;
	}

	public Integer getManualCount() {
		return manualCount;
	}

	public void setManualCount(Integer manualCount) {
		this.manualCount = manualCount;
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
		this.userTelephone = userTelephone == null ? null : userTelephone
				.trim();
	}

	public Date getUserSj() {
		return userSj;
	}

	public void setUserSj(Date userSj) {
		this.userSj = userSj;
	}

	public Integer getCardXh() {
		return cardXh;
	}

	public void setCardXh(Integer cardXh) {
		this.cardXh = cardXh;
	}

	public String getCardHao() {
		return cardHao;
	}

	public void setCardHao(String cardHao) {
		this.cardHao = cardHao == null ? null : cardHao.trim();
	}

	public String getCardSerial() {
		return cardSerial;
	}

	public void setCardSerial(String cardSerial) {
		this.cardSerial = cardSerial == null ? null : cardSerial.trim();
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

	public Integer getCardLx() {
		return cardLx;
	}

	public void setCardLx(Integer cardLx) {
		this.cardLx = cardLx;
	}

}