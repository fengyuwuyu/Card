package com.cecep.controller.mess;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.model.DtUser;
import com.cecep.model.XfTime;
import com.cecep.model.mess.MessQuery;
import com.cecep.model.mess.Region;
import com.cecep.service.DtDepServiceI;
import com.cecep.service.XfTimeServiceI;
import com.cecep.service.mess.MessConsumeServiceI;
import com.cecep.service.mess.RegionServiceI;

/**
 * 打卡记录查询
 * 
 * @author lilei
 * 
 */
@Controller
@RequestMapping(value = "messConsumeController")
@SessionAttributes(value = "currUser")
public class MessConsumeController {

	private MessConsumeServiceI messConsumeServiceI;
	private DtDepServiceI depServiceI;
	private RegionServiceI regionServiceI;
	private XfTimeServiceI xfTimeService;

	@Autowired
	public void setDeviceServiceI(RegionServiceI regionServiceI) {
		this.regionServiceI = regionServiceI;
	}

	@Autowired
	public void setMessConsumeServiceI(MessConsumeServiceI messConsumeServiceI) {
		this.messConsumeServiceI = messConsumeServiceI;
	}

	@Autowired
	public void setDepServiceI(DtDepServiceI depServiceI) {
		this.depServiceI = depServiceI;
	}
	
	@Autowired
	public void setXfTimeService(XfTimeServiceI xfTimeService) {
		this.xfTimeService = xfTimeService;
	}

	/**
	 * 
	 * */
	@RequestMapping(value = "dataList.do")
	@ResponseBody
	public Map<String, Object> dataList(@ModelAttribute("currUser") DtUser currUser, MessQuery query,
			HttpServletRequest request, HttpServletResponse response) {
		return this.messConsumeServiceI.dataList(query,currUser);
	}

	/**
	 * 根据权限查询部门
	 * */
	@RequestMapping(value = "loadDep.do")
	@ResponseBody
	public List<Map<String, Object>> loadDep(@ModelAttribute("currUser") DtUser currUser, Integer id,
			HttpServletRequest request, HttpServletResponse response) {
		return this.depServiceI.loadByPrvilege(request,id, currUser);
	}
	
	/**
	 * 根据权限查询部门
	 * */
	@RequestMapping(value = "loadAcdep.do")
	@ResponseBody
	public List<Map<String,Object>> loadAcdep(){
		return this.messConsumeServiceI.loadAcdep();
	}

	/**
	 * 统计食堂消费
	 * */
	@RequestMapping(value = "statistics.do")
	@ResponseBody
	public Map<String, Object> statistics(@ModelAttribute("currUser") DtUser currUser, MessQuery query,
			HttpServletRequest request, HttpServletResponse response) {
		return this.messConsumeServiceI.statistics(query,currUser);
	}
	
	/**
	 * 消费时间列表
	 * */
	@RequestMapping(value = "messTimeList.do")
	@ResponseBody
	public Map<String, Object> messTimeManageList(XfTime record,HttpServletRequest request, HttpServletResponse response) {
		return this.xfTimeService.selectByPage(record);
	}
	
	/**
	 * 返回绑定了消费机的场所
	 * */
	@RequestMapping(value = "regionList.do")
	@ResponseBody
	public Map<String, Object> regionList(Region query ,HttpServletRequest request, HttpServletResponse response) {
		return this.regionServiceI.datalistXf(query);
	}
	
	/**
	 * 部门可在食堂消费的员工数量
	 * */
	@RequestMapping(value = "depNum.do")
	@ResponseBody
	public Map<String, Object> depNum(@ModelAttribute("currUser") DtUser currUser,MessQuery query ,HttpServletRequest request, HttpServletResponse response) {
		return this.messConsumeServiceI.depNum(currUser,query);
		
	}
	
	@RequestMapping(value = "timeLoad.do")
	@ResponseBody
	public List<Map<String,Object>> loadTime(XfTime record,HttpServletRequest request,HttpServletResponse response) {
		return this.xfTimeService.load(record);					
	}
	
