package com.cecep.model;

import java.math.BigDecimal;

public class HaircutArticles  extends  PageModel{
    private Integer articlesId;

    private String articlesName;

    private BigDecimal articlesPrice;

    private String articlesDesc;
    
    private String articlesAddress;
    private Integer termsId;
    
    
    public Integer getTermsId() {
		return termsId;
	}

	public void setTermsId(Integer termsId) {
		this.termsId = termsId;
	}

	public String getArticlesAddress() {
		return articlesAddress;
	}

	public void setArticlesAddress(String articlesAddress) {
		this.articlesAddress = articlesAddress;
	}

	public Integer getArticlesId() {
        return articlesId;
    }

    public void setArticlesId(Integer articlesId) {
        this.articlesId = articlesId;
    }

    public String getArticlesName() {
        return articlesName;
    }

    public void setArticlesName(String articlesName) {
        this.articlesName = articlesName == null ? null : articlesName.trim();
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
        this.articlesDesc = articlesDesc == null ? null : articlesDesc.trim();
    }
}