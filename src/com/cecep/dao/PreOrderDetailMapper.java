package com.cecep.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.cecep.model.PreOrderDetail;

public interface PreOrderDetailMapper {
    int deleteByPrimaryKey(Integer preOrderId1);
    int delete(Integer preOrderId1);
    int insert(PreOrderDetail record);

    int insertSelective(PreOrderDetail record);

    PreOrderDetail selectByPrimaryKey(Integer preOrderId);

    int updateByPrimaryKeySelective(PreOrderDetail record);

    int updateByPrimaryKey(PreOrderDetail record);
    
    
    //分页查询
    List<PreOrderDetail> selectByPage(PreOrderDetail record);
    Integer selectCount(PreOrderDetail record);
    
    /**
     * 添加修改预订人信息
     */
    int insertUser(PreOrderDetail record);
    int updateUser(PreOrderDetail record);
    PreOrderDetail selectUser(Integer preOrderId1);
    //分页药品详细查询
    List<PreOrderDetail> selectByPage1(PreOrderDetail record);
    Integer selectCount1(PreOrderDetail record);
    String getType(Integer preOrderId1);
    int getCardNumber(PreOrderDetail record);
    String getCardNumberType(PreOrderDetail record);
    int updateMedAccount(PreOrderDetail record);//修改医药账户余额
    int updatePreOrder(PreOrderDetail record);//修改预定状态
    BigDecimal selectAmount(PreOrderDetail record);
    List<Map<String,Object>> checkPrintMsg(PreOrderDetail record);
    
    
}