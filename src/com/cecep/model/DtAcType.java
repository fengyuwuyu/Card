package com.cecep.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 账户类型实体类(dt_ac_type表)
 * @date 2016-03-15
 * */
public class DtAcType extends PageModel {
	
    private String acBh;//账户类型编号(16位整数组成 年月日时分秒+2位随机数)
    private String acName;//账户类型名称
    private Integer moneyType;//管理费收取方式
    private BigDecimal regMoney;//卡注册押金(以分为单位,单位换算参照tt_money)
    private Integer regManage;//应收管理费用金额(以分为单位,单位换算参照tt_money)
    private Integer regRatio;//管理费用占押金比例(表示百分比)
    private Integer acLimit;//账户有效使用周期(从账户生效时间开始计算)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date acJssj;//账户有效结束日期
    private String acPass;//账户初始默认密码
    private String acPassRule;//账户密码取值规则
    private Integer acSubsidy;//是否启用补贴(0 不启用 1 启用)
    private Integer acSubRule;//自动补贴规则(0 补贴累计 1 周期补贴)
    private Integer acSubLimit;//补贴累计周期
    private String discountRate;//折扣比例(表示百分比)
    private BigDecimal moneyMax;//账户最大金额(分)
    private BigDecimal moneyMin;//账户最小金额(分)
    private BigDecimal dayMaxM;//当日累计最大金额(分)
    private Integer dayMaxT;//当日累计最大次数
    private Integer mealMaxM;//
    private Integer mealMaxT;//
    private BigDecimal timeMaxM;//单次最大消费金额(分)
    private Integer acUnit;//账户有效周期单位(0 年 1 月  2 日)
    private Integer acSubUnit;//补贴有效周期单位(0 年 1 月 2 日3 时 4 分 5 秒)
    private Integer acEarmark;//是否启用圈存业务(0 启用 1 禁用)
    private Integer acSubAuto;//是否启用自动补贴(0 不启用 1 启用 2 手动加自动)
    private BigDecimal subMoney;//单次补贴金额(分)
    private BigDecimal acOverdraw;//允许透支的金额(分)
    private BigDecimal subMaxM;//补贴累计最大金额(分)
    private BigDecimal makeMaxM;//圈存累计最大金额(分)
    private Integer acTimeState;//非时段是否消费(0 不允许 1 允许)
    private Integer acEach;//是否启用按份消费(0 不启用 1 启用)
    private Integer acEachRule;//份发放规则(0 累计发放 1 周期发放)
    private Integer acTimeOffset;//时段偏移量
    private Integer acTimeType;//时段补贴类型(0 日补贴 1 时段补贴)
    private BigDecimal acTimeDay;//日补贴金额(分)
    private Integer acTimeMould;//时段补贴模式(0 定额补贴 1 消费多少补多少)
    private Integer passMax;//启用超限密码消费(1 启用 0 关闭)
    private Integer tallyMaxM;//记账累计最大金额(分)
    private Integer tallyMaxT;//记账累计最大次数
    private String acRegserial;//
    private String regserial;//
    private Integer acTimeeachType;//时段补贴类型(0 日补贴 1 时段补贴)
    private Integer acTimeeachDay;//日补贴份数
    private Integer acTimeeachMould;//时段补贴模式(0 定额 1 消费全额)
    private Integer acEachAuto;//是否启用份自动补贴

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

    public Integer getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(Integer moneyType) {
        this.moneyType = moneyType;
    }

    public BigDecimal getRegMoney() {
        return regMoney;
    }

    public void setRegMoney(BigDecimal regMoney) {
        this.regMoney = regMoney;
    }

    public Integer getRegManage() {
        return regManage;
    }

    public void setRegManage(Integer regManage) {
        this.regManage = regManage;
    }

    public Integer getRegRatio() {
        return regRatio;
    }

    public void setRegRatio(Integer regRatio) {
        this.regRatio = regRatio;
    }

    public Integer getAcLimit() {
        return acLimit;
    }

    public void setAcLimit(Integer acLimit) {
        this.acLimit = acLimit;
    }

    public Date getAcJssj() {
        return acJssj;
    }

    public void setAcJssj(Date acJssj) {
        this.acJssj = acJssj;
    }

    public String getAcPass() {
        return acPass;
    }

    public void setAcPass(String acPass) {
        this.acPass = acPass == null ? null : acPass.trim();
    }

    public String getAcPassRule() {
        return acPassRule;
    }

    public void setAcPassRule(String acPassRule) {
        this.acPassRule = acPassRule == null ? null : acPassRule.trim();
    }

    public Integer getAcSubsidy() {
        return acSubsidy;
    }

    public void setAcSubsidy(Integer acSubsidy) {
        this.acSubsidy = acSubsidy;
    }

    public Integer getAcSubRule() {
        return acSubRule;
    }

    public void setAcSubRule(Integer acSubRule) {
        this.acSubRule = acSubRule;
    }

    public Integer getAcSubLimit() {
        return acSubLimit;
    }

    public void setAcSubLimit(Integer acSubLimit) {
        this.acSubLimit = acSubLimit;
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate == null ? null : discountRate.trim();
    }

    public BigDecimal getMoneyMax() {
        return moneyMax;
    }

    public void setMoneyMax(BigDecimal moneyMax) {
        this.moneyMax = moneyMax;
    }

    public BigDecimal getMoneyMin() {
        return moneyMin;
    }

