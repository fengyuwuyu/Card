package com.cecep.dao;

import java.util.List;

import com.cecep.model.HaircutArticles;

public interface HaircutArticlesMapper {
    int deleteByPrimaryKey(Integer articlesId);

    int insert(HaircutArticles record);

    int insertSelective(HaircutArticles record);

    HaircutArticles selectByPrimaryKey(Integer articlesId);

    int updateByPrimaryKeySelective(HaircutArticles record);

    int updateByPrimaryKey(HaircutArticles record);
    //分页查询
    List<HaircutArticles> selectByPage(HaircutArticles record);
    Integer selectCount(HaircutArticles record);
    Integer selectCount1(HaircutArticles record);
}