package com.cecep.controller.sys;






import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.controller.BaseController;
import com.cecep.model.DtDep;
import com.cecep.model.DtUser;
import com.cecep.model.MidDep;
import com.cecep.model.MidUser;
import com.cecep.model.SysMenu;
import com.cecep.model.SysRole;
import com.cecep.model.TreeNode;
import com.cecep.model.TtLizhi;
import com.cecep.model.TtNation;
import com.cecep.model.TtXueli;
import com.cecep.model.XfAcTime;
import com.cecep.model.kq.TreeDep;
import com.cecep.service.DtDepServiceI;
import com.cecep.service.DtUserServiceI;
import com.cecep.service.MidDepServiceI;
import com.cecep.service.MidUserServiceI;
import com.cecep.service.SysMenuServiceI;
import com.cecep.service.SysRoleServiceI;
import com.cecep.service.TtLizhiServiceI;
import com.cecep.service.TtNationServiceI;
import com.cecep.service.TtXueliServiceI;
import com.cecep.util.MapUtils;

@Controller
@RequestMapping(value = "systemController")
@SessionAttributes(value = "currUser")
public class SystemController extends BaseController {
	
	private SysMenuServiceI sysMenuService;	
	private SysRoleServiceI sysRoleService;	
	private DtUserServiceI dtUserServiceI;
	private DtDepServiceI dtDepServiceI;
	private TtLizhiServiceI ttLizhiServiceI;
	private TtNationServiceI ttNationServiceI;
	private TtXueliServiceI ttXueliServiceI;
	private MidUserServiceI midUserServiceI;
	private MidDepServiceI midDepServiceI;
	
	
	@Autowired
	public void setSysMenuService(SysMenuServiceI sysMenuService) {
		this.sysMenuService = sysMenuService;
	}
	
	@Autowired
	public void setSysRoleService(SysRoleServiceI sysRoleService) {
		this.sysRoleService = sysRoleService;
	}
	
	@Autowired
	public void setDtUserServiceI(DtUserServiceI dtUserServiceI) {
		this.dtUserServiceI = dtUserServiceI;
	}

	@Autowired
	public void setDtDepServiceI(DtDepServiceI dtDepServiceI) {
		this.dtDepServiceI = dtDepServiceI;
	}

	@Autowired
	public void setTtLizhiServiceI(TtLizhiServiceI ttLizhiServiceI) {
		this.ttLizhiServiceI = ttLizhiServiceI;
	}
	
	@Autowired
	public void setTtNationServiceI(TtNationServiceI ttNationServiceI) {
		this.ttNationServiceI = ttNationServiceI;
	}
	
	@Autowired
	public void setTtXueliServiceI(TtXueliServiceI ttXueliServiceI) {
		this.ttXueliServiceI = ttXueliServiceI;
	}

	@Autowired
	public void setMidUserServiceI(MidUserServiceI midUserServiceI) {
		this.midUserServiceI = midUserServiceI;
	}

	@Autowired
	public void setMidDepServiceI(MidDepServiceI midDepServiceI) {
		this.midDepServiceI = midDepServiceI;
	}

	/**
	 * 菜单--分页查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "sysMenuDataList.do")
	@ResponseBody
	public Map<String, Object> sysMenuDataList(SysMenu record,HttpServletRequest request,HttpServletResponse response,ModelMap model) {
		Map<String,Object> map = this.sysMenuService.dataList(record);
		return map;
	}
	
	/**
	 * 菜单--主键查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-06
	 * */
	@RequestMapping(value = "sysMenuGetById.do")
	@ResponseBody
	public Map<String, Object> sysMenuGetById(SysMenu record,HttpServletRequest request,HttpSession session,HttpServletResponse response,ModelMap model) {
		Map<String,Object> map = this.sysMenuService.getById(record);
		return map;
	}
	
