package com.cecep.dao;

import java.util.List;



import com.cecep.model.DtCard;
import com.cecep.model.VisitorBlacklist;

public interface VisitorBlacklistMapper {
	
    int deleteByPrimaryKey(Long id);
    int insert(VisitorBlacklist record);
    int insertSelective(VisitorBlacklist record);
    VisitorBlacklist selectByPrimaryKey(Long id);
    Integer selectBySelective(VisitorBlacklist record);
    int updateByPrimaryKeySelective(VisitorBlacklist record);
    int updateByPrimaryKey(VisitorBlacklist record);
    
    //分页查询
    List<VisitorBlacklist> selectByPage(VisitorBlacklist record);
    Integer selectCount(VisitorBlacklist record);
    //查询卡片
    List<DtCard> selectDtCard();
    //查询卡片
    Integer selectDtCardBySelective(DtCard card);
    //查询卡片最大顺序号
    Integer selectMaxCardSerial();
    //修改卡片最大顺序号
    int updateCardSerial();
    //开卡(存储过程)
    int openCard(DtCard record);   
    //前台系统退卡同时取消门禁授权(存储过程)
    int returnCard(DtCard record);
    //后台系统退卡同时取消门禁授权并拉入黑名单(存储过程)
    int returnCard2(DtCard record);
    //导出查询
    List<VisitorBlacklist> export(VisitorBlacklist record);
	List<DtCard> selectDtCardByDeadline();
}