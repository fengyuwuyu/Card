package com.cecep.dao;

import java.util.List;
import java.util.Map;

import com.cecep.model.CecepWords;
import com.cecep.model.DtUser;

public interface CecepWordsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CecepWords record);

    int insertSelective(CecepWords record);

    CecepWords selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CecepWords record);

    int updateByPrimaryKey(CecepWords record);

	void updateSynchronized(Map<String, Object> map);

	List<DtUser> selectAllUsersBySync();

	List<CecepWords> selectAllPinYin();

	void updateCecepUserPrivilege(DtUser dtUser);

	List<String> selectDtUserByPinYin(Map<String, Object> map);

	void insertList(Map<String, Object> map);
}