package com.cecep.model;

import java.math.BigDecimal;
import java.util.List;

public class PreOrderDetail extends PageModel{
	/**
	 * 预定详细
	 */
    private Integer preOrderId;
    private Integer preRecordId;
    private String medName;
    private Long quantity;
    
   /**
    * 预订人信息 
    * @return
    */
    private Integer preOrderId1; 
    private Integer cardNumber;
    private String phone;
    private String preType;//处理状态 0  未处理  1  已处理
    private String preType1;
    private BigDecimal price;//金额的定义
    private String accType;
    private  BigDecimal  totalAmount;
    private String ids;//打印数据id;
    private List<Integer> printList;//打印数据id数组;
   

	public List<Integer> getPrintList() {
		return printList;
	}

	public void setPrintList(List<Integer> printList) {
		this.printList = printList;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPreType1() {
		return preType1;
	}

	public void setPreType1(String preType1) {
		this.preType1 = preType1;
	}

	/**
     * 员工信息
     * @return
     */
    private String userLname;
    private String cardHao;
    private Integer userSerial; 
    
    
    public String getCardHao() {
		return cardHao;
	}

	public void setCardHao(String cardHao) {
		this.cardHao = cardHao;
	}

	public Integer getUserSerial() {
		return userSerial;
	}

	public void setUserSerial(Integer userSerial) {
		this.userSerial = userSerial;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getPreType() {
		return preType;
	}

	public void setPreType(String preType) {
		this.preType = preType;
	}

	public Integer getPreOrderId1() {
		return preOrderId1;
	}

	public void setPreOrderId1(Integer preOrderId1) {
		this.preOrderId1 = preOrderId1;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPreOrderId() {
        return preOrderId;
    }

    public void setPreOrderId(Integer preOrderId) {
        this.preOrderId = preOrderId;
    }

    public Integer getPreRecordId() {
        return preRecordId;
    }

    public void setPreRecordId(Integer preRecordId) {
        this.preRecordId = preRecordId;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName == null ? null : medName.trim();
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}