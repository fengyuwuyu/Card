package com.cecep.service.impl.mess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.cache.DepCache;
import com.cecep.dao.DtDepMapper;
import com.cecep.dao.mess.MessConsumeMapper;
import com.cecep.model.DtUser;
import com.cecep.model.mess.DepNum;
import com.cecep.model.mess.MessConstant;
import com.cecep.model.mess.MessConsumeInfo;
import com.cecep.model.mess.MessQuery;
import com.cecep.model.mess.MessQuerySummary;
import com.cecep.model.mess.MessStatisticsInfo;
import com.cecep.model.mess.MessSummary;
import com.cecep.service.DtDepServiceI;
import com.cecep.service.mess.MessConsumeServiceI;
import com.cecep.util.CommonsUtil;
import com.cecep.util.DocumentHandler;
import com.cecep.util.ExportExcel;
import com.cecep.util.MapUtils;
import com.cecep.util.ThreadPool;

@Service("messConsumeService")
public class MessConsumeServiceImpl implements MessConsumeServiceI {
	private int count = 0;
	private MessConsumeMapper messConsumeMapper;
	private DtDepServiceI depServiceI;
	private Logger log = Logger.getLogger(MessConsumeServiceImpl.class);
	private DtDepMapper dtDepMapper;
	
	@Autowired
	public void setDtDepMapper(DtDepMapper dtDepMapper) {
		this.dtDepMapper = dtDepMapper;
	}

	@Autowired
	public void setDepServiceI(DtDepServiceI depServiceI) {
		this.depServiceI = depServiceI;
	}

	@Autowired
	public void setMessConsumeMapper(MessConsumeMapper messConsumeMapper) {
		this.messConsumeMapper = messConsumeMapper;
	}

	public Map<String, Object> dataList(MessQuery query, DtUser currUser) {
		if(query.getKssj()==null){
			return MapUtils.createMap("total",0,"rows",new ArrayList<MessConsumeInfo>());
		}
		if (query != null) {
			if (query != null && query.getDepNo() != null
					&& "00".equals(query.getDepNo()[0])) {
				int length = query.getDepNo().length;
				if (length == 1) {
					query.setDepNo(null);
				} else {
					String[] temp = new String[length - 1];
					for (int i = 1; i < length; i++) {
						temp[i - 1] = query.getDepNo()[i];
					}
					query.setDepNo(temp);
				}
			}
			if (query != null && query.getMachineBh() != null
					&& "00".equals(query.getMachineBh()[0])) {
				int length = query.getMachineBh().length;
				if (length == 1) {
					query.setMachineBh(null);
				} else {
					String[] temp = new String[length - 1];
					for (int i = 1; i < length; i++) {
						temp[i - 1] = query.getMachineBh()[i];
					}
					query.setMachineBh(temp);
				}
			}
		}
		List<MessConsumeInfo> list = new ArrayList<MessConsumeInfo>();
		final Map<String, Object> map = new HashMap<String, Object>();
		int total = 0;
		//个人查询消费记录
		Integer personal = query.getPersonal();
		if(personal!=null&&personal==1){
			query.setUserNo(currUser.getUserNo());
			list = this.messConsumeMapper.dataList(query);
			total = list.size();
			//员工所属部门及其下属部门消费记录
		}else{
			Long[] depSerials = query.getDepSerial();
			if(depSerials==null||depSerials.length==0){
				if(personal==0){
					//默认查询中节能总部
					String depSerial = this.depServiceI.getRootDepSerial("10000001");
					depSerials = new Long[]{Long.valueOf(depSerial)};
				}else if(personal==2){
					Integer depSerial = currUser.getUserDep();
					Integer level2DepSerial = this.dtDepMapper.getlevel2Serial(depSerial);
					if(level2DepSerial!=null){
						depSerial=level2DepSerial;
					}
					depSerials = new Long[]{Long.valueOf(depSerial)};
				}
			} 
			Arrays.sort(depSerials);
			int index = Arrays.binarySearch(depSerials, 10000L);
			boolean isRoot = false;
			if(index>=0){
				isRoot = true;
			}
			if(!isRoot){
				for (Long depSerial : depSerials) {
					Set<Long> lists = DepCache.getChildren(Long.valueOf(depSerial));
					if (lists.size() > 0) {
						query.setDepSerials(lists);
						query.setDepSerialSingle(depSerial);
						List<MessConsumeInfo> listTemp = this.messConsumeMapper
								.dataList(query);
						list.addAll(listTemp);
					}
				}
			}else{
				list = this.messConsumeMapper.dataList1(query);
			}
			total = list.size();
			MessQuerySummary sumary = new MessQuerySummary();
			sumary.setRemainMoney(CommonsUtil.getCss("总计："));
			sumary.setTradeDate(CommonsUtil.getCss(total));
			ArrayList<MessQuerySummary> footer = new ArrayList<MessQuerySummary>();
			footer.add(sumary);
			map.put("footer", footer);
		}
		List<MessConsumeInfo> subList = new ArrayList<MessConsumeInfo>();
		if (list != null && list.size() > 0) {
			subList = list.subList(query.getStart() - 1, (query.getStart()
					+ query.getRows() - 1) > total ? total : query.getStart()
					+ query.getRows() - 1);
			// 导出excel和word
			this.createQueryReport(query, list, total, currUser, null,
					"query.ftl");
		}
		map.put("rows", subList);
		map.put("total", total);
		return map;
	}

