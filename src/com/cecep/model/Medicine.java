package com.cecep.model;

import java.math.BigDecimal;

public class Medicine extends  PageModel{
    private Integer medicineId;


    private String medicineName;

    private BigDecimal price;//金额的定义

    private String proDate;

    private String dueDate;

    private String vendor;

    private String medicineDesc;
    private String  medicineType;
    private String barCode;
    
    
    public String getMedicineType() {
		return medicineType;
	}

	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}

	/**
     * 分类关联信息
     * @return
     */
    
    private Integer typeId;

    private String typeName;

    private String medicineDetailed;
    
    
    public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getMedicineDetailed() {
		return medicineDetailed;
	}

	public void setMedicineDetailed(String medicineDetailed) {
		this.medicineDetailed = medicineDetailed;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	
    

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }


    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName == null ? null : medicineName.trim();
    }


    public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getProDate() {
        return proDate;
    }

    public void setProDate(String proDate) {
        this.proDate = proDate == null ? null : proDate.trim();
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate == null ? null : dueDate.trim();
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor == null ? null : vendor.trim();
    }

    public String getMedicineDesc() {
        return medicineDesc;
    }

    public void setMedicineDesc(String medicineDesc) {
        this.medicineDesc = medicineDesc == null ? null : medicineDesc.trim();
    }
}