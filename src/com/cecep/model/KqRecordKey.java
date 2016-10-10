package com.cecep.model;

import java.util.Date;

public class KqRecordKey extends PageModel {
	/**刷卡时间*/
    protected Date sj;
    /**用户编号*/
    protected Integer userSerial;

    protected Integer bh;

    public Date getSj() {
        return sj;
    }

    public void setSj(Date sj) {
        this.sj = sj;
    }

    public Integer getUserSerial() {
        return userSerial;
    }

    public void setUserSerial(Integer userSerial) {
        this.userSerial = userSerial;
    }

    public Integer getBh() {
        return bh;
    }

    public void setBh(Integer bh) {
        this.bh = bh;
    }
}