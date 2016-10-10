package com.cecep.dao;

import java.util.List;

import com.cecep.model.KqSjManage;

public interface KqSjManageMapper {
   /* int deleteByPrimaryKey(Integer id);

    int insert(KqSjManage record);

    int insertSelective(KqSjManage record);*/

    KqSjManage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KqSjManage record);

    int updateByPrimaryKey(KqSjManage record);

	List<KqSjManage> dataList();
}