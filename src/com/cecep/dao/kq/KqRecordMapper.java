package com.cecep.dao.kq;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.cecep.model.kq.KqCollect;
import com.cecep.model.kq.KqQuery;
import com.cecep.model.kq.KqRecord;
import com.cecep.model.kq.StatisticsRecord;
import com.cecep.model.kq.StatisticsRecordJiaban;
import com.cecep.model.kq.WorkTime;

public interface KqRecordMapper {
	
	List<KqRecord> selectByConditionAndPaging(KqQuery kqRecord);
	/** 统计迟到早退及外出*/
	List<KqCollect> selectByCondition1(KqQuery kqRecord);
	/** 统计加班*/
	List<KqCollect> selectByCondition2(KqQuery kqRecord);

	/** 获取上班时间列表*/
	List<WorkTime> getBeginWorkTime();

	/** 获取下班时间列表*/
	List<WorkTime> getEndWorkTime();
	
	/** 查询某个员工加班考勤记录*/
	List<String> getRecordDataListByJb(KqQuery query);

	/**根据部门编号查询部门名称*/
	String getDtDepByDepno(Map<String,Object> map);
	
	/** 插入考勤记录（测试使用）*/
	int insert(KqRecord record);
	/**个人考勤记录查询*/
	StatisticsRecord getPersonStatistics(KqQuery record);
	/**个人加班记录查询*/
	StatisticsRecordJiaban getPersonStatisticsJb(KqQuery record);
	/**个人加班记录迟到*/
	List<String> getRecordDataListKq(KqQuery query);
	List<KqRecord> kqQuery(KqQuery query);
	int getkqQueryTotal(KqQuery query);
	List<StatisticsRecord> kqRecordAnalyse(KqQuery query);
	void insertKqAnalyse(Map<String, Object> map);
	List<Date> selectAllDate();
	
}