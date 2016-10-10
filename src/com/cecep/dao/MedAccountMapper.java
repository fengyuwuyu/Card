package com.cecep.dao;

import java.util.List;
import java.util.Map;

import com.cecep.model.MedAccount;

public interface MedAccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(MedAccount record);

    int insertSelective(MedAccount record);

    MedAccount selectByPrimaryKey(Integer accountId);
    /**
     * 查询员工详细信息
     * @param userSerial
     * @return
     */
    MedAccount selectEmployeeByKey(Integer userSerial);
    int updateByPrimaryKeySelective(MedAccount record);

    int updateByPrimaryKey(MedAccount record);
    
    //分页查询
    List<MedAccount> selectByPage(MedAccount record);
    Integer selectCount(MedAccount record);
    List<MedAccount> selectCardNum(MedAccount record);//查询出所有账户
    
    int getNum(Integer userSerial);
    int insertCardHao(Integer userSerial);
    
    
    
    /**
     * 充值记录
     * @param record
     * @return
     */
    List<MedAccount> selectByPage1(MedAccount record);
    Integer selectCount1(MedAccount record);
    int rechargeMoney(MedAccount record);
    int addMedicineRecord(MedAccount record);
    int  cardnum(Integer userno);
    
    
    //分页查询人员情况 转移金额
    List<MedAccount> selectByPage2(MedAccount record);
    Integer selectCount2(MedAccount record);
    //转移金额
    int updateMoney1(MedAccount record);
    int updateMoney2( MedAccount record);
    int addrecord( MedAccount record);//金额转移充值记录
    
    List<MedAccount> selectByPage3(MedAccount record);
    Integer selectCount3(MedAccount record);
    List<MedAccount> selectByPage4(MedAccount record);
    Integer selectCount4(MedAccount record);
    List<MedAccount> selectByPage5(MedAccount record);
    Integer selectCount5(MedAccount record);
    //导出数据
    List<MedAccount> selectByPage6(MedAccount record);
    List<MedAccount> selectByPage7(MedAccount record);
    List<MedAccount> selectByPage8(MedAccount record);
    List<MedAccount> selectByPage9(MedAccount record);	
    Map<String, Object>  selectByUser(MedAccount record);
    
    List<MedAccount> selectByPage10(MedAccount record);
    Integer selectCount10(MedAccount record);
    
    List<MedAccount>   personalRecharge(MedAccount record);
    int  personalRechargeCou(MedAccount record);
    
}