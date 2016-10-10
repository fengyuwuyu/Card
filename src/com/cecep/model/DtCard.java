package com.cecep.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 物理卡号实体类(dt_card表)
 * 
 * @date 2016-03-16
 * */
public class DtCard {

	private String cardSerial;// 卡片顺序号
	private Integer xh;// 自增序号
	private Integer lx;// 卡号类型
	private String glyNo;// 管理员编号(卡号类型为1时关联wt_gly的gly_no
							// 卡片类型为2时关联dt_owner的user_no)
	private String cardPhoto;// 卡片照片
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date sj;// 卡片信息变动时间
	private Long userSerial;// 人员序号(卡号类型为0时关联dt_user的user_serial)
	private Integer cardLx;// 卡片类型(关联tt_card表的tt_xh)
	private Integer cardType;// 卡片状态(0 正常 1 挂失 2 退卡 3 临时卡 4 开始发卡 5 坏卡)
	private String cardHao;// 卡片物理号
	private Integer cardOrder;// 卡片顺序 (人员拥有多张卡时从0开始，由高到低)
	private String cardBz;// 卡片挂失原因、备注
	private String cardVerify;// 卡片认证码
	private Integer readdCount;// 是否补卡
	private Integer lossCount;// 卡片挂失次数
	private Integer cardWork;// 卡片操作(0 读卡 1 写卡)
	private String cardForm;// 卡片目录区结构
	private Integer iscardreplace;// 是否补卡
	private Integer iscarddel;
	/** 卡的使用截止日期 */
	private java.sql.Date deadline;

	/**
	 * 关联属性
	 * */
	private String devSerial;// 发卡设备编号
	private Integer versionNo;// 卡片当前版本号
	private String acType;// 账户类型
	private String jmkh;// 加密卡号
	private String ip;// 操作终端IP
	private String regSerial;// 企业编号

	public java.sql.Date getDeadline() {
		return deadline;
	}

	public void setDeadline(java.sql.Date deadline) {
		this.deadline = deadline;
	}

	public String getCardSerial() {
		return cardSerial;
	}

	public void setCardSerial(String cardSerial) {
		this.cardSerial = cardSerial == null ? null : cardSerial.trim();
	}

	public Integer getXh() {
		return xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}

	public Integer getLx() {
		return lx;
	}

	public void setLx(Integer lx) {
		this.lx = lx;
	}

	public String getGlyNo() {
		return glyNo;
	}

	public void setGlyNo(String glyNo) {
		this.glyNo = glyNo == null ? null : glyNo.trim();
	}

	public String getCardPhoto() {
		return cardPhoto;
	}

	public void setCardPhoto(String cardPhoto) {
		this.cardPhoto = cardPhoto == null ? null : cardPhoto.trim();
	}

	public Date getSj() {
		return sj;
	}

	public void setSj(Date sj) {
		this.sj = sj;
	}

	public Long getUserSerial() {
		return userSerial;
	}

	public void setUserSerial(Long userSerial) {
		this.userSerial = userSerial;
	}

	public Integer getCardLx() {
		return cardLx;
	}

	public void setCardLx(Integer cardLx) {
		this.cardLx = cardLx;
	}

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public String getCardHao() {
		return cardHao;
	}

	public void setCardHao(String cardHao) {
		this.cardHao = cardHao == null ? null : cardHao.trim();
	}

	public Integer getCardOrder() {
		return cardOrder;
	}

	public void setCardOrder(Integer cardOrder) {
		this.cardOrder = cardOrder;
	}

	public String getCardBz() {
		return cardBz;
	}

	public void setCardBz(String cardBz) {
		this.cardBz = cardBz == null ? null : cardBz.trim();
	}

	public String getCardVerify() {
		return cardVerify;
	}

	public void setCardVerify(String cardVerify) {
		this.cardVerify = cardVerify == null ? null : cardVerify.trim();
	}

	public Integer getReaddCount() {
		return readdCount;
	}

	public void setReaddCount(Integer readdCount) {
		this.readdCount = readdCount;
	}

	public Integer getLossCount() {
		return lossCount;
	}

	public void setLossCount(Integer lossCount) {
		this.lossCount = lossCount;
	}

	public Integer getCardWork() {
		return cardWork;
	}

	public void setCardWork(Integer cardWork) {
		this.cardWork = cardWork;
	}

	public String getCardForm() {
		return cardForm;
	}

	public void setCardForm(String cardForm) {
		this.cardForm = cardForm == null ? null : cardForm.trim();
	}

	public Integer getIscardreplace() {
		return iscardreplace;
	}

	public void setIscardreplace(Integer iscardreplace) {
		this.iscardreplace = iscardreplace;
	}

	public Integer getIscarddel() {
		return iscarddel;
	}

	public void setIscarddel(Integer iscarddel) {
		this.iscarddel = iscarddel;
	}

	public String getDevSerial() {
		return devSerial;
	}

	public void setDevSerial(String devSerial) {
		this.devSerial = devSerial == null ? null : devSerial.trim();
	}

	public Integer getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}

	public String getAcType() {
		return acType;
	}

	public void setAcType(String acType) {
		this.acType = acType == null ? null : acType.trim();
	}

	public String getJmkh() {
		return jmkh;
	}

	public void setJmkh(String jmkh) {
		this.jmkh = jmkh == null ? null : jmkh.trim();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	public String getRegSerial() {
		return regSerial;
	}

	public void setRegSerial(String regSerial) {
		this.regSerial = regSerial == null ? null : regSerial.trim();
	}

	@Override
	public String toString() {
		return "DtCard [cardSerial=" + cardSerial + ", xh=" + xh + ", lx=" + lx
				+ ", glyNo=" + glyNo + ", cardPhoto=" + cardPhoto + ", sj="
				+ sj + ", userSerial=" + userSerial + ", cardLx=" + cardLx
				+ ", cardType=" + cardType + ", cardHao=" + cardHao
				+ ", cardOrder=" + cardOrder + ", cardBz=" + cardBz
				+ ", cardVerify=" + cardVerify + ", readdCount=" + readdCount
				+ ", lossCount=" + lossCount + ", cardWork=" + cardWork
				+ ", cardForm=" + cardForm + ", iscardreplace=" + iscardreplace
				+ ", iscarddel=" + iscarddel + ", deadline=" + deadline
				+ ", devSerial=" + devSerial + ", versionNo=" + versionNo
				+ ", acType=" + acType + ", jmkh=" + jmkh + ", ip=" + ip
				+ ", regSerial=" + regSerial + "]";
	}

}