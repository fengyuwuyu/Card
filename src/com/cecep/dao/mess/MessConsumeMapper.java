package com.cecep.dao.mess;

import java.util.List;
import java.util.Map;

import com.cecep.model.mess.DepNum;
import com.cecep.model.mess.MessConsumeInfo;
import com.cecep.model.mess.MessQuery;
import com.cecep.model.mess.MessStatisticsInfo;

public interface MessConsumeMapper {
	
	/** 查询食堂消费*/
	List<MessConsumeInfo> dataList(MessQuery query);
	
	Integer getTotal(MessQuery query);
	
	List<MessStatisticsInfo> statisticsByDep(MessQuery query);

	List<MessStatisticsInfo> statisticsByRegion(MessQuery query);

	List<MessStatisticsInfo> statisticsByMachine(MessQuery query);

	void insert(Map<String, Object> map);

	List<DepNum> depNum(MessQuery query);

	List<MessStatisticsInfo> statisticsByPersonal(MessQuery query);

	List<MessConsumeInfo> dataList1(MessQuery query);

	List<MessStatisticsInfo> statisticsByDep1(MessQuery query);

	List<Map<String, Object>> loadAcdep();

}