	@RequestMapping(value = "saveDevTime.do")
	@ResponseBody
	public Map<String,Object> saveDevTime(@ModelAttribute("currUser")DtUser currUser , String[] addTimes,Integer depSerial,HttpServletRequest request,HttpServletResponse response) {
		return this.xfTimeService.saveDevTime(addTimes,depSerial,currUser.getUserLname());					
	}
	
//	@RequestMapping(value = "getById.do")
//	@ResponseBody
//	public Map<String, Object> getById(Region record) {
//		Map<String, Object> map = this.regionServiceI.getById(record);
//		return map;
//	}
//
//	@RequestMapping(value = "save.do")
//	@ResponseBody
//	public Map<String, Object> save(Region record) {
//		if(record.getDepSerial()==null||"".equals(record.getDepSerial())){
//			return this.regionServiceI.save(record);
//		}else{
//			return this.regionServiceI.update(record);
//		}
//	}
//
//	@RequestMapping(value = "delete.do")
//	@ResponseBody
//	public Map<String, Object> delete(Region record) {
//		return this.regionServiceI.delete(record);
//	}
//	

	/**
	 * 生成测试数据
	 */
	/*@RequestMapping(value = "insert.do")
	@ResponseBody
	public void insert(){
		List<Region> regions = this.regionServiceI.select();
		List<Device> devices = this.deviceServiceI.select();
		List<Long> dtDeps = this.depMapper.getAll();
		List<Map<String, Object>> list = this.xfTimeMapper.load(null);
		DtUser dtUser = new DtUser();
		dtUser.setRows(30);
		dtUser.setStart(30);
		dtUser.setPage(1);
		List<DtUser> dtUsers = this.userMapper.selectByPage(dtUser);
		for(int i=0;i<100000;i++){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("depSerial", dtDeps.get(getRandom(dtDeps.size())));
			map.put("Dev_serial", devices.get(getRandom(devices.size())).getBh());
			map.put("Acdep_serial", regions.get(getRandom(regions.size())).getDepNo());
			map.put("time_no", list.get(getRandom(list.size())).get("bh"));
			map.put("Jl_sj", getDate());
			map.put("User_serial", dtUsers.get(getRandom(dtUsers.size())).getUserSerial());
			map.put("more_money", 0.00);
			map.put("rate_money", 0.00);
			map.put("discount_rate", 0);
			map.put("each_unit", 0.00);
			map.put("mould", 0);
			map.put("type", 0);
			this.consumeMapper.insert(map);
		}
		
	}

	private Date getDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, KqStatisticsUtil.getRandom(20));
		return calendar.getTime();
	}

	private int getRandom(int size) {
		if(size==0){
			return 0;
		}
		return KqStatisticsUtil.getRandom(size);
	}

	private RegionServiceI regionServiceI;
	private DtDepMapper depMapper;
	private DeviceServiceI deviceServiceI;
	private XfTimeMapper xfTimeMapper;
	private DtUserMapper userMapper ;
	private MessConsumeMapper consumeMapper;
	
	@Autowired
	public void setConsumeMapper(MessConsumeMapper consumeMapper) {
		this.consumeMapper = consumeMapper;
	}

	@Autowired
	public void setUserMapper(DtUserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Autowired
	public void setXfTimeMapper(XfTimeMapper xfTimeMapper) {
		this.xfTimeMapper = xfTimeMapper;
	}

	@Autowired
	public void setDepMapper(DtDepMapper depMapper) {
		this.depMapper = depMapper;
	}

	@Autowired
	public void setDeviceServiceI(RegionServiceI regionServiceI) {
		this.regionServiceI = regionServiceI;
	}


	@Autowired
	public void setDeviceServiceI(DeviceServiceI deviceServiceI) {
		this.deviceServiceI = deviceServiceI;
	}
*/
}
