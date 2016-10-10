package com.cecep.controller.mess;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cecep.model.RegionTree;
import com.cecep.model.mess.Region;
import com.cecep.service.mess.RegionServiceI;

/**
 * 场所控制器
 * @author lilei
 * 
 */
@Controller
@RequestMapping(value = "regionController")
public class RegionController {

	private RegionServiceI regionServiceI;

	@Autowired
	public void setDeviceServiceI(RegionServiceI regionServiceI) {
		this.regionServiceI = regionServiceI;
	}

	/**
	 * 绑定消费机场所下拉框
	 * */
	@RequestMapping(value = "select.do")
	@ResponseBody
	public List<Region> select() {
		return regionServiceI.select();
	}
	
	/**
	 * 所有场所下拉框
	 * */
	@RequestMapping(value = "selectAll.do")
	@ResponseBody
	public List<RegionTree> selectAll() {
		return regionServiceI.selectAll();
	}
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping("dataList.do")
	@ResponseBody
	public Object dataList(Region query,Integer id){
		query.setDepParent(id);
		return this.regionServiceI.datalist(query);
	}

	@RequestMapping("getById.do")
	@ResponseBody
	public Map<String, Object> getById(Region query){
		return this.regionServiceI.getById(query);
	}
	
	@RequestMapping("save.do")
	@ResponseBody
	public Map<String,Object> save(Region query){
		return this.regionServiceI.save(query);
	}

	@RequestMapping("delete.do")
	@ResponseBody
	public Map<String,Object> delete(Region query){
		return this.regionServiceI.delete(query);
	}
	
	@RequestMapping("acdepType.do")
	@ResponseBody
	public List<Map<String, Object>> acdepType(){
		return this.regionServiceI.acdepType();
	}
}