    public void setMoneyMin(BigDecimal moneyMin) {
        this.moneyMin = moneyMin;
    }

    public BigDecimal getDayMaxM() {
        return dayMaxM;
    }

    public void setDayMaxM(BigDecimal dayMaxM) {
        this.dayMaxM = dayMaxM;
    }

    public Integer getDayMaxT() {
        return dayMaxT;
    }

    public void setDayMaxT(Integer dayMaxT) {
        this.dayMaxT = dayMaxT;
    }

    public Integer getMealMaxM() {
        return mealMaxM;
    }

    public void setMealMaxM(Integer mealMaxM) {
        this.mealMaxM = mealMaxM;
    }

    public Integer getMealMaxT() {
        return mealMaxT;
    }

    public void setMealMaxT(Integer mealMaxT) {
        this.mealMaxT = mealMaxT;
    }

    public BigDecimal getTimeMaxM() {
        return timeMaxM;
    }

    public void setTimeMaxM(BigDecimal timeMaxM) {
        this.timeMaxM = timeMaxM;
    }

    public Integer getAcUnit() {
        return acUnit;
    }

    public void setAcUnit(Integer acUnit) {
        this.acUnit = acUnit;
    }

    public Integer getAcSubUnit() {
        return acSubUnit;
    }

    public void setAcSubUnit(Integer acSubUnit) {
        this.acSubUnit = acSubUnit;
    }

    public Integer getAcEarmark() {
        return acEarmark;
    }

    public void setAcEarmark(Integer acEarmark) {
        this.acEarmark = acEarmark;
    }

    public Integer getAcSubAuto() {
        return acSubAuto;
    }

    public void setAcSubAuto(Integer acSubAuto) {
        this.acSubAuto = acSubAuto;
    }

    public BigDecimal getSubMoney() {
        return subMoney;
    }

    public void setSubMoney(BigDecimal subMoney) {
        this.subMoney = subMoney;
    }

    public BigDecimal getAcOverdraw() {
        return acOverdraw;
    }

    public void setAcOverdraw(BigDecimal acOverdraw) {
        this.acOverdraw = acOverdraw;
    }

    public BigDecimal getSubMaxM() {
        return subMaxM;
    }

    public void setSubMaxM(BigDecimal subMaxM) {
        this.subMaxM = subMaxM;
    }

    public BigDecimal getMakeMaxM() {
        return makeMaxM;
    }

    public void setMakeMaxM(BigDecimal makeMaxM) {
        this.makeMaxM = makeMaxM;
    }

    public Integer getAcTimeState() {
        return acTimeState;
    }

    public void setAcTimeState(Integer acTimeState) {
        this.acTimeState = acTimeState;
    }

    public Integer getAcEach() {
        return acEach;
    }

    public void setAcEach(Integer acEach) {
        this.acEach = acEach;
    }

    public Integer getAcEachRule() {
        return acEachRule;
    }

    public void setAcEachRule(Integer acEachRule) {
        this.acEachRule = acEachRule;
    }

    public Integer getAcTimeOffset() {
        return acTimeOffset;
    }

    public void setAcTimeOffset(Integer acTimeOffset) {
        this.acTimeOffset = acTimeOffset;
    }

    public Integer getAcTimeType() {
        return acTimeType;
    }

    public void setAcTimeType(Integer acTimeType) {
        this.acTimeType = acTimeType;
    }

    public BigDecimal getAcTimeDay() {
        return acTimeDay;
    }

    public void setAcTimeDay(BigDecimal acTimeDay) {
        this.acTimeDay = acTimeDay;
    }

    public Integer getAcTimeMould() {
        return acTimeMould;
    }

    public void setAcTimeMould(Integer acTimeMould) {
        this.acTimeMould = acTimeMould;
    }

    public Integer getPassMax() {
        return passMax;
    }

    public void setPassMax(Integer passMax) {
        this.passMax = passMax;
    }

    public Integer getTallyMaxM() {
        return tallyMaxM;
    }

    public void setTallyMaxM(Integer tallyMaxM) {
        this.tallyMaxM = tallyMaxM;
    }

    public Integer getTallyMaxT() {
        return tallyMaxT;
    }

    public void setTallyMaxT(Integer tallyMaxT) {
        this.tallyMaxT = tallyMaxT;
    }

    public String getAcRegserial() {
        return acRegserial;
    }

    public void setAcRegserial(String acRegserial) {
        this.acRegserial = acRegserial == null ? null : acRegserial.trim();
    }

    public String getRegserial() {
        return regserial;
    }

    public void setRegserial(String regserial) {
        this.regserial = regserial == null ? null : regserial.trim();
    }

    public Integer getAcTimeeachType() {
        return acTimeeachType;
    }

    public void setAcTimeeachType(Integer acTimeeachType) {
        this.acTimeeachType = acTimeeachType;
    }

    public Integer getAcTimeeachDay() {
        return acTimeeachDay;
    }

    public void setAcTimeeachDay(Integer acTimeeachDay) {
        this.acTimeeachDay = acTimeeachDay;
    }

    public Integer getAcTimeeachMould() {
        return acTimeeachMould;
    }

    public void setAcTimeeachMould(Integer acTimeeachMould) {
        this.acTimeeachMould = acTimeeachMould;
    }

    public Integer getAcEachAuto() {
        return acEachAuto;
    }

    public void setAcEachAuto(Integer acEachAuto) {
        this.acEachAuto = acEachAuto;
    }
}