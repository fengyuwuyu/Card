package com.cecep.model;

public class MedicineType extends  PageModel{
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
        this.medicineDetailed = medicineDetailed == null ? null : medicineDetailed.trim();
    }
}