package com.cecep.dao;

import java.util.List;

import com.cecep.model.HaircutArticles;
import com.cecep.model.HaircutTerms;

public interface HaircutTermsMapper {
    int deleteByPrimaryKey(Integer termsId);

    int insert(HaircutTerms record);

    int insertSelective(HaircutTerms record);

    HaircutTerms selectByPrimaryKey(Integer termsId);

    int updateByPrimaryKeySelective(HaircutTerms record);

    int updateByPrimaryKey(HaircutTerms record);
    //分页查询
    List<HaircutTerms> selectByPage(HaircutTerms record);
    Integer selectCount(HaircutTerms record);
    Integer selectCount1(HaircutTerms record);
}