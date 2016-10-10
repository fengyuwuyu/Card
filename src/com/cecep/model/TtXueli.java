package com.cecep.model;
/**
 * 学历实体类(tt_xueli表)
 * @date 2016-03-16
 * */
public class TtXueli {
	
    private String ttName;
    private Short ttOrder;

    public String getTtName() {
        return ttName;
    }

    public void setTtName(String ttName) {
        this.ttName = ttName == null ? null : ttName.trim();
    }

    public Short getTtOrder() {
        return ttOrder;
    }

    public void setTtOrder(Short ttOrder) {
        this.ttOrder = ttOrder;
    }
}