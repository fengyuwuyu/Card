package com.cecep.service.kq;

import java.util.List;
import java.util.Map;

import com.cecep.model.DtUser;
import com.cecep.model.KqSjManage;
import com.cecep.model.kq.KqQuery;
import com.cecep.model.kq.WorkTime;

public interface KqRecordServiceI {

	/**
	 * 返回考勤统计结果
	 * @param record
	 * @param currUser
	 * @return
	 */
	Map<String,Object> dataList(KqQuery record, DtUser currUser);

	/**
	 * 返回考勤统计的时间
	 * @return
	 */
	List<WorkTime> getBeginWorkTime();

	List<WorkTime> getEndWorkTime();
	
	List<String> getRecordDataList(KqQuery query);

	Map<String, Object> kqQuery(DtUser currUser, KqQuery query);

	Map<String, Object> kqDescribe(DtUser currUser, KqQuery query);

	/**
	 * 处理每天的考勤日志
	 * 每天自动调用一次
	 * */
	void kqRecordAnalyse();

	Map<String, Object> kqSjManageDataList();

	Map<String, Object> kqSjManageGetById(KqSjManage query);

	Map<String, Object> kqSjManageSave(KqSjManage query);
	
	/**
	 * 处理所有的考勤日志
	 * 调用前需先清空kq_collect表
	 * */
	void kqRecordAnalyse1();

}
