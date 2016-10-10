package com.cecep.model;
/**
 * 离职实体类(tt_lizhi表)
 * @date 2016-03-16
 * */
public class TtLizhi {
	
    private String ttName;
    private Short ttOrder;
    private String tt1;
    private String tt2;
    private String tt3;
    private Integer tt5;
    private String glyNo;
    private String tt4;

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

    public String getTt1() {
        return tt1;
    }

    public void setTt1(String tt1) {
        this.tt1 = tt1 == null ? null : tt1.trim();
    }

    public String getTt2() {
        return tt2;
    }

    public void setTt2(String tt2) {
        this.tt2 = tt2 == null ? null : tt2.trim();
    }

    public String getTt3() {
        return tt3;
    }

    public void setTt3(String tt3) {
        this.tt3 = tt3 == null ? null : tt3.trim();
    }

    public Integer getTt5() {
        return tt5;
    }

    public void setTt5(Integer tt5) {
        this.tt5 = tt5;
    }

    public String getGlyNo() {
        return glyNo;
    }

    public void setGlyNo(String glyNo) {
        this.glyNo = glyNo == null ? null : glyNo.trim();
    }

    public String getTt4() {
        return tt4;
    }

    public void setTt4(String tt4) {
        this.tt4 = tt4 == null ? null : tt4.trim();
    }
}