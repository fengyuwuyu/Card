package com.cecep.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MedAccount extends PageModel{
    private Integer accountId;
    private String accountIds;
    private Integer cardNumber;
    private BigDecimal amount;
    private String accType;
    private String accType1;
    private BigDecimal amount1;
    private BigDecimal amount2;
    private Integer depParent;// 父级部门序号
    private  String depName;
    
    
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public Integer getDepParent() {
		return depParent;
	}
	public void setDepParent(Integer depParent) {
		this.depParent = depParent;
	}
	public BigDecimal getAmount2() {
		return amount2;
	}
	public void setAmount2(BigDecimal amount2) {
		this.amount2 = amount2;
	}
	public BigDecimal getAmount1() {
		return amount1;
	}
	public void setAmount1(BigDecimal amount1) {
		this.amount1 = amount1;
	}
	public String getAccountIds() {
		return accountIds;
	}
	public void setAccountIds(String accountIds) {
		this.accountIds = accountIds;
	}
	public String getAccType1() {
		return accType1;
	}
	public void setAccType1(String accType1) {
		this.accType1 = accType1;
	}
	private BigDecimal money;
    
    public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	/**
     * 关联表属性
     * 人员表
     * @return
     */
    
    private  String  userNo;//工号
    private  String  userLname;//姓名
    private  String  sexName;//性别 
    private  String  userDuty;//职务
    private  String  userDepname;//部门
    private  String  cardHao;//卡号
    private  String  userType;//是否离职
	private  String  userType1;//是否离职
	private Integer  userSerial;//人员序号
	private  Integer  depSerial;//部门id
	private  Integer  depSerialAccount;//部门id
	private Long userSerial1;// 人员序号
	private String state;//树形结构
	private  String  depSerials;//部门id
	private List<Integer> result;
	
	
	public List<Integer> getResult() {
		return result;
	}
	public void setResult(List<Integer> result) {
		this.result = result;
	}
	public String getDepSerials() {
		return depSerials;
	}
	public void setDepSerials(String depSerials) {
		this.depSerials = depSerials;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getUserSerial1() {
		return userSerial1;
	}
	public void setUserSerial1(Long userSerial1) {
		this.userSerial1 = userSerial1;
	}
	public Integer getDepSerialAccount() {
		return depSerialAccount;
	}
	public void setDepSerialAccount(Integer depSerialAccount) {
		this.depSerialAccount = depSerialAccount;
	}
	public Integer getDepSerial() {
		return depSerial;
	}
	public void setDepSerial(Integer depSerial) {
		this.depSerial = depSerial;
	}
	/**
	 * 修改卡余额
	 */
	private  String  cardNumber2;//被转移卡号
	private  String  cardNumber1;//转账到卡号
	private  BigDecimal amountMoney;//转移金额
	
	public BigDecimal getAmountMoney() {
		return amountMoney;
	}
	public void setAmountMoney(BigDecimal amountMoney) {
		this.amountMoney = amountMoney;
	}
	public String getCardNumber2() {
		return cardNumber2;
	}
	public void setCardNumber2(String cardNumber2) {
		this.cardNumber2 = cardNumber2;
	}
	public String getCardNumber1() {
		return cardNumber1;
	}
	public void setCardNumber1(String cardNumber1) {
		this.cardNumber1 = cardNumber1;
	}

	
    public Integer getUserSerial() {
		return userSerial;
	}
	public void setUserSerial(Integer userSerial) {
		this.userSerial = userSerial;
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

    
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public Integer getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getUserNo() {
		return userNo;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
	
	public String getSexName() {
		return sexName;
	}
	public void setSexName(String sexName) {
		this.sexName = sexName;
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
	public String getCardHao() {
		return cardHao;
	}
	public void setCardHao(String cardHao) {
		this.cardHao = cardHao;
	}
	
	
	@JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss",timezone = "GMT+8")
	private Date createTime;// 入库时间时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date beginDate;// 开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;// 结束时间
	private String selectType;//区分公司还是个人
	

	public String getSelectType() {
		return selectType;
	}
	public void setSelectType(String selectType) {
		this.selectType = selectType;
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
	public MedAccount() {
		super();
	}
	
	
	
	
    
}