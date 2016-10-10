package com.cecep.dao;

import java.util.List;
import java.util.Map;

import com.cecep.model.MedAccount;
import com.cecep.model.Medicine;
import com.cecep.model.PurOrder;

public interface PurOrderMapper {
    int deleteByPrimaryKey(Integer orderId);
    int insert(PurOrder record);
    int insertSelective(PurOrder record);
    PurOrder selectByPrimaryKey(Integer orderId);
    int updateByPrimaryKeySelective(PurOrder record);
    int updateByPrimaryKey(PurOrder record);
    Map<String,Object> medicineMsg(Medicine record);
    int addPurchaseForm(PurOrder record);
    Map<String,Object> getUserData(PurOrder record);
    int updateAmount(PurOrder record);//修改账户金额
    Double selectAmount(PurOrder record);//查询账户余额
    int selectinsertid(PurOrder record);//查询插入的id
    int addRecord(PurOrder record);//消费记录
    int selectAccountId(PurOrder record);//消费记录
    int updateInventory(PurOrder record);//修改库存数量
    int selectInventory(PurOrder record);//查询库存数量
    String selectMedName(PurOrder record);//查询药品名称
    
    List<PurOrder> selectByPage1(PurOrder record);
    Integer selectCount1(PurOrder record);
    List<PurOrder> selectByPage2(PurOrder record);
    Integer selectCount2(PurOrder record);
    
    List<PurOrder> selectByPage3(PurOrder record);
    Integer selectCount3(PurOrder record);
    List<PurOrder> selectByPage4(PurOrder record);
    Integer selectCount4(PurOrder record);
    List<PurOrder> selectByPage5(PurOrder record);
    List<PurOrder> selectByPage6(PurOrder record);
    List<PurOrder> selectByPage7(PurOrder record);
    List<PurOrder> selectByPage8(PurOrder record);
    Map<String, Object>  selectByUser(PurOrder record);
    List<MedAccount>   personalRecharge(PurOrder record);
    int  personalRechargeCou(PurOrder record);
    
}