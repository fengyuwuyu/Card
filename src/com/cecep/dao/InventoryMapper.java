package com.cecep.dao;

import java.util.List;

import com.cecep.model.Inventory;

public interface InventoryMapper {
    int deleteByPrimaryKey(Integer inventoryId);
    
    int insert(Inventory record);
    int insertdetailed(Inventory record);//添加关联入库明细
    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(Integer inventoryId);

    int updateByPrimaryKeySelective(Inventory record);
    int updateType(Integer invRecordId);
    

    int updateByPrimaryKey(Inventory record);
    
    int updateOutMedicine(Inventory record);//删除过期药品的库存数量
    //查询出过期药品的数量
    List<Inventory> outTimeMedicine(Inventory record); 
    int updateMoney(Inventory record);//代购结算
    int saveMoneyMsg(Inventory record);//代购结算
    
    //分页查询
    List<Inventory> selectByPage(Inventory record);
    Integer selectCount(Inventory record);
    Integer selectCou(Inventory record);
    int selectinsertid(Inventory record);//查询刚插入的主键id
    int selectid(Inventory record);//查询主键id
    List<Inventory> impotmsg(Inventory record);
    List<Inventory> selectByPage1(Inventory record);
    Integer selectCount1(Inventory record);
    List<Inventory> selectByPage2(Inventory record);
    Integer selectCount2(Inventory record);
    List<Inventory> selectByPage3(Inventory record);
    List<Inventory> selectByPage4(Inventory record);
    
    int updateInventory(Inventory record);
    
}