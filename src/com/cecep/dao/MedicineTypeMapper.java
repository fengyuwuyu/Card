package com.cecep.dao;

import java.util.List;

import com.cecep.model.MedicineType;

public interface MedicineTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(MedicineType record);

    int insertSelective(MedicineType record);

    MedicineType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(MedicineType record);

    int updateByPrimaryKey(MedicineType record);
    //分页查询
    List<MedicineType> selectByPage(MedicineType record);
    Integer selectCount(MedicineType record);
}