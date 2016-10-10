package com.cecep.dao;

import java.util.List;

import com.cecep.model.HaircutPrice;

public interface HaircutPriceMapper {
    int deleteByPrimaryKey(Integer haircutId);

    int insert(HaircutPrice record);

    int insertSelective(HaircutPrice record);

    HaircutPrice selectByPrimaryKey(Integer haircutId);

    int updateByPrimaryKeySelective(HaircutPrice record);

    int updateByPrimaryKey(HaircutPrice record);
    //分页查询
    List<HaircutPrice> selectByPage(HaircutPrice record);
    Integer selectCount(HaircutPrice record);
}