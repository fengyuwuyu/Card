package com.cecep.model;

import java.math.BigDecimal;
import java.util.Date;

public class HaircutStorage extends  PageModel{
    private Integer storageId;

    private Integer storageNum;

    private Date storageDate;

    private Integer articlesId;
    
    
    
    
    
    
    
    /**
     * 用品信息
     */
    private String articlesName;

    private BigDecimal articlesPrice;

    private String articlesDesc;
    
    private String articlesAddress;
    
    
    
    
    
    

    public String getArticlesName() {
		return articlesName;
	}

	public void setArticlesName(String articlesName) {
		this.articlesName = articlesName;
	}

	public BigDecimal getArticlesPrice() {
		return articlesPrice;
	}

	public void setArticlesPrice(BigDecimal articlesPrice) {
		this.articlesPrice = articlesPrice;
	}

	public String getArticlesDesc() {
		return articlesDesc;
	}

	public void setArticlesDesc(String articlesDesc) {
		this.articlesDesc = articlesDesc;
	}

	public String getArticlesAddress() {
		return articlesAddress;
	}

	public void setArticlesAddress(String articlesAddress) {
		this.articlesAddress = articlesAddress;
	}

	public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public Integer getStorageNum() {
        return storageNum;
    }

    public void setStorageNum(Integer storageNum) {
        this.storageNum = storageNum;
    }

    public Date getStorageDate() {
        return storageDate;
    }

    public void setStorageDate(Date storageDate) {
        this.storageDate = storageDate;
    }

    public Integer getArticlesId() {
        return articlesId;
    }

    public void setArticlesId(Integer articlesId) {
        this.articlesId = articlesId;
    }
}