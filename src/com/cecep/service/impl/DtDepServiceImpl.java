package com.cecep.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.cache.DepCache;
import com.cecep.dao.DtAcDepMapper;
import com.cecep.dao.DtDepMapper;
import com.cecep.dao.DtUserMapper;
import com.cecep.model.DtDep;
import com.cecep.model.DtUser;
import com.cecep.model.kq.TreeDep;
import com.cecep.service.DtDepServiceI;
import com.cecep.util.MapUtils;
import com.cecep.util.ThreadPool;

@Service("dtDepService")
public class DtDepServiceImpl implements DtDepServiceI {
	
	private DtDepMapper dtDepMapper;
	private DtUserMapper dtUserMapper;
	private DtAcDepMapper dtAcDepMapper;
	
	@Autowired
	public void setDtAcDepMapper(DtAcDepMapper dtAcDepMapper) {
		this.dtAcDepMapper = dtAcDepMapper;
	}

	@Autowired
	public void setDtUserMapper(DtUserMapper dtUserMapper) {
		this.dtUserMapper = dtUserMapper;
	}

	@Autowired
	public void setDtDepMapper(DtDepMapper dtDepMapper) {
		this.dtDepMapper = dtDepMapper;
	}

	public List<Map<String, Object>> load(Integer depParent) {
		List<Map<String, Object>> list = this.dtDepMapper.load(depParent);
		return list;
	}

	public Object dataList(DtDep record) {
		if(record.getDepParent() == null) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<DtDep> list = this.dtDepMapper.selectByPage(record);
			Integer count = this.dtDepMapper.selectCount(record);
			map.put("rows", list);
			map.put("total",count);
			return map;
		}else {
			List<DtDep> list = this.dtDepMapper.selectByPage(record);
			return list;
		}
	}
	
	public Map<String,Object> getById(DtDep query){
		DtDep data = this.dtDepMapper.selectByPrimaryKey(query.getDepSerial());
		return MapUtils.createSuccessMap("data",data);
	}
	
	public Map<String,Object> save(DtDep query){
		String msg = "";
		if(query.getDepSerial()==null){
			this.dtDepMapper.updateDepSerial();
			Integer depSerial = this.dtDepMapper.selectMaxDepSerial();
			query.setDepSerial(Long.valueOf(depSerial+""));
			query.setDepOrder(99);
			query.setDepRule("0");
			query.setDepNo("99999999");
			this.dtDepMapper.insert(query);
			msg = "保存成功！";
		}else{
			this.dtDepMapper.updateByPrimaryKeySelective(query);
			this.dtUserMapper.updateWhenDepChange(query);
			msg = "更新成功！";
		}
		ThreadPool.execute(new Runnable() {
			
			public void run() {
				DepCache.init(dtDepMapper);
			}
		});
		return MapUtils.createSuccessMap("msg",msg);
	}

	/**
	 * 
	 * @param depParent
	 * @return
	 */
	public List<Map<String, Object>> loadByPrvilege(HttpServletRequest request,Integer depParent, DtUser currUser) {
		String p = request.getParameter("personal");
		Integer personal = null;
		if(p!=null){
			personal = Integer.valueOf(p);
		}
		Map<String,Integer> map = new HashMap<String, Integer>();
		Integer depSerial = null;
		if(personal==null||personal!=0){
			depSerial = currUser.getUserDep();
			Integer level2DepSerial = this.dtDepMapper.getlevel2Serial(depSerial);
			if(level2DepSerial!=null){
				depSerial=level2DepSerial;
			}
			map.put("depSerial", depSerial);
		}
		map.put("depParent", depParent);
		List<Map<String, Object>> list = this.dtDepMapper.loadByPrivilege(map);
		return list;
	}
	
	public List<Map<String, Object>> load(DtDep record) {
		List<Map<String, Object>> list = this.dtDepMapper.load2(record);
		return list;
	}

	public void getChildrenDepSerial(Long depSerial,Set<Long> list) {
		if(depSerial==null){
			return ;
		}
		list.add(depSerial);
		Set<Long> depSerials = this.dtDepMapper.getChildrenDepSerial(depSerial);
		if(depSerials!=null&&depSerials.size()>0){
			for(Long depS : depSerials){
				this.getChildrenDepSerial(depS,list);
			}
		}
	}

	public String getRootDepSerial(String depNo) {
		return this.dtDepMapper.getRootDepSerial(MapUtils.createMap("depNo",depNo));
	}

	/**
	 * 还原dt_dep表及其他相关表
	 * @return
	 */
	public Map<String,Object> clearDtDDep(){
		this.dtDepMapper.initDepSerial();
		this.dtDepMapper.clearDtDepAcdep();
		this.dtDepMapper.clearDtDep();
		this.dtDepMapper.insertRootDep();
		return MapUtils.createSuccessMap();
	}
	
	/** 删除该部门及其子部门没有员工的部门*/
	public Map<String,Object> deleteNoUserDep(){
		List<Long> depSerials = this.dtDepMapper.selectThreeLevelDep();
		for(Long depSerial : depSerials){
			Set<Long> set = DepCache.getChildren(depSerial);
			Map<String,Object> map = MapUtils.createMap("set",set);
			int count = this.dtDepMapper.selectUsersByDeps(map);
			if(count==0){
				this.dtDepMapper.deleteDeps(map);
				this.dtAcDepMapper.deleteAcdepAndDep1(map);
			}
		}
		return MapUtils.createSuccessMap();
	}

	public Map<String, Object> dtDepDelete(Long depSerial) {
		Set<Long> depSerials = DepCache.getChildren(depSerial);
		Map<String,Object> map = MapUtils.createMap("set",depSerials);
		Integer count = this.dtUserMapper.selectChildrenCount(map);
		if(count!=0){
			return MapUtils.createFailedMap("msg","该部门或其子部门下存在员工，无法删除！");
		}
		this.dtDepMapper.deleteDeps(map);
		map.put("depSerials", depSerials);
		this.dtAcDepMapper.deleteAcdepAndDep1(map);
		return MapUtils.createSuccessMap("msg","删除部门及其子部门成功！");
	}
	
	public List<TreeDep> getAll(){
		List<TreeDep> list = this.dtDepMapper.getChildren1(new TreeDep(0));
		this.getAll(list.get(0));
		return list;
	}
	
	private void getAll(TreeDep treeDep){
		if(treeDep!=null){
			List<TreeDep> list = this.dtDepMapper.getChildren1(treeDep);
			if(list!=null&&list.size()>0){
				treeDep.setChildren(list);
				for (TreeDep treeDep2 : list) {
					this.getAll(treeDep2);
				}
			}
		}
	}
}
