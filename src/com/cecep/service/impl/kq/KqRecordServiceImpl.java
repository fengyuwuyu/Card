package com.cecep.service.impl.kq;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.cache.DepCache;
import com.cecep.dao.DtDepMapper;
import com.cecep.dao.DtUserMapper;
import com.cecep.dao.KqSjManageMapper;
import com.cecep.dao.kq.HolidayMapper;
import com.cecep.dao.kq.KqRecordMapper;
import com.cecep.model.DtUser;
import com.cecep.model.KqSjManage;
import com.cecep.model.kq.KqCollect;
import com.cecep.model.kq.KqQuery;
import com.cecep.model.kq.KqRecord;
import com.cecep.model.kq.StatisticsInfo;
import com.cecep.model.kq.StatisticsRecord;
import com.cecep.model.kq.WorkTime;
import com.cecep.service.DtDepServiceI;
import com.cecep.service.kq.KqRecordServiceI;
import com.cecep.util.ExportExcel;
import com.cecep.util.KqStatisticsUtil;
import com.cecep.util.MapUtils;
import com.cecep.util.ThreadPool;

@Service("kqRecordService")
public class KqRecordServiceImpl implements KqRecordServiceI {

	private Logger log = Logger.getLogger(KqRecordServiceImpl.class);
	private KqRecordMapper kqRecordMapper;
	private HolidayMapper holidayMapper;
	private DtDepMapper depMapper;
	 private DtUserMapper userMapper;
	 private DtDepServiceI depServiceI;
	private KqSjManageMapper kqSjManageMapper;

	@Autowired
	public void setKqSjManageMapper(KqSjManageMapper kqSjManageMapper) {
		this.kqSjManageMapper = kqSjManageMapper;
	}

	 @Autowired
	 public void setDepServiceI(DtDepServiceI depServiceI) {
	 this.depServiceI = depServiceI;
	 }
	
	 @Autowired
	 public void setUserMapper(DtUserMapper userMapper) {
	 this.userMapper = userMapper;
	 }

	@Autowired
	public void setKqRecordMapper(KqRecordMapper kqRecordMapper) {
		this.kqRecordMapper = kqRecordMapper;
	}

	@Autowired
	public void setHolidayMapper(HolidayMapper holidayMapper) {
		this.holidayMapper = holidayMapper;
	}

	 @Autowired
	 public void setDepMapper(DtDepMapper depMapper) {
	 this.depMapper = depMapper;
	 }

	/**
	 * 根据考勤记录统计分析员工考勤
	 * 
	 * @param record
	 */
	public Map<String, Object> dataList(final KqQuery record, final DtUser user) {
		if(record==null||record.getKssj()==null||record.getJssj()==null){
			return MapUtils.createSuccessMap("rows",null,"total",0);
		}
		final Map<String, Object> map = new HashMap<String, Object>();
		final Integer personal = record.getPersonal();
		//如果是个人考勤统计
		if(personal!=null&&personal==1){
			record.setUserNo(user.getUserNo());
			List<KqCollect> list = this.kqRecordMapper.selectByCondition1(record);
			map.put("rows", list);
			map.put("total", 1);
		}else{
			StringBuilder allWorkNames = new StringBuilder();
			// 存储统计信息
			StatisticsInfo info = new StatisticsInfo();
			// 根据depSerial获取部门名称
			Integer[] depSerials = record.getDepSerial();
			StringBuilder sb = new StringBuilder();
			// 根据depSerial查询该部门员工人数
			int total = 0;
			List<String> usernames = new ArrayList<String>();
			if (depSerials != null) {
				Map<String,Object> param = new HashMap<String, Object>();
				param.put("depSerials", depSerials);
				List<String> depNames = this.depMapper.getDepNameBySerials(param);
				for(String depName : depNames){
					sb.append(depName+",");
				}
			}else{
				if(record.getUsername()==null||"".equals(record.getUsername())){
					//默认查询中节能总部
					depSerials = new Integer[1];
					String depSerial = this.depServiceI.getRootDepSerial("10000001");
					depSerials[0] = Integer.valueOf(depSerial);
					sb.append("中国节能环保集团公司总部,");
				}else{
					sb.append("个人考勤查询,");
				}
			}
			if(depSerials!=null){
				if (record.getType() == 1) {
					// 全体人员集合
					List<KqCollect> list = new ArrayList<KqCollect>();
					Set<Long> deps = new HashSet<Long>();
					for (Integer depSerial : depSerials) {
						Set<Long> sets = DepCache.getChildren(Long.valueOf(depSerial));
						deps.addAll(sets);
						Map<String,Object> res = new HashMap<String, Object>();
						res.put("list", sets);
						total += this.depMapper.getCountBySerials(res);
						record.setDepSerials(sets);
						record.setSerial(depSerial);
						List<KqCollect> tempList = this.kqRecordMapper.selectByCondition1(record);
						list.addAll(tempList);
					}
					Map<String,Object> userMap = new HashMap<String, Object>();
					if(deps.size()>0){
						userMap.put("depSerials", deps);
						usernames = this.userMapper.getNamesByDepSerials(userMap);
					}else{
						if(list.size()>0){
							for(KqCollect record2 : list){
								usernames.add(record2.getUsername());
							}
						}
					}
					map.put("rows", list);
					info.setAllWorkInfo(KqStatisticsUtil.subLastChar(allWorkNames));
					info.setPersonNum("总晚到早走人次:" + list.size());
				} else if (record.getType() == 2) {
					List<KqCollect> list = new ArrayList<KqCollect>();
					for (Integer depSerial : depSerials) {
						Set<Long> sets = DepCache.getChildren(Long.valueOf(depSerial));
						Map<String,Object> res = new HashMap<String, Object>();
						res.put("list", sets);
						total += this.depMapper.getCountBySerials(res);
						record.setDepSerials(sets);
						record.setSerial(depSerial);
						List<KqCollect> tempList = this.kqRecordMapper.selectByCondition1(record);
						list.addAll(tempList);
					}
					info.setPersonNum("总加班人次:" + list.size());
					map.put("rows", list);
				}
			}else{
				List<KqCollect> list = this.kqRecordMapper.selectByCondition1(record);
				map.put("rows", list);
				map.put("total", list.size());
			}
			
			info.setDepInfo("公司部门:" + (sb.substring(0,sb.length() - 1)) + "　人数：" + total);
			info.setDateInfo("日期:"+ KqStatisticsUtil.formatDateToString1(record.getKssj()) + "至 "
				+ KqStatisticsUtil.formatDateToString1(record.getJssj()));
			map.put("total", total);
			map.put("statisticsInfo", info);
		}
		
		// 根据用户名生成Excel文件,耗时且不需要等待结果的任务交给线程池执行
		ThreadPool.execute(new Runnable() {

			public void run() {
				exportExcel(map, record.getType(), user.getUserLname() , personal);
			}
		});
		return map;
	}