	/**
	 * 菜单--保存
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "sysMenuSave.do")
	@ResponseBody
	public Map<String, Object> sysMenuSave(SysMenu record,HttpServletRequest request,HttpSession session,HttpServletResponse response,ModelMap model) {
		Map<String, Object> map = this.sysMenuService.save(record);
		return map;
	}
	
	/**
	 * 菜单--删除
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "sysMenuDelete.do")
	@ResponseBody
	public Map<String, Object> sysMenuDelete(SysMenu record,HttpServletRequest request,HttpSession session,HttpServletResponse response,ModelMap model) {
		Map<String, Object> map = this.sysMenuService.delete(record);
		return map;
	}
	
	/**
	 * 角色--分页查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "sysRoleDataList.do")
	@ResponseBody
	public Map<String, Object> sysRoleDataList(SysRole record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.sysRoleService.dataList(record);
		return map;
	}
	
	/**
	 * 角色--主键查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "sysRoleGetById.do")
	@ResponseBody
	public Map<String, Object> sysRoleGetById(SysRole record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.sysRoleService.getById(record);
		return map;
	}
	
	/**
	 * 角色--保存
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "sysRoleSave.do")
	@ResponseBody
	public Map<String, Object> sysRoleSave(SysRole record,Integer[] menuIds,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = this.sysRoleService.save(record,menuIds);
		return map;
	}
	
	/**
	 * 角色--删除
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "sysRoleDelete.do")
	@ResponseBody
	public Map<String, Object> sysRoleDelete(SysRole record,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = this.sysRoleService.delete(record);	
		return map;
	}
	
	/**
	 * 角色--菜单树查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "getMenuTree.do")
	@ResponseBody
	public List<TreeNode> getMenuTree(Integer id,HttpServletRequest request,HttpServletResponse response) {
		List<TreeNode> list = this.sysRoleService.getMenuTree(id);
		return list;
	}
	
	/**
	 * 角色--下拉加载
	 * @return List
	 * @author BYP
	 * @date 2016-01-25
	 * */
	@RequestMapping(value = "sysRoleLoad.do")
	@ResponseBody
	public List<Map<String,Object>> load(SysRole record,HttpServletRequest request,HttpServletResponse response) {
		List<Map<String,Object>> list = this.sysRoleService.load(record);
		return list;	
	}
	
	/**
	 * 员工--分页查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "dtUserDataList.do")
	@ResponseBody
	public Map<String, Object> dtUserDataList(DtUser record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.dtUserServiceI.dataList(record);
		return map;
	}
	
	/**
	 * 员工--主键查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "dtUserGetById.do")
	@ResponseBody
	public Map<String, Object> dtUserGetById(DtUser record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.dtUserServiceI.getById(record);
		return map;
	}
	
	/**
	 * 员工--账户时段查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "selectXfAcTime.do")
	@ResponseBody
	public List<XfAcTime> selectXfAcTime(DtUser record,HttpServletRequest request,HttpServletResponse response) {
		List<XfAcTime> list = this.dtUserServiceI.selectXfAcTime(record);
		return list;
	}
	
	/**
	 * 员工--门禁树查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "getDoorTree.do")
	@ResponseBody
	public List<TreeNode> getDoorTree(Integer id,HttpServletRequest request,HttpServletResponse response) {
		List<TreeNode> list = this.dtUserServiceI.getDoorTree(id);
		return list;
	}
	
	/**
	 * 员工--门禁查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "selectStDoorReal.do")
	@ResponseBody
	public List<Map<String,Object>> selectStDoorReal(DtUser record,HttpServletRequest request,HttpServletResponse response) {
		List<Map<String,Object>> list = this.dtUserServiceI.selectStDoorReal(record);
		return list;
	}
	
	/**
	 * 员工--保存
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "dtUserSave.do")
	@ResponseBody
	public Map<String, Object> dtUserSave(@ModelAttribute("currUser") DtUser currUser,DtUser record,String[] doorBhs,HttpServletRequest request,HttpServletResponse response) {
		//用户IP
		record.setIp(request.getRemoteAddr());
		//用户姓名
		record.setGlyNo(currUser.getUserLname());
		Map<String,Object> map = this.dtUserServiceI.save(record,doorBhs);
		return map;
	}
	
	@RequestMapping(value = "dtUserDelete.do")
	@ResponseBody
	public Map<String, Object> dtUserDelete(DtUser record) {
		return this.dtUserServiceI.delete(record);
	}
	
	/**
	 * 员工--密码修改
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "editPwd.do")
	@ResponseBody
	public Map<String, Object> editPwd(DtUser record,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = this.dtUserServiceI.editPwd(record);
		return map;
	}
	
	/**
	 * 部门--分页查询
	 * @return Map
	 * @author BYP
	 * @date 2016-02-23
	 * */
	@RequestMapping(value = "dtDepDataList.do")
	@ResponseBody
	public Object dtDepDataList(Integer id,DtDep record,HttpServletRequest request,HttpServletResponse response) {
		record.setDepParent(id);
		Object o = this.dtDepServiceI.dataList(record);
		return o;
	}
	
