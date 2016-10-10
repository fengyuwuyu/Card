package com.cecep.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.cache.DepCache;
import com.cecep.dao.DtAcDepMapper;
import com.cecep.dao.DtDepMapper;
import com.cecep.dao.MidDepMapper;
import com.cecep.model.CecepDep;
import com.cecep.model.DtDep;
import com.cecep.model.MidDep;
import com.cecep.service.MidDepServiceI;
import com.cecep.util.CommonsUtil;
import com.cecep.util.MapUtils;
import com.cecep.util.ThreadPool;

@Service("midDepService")
public class MidDepServiceImpl implements MidDepServiceI {

	private MidDepMapper midDepMapper;
	private DtDepMapper dtDepMapper;
	private DtAcDepMapper acDepMapper;

	@Autowired
	public void setMidDepMapper(MidDepMapper midDepMapper) {
		this.midDepMapper = midDepMapper;
	}

	@Autowired
	public void setDtDepMapper(DtDepMapper dtDepMapper) {
		this.dtDepMapper = dtDepMapper;
	}

	@Autowired
	public void setAcDepMapper(DtAcDepMapper acDepMapper) {
		this.acDepMapper = acDepMapper;
	}

	public Map<String, Object> selectIsSynchronized(MidDep record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer count = 0;
		count = this.midDepMapper.selectIsSynchronized();
		map.put("count", count);
		return map;
	}

	public List<Map<String, Object>> load(String id) {
		List<Map<String, Object>> list = this.midDepMapper.load(id);
		return list;
	}

	public void save(MidDep record) {
		Integer count = this.midDepMapper.selectByPrimaryKey(record
				.getIu_code());
		if (count > 0) {
			this.midDepMapper.updateByPrimaryKey(record);
		} else {
			this.midDepMapper.insert(record);
		}
	}

	public Map<String, Object> synchronize(String[] depNos) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Map<String, Object> parameterMap1 = new HashMap<String, Object>();
		parameterMap.put("depNos", depNos);
		List<DtDep> list = this.midDepMapper.synchronize(parameterMap);
		if (list.size() > 0) {
			parameterMap1.put("list", list);
			this.midDepMapper.updateIsSynchronized(parameterMap1);
			for (DtDep dep : list) {
				if (dep.getDepSerial() == null) {
					this.dtDepMapper.updateDepSerial();
					Integer serial = this.dtDepMapper.selectMaxDepSerial();
					// 序号
					dep.setDepSerial(Long.parseLong(serial + ""));
					this.dtDepMapper.insert(dep);
					String [] acdepSerials = this.midDepMapper.getAcdepSerialByDepNo(dep.getDepNo());
					if(acdepSerials!=null&&acdepSerials.length>0){
						String depSerial = this.dtDepMapper.getRootDepSerial(MapUtils.createMap("depNo",dep.getDepNo()));
						this.saveAcdepAndDep(acdepSerials, depSerial);
					}
				} else {
					this.dtDepMapper.updateByPrimaryKey(dep);
				}
			}
		}
		// 异步更新DepCache
		ThreadPool.execute(new Runnable() {

			public void run() {
				DepCache.init(dtDepMapper);
			}
		});
		resultMap.put("success", true);
		resultMap.put("msg", "同步成功！");
		return resultMap;
	}

	/**
	 * 根据cecep_dep表中的数据初始化dt_dep表，只进行一次
	 * 
	 * @param parentId
	 * @return
	 */
	public Map<String, Object> synchronizeFirst(String parentId) {
		// TODO
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Map<String, Object> parameterMap1 = new HashMap<String, Object>();
		parameterMap.put("first", true);
		parameterMap1.put("first", true);
		List<String> depNos = this.midDepMapper.selectCecepDep(parentId);
		if (depNos != null && depNos.size() > 0) {
			parameterMap.put("depNos", depNos);
			List<DtDep> list = this.midDepMapper.synchronize(parameterMap);
			if (list!=null&&list.size() > 0) {
				String acdepSerial = null;
				String []acdepSerials = null;
				for (DtDep dep : list) {
					if (dep.getDepSerial() == null) {
						this.dtDepMapper.updateDepSerial();
						Integer serial = this.dtDepMapper.selectMaxDepSerial();
						// 序号
						dep.setDepSerial(Long.parseLong(serial + ""));
						this.dtDepMapper.insert(dep);
						//设置部门与场所的关联关系
						int extend = dep.getExtend();
						if(extend==0){
							acdepSerials = this.midDepMapper.getAcdepSerialByDepNo(parentId);
						}else if(extend==1){
							acdepSerial = dep.getAcdepSerial();
						}
						if(acdepSerial!=null){
							acdepSerials = acdepSerial.split(",");
						}
						if(acdepSerials!=null&&acdepSerials.length>0){
							String depSerial = this.dtDepMapper.getRootDepSerial(MapUtils.createMap("depNo",dep.getDepNo()));
							this.saveAcdepAndDep(acdepSerials, depSerial);
						}
					} else {
						this.dtDepMapper.updateByPrimaryKey(dep);
					}
					this.synchronizeFirst(dep.getDepNo());
				}
				this.midDepMapper.updateHasSynchronized(MapUtils.createMap(
						"depNos", list));
			}
			//将mid_dep表中的所有数据的is_synchronized字段更新为1
			this.midDepMapper.updateIsSynchronized(parameterMap1);
			return MapUtils.createSuccessMap("msg", "同步成功！");
		} else {
			return MapUtils.createFailedMap("msg",
					"同步失败，cecep_dep表中没有数据，请及时联系管理员进行处理！");
		}
	}
	
	/**
	 * 根据cecep_dep表中的数据初始化dt_dep表，只进行一次
	 * 
	 * @param parentId
	 * @return
	 */
