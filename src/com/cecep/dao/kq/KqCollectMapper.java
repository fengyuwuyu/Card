package com.cecep.dao.kq;

import com.cecep.model.kq.KqCollect;

public interface KqCollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KqCollect record);

    int insertSelective(KqCollect record);

    KqCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KqCollect record);

    int updateByPrimaryKey(KqCollect record);
}