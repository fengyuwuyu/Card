package com.cecep.dao;



import com.cecep.model.DtCard;
import com.cecep.model.DtUser;

public interface DtCardMapper {
	
    int deleteByPrimaryKey(String cardSerial);
    int insert(DtCard record);
    int insertSelective(DtCard record);
    DtCard selectByPrimaryKey(String cardSerial);
    DtCard selectBySelective(DtCard record);
    int updateByPrimaryKeySelective(DtCard record);
    int updateByPrimaryKey(DtCard record);
    
    //查询卡片最大顺序号
    Integer selectMaxCardSerial();
    //修改卡片最大顺序号
    int updateCardSerial();
    //开卡(厂商存储过程)
    int openCard(DtCard record); 
    //开卡同时门禁授权中更换物理卡号(厂商存储过程)
    int openCard2(DtCard record); 
    //挂失(厂商存储过程)
    int lockCard(DtCard record);
    //读卡
    DtUser readCard(String cardHao);
    //解挂(厂商存储过程)
    int unlockCard(DtCard record);
    //退卡(厂商存储过程)
    int returnCard(DtCard record);
    //退卡同时取消门禁授权(存储过程)
    int returnCard2(DtCard record);
    /** 更新中间表cecep_user_privilege的deadline值*/
	void updateDeadline(DtCard record);
    
}