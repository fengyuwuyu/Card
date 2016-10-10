package com.cecep.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Inventory extends PageModel {

	private Integer inventoryId;
	private Integer examinerId;
	private Integer quantity;


	/*
	 * 关联属性--药品管理表
	 */
	private Integer medicineId;
	private String medicineName;
	private BigDecimal price;
	private String vendor;
	private String medicineDesc;
	private String barCode;//条码
	/*
	 * 关联属性--入库记录表
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date outTime;// 过期时间
	private Integer number;
	private Integer inventory;// 关联表主键
	private Integer invRecordId;
	private Integer cou;//销售数量
	private Integer cou1;//过期数量
	
	

	/**
	 * 代购
	 * @return
	 */
	private String remarks;//代购备注信息
	private Integer cardNumber;//代购人卡号
	private BigDecimal money;//消费金额
	private BigDecimal money1;//消费金额用于记录
	private  String type;//代购人是否特殊用户
	
	
	
	/**
	 * 库存信息查询
	 * @return
	 */
	
	
	@JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss",timezone = "GMT+8")
	private Date invTime;// 入库时间时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date beginDate;// 开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;// 结束时间
	
	
	
	
	
	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Integer getCou1() {
		return cou1;
	}

	public void setCou1(Integer cou1) {
		this.cou1 = cou1;
	}

	public Integer getCou() {
		return cou;
	}

	public void setCou(Integer cou) {
		this.cou = cou;
	}

	public Date getInvTime() {
		return invTime;
	}

	public void setInvTime(Date invTime) {
		this.invTime = invTime;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getMoney1() {
		return money1;
	}

	public void setMoney1(BigDecimal money1) {
		this.money1 = money1;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getInvRecordId() {
		return invRecordId;
	}

	public void setInvRecordId(Integer invRecordId) {
		this.invRecordId = invRecordId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getMedicineDesc() {
		return medicineDesc;
	}

	public void setMedicineDesc(String medicineDesc) {
		this.medicineDesc = medicineDesc;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Integer getExaminerId() {
		return examinerId;
	}

	public void setExaminerId(Integer examinerId) {
		this.examinerId = examinerId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}