	public Map<String, Object> statistics(MessQuery query, DtUser currUser) {
		if(query==null||query.getKssj()==null||query.getJssj()==null){
			return MapUtils.createMap("total",0,"rows",new ArrayList<MessStatisticsInfo>());
		}
		List<MessStatisticsInfo> list = new ArrayList<MessStatisticsInfo>();
		Map<String, Object> map = new HashMap<String, Object>();
		if ( query.getDepNo() != null && "00".equals(query.getDepNo()[0])) {
			int length = query.getDepNo().length;
			if (length == 1) {
				query.setDepNo(null);
			} else {
				String[] temp = new String[length - 1];
				for (int i = 1; i < length; i++) {
					temp[i - 1] = query.getDepNo()[i];
				}
				query.setDepNo(temp);
			}
		}
		if (query != null && query.getMachineBh() != null
				&& "00".equals(query.getMachineBh()[0])) {
			int length = query.getMachineBh().length;
			if (length == 1) {
				query.setMachineBh(null);
			} else {
				String[] temp = new String[length - 1];
				for (int i = 1; i < length; i++) {
					temp[i - 1] = query.getMachineBh()[i];
				}
				query.setMachineBh(temp);
			}
		}
		int statisticType = query.getStatisticType();
		MessSummary summary = new MessSummary();
		final Integer personal = query.getPersonal();
		//如果是个人查询统计
		if(personal==1){
			query.setUserNo(currUser.getUserNo());
			list = this.messConsumeMapper.statisticsByPersonal(query);
		}else {
			Long[] depSerials = query.getDepSerial();
			switch (statisticType) {
			case MessConstant.STATISTIC_TYPE_DEP:
				if(depSerials==null||depSerials.length==0){
					if(personal==0){
						String depSerialRoot = this.depServiceI.getRootDepSerial("10000001");
						depSerials = new Long[]{Long.valueOf(depSerialRoot)};
					}else if(personal==2){
						Integer depSerialRoot = currUser.getUserDep();
						depSerials = new Long[]{Long.valueOf(depSerialRoot)};
					}
				}
				Arrays.sort(depSerials);
				int index = Arrays.binarySearch(depSerials, 10000L);
				boolean isRoot = false;
				if(index>=0){
					isRoot = true;
				}
				if(!isRoot){
					for (Long depSerial : depSerials) {
						Set<Long> lists =DepCache.getChildren(Long.valueOf(depSerial));
						if (lists.size() > 0) {
							query.setDepSerials(lists);
							query.setDepSerialSingle(depSerial);
							query.setDepSerial(String.valueOf(depSerial));
							List<MessStatisticsInfo> listTemp = this.messConsumeMapper
									.statisticsByDep(query);
							list.addAll(listTemp);
						}
					}
				}else{
					list = this.messConsumeMapper.statisticsByDep1(query);
				}
//				} else {
//					query.setDepSerial("10000");
//					Set<Long> lists = new HashSet<Long>();
//					this.depServiceI.getChildrenDepSerial(10000L, lists);
//					if (lists.size() > 0) {
//						query.setDepSerials(lists);
//						query.setDepSerialSingle(10000L);
//						List<MessStatisticsInfo> listTemp = this.messConsumeMapper
//								.statisticsByDep(query);
//						list.addAll(listTemp);
//					}
//				}
				break;
			case MessConstant.STATISTIC_TYPE_REGION:
				if (depSerials != null && depSerials.length > 0) {
					for (Long depSerial : depSerials) {
						Set<Long> lists = DepCache.getChildren(Long.valueOf(depSerial));
						if (lists.size() > 0) {
							query.setDepSerials(lists);
							query.setDepSerialSingle(depSerial);
							List<MessStatisticsInfo> listTemp = this.messConsumeMapper
									.statisticsByRegion(query);
							list.addAll(listTemp);
						}
					}
				} else {
					list = this.messConsumeMapper.statisticsByRegion(query);
				}
				break;
			case MessConstant.STATISTIC_TYPE_MACHINE:
				if(depSerials==null||depSerials.length==0){
					if(personal==0){
						String depSerial = this.depServiceI.getRootDepSerial("10000000");
						depSerials = new Long[]{Long.valueOf(depSerial)};
					}else if(personal==2){
						String depSerial = this.depServiceI.getRootDepSerial(currUser.getDepNo());
						depSerials = new Long[]{Long.valueOf(depSerial)};
					}
				}
//				if (depSerials != null && depSerials.length > 0) {
					for (Long depSerial : depSerials) {
						Set<Long> lists = DepCache.getChildren(Long.valueOf(depSerial));
						if (lists.size() > 0) {
							query.setDepSerials(lists);
							query.setDepSerialSingle(depSerial);
							List<MessStatisticsInfo> listTemp = this.messConsumeMapper
									.statisticsByMachine(query);
							list.addAll(listTemp);
						}
					}
//				} else {
//					list = this.messConsumeMapper.statisticsByMachine(query);
//				}
				break;
			}
			// 添加footer对象
		}
		int total = list.size();
		if (list != null && list.size() > 0) {
			for (MessStatisticsInfo info : list) {
				info.statistics(summary, query);
				if(personal==1){
					info.setRegion(currUser.getUserLname());
				}
			}
			if(query.getByDay()==null||"".equals(query.getByDay())){
				for(MessStatisticsInfo info : list){
					info.setDate(query.getKssj()+"至"+query.getJssj());
				}
			}
			// 导出excel和word
			this.createStatisticsReport(query, list, currUser, summary,
					"statistics.ftl", personal);
		}
		List<MessStatisticsInfo> subList = new ArrayList<MessStatisticsInfo>();
		if (list != null && list.size() > 0) {
			subList = list.subList(query.getStart() - 1, (query.getStart()
					+ query.getRows() - 1) > total ? total : query.getStart()
					+ query.getRows() - 1);
		}
		map.put("rows", subList);
		List<MessSummary> footer = new ArrayList<MessSummary>();
		footer.add(summary);
		map.put("footer", footer);
		map.put("total", list.size());
		return map;
	}