	@RequestMapping("getById.do")
	@ResponseBody
	public Map<String,Object> getById(DtDep query){
		return this.dtDepServiceI.getById(query);
	}
	
	@RequestMapping("save.do")
	@ResponseBody
	public Map<String,Object> save(DtDep query){
		return this.dtDepServiceI.save(query);
	}
	
	/**
	 * 部门--下拉查询
	 * @return List
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "dtDepLoad.do")
	@ResponseBody
	public List<Map<String,Object>> dtDepLoad(Integer id,HttpServletRequest request,HttpServletResponse response) {
		List<Map<String,Object>> list = this.dtDepServiceI.load(id);
		return list;					
	}
	
	/**
	 * 部门--下拉查询二
	 * @return List
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "dtDepLoad2.do")
	@ResponseBody
	public List<Map<String,Object>> dtDepLoad2(DtDep record,HttpServletRequest request,HttpServletResponse response) {
		List<Map<String,Object>> list = this.dtDepServiceI.load(record);
		return list;					
	}
	
	/**
	 * 状态--下拉查询
	 * @return List
	 * @author BYP
	 * @date 2016-01-25
	 * */
	@RequestMapping(value = "ttLizhiLoad.do")
	@ResponseBody
	public List<Map<String,Object>> ttLizhiLoad(TtLizhi record,HttpServletRequest request,HttpServletResponse response) {
		List<Map<String,Object>> list = this.ttLizhiServiceI.load(record);
		return list;	
	}
	
	/**
	 * 民族--下拉查询
	 * @return List
	 * @author BYP
	 * @date 2016-01-25
	 * */
	@RequestMapping(value = "ttNationLoad.do")
	@ResponseBody
	public List<Map<String,Object>> ttNationLoad(TtNation record,HttpServletRequest request,HttpServletResponse response) {
		List<Map<String,Object>> list = this.ttNationServiceI.load(record);
		return list;	
	}
	
	/**
	 * 学历--下拉查询
	 * @return List
	 * @author BYP
	 * @date 2016-01-25
	 * */
	@RequestMapping(value = "ttXueliLoad.do")
	@ResponseBody
	public List<Map<String,Object>> ttXueliLoad(TtXueli record,HttpServletRequest request,HttpServletResponse response) {
		List<Map<String,Object>> list = this.ttXueliServiceI.load(record);
		return list;	
	}
	
