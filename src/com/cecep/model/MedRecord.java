package com.cecep.model;

import java.util.Date;

public class MedRecord {
    private Integer medRecordId;

    private Long amount;

    private Date medTime;

    private Integer accountId;

    private Integer orderId;

    public Integer getMedRecordId() {
        return medRecordId;
    }

    public void setMedRecordId(Integer medRecordId) {
        this.medRecordId = medRecordId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getMedTime() {
        return medTime;
    }

    public void setMedTime(Date medTime) {
        this.medTime = medTime;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}