	/**
	 * 根据起始日期查询节假日
	 * 
	 * @param record
	 * @return
	 */
	private List<String> getVacationsByCondition(KqQuery record) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("kssj", record.getKssj());
		paramMap.put("jssj", record.getJssj());
		return this.holidayMapper.getVacationsByCondition(paramMap);
	}

	/**
	 * 根据查询类型导出Excel
	 * 
	 * @param map
	 * @param type
	 * @param username
	 */
	private void exportExcel(Map<String, Object> map, int type,
			String username, Integer personal) {
		try {
			if (type == 1) {
				ExportExcel.exportKq(map, username, personal);
			} else {
				ExportExcel.exportJiaban(map, username, personal);
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	/**
	 * 返回开始工作时间列表
	 */
	public List<WorkTime> getBeginWorkTime() {
		return this.kqRecordMapper.getBeginWorkTime();
	}

	/**
	 * 返回开始结束时间列表
	 */
	public List<WorkTime> getEndWorkTime() {
		return this.kqRecordMapper.getEndWorkTime();
	}

	public List<String> getRecordDataList(KqQuery query) {
		int queryType = query.getQueryType();
		String[] times = null;
		if (query.getDates() != null) {
			times = query.getDates().split(",");
		}
		query.setTimeArray(times);
		switch (queryType) {
		case 1:
		case 2:
			return this.kqRecordMapper.getRecordDataListKq(query);
		case 3:
			List<String> list = new ArrayList<String>();
			if (times != null && times.length > 0) {
				for (String s : times) {
					list.add(s);
				}
				return list;
			}
		case 4:
			return this.kqRecordMapper.getRecordDataListByJb(query);
		default:
			return new ArrayList<String>();
		}
	}

	public Map<String, Object> kqQuery(DtUser currUser, KqQuery query) {
		if (query.getKssj() == null) {
			return MapUtils.createSuccessMap("rows", new ArrayList<KqRecord>(),
					"total", 0);
		}

		if (query.getPersonal() != 1) {
			if (query.getUserDep() != null) {
				if (query.getUserDep() == 10000) {
					query.setUserDep(null);
				} else {
					Set<Long> depSerials = DepCache.getChildren(Long
							.valueOf(query.getUserDep() + ""));
					query.setDepSerials(depSerials);
					query.setUserDep(null);
				}
			}
		} else {
			query.setUserSerial(Integer.valueOf(currUser.getUserSerial() + ""));
		}
		List<KqRecord> list = this.kqRecordMapper.kqQuery(query);
		int total = this.kqRecordMapper.getkqQueryTotal(query);
		return MapUtils.createSuccessMap("rows", list, "total", total);
	}

	public Map<String, Object> kqDescribe(DtUser user, KqQuery record) {
		final Map<String, Object> map = new HashMap<String, Object>();
		List<String> days = KqStatisticsUtil.getDays(record.getKssj(),
				record.getJssj());
		List<String> holiday = this.getVacationsByCondition(record);
		List<String> workday = KqStatisticsUtil.getWorkday(days, holiday);
		// 记录加班或迟到早退人数
		Integer personNum = 0;
		record.setPersonal(1);
		;
		// 如果是个人考勤统计
		record.setUserNo(user.getUserNo());
		// if(record.getType()==1){
		List<KqCollect> list = this.kqRecordMapper
				.selectByCondition1(record);
		if (list != null && list.size() > 0) {
			// list.get(0).statistics(workday, record.getSbsj(),
			// record.getXbsj(), personNum);

		}
		map.put("rows", list);
		// }else{
		// List<StatisticsRecordJiaban> list =
		// this.kqRecordMapper.selectByCondition2(record);
		// list.get(0).statistics(personNum);
		// map.put("rows", list);
		// }
		map.put("total", 1);
		return map;
	}

	public void kqRecordAnalyse() {
		Date kssj = new Date(new java.util.Date().getTime());
		String holiday = this.holidayMapper.queryByDay(kssj); 
		boolean isHoliday = false;
		//判断当天是否是节假日
		if(holiday!=null){
			isHoliday = true;
		}
		// 1.根据当前日期查询门禁刷卡记录
		KqQuery query = new KqQuery();
		query.setKssj(kssj);
		List<StatisticsRecord> list = this.kqRecordMapper.kqRecordAnalyse(query);
		if(list==null||list.size()==0){
			return;
		}
		// 2.遍历集合，根据员工处理刷卡记录
		List<KqSjManage> times = this.kqSjManageMapper.dataList();
		Iterator<StatisticsRecord> it = list.iterator();
		while(it.hasNext()){
			StatisticsRecord statisticsRecord = it.next();
			statisticsRecord.statistics(isHoliday,times.get(0).getSj(), times.get(1).getSj(),KqStatisticsUtil.formatDateToString1(kssj));
			if(!statisticsRecord.isNeedInsert()){  //判断是否需要插入，若不需要则移除
				it.remove();
			}
		}
		// 3、将处理的结果分批插入法数据库中
		int length = list.size(),temp = 260,begin=0,end=temp;
		Map<String,Object> paramMap = MapUtils.createMap("list",list);
		if(length<=temp){
			this.kqRecordMapper.insertKqAnalyse(paramMap);
		}else{
			List<StatisticsRecord> subList = null;
			while(true){
				subList = list.subList(begin, end);
				paramMap.put("list",subList);
				this.kqRecordMapper.insertKqAnalyse(paramMap);
				begin+=temp;
				end+=temp;
				if(end>=length){
					end = length;
					subList = list.subList(begin, end);
					paramMap.put("list",subList);
					this.kqRecordMapper.insertKqAnalyse(paramMap);
					break;
				}
			}
		}
	}
	
	public void kqRecordAnalyse1() {
		List<Date> dates = this.kqRecordMapper.selectAllDate();
		for (Date kssj : dates) {
			String holiday = this.holidayMapper.queryByDay(kssj); 
			boolean isHoliday = false;
			//判断当天是否是节假日
			if(holiday!=null){
				isHoliday = true;
			}
			// 1.根据当前日期查询门禁刷卡记录
			KqQuery query = new KqQuery();
			query.setKssj(kssj);
			List<StatisticsRecord> list = this.kqRecordMapper.kqRecordAnalyse(query);
			if(list==null||list.size()==0){
				return;
			}
			// 2.遍历集合，根据员工处理刷卡记录
			List<KqSjManage> times = this.kqSjManageMapper.dataList();
			Iterator<StatisticsRecord> it = list.iterator();
			while(it.hasNext()){
				StatisticsRecord statisticsRecord = it.next();
				statisticsRecord.statistics(isHoliday,times.get(0).getSj(), times.get(1).getSj(),KqStatisticsUtil.formatDateToString1(kssj));
				if(!statisticsRecord.isNeedInsert()){  //判断是否需要插入，若不需要则移除
					it.remove();
				}
			}
			// 3、将处理的结果分批插入法数据库中
			int length = list.size(),temp = 260,begin=0,end=temp;
			Map<String,Object> paramMap = MapUtils.createMap("list",list);
			if(length<=temp){
				this.kqRecordMapper.insertKqAnalyse(paramMap);
			}else{
				List<StatisticsRecord> subList = null;
				while(true){
					subList = list.subList(begin, end);
					paramMap.put("list",subList);
					this.kqRecordMapper.insertKqAnalyse(paramMap);
					begin+=temp;
					end+=temp;
					if(end>=length){
						end = length;
						subList = list.subList(begin, end);
						paramMap.put("list",subList);
						this.kqRecordMapper.insertKqAnalyse(paramMap);
						break;
					}
				}
			}
		}
	}

	public Map<String, Object> kqSjManageDataList() {
		List<KqSjManage> list = this.kqSjManageMapper.dataList();
		return MapUtils.createSuccessMap("rows", list, "total", list.size());
	}

	public Map<String, Object> kqSjManageGetById(KqSjManage query) {
		KqSjManage manage = this.kqSjManageMapper.selectByPrimaryKey(query
				.getId());
		return MapUtils.createSuccessMap("data", manage);
	}

	public Map<String, Object> kqSjManageSave(KqSjManage query) {
		this.kqSjManageMapper.updateByPrimaryKey(query);
		return MapUtils.createSuccessMap("msg", "修改成功！");
	}

}