	/**
	 * 主数据用户--检查同步数据条数(轮训方式)
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "midUserIsSynchronized.do")
	@ResponseBody
	public Map<String, Object> midUserIsSynchronized(MidUser record, HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = this.midUserServiceI.selectIsSynchronized(record);
		return map;	
	}
	
	/**
	 * 主数据用户--同步数据
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "midUserSynchronize.do")
	@ResponseBody
	public Map<String, Object> midUserSynchronize() {
		return this.midUserServiceI.midUserSynchronize();
	}
	
	/**
	 * 主数据用户--同步数据
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "midUserSynchronizeCount.do")
	@ResponseBody
	public Map<String, Object> midUserSynchronizeCount(@ModelAttribute("currUser") DtUser currUser) {
		if(this.checkUserManager(currUser)){
			return this.midUserServiceI.midUserSynchronizeCount();
		}
		return MapUtils.createSuccessMap("count",0);
	}
	
	private boolean checkUserManager(DtUser currUser) {
		return this.dtUserServiceI.checkUserManager(currUser,  "/dtUser.jsp");
	}

	/**
	 * 主数据部门--检查同步数据条数(轮训方式)
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "midDepIsSynchronized.do")
	@ResponseBody
	public Map<String, Object> midDepIsSynchronized(MidDep record, HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = this.midDepServiceI.selectIsSynchronized(record);
		return map;	
	}
	
	/**
	 * 主数据部门--同步数据
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "midDepSynchronize.do")
	@ResponseBody
	public Map<String, Object> midDepSynchronize(String[] depNos, HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = this.midDepServiceI.synchronize(depNos);
		return map;	
	}
	
	/**
	 * 主数据部门--下拉查询
	 * @return Map
	 * @author BYP
	 * @date 2016-01-20
	 * */
	@RequestMapping(value = "midDepLoad.do")
	@ResponseBody
	public List<Map<String,Object>> midDepLoad(String id,MidDep record, HttpServletRequest request,HttpServletResponse response) {
		List<Map<String,Object>> list = this.midDepServiceI.load(id);
		return list;	
	}
	
	/**
	 * 判断是否存在未同步的部门，若存在则返回false
	 * @return
	 */
	@RequestMapping(value = "midDepCount.do")
	@ResponseBody
	public Map<String, Object> checkMidDepCountAndSameUser() {
		return this.midDepServiceI.midDepCount();	
	}
	
	@RequestMapping(value = "synchronizeRepeatDtUser.do")
	@ResponseBody
	public Map<String,Object> synchronizeRepeatDtUser(String userSerial){
		return this.midUserServiceI.synchronizeRepeatDtUser(userSerial);
	}
	
	@RequestMapping(value = "acDepLoad.do")
	@ResponseBody
	public List<Map<String,Object>> acDepLoad() {
		return this.midDepServiceI.acDepLoad();
	}
	
	/**
	 * 为部门关联场所
	 * @return
	 */
	@RequestMapping(value = "saveAcdepAndDep.do")
	@ResponseBody
	public Map<String,Object> saveAcdepAndDep(String[] ids,String depSerial) {
		return this.midDepServiceI.saveAcdepAndDep(ids,depSerial);
	}
	
	/**
	 * 为部门关联场所(包括下级部门)
	 * @return
	 */
	@RequestMapping(value = "saveAcdepAndDep1.do")
	@ResponseBody
	public Map<String,Object> saveAcdepAndDep1(String[] ids,String depSerial) {
		return this.midDepServiceI.saveAcdepAndDep1(ids,depSerial);
	}
	
	@RequestMapping(value = "selectAcdepAndDep.do")
	@ResponseBody
	public Map<String,Object> selectAcdepAndDep(String depSerial) {
		return this.midDepServiceI.selectAcdepAndDep(depSerial);
	}
	
	@RequestMapping(value = "selectAcType.do")
	@ResponseBody
	public List<Map<String, Object>> selectAcType() {
		return this.dtUserServiceI.selectAcType();
	}
	
	@RequestMapping("synchronizeUsers.do")
	@ResponseBody
	public Map<String,Object> synchronizeUsers(@RequestBody List<DtUser> list){
		return this.midUserServiceI.synchronizeUsers(list);
	}
	
	@RequestMapping("syncMidDep.do")
	@ResponseBody
	public Map<String,Object> syncMidDep(Long depSerial,String iuCode,Boolean all){
		return this.midDepServiceI.syncMidDep(depSerial,iuCode,all);
	}
	
	@RequestMapping("dtDepDelete.do")
	@ResponseBody
	public Map<String,Object> dtDepDelete(Long depSerial){
		return this.dtDepServiceI.dtDepDelete(depSerial);
	}
	
	@RequestMapping("dtDepGetAll.do")
	@ResponseBody
	public List<TreeDep> dtDepGetAll(){
		return this.dtDepServiceI.getAll();
	}
	
}
