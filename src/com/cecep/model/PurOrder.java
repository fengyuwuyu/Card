package com.cecep.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PurOrder  extends  PageModel{
    private Integer orderId;
    private String cardNumber;
    private Date time;
    private Integer medRecordId;
    
    
    /**
     * 药品详细关联
     * @return
     */
    private Integer medicineId;
    private String medicineName;
    private BigDecimal price;//金额的定义
    private String vendor;
    private String medicineDesc;
    private String  medicineType;
    private String barCode;
    
    /**医药账户关联
     * 
     * @return
     */ 
    	
 	private Integer accountId;
 	private String cardNumber1;
    private BigDecimal amount;
    private String accType;
    private String accType1;
    
    private  BigDecimal  total;
    private  BigDecimal  totalAmount;//消费总额
    private  BigDecimal  totalAmount1;//消费总额用于记录
    
    private BigDecimal totalPrice;
    
    
    public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	private String selectType;//区分公司还是个人
	
	@JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss",timezone = "GMT+8")
	private Date createTime;// 入库时间时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date beginDate;// 开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;// 结束时间

	private Long  userSerial1;//人员序号
	
    private Integer depParent;// 父级部门序号
    private  String depName;
    private String state;//树形结构
	private  String  depSerials;//部门id
	private List<Integer> result;
	

	public Integer getDepParent() {
		return depParent;
	}

	public void setDepParent(Integer depParent) {
		this.depParent = depParent;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDepSerials() {
		return depSerials;
	}

	public void setDepSerials(String depSerials) {
		this.depSerials = depSerials;
	}

	public List<Integer> getResult() {
		return result;
	}

	public void setResult(List<Integer> result) {
		this.result = result;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

public Long getUserSerial1() {
		return userSerial1;
	}

	public void setUserSerial1(Long userSerial1) {
		this.userSerial1 = userSerial1;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
	}

	public BigDecimal getTotalAmount1() {
		return totalAmount1;
	}

	public void setTotalAmount1(BigDecimal totalAmount1) {
		this.totalAmount1 = totalAmount1;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

/**
    * 药品购买明细
    * @return
    */
    private Integer   medId;
    private Integer  quantity;
    private String   medIds;
    private String  quantitys;
    private Integer purRecordId;

    private Integer  cou;


	public Integer getCou() {
		return cou;
	}

	public void setCou(Integer cou) {
		this.cou = cou;
	}

	public Integer getMedId() {
		return medId;
	}

	public void setMedId(Integer medId) {
		this.medId = medId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getMedIds() {
		return medIds;
	}

	public void setMedIds(String medIds) {
		this.medIds = medIds;
	}

	public String getQuantitys() {
		return quantitys;
	}

	public void setQuantitys(String quantitys) {
		this.quantitys = quantitys;
	}

	public Integer getPurRecordId() {
		return purRecordId;
	}

	public void setPurRecordId(Integer purRecordId) {
		this.purRecordId = purRecordId;
	}


	public String getAccType1() {
		return accType1;
	}

	public void setAccType1(String accType1) {
		this.accType1 = accType1;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getSexname() {
		return sexname;
	}

	public void setSexname(String sexname) {
		this.sexname = sexname;
	}

	public String getUserDuty() {
		return userDuty;
	}

	public void setUserDuty(String userDuty) {
		this.userDuty = userDuty;
	}

	public String getUserDepname() {
		return userDepname;
	}

	public void setUserDepname(String userDepname) {
		this.userDepname = userDepname;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserType1() {
		return userType1;
	}

	public void setUserType1(String userType1) {
		this.userType1 = userType1;
	}

	public Integer getUserSerial() {
		return userSerial;
	}

	public void setUserSerial(Integer userSerial) {
		this.userSerial = userSerial;
	}

	/**
     * 关联表属性
     * 人员表
     * @return
     */
    
    private  String  userNo;//工号
    private  String  userLname;//姓名
    private  String  sexname;//性别 
    private  String  userDuty;//职务
    private  String  userDepname;//部门
    private  String  cardHao;//卡号
    private  String  userType;//是否离职
	private  String  userType1;//是否离职
	private Integer  userSerial;//人员序号
	private  Integer  depSerial;//部门id
	private  Integer  depSerial1;//部门id
	private  Integer  depSerialAccount;
	
	
    
    
     public Integer getDepSerialAccount() {
		return depSerialAccount;
	}

	public void setDepSerialAccount(Integer depSerialAccount) {
		this.depSerialAccount = depSerialAccount;
	}

	public Integer getDepSerial1() {
		return depSerial1;
	}

	public void setDepSerial1(Integer depSerial1) {
		this.depSerial1 = depSerial1;
	}

	public Integer getDepSerial() {
		return depSerial;
	}

	public void setDepSerial(Integer depSerial) {
		this.depSerial = depSerial;
	}

	public String getCardHao() {
		return cardHao;
	}

	public void setCardHao(String cardHao) {
		this.cardHao = cardHao;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getCardNumber1() {
		return cardNumber1;
	}

	public void setCardNumber1(String cardNumber1) {
		this.cardNumber1 = cardNumber1;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}


     
    
    

    public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
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

	public String getMedicineType() {
		return medicineType;
	}

	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}

	public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getMedRecordId() {
        return medRecordId;
    }

    public void setMedRecordId(Integer medRecordId) {
        this.medRecordId = medRecordId;
    }

	public PurOrder() {
		super();
	}

	@Override
	public String toString() {
		return "PurOrder [orderId=" + orderId + ", cardNumber=" + cardNumber
				+ ", time=" + time + ", medRecordId=" + medRecordId
				+ ", medicineId=" + medicineId + ", medicineName="
				+ medicineName + ", price=" + price + ", vendor=" + vendor
				+ ", medicineDesc=" + medicineDesc + ", medicineType="
				+ medicineType + ", barCode=" + barCode + ", accountId="
				+ accountId + ", cardNumber1=" + cardNumber1 + ", amount="
				+ amount + ", accType=" + accType + ", accType1=" + accType1
				+ ", total=" + total + ", totalAmount=" + totalAmount
				+ ", totalAmount1=" + totalAmount1 + ", totalPrice="
				+ totalPrice + ", selectType=" + selectType + ", createTime="
				+ createTime + ", beginDate=" + beginDate + ", endDate="
				+ endDate + ", userSerial1=" + userSerial1 + ", depParent="
				+ depParent + ", depName=" + depName + ", state=" + state
				+ ", depSerials=" + depSerials + ", result=" + result
				+ ", medId=" + medId + ", quantity=" + quantity + ", medIds="
				+ medIds + ", quantitys=" + quantitys + ", purRecordId="
				+ purRecordId + ", cou=" + cou + ", userNo=" + userNo
				+ ", userLname=" + userLname + ", sexname=" + sexname
				+ ", userDuty=" + userDuty + ", userDepname=" + userDepname
				+ ", cardHao=" + cardHao + ", userType=" + userType
				+ ", userType1=" + userType1 + ", userSerial=" + userSerial
				+ ", depSerial=" + depSerial + ", depSerial1=" + depSerial1
				+ ", depSerialAccount=" + depSerialAccount + "]";
	}
    
    
    
}