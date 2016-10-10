package com.cecep.model;

public class HaircutTerms extends PageModel{
    private Integer termsId;

    private String termsName;

    public Integer getTermsId() {
        return termsId;
    }

    public void setTermsId(Integer termsId) {
        this.termsId = termsId;
    }

    public String getTermsName() {
        return termsName;
    }

    public void setTermsName(String termsName) {
        this.termsName = termsName == null ? null : termsName.trim();
    }
}