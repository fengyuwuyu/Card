package com.cecep.dao;

import com.cecep.model.UserAccount;

public interface UserAccountMapper {
	int deleteByPrimaryKey(String uid);

    int insert(UserAccount record);

    int insertSelective(UserAccount record);

    UserAccount selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(String uid);

    int updateByPrimaryKey(UserAccount record);
    
    int  selectUserCount(String uid);
    
    int  query(String uid);
    
    int  selectValidateCount(UserAccount record);
    int  updateHang(String uid);
    int  ReplyAccount(String uid);
    int  selectSn(UserAccount record);
    
}