//	public Map<String, Object> synchronizeFirstExternal(String parentId) {
//		Map<String, Object> parameterMap = new HashMap<String, Object>();
//		Map<String, Object> parameterMap1 = new HashMap<String, Object>();
//		parameterMap.put("first", true);
//		parameterMap1.put("first", true);
//		List<String> depNos = this.midDepMapper.selectCecepDep(parentId);
//		if (depNos != null && depNos.size() > 0) {
//			parameterMap.put("depNos", depNos);
//			List<DtDep> list = this.midDepMapper.synchronize(parameterMap);
//			if (list.size() > 0) {
//				String acdepSerial = null;
//				String []acdepSerials = null;
//				for (DtDep dep : list) {
//					if (dep.getDepSerial() == null) {
//						this.dtDepMapper.updateDepSerial();
//						Integer serial = this.dtDepMapper.selectMaxDepSerial();
//						// 序号
//						dep.setDepSerial(Long.parseLong(serial + ""));
//						this.dtDepMapper.insert(dep);
//						//设置部门与场所的关联关系
//						int extend = dep.getExtend();
//						if(extend==0){
//							acdepSerials = this.midDepMapper.getAcdepSerialByDepNo(parentId);
//						}else if(extend==1){
//							acdepSerial = dep.getAcdepSerial();
//						}
//						if(acdepSerial!=null){
//							acdepSerials = acdepSerial.split(",");
//						}
//						if(acdepSerials!=null&&acdepSerials.length>0){
//							String depSerial = this.dtDepMapper.getRootDepSerial(MapUtils.createMap("depNo",dep.getDepNo()));
//							this.saveAcdepAndDep(acdepSerials, depSerial);
//						}
//					} else {
//						this.dtDepMapper.updateByPrimaryKey(dep);
//					}
//					this.synchronizeFirst(dep.getDepNo());
//				}
//				this.midDepMapper.updateHasSynchronized(MapUtils.createMap(
//						"depNos", list));
//			}
//			//将mid_dep表中的所有数据的is_synchronized字段更新为1
//			this.midDepMapper.updateIsSynchronized(parameterMap1);
//			return MapUtils.createSuccessMap("msg", "同步成功！");
//		} else {
//			return MapUtils.createFailedMap("msg",
//					"同步失败，cecep_dep表中没有数据，请及时联系管理员进行处理！");
//		}
//	}

	/**
	 * 查询未同步的部门，若存在未同步的部门则返回false，否则返回true；用于确保同步员工数据前所有部门已同步
	 */
	public Map<String, Object> midDepCount() {
		int count = this.midDepMapper.selectIsSynchronized();
		if (count != 0) {
			return MapUtils.createFailedMap("msg", "请先去部门管理功能中同步部门数据！");
		}
		return MapUtils.createSuccessMap();
	}

	public List<Map<String, Object>> acDepLoad() {
		return this.acDepMapper.selectAcDepByDoor();
	}

	/**
	 * 绑定部门与场所之间的关系
	 */
	public Map<String, Object> saveAcdepAndDep(String[] ids, String depSerial) {
		if (depSerial != null) {
			this.acDepMapper.deleteAcdepAndDep(depSerial);
			if(ids == null || ids.length == 0){
				return MapUtils.createSuccessMap("msg", "解除绑定成功！");
			}
			this.acDepMapper.insertDtDev(MapUtils.createMap("depSerial", depSerial,"ids", ids));
			
		}
		return MapUtils.createSuccessMap("msg", "绑定场所成功！");
	}
	
	/**
	 * 绑定部门与场所之间的关系（包括下级部门）
	 */
	public Map<String, Object> saveAcdepAndDep1(String[] ids, String depSerial) {
		if (depSerial != null ) {
			Set<Long> depSerials = DepCache.getChildren(Long.valueOf(depSerial));
			this.acDepMapper.deleteAcdepAndDep1(MapUtils.createMap("depSerials",depSerials));
			if(ids == null || ids.length == 0){
				return MapUtils.createSuccessMap("msg", "解除绑定成功！");
			}
			for(Long serial : depSerials){
				this.acDepMapper.insertDtDev(MapUtils.createMap("depSerial",serial,"ids", ids));
			}
		}
		return MapUtils.createSuccessMap("msg", "绑定场所(包含下级部门)成功！");
	}

	public Map<String, Object> selectAcdepAndDep(String depSerial) {
		if (depSerial == null) {
			return MapUtils.createFailedMap("msg", "系统异常，请联系管理员！");
		}
		String[] acDepSerials = this.acDepMapper.selectAcDepSerials(depSerial);
		String result = CommonsUtil.join(acDepSerials, ",");
		return MapUtils.createSuccessMap("data", result);
	}

	/**
	 * 初始化cecep_dep表
	 */
	public void insertInitData() {
		List<String> ids = this.midDepMapper.selectBenBu();
		if (ids != null && ids.size() > 0) {
			List<CecepDep> deps = this.midDepMapper.selectByIds(MapUtils
					.createMap("ids", ids));
			this.insert(deps);
		}
	}

	private void insert(List<CecepDep> deps) {
		if (deps == null || deps.size() == 0) {
			return;
		}
		for (CecepDep cecepDep : deps) {
			int count = this.midDepMapper.selectById(cecepDep.getDepSerial());
			if(count==0){
				this.midDepMapper.insertCecep(cecepDep);
			}
			List<CecepDep> deps2 = this.midDepMapper.selectByParentId(cecepDep.getDepSerial());
			this.insert(deps2);
		}
	}
	
	/**
	 * 根据depSerial插入部门到dt_dep中
	 * 递归判断其付部门是否存在，若不存在在插入其不存在的父部门
	 * @param depSerial
	 */
	public void insert1(String depNo,String parentId){
		if(depNo==null){
			return ;
		}
		if(parentId==null){
			parentId = this.midDepMapper.selectParentId(depNo);
		}
		//在dt_dep表中根据parentId查找该部门是否存在
		Integer parentSerial = this.midDepMapper.selectById1(parentId);
		if(parentSerial==null){
			this.insert1(parentId, null);
		}else{
			this.dtDepMapper.updateDepSerial();
			Integer depSerial = this.dtDepMapper.selectMaxDepSerial();
			Map<String,Object> map = MapUtils.createMap("depNo",depNo,"parentSerial",parentSerial,"depSerial",depSerial);
			this.midDepMapper.insertById(map);
		}
	}
	
