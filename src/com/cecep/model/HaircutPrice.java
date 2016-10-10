package com.cecep.model;

import java.math.BigDecimal;

public class HaircutPrice  extends PageModel {
    private Integer haircutId;

    private String haircutType;

    private BigDecimal price;

    private String haircutDesc;

    public Integer getHaircutId() {
        return haircutId;
    }

    public void setHaircutId(Integer haircutId) {
        this.haircutId = haircutId;
    }

    public String getHaircutType() {
        return haircutType;
    }

    public void setHaircutType(String haircutType) {
        this.haircutType = haircutType == null ? null : haircutType.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getHaircutDesc() {
        return haircutDesc;
    }

    public void setHaircutDesc(String haircutDesc) {
        this.haircutDesc = haircutDesc == null ? null : haircutDesc.trim();
    }
}