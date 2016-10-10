package com.cecep.dao;

import com.cecep.model.MedRecord;

public interface MedRecordMapper {
    int deleteByPrimaryKey(Integer medRecordId);

    int insert(MedRecord record);

    int insertSelective(MedRecord record);

    MedRecord selectByPrimaryKey(Integer medRecordId);

    int updateByPrimaryKeySelective(MedRecord record);

    int updateByPrimaryKey(MedRecord record);
}