//	public Map<String,Object> analyseDep(){
//		
//		return MapUtils.createSuccessMap();
//	}

	public Map<String, Object> syncMidDep(Long depSerial, String iuCode,
			Boolean all) {
		//先将选中的部门设置到depSerial部门下
		Long serial = this.insert(iuCode, depSerial,null);
		if(all!=null&&all){
			//若级联，则递归同步iuCode的所有下级部门
			this.recusive(iuCode,serial);
			
		}
		ThreadPool.execute(new Runnable() {
			
			public void run() {
				DepCache.init(dtDepMapper);
			}
		});
		return MapUtils.createSuccessMap("msg","同步HR部门成功！");
	}
	
	/**
	 * 根据iuCode和depSerial同步HR部门
	 * @param iuCode
	 * @param depSerial
	 */
	private Long insert(String iuCode,Long depSerial,DtDep dep){
		this.dtDepMapper.updateDepSerial();
		Integer serial = this.dtDepMapper.selectMaxDepSerial();
		if(dep==null){
			dep = this.midDepMapper.selectByIuCode(MapUtils.createMap("iuCode",iuCode));
		}
		dep.setDepSerial(Long.valueOf(serial+""));
		dep.setDepParent(Integer.valueOf(depSerial+""));
		this.dtDepMapper.insert(dep);
		String [] acdepSerials = this.midDepMapper.getAcdepSerialByParentId(depSerial+"");
		if(acdepSerials!=null&&acdepSerials.length>0){
			this.acDepMapper.insertDtDev(MapUtils.createMap("depSerial",serial,"ids",acdepSerials));
		}
		
		return Long.valueOf(serial+"");
	}
	
	/**
	 * 根据iuCode和depSerial递归同步HR部门
	 * @param iuCode
	 */
	private void recusive(String iuCode,Long depSerial){
		List<DtDep> list = this.midDepMapper.selectByIuLssjdwId(MapUtils.createMap("iuLssjdwId",iuCode));
		if(list!=null&&list.size()>0){
			for(DtDep dtDep : list){
				Long serial = this.insert(dtDep.getDepNo(), depSerial,dtDep);
				this.recusive(dtDep.getDepNo(), serial);
			}
		}
		
	}

	public void updateDepOrder(String[] arr2) {
		this.dtDepMapper.updateDepOrder(MapUtils.createMap("depNo",arr2[0],"depOrder",Integer.valueOf(arr2[1])));
	}

	public void updateUserOrder(String[] arr2) {
		this.dtDepMapper.updateUserOrder(MapUtils.createMap("userNo",arr2[0],"userOrder",Integer.valueOf(arr2[1]),"depNo",arr2[2]));
	}

	public void test() {
//		String sortList = "30021135:0;30002513:1;30003359:2;30004338:3;30004093:4;30021967:5;30006085:6;30010127:7;30012132:8;30013034:9;30014104:10;30014105:11;30014106:12;30014333:13;30014342:14";
		String sortList = "10000211:0;10001550:1;10004006:2;10001432:3;10000933:4;10000999:5;10003704:6;10001009:7;10003352:8;10001181:9;10001198:10;10000071:11;10000001:12;10001606:13;10001678:14;10001731:15;10003456:16;10001937:17;10002599:18;10003109:19;10000224:20;10003449:21;10002613:22;10003662:23;10002748:24;10002754:25;10003516:26;10003526:27;10000587:28;10002606:29;10003243:30;10003528:31;10003571:32;10002951:33;10003660:34;10003840:35;10000876:36;10003724:37";
		if (sortList != null && sortList.trim().length() > 0) {
			String[] arr1 = sortList.split(";");
			if (arr1 != null && arr1.length > 0) {
				for (int i = 0; i < arr1.length; i++) {
					String[] arr2 = arr1[i].split(":");
//					String arr[] = new String[3];
//					arr[0] = arr2[0];
//					arr[1] = arr2[1];
//					arr[2] = "10003706";
					this.updateDepOrder(arr2);
					this.updateMidDepOrder(arr2);
//					this.updateMidUserOrder(arr);
//					this.updateUserOrder(arr);
				}
			}
		}
	}

	public void updateMidUserOrder(String[] arr2) {
		this.dtDepMapper.updateMidUserOrder(MapUtils.createMap("userNo",arr2[0],"userOrder",Integer.valueOf(arr2[1]),"depNo",arr2[2]));
	}

	public void updateMidDepOrder(String[] arr2) {
		this.dtDepMapper.updateMidDepOrder(MapUtils.createMap("depNo",arr2[0],"depOrder",Integer.valueOf(arr2[1])));
	}
}
