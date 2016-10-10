package com.cecep.service.impl.mess;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.mess.RegionMapper;
import com.cecep.model.RegionTree;
import com.cecep.model.mess.Region;
import com.cecep.service.mess.RegionServiceI;
import com.cecep.util.MapUtils;

@Service("regionServiceI")
public class RegionServiceImpl implements RegionServiceI {

	private RegionMapper regionMapper;

	@Autowired
	public void setDeviceDao(RegionMapper regionMapper) {
		this.regionMapper = regionMapper;
	}

	public List<Region> select() {
		List<Region> list = regionMapper.select();
		Region region = new Region();
		region.setDepName("所有区域");
		region.setDepNo("00");
		list.add(0,region);
		return list;
	}

	public Map<String, Object> datalistXf(Region query) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<Region> list = this.regionMapper.datalistXf(query);
		int total = this.regionMapper.totalXf(query);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}

	public Map<String, Object> delete(Region record) {
		int count = this.regionMapper.getChildrenCount(record);
		if(count!=0){
			return MapUtils.createFailedMap("msg","该场所存在下级场所，请先删除所有下级场所！");
		}
		this.regionMapper.delete(record.getDepSerial());
		return MapUtils.createSuccessMap("msg","删除成功！");
	}

	public Map<String, Object> save(Region record) {
		String msg = "";
		if(record.getDepSerial()==null){
			this.regionMapper.updateModuleId(record.getModuleId());
			Integer depSerial = this.regionMapper.getDepSerial(record.getModuleId());
			record.setDepSerial(depSerial);
			int depOrder = this.regionMapper.getDepOrder(record.getDepParent())+1;
			String parentDepNo = this.regionMapper.selectDepNo(record.getDepParent());
			String depNo = parentDepNo+"0".substring(0, 2-(depOrder+"").length())+depOrder;
			record.setDepNo(depNo);
			record.setDepOrder(depOrder);
			record.setSj(new Date());
			this.regionMapper.save(record);
			msg = "添加成功！";
		}else{
			this.regionMapper.update(record);
			msg = "更新成功！";
		}

//		throw new RuntimeException();
		return MapUtils.createSuccessMap("msg",msg);
	}

	public Map<String, Object> getById(Region record) {
		if(record.getDepSerial()==null){
			return MapUtils.createFailedMap();
		}
		Region  data = this.regionMapper.getById(record.getDepSerial());
		return MapUtils.createSuccessMap("data",data,"success",true);
	}

	public Object datalist(Region query) {
		if(query.getDepParent()==null){
			List<Region> list = this.regionMapper.datalist(query);
			return MapUtils.createSuccessMap("rows",list);
		}else{
			return this.regionMapper.datalist(query);
		}
//		int total = this.regionMapper.total(query);
	}

	public List<RegionTree> selectAll() {
		List<RegionTree> list = regionMapper.selectAll(new RegionTree());
		this.getRegionTree(list.get(0));
		return list;
	}

	public List<Map<String, Object>> acdepType() {
		return this.regionMapper.acdepType();
	}

	
	private void getRegionTree(RegionTree tree){
		List<RegionTree> list = this.regionMapper.selectAll(tree);
		if(list!=null&&list.size()>0){
			tree.setChildren(list);
			for (RegionTree regionTree : list) {
				this.getRegionTree(regionTree);
			}
		}
	}
}
