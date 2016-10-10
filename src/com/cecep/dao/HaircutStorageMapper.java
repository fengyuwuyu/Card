package com.cecep.dao;

import java.util.List;

import com.cecep.model.HaircutStorage;

public interface HaircutStorageMapper {
    int deleteByPrimaryKey(Integer storageId);

    int insert(HaircutStorage record);

    int insertSelective(HaircutStorage record);

    HaircutStorage selectByPrimaryKey(Integer storageId);

    int updateByPrimaryKeySelective(HaircutStorage record);

    int updateByPrimaryKey(HaircutStorage record);
    
    //分页查询
    List<HaircutStorage> selectByPage(HaircutStorage record);
    Integer selectCount(HaircutStorage record);
}