	/**
	 * 异步执行Excel文件导出 消费统计报表
	 * 
	 * @param query
	 *            查询条件，主要使用其中的开始时间与结束时间
	 * @param list
	 *            表格数据
	 * @param currUser
	 *            当前用户的信息，主要使用用户名
	 * @param summary
	 *            统计信息类
	 */
	private void createStatisticsReport(final MessQuery query,
			final List<MessStatisticsInfo> list, final DtUser currUser,
			final MessSummary summary, final String path, final Integer personal) {
		ThreadPool.execute(new Runnable() {

			public void run() {
				try {
					ExportExcel.exportMessStatistics(query, list, currUser,
							summary, personal);
					// 导出word
					Map<String, Object> exportWord = new HashMap<String, Object>();
					exportWord.put("list", list);
					exportWord.put("t", summary);
					exportWord.put("q", query);
					if(personal==1){
						exportWord.put("columnTitle", "员工姓名");
					}else{
						exportWord.put("columnTitle", "区域");
					}
					DocumentHandler.createDoc(exportWord, path, currUser);
				} catch (Exception e) {
					log.error(e);
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 异步执行Excel文件导出 消费查询报表
	 * 
	 * @param query
	 *            查询条件，主要使用其中的开始时间与结束时间
	 * @param list
	 *            表格数据
	 * @param currUser
	 *            当前用户的信息，主要使用用户名
	 */
	private void createQueryReport(final MessQuery query,
			final List<MessConsumeInfo> list, final int total,
			final DtUser currUser, final MessSummary summary, final String path) {
		ThreadPool.execute(new Runnable() {

			public void run() {
				try {
					// 导出excel
					ExportExcel.exportMessQuery(query, list, currUser, total);
					// 导出word
					Map<String, Object> exportWord = new HashMap<String, Object>();
					exportWord.put("list", list);
					exportWord.put("t", summary);
					exportWord.put("q", query);
					exportWord.put("total", total);
					DocumentHandler.createDoc(exportWord, path, currUser);
				} catch (Exception e) {
					log.error(e);
					e.printStackTrace();
				}
			}
		});
	}

	public Map<String, Object> depNum(final DtUser currUser, MessQuery query) {
		// TODO
		count = 0;
		Map<String, Object> result = new HashMap<String, Object>();
		final List<DepNum> list = new ArrayList<DepNum>();
		Long[] depSerials = query.getDepSerial();
		if (depSerials == null || depSerials.length == 0) {
			depSerials = new Long[1];
			depSerials[0] = 10000L;
		}
		for (Long depSerial : depSerials) {
			Set<Long> lists = DepCache.getChildren(Long.valueOf(depSerial));
			if (lists.size() > 0) {
				query.setDepSerials(lists);
				query.setDepSerialSingle(depSerial);
				list.addAll(this.messConsumeMapper.depNum(query));
			}
		}
		for(DepNum num : list){
			count+=num.getNum();
		}
		//将结果导出到Excel
		ThreadPool.execute(new Runnable() {
			
			public void run() {
				try {
					ExportExcel.exportDepNum(list, currUser.getUserLname(),count);
				} catch (Exception e) {
					log.error(e);
					e.printStackTrace();
				}
			}
		});
		int total = list.size();
		result.put("total", total);
		List<DepNum> subList = new ArrayList<DepNum>();
		if (list != null && list.size() > 0) {
			subList = list.subList(query.getStart() - 1, (query.getStart()
					+ query.getRows() - 1) > total ? total : query.getStart()
					+ query.getRows() - 1);
		}
		result.put("rows", subList);
		Map<String,Object> footer = new HashMap<String, Object>();
		footer.put("depParent", "总计：");
		footer.put("num", count);
		List<Map<String,Object>> li = new ArrayList<Map<String,Object>>();
		li.add(footer);
		result.put("footer", li);
		return result;
	}

	public List<Map<String, Object>> loadAcdep() {
		return this.messConsumeMapper.loadAcdep();